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
				<div class="col-lg-9 col-md-9 col-sm-7">
				
					<div class="row userInfo">
						<div class="col-lg-12">
							<h2 class="block-title-2">Product Items List</h2>
							<button class="table-add btn btn-primary pull-right">
								<i class="fa fa-plus-square-o" aria-hidden="true"></i> Add Item</button>
						</div>
						<div class="col-lg-6 pull-right">
						</div>
	
						<div style="clear: both"></div>
					</div>
					<div id="table" class="table-editable">
						
						<table id="wrapProdItmTable" class="table tablesorter" >
							<thead>
							<tr style="background-color: #EBEDED;">
								<th>Category Id</th>
								<th>Section Id</th>
								<th>Carton Id</th>
								<th>Item Id</th>
								<th>Item Name</th>
								<th>Item Description</th>
								<th>Stock</th>
								<th>Marked Price</th>
								<th>Discount %</th>
								<th>Shipping %</th>
								<th>Size</th>
								<th>Color</th>
								<th>Img Path</th>
								<th>Sort Order</th>
								<th>Action</th>
							</tr>
							</thead>
							<tbody>
							<c:forEach items="${WrapProductList}" var="itm">
								<tr>
									<td contenteditable="true" class="editableField">${itm.wrapTabId}</td>
									<td contenteditable="true" class="editableField">${itm.wrapColId}</td>
									<td contenteditable="true" class="editableField">${itm.wrapCatId}</td>
									<td contenteditable="true" class="editableField">${itm.wrapProdId}</td>
									<td contenteditable="true" class="editableField">${itm.wrapProdName}</td>
									<td contenteditable="true" class="editableField">${itm.wrapProdDescription}</td>
									<td contenteditable="true" class="editableField">${itm.wrapProdInStockItemsCount}</td>
									<td contenteditable="true" class="editableField">${itm.wrapProdMarkedPrice}</td>
									<td contenteditable="true" class="editableField">${itm.wrapProdDiscountPercent}</td>
									<td contenteditable="true" class="editableField">${itm.wrapProdShippingChargePercent}</td>
									<td contenteditable="true" class="editableField">${itm.wrapProdColor}</td>
									<td contenteditable="true" class="editableField">${itm.wrapProdId}</td>
									<td contenteditable="true" class="editableField"><img src="${itm.wrapProdImagePath}"></td>
									<td contenteditable="true" class="editableField">${itm.wrapProdSortOrder}</td>
									<td>
										<span class="table-remove glyphicon glyphicon-remove"></span>
									</td>
								</tr>	
							</c:forEach>
							<!-- This is our clonable table line -->
							<tr class="hide">
								<td contenteditable="true">_________</td>
								<td contenteditable="true">_________</td>
								<td contenteditable="true">_________</td>
								<td contenteditable="true">_________</td>
								<td>
									<span class="table-remove glyphicon glyphicon-remove"></span>
								</td>
							</tr>
							</tbody>
						</table>
					</div>
					
					<div class="row userInfo">
						<div class="col-lg-12">
							<button class="table-add btn btn-primary pull-left"><i class="fa fa-floppy-o" aria-hidden="true"></i> Save</button>
							<br>
							<hr>
						</div>
					</div>

					<p id="export"></p>
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
