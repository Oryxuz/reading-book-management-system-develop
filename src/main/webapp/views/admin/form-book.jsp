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
    <title>Form Book</title>
</head>
<body class="sidebar-collapse layout-top-nav">
<div class="wrapper">
    <jsp:include page="/views/admin/fragments/header.jsp"/>
    <div class="content-wrapper">
        <div class="content-header">
            <div class="container">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>Form book</h1>
                    </div>
                </div>
            </div>
        </div>

        <!-- Main content -->
        <div class="content">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 col-sm-12">
                        <div class="card">
                            <div class="card-header">
                                <h5 class="card-title m-0">Information of Book</h5>
                            </div>
                            <div class="card-body">
                                <form action="${context}/admin/book/form" class="row" method="post" id="book-form"
                                      enctype="multipart/form-data">
                                    <input name="id" type="text" value="${book.id}" hidden>
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <label for="title">Title</label>
                                            <input class="form-control" id="title" name="title"
                                                   placeholder="Enter title" type="text"
                                                   value="${book.title}"/>
                                        </div>
                                        <div class="form-group">
                                            <label for="author">Author</label>
                                            <input class="form-control" id="author" name="author"
                                                   placeholder="Enter author" type="text"
                                                   value="${book.author}"/>
                                        </div>
                                        <div class="form-group">
                                            <label for="brief">Brief</label>
                                            <select class="custom-select" id="brief" name="brief">
                                                <c:forEach var="brief" items="${briefs}">
                                                    <option value="${brief}" ${book.brief == brief ? 'selected' : ''}>${brief}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label for="publisher">Publisher</label>
                                            <input class="form-control" id="publisher" name="publisher" type="date"
                                                   value="${book.publisher}"/>
                                        </div>
                                        <div class="form-group">
                                            <label for="content">Content</label>
                                            <textarea class="form-control" id="content" name="content"
                                                      rows="5">${book.content}</textarea>
                                        </div>
                                        <div class="form-group">
                                            <label for="category">Category</label>
                                            <select class="custom-select" id="category" name="category">
                                                <c:forEach var="category" items="${categories}">
                                                    <option value="${category}" ${book.category == category ? 'selected' : ''}>${category}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <label for="image">Upload your image</label>
                                            <div class="input-group">
                                                <div class="custom-file">
                                                    <input id="image" accept="image/*" class="custom-file-input"
                                                           name="imgInp"
                                                           onchange="previewFile(this);"
                                                           type="file"
                                                           size="50"
                                                           value="${book.imgUrl}"
                                                    />
                                                    <label class="custom-file-label" id="labelImage">Choose file</label>
                                                </div>
                                            </div>
                                        </div>
                                        <c:choose>
                                            <c:when test="${book.imgUrl !=null}">
                                                <c:url value="/upload/img?fname=${book.imgUrl}" var="imgUpload"></c:url>
                                                <img alt="My Image" class="img-fluid border" id="previewImg"
                                                     src="${imgUpload}"/>
                                            </c:when>
                                            <c:otherwise>
                                                <img alt="My Image" class="img-fluid border" id="previewImg"
                                                     src="data:image/gif;base64,R0lGODlhAQABAAD/ACwAAAAAAQABAAACADs="/>
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                    <div class="col-lg-6 mt-2">
                                        <c:choose>
                                            <c:when test="${book.id !=null}">
                                                <button class="btn btn-primary" type="submit">
                                                    Update
                                                </button>
                                                <a href="${context}/admin/book/list" class="btn btn-danger">
                                                    Cancel
                                                </a>
                                            </c:when>
                                            <c:otherwise>
                                                <button class="btn btn-success" type="submit">
                                                    Submit
                                                </button>
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </form>
                            </div>
                            <div class="card-footer">
                                <h5>This is end of form</h5>
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
<!-- jQuery Validation -->
<script src="${plugin}/jquery-validation/jquery.validate.min.js"></script>
<!-- Custom JS -->
<script src="${custom}/js/form-book.js"></script>
</html>
