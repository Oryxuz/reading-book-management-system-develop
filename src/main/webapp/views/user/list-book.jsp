<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="context"/>
<c:url value="/resources/plugins" var="plugin"></c:url>
<c:url value="/resources/custom" var="custom"></c:url>
<c:url value="/resources/img" var="img"></c:url>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/views/fragments/head.jsp"/>
    <!-- SweetAlert2 -->
    <script src="${plugin}/sweetalert2/sweetalert2.all.min.js"></script>
    <!-- Custom CSS   -->
    <title>List Book</title>
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
                        <h1>List of book</h1>
                    </div>
                    <div class="col-sm-6">
                        <a class="btn btn-sm btn-success float-right" href="${context}/user/bookcase"
                           title="My bookcase">My
                            Bookcase</a>
                    </div>
                </div>
                <!-- /.row -->
                <form action="${context}/user/book/list" class="row" method="post">
                    <div class="col-lg-6">
                        <div class="form-group form-group-lg">
                            <label>Your keyword</label>
                            <div class="input-group input-group-lg">
                                <input
                                        class="form-control form-control-lg"
                                        name="keyword"
                                        placeholder="Type your keywords here"
                                        type="search"
                                />
                                <div class="input-group-append">
                                    <button class="btn btn-lg btn-default" type="submit">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="form-group">
                            <label>Filter By</label>
                            <select class="custom-select custom-select-lg" name="option">
                                <option selected value="title">Title</option>
                                <option value="author">Author</option>
                                <option value="category">Category</option>
                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /.content-header -->

        <!-- Main content -->
        <div class="content">
            <div class="container">
                <div class="row">
                    <c:forEach items="${books}" var="book">
                        <div class="col-lg-3">
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
                                        <a href="javascript:void(0)" onclick="addBookToCase(${book.id})"
                                           class="btn btn-sm btn-danger ml-auto"
                                           title="Add to case">
                                            <i class="fa fa-plus"></i>
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
