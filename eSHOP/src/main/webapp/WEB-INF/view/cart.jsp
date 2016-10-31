<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	var context = '<%=ctx%>
	';
</script>
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
<title>eSHOP</title>
<!-- Bootstrap core CSS -->
<link href="resources/assets/bootstrap/css/bootstrap.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="resources/assets/css/style.css" rel="stylesheet">

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
		elements : true
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
<!-- 					<li><a href="category">Category</a></li> -->
					<li class="active">Cart</li>
				</ul>
			</div>
		</div>
		<!--/.row-->

		<div class="row">
			<div
				class="col-lg-9 col-md-9 col-sm-7 col-xs-6 col-xxs-12 text-center-xs">
				<h1 class="section-title-inner">
					<span><i class="glyphicon glyphicon-shopping-cart"></i>
						Shopping cart </span>
				</h1>
			</div>
			<div
				class="col-lg-3 col-md-3 col-sm-5 rightSidebar col-xs-6 col-xxs-12 text-center-xs">
				<h4 class="caps">
					<a href="index"><i class="fa fa-chevron-left"></i> Back to
						shopping </a>
				</h4>
			</div>
		</div>
		<!--/.row-->

		<div class="row">
			<div class="col-lg-9 col-md-9 col-sm-7">
				<div class="row userInfo">
					<div class="col-xs-12 col-sm-12">
						<div class="cartContent w100">
							<table class="cartTable table-responsive" style="width: 100%">
								<tbody>

									<tr class="CartProduct cartTableHeader">
										<td style="width: 15%">Product</td>
										<td style="width: 25%">Details</td>
										<td style="width: 10%">QNT</td>
										<td style="width: 10%">Discount</td>
										<td style="width: 10%">Shipping</td>
										<td style="width: 10%">Tax</td>
										<td style="width: 10%">Subtotal</td>
										<td style="width: 10%" class="delete">Remove</td>
									</tr>
									<c:forEach items="${wrapCart.wrapCartItemlList}"
										var="cartItemList">
										<tr class="CartProduct">
											<td class="CartProductThumb">
												<div>
													<a href="productDetails?tabId=${cartItemList.itemTabId}&
														colId=${cartItemList.itemColId}&
														catId=${cartItemList.itemCatId}&
														prodId=${cartItemList.itemId}"><img
														src="${cartItemList.itemImagePath}" alt="img"></a>
												</div>
											</td>
											<td>
												<div class="CartDescription">
													<h4>
														<a href="productDetails?tabId=${cartItemList.itemTabId}&
														colId=${cartItemList.itemColId}&
														catId=${cartItemList.itemCatId}&
														prodId=${cartItemList.itemId}">${cartItemList.itemName} </a>
													</h4>
													<span class="size">${cartItemList.itemSize}</span><span
														class="size"> (${cartItemList.itemColor}) </span>

													<div class="price">
														<span>$ ${cartItemList.itemMarkedPrice}</span>
													</div>
												</div>
											</td>
											<td><input class="quanitySniper" type="text"
												value="${cartItemList.itemCount}" name="quanitySniper"></td>
											<!-- <td class="price">$${cartItemList.itemSubToal}</td> -->
											<td>$ ${cartItemList.itemDiscountTotal}</td>
											<td>$ ${cartItemList.itemShippingTotal}</td>
											<td>$ ${cartItemList.itemTaxTotal}</td>
											<td class="price">$ ${cartItemList.itemSubToal}</td>
											<td class="delete">
												<a title="Delete" href="removeFromCart?itemTabId=${cartItemList.itemTabId}&
																		itemColId=${cartItemList.itemColId}&
																		itemCatId=${cartItemList.itemCatId}&
																		itemId=${cartItemList.itemId}&
																		itemCount=1&
																		itemSize=${cartItemList.itemSize}">
													 <i style="color: #e7711b" class="glyphicon glyphicon-trash fa-2x"></i>
												</a></td>
										</tr>
									</c:forEach>




								</tbody>
							</table>
						</div>
						<!--cartContent-->

						<div class="cartFooter w100">
							<div class="box-footer">
								<div class="pull-left">
									<a href="index" class="btn btn-default"> <i
										class="fa fa-arrow-left"></i> &nbsp; Continue shopping
									</a>
								</div>
								<div class="pull-right">
									<a type="submit" class="btn btn-default" href="cart">
										<i class="fa fa-undo"></i> &nbsp; Update cart
									</a>
								</div>
							</div>
						</div>
						<!--/ cartFooter -->

					</div>
				</div>
				<!--/row end-->

			</div>
			<div class="col-lg-3 col-md-3 col-sm-5 rightSidebar">
				<div class="contentBox">
					<div class="w100 costDetails">
						
						<div class="table-block" id="order-detail-content">
							
							<c:if test="${wrapCart.wrapCartPayable>0}">
								<a class="btn btn-primary btn-lg btn-block " title="checkout-1"
									href="checkout-1" style="margin-bottom: 20px"> Proceed to
									checkout &nbsp; <i class="fa fa-arrow-right"></i>
								</a>
							</c:if>
							
							

							<div class="w100 cartMiniTable">
								<table id="cart-summary" class="std table">
									<tbody>
										<tr>
											<td>Sub Total</td>
											<td class="price">$ ${wrapCart.wrapCartSubToal}</td>
										</tr>
										<tr style="">
											<td>Shipping</td>
											<c:choose>
												<c:when test="${wrapCart.wrapCartShippingTotal>0}">
													<td class="price">$ ${wrapCart.wrapCartShippingTotal}</td>
												</c:when>
												<c:otherwise>
													<td class="price"><span class="success">Free
															shipping!</span></td>
												</c:otherwise>
											</c:choose>

										</tr>
										<tr class="cart-total-price ">
											<td>Discount</td>
											<td class="price">$ ${wrapCart.wrapCartDiscountTotal}</td>
										</tr>
										<tr>
											<td>Tax</td>
											<td class="price" id="total-tax">$
												${wrapCart.wrapCartTaxTotal}</td>
										</tr>
										<tr>
											<td>Total</td>
											<td class=" site-color" id="total-price">$
												${wrapCart.wrapCartPayable}</td>
										</tr>
										<tr>
											<td colspan="2">
												<div class="input-append couponForm">
													<input class="col-lg-8" id="appendedInputButton"
														type="text" placeholder="Coupon code">
													<button class="col-lg-4 btn btn-success" type="button">Apply!</button>
												</div>
											</td>
										</tr>
									</tbody>
									<tbody>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				<!-- End popular -->

			</div>
			<!--/rightSidebar-->

		</div>
		<!--/row-->

		<div style="clear: both"></div>
	</div>
	<!-- /.main-container -->

	<div class="gap"></div>

	<!-- Footer -->
	<jsp:include page="contents/footer.jsp" />
	<!-- /Footer -->



	<!-- Le javascript
================================================== -->

	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js">
		
	</script>
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


