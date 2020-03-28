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
                <form class="layui-form" id="authorForm">
                    <div class="layui-form-item">
                        <label for="authorName" class="layui-form-label">
                            <span class="x-red">*</span>诗人名
                        </label>
                        <div class="layui-input-inline">
                            <input type="text" id="authorName" name="authorName" required="" lay-verify="required" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label for="sex" class="layui-form-label">
                            <span class="x-red">*</span>性别
                        </label>
                        <div class="layui-input-inline">
                            <select id="sex" name="sex" lay-verify="required">
                                <option value="男">请选择</option>
                                <option value="男">男</option>
                                <option value="女">女</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label for="dynasty" class="layui-form-label">
                            <span class="x-red">*</span>朝代
                        </label>
                        <div class="layui-input-inline">
                            <input type="text" id="dynasty" name="dynasty" required="" lay-verify="required" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label for="description" class="layui-form-label">
                            简介
                        </label>
                        <div class="layui-input-inline">
                            <input type="text" id="description" name="description" required="" autocomplete="off" class="layui-input">
                        </div>
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
                //监听提交
                form.on('submit(add)',
                    function(data) {
                        //发异步，把数据提交给
                        const authorForm = $('#authorForm').serialize();
                        $.ajax({
                            type:"post",
                            url:"addAuthor",
                            data:authorForm,
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