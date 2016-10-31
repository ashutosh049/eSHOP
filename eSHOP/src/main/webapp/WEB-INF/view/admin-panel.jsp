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


    <!-- styles needed by swiper slider -->
    <link href="resources/assets/plugins/swiper-master/css/swiper.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="resources/assets/css/style.css" rel="stylesheet">
    <link href="resources/assets/css/home-v7.css" rel="stylesheet">
    <link href="resources/assets/css/cart-nav.css" rel="stylesheet">


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

<!-- search-overly -->
<jsp:include page="admin-contents/search-overly.jsp"/>
<!-- /search-overly -->

<!-- menu-sidebar -->
<jsp:include page="admin-contents/menu-sidebar.jsp"/>
<!-- /menu-sidebar -->

<!-- /.cart-sidebar -->
<%-- <jsp:include page="admin-contents/cart-sidebar.jsp"/> --%>
<!-- /.cart-sidebar -->

<!-- Fixed navbar start -->
<jsp:include page="admin-contents/fixed-navbar-admin.jsp"/>
<!-- /.Fixed navbar  -->

<!-- /.slider-hero-wrapper  -->
<jsp:include page="admin-contents/slider-hero-wrapper.jsp"/>
<!-- /.slider-hero-wrapper  -->


<section class="section-hero-parallax parallax-section " id="hero-parallax"
         style="background-image: url(images/parallax/7.jpg);
background-size: cover">
    <div class="overly-shade">
        <div class="container">

            <div class="hero-parallax-content ">
                <h3 class="hero-section-title"> Summer Textures </h3>
                <a class="btn btn-stroke thin lite" href="category">Start Shopping Now</a>
            </div>
        </div>
    </div>
</section>

<section class="section-hero hide" id="TheCollection">
    <div class="container">

        <div class="hero-section-header ">
            <h3 class="hero-section-title">The collection</h3>

            <p class="hero-section-sub-text">This season, classic pinstripes make a comeback both on and off the court.
                <br>
                Introducing the Lacoste Live Pinstripes on the Court Collection.</p>
        </div>

        <div class="row featuredPostContainer ">
            <div class="featuredImageLook3 flat">
                <div class="col-md-3 col-sm-4 col-xs-4 col-xs-min-12">
                    <div class="inner">
                        <div class="box-content-overly box-content-overly-white flat">
                            <div class="box-text-table">
                                <div class="box-text-cell ">
                                    <div class="box-text-cell-inner dark">
                                        <h1 class="uppercase">Handbags</h1>
                                        <hr class="submini">
                                        <a href="category2" class="btn btn-flat btn-dark btn-sm"> SHOP NOW</a></div>
                                </div>
                            </div>
                        </div>
                        <!--/.box-content-overly -->
                        <div class="img-title"> Handbags</div>
                        <a href="category2" class="img-block"> <img alt="img" src="resources/images/look3/2.jpg"
                                                            class="img-responsive"></a>
                    </div>
                </div>
                <div class="col-md-3 col-sm-4 col-xs-4 col-xs-min-12">
                    <div class="inner">
                        <div class="box-content-overly box-content-overly-white flat">
                            <div class="box-text-table">
                                <div class="box-text-cell ">
                                    <div class="box-text-cell-inner dark">
                                        <h1 class="uppercase"> Designers</h1>
                                        <hr class="submini">
                                        <a href="category2" class="btn btn-flat btn-dark btn-sm"> SHOP NOW</a></div>
                                </div>
                            </div>
                        </div>
                        <!--/.box-content-overly -->
                        <div class="img-title"> Designers</div>
                        <a href="category2" class="img-block"> <img alt="img" src="resources/images/look3/1.jpg"
                                                            class="img-responsive"></a>
                    </div>
                </div>
                <div class="col-md-3 col-sm-4 col-xs-4 col-xs-min-12">
                    <div class="inner">
                        <div class="box-content-overly box-content-overly-white flat">
                            <div class="box-text-table">
                                <div class="box-text-cell ">
                                    <div class="box-text-cell-inner dark">
                                        <h1 class="uppercase">Sale Offers</h1>

                                        <hr class="submini">
                                        <a href="category2" class="btn btn-flat btn-dark btn-sm"> SHOP NOW</a></div>
                                </div>
                            </div>
                        </div>
                        <!--/.box-content-overly -->
                        <div class="img-title"> Sale Offers</div>
                        <a href="category2" class="img-block"> <img alt="img" src="resources/images/look3/3.jpg"
                                                            class="img-responsive"></a>
                    </div>
                </div>
                <div class="col-md-3 col-sm-4 col-xs-4 col-xs-min-12">
                    <div class="inner">
                        <div class="box-content-overly box-content-overly-white flat">
                            <div class="box-text-table">
                                <div class="box-text-cell ">
                                    <div class="box-text-cell-inner dark">
                                        <h1 class="uppercase">T Collections</h1>

                                        <hr class="submini">
                                        <a href="category2" class="btn btn-flat btn-dark btn-sm"> SHOP NOW</a></div>
                                </div>
                            </div>
                        </div>
                        <!--/.box-content-overly -->
                        <div class="img-title">T Collections</div>
                        <a href="category2" class="img-block"> <img alt="img" src="resources/images/look3/4.jpg"
                                                            class="img-responsive"></a>
                    </div>
                </div>
                <div class="col-md-3 col-sm-4 col-xs-4 col-xs-min-12">
                    <div class="inner">
                        <div class="box-content-overly box-content-overly-white flat">
                            <div class="box-text-table">
                                <div class="box-text-cell ">
                                    <div class="box-text-cell-inner dark">
                                        <h1 class="uppercase">Latest Trends </h1>
                                        <hr class="submini">
                                        <a href="category2" class="btn btn-flat btn-dark btn-sm"> SHOP NOW</a></div>
                                </div>
                            </div>
                        </div>
                        <!--/.box-content-overly -->
                        <div class="img-title"> Latest Trends</div>
                        <a href="category2" class="img-block"> <img alt="img" src="resources/images/look3/5.jpg"
                                                            class="img-responsive"></a>
                    </div>
                </div>
                <div class="col-md-3 col-sm-4 col-xs-4 col-xs-min-12">
                    <div class="inner">
                        <div class="box-content-overly box-content-overly-white flat">
                            <div class="box-text-table">
                                <div class="box-text-cell ">
                                    <div class="box-text-cell-inner dark">
                                        <h1 class="uppercase">Dresses</h1>

                                        <hr class="submini">
                                        <a href="category2" class="btn btn-flat btn-dark btn-sm"> SHOP NOW</a></div>
                                </div>
                            </div>
                        </div>
                        <!--/.box-content-overly -->
                        <div class="img-title"> Dresses</div>
                        <a href="category2" class="img-block"> <img alt="img" src="resources/images/look3/6.jpg"
                                                            class="img-responsive"></a>
                    </div>
                </div>
                <div class="col-md-3 col-sm-4 col-xs-4 col-xs-min-12">
                    <div class="inner">
                        <div class="box-content-overly box-content-overly-white flat">
                            <div class="box-text-table">
                                <div class="box-text-cell ">
                                    <div class="box-text-cell-inner dark">
                                        <h1 class="uppercase">Dresses</h1>

                                        <hr class="submini">
                                        <a href="category2" class="btn btn-flat btn-dark btn-sm"> SHOP NOW</a></div>
                                </div>
                            </div>
                        </div>
                        <!--/.box-content-overly -->
                        <div class="img-title"> Dresses</div>
                        <a href="category2" class="img-block"> <img alt="img" src="resources/images/category/3.jpg"
                                                            class="img-responsive"></a>
                    </div>
                </div>
                <div class="col-md-3 col-sm-4 col-xs-4 col-xs-min-12">
                    <div class="inner">
                        <div class="box-content-overly box-content-overly-white flat">
                            <div class="box-text-table">
                                <div class="box-text-cell ">
                                    <div class="box-text-cell-inner dark">
                                        <h1 class="uppercase">Dresses</h1>

                                        <hr class="submini">
                                        <a href="category2" class="btn btn-flat btn-dark btn-sm"> SHOP NOW</a></div>
                                </div>
                            </div>
                        </div>
                        <!--/.box-content-overly -->
                        <div class="img-title"> Dresses</div>
                        <a href="category2" class="img-block"> <img alt="img" src="resources/images/category/1.jpg"
                                                            class="img-responsive"></a>
                    </div>
                </div>
            </div>
            <!--/.featuredImageLook3-->
        </div>


    </div>
