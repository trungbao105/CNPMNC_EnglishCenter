<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 7/15/2024
  Time: 8:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="bookListURL" value="/admin/book-list"/>
<c:url var="bookAPI" value="/api/book"/>
<html>
<head>
    <title>
        Danh sách thư viện
    </title>
</head>
<body>
<div class="main-content" >
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
                <div class="page-header">
                    <h1>
                        Danh sách thư viện
                        <small>
                            <i class="ace-icon fa fa-angle-double-right"></i>
                            overview &amp; stats
                        </small>
                    </h1>
                </div><!-- /.page-header -->
                <div class="widget-box ui-sortable-handle collapsed">
                    <div class="widget-header">
                        <h5 class="widget-title">Tìm kiếm</h5>
                        <div class="widget-toolbar">
                            <a href="#" data-action="collapse">
                                <i class="ace-icon fa fa-chevron-down"></i>
                            </a>
                        </div>
                    </div>

                    <div class="widget-body" style="display: block;font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;" >
                        <div class="widget-main" >
                            <form:form id="listForm" modelAttribute="modelSearchRequest" action="${bookListURL}" method="GET">
                                <!-- danh sach tim kiem -->
                                <div class="row">
                                    <div class="form-group">
                                        <div class="col-xs-12">
                                            <label class="name">Tên sách</label>
                                            <form:input class="form-control" path="title"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-xs-12">
                                            <div class="col-sm-6">
                                                <button class="btn btn-danger" type="button" id="btnSearchBook">Tìm kiếm</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- /danh sach tim kiem -->
                            </form:form>

                        </div>
                    </div>

                    <div class="widget-title pull-right">
                        <a href="/admin/book-edit">
                            <button type="button" class="btn btn-info">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-building-add" viewBox="0 0 16 16">
                                    <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7m.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 0 1-1 0v-1h-1a.5.5 0 0 1 0-1h1v-1a.5.5 0 0 1 1 0"/>
                                    <path d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6.5a.5.5 0 0 1-1 0V1H3v14h3v-2.5a.5.5 0 0 1 .5-.5H8v4H3a1 1 0 0 1-1-1z"/>
                                    <path d="M4.5 2a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
                                </svg>
                            </button>
                        </a>
                        <button class="btn btn-danger" title="Xóa sach" id="btnDeleteBuilding">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-building-dash" viewBox="0 0 16 16">
                                <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7M11 12h3a.5.5 0 0 1 0 1h-3a.5.5 0 0 1 0-1"/>
                                <path d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6.5a.5.5 0 0 1-1 0V1H3v14h3v-2.5a.5.5 0 0 1 .5-.5H8v4H3a1 1 0 0 1-1-1z"/>
                                <path d="M4.5 2a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
                            </svg>
                        </button>
                    </div>
                </div>
                <!-- Danh sách kết quả -->
                <div class="row" style="font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; margin-top: 80px;">
                    <div class="col-xs-12">
                        <display:table name="books" cellspacing="0" cellpadding="0" requestURI="${bookListURL}"
                                       id="tableList"
                                       class="table table-fcv-ace table-striped table-bordered table-hover dataTable no-footer"
                                       style="margin: 3em 0 1.5em;"
                                       >
                            <display:column title="<fieldset class='form-group'>
												        <input type='checkbox' id='checkAll' class='check-box-element'>
												        </fieldset>" class="center select-cell"
                                            headerClass="center select-cell">
                                <fieldset>
                                    <input type="checkbox" name="checkList" value="${tableList.id}"
                                           id="checkbox_${tableList.id}" class="check-box-element"/>
                                </fieldset>
                            </display:column>
                            <display:column headerClass="text-left" property="title" title="Tên sách"/>
                            <display:column headerClass="text-left" property="author" title="Tác giả"/>
                            <display:column headerClass="text-left" property="publisher" title="Nhà xuất bản"/>
                            <display:column headerClass="text-left" property="category" title="Thể loại"/>
                            <display:column headerClass="text-left" property="quantity" title="Số lượng"/>
                            <display:column title="Thao tác">
                                    <button class="btn btn-xs btn-success" title="Giao sách" onclick="assignmentBuilding(${tableList.id})">
                                        <i class="ace-icon glyphicon glyphicon-align-justify"></i>
                                    </button>
                                <a href="/admin/book-edit-${tableList.id}" >
                                    <button class="btn btn-xs btn-info" >
                                        <i class="ace-icon fa fa-pencil bigger-120"></i>
                                    </button>
                                </a>
                                    <button class="btn btn-xs btn-danger" title="Xóa sách" onclick="deleteBuilding(${tableList.id})">
                                        <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                    </button>
                            </display:column>
                        </display:table>



                        <input type="hidden" name="Book" id="bookId" value="">
                    </div><!-- /.span -->
                </div>

            </div><!-- /.page-content -->
        </div>
    </div><!-- /.main-content -->



    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
    </a>
</div>
<script>
    $('#btnSearchBook').click(function(e){
        e.preventDefault();
        $('#listForm').submit()
    });
    function deleteBuilding(id){
        var bookId = [id];
        deleteBuildings(bookId);
    };

    $('#btnDeleteBuilding').click(function(e){
        e.preventDefault();
        var data= {};
        data['bookId'] = $('#bookId').val();
        var bookIds = $('#tableList').find('tbody input[type = checkbox]:checked').map(function(){
            return $(this).val();
        }).get();
        deleteBuildings(bookIds);
    });

    function deleteBuildings(data){
        $.ajax({
            type: "DELETE",
            url: "${bookAPI}/"+data,
            data: JSON.stringify(data),
            contentType: "application/json",
            dataType: "JSON",
            success: function (respond) {
                console.log("Success");
            },
            error : function (respond) {
                console.log("fail");
                window.location.href = "<c:url value="/admin/book-list?message=success"/> ";
            }
        });
    }
</script>
</body>
</html>