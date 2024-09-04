<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="context"/>
<c:url value="/resources/plugins" var="plugin"></c:url>
<c:url value="/resources/custom" var="custom"></c:url>
<c:url value="/resources/img" var="img"></c:url>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../fragments/head.jsp"/>
    <!-- SweetAlert2 -->
    <script src="${plugin}/sweetalert2/sweetalert2.all.min.js"></script>
    <title>Registration Page</title>
</head>
<body class="hold-transition register-page">
<div class="register-box">
    <div class="card card-outline card-primary">
        <div class="card-header text-center">
            <h4>Welcome to RBMS</h4>
        </div>
        <div class="card-body">
            <p class="login-box-msg">Register a new membership</p>

            <form action="${context}/register" method="post" id="register-form">
                <div class="input-group mb-3">
                    <input class="form-control" id="username" name="username" placeholder="Your UserName" type="text"/>
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-user"></span>
                        </div>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input class="form-control" id="password" name="password" placeholder="Password" type="password"/>
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-lock"></span>
                        </div>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input class="form-control" id="re-password" name="re-password" placeholder="Retype password"
                           type="password"/>
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-lock"></span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-8">
                        <div class="icheck-primary">
                            <input id="agreeTerms" name="terms" type="checkbox" value="agree"/>
                            <label for="agreeTerms">
                                I agree to the <a href="#">terms</a>
                            </label>
                        </div>
                    </div>
                    <!-- /.col -->
                    <div class="col-4">
                        <button class="btn btn-primary btn-block" type="submit">
                            Register
                        </button>
                    </div>
                    <!-- /.col -->
                </div>
            </form>

            <div class="social-auth-links text-center">
                <a class="btn btn-block btn-primary" href="#">
                    <i class="fab fa-facebook mr-2"></i>
                    Sign up using Facebook
                </a>
                <a class="btn btn-block btn-danger" href="#">
                    <i class="fab fa-google-plus mr-2"></i>
                    Sign up using Google+
                </a>
            </div>

            <a class="text-center" href="${context}/login">I already have a membership</a>
        </div>
        <!-- /.form-box -->
    </div>
    <!-- /.card -->
</div>
<!-- /.register-box -->
<!--Plugins-->
<jsp:include page="../fragments/plugins.jsp"/>
<!-- jQuery validation -->
<script src="${plugin}/jquery-validation/jquery.validate.min.js"></script>
<!-- SweetAlert2 -->
<script src="${plugin}/sweetalert2/sweetalert2.min.js"></script>
<!-- Helper JS -->
<script src="${custom}/js/helper/utils.js"></script>
<!-- Custom JS -->
<script src="${custom}/js/register.js"></script>
</body>
</html>
