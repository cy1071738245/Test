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
                <span class="fr">您现在的位置：<a href="#">诗词鉴赏</a></span>
                <i class="i0"></i><span class="t">诗词鉴赏</span>
            </div>
            <div class="line_er"></div>
            <div class="ma_15 ov_hi">
                <ul class="tw_il">
                    <c:forEach items="${articleResultMap.data}" var="articleInfo">
                        <li>
                            <a href="getArticleById?articleId=${articleInfo.articleId}"><img src="${articleInfo.imageUrl}" alt=""/></a>
                            <h2><a href="getArticleById?articleId=${articleInfo.articleId}">${articleInfo.articleName}</a></h2>
                            <div class="txt">${articleInfo.content}</div>
                            <p class="time">${articleInfo.updateTime}</p>
                        </li>
                    </c:forEach>
                </ul>
                <div class="clear"></div>
                <div class="fy_box">
                    <c:if test="${articleResultMap.prePage != null}">
                        <a href="articleList?page=${articleResultMap.prePage}"><<</a>
                        <a href="articleList?page=${articleResultMap.prePage}" class="hover">
                            ${articleResultMap.prePage}
                        </a>
                    </c:if>
                    <a href="#" class="hover">
                        ${articleResultMap.prePage + 1}
                    </a>
                    <c:if test="${articleResultMap.nextPage != null}">
                        <a href="articleList?page=${articleResultMap.nextPage}&size=" class="hover">
                            ${articleResultMap.nextPage}
                        </a>
                        <a href="articleList?page=${articleResultMap.nextPage}">>></a>
                    </c:if>
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
