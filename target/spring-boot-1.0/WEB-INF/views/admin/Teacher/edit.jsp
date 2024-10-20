<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 10/19/2024
  Time: 10:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="teacherAPI" value="/api/teachers"/>
<html>
<head>
    <title>Thêm/Sửa giáo viên</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try {
                    ace.settings.check('breadcrumbs', 'fixed')
                } catch (e) {
                }
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
            <div class="page-header">
                <h1 style="font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;">
                    Sửa đổi hoặc thêm khóa học
                    <small>
                        <i class="ace-icon fa fa-angle-double-right"></i>
                        overview &amp; stats
                    </small>
                </h1>
            </div><!-- /.page-header -->
            <form:form modelAttribute="teacherEdit" id="listForm" method="GET" var="item">
                <div class="row" style="font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;">
                    <div class="col-xs-12">
                        <form action="" class="form-horizontal" role="form">
                            <div class="form-group">
                                <div class="col-xs-3">Tên giáo viên</div>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="name"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-3">Email</div>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="email"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-3">Số điện thoại</div>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="phone"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-xs-3"></label>
                                <div class="col-xs-9">
                                    <c:if test="${not empty teacherEdit.id}">
                                        <button type="button" class="btn btn-primary" id="btnAddOrUpdateTeacher">Cập nhật
                                            giáo viên
                                        </button>
                                        <button type="button" class="btn btn-primary" id="btnCancel">Hủy thao tác
                                        </button>
                                    </c:if>
                                    <c:if test="${empty teacherEdit.id}">
                                        <button type="button" class="btn btn-primary" id="btnAddOrUpdateTeacher">Thêm
                                            giáo viên
                                        </button>
                                        <button type="button" class="btn btn-primary" id="btnCancel">Hủy thao tác
                                        </button>
                                    </c:if>
                                </div>
                            </div>
                            <form:hidden path="id" id="teacherId"/>
                        </form>

                    </div>
                </div>

            </form:form>
        </div><!-- /.page-content -->

    </div>
</div>
<script>
    $('#btnAddOrUpdateTeacher').click(function () {
        var data = {};
        var formData = $('#listForm').serializeArray();

        $.each(formData, function (i, v) {
            data["" + v.name + ""] = v.value;
        })
        addOrUpdate(data);

        function addOrUpdate(data) {
            $.ajax({
                type: "POST",
                url: "${teacherAPI}",
                data: JSON.stringify(data),
                contentType: "application/json",
                dataType: "JSON",
                success: function (respond) {
                    console.log("success");
                },
                error: function (respond) {
                    console.log("fail");
                    console.log(respond);
                }
            });
        };

        $('#btnCancel').click(function () {
            window.location.href = "/admin/teacher-list";
        });
    })
</script>
</body>
</html>
