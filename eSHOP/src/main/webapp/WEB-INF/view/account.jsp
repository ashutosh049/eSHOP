<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String locale = request.getParameter("locale");
	if (locale == null) {
		session.setAttribute("locale", "en");
	} else {
		session.setAttribute("locale", locale);
	}
	String ctx = request.getContextPath();
%>
<c:if test="<%=locale != null%>">
	<fmt:setLocale value="<%=locale%>" scope="session" />
</c:if>
<script type="text/javascript">
	var projectDir='<%=ctx%>'+'/';
	var context = '<%=ctx%>';
</script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Fav and touch icons -->
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="resources/assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="resources/assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="resources/assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="ico/apple-touch-icon-57-precomposed.png">
<link rel="shortcut icon" href="resources/assets/ico/favicon.png">
<title>TSHOP - Bootstrap E-Commerce Parallax Theme</title>
<!-- Bootstrap core CSS -->
<link href="resources/assets/bootstrap/css/bootstrap.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="resources/assets/css/style.css" rel="stylesheet">


<link href="resources/assets/css/ion.checkRadio.css" rel="stylesheet">
<link href="resources/assets/css/ion.checkRadio.cloudy.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="resources/assets/css/jquery.minimalect.min.css" media="screen" />


<!-- Just for debugging purposes. -->
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

<!-- include pace script for automatic web page progress bar  -->
<!-- vex -->
	<script src="resources/assets/vex/vex.combined.min.js"></script>
	<script>vex.defaultOptions.className = 'vex-theme-default'</script>
	<link rel="stylesheet" href="resources/assets/vex/vex.css" />
	<link rel="stylesheet" href="resources/assets/vex/vex-theme-default.css" />
<!-- /vex -->

<script>
        paceOptions = {
            elements: true
        };
    </script>

<script src="resources/assets/js/pace.min.js"></script>
</head>

<body>

<!-- Modal Login start -->
	<jsp:include page="contents/modal-login.jsp" />
<!-- /.Modal Login -->

<!-- Modal Signup start -->
	<jsp:include page="contents/modal-signup.jsp" />
<!-- /.ModalSignup End -->

<!-- Fixed navbar start -->
	<jsp:include page="contents/header.jsp" />
<!-- /.Fixed navbar  -->

	
	<div class="container main-container headerOffset">
		<div class="row">
			<div class="breadcrumbDiv col-lg-12">
				<ul class="breadcrumb">
					<li><a href="index">Home</a></li>
					<li><a href="account-1">Authentication</a></li>
					<li class="active">My account</li>
				</ul>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-9 col-md-9 col-sm-7">
				<h1 class="section-title-inner">
					<span><i class="fa fa-unlock-alt"></i> My account </span>
				</h1>

				<div class="row userInfo">
					<div class="col-xs-12 col-sm-12">
						<p>Your account has been created.</p>

						<h2 class="block-title-2">
							<span>Welcome to your account. Here you can manage all of
								your personal information and orders.</span>
						</h2>
						<ul class="myAccountList row">
							<li class="col-lg-2 col-md-2 col-sm-3 col-xs-4  text-center ">
								<div class="thumbnail equalheight">
									<a title="Orders" href="order-list"><i
										class="fa fa-calendar"></i> Order history </a>
								</div>
							</li>
							<li class="col-lg-2 col-md-2 col-sm-3 col-xs-4  text-center ">
								<div class="thumbnail equalheight">
									<a title="My addresses" href="my-address"><i
										class="fa fa-map-marker"></i> My addresses</a>
								</div>
							</li>
							<li class="col-lg-2 col-md-2 col-sm-3 col-xs-4  text-center ">
								<div class="thumbnail equalheight">
									<a title="Add  address" href="add-address"> <i
										class="fa fa-edit"> </i> Add address
									</a>
								</div>
							</li>
							<li class="col-lg-2 col-md-2 col-sm-3 col-xs-4  text-center ">
								<div class="thumbnail equalheight">
									<a title="Personal information" href="user-information"><i
										class="fa fa-cog"></i> Personal information</a>
								</div>
							</li>
							<li class="col-lg-2 col-md-2 col-sm-3 col-xs-4  text-center ">
								<div class="thumbnail equalheight">
									<a title="My wishlists" href="wishlist"><i
										class="fa fa-heart"></i> My wishlists </a>
								</div>
							</li>
						</ul>
						<div class="clear clearfix"></div>
					</div>
				</div>
				<!--/row end-->

			</div>
			<div class="col-lg-3 col-md-3 col-sm-5"></div>
		</div>
		<!--/row-->

		<div style="clear: both"></div>
	</div>
	<!-- /wrapper -->
	<div class="gap"></div>

	<!-- Footer -->
	<jsp:include page="contents/footer.jsp" />
	<!-- /Footer -->

	<!-- Le javascript
================================================== -->

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
	<script src="resources/assets/bootstrap/js/bootstrap.min.js"></script>
	<!-- include  parallax plugin -->
	<script type="text/javascript"
		src="resources/assets/js/jquery.parallax-1.1.js"></script>

	<!-- optionally include helper plugins -->
	<script type="text/javascript"
		src="resources/assets/js/helper-plugins/jquery.mousewheel.min.js"></script>

	<!-- include mCustomScrollbar plugin //Custom Scrollbar  -->

	<script type="text/javascript"
		src="resources/assets/js/jquery.mCustomScrollbar.js"></script>

	<!-- include icheck plugin // customized checkboxes and radio buttons   -->
	<script type="text/javascript"
		src="resources/assets/plugins/icheck-1.x/icheck.min.js"></script>

	<!-- include grid.js // for equal Div height  -->
	<script src="resources/assets/js/grids.js"></script>

	<!-- include carousel slider plugin  -->
	<script src="resources/assets/js/owl.carousel.min.js"></script>

	<!-- jQuery select2 // custom select   -->
	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/js/select2.min.js"></script>

	<!-- include touchspin.js // touch friendly input spinner component   -->
	<script src="resources/assets/js/bootstrap.touchspin.js"></script>

	<!-- include custom script for site  -->
	<script src="resources/assets/js/script.js"></script>
</body>
</html>
