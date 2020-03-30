<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>诗词网</title>
    <link href="front/css/css.css" rel="stylesheet" type="text/css" />
    <script src="front/js/jquery.js"></script>
    <script src="front/js/html.js"></script>
</head>
<body>
<!--头部-->
<div id="header">
    <div class="top">

    </div>
</div>
<!--内容部分-->
<div id="content">
    <div class="layout ptb_20">
        <div class="bj_fff">
            <div class="er_title">
                <span class="fr">您现在的位置：<a href="#">诗词鉴赏</a>><a href="#">${articleInfo.poetryName}</a></span>
                <i class="i0"></i><span class="t">${articleInfo.articleName}</span>
            </div>
            <div class="line_er"></div>
            <div class="ma_15 ov_hi">
                <div class="pages_title">
                    <h2 class="pages_h2">${articleInfo.articleName}</h2>
                    <p class="pages_p">${articleInfo.updateTime}</p>
                </div>
                <div class="text_box">
                    <p>&nbsp;&nbsp;&nbsp;&nbsp;
                        ${articleInfo.poetryContent}
                    </p>
                    <br />
                    <p style="text-align:center"><img src="${articleInfo.imageUrl}" alt="" style="height: 300px" /></p><br />
                    <p>&nbsp;&nbsp;&nbsp;&nbsp;
                        ${articleInfo.articleContent}
                    </p>
                    <br />
                </div>
            </div>
        </div>
    </div>
</div>
<div id="footer">
    <div class="layout">

    </div>
</div>
</body>
</html>