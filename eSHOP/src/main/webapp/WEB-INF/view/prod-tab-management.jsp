<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<!DOCTYPE HTML>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
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


<!-- styles needed by swiper slider -->
<link href="resources/assets/plugins/swiper-master/css/swiper.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="resources/assets/css/style.css" rel="stylesheet">
<link href="resources/assets/css/home-v7.css" rel="stylesheet">
<link href="resources/assets/css/cart-nav.css" rel="stylesheet">


<!-- styles needed by footable  -->
<link href="resources/assets/css/footable-0.1.css" rel="stylesheet"
	type="text/css" />
<link href="resources/assets/css/footable.sortable-0.1.css"
	rel="stylesheet" type="text/css" />



<!-- Just for debugging purposes. -->
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

<!-- include pace script for automatic web page progress bar  -->
<!-- vex -->
<script src="resources/assets/vex/vex.combined.min.js"></script>
<script>
	vex.defaultOptions.className = 'vex-theme-default'
</script>
<link rel="stylesheet" href="resources/assets/vex/vex.css" />
<link rel="stylesheet" href="resources/assets/vex/vex-theme-default.css" />
<!-- /vex -->

<style type="text/css">

.breadcrumb-arrow {
    height: 36px;
    padding: 0;
    line-height: 36px;
    list-style: none;
    background-color: #e6e9ed
}
.breadcrumb-arrow li:first-child a {
    border-radius: 4px 0 0 4px;
    -webkit-border-radius: 4px 0 0 4px;
    -moz-border-radius: 4px 0 0 4px
}
.breadcrumb-arrow li, .breadcrumb-arrow li a, .breadcrumb-arrow li span {
    display: inline-block;
    vertical-align: top
}
.breadcrumb-arrow li:not(:first-child) {
    margin-left: -5px
}
.breadcrumb-arrow li+li:before {
    padding: 0;
    content: ""
}
.breadcrumb-arrow li span {
    padding: 0 10px
}
.breadcrumb-arrow li a, .breadcrumb-arrow li:not(:first-child) span {
    height: 36px;
    padding: 0 10px 0 25px;
    line-height: 36px
}
.breadcrumb-arrow li:first-child a {
    padding: 0 10px
}
.breadcrumb-arrow li a {
    position: relative;
    color: #fff;
    text-decoration: none;
    background-color: #3bafda;
    border: 1px solid #3bafda
}
.breadcrumb-arrow li:first-child a {
    padding-left: 10px
}
.breadcrumb-arrow li a:after, .breadcrumb-arrow li a:before {
    position: absolute;
    top: -1px;
    width: 0;
    height: 0;
    content: '';
    border-top: 18px solid transparent;
    border-bottom: 18px solid transparent
}
.breadcrumb-arrow li a:before {
    right: -10px;
    z-index: 3;
    border-left-color: #3bafda;
    border-left-style: solid;
    border-left-width: 11px
}
.breadcrumb-arrow li a:after {
    right: -11px;
    z-index: 2;
    border-left: 11px solid #2494be
}
.breadcrumb-arrow li a:focus, .breadcrumb-arrow li a:hover {
    background-color: #4fc1e9;
    border: 1px solid #4fc1e9
}
.breadcrumb-arrow li a:focus:before, .breadcrumb-arrow li a:hover:before {
    border-left-color: #4fc1e9
}
.breadcrumb-arrow li a:active {
    background-color: #2494be;
    border: 1px solid #2494be
}
.breadcrumb-arrow li a:active:after, .breadcrumb-arrow li a:active:before {
    border-left-color: #2494be
}
.breadcrumb-arrow li span {
    color: #434a54
}
</style>

<script>
	paceOptions = {
		elements : true
	};
</script>
<script src="resources/assets/js/pace.min.js"></script>
</head>

