<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="context"/>
<c:url value="/resources/img" var="img"></c:url>
<nav class="main-header navbar navbar-expand-md navbar-light navbar-light">
  <div class="container">
    <a href="${context}/admin/book/list" class="navbar-brand ml-2">
      <img src="${img}/logo.jpg" alt="RBMS" class="brand-image img-circle elevation-3" style="opacity: 0.8"/>
      <span class="brand-text font-weight-light">Reading Book System</span>
    </a>
    <!-- Right navbar links -->
    <ul class="order-1 order-md-3 navbar-nav navbar-no-expand ml-auto">
      <li class="row">
        <p class="mr-2">Welcome ${loginedUser.userName}</p>|<a href="${context}/logout" class="ml-2">Logout</a>
      </li>
    </ul>
  </div>
</nav>
