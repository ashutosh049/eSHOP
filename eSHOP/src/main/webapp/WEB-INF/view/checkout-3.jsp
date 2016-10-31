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
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="resources/assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="resources/assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="resources/assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="ico/apple-touch-icon-57-precomposed.png">
    <link rel="shortcut icon" href="resources/assets/ico/favicon.png">
    <title>TSHOP - Bootstrap E-Commerce Parallax Theme</title>

    <!-- Bootstrap core CSS -->
    <link href="resources/assets/bootstrap/css/bootstrap.css" rel="stylesheet">

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
                <li class="active"> Checkout</li>
            </ul>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-9 col-md-9 col-sm-7 col-xs-6 col-xxs-12 text-center-xs">
            <h1 class="section-title-inner"><span><i class="glyphicon glyphicon-shopping-cart"></i> Checkout</span></h1>
        </div>
        <div class="col-lg-3 col-md-3 col-sm-5 rightSidebar col-xs-6 col-xxs-12 text-center-xs">
            <h4 class="caps"><a href="category"><i class="fa fa-chevron-left"></i> Back to shopping </a></h4>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-9 col-md-9 col-sm-12">
            <div class="row userInfo">
                <div class="col-xs-12 col-sm-12">
                    <div class="w100 clearfix" style="height: 12%;">
                        <ul class="orderStep orderStepLook2">
                            <li><a href="checkout-1"> <i class="fa fa-map-marker "></i> <span> address</span> </a>
                            </li>
                            <li><a href="checkout-2"> <i class="fa fa fa-envelope  "></i>
                                <span> Billing </span></a></li>
                            <li class="active"><a href="checkout-3"><i
                                    class="fa fa-truck "> </i><span>Shipping</span> </a></li>
                            <li><a href="checkout-4"><i class="fa fa-money  "> </i><span>Payment</span> </a></li>
                            <li><a href="checkout-5"><i class="fa fa-check-square "> </i><span>Order</span></a>
                            </li>
                        </ul>
                        <!--/orderStep-->
                    </div>
                    <div class="w100 clearfix">
                        <div class="row userInfo">
                            <div class="col-lg-12">
                                <h2 class="block-title-2"> Choose your delivery method </h2>
                            </div>
                            <div class="col-xs-12 col-sm-12">
                                <div class="w100 row">
                                    <div class="form-group col-lg-4 col-sm-4 col-md-4 -col-xs-12">
                                        <label for="id_country">Country</label>
                                        <select class="form-control" required aria-required="true" id="id_country"
                                                name="id_country">
                                            <option value="">Choose</option>
                                            <option value="38">Algeria</option>
                                            <option value="39">American Samoa</option>
                                            <option value="40">Andorra</option>
                                            <option value="41">Angola</option>
                                            <option value="42">Anguilla</option>
                                            <option value="43">Antigua and Barbuda</option>
                                            <option value="44">Argentina</option>
                                            <option value="45">Armenia</option>
                                            <option value="46">Aruba</option>
                                            <option value="24">Australia</option>
                                            <option value="2">Austria</option>
                                            <option value="47">Azerbaijan</option>
                                            <option value="48">Bahamas</option>
                                            <option value="49">Bahrain</option>
                                            <option value="50">Bangladesh</option>
                                            <option value="3">Belgium</option>
                                            <option value="34">Bolivia</option>
                                            <option value="4">Canada</option>
                                            <option value="5">China</option>
                                            <option value="16">Czech Republic</option>
                                            <option value="20">Denmark</option>
                                            <option value="7">Finland</option>
                                            <option value="8">France</option>
                                            <option value="1">Germany</option>
                                            <option value="9">Greece</option>
                                            <option value="22">HongKong</option>
                                            <option value="26">Ireland</option>
                                            <option value="29">Israel</option>
                                            <option value="10">Italy</option>
                                            <option value="32">Ivory Coast</option>
                                            <option value="11">Japan</option>
                                            <option value="12">Luxemburg</option>
                                            <option value="35">Mauritius</option>
                                            <option value="13">Netherlands</option>
                                            <option value="27">New Zealand</option>
                                            <option value="31">Nigeria</option>
                                            <option value="23">Norway</option>
                                            <option value="14">Poland</option>
                                            <option value="15">Portugal</option>
                                            <option value="36">Romania</option>
                                            <option value="25">Singapore</option>
                                            <option value="37">Slovakia</option>
                                            <option value="30">South Africa</option>
                                            <option value="28">South Korea</option>
                                            <option value="6">Spain</option>
                                            <option value="18">Sweden</option>
                                            <option value="19">Switzerland</option>
                                            <option value="33">Togo</option>
                                            <option value="17">United Kingdom</option>
                                            <option selected="selected" value="21">United States</option>
                                        </select>
                                    </div>
                                    <div id="states" class="form-group  col-lg-4 col-sm-4 col-md-4 -col-xs-12">
                                        <label for="id-state">State</label>
                                        <select class="form-control" required aria-required="true" id="id-state"
                                                name="id-state">
                                            <option value="">Choose</option>
                                            <option value="1">Alabama</option>
                                            <option value="2">Alaska</option>
                                            <option value="3">Arizona</option>
                                            <option value="4">Arkansas</option>
                                            <option value="5">California</option>
                                            <option value="6">Colorado</option>
                                            <option value="7">Connecticut</option>
                                            <option value="8">Delaware</option>
                                            <option value="9">Florida</option>
                                            <option value="10">Georgia</option>
                                            <option value="11">Hawaii</option>
                                            <option value="12">Idaho</option>
                                            <option value="13">Illinois</option>
                                            <option value="14">Indiana</option>
                                            <option value="15">Iowa</option>
                                            <option value="16">Kansas</option>
                                            <option value="17">Kentucky</option>
                                            <option value="18">Louisiana</option>
                                            <option value="19">Maine</option>
                                            <option value="20">Maryland</option>
                                            <option value="21">Massachusetts</option>
                                            <option value="22">Michigan</option>
                                            <option value="23">Minnesota</option>
                                            <option value="24">Mississippi</option>
                                            <option value="25">Missouri</option>
                                            <option value="26">Montana</option>
                                            <option value="27">Nebraska</option>
                                            <option value="28">Nevada</option>
                                            <option value="29">New Hampshire</option>
                                            <option value="30">New Jersey</option>
                                            <option value="31">New Mexico</option>
                                            <option value="32">New York</option>
                                            <option value="33">North Carolina</option>
                                            <option value="34">North Dakota</option>
                                            <option value="35">Ohio</option>
                                            <option value="36">Oklahoma</option>
                                            <option value="37">Oregon</option>
                                            <option value="38">Pennsylvania</option>
                                            <option value="39">Rhode Island</option>
                                            <option value="40">South Carolina</option>
                                            <option value="41">South Dakota</option>
                                            <option value="42">Tennessee</option>
                                            <option value="43">Texas</option>
                                            <option value="44">Utah</option>
                                            <option value="45">Vermont</option>
                                            <option value="46">Virginia</option>
                                            <option value="47">Washington</option>
                                            <option value="48">West Virginia</option>
                                            <option value="49">Wisconsin</option>
                                            <option value="50">Wyoming</option>
                                            <option value="51">Puerto Rico</option>
                                            <option value="52">US Virgin Islands</option>
                                            <option value="53">District of Columbia</option>
                                        </select>
                                    </div>
                                    <div class="form-group  col-lg-4 col-sm-4 col-md-4 -col-xs-12">
                                        <label for="zipcode">Zip Code</label>
                                        <input type="text" id="zipcode" name="zipcode" class="form-control">
                                        (Needed for certain carriers.)
                                    </div>
                                    <div class="form-group col-lg-12 col-sm-12 col-md-12 -col-xs-12">
                                        <table style="width:100%" class="table-bordered table tablelook2">
                                            <tbody>
                                            <tr>
                                                <td> Carrier</td>
                                                <td>Method</td>
                                                <td>Information</td>
                                                <td>Price!</td>
                                            </tr>
                                            <tr>
                                                <td><label class="radio">
                                                    <input type="radio" name="optionsRadios" id="optionsRadios1"
                                                           value="option1" checked>
                                                    <i class="fa  fa-plane fa-2x"></i> </label></td>
                                                <td> By Road</td>
                                                <td>Pick up in-store</td>
                                                <td>Free!</td>
                                            </tr>
                                            <tr>
                                                <td><label class="radio">
                                                    <input type="radio" name="optionsRadios" id="optionsRadios2"
                                                           value="option2">
                                                    <i class="fa fa-truck fa-2x"></i> </label></td>
                                                <td>By Air</td>
                                                <td>Delivery next day!</td>
                                                <td>Free!</td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                                <!--/row-->

                                <div class="cartFooter w100">
                                    <div class="box-footer">
                                        <div class="pull-left"><a class="btn btn-default" href="checkout-2"> <i
                                                class="fa fa-arrow-left"></i> &nbsp; Shipping address </a></div>
                                        <div class="pull-right"><a href="checkout-4"
                                                                   class="btn btn-primary btn-small "> Payment Method
                                            &nbsp; <i class="fa fa-arrow-circle-right"></i> </a></div>
                                    </div>
                                </div>
                                <!--/ cartFooter -->

                            </div>
                        </div>
                    </div>
                    <!--/row end-->

                </div>
            </div>
        </div>
        <!--/row end-->

        <div class="col-lg-3 col-md-3 col-sm-12 rightSidebar">
            <div class="w100 cartMiniTable">
                <table id="cart-summary" class="std table">
                    <tbody>
                    <tr>
                        <td>Total products</td>
                        <td class="price">$216.51</td>
                    </tr>
                    <tr style="">
                        <td>Shipping</td>
                        <td class="price"><span class="success">Free shipping!</span></td>
                    </tr>
                    <tr class="cart-total-price ">
                        <td>Total (tax excl.)</td>
                        <td class="price">$216.51</td>
                    </tr>
                    <tr>
                        <td>Total tax</td>
                        <td class="price" id="total-tax">$0.00</td>
                    </tr>
                    <tr>
                        <td> Total</td>
                        <td class=" site-color" id="total-price">$216.51</td>
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

    <div style="clear:both"></div>

