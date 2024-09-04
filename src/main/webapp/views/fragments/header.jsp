<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/resources/plugins" var="plugin"></c:url>
<c:url value="/resources/img" var="img"></c:url>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<nav class="main-header navbar navbar-expand-md navbar-light navbar-light">
    <div class="container">
        <button
                aria-controls="navbarCollapse"
                aria-expanded="false"
                aria-label="Toggle navigation"
                class="navbar-toggler"
                data-target="#navbarCollapse"
                data-toggle="collapse"
                type="button"
        >
            <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand ml-2" href="${context}/user/book/list">
            <img alt="RBMS" class="brand-image img-circle elevation-3" src="${img}/logo.jpg"/>
            <span class="brand-text font-weight-light">Reading Book System</span>
        </a>
        <div class="collapse navbar-collapse order-3" id="navbarCollapse">
            <!-- Left navbar links -->
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="${context}/user/bookcase">My BookCase</a>
                </li>
            </ul>
        </div>

        <!-- Right navbar links -->
        <ul class="order-1 order-md-3 navbar-nav navbar-no-expand ml-auto">
            <li class="row">
                <p class="mr-2">Welcome ${loginedUser.userName}</p>
                |
                <a class="ml-2" href="${context}/logout">Logout</a>
            </li>
        </ul>
    </div>
</nav>