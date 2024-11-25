<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title><dec:title default="Trang chủ" /></title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="font-awesome/4.5.0/css/font-awesome.min.css" />
    <link rel="stylesheet" href="assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />
    <script type='text/javascript' src="assets/js/ace-extra.min.js"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<link
			href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
			rel="stylesheet">

	<!-- jquery -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.min.css">

	<%--sweetalert--%>
</head>
<body class="page-top">
<div id="wrapper">
<!-- header -->
    <%@ include file="/common/admin/header.jsp" %>
    <!-- header -->

	<div class="main-container" id="main-container">
		<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
		</script>
		<!-- header -->
    	<%@ include file="/common/admin/menu.jsp" %>
    	<!-- header -->

		<dec:body/>

		<!-- footer -->
    	<%@ include file="/common/admin/footer.jsp" %>
    	<!-- footer -->

    	<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse display">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div>
</div>


	<%--jQuery Validation Plugin--%>
	<script src="js/jqueryvalidate/jquery.validate.min.js"></script>

	<%--common javascript file--%>
	<script type="text/javascript" src="js/global_admin_script.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/jquery-ui.custom.min.js"></script>
	<script src="assets/js/jquery.ui.touch-punch.min.js"></script>
	<script src="assets/js/jquery.easypiechart.min.js"></script>
	<script src="assets/js/jquery.sparkline.min.js"></script>
	<script src="assets/js/jquery.flot.min.js"></script>
	<script src="assets/js/jquery.flot.pie.min.js"></script>
	<script src="assets/js/jquery.flot.resize.min.js"></script>
	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>

	<!-- page specific plugin scripts -->
	<script src="assets/js/jquery-ui.min.js"></script>

	<script type="text/javascript">
        function showAlertBeforeDelete(callback) {
            swal({
                title: "Xác nhận xóa",
                text: "Bạn có chắc chắn xóa những dòng đã chọn",
                type: "warning",
                showCancelButton: true,
                confirmButtonText: "Xác nhận",
                cancelButtonText: "Hủy bỏ",
                confirmButtonClass: "btn btn-success",
                cancelButtonClass: "btn btn-danger"
            }).then(function (res) {
                if(res.value){
                    callback();
                }else if(res.dismiss == 'cancel'){
                    console.log('cancel');
                }
            });
        }
	</script>
</body>
</html>