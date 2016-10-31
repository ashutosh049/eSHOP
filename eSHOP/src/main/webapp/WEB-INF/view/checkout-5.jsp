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
	var context = '<%=ctx%>
	';
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
					<li><a href="cart">Cart</a></li>
					<li class="active">Checkout</li>
				</ul>
			</div>
		</div>

		<div class="row">
			<div
				class="col-lg-9 col-md-9 col-sm-7 col-xs-6 col-xxs-12 text-center-xs">
				<h1 class="section-title-inner">
					<span><i class="glyphicon glyphicon-shopping-cart"></i>
						Checkout</span>
				</h1>
			</div>

			<div
				class="col-lg-3 col-md-3 col-sm-5 rightSidebar col-xs-6 col-xxs-12 text-center-xs">

				<h4 class="caps">
					<a href="category"><i class="fa fa-chevron-left"></i> Back to
						shopping </a>
				</h4>
			</div>
		</div>

		<div class="row">
			<div class="col-lg-9 col-md-9 col-sm-12">
				<div class="row userInfo">

					<div class="col-xs-12 col-sm-12">

						<div class="w100 clearfix" style="height: 12%;">


							<ul class="orderStep orderStepLook2">
								<li><a href="checkout-1"> <i class="fa fa-map-marker "></i>
										<span> address</span>
								</a></li>

								<!--  <li><a href="checkout-2"> <i class="fa fa fa-envelope  "></i>
                                <span> Billing </span></a></li>

                            <li><a href="checkout-3"><i class="fa fa-truck "> </i><span>Shipping</span> </a></li> -->

								<li><a href="checkout-4"><i class="fa fa-money  ">
									</i><span>Payment</span> </a></li>

								<li class="active"><a href="checkout-5"><i
										class="fa fa-check-square "> </i><span>Order</span></a></li>

							</ul>
							<!--orderStep-->
						</div>


						<div class="w100 clearfix">


							<div class="row userInfo">

								<div class="col-lg-12">
									<h2 class="block-title-2">Review Order</h2>
								</div>


								<div class="col-xs-12 col-sm-12">
									<div class="cartContent w100 checkoutReview ">
										<table class="cartTable table-responsive" style="width: 100%">
											<tbody>
												<tr class="CartProduct cartTableHeader">
													<th style="width: 15%">Product</th>
													<th class="checkoutReviewTdDetails">Details</th>
													<th class="hidden-xs" style="width: 5%">QNT</th>
													<th class="hidden-xs" style="width: 10%">Discount</th>
													<th style="width: 10%">Shipping</th>
													<th style="width: 15%">Total</th>
												</tr>
												<c:forEach items="${wrapCart.wrapCartItemlList}"
													var="cartItemList">
													<tr class="CartProduct">
														<td class="CartProductThumb">
															<div>
																<a href="product-details"><img
																	src="${cartItemList.itemImagePath}" alt="img"></a>
															</div>
														</td>
														<td style="text-align: center;">
															<div class="CartDescription">
																<h4>
																	<a href="product-details">${cartItemList.itemName}
																	</a>
																</h4>
																<span class="size">${cartItemList.itemSize}</span><span
																	class="size">${cartItemList.itemColor}</span>

																<div class="price">
																	<span>$ ${cartItemList.itemMarkedPrice}</span>
																</div>
															</div>
														</td>
														<td>
															<span>${cartItemList.itemCount}</span>
														</td>
														<!-- <td class="price">$${cartItemList.itemSubToal}</td> -->
														<td>$ ${cartItemList.itemDiscountTotal}</td>
														<td>$ ${cartItemList.itemShippingTotal}</td>
														<td class="price">$ ${cartItemList.itemSubToal}</td>
													</tr>
												</c:forEach>

											</tbody>
										</table>
									</div>
									<!--cartContent-->

									<div class="w100 costDetails">
										<div class="table-block" id="order-detail-content">
											<table class="std table" id="cart-summary">
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
												<tbody>
												</tbody>
											</table>
										</div>
									</div>
									<!--/costDetails-->


									<!--/row-->


								</div>


							</div>


						</div>
						<!--/row end-->


						<div class="cartFooter w100">
							<div class="box-footer">
								<div class="pull-left">
									<a class="btn btn-default" href="checkout-4"> <i
										class="fa fa-arrow-left"></i> &nbsp; Payment method
									</a>
								</div>


								<div class="pull-right">
									<a href="thanks-for-order" class="btn btn-primary btn-small ">
										Confirm Order &nbsp; <i class="fa fa-check"></i>
									</a>
								</div>


							</div>
						</div>
						<!--/ cartFooter -->
					</div>


				</div>
			</div>
			<!--/row end-->


			<div class="col-lg-3 col-md-3 col-sm-12 rightSidebar">

				<!-- RIGHT Mini Cart -->
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
										<input class="col-lg-8" id="appendedInputButton" type="text"
											placeholder="Coupon code">
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
			<!--/rightSidebar-->

		</div>
		<!--/row-->

		<div style="clear: both"></div>
	</div>
	<!-- /wrapper -->
	<div class="gap"></div>

	<footer>
		<div class="footer">
			<div class="container">
				<div class="row">
					<div class="col-lg-3  col-md-3 col-sm-4 col-xs-6">
						<h3>Support</h3>
						<ul>
							<li class="supportLi">
								<p>Lorem ipsum dolor sit amet, consectetur</p>
								<h4>

									<a class="inline" href="callto:+12025550151"> <strong>
											<i class="fa fa-phone"> </i> +1-202-555-0151
									</strong>
									</a>
								</h4>
								<h4>
									<a class="inline" href="mailto:help@yourweb.com"> <i
										class="fa fa-envelope-o"> </i> help@yourweb.com
									</a>
								</h4>
							</li>
						</ul>
					</div>
					<div class="col-lg-2  col-md-2 col-sm-4 col-xs-6">
						<h3>Shop</h3>
						<ul>
							<li><a href="index"> Home </a></li>
							<li><a href="category"> Category </a></li>
							<li><a href="category2"> Category Style 2 [Parallax] </a></li>
							<li><a href="sub-category"> Sub Category </a></li>

						</ul>
					</div>
					<div class="col-lg-2  col-md-2 col-sm-4 col-xs-6">
						<h3>Information</h3>
						<ul>
							<li><a href="product-details"> Product Details </a></li>
							<li><a href="product-details-style2"> Product Details
									Version 2 </a></li>
							<li><a href="cart"> Cart </a></li>
							<li><a href="about-us-3"> About us </a></li>
							<li><a href="about-us-2"> About us 2 </a></li>
							<li><a href="contact-us"> Contact us </a></li>
							<li><a href="contact-us-2"> Contact us 2 </a></li>
							<li><a href="terms-conditions"> Terms &amp; Conditions </a>

							</li>

						</ul>
					</div>
					<div class="col-lg-2  col-md-2 col-sm-4 col-xs-6">
						<h3>My Account</h3>
						<ul>
							<li><a href="account-1"> Account Login </a></li>
							<li><a href="account"> My Account </a></li>
							<li><a href="my-address"> My Address </a></li>
							<li><a href="wishlist"> Wish List </a></li>
							<li><a href="order-list"> Order list </a></li>
							<li><a href="order-status"> Order Status </a></li>

						</ul>
					</div>
					<div class="col-lg-3  col-md-3 col-sm-6 col-xs-12 ">
						<h3>Stay in touch</h3>
						<ul>
							<li>
								<div class="input-append newsLatterBox text-center">
									<input type="text" class="full text-center"
										placeholder="Email ">
									<button class="btn  bg-gray" type="button">
										Subscribe <i class="fa fa-long-arrow-right"> </i>
									</button>
								</div>
							</li>
						</ul>
						<ul class="social">
							<li><a href="http://facebook.com"> <i
									class=" fa fa-facebook"> &nbsp; </i>
							</a></li>
							<li><a href="http://twitter.com"> <i
									class="fa fa-twitter"> &nbsp; </i>
							</a></li>
							<li><a href="https://plus.google.com"> <i
									class="fa fa-google-plus"> &nbsp; </i>
							</a></li>
							<li><a href="http://youtube.com"> <i
									class="fa fa-pinterest"> &nbsp; </i>
							</a></li>
							<li><a href="http://youtube.com"> <i
									class="fa fa-youtube"> &nbsp; </i>
							</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="footer-bottom">
			<div class="container">
				<p class="pull-left">&copy; TSHOP 2014. All right reserved.</p>

				<div class="pull-right paymentMethodImg">

					<img height="30" class="pull-right"
						src="resources/images/site/payment/master_card.png"> <img
						height="30" class="pull-right"
						src="resources/images/site/payment/paypal.png"> <img
						height="30" class="pull-right"
						src="resources/images/site/payment/american_express_card.png">
					<img height="30" class="pull-right"
						src="resources/images/site/payment/discover_network_card.png">
					<img height="30" class="pull-right"
						src="resources/images/site/payment/google_wallet.png">
				</div>


			</div>
		</div>
	</footer>


	<!-- Le javascript
================================================== -->

	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js">
</script>
	<script src="resources/assets/bootstrap/js/bootstrap.min.js"></script>
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

	<!-- include smoothproducts // product zoom plugin  -->
	<script type="text/javascript"
		src="resources/assets/js/smoothproducts.min.js"></script>

	<!-- jQuery select2 // custom select   -->
	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/js/select2.min.js"></script>

	<!-- include touchspin.js // touch friendly input spinner component   -->
	<script src="resources/assets/js/bootstrap.touchspin.js"></script>

	<!-- include touchspin.js // touch friendly input spinner component   -->
	<script src="resources/assets/js/bootstrap.touchspin.js"></script>

	<!-- include custom script for site  -->
	<script src="resources/assets/js/script.js"></script>
</body>
</html>
