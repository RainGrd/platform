<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isErrorPage="true"%>
<%@include file="common/header.jsp" %>
<div class="page-title">
    <div class="title_left">
        <h3>
            欢迎你：${sessionScope.userSession.userName}<strong> |
            角色：<c:if test="${dictionary}!=null">
                ${dictionary.valueName}
            </c:if>
            <%-- <c:if test="${sessionScope.userSession.userType==1}">
                 超级管理员
             </c:if>--%>
        </strong>
        </h3>
    </div>
</div>
<div class="clearfix"></div>
<%@include file="common/footer.jsp" %>  
     