<body>

	<!-- search-overly -->
	<jsp:include page="admin-contents/search-overly.jsp" />
	<!-- /search-overly -->

	<!-- menu-sidebar -->
	<jsp:include page="admin-contents/menu-sidebar.jsp" />
	<!-- /menu-sidebar -->

	<!-- /.cart-sidebar -->
	<jsp:include page="admin-contents/cart-sidebar.jsp" />
	<!-- /.cart-sidebar -->

	<!-- Fixed navbar start -->
	<jsp:include page="admin-contents/fixed-navbar-admin.jsp" />
	<!-- /.Fixed navbar  -->


	<!-- CUSTOMER LIST -->

	<div class="container" style="padding-top: 10%;">
		<div class="row">
		
		<div class="container">
			    <ol class="breadcrumb breadcrumb-arrow">
					<li><a href="admin-panel"><i class="fa fa-home" aria-hidden="true"></i> Admin Home</a></li>
					<li class="active"><span>Category</span></li>
				</ol>
			</div>
		
		
			<div class="col-lg-9 col-md-9 col-sm-7">

				<div class="row userInfo">
					<div class="col-lg-12">
						<div class="col-lg-6 pull-left" >
							<h2 class="">Product Category List	</h2>
						</div>
						<div class="col-lg-6 pull-right" >
							<a data-toggle="modal" data-target="#addTabModal" class="btn btn-default btn-link btn-md">
                            Add New Tab <i class="fa fa-plus"></i> </a>
						</div>
					</div>
					<div class="col-lg-6 pull-right"></div>

					<div style="clear: both"></div>
				</div>

				<!-- ADD MODAL -->				
				<div class="modal  fade" id="addTabModal" tabindex="-1" role="dialog">
				    <div class="modal-dialog" style="width: 65%;">
				        <div class="modal-content">
				            <div class="modal-header">
				                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"> &times; </button>
				                <h3 class="modal-title-site text-center">Add New Category </h3>
				            </div>
				            <div class="modal-body">
				              <div class="table-responsive">
										<form action="createWrapTab" method="post" role="form">
											<div class=" col-lg-4">
												<label for="wrapTabId">Tab Id</label> <br>
												<input id="wrapTabId" type="text" name="wrapTabId" class="wrap-ids-class"></input>
											</div>
											<div class=" col-lg-4">
												<label for="wrapTabName">Tab Name</label> <br>
												<input id="wrapTabName" type="text" name="wrapTabName" ></input>
											</div>
											<div class=" col-lg-4">
												<label for="wrapTabSortOrder">Sort Order *</label> <br>
												<input type="text" id="wrapTabSortOrder" name="wrapTabSortOrder" class="sort-order-class"></input>
											</div>
											<div class="col-md-12">
												<div class="col-lg-4 pull-left">
													<button class="btn btn-primary btn-small "
														id="updateWrapTabSbmtBtn">
														Create &nbsp; <i class="fa fa-arrow-circle-right"></i>
													</button>
												</div>
												<div class="col-lg-4 pull-right">
													<button class="btn btn-default btn-small " data-dismiss="modal" >
														Discard &nbsp; <i class="fa fa-times" aria-hidden="true"></i>
													</button>
												</div>
											</div>
											
										</form>
				                </div>
				            </div>
				        </div>
				    </div>
				</div>
				
				<!--/ ADD MODAL -->
				
				<!-- carousal.. -->
				<div class="paymentBox">
					<div class="panel-group paymentMethod" id="accordion">
						<c:forEach items="${wrapTabList}" var="tab">
							<div class="panel panel-default">
								<div class="panel-heading panel-heading-custom">
									<h4 class="panel-title">
										<a class="cashOnDelivery" data-toggle="collapse"
											data-parent="#accordion"
											href="#${tab.wrapTabId}"> <span
											class="fa-fw"><strong> ${tab.wrapTabName}
											</strong></span>
										</a>
									</h4>
								</div>
								<div id="${tab.wrapTabId}"
									class="panel-collapse collapse">
									<div class="panel-body">
										<div class="panel open">
											<div class="creditCard col-lg-12">
												<form action="updateWrapTab" method="post" role="form">
													<div class="paymentInput col-lg-6">
														<label path1="wrapTabId" for="wrapTabId">Tab Id</label> <br>
														<input path1="wrapTabId" id="wrapTabId" type="text"
															value="${tab.wrapTabId}" name="wrapTabId"
															style="width: 100%;" ></input>
													</div>
													<div class="paymentInput col-lg-6">
														<label path1="wrapTabName" for="wrapTabName">Tab Name</label> <br>
														<input path1="wrapTabName" id="wrapTabName" type="text"
															value="${tab.wrapTabName}" name="wrapTabName"
															style="width: 100%;" ></input>
													</div>
													<div class="paymentInput col-lg-6">
														<label for="wrapTabSortOrder" path1="wrapTabSortOrder">Sort
															Order *</label> <br> <input type="text"
															id="wrapTabSortOrder" value="${tab.wrapTabSortOrder}"
															path1="wrapTabSortOrder" name="wrapTabSortOrder"
															style="width: 90px;"></input>
													</div>

													
													<div class="col-md-12">
														<div class="col-md-4">
															<button class="btn btn-primary btn-small "
																id="updateWrapTabSbmtBtn">
																Update &nbsp; <i class="fa fa-arrow-circle-right"></i>
															</button>
														</div>
														<div class="col-md-4">
															<a class="btn btn-danger btn-small " 
																href="deleteTab?wrapTabId=${tab.wrapTabId}">
																Delete &nbsp; <i class="fa fa-trash-o" aria-hidden="true"></i>
															</a>
														</div>
														<div class="col-md-4">
															<a class="btn btn-default btn-small " 
																href="manageProductSection?wrapTabId=${tab.wrapTabId}">
																View Sections(Col) &nbsp; <i class="fa fa-arrow-circle-right"></i>
															</a>
														</div>
													</div>
													
												</form>
												
											</div>
										</div>
									</div>
								</div>
								</div>
						</c:forEach>
					</div>
				</div>
				<!-- / carousal -->
			</div>
		</div>
	</div>
	</div>




	<!-- Footer  -->
	<jsp:include page="admin-contents/admin-footer.jsp" />
	<!-- / Footer  -->


	<!-- Le javascript
