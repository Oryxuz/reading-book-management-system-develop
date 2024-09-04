<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<c:url value="/resources/plugins" var="plugin"></c:url>
<c:url value="/resources/custom" var="custom"></c:url>
<c:url value="/resources/img" var="img"></c:url>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/views/fragments/head.jsp"/>
    <!-- waitMe -->
    <link href="${plugin}/waitMe/css/waitMe.min.css" rel="stylesheet"/>
    <title>Log in</title>
</head>
<body class="hold-transition login-page">
<div class="login-box">
    <!-- /.login-logo -->
    <div class="card card-outline card-primary">
        <div class="card-header text-center">
            <h3>Welcome to our service !</h3>
        </div>
        <div class="card-body" id="login-card">
            <p class="login-box-msg">Sign in to start your session</p>
            <form action="${context}/login" method="post" id="login-form">
                <div class="input-group mb-3">
                    <input id="username" class="form-control" type="text" name="username" placeholder="Your UserName"/>
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-user"></span>
                        </div>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input id="password" class="form-control" type="password" name="password"
                           placeholder="Your Password"/>
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-lock"></span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-8">
                        <div class="">
                            <input id="remember" name="remember" type="checkbox"/>
                            <label for="remember"> Remember Me </label>
                        </div>
                    </div>
                    <!-- /.col -->
                    <div class="col-4">
                        <button class="btn btn-primary btn-sm d-block ml-auto" type="submit">
                            Sign In
                        </button>
                    </div>
                    <!-- /.col -->
                </div>
            </form>

            <div class="social-auth-links text-center mt-2 mb-3">
                <p>- or use another account -</p>
                <button class="btn btn-block btn-primary" href="#">
                    <i class="fab fa-facebook mr-2"></i> Sign in using Facebook
                </button>
                <button class="btn btn-block btn-danger" href="#">
                    <i class="fab fa-google-plus mr-2"></i> Sign in using Google+
                </button>
            </div>
            <!-- /.social-auth-links -->

            <p class="mb-1">
                <a href="forgot-password.html">I forgot my password</a>
            </p>
            <p class="mb-0">
                <a class="text-center" href="${context}/register">Register a new membership</a>
            </p>
        </div>
        <!-- /.card-body -->
    </div>
    <!-- /.card -->
</div>
<!-- /.login-box -->
<!--Default jQuery and bootstrap-->
<jsp:include page="/views/fragments/plugins.jsp"/>
<!-- jQuery validation -->
<script src="${plugin}/jquery-validation/jquery.validate.min.js"></script>
<!-- SweetAlert2 -->
<script src="${plugin}/sweetalert2/sweetalert2.all.min.js"></script>
<!-- waitMe -->
<script src="${plugin}/waitMe/js/waitMe.min.js"></script>
<!-- Helper JS -->
<script src="${custom}/js/helper/utils.js"></script>
<!-- Custom JS -->
<script src="${custom}/js/login.js"></script>
</body>
</html>
