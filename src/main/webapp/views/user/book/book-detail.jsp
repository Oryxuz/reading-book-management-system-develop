<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="context"/>
<c:url value="/resources/plugins" var="plugin"></c:url>
<c:url value="/resources/custom" var="custom"></c:url>
<c:url value="/resources/img" var="img"></c:url>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/views/fragments/head.jsp"/>
    <!-- Custom CSS   -->
    <title>Book Detail</title>
</head>
<body class="sidebar-collapse layout-top-nav">
<div class="wrapper">
    <jsp:include page="/views/fragments/header.jsp"></jsp:include>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <div class="content-header">
            <div class="container">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>Information of Book</h1>
                    </div>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /.content-header -->

        <!-- Main content -->
        <div class="content">
            <div class="container">
                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title m-0">${book.title}</h5>
                    </div>
                    <div class="card-body row">
                        <div class="col-lg-4">
                            <h6 class="card-title">${book.title}</h6>
                            <c:url value="/upload/img?fname=${book.imgUrl}" var="imgUpload"></c:url>
                            <img src="${imgUpload}" class="m-auto d-block" alt="${book.title}"
                                 style="height: 15rem;">
                            <p class="card-text">Author : ${book.author}</p>
                            <p class="card-text">Brief : ${book.brief}</p>
                            <p class="card-text">Publisher : ${book.publisher}</p>
                        </div>
                        <div class="col-lg-8">
                            <p class="card-text">${book.content}</p>
                        </div>
                    </div>
                    <div class="card-footer text-muted">
                        <div class="row">
                            <div class="col-lg-6">
                                <a class="btn btn-sm btn-danger" href="${context}/user/book/list"
                                   title="Back to list">
                                    <i class="fas fa-arrow-left"></i></a>
                            </div>
                            <div class="col-lg-6">
                                <p class="float-right">${book.author}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /.content -->
    </div>
    <jsp:include page="/views/fragments/footer.jsp"></jsp:include>
</div>
</body>
<!--Default jQuery and bootstrap-->
<jsp:include page="/views/fragments/plugins.jsp"/>
<!-- Custom JS -->
</html>
