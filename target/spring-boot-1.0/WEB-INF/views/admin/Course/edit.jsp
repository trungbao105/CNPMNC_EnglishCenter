<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 7/17/2024
  Time: 4:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="courseAPI" value="/api/course"/>

<html>
<head>
    <title>Thêm mới/chỉnh sửa khóa học</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>

            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Home</a>
                </li>
                <li class="active">Dashboard</li>
            </ul><!-- /.breadcrumb -->
        </div>

        <div class="page-content">
            <div class="page-header" >
                <h1 style="font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;">
                    Sửa đổi hoặc thêm khóa học
                    <small>
                        <i class="ace-icon fa fa-angle-double-right"></i>
                        overview &amp; stats
                    </small>
                </h1>
            </div><!-- /.page-header -->
            <form:form modelAttribute="courseEdit" id="listForm" method="GET" var="item">
                <div class="row" style="font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;">
                    <div class="col-xs-12">
                        <form action="" class="form-horizontal" role="form" >
                            <div class="form-group">
                                <div class="col-xs-3">Tên khóa học </div>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="title"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-3">Ngày khai giảng</div>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="openingDate" type="date" placeholder="yyyy-MM-dd"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-3">Giá khóa học </div>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="price"/>
                                </div>
                            </div>
                             <div class="form-group">
                                <div class="col-xs-3">Ghi chú</div>
                                <div class="col-xs-9">
                                    <form:textarea rows="12" class="form-control" path="note"/>
                                 </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 no-padding-right">Hình ảnh </label>
                                <input class="col-sm-3 no-padding-right" type="file" id="uploadImage"/>
                                <div class="col-xs-9">
                                     <c:if test="${not empty courseEdit.image}">
                                        <c:set var="imagePath" value="/repository${courseEdit.image}"/>
                                        <img src="${imagePath}" id="viewImage" width="300px" height="300px" style="margin-top: 50px">
                                    </c:if>
                                    <c:if test="${empty courseEdit.image}">
                                        <img src="/admin/image/defaul.jpg" id="viewImage" width="300px" height="300px">
                                    </c:if>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-xs-3"></label>
                                <div class="col-xs-9">
                                    <c:if test="${not empty courseEdit.id}">
                                        <button type="button" class="btn btn-primary" id="btnAddOrUpdateCourse">Cập nhật khóa học</button>
                                        <button type="button" class="btn btn-primary" id="btnCancel">Hủy thao tác</button>
                                    </c:if>
                                    <c:if test="${empty courseEdit.id}">
                                        <button type="button" class="btn btn-primary" id="btnAddOrUpdateCourse">Thêm khóa học</button>
                                        <button type="button" class="btn btn-primary" id="btnCancel">Hủy thao tác</button>
                                    </c:if>
                                </div>
                            </div>
                            <form:hidden path="id" id="courseId"/>
                        </form>

                    </div>
                </div>

            </form:form>
        </div><!-- /.page-content -->

    </div>
</div>
<script>
    $('#btnAddOrUpdateCourse').click(function(){
        var data = {};
        var formData=$('#listForm').serializeArray();

        $.each(formData,function(i,v){
            data[""+v.name+""]=v.value;
        })
        addOrUpdate(data);
        function addOrUpdate(data){
            $.ajax({
                type:"POST",
                url:"${courseAPI}",
                data:JSON.stringify(data),
                contentType:"application/json",
                dataType:"JSON",
                success:function(respond){
                    console.log("success");
                },
                error:function(respond){
                    console.log("fail");
                    console.log(respond);
                }
            });
        };

        $('#btnCancel').click(function () {
            window.location.href = "/admin/course-list";
        });
    })
</script>
</body>
</html>
