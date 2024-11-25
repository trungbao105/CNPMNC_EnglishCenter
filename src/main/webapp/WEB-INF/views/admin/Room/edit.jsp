<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 10/8/2024
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="roomAPI" value="/api/rooms"/>
<html>
<head>
    <title>Thêm/Sửa phòng học</title>
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
                    Sửa đổi hoặc thêm phòng học
                    <small>
                        <i class="ace-icon fa fa-angle-double-right"></i>
                        overview &amp; stats
                    </small>
                </h1>
            </div><!-- /.page-header -->
            <form:form modelAttribute="roomEdit" id="listForm" method="GET" var="item">
                <div class="row" style="font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;">
                    <div class="col-xs-12">
                        <form action="" class="form-horizontal" role="form">
                            <div class="form-group">
                                <div class="col-xs-3">Tên phòng học</div>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="roomName"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-3">Sức chứa</div>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="capacity"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-3">Vị trí phòng học</div>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="location"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-xs-3"></label>
                                <div class="col-xs-9">
                                    <c:if test="${not empty roomEdit.id}">
                                        <button type="button" class="btn btn-primary" id="btnAddOrUpdateRoom">Cập nhật
                                            phòng học
                                        </button>
                                        <button type="button" class="btn btn-primary" id="btnCancel">Hủy thao tác
                                        </button>
                                    </c:if>
                                    <c:if test="${empty roomEdit.id}">
                                        <button type="button" class="btn btn-primary" id="btnAddOrUpdateRoom">Thêm
                                            phòng học
                                        </button>
                                        <button type="button" class="btn btn-primary" id="btnCancel">Hủy thao tác
                                        </button>
                                    </c:if>
                                </div>
                            </div>
                            <form:hidden path="id" id="roomId"/>
                        </form>

                    </div>
                </div>

            </form:form>
        </div><!-- /.page-content -->

    </div>
</div>
    <script>
    $('#btnAddOrUpdateRoom').click(function () {
        var data = {};
        var formData = $('#listForm').serializeArray();

        $.each(formData, function (i, v) {
            data["" + v.name + ""] = v.value;
        })
        addOrUpdate(data);

        function addOrUpdate(data) {
            $.ajax({
                type: "POST",
                url: "${roomAPI}",
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
            window.location.href = "/admin/room-list";
        });
    })
</script>
</body>
</html>
