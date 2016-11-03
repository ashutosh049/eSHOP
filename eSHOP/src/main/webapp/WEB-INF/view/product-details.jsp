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
<title>eSHOP</title>
<!-- Bootstrap core CSS -->
<link href="resources/assets/bootstrap/css/bootstrap.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="resources/assets/css/style.css" rel="stylesheet">


<!-- styles needed by smoothproducts.js for product zoom  -->
<link rel="stylesheet" href="resources/assets/css/smoothproducts.css">


<!-- Just for debugging purposes. -->
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

<!-- include pace script for automatic web page progress bar  -->
<!-- vex -->
	<script src="resources/assets/vex/vex.combined.min.js"></script>
	<script>vex.defaultOptions.className = 'vex-theme-bottom-right-corner'</script>
	<link rel="stylesheet" href="resources/assets/vex/vex.css" />
	<link rel="stylesheet" href="resources/assets/vex/vex-theme-default.css" />
	<link rel="stylesheet" href="resources/assets/vex/vex-theme-bottom-right-corner.css" />
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
					<li><a <a href="category?tabId=${wrapProduct.wrapTabId}&
														colId=${wrapProduct.wrapColId}&
														catId=${wrapProduct.wrapCatId}">${wrapCategory.wrapCatName}</a></li>
					<li class="active">${wrapProduct.wrapProdName}</li>
				</ul>
			</div>
		</div>
		<div class="row transitionfx">

			<!-- left column -->
			<div class="col-lg-6 col-md-6 col-sm-6">
				<!-- product Image and Zoom -->


				<div
					class="main-image sp-wrap col-lg-12 no-padding style2 style2look2">
					<a href="${wrapProduct.wrapProdImagePath.substring(10)}"> <img
						src="${wrapProduct.wrapProdImagePath}" class="img-responsive"
						alt="img">
					</a>
				</div>



				<div class="product-tab w100 clearfix">

					<ul class="nav nav-tabs">
						<li class="active"><a href="#freqBoughtTogeth"
							data-toggle="tab">Frequently bought together</a></li>
						<li><a href="#details" data-toggle="tab">Details</a></li>
						<li><a href="#shipping" data-toggle="tab">Shipping</a></li>
					</ul>

					<!-- Tab panes -->
					<div class="tab-content">
						<form id="addComboToCartForm">
							<div class="tab-pane active" id="freqBoughtTogeth">
								<br>
								<div id="comboItemsList" class="zoomThumb " style="text-align: left;">
									
									<a class="zoomThumbLink comboItems" style="border: none;"
										wrapTabId="${wrapProduct.wrapTabId}"
											wrapColId="${wrapProduct.wrapColId}"
											wrapCatId="${wrapProduct.wrapCatId}"
											wrapProdId="${wrapProduct.wrapProdId}"> <img
										data-large="images/product_details/hi-res-croped/1.jpg"
										src="${wrapProduct.wrapProdImagePath}" alt="Saleen" title="" />
										<div class="price" style="text-align: center;">
											<span class="price-sales"> $
												${wrapProduct.wrapProdDiscountedPrice}</span> <br> <span
												class="price-sales" style="color: #e7711b; font-size: 15px;">(${wrapProduct.wrapProdDiscountPercent}%
												Off)</span> <br>
										</div>
									</a>
	
									<c:forEach items="${freqBaughtTogetherWrapProductList}" var="wpList">
										<i class="fa fa-plus" aria-hidden="true" style="margin-bottom: -11%; color: #e7711b;"> </i>
										<a class="zoomThumbLink comboItems" style="border: none;"
											wrapTabId="${wpList.wrapTabId}"
											wrapColId="${wpList.wrapColId}"
											wrapCatId="${wpList.wrapCatId}"
											wrapProdId="${wpList.wrapProdId}">
											<img data-large="${wpList.wrapProdImagePath}" src="${wpList.wrapProdImagePath}" alt="Saleen" title="" />
											<div class="price" style="text-align: center;">
												<span class="price-sales"> $ ${wpList.wrapProdDiscountedPrice}</span> 
												<br>
												<span class="price-sales" style="color: #e7711b; font-size: 15px;">(${wpList.wrapProdDiscountPercent}% Off)</span>
												 <br>
											</div>
										</a>
									</c:forEach>
	
								</div>
								<br>
								<div class="w100 costDetails">
									<div class="table-block" id="order-detail-content">
										<table class="std table" id="cart-summary">
											<tr>
												<td>Sub Total</td>
												<%-- <td class="price">$ ${freqTotalMarkedPrice}</td> --%>
												<td class="price">$ ${freqTotalDiscountedPrice}</td>
											</tr>
											<tr style="">
												<td>Shipping</td>
												<td class="price"><span class="success">Free
														shipping!</span></td>
											</tr>
											<tr class="cart-total-price ">
												<td>Total Discount (extra 10% Off)</td>
												<td class="price">$ ${freqTotalDiscount}</td>
											</tr>
											<tr>
												<td>Total tax</td>
												<td id="total-tax" class="price">$ ${freqTotalotalTax}</td>
											</tr>
											<tr>
												<td>Total</td>
												<td id="total-price" class="price">$ ${freqTotal}</td>
											</tr>
											<tbody>
											</tbody>
										</table>
									</div>
								</div>
								<br>
								<div class="cart-actions" style="border-bottom: none;">
									<div class="addto row">
										<button class="link-wishlist wishlist btn-block " id="addToCartBtn">
											Add Combo to Cart
										</button>
									</div>
								</div>
							</div>
						</form>
						<div class="tab-pane" id="details">
							16" waist<br> 34" inseam<br> 10.5" front rise<br>
							8.5" knee<br> 7.5" leg opening<br> <br>
							Measurements taken from size 30<br> Model wears size 31.
							Model is 6'2 <br> <br>
						</div>

						<div class="tab-pane" id="shipping">
							<table>
								<colgroup>
									<col style="width: 33%">
									<col style="width: 33%">
									<col style="width: 33%">
								</colgroup>
								<tbody>
									<tr>
										<td>Standard</td>
										<td>1-5 business days</td>
										<td>$7.95</td>
									</tr>
									<tr>
										<td>Two Day</td>
										<td>2 business days</td>
										<td>$15</td>
									</tr>
									<tr>
										<td>Next Day</td>
										<td>1 business day</td>
										<td>$30</td>
									</tr>
								</tbody>
								<tfoot>
									<tr>
										<td colspan="3">* Free on orders of $50 or more</td>
									</tr>
								</tfoot>
							</table>
						</div>

					</div>
					<!-- /.tab content -->

				</div>
			</div>
			<!--/ left column end -->


			<!-- right column -->
			<form id="addToCartForm" action="addToCart" method="post">
				<div class="col-lg-6 col-md-6 col-sm-5">

					<h1 class="product-title">
						${wrapProduct.wrapProdName}
						</h2>

						<h3 class="product-code">Product Code :
							${wrapProduct.wrapProdId}</h3>

						<div class="rating">
							<p>
								<span><i class="fa fa-star"></i></span> <span><i
									class="fa fa-star"></i></span> <span><i class="fa fa-star"></i></span>
								<span><i class="fa fa-star"></i></span> <span><i
									class="fa fa-star-o "></i></span> <span class="ratingInfo"> <span>
										/ </span> <a data-toggle="modal" data-target="#modal-review">
										Write a review</a>
								</span>
							</p>
						</div>
						<div class="product-price">
							<span class="price-sales"> $
								${wrapProduct.wrapProdDiscountedPrice}</span> <span
								class="price-standard">$${wrapProduct.wrapProdMarkedPrice}</span>
							<span class="price-sales" style="color: #e7711b;">(${wrapProduct.wrapProdDiscountPercent}
								% Off)</span>
						</div>

						<div class="details-description">
							<p>${wrapProduct.wrapProdDescription}</p>
						</div>

						<div class="color-details">
							<span class="selected-color"><strong>COLOR</strong></span>
							<ul class="swatches Color">
								<c:if test="${wrapProduct.wrapProdColor=='YELLOW'}">
									<li class="selected"><a style="background-color: #f1f40e">
									</a></li>
									<li><a style="background-color: #adadad"> </a></li>
									<li><a style="background-color: #4EC67F"> </a></li>
								</c:if>
								<c:if test="${wrapProduct.wrapProdColor=='GREY'}">
									<li><a style="background-color: #f1f40e"> </a></li>
									<li class="selected"><a style="background-color: #adadad">
									</a></li>
									<li><a style="background-color: #4EC67F"> </a></li>
								</c:if>
								<c:if test="${wrapProduct.wrapProdColor=='GREEN'}">
									<li><a style="background-color: #f1f40e"> </a></li>
									<li><a style="background-color: #adadad"> </a></li>
									<li class="selected"><a style="background-color: #4EC67F">
									</a></li>
								</c:if>

							</ul>
						</div>
						<!--/.color-details-->

						<div class="productFilter productFilterLook2">
							<div class="row">
								<div class="col-lg-6 col-sm-6 col-xs-6">
									<div class="filterBox">
										<select class="form-control" id="addTocart_quantity" name="itemCount">
											<option value="1" selected>1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
											<option value="6">6</option>
											<option value="7">7</option>
											<option value="8">8</option>
										</select>
									</div>
								</div>
								<div class="col-lg-6 col-sm-6 col-xs-6">
									<div class="filterBox">
										<select class="form-control" id="addTocart_size" name="itemSize">
											<option value="S" selected>S</option>
											<option value="M">M</option>
											<option value="L">L</option>
											<option value="XL">XL</option>
											<option value="XXL">XXL</option>
										</select>
									</div>
								</div>
							</div>
						</div>
						<!-- productFilter -->

						<div class="cart-actions">
							<div class="addto row">
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								
									<input type="hidden" name="itemTabId" id="addTocart_tabId" value="${wrapProduct.wrapTabId}">
									<input type="hidden" name="itemColId" id="addTocart_colId" value="${wrapProduct.wrapColId}">
									<input type="hidden" name="itemCatId" id="addTocart_catId" value="${wrapProduct.wrapCatId}"> 
									<input type="hidden" name="itemId" id="addTocart_prodId" value="${wrapProduct.wrapProdId}">
									<input type="hidden" name="itemColor" id="addTocart_prodColor" value="${wrapProduct.wrapProdColor}">
										
									<!-- onclick="addToCartForm.submit(this);" -->	
									<button type="submit"
										class="button btn-block btn-cart cart first"
										title="Add to Cart" >Add to Cart</button>
									<!-- <a class="link-wishlist wishlist btn-block" href="cart">Add to Cart</a> -->
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<a class="link-wishlist wishlist btn-block">Add to Wishlist</a>
								</div>
							</div>

							<div style="clear: both"></div>

							<h3 class="incaps">
								<i class="fa fa fa-check-circle-o color-in"></i> In stock
							</h3>

							<h3 style="display: none" class="incaps">
								<i class="fa fa-minus-circle color-out"></i> Out of stock
							</h3>

							<h3 class="incaps">
								<i class="glyphicon glyphicon-lock"></i> Secure online ordering
							</h3>
						</div>



						<div style="clear: both"></div>

						<div class="product-share clearfix" style="border-top: none">
							<p>SHARE</p>

							<div class="socialIcon">
								<a href="#"> <i class="fa fa-facebook"></i></a> <a href="#">
									<i class="fa fa-twitter"></i>
								</a> <a href="#"> <i class="fa fa-google-plus"></i></a> <a href="#">
									<i class="fa fa-pinterest"></i>
								</a>
							</div>
						</div>
						<!--/.product-share-->
				</div>
			</form>
			<!--/ right column end -->

		</div>
		<!--/.row-->

		<div class="row recommended">

			<h1>YOU MAY ALSO LIKE</h1>

			<div id="SimilarProductSlider">

				<c:forEach items="${mayAlsoLikeWrapProductList}" var="wpList">
					<div class="item">
						<div class="product">
							<a class="product-image"
								href="productDetails?tabId=${wpList.wrapTabId}&
														colId=${wpList.wrapColId}&
														catId=${wpList.wrapCatId}&
														prodId=${wpList.wrapProdId}">
								<img src="${wpList.wrapProdImagePath}" alt="img">
							</a>
							<div class="description">
								<h4>
									<a
										href="productDetails?tabId=${wpList.wrapTabId}&
														colId=${wpList.wrapColId}&
														catId=${wpList.wrapCatId}&
														prodId=${wpList.wrapProdId}">
										${wpList.wrapProdName} </a>
								</h4>
								<div class="price">
									<span>$${wpList.wrapProdMarkedPrice}</span>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>

			</div>
			<!--/.SimilarProductSlider-->
		</div>
		<!--/.recommended-->


		<div style="clear: both"></div>


	</div>
	<!-- /main-container -->


	<div class="gap"></div>


	<!-- Footer -->
	<jsp:include page="contents/footer.jsp" />
	<!-- /Footer -->


	<!-- Modal review start -->
	<div class="modal  fade" id="modal-review" tabindex="-1" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h3 class="modal-title-site text-center">PRODUCT REVIEW</h3>
				</div>
				<div class="modal-body">

					<h3 class="reviewtitle uppercase">You're reviewing: Lorem
						ipsum dolor sit amet</h3>

					<form>
						<div class="form-group">
							<label> How do you rate this product? </label> <br>

							<div class="rating-here">
								<input type="hidden" class="rating-tooltip-manual"
									data-filled="fa fa-star fa-2x" data-empty="fa fa-star-o fa-2x"
									data-fractions="3" />

							</div>
						</div>
						<div class="form-group">
							<label for="rtext">Name</label> <input type="text"
								class="form-control" id="rtext" placeholder="Your name" required>
						</div>

						<div class="form-group ">
							<label>Review</label>
							<textarea class="form-control" rows="3" placeholder="Your Review"
								required></textarea>

						</div>


						<button type="submit" class="btn btn-success">Submit
							Review</button>
					</form>


				</div>

			</div>
			<!-- /.modal-content -->

		</div>
		<!-- /.modal-dialog -->

	</div>
	<!-- /.Modal review -->

	<!-- Le javascript
================================================== -->

	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js">
		
	</script>

	<!-- jquery-migrate only for product details -->
	<script src="http://code.jquery.com/jquery-migrate-1.2.1.js"></script>

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

	<!-- include custom script for site  -->
	<script src="resources/assets/js/script.js"></script>
	<script src="resources/assets/js/wrap.js"></script>

	<script src="resources/assets/plugins/rating/bootstrap-rating.min.js"></script>
	<script>
		$(function() {

			$('.rating-tooltip-manual').rating({
				extendSymbol : function() {
					var title;
					$(this).tooltip({
						container : 'body',
						placement : 'bottom',
						trigger : 'manual',
						title : function() {
							return title;
						}
					});
					$(this).on('rating.rateenter', function(e, rate) {
						title = rate;
						$(this).tooltip('show');
					}).on('rating.rateleave', function() {
						$(this).tooltip('hide');
					});
				}
			});

		});
	</script>


</body>
</html>
