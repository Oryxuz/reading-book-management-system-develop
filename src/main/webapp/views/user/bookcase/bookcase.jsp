<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="context"/>
<c:url value="/resources/plugins" var="plugin"></c:url>
<c:url value="/resources/custom" var="custom"></c:url>
<c:url value="/resources/img" var="img"></c:url>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/views/fragments/head.jsp"/>
    <!-- SweetAlert2 -->
    <script src="${plugin}/sweetalert2/sweetalert2.all.min.js"></script>
    <!-- Custom CSS   -->
    <title>Your BookCase</title>
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
                        <h1>Your BookCase</h1>
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
                <p>You have books in your bookcase</p>
                <div class="mb-3">
                    <a href="javascript:void(0)" onclick="deleteAll()" class="btn btn-danger">
                        <i class="fa fa-trash"></i>
                        Clear All
                    </a>
                </div>
                <div class="row book-case">
                    <c:forEach items="${books}" var="book">
                        <div class="col-lg-3 book-${book.id}">
                            <div class="card">
                                <div class="card-header">
                                    <h5 class="card-title m-0">${book.title}</h5>
                                </div>
                                <div class="card-body">
                                    <c:url value="/upload/img?fname=${book.imgUrl}" var="imgUpload"></c:url>
                                    <img src="${imgUpload}" class="m-auto d-block card-img-top" alt="${book.title}"
                                         style="height: 15rem;">
                                    <p class="card-text">Author : ${book.author}</p>
                                    <p class="card-text">Category : ${book.category}</p>
                                    <p class="card-text">Publisher : ${book.publisher}</p>
                                    <div class="row">
                                        <a class="btn btn-sm btn-primary"
                                           href="${context}/user/book/detail?id=${book.id}"
                                           title="View detail"><i class="fas fa-eye"></i></a>
                                        <a href="javascript:void(0)" onclick="deleteBookFromCase(${book.id})"
                                           class="btn btn-sm btn-danger ml-auto"
                                           title="Remove from case">
                                            <i class="fa fa-trash"></i>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
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
<!-- SweetAlert2 -->
<script src="${plugin}/sweetalert2/sweetalert2.min.js"></script>
<!-- Custom JS -->
<script src="${custom}/js/helper/utils.js"></script>
<script src="${custom}/js/bookcase.js"></script>
</html>
