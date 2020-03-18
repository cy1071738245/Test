<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>书画网</title>
    <link href="css/css.css" rel="stylesheet" type="text/css" />
    <script src="js/jquery.js"></script>
    <script src="js/html.js"></script>
</head>
<body>
<c:set var="size" value="1" />
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
                <span class="fr">您现在的位置：<a href="#">首页</a>><a href="#">诗词列表</a></span>
                <i class="i0"></i><span class="t">诗词列表</span>
            </div>
            <div class="line_er"></div>
            <div class="ma_15 ov_hi">
                <ul class="tw_il">
                    <c:forEach items="${poetryResultMap.data}" var="poetryInfo">
                        <li>
                            <a href="detail"><img src="img/cs12.jpg" alt=""/></a>
                            <h2><a href="detail">${poetryInfo.title}</a></h2>
                            <div class="txt">${poetryInfo.content}</div>
                            <p class="time">${poetryInfo.updateTime}</p>
                        </li>
                    </c:forEach>
                </ul>
                <div class="clear"></div>
                <div class="fy_box">
                    <c:if test="${poetryResultMap.prePage != null}">
                        <a href="poetryList?page=${poetryResultMap.prePage}&size=${size}"><<</a>
                        <a href="poetryList?page=${poetryResultMap.prePage}&size=${size}" class="hover">
                            ${poetryResultMap.prePage}
                        </a>
                    </c:if>
                    <a href="#" class="hover">
                        ${poetryResultMap.prePage + 1}
                    </a>
                    <c:if test="${poetryResultMap.nextPage != null}">
                        <a href="poetryList?page=${poetryResultMap.nextPage}&size=${size}" class="hover">
                                ${poetryResultMap.nextPage}
                        </a>
                        <a href="poetryList?page=${poetryResultMap.nextPage}&size=${size}">>></a>
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
