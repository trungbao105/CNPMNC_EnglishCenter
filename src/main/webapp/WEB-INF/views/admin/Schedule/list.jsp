<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 10/21/2024
  Time: 2:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="scheduleAPI" value="/api/schedules"/>
<c:url var="scheduleListURL" value="/admin/schedule-list"/>
<html>
<head>
    <title>Lịch học</title>
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
                        <h5 class="widget-title">Thêm lịch học </h5>
                        <div class="widget-toolbar">
                            <a href="#" data-action="collapse">
                                <i class="ace-icon fa fa-chevron-down"></i>
                            </a>
                        </div>
                    </div>

                    <div class="widget-body"
                         style="display: block;font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;">
                        <div class="widget-main">
                            <form:form modelAttribute="scheduleEdit" id="listForm" method="GET" var="item">
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
                                                <div class="col-xs-3">Phòng học</div>
                                                <div class="col-xs-9">
                                                    <form:select path="roomId" class="form-control">
                                                        <form:option value="">---Chọn phòng học---</form:option>
                                                        <form:options items="${rooms}" itemValue="id"
                                                                      itemLabel="roomName"/>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-xs-3">Thứ</div>
                                                <div class="col-xs-9">
                                                    <form:select path="date" class="form-control">
                                                        <form:option value="">---Chọn thứ trong tuần---</form:option>
                                                        <form:options items="${weekdays}"/>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-xs-3">Giờ vào lớp</div>
                                                <div class="col-xs-9">
                                                    <form:select class="form-control" path="classTime">
                                                        <form:option value="">---Chọn giờ vào lớp---</form:option>
                                                        <form:options items="${classTimes}"/>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-xs-3"></label>
                                                <div class="col-xs-9">
                                                    <button type="button" class="btn btn-primary"
                                                            id="btnAddOrUpdateSchedule">Thêm mới lịch học
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
                        <display:table name="scheduleDTOS" cellspacing="0" cellpadding="0"
                                       requestURI="${scheduleListURL}"
                                       id="tableList"
                                       class="table table-fcv-ace table-striped table-bordered table-hover dataTable no-footer"
                                       style="margin: 3em 0 1.5em;">
                            <display:column title="<fieldset class='form-group'>
                                <input type='checkbox' id='checkAll' class='check-box-element'>
                            </fieldset>" class="center select-cell" headerClass="center select-cell">
                                <fieldset>
                                    <input type="checkbox" name="checkList" value="${tableList.id}"
                                           id="checkbox_${tableList.id}" class="check-box-element"/>
                                </fieldset>
                            </display:column>
                            <display:column headerClass="text-left" title="Tên khóa học">
                                <c:forEach items="${tableList.courseNames}" var="courseName">
                                    ${courseName}<br/>
                                </c:forEach>
                            </display:column>
                            <display:column headerClass="text-left" title="Tên phòng học">
                                <c:forEach items="${tableList.roomNames}" var="roomName">
                                    ${roomName}<br/>
                                </c:forEach>
                            </display:column>
                            <display:column headerClass="text-left" property="date" title="Thứ"/>
                            <display:column headerClass="text-left" property="classTime" title="Giờ học"/>
                            <display:column title="Thao tác">
                                <button class="btn btn-xs btn-danger" title="xóa lịch học"
                                        onclick="deleteSchedule(${tableList.id})">
                                    <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                </button>
                            </display:column>
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
    function deleteSchedule(id) {
        var scheduleId = [id];
        deleteSchedules(scheduleId);
    };
    $('#btnDeleteSchedule').click(function (e) {
        e.preventDefault();
        var data = {};
        data['scheduleId'] = $('#scheduleId').val();
        var scheduleIds = $('#tableList').find('tbody input[type = checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        deleteSchedules(scheduleIds);
    });

    function deleteSchedules(data) {
        $.ajax({
            type: "DELETE",
            url: "${scheduleAPI}/" + data,
            data: JSON.stringify(data),
            contentType: "application/json",
            dataType: "JSON",
            success: function (respond) {
                console.log("Success");
            },
            error: function (respond) {
                console.log("fail");
                window.location.href = "<c:url value="/admin/schedule-list?message=success"/> ";
            }
        });
    }

    $('#btnAddOrUpdateSchedule').click(function () {
        $('.error-message').remove();

        var isValid = true;

        if ($('[name="courseId"]').val() === "") {
            $('[name="courseId"]').after('<span class="error-message" style="color:red; font-size: 0.875em; display: block; margin-top: 5px;">Vui lòng chọn khóa học</span>');
            isValid = false;
        }

        if ($('[name="roomId"]').val() === "") {
            $('[name="roomId"]').after('<span class="error-message" style="color:red; font-size: 0.875em; display: block; margin-top: 5px;">Vui lòng chọn phòng học</span>');
            isValid = false;
        }

        if ($('[name="date"]').val() === "") {
            $('[name="date"]').after('<span class="error-message" style="color:red; font-size: 0.875em; display: block; margin-top: 5px;">Vui lòng chọn thứ trong tuần</span>');
            isValid = false;
        }

        if ($('[name="classTime"]').val() === "") {
            $('[name="classTime"]').after('<span class="error-message" style="color:red; font-size: 0.875em; display: block; margin-top: 5px;">Vui lòng chọn giờ vào lớp</span>');
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
            url: "${scheduleAPI}",
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
                    window.location.href = "/admin/schedule-list";
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
                        window.location.href = "/admin/schedule-list";
                    });
                }
            }
        });
    }

</script>

</body>
</html>
