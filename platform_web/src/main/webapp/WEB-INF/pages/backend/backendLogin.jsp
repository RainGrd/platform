<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isErrorPage="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="${pageContext.request.contextPath}/">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>后台管理系统</title>

    <!-- Bootstrap -->
    <link href="statics/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="statics/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="statics/css/nprogress.css" rel="stylesheet">
    <!-- Animate.css -->
    <link href="statics/css/animate.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="statics/css/custom.min.css" rel="stylesheet">
    <jsp:include page="common/js.jsp"/>
</head>

<body class="login">
<div>
    <a class="hiddenanchor" id="signup"></a>
    <a class="hiddenanchor" id="signin"></a>

    <div class="login_wrapper">
        <div class="animate form login_form">
            <section class="login_content">
                <form action="" method="post">
                    <h1>后台管理系统</h1>
                    <div>
                        <input type="text" id="userName" class="form-control" name="userCode" placeholder="请输入用户名"
                               required=""/>
                    </div>
                    <div>
                        <input type="password" id="password" class="form-control" name="userPassword"
                               placeholder="请输入密码"
                               required=""/>
                    </div>
                    <%--提示登录错误信息--%>
                    <span id="error">${error}</span>
                    <div>
                        <button type="button" id="loginBtn" class="btn btn-success">登 录</button>
                        <button type="reset" class="btn btn-default">重　填</button>
                    </div>

                    <div class="clearfix"></div>

                    <div class="separator">
                        <div>
                            <p>©2016 All Rights Reserved. </p>
                        </div>
                    </div>
                </form>
            </section>
        </div>
    </div>
</div>
</body>
<script src="/js/backend/login.js" charset="utf-8"></script>

</html>