</div>
<!-- /main-container -->


<div class="gap"></div>


<footer>
    <div class="footer">
        <div class="container">
            <div class="row">
                <div class="col-lg-3  col-md-3 col-sm-4 col-xs-6">
                    <h3> Support </h3>
                    <ul>
                        <li class="supportLi">
                            <p> Lorem ipsum dolor sit amet, consectetur </p>
                            <h4><a class="inline" href="callto:+12025550151"> <strong> <i class="fa fa-phone"> </i> +1-202-555-0151 </strong> </a></h4>
                            <h4><a class="inline" href="mailto:help@yourweb.com"> <i class="fa fa-envelope-o"> </i>
                                help@yourweb.com </a></h4>
                        </li>
                    </ul>
                </div>
                <div class="col-lg-2  col-md-2 col-sm-4 col-xs-6">
                    <h3> Shop </h3>
                    <ul>
                        <li><a href="#">
                            Men's
                        </a></li>
                        <li><a href="#">
                            Women's</a></li>
                        <li><a href="#">
                            Kids'
                        </a></li>
                        <li><a href="#">Shoes
                        </a></li>
                        <li><a href="#">
                            Gift Cards
                        </a></li>

                    </ul>

                </div>

                <div style="clear:both" class="hide visible-xs"></div>

                <div class="col-lg-2  col-md-2 col-sm-4 col-xs-6">
                    <h3> Information </h3>
                    <ul class="list-unstyled footer-nav">
                        <li><a href="#">Questions?
                        </a></li>

                        <li><a href="#"> Order Status
                        </a></li>
                        <li><a href="#"> Sizing Charts
                        </a></li>
                        <li><a href="#"> Return Policy </a></li>
                        <li><a href="#">
                            Contact Us
                        </a></li>

                    </ul>
                </div>
                <div class="col-lg-2  col-md-2 col-sm-4 col-xs-6">
                    <h3> My Account </h3>
                    <ul>
                        <li><a href="account"> My Account </a></li>
                        <li><a href="my-address"> My Address </a></li>
                        <li><a href="wishlist"> Wish List </a></li>
                        <li><a href="order-list"> Order list </a></li>
                        <li><a href="order-status"> Order Status </a></li>
                    </ul>
                </div>

                <div style="clear:both" class="hide visible-xs"></div>

                <div class="col-lg-3  col-md-3 col-sm-6 col-xs-12 ">
                    <h3> Stay in touch </h3>
                    <ul>
                        <li>
                            <div class="input-append newsLatterBox text-center">
                                <input type="text" class="full text-center" placeholder="Email ">
                                <button class="btn  bg-gray" type="button"> Subscribe <i
                                        class="fa fa-long-arrow-right"> </i></button>
                            </div>
                        </li>
                    </ul>
                    <ul class="social">
                        <li><a href="http://facebook.com"> <i class=" fa fa-facebook"> &nbsp; </i> </a></li>
                        <li><a href="http://twitter.com"> <i class="fa fa-twitter"> &nbsp; </i> </a></li>
                        <li><a href="https://plus.google.com"> <i class="fa fa-google-plus"> &nbsp; </i> </a></li>
                        <li><a href="http://youtube.com"> <i class="fa fa-pinterest"> &nbsp; </i> </a></li>
                        <li><a href="http://youtube.com"> <i class="fa fa-youtube"> &nbsp; </i> </a></li>
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
            <p class="pull-left"> &copy; TSHOP 2014. All right reserved. </p>

            <div class="pull-right paymentMethodImg"><img height="30" class="pull-right"
                                                          src="resources/images/site/payment/master_card.png" alt="img"> <img
                    height="30" class="pull-right" src="resources/images/site/payment/visa_card.png" alt="img"><img height="30"
                                                                                                          class="pull-right"
                                                                                                          src="resources/images/site/payment/paypal.png"
                                                                                                          alt="img">
                <img height="30" class="pull-right" src="resources/images/site/payment/american_express_card.png" alt="img"> <img
                        height="30" class="pull-right" src="resources/images/site/payment/discover_network_card.png" alt="img">
                <img height="30" class="pull-right" src="resources/images/site/payment/google_wallet.png" alt="img">

            </div>
        </div>
    </div>
    <!--/.footer-bottom-->
