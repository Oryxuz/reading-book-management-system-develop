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
    <title>List Book</title>
</head>
<body class="sidebar-collapse layout-top-nav bg-light">
<div class="wrapper">
    <jsp:include page="/views/admin/fragments/header.jsp"/>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <div class="content-header">
            <div class="container">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>List of book</h1>
                    </div>
                    <div class="col-sm-6">
                        <a href="${context}/admin/book/form" class="btn btn-sm btn-success float-right">
                            <i class="fa fa-edit">Add New</i>
                        </a>
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
                <div class="row book-list">
                    <c:forEach items="${books}" var="book">
                        <div class="col-lg-3 book-${book.id}">
                            <div class="card">
                                <div class="card-header">
                                    <h5 class="card-text">${book.title}</h5>
                                </div>
                                <c:url value="/upload/img?fname=${book.imgUrl}" var="imgUpload"></c:url>
                                <img src="${imgUpload}" class="m-auto d-block card-img-top" alt="${book.title}"
                                     style="height: 15rem;">
                                <div class="card-body">
                                    <h6 class=" card-text">${book.title}</h6>
                                    <p class="card-text">Author : ${book.author}</p>
                                    <p class="card-text">Category : ${book.category}</p>
                                    <p class="card-text">Publisher : ${book.publisher}</p>
                                    <div class="row">
                                        <a href="${context}/admin/book/form?id=${book.id}"
                                           class="btn btn-sm btn-primary"
                                           title="Edit this book">
                                            <i class="fa fa-edit"></i>
                                        </a>
                                        <a href="javascript:void(0)" onclick="deleteBook(${book.id},this)"
                                           class="btn btn-sm btn-danger ml-auto"
                                           title="Delete this book">
                                            <i class="fa fa-trash"></i>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <ul class="pagination justify-content-center">
                    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item"><a class="page-link" href="#">Next</a></li>
                </ul>
            </div>
        </div>
        <!-- /.content -->
    </div>
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
<script src="${custom}/js/list-book.js"></script>
</html>
