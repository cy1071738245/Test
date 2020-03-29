<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="x-admin-sm">
    <head>
        <meta charset="UTF-8">
        <title>诗词网后台管理系统</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="stylesheet" href="./css/font.css">
        <link rel="stylesheet" href="./css/xadmin.css">
        <script src="front/js/jquery.js"></script>
        <script src="./lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="./js/xadmin.js"></script>
        <!--[if lt IE 9]>
        <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
        <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <div class="x-nav">
          <span class="layui-breadcrumb">
            <a href="">
                <cite>诗词管理</cite>
            </a>
          </span>
          <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
            <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
        </div>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-body ">
                            <form class="layui-form layui-col-space5">
                                <div class="layui-inline layui-show-xs-block">
                                    <input type="text" name="keyword" placeholder="请输入搜索关键词" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <button class="layui-btn"  lay-submit="" lay-filter="sreach" onclick="search()"><i class="layui-icon">&#xe615;</i></button>
                                </div>
                            </form>
                        </div>
                        <div class="layui-card-header">
                            <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
                            <button class="layui-btn" onclick="xadmin.open('添加诗词','admin-article-add',600,400)"><i class="layui-icon"></i>添加</button>
                        </div>
                        <div class="layui-card-body layui-table-body layui-table-main">
                            <table class="layui-table layui-form" id="poetryTable">
                                <thead>
                                <tr>
                                    <th>
                                        <input type="checkbox" lay-filter="checkall" name="" lay-skin="primary">
                                    </th>
                                    <th>ID</th>
                                    <th>文章标题</th>
                                    <th>作者</th>
                                    <th>赏析对象</th>
                                    <th>内容</th>
                                    <th>更新时间</th>
                                    <th>操作</th></tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${articleResultMap.data}" var="articleInfo">
                                    <tr>
                                        <td>
                                            <input type="checkbox" name="articleId" value="${articleInfo.articleId}" lay-skin="primary">
                                        </td>
                                        <td>${articleInfo.articleId}</td>
                                        <td>${articleInfo.articleName}</td>
                                        <td>${articleInfo.userName}</td>
                                        <td>${articleInfo.poetryName}</td>
                                        <td>${articleInfo.content}</td>
                                        <td>${articleInfo.updateTime}</td>
                                        <td>
                                            <a title="编辑"  onclick="xadmin.open('编辑','admin-article-edit?articleId=' + ${articleInfo.articleId},600,400)" href="javascript:">
                                                <i class="layui-icon">&#xe642;</i>
                                            </a>
                                            <a title="删除" onclick="articleDel(this,${articleInfo.articleId})" href="javascript:">
                                                <i class="layui-icon">&#xe640;</i>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="layui-card-body ">
                            <div class="page">
                                <div>
                                    <c:if test="${articleResultMap.prePage != null}">
                                        <a class="prev" href="adminArticleList?page=${articleResultMap.prePage}">&lt;&lt;</a>
                                        <a class="num" href="adminArticleList?page=${articleResultMap.prePage}">
                                                ${articleResultMap.prePage}
                                        </a>
                                    </c:if>
                                    <span class="current">${articleResultMap.prePage + 1}</span>
                                    <c:if test="${articleResultMap.nextPage != null}">
                                        <a class="num" href="adminArticleList?page=${articleResultMap.nextPage}">
                                                ${articleResultMap.nextPage}
                                        </a>
                                        <a class="next" href="adminArticleList?page=${articleResultMap.nextPage}">&gt;&gt;</a>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div> 
    </body>
    <script>
      layui.use(['laydate','form'], function(){
        var laydate = layui.laydate;
        var form = layui.form;
        // 监听全选
        form.on('checkbox(checkall)', function(data){

          if(data.elem.checked){
            $('tbody input').prop('checked',true);
          }else{
            $('tbody input').prop('checked',false);
          }
          form.render('checkbox');
        });
        //执行一个laydate实例
        laydate.render({
          elem: '#start' //指定元素
        });
        //执行一个laydate实例
        laydate.render({
          elem: '#end' //指定元素
        });
      });

      /*删除*/
      function articleDel(obj,articleId){
          layer.confirm('确认要删除吗？',function(index){
              //发异步删除数据
              $.ajax({
                  type:"delete",
                  url:"deleteArticle",
                  data:{articleId:articleId},
                  dataType:"text",
                  success: function (result) {
                      if (result === "success") {
                          $(obj).parents("tr").remove();
                          layer.msg('已删除!',{icon:1,time:1000});
                      } else {
                          layer.alert("删除失败");
                      }
                  }
              });
          });
      }

      function delAll (argument) {
        var ids = [];
        // 获取选中的id 
        $('tbody input').each(function(index, el) {
            if($(this).prop('checked')){
               ids.push($(this).val())
            }
        });
        layer.confirm('确认要删除吗？'+ids.toString(),function(index){
            //捉到所有被选中的，发异步进行删除
            $.ajax({
                type:"delete",
                url:"batchDeleteArticle",
                data:{articleIds:ids},
                traditional:true,
                dataType:"text",
                success: function (result) {
                    if (result === "success") {
                        layer.msg('删除成功', {icon: 1});
                        $(".layui-form-checked").not('.header').parents('tr').remove();
                    } else {
                        layer.alert("删除失败");
                    }
                }
            });
        });
      }
      
      function search() {
          const keyword = $("[name=keyword]").val();
          $.ajax({
              type:"get",
              url: "adminArticleList?page=1&keyword=" + keyword,
          })
      }
    </script>
</html>