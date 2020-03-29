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
        <script type="text/javascript" src="./lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="./js/xadmin.js"></script>
        <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
        <!--[if lt IE 9]>
            <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
            <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <div>
        <div class="layui-fluid">
            <div class="layui-row">
                <form class="layui-form" id="poetryForm">
                    <div class="layui-form-item">
                        <label for="poetryName" class="layui-form-label">
                            <span class="x-red">*</span>诗词名
                        </label>
                        <div class="layui-input-inline">
                            <input type="text" id="poetryName" name="poetryName" required="" lay-verify="poetryName" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label for="authorId" class="layui-form-label">
                            <span class="x-red">*</span>作者
                        </label>
                        <div class="layui-input-inline">
                            <select id="authorId" name="authorId" lay-verify="authorId">
                                <option value="0">请选择</option>
                                <c:forEach items="${authorInfoMap}" var="dynastyMap">
                                    <optgroup label="${dynastyMap.key}">
                                        <c:forEach items="${dynastyMap.value}" var="authorInfo">
                                            <option value="${authorInfo.authorId}">${authorInfo.authorName}</option>
                                        </c:forEach>
                                    </optgroup>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label for="content" class="layui-form-label">
                            <span class="x-red">*</span>内容
                        </label>
                        <div class="layui-input-inline">
                            <input type="text" id="content" name="content" required="" lay-verify="content" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label for="uploadImg" class="layui-form-label">
                            <span class="x-red"></span>上传图片
                        </label>
                        <div class="layui-upload">
                            <button type="button" class="layui-btn" id="uploadImg">上传</button>
                            <div class="layui-upload-list" id="show"></div>
                        </div>
                        <input type="hidden" id="imageUrl" name="imageUrl" required="" class="layui-input">
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label"></label>
                        <button class="layui-btn" lay-filter="add" lay-submit="">添加</button>
                    </div>
                </form>
            </div>
        </div>
        </div>
    </body>
    <script>
        layui.use(['form', 'layer','jquery','upload'],
            function() {
                $ = layui.jquery;
                var form = layui.form,
                    layer = layui.layer;
                //自定义验证规则
                form.verify({
                    poetryName: function(value) {
                        if (value.length === 0) {
                            return '诗词名必填项';
                        }
                    },
                    authorId: function(value) {
                        if (value === "0") {
                            return '作者必选项';
                        }
                    },
                    content: function (value) {
                        if (value.length === 0) {
                            return '内容必填项';
                        }
                    }
                });
                layui.upload.render({
                    elem: '#uploadImg'
                    ,url: 'uploadImage' //改成您自己的上传接口
                    ,multiple: false
                    ,before: function(obj){
                        //预读本地文件示例，不支持ie8
                        obj.preview(function(index, file, result){
                            $('#show').append('<label for="uploadImg" class="layui-form-label"><span class="x-red"></span></label>')
                                    .append('<img style="width:70px;height:70px;" src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img">')
                        });
                    }
                    ,done: function(res){
                        //上传完毕
                        $('#imageUrl').val(res.src);
                        layer.alert("上传成功")
                    }
                });
                //监听提交
                form.on('submit(add)',
                    function(data) {
                        //发异步，把数据提交给
                        const poetryForm = $('#poetryForm').serialize();
                        $.ajax({
                            type:"post",
                            url:"addPoetry",
                            data:poetryForm,
                            dataType:"text",
                            success: function (result) {
                                if (result === "success") {
                                    layer.alert("添加成功", {
                                        icon: 6
                                    }, function() {
                                        //关闭当前frame
                                        xadmin.close();
                                        //可以对父窗口进行刷新
                                        xadmin.father_reload();
                                    });
                                } else {
                                    layer.alert("添加失败");
                                }
                            }
                        });
                        return false;
                    });
            });
    </script>
</html>