================================================== -->

	<!-- Placed at the end of the document so the pages load faster -->
	<script type="text/javascript"
		src="resources/assets/js/jquery/jquery-1.10.1.min.js"></script>
	<script src="resources/assets/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="resources/assets/plugins/swiper-master/js/swiper.jquery.min.js"></script>
	<!-- include footable plugin -->
	<script src="resources/assets/js/footable.js" type="text/javascript"></script>
	<script src="resources/assets/js/footable.sortable.js"
		type="text/javascript"></script>
	<script type="text/javascript">
		$(function() {
			$('.footable').footable();
		});
	</script>
	<script>
		var swiper = new Swiper('.swiper-container', {
			pagination : '.swiper-pagination',
			paginationClickable : '.swiper-pagination',
			nextButton : '.arrow-right',
			prevButton : '.arrow-left',
			// effect: 'cube',
			keyboardControl : true,
			parallax : true,
			speed : 600,
			spaceBetween : 0
		});
	</script>

	<!-- include jqueryCycle plugin -->
	<script src="resources/assets/js/jquery.cycle2.min.js"></script>

	<!-- include easing plugin -->
	<script src="resources/assets/js/jquery.easing.1.3.js"></script>

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

	<!-- include custom script for only homepage  -->
	<script src="resources/assets/js/home.js"></script>

	<!-- include custom script for site  -->
	<script src="resources/assets/js/script.js"></script>

	<script src="resources/assets/js/sidebar-nav.js"></script>


	<!-- scrollme || onscroll parallax effect for category page  -->
	<script src="resources/assets/js/jquery.scrollme.min.js"></script>
	<script src="resources/assets/js/wrap-admin.js"></script>
	<script type="text/javascript">
		$(function() {
			var target = $("div.has-overly-shade"), targetHeight = target
					.outerHeight();
			$(document).scroll(
					function() {
						var scrollPercent = (targetHeight - window.scrollY)
								/ targetHeight;
						scrollPercent >= 0
								&& (target.css("background-color",
										"rgba(0,0,0," + (1.1 - scrollPercent)
												+ ")"))
					})
		});

		$(function() {
			if (navigator.userAgent.match(/(iPod|iPhone|iPad|Android)/)) {
				$('#ios-notice').removeClass('hidden');
				$('.parallax-container').height($(window).height() * 0.5 | 0);
			} else {
				$(window).resize(
						function() {
							var parallaxHeight = Math.max(
									$(window).height() * 0.7, 200) | 0;
							$('.parallax-container').height(parallaxHeight);
						}).trigger('resize');
			}
		});

		$(document)
				.ready(
						function() {
							var isMobile = function() {
								//console.log("Navigator: " + navigator.userAgent);
								return /(iphone|ipod|ipad|android|blackberry|windows ce|palm|symbian)/i
										.test(navigator.userAgent);
							};

							if (isMobile()) {
								// For  mobile , ipad, tab
								$('.animateme').removeClass('animateme');
								$('.if-is-mobile').addClass('ismobile');

							} else {
							}

						}); // end
	</script>


</body>
</html>