</footer>
<!-- Le javascript
================================================== -->

<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js">
</script>
<script src="resources/assets/bootstrap/js/bootstrap.min.js"></script>
<!-- include  parallax plugin -->
<script type="text/javascript" src="resources/assets/js/jquery.parallax-1.1.js"></script>

<!-- optionally include helper plugins -->
<script type="text/javascript" src="resources/assets/js/helper-plugins/jquery.mousewheel.min.js"></script>

<!-- include mCustomScrollbar plugin //Custom Scrollbar  -->

<script type="text/javascript" src="resources/assets/js/jquery.mCustomScrollbar.js"></script>

<!-- include icheck plugin // customized checkboxes and radio buttons   -->
<script type="text/javascript" src="resources/assets/plugins/icheck-1.x/icheck.min.js"></script>

<!-- include grid.js // for equal Div height  -->
<script src="resources/assets/js/grids.js"></script>

<!-- include carousel slider plugin  -->
<script src="resources/assets/js/owl.carousel.min.js"></script>

<!-- jQuery select2 // custom select   -->
<script src="http://cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/js/select2.min.js"></script>

<!-- include touchspin.js // touch friendly input spinner component   -->
<script src="resources/assets/js/bootstrap.touchspin.js"></script>

<!-- include custom script for site  -->
<script src="resources/assets/js/script.js"></script>
</body>
</html>
