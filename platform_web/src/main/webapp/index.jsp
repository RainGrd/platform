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
</head>

<body class="login">
<div class="login_wrapper">
    <h1>手游管理平台</h1>
    <div>
        <a href="backend/backendLogin.do" class="btn btn-link">后台管理系统 入口</a>
    </div>
    <div>
        <a href="developer/developerLogin.do" class="btn btn-link">开发者平台 入口</a>
    </div>
</div>
</body>
</html>