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
					
					<!-- FORM -->
					<form:form role="form" action="checkout-5" method="post" modelAttribute="wrapUserCard">
					
					<div class="col-xs-12 col-sm-12">
						<div class="w100 clearfix" style="height: 12%;">
							<ul class="orderStep orderStepLook2">
								<li>
									<a href="checkout-1"> <i class="fa fa-map-marker "></i>
										<span> address</span>
									</a>
								</li>
								<li class="active"><a href="checkout-4"><i
										class="fa fa-money  "> </i><span>Payment</span> </a>
								</li>
								<li>
									<a href="checkout-5"><i class="fa fa-check-square ">
									</i><span>Order</span></a>
								</li>
							</ul>
							<!--orderStep-->
						</div>
						<div class="w100 clearfix">
							<div class="row userInfo">
								<div class="col-lg-12">
									<h2 class="block-title-2">Payment method</h2>

									<p>Please select the preferred payment method to use on this order.</p>
									<hr>
								</div>
								<div class="col-xs-12 col-sm-12">
									<div class="paymentBox">
										
										<div class="panel-group paymentMethod" id="accordion">
											
											<div class="panel panel-default">
												<div class="panel-heading panel-heading-custom">
													<h4 class="panel-title">
														<a class="cashOnDelivery" data-toggle="collapse"
															data-parent="#accordion" href="#collapseOne"> <span
															class="numberCircuil">Option 1. </span> <strong>
																Cash on Delivery</strong>
														</a>
													</h4>
												</div>
												<div id="collapseOne" class="panel-collapse collapse">
													<div class="panel-body">
														<h2>
															<p class="required">Sorry ! Cash on delievery is
																currently not available.</p>
														</h2>
														<p>All transactions are secure and encrypted, and we
															never store any kind of data. To know more, please view
															our privacy policy.</p>
														<br> <label class="radio-inline" for="radios-4">
															<input name="radios" id="radios-4" value="4" type="radio"
															disabled="disabled"> Cash On Delivery
														</label>

														<div class="form-group">
															<label for="CommentsOrder">Add Comments About
																Your Order</label>
															<textarea id="CommentsOrder" class="form-control"
																disabled="disabled" name="CommentsOrder" cols="26"
																rows="3"></textarea>
														</div>
														<div class="form-group clearfix">
															<label class="checkbox-inline" for="checkboxes-1">
																<input name="checkboxes" id="checkboxes-1" value="1"
																disabled="disabled" type="checkbox"> I have read
																and agree to the <a href="terms-conditions">Terms &
																	Conditions</a>
															</label>
														</div>
														<div class="pull-right">
															<a href="checkout-5" class="btn btn-primary btn-small disabled">
																Order &nbsp; <i class="fa fa-arrow-circle-right"></i>
															</a>
														</div>
													</div>
												</div>
											</div>
											
											<div class="panel panel-default">
												<div class="panel-heading panel-heading-custom">
													<h4 class="panel-title">
														<a data-toggle="collapse" data-parent="#accordion"
															href="#collapseTwo"> <span class="numberCircuil">Option
																2. </span><strong> PayPal</strong> <span>
																&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
																&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; <img
																src="resources/images/site/payment/paypal-small.png"
																alt="paypal" height="18">
														</span>
														</a>
													</h4>
												</div>
												<div id="collapseTwo" class="panel-collapse collapse">
													<div class="panel-body">
														<h2>
															<p class="required">Sorry ! PayPal is
																currently not available.</p>
														</h2>
														<p>All transactions are secure and encrypted, and we
															never store any kind of data. To know more, please view
															our privacy policy.</p>
														<br> <label class="radio-inline" for="radios-3">
															<input name="radios" id="radios-3" value="4" type="radio" disabled="disabled">
															<img src="resources/images/site/payment/paypal-small.png"
															height="18" alt="paypal"> Checkout with Paypal
														</label>

														<div class="form-group">
															<label for="CommentsOrder2">Add Comments About
																Your Order</label>
															<textarea id="CommentsOrder2" class="form-control" disabled="disabled"
																name="CommentsOrder2" cols="26" rows="3"></textarea>
														</div>
														<div class="form-group clearfix">
															<label class="checkbox-inline" for="checkboxes-0">
																<input name="checkboxes" id="checkboxes-0" value="1" disabled="disabled"
																type="checkbox"> I have read and agree to the <a
																href="terms-conditions">Terms & Conditions</a>
															</label>
														</div>
														<div class="pull-right">
															<a href="checkout-5" class="btn btn-primary btn-small disabled">
																Order &nbsp; <i class="fa fa-arrow-circle-right"></i>
															</a>
														</div>
													</div>
												</div>
											</div>
											
											<div class="panel panel-default">
												<div class="panel-heading panel-heading-custom">
													<h4 class="panel-title">
														<a class="masterCard" data-toggle="collapse"
															data-parent="#accordion" href="#collapseThree"> <span
															class="numberCircuil">Option 3. </span> <strong>
																MasterCard</strong> <span><img class="pull-right"
																src="resources/images/site/payment/master_card.png"
																alt="img" height="30"
																style="margin-top: -5px; margin-right: 74%;"></span>
														</a>
													</h4>
												</div>
												<div id="collapseThree" class="panel-collapse collapse in">
													<div class="panel-body">
														<p>All transactions are secure and encrypted, and we
															neverstor To learn more, please view our privacy policy.</p>
														<br>

														<div class="panel open">
															<div class="creditCard">
																<div class="cartBottomInnerRight paymentCard"></div>
																<span>Supported</span> <span>Credit Cards</span>

																<div class="paymentInput">
																	<form:label path="ccNumber" for="CardNumber">Credit Card Number *</form:label> <br>
																	<form:input path="ccNumber" id="CardNumber" type="text" name="Number" style="width: 33%;" maxlength="16"></form:input>
																</div>
																<!--paymentInput-->
																<div class="paymentInput">
																	<form:label path="ccOnName" for="CardNumber2">Name on Credit Card *</form:label>
																	<br> <form:input type="text" path="ccOnName" name="CardNumber2" style="width: 33%;"
																		id="CardNumber2"></form:input>
																</div>
																<!--paymentInput-->
																<div class="paymentInput">
																	<div class="form-group">
																		<label for="">Expiration date *</label> <br>

																		<div
																			class="col-lg-4 col-md-4 col-sm-4 no-margin-left no-padding">
																			<form:select class="form-control" required="required" path="ccExpirationMonth"
																				aria-required="true" name="expire">
																				<option value="">Month</option>
																				<option value="1">01 - January</option>
																				<option value="2">02 - February</option>
																				<option value="3">03 - March</option>
																				<option value="4">04 - April</option>
																				<option value="5">05 - May</option>
																				<option value="6">06 - June</option>
																				<option value="7">07 - July</option>
																				<option value="8">08 - August</option>
																				<option value="9">09 - September</option>
																				<option value="10">10 - October</option>
																				<option value="11">11 - November</option>
																				<option value="12">12 - December</option>
																			</form:select>
																		</div>
																		<div class="col-lg-4 col-md-4 col-sm-4">
																			<form:select class="form-control" required="required" path="ccExpirationYear"
																				aria-required="true" name="year">
																				<option value="">Year</option>
																				<option value="2013">2013</option>
																				<option value="2014">2014</option>
																				<option value="2015">2015</option>
																				<option value="2016">2016</option>
																				<option value="2017">2017</option>
																				<option value="2018">2018</option>
																				<option value="2019">2019</option>
																				<option value="2020">2020</option>
																				<option value="2021">2021</option>
																				<option value="2022">2022</option>
																				<option value="2023">2023</option>
																			</form:select>
																		</div>
																	</div>
																</div>
																<!--paymentInput-->

																<div style="clear: both"></div>
																<br>
																<div class="paymentInput clearfix">
																	<form:label for="VerificationCode" path="ccCvvNumber">CVV
																		*</form:label> <br> 
																	<form:input type="text" id="VerificationCode" path="ccCvvNumber"
																		name="VerificationCode" style="width: 90px;"></form:input>
																	<br>
																</div>
																<!--paymentInput-->

																<!-- <div>
																	<input type="checkbox" name="saveInfo" id="saveInfoid">
																	<label for="saveInfoid">&nbsp;Save my Card
																		information</label>
																</div> -->
															</div>
															<!--creditCard-->

															<div class="pull-right">
																<button class="btn btn-primary btn-small ">
																	Order &nbsp; <i class="fa fa-arrow-circle-right"></i>
																</button>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>

									<!--/row-->

								</div>
							</div>
						</div>
						<!--/row end-->

						<div class="cartFooter w100">
							<div class="box-footer">
								<div class="pull-left">
									<a class="btn btn-default" href="checkout-3"> <i
										class="fa fa-arrow-left"></i> &nbsp; Billing address
									</a>
								</div>
							</div>
						</div>
					</div>
					</form:form>

					<!--/ cartFooter -->

				</div>
			</div>
			<!--/row end-->

			<div class="col-lg-3 col-md-3 col-sm-12 rightSidebar">
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
	<!-- /.main-container -->
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
							<li><a href="#"> Men's </a></li>
							<li><a href="#"> Women's</a></li>
							<li><a href="#"> Kids' </a></li>
							<li><a href="#">Shoes </a></li>
							<li><a href="#"> Gift Cards </a></li>

						</ul>

					</div>

					<div style="clear: both" class="hide visible-xs"></div>

					<div class="col-lg-2  col-md-2 col-sm-4 col-xs-6">
						<h3>Information</h3>
						<ul class="list-unstyled footer-nav">
							<li><a href="#">Questions? </a></li>

							<li><a href="#"> Order Status </a></li>
							<li><a href="#"> Sizing Charts </a></li>
							<li><a href="#"> Return Policy </a></li>
							<li><a href="#"> Contact Us </a></li>

						</ul>
					</div>
					<div class="col-lg-2  col-md-2 col-sm-4 col-xs-6">
						<h3>My Account</h3>
						<ul>
							<li><a href="account"> My Account </a></li>
							<li><a href="my-address"> My Address </a></li>
							<li><a href="wishlist"> Wish List </a></li>
							<li><a href="order-list"> Order list </a></li>
							<li><a href="order-status"> Order Status </a></li>
						</ul>
					</div>

					<div style="clear: both" class="hide visible-xs"></div>

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
				<!--/.row-->
			</div>
			<!--/.container-->
		</div>
		<!--/.footer-->

		<div class="footer-bottom">
			<div class="container">
				<p class="pull-left">&copy; TSHOP 2014. All right reserved.</p>

				<div class="pull-right paymentMethodImg">
					<img height="30" class="pull-right"
						src="resources/images/site/payment/master_card.png" alt="img">
					<img height="30" class="pull-right"
						src="resources/images/site/payment/visa_card.png" alt="img"><img
						height="30" class="pull-right"
						src="resources/images/site/payment/paypal.png" alt="img"> <img
						height="30" class="pull-right"
						src="resources/images/site/payment/american_express_card.png"
						alt="img"> <img height="30" class="pull-right"
						src="resources/images/site/payment/discover_network_card.png"
						alt="img"> <img height="30" class="pull-right"
						src="resources/images/site/payment/google_wallet.png" alt="img">

				</div>
			</div>
		</div>
		<!--/.footer-bottom-->
	</footer>
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
