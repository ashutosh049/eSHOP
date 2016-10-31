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
<link rel="shortcut icon" href="resources/assets/ico/favicon.png">
<title>eSHOP</title>
<!-- Bootstrap core CSS -->
<link href="resources/assets/bootstrap/css/bootstrap.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="resources/assets/css/style.css" rel="stylesheet">

<!-- vex -->
	<script src="resources/assets/vex/vex.combined.min.js"></script>
	<script>vex.defaultOptions.className = 'vex-theme-default'</script>
	<link rel="stylesheet" href="resources/assets/vex/vex.css" />
	<link rel="stylesheet" href="resources/assets/vex/vex-theme-default.css" />
	<link rel="stylesheet" href="resources/assets/vex/vex-theme-bottom-right-corner.css" />
	
<!-- /vex -->

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

	<div class="banner">
		<div class="full-container">
			<div class="slider-content">
				<ul id="pager2" class="container">
				</ul>
				<!-- prev/next links -->

				<span class="prevControl sliderControl"> <i
					class="fa fa-angle-left fa-3x "></i></span> <span
					class="nextControl sliderControl"> <i
					class="fa fa-angle-right fa-3x "></i></span>

				<div class="slider slider-v1" data-cycle-swipe=true
					data-cycle-prev=".prevControl" data-cycle-next=".nextControl"
					data-cycle-loader="wait">
					<div class="slider-item slider-item-img1">
						<img src="resources/images/slider/slider0.jpg"  style="width:100%; height:100%"
							class="img-responsive parallaximg sliderImg" alt="img">
					</div>
					<div class="slider-item slider-item-img1">
						<!-- <div class="sliderInfo">
							<div class="container">
								<div class="col-lg-12 col-md-12 col-sm-12 sliderTextFull ">
									<div class="inner text-center">
										<div class="topAnima animated">
											<h1 class="uppercase xlarge">FREE SHIPPING</h1>

											<h3 class="hidden-xs">Free Standard Shipping on Orders
												Over $100</h3>
										</div>
										<a class="btn btn-danger btn-lg bottomAnima animated opacity0">SHOP
											NOW ON TSHOP <span class="arrowUnicode">►</span>
										</a>
									</div>
								</div>
							</div>
						</div> -->
						<img src="resources/images/slider/slider1.jpg"  style="width:100%; height:100%"
							class="img-responsive parallaximg sliderImg" alt="img">
					</div>
					<!--/.slider-item-->

					<div class="slider-item slider-item-img2 ">
						<!-- <div class="sliderInfo">
							<div class="container">
								<div class="col-lg-12 col-md-12 col-sm-12 sliderTextFull  ">
									<div
										class="inner dark maxwidth500 text-center animated topAnima">
										<div class=" ">
											<h1 class="uppercase xlarge">CUSTOM HTML BLOCK</h1>

											<h3 class="hidden-xs">Custom Slides to Your Slider</h3>
										</div>
										<a class="btn btn-danger btn-lg">SHOP NOW ON TSHOP <span
											class="arrowUnicode">►</span></a>
									</div>
								</div>
							</div>
						</div> -->
						<img src="resources/images/slider/slider3.jpg"  style="width:100%; height:100%"
							class="img-responsive parallaximg sliderImg" alt="img">
					</div>
					<!--/.slider-item-->

					<div class="slider-item slider-item-img3 ">
						<div class="sliderInfo">
							<!-- <div class="container">
								<div
									class="col-lg-5 col-md-4 col-sm-6 col-xs-8   pull-left sliderText white hidden-xs">
									<div class="inner">
										<h1>TSHOP JEANS</h1>

										<h3 class="price ">Free Shipping on $100</h3>

										<p class="hidden-xs">Lorem ipsum dolor sit amet,
											consectetuer adipiscing elit, sed diam nonummy nibh euismod
											tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
										<a href="category" class="btn btn-primary">SHOP NOW <span
											class="arrowUnicode">►</span></a>
									</div>
								</div>
							</div> -->
						</div>
						<img src="resources/images/slider/slider4.jpg" style="width:100%; height:100%"
							class="img-responsive parallaximg sliderImg" alt="img">
					</div>
					<!--/.slider-item-->

					<div class="slider-item slider-item-img3">
						<div class="sliderInfo">
							<div class="container">
								<div
									class="col-lg-5 col-md-6 col-sm-5 col-xs-5 pull-left sliderText blankstyle transformRight">
									<div class="inner text-right">
										<img src="resources/images/slider/color.png"
											class="img-responsive" alt="img">
									</div>
								</div>
								<div
									class="col-lg-4 col-md-4 col-sm-5 col-xs-7   pull-left sliderText blankstyle color-white">
									<div class="inner">
										<h1 class="uppercase topAnima animated ">10+ Amazing
											Color Theme</h1>

										<p class="bot tomAnima animated opacity0 hidden-xs">Fully
											responsive bootstrap Ecommerce Template. Available in 10+
											color schemes and easy to set.</p>
									</div>
								</div>
							</div>
						</div>
						<img src="resources/images/slider/6.jpg"
							class="img-responsive parallaximg sliderImg" alt="img">
					</div>
				</div>
				<!--/.slider slider-v1-->
			</div>
			<!--/.slider-content-->
		</div>
		<!--/.full-container-->
	</div>
	<!--/.banner style1-->

	<div class="container main-container">

		<!-- Main component call to action -->

		<div class="row featuredPostContainer globalPadding style2">
			<h3 class="section-title style2 text-center">
				<span>NEW ARRIVALS</span>
			</h3>

			<div id="productslider" class="owl-carousel owl-theme">
				<c:forEach items="${wrapNewAriivalsProductList}" var="wpList">
					<div class="item">
						<div class="product">
							<a class="add-fav tooltipHere" data-toggle="tooltip"
								data-original-title="Add to Wishlist" data-placement="left"
								 href="productDetails?tabId=${wpList.wrapTabId}&
														colId=${wpList.wrapColId}&
														catId=${wpList.wrapCatId}&
														prodId=${wpList.wrapProdId}">
								<i class="glyphicon glyphicon-heart"></i>
							</a>
	
							<div class="image">
								<div class="quickview">
									<a class="btn btn-xs btn-quickview"
										href="productDetails?tabId=${wpList.wrapTabId}&
														colId=${wpList.wrapColId}&
														catId=${wpList.wrapCatId}&
														prodId=${wpList.wrapProdId}">Quick
										View </a>
								</div>
								<a href="productDetails?tabId=${wpList.wrapTabId}&
														colId=${wpList.wrapColId}&
														catId=${wpList.wrapCatId}&
														prodId=${wpList.wrapProdId}"><img
									src="${wpList.wrapProdImagePath}" alt="img"
									class="img-responsive"></a>
	
								<div class="promotion">
									<span class="new-product"> NEW</span> 
										<span class="discount">${wpList.wrapProdDiscountPercent}% OFF</span>
								</div>
							</div>
							<div class="description">
								<h4>
									<a href="productDetails?tabId=${wpList.wrapTabId}&
														colId=${wpList.wrapColId}&
														catId=${wpList.wrapCatId}&
														prodId=${wpList.wrapProdId}">consectetuer adipiscing </a>
								</h4>
	
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
								<span class="size">XL / XXL / S </span>
							</div>
							<div class="price">
								<span>$ ${wpList.wrapProdMarkedPrice}</span>
							</div>
							<div class="action-control">
								<a class="btn btn-primary" href="addToCart?itemTabId=${wpList.wrapTabId}&
														itemColId=${wpList.wrapColId}&
														itemCatId=${wpList.wrapCatId}&
														itemId=${wpList.wrapProdId}&
														itemCount=1&
														itemSize=${wpList.wrapProdSize}"> <span class="add2cart"><i
										class="glyphicon glyphicon-shopping-cart"> </i> Add to cart </span>
								</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<!--/.productslider-->

		</div>
		<!--/.featuredPostContainer-->
	</div>
	<!-- /main container -->

	<div class="parallax-section parallax-image-1">
		<div class="container">
			<div class="row ">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div class="parallax-content clearfix">
						<h1 class="parallaxPrce">$200</h1>

						<h2 class="uppercase">FREE INTERNATIONAL SHIPPING! Get Free
							Shipping Coupons</h2>

						<h3>Energistically develop parallel mindshare rather than
							premier deliverables.</h3>

						<div style="clear: both"></div>
						<a class="btn btn-discover "> <i class="fa fa-shopping-cart"></i>
							SHOP NOW
						</a>
					</div>
				</div>
			</div>
			<!--/.row-->
		</div>
		<!--/.container-->
	</div>
	<!--/.parallax-image-1-->

	<div class="container main-container">


		<!-- Demo Features Content start -->

		<div
			class="morePost row featuredPostContainer style2 globalPaddingTop ">
			<!-- this div is for demo || Please remove it when use this page -->

			<h3 class="section-title style2 text-center">
				<span>NEW FEATURES</span>
			</h3>

			<div class="container">
				<div class="row xsResponse categoryProduct">

					<c:forEach items="${wrapNewFeaturesProductList}" var="wpList">
						<div class="item itemauto col-lg-3 col-md-3 col-sm-6 col-xs-6">
							<div class="product">
								<a class="add-fav tooltipHere" data-toggle="tooltip"
									data-original-title="Add to Wishlist" data-placement="left">
									<i class="glyphicon glyphicon-heart"></i>
								</a>
	
	
								<div class="imageHover">
	
									<div class="promotion">
										<span class="discount">${wpList.wrapProdDiscountPercent} % OFF</span>
									</div>
	
									<div id="carousel-id-1" class="carousel slide"
										data-ride="carousel" data-interval="0">
										<!-- Indicators -->
										<ol class="carousel-indicators">
											<li data-target="#carousel-id-1" data-slide-to="0"
												class="active"></li>
										</ol>
	
										<!-- Wrapper for slides -->
										<div class="carousel-inner" role="listbox">
											<div class="item active">
												<a href="productDetails?tabId=${wpList.wrapTabId}&
														colId=${wpList.wrapColId}&
														catId=${wpList.wrapCatId}&
														prodId=${wpList.wrapProdId}"> <img
													src="${wpList.wrapProdImagePath}" alt="img"
													class="img-responsive "></a>
											</div>
											
										</div>
	
										<!-- Controls -->
										<a class="left carousel-control" href="#carousel-id-1"
											role="button" data-slide="prev"> <span
											class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
											<span class="sr-only">Previous</span>
										</a> <a class="right carousel-control" href="#carousel-id-1"
											role="button" data-slide="next"> <span
											class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
											<span class="sr-only">Next</span>
										</a>
									</div>
	
	
								</div>
	
	
								<div class="description">
									<h4>
										<a href="productDetails?tabId=${wpList.wrapTabId}&
														colId=${wpList.wrapColId}&
														catId=${wpList.wrapCatId}&
														prodId=${wpList.wrapProdId}"> ${wpList.wrapProdName} </a>
									</h4>
	
									<div class="grid-description">
										<p>${wpList.wrapProdDescription}
										</p>
									</div>
									<div class="list-description">
										<p>${wpList.wrapProdDescription}</p>
									</div>
									<span class="size">XL / XXL / S </span>
								</div>
								<div class="price">
									<span>$ ${wpList.wrapProdMarkedPrice}</span>
								</div>
								<div class="action-control">
									<a class="btn btn-primary" href="addToCart?itemTabId=${wpList.wrapTabId}&
														itemColId=${wpList.wrapColId}&
														itemCatId=${wpList.wrapCatId}&
														itemId=${wpList.wrapProdId}&
														itemCount=1&
														itemSize=${wpList.wrapProdSize}"> <span class="add2cart"><i
											class="glyphicon glyphicon-shopping-cart"> </i> Add to cart </span>
									</a>
								</div>
							</div>
						</div>
					</c:forEach>

				</div>
			</div>

		</div>
		<!-- Demo Features Content end -->

		<!-- Main component call to action -->

		<div
			class="morePost row featuredPostContainer style2 globalPaddingTop ">
			<h3 class="section-title style2 text-center">
				<span>FEATURES PRODUCT</span>
			</h3>

			<div class="container">
				<div class="row xsResponse">
					<c:forEach items="${wrapFeaturesProductList}" var="wpList">
						<div class="item col-lg-3 col-md-3 col-sm-4 col-xs-6">
							<div class="product">
								<a class="add-fav tooltipHere" data-toggle="tooltip"
									data-original-title="Add to Wishlist" data-placement="left">
									<i class="glyphicon glyphicon-heart"></i>
								</a>
	
								<div class="image">
									<div class="quickview">
										<a class="btn btn-xs btn-quickview"
											href="productDetails?tabId=${wpList.wrapTabId}&
														colId=${wpList.wrapColId}&
														catId=${wpList.wrapCatId}&
														prodId=${wpList.wrapProdId}">Quick
											View </a>
									</div>
									<a href="product-details"><img
										src="${wpList.wrapProdImagePath}" alt="img"
										class="img-responsive"></a>
	
									<div class="promotion">
										<span class="new-product"> NEW</span> <span class="discount">${wpList.wrapProdDiscountPercent} %
											OFF</span>
									</div>
								</div>
								<div class="description">
									<h4>
										<a href="productDetails?tabId=${wpList.wrapTabId}&
														colId=${wpList.wrapColId}&
														catId=${wpList.wrapCatId}&
														prodId=${wpList.wrapProdId}">${wpList.wrapProdName}</a>
									</h4>
	
									<p>${wpList.wrapProdDescription}
									</p>
									<span class="size">XL / XXL / S </span>
								</div>
								<div class="price">
									<span>$ ${wpList.wrapProdDiscountedPrice}</span> <span class="old-price">$ ${wpList.wrapProdMarkedPrice}</span>
								</div>
								<div class="action-control">
									<a class="btn btn-primary" href="addToCart?itemTabId=${wpList.wrapTabId}&
														itemColId=${wpList.wrapColId}&
														itemCatId=${wpList.wrapCatId}&
														itemId=${wpList.wrapProdId}&
														itemCount=1&
														itemSize=${wpList.wrapProdSize}"> <span class="add2cart"><i
											class="glyphicon glyphicon-shopping-cart"> </i> Add to cart </span>
									</a>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<!-- /.row -->

				<!-- <div class="row">
					<div class="load-more-block text-center">
						<a class="btn btn-thin" href="#"> <i class="fa fa-plus-sign">+</i>
							load more products
						</a>
					</div>
				</div> -->
			</div>
			<!--/.container-->
		</div>
		<!--/.featuredPostContainer-->

		<hr class="no-margin-top">
		
		
		<!-- <div class="width100 section-block ">
			<div class="row featureImg">
				<div class="col-md-3 col-sm-3 col-xs-6">
					<a href="category"><img
						src="resources/images/site/new-collection-1.jpg"
						class="img-responsive" alt="img"></a>
				</div>
				<div class="col-md-3 col-sm-3 col-xs-6">
					<a href="category"><img
						src="resources/images/site/new-collection-2.jpg"
						class="img-responsive" alt="img"></a>
				</div>
				<div class="col-md-3 col-sm-3 col-xs-6">
					<a href="category"><img
						src="resources/images/site/new-collection-3.jpg"
						class="img-responsive" alt="img"></a>
				</div>
				<div class="col-md-3 col-sm-3 col-xs-6">
					<a href="category"><img
						src="resources/images/site/new-collection-4.jpg"
						class="img-responsive" alt="img"></a>
				</div>
			</div>
			/.row
		</div> -->
		<!--/.section-block-->
		
		<!--/.section-block-->

	</div>
	<!--main-container-->

	<div class="parallax-section parallax-image-2">
		<div class="w100 parallax-section-overley">
			<div class="container">
				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
						<div class="parallax-content clearfix">
							<h1 class="xlarge">Trusted Seller 500+</h1>
							<h5 class="parallaxSubtitle">Lorem ipsum dolor sit amet
								consectetuer</h5>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--/.parallax-section-->

	<!-- Product Details Modal  -->
	<!-- Modal -->
	<div class="modal fade" id="productSetailsModalAjax" tabindex="-1"
		role="dialog" aria-labelledby="productSetailsModalAjaxLabel"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content"></div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<!-- End Modal -->


	<!-- Footer -->
	<jsp:include page="contents/footer.jsp" />
	<!-- /Footer -->

	<!-- <div class="modal fade hide" id="modalAds" role="dialog">
		<div class="modal-dialog  modal-bg-1">
			<div class="modal-body-content">
				<a class="close" data-dismiss="modal">x</a>

				<div class="modal-body">
					<div class="col-lg-6 col-sm-8 col-xs-8">
						<h3>
							enter your <br>email to receive
						</h3>

						<p class="discountLg">10% OFF</p>

						<p>We invite you to subscribe to our newsletter and receive
							10% discount.</p>

						<div class="clearfx">
							<form id="newsletter" class="newsletter">
								<input type="text" id="subscribe" name="s"
									placeholder="Enter email">
								<button class="subscribe-btn">Subscribe</button>
							</form>
						</div>

						<p>
							<a href="category" class="link shoplink"> SHOP NOW <i
								class="fa fa-caret-right"> </i>
							</a>
						</p>


					</div>
				</div>

			</div>
		</div>
	</div> -->
	<!-- Le javascript
================================================== -->

	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js">
		
	</script>
	<script src="resources/assets/bootstrap/js/bootstrap.min.js"></script>
	<script>
		// this script required for subscribe modal
		$(window).load(function() {
			// full load
			$('#modalAds').modal('show');
			$('#modalAds').removeClass('hide');
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
	<script src="resources/assets/js/wrap.js"></script>
	
</body>
</html>
