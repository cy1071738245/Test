<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                        <label for="author" class="layui-form-label">
                            <span class="x-red">*</span>作者
                        </label>
                        <div class="layui-input-inline">
                            <input type="text" id="authorId" name="authorId" required="" lay-verify="author" autocomplete="off" class="layui-input">
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
                        <label class="layui-form-label"></label>
                        <button class="layui-btn" lay-filter="add" lay-submit="">增加</button>
                    </div>
                </form>
            </div>
        </div>
        </div>
    </body>
    <script>
        layui.use(['form', 'layer','jquery'],
            function() {
                $ = layui.jquery;
                var form = layui.form,
                    layer = layui.layer;
                //自定义验证规则
                form.verify({
                    poetryName: function(value) {
                        if (value.length < 1) {
                            return '诗词名必填项';
                        }
                    },
                    author: function (value) {
                        if (value.length < 1) {
                            return '作者必填项';
                        }
                    },
                    content: function (value) {
                        if (value.length < 1) {
                            return '内容必填项';
                        }
                    }
                });
                //监听提交
                form.on('submit(add)',
                    function(data) {
                        //发异步，把数据提交给
                        var poetryForm = $('#poetryForm').serialize()
                        $.ajax({
                            type:"post",
                            url:"addPoetry",
                            data:poetryForm,
                            dataType:"text",
                            success: function (result) {
                                if (result === "success") {
                                    layer.alert("增加成功", {
                                        icon: 6
                                    }, function() {
                                        //关闭当前frame
                                        xadmin.close();
                                        //可以对父窗口进行刷新
                                        xadmin.father_reload();
                                    });
                                }
                            }
                        });
                        return false;
                    });
            });
    </script>
</html>