</section>



<!-- Footer  -->
<jsp:include page="admin-contents/admin-footer.jsp"/>
<!-- / Footer  -->


<!-- Le javascript
================================================== -->

<!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript" src="resources/assets/js/jquery/jquery-1.10.1.min.js"></script>
<script src="resources/assets/bootstrap/js/bootstrap.min.js"></script>
<script src="resources/assets/plugins/swiper-master/js/swiper.jquery.min.js"></script>
<script>

    var swiper = new Swiper('.swiper-container', {
        pagination: '.swiper-pagination',
        paginationClickable: '.swiper-pagination',
        nextButton: '.arrow-right',
        prevButton: '.arrow-left',
        // effect: 'cube',
        keyboardControl: true,
        parallax: true,
        speed: 600,
        spaceBetween: 0
    });


</script>

<!-- include jqueryCycle plugin -->
<script src="resources/assets/js/jquery.cycle2.min.js"></script>

<!-- include easing plugin -->
<script src="resources/assets/js/jquery.easing.1.3.js"></script>

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

<!-- include custom script for only homepage  -->
<script src="resources/assets/js/home.js"></script>

<!-- include custom script for site  -->
<script src="resources/assets/js/script.js"></script>

<script src="resources/assets/js/sidebar-nav.js"></script>


<!-- scrollme || onscroll parallax effect for category page  -->
<script src="resources/assets/js/jquery.scrollme.min.js"></script>
<script src="resources/assets/js/wrap-admin.js"></script>
<script type="text/javascript">


    $(function () {
        var target = $("div.has-overly-shade"),
                targetHeight = target.outerHeight();
        $(document).scroll(function () {
            var scrollPercent = (targetHeight - window.scrollY) / targetHeight;
            scrollPercent >= 0 && (target.css("background-color", "rgba(0,0,0," + (1.1 - scrollPercent) + ")"))
        })
    });


    $(function () {
        if (navigator.userAgent.match(/(iPod|iPhone|iPad|Android)/)) {
            $('#ios-notice').removeClass('hidden');
            $('.parallax-container').height($(window).height() * 0.5 | 0);
        } else {
            $(window).resize(function () {
                var parallaxHeight = Math.max($(window).height() * 0.7, 200) | 0;
                $('.parallax-container').height(parallaxHeight);
            }).trigger('resize');
        }
    });


    $(document).ready(function () {
        var isMobile = function () {
            //console.log("Navigator: " + navigator.userAgent);
            return /(iphone|ipod|ipad|android|blackberry|windows ce|palm|symbian)/i.test(navigator.userAgent);
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
