<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/24/2024
  Time: 2:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="registrationURL" value="/admin/registration-list"/>
<html>
<head>
    <title> Đăng ký khóa học </title>
</head>
<body>
<div class="main-content">
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
                    <h1>
                        Lịch học
                        <small>
                            <i class="ace-icon fa fa-angle-double-right"></i>
                            overview &amp; stats
                        </small>
                    </h1>
                </div><!-- /.page-header -->
                <div class="widget-box ui-sortable-handle collapsed">
                    <div class="widget-header">
                        <h5 class="widget-title"> Đăng ký khóa học </h5>
                        <div class="widget-toolbar">
                            <a href="#" data-action="collapse">
                                <i class="ace-icon fa fa-chevron-down"></i>
                            </a>
                        </div>
                    </div>

                    <div class="widget-body"
                         style="display: block;font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;">
                        <div class="widget-main">
                            <form:form modelAttribute="registration" id="listForm" method="GET" var="item">
                                <div class="row" style="font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;">
                                    <div class="col-xs-12">
                                        <form action="" class="form-horizontal" role="form">
                                            <div class="form-group">
                                                <div class="col-xs-3">Khóa học</div>
                                                <div class="col-xs-9">
                                                    <form:select path="courseId" class="form-control">
                                                        <form:option value="">---Chọn khóa học---</form:option>
                                                        <form:options items="${courses}" itemValue="id"
                                                                      itemLabel="title"/>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-xs-3">Học sinh</div>
                                                <div class="col-xs-9">
                                                    <form:select path="studentId" class="form-control">
                                                        <form:option value="">---Chọn học sinh---</form:option>
                                                        <form:options items="${students}" itemValue="id"
                                                                      itemLabel="name"/>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-xs-3"></label>
                                                <div class="col-xs-9">
                                                    <button type="button" class="btn btn-primary"
                                                            id="btnRegistration"> Đăng ký
                                                    </button>
                                                </div>
                                            </div>
                                            <form:hidden path="id" id="scheduleId"/>
                                        </form>
                                    </div>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
                <!-- Danh sách kết quả -->
                <div class="row"
                     style="font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; margin-top: 10px;">
                    <div class="col-xs-12">
                        <display:table name="courses" cellspacing="0" cellpadding="0"
                                       requestURI="${registrationURL}"
                                       id="tableList"
                                       class="table table-fcv-ace table-striped table-bordered table-hover dataTable no-footer"
                                       style="margin: 3em 0 1.5em;">
                            <display:column headerClass="text-left" property="title" title=" Tên khóa học "/>
                            <display:column headerClass="text-left" property="quantity"
                                            title="Số lượng học viên đăng ký khóa"/>
                        </display:table>
                        <input type="hidden" name="Schedule" id="scheduleId" value="">
                    </div><!-- /.span -->

                </div><!-- /.page-content -->
            </div>
        </div><!-- /.main-content -->
        <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
            <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
        </a>
    </div>
</div>
<script>
    $('#btnRegistration').click(function () {
        $('.error-message').remove();
        var isValid = true;
        if ($('[name="courseId"]').val() === "") {
            $('[name="courseId"]').after('<span class="error-message" style="color:red; font-size: 0.875em; display: block; margin-top: 5px;">Vui lòng chọn khóa học</span>');
            isValid = false;
        }
        if ($('[name="studentId"]').val() === "") {
            $('[name="studentId"]').after('<span class="error-message" style="color:red; font-size: 0.875em; display: block; margin-top: 5px;">Vui lòng chọn học sinh</span>');
            isValid = false;
        }
        if (isValid) {
            var data = {};
            var formData = $('#listForm').serializeArray();
            $.each(formData, function (i, v) {
                data[v.name] = v.value;
            });
            addOrUpdate(data);
        }
    });

    function addOrUpdate(data) {
        $.ajax({
            type: "POST",
            url: "/api/students/registration",
            data: JSON.stringify(data),
            contentType: "application/json",
            dataType: "text",
            success: function (response) {
                Swal.fire({
                    title: 'Thành công!',
                    text: response,
                    icon: 'success',
                    confirmButtonText: 'OK',
                    timer: 3000
                }).then(() => {
                    window.location.href = "/admin/registration-list";
                });
            },
            error: function (xhr) {
                if (xhr.status === 400) {
                    Swal.fire({
                        title: 'Lỗi!',
                        text: xhr.responseText,
                        icon: 'error',
                        confirmButtonText: 'OK',
                        timer: 3000
                    }).then(() => {
                        window.location.href = "/admin/registration-list";
                    });
                }
            }
        });
    }
</script>
</body>
</html>
