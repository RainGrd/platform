<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isErrorPage="true"%>
<%@include file="common/header.jsp" %>
<div class="page-title">
    <div class="title_left">
        <h3>
            欢迎你：${sessionScope.devUserSession.devName }<strong> | 角色：开发者账户</strong>
        </h3>
    </div>
</div>
<div class="clearfix"></div>
<%@include file="common/footer.jsp" %>
