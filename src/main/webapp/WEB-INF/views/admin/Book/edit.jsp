<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 7/17/2024
  Time: 4:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="bookAPI" value="/api/book"/>

<html>
<head>
    <title>Chinh sửa sách</title>
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
                    Sửa đổi hoặc thêm sách
                    <small>
                        <i class="ace-icon fa fa-angle-double-right"></i>
                        overview &amp; stats
                    </small>
                </h1>
            </div><!-- /.page-header -->
            <form:form modelAttribute="bookEdit" id="listForm" method="GET" var="item">
                <div class="row" style="font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;">
                    <div class="col-xs-12">
                        <form action="" class="form-horizontal" role="form" >
                            <div class="form-group">
                                <div class="col-xs-3">Tên sách</div>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="title"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-3">Tác giả</div>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="author"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-3">Nhà xuất bản</div>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="publisher"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-3">Thế loại</div>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="category"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-3">Số lượng</div>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="quantity"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-xs-3"></label>
                                <div class="col-xs-9">
                                    <c:if test="${not empty bookEdit.id}">
                                        <button type="button" class="btn btn-primary" id="btnAddOrUpdateBook">Cập nhật sach</button>
                                        <button type="button" class="btn btn-primary" id="btnCancel">Hủy thao tác</button>
                                    </c:if>
                                    <c:if test="${empty bookEdit.id}">
                                        <button type="button" class="btn btn-primary" id="btnAddOrUpdateBook">Thêm sach</button>
                                        <button type="button" class="btn btn-primary" id="btnCancel">Hủy thao tác</button>
                                    </c:if>
                                </div>
                            </div>
                            <form:hidden path="id" id="bookId"/>
                        </form>

                    </div>
                </div>

            </form:form>
        </div><!-- /.page-content -->

         <div class="col-xs-12">
              <div class="col-sm-12">
                  <h3 class="header smaller lighter blue">Mượn sách</h3>
                  <button class="btn btn-lg btn-primary" style="margin: 12px" id="btnAddOrUpdateBorrow" >
                            <i class="orange ace-icon fa fa-location-arrow bigger-130">Mượn</i>
                  </button>

                  <div class="col-xs-12">
                                <table id="simple-table" class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>Người mượn</th>
                                        <th>Ngày mượn</th>
                                        <th>Ngày trả</th>

                                    </tr>
                                    </thead>

                                    <tbody>
                                    <c:forEach var="items" items="${borrowBook}">
                                        <tr>
                                            <td>${items.user}</td>
                                            <td>${items.createdDate}</td>
                                            <td>${items.returnDate}</td>

                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
              </div>
         </div>
    </div>
</div>
<script>
     $('#btnAddOrUpdateBorrow').click(function (e){
            e.preventDefault();
            var data={};
            data['id']=$('#id').val();
            data['bookId']=$('#bookId').val();
            data['user']="nguyen van a";
            addOrUpdateTransaction(data);
            location.reload();
            function addOrUpdateTransaction(data){
                $.ajax({
                    type:"POST",
                    url:"${bookAPI}/borrow",
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
            }

        });
    $('#btnAddOrUpdateBook').click(function(){
        var data = {};
        var formData=$('#listForm').serializeArray();

        $.each(formData,function(i,v){
            data[""+v.name+""]=v.value;
        })
        addOrUpdate(data);
        function addOrUpdate(data){
            $.ajax({
                type:"POST",
                url:"${bookAPI}",
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
            window.location.href = "/admin/book-list";
        });
    })
</script>
</body>
</html>
