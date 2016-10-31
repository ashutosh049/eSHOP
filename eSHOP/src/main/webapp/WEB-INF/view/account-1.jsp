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
    <link rel="apple-touch-icon-precomposed" sizes="144x144" src="resources/assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" src="resources/assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" src="resources/assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="ico/apple-touch-icon-57-precomposed.png">
    <link rel="shortcut icon" src="resources/assets/ico/favicon.png">
    <title>TSHOP - Bootstrap E-Commerce Parallax Theme</title>

    <!-- Bootstrap core CSS -->
    <link src="resources/assets/bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link src="resources/assets/css/style.css" rel="stylesheet">

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
                <li class="active"> Authentication</li>
            </ul>
        </div>
    </div>

    <div class="row">

        <div class="col-lg-9 col-md-9 col-sm-7">
            <h1 class="section-title-inner"><span><i class="fa fa-lock"></i> Authentication</span></h1>

            <div class="row userInfo">

                <div class="col-xs-12 col-sm-6">
                    <h2 class="block-title-2"> Create an account </h2>

                    <form role="form" class="regForm">
                        <div class="form-group">
                            <label>Name</label>
                            <input title="Please enter your username (at least 3 characters)" type="text"
                                   class="form-control" placeholder="Enter name" required minlength="3">
                        </div>
                        <div class="form-group">
                            <label>Email address</label>
                            <input title="Please enter valid email" type="email" class="form-control"
                                   placeholder="Enter email" required>
                        </div>
                        <div class="form-group">
                            <label>Password</label>
                            <input required minlength="5"
                                   title="Please enter your password, between 5 and 12 characters" type="password"
                                   class="form-control" placeholder="Password">
                        </div>
                        <div class="error">
                        </div>

                        <button type="submit" class="btn   btn-primary"><i class="fa fa-user"></i> Create an account
                        </button>
                    </form>
                </div>
                <div class="col-xs-12 col-sm-6">
                    <h2 class="block-title-2"><span>Already registered?</span></h2>

                    <form role="form" class="logForm ">
                        <div class="form-group">
                            <label>Email address</label>
                            <input type="email" class="form-control" placeholder="Enter email">
                        </div>
                        <div class="form-group">
                            <label>Password</label>
                            <input type="password" class="form-control" placeholder="Password">
                        </div>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" name="checkbox">
                                Remember me </label>
                        </div>
                        <div class="form-group">
                            <p><a title="Recover your forgotten password" href="forgot-password">Forgot your
                                password? </a></p>
                        </div>
                        <a class="btn btn-primary" href="account"><i class="fa fa-sign-in"></i> Sign In</a>


                    </form>
                </div>
            </div>
            <!--/row end-->

        </div>

        <div class="col-lg-3 col-md-3 col-sm-5"></div>
    </div>
    <!--/row-->

    <div style="clear:both"></div>
</div>
<!-- /wrapper -->

<div class="gap"></div>


<!-- Footer -->
	<jsp:include page="contents/footer.jsp" />
	<!-- /Footer -->

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

<!-- include validate.js // jquery plugin   -->
<script src="resources/assets/js/jquery.validate.js"></script>

<script>
    $().ready(function () {
        // validate the comment form when it is submitted
        $("#regForm").validate();

        // validate signup form on keyup and submit
        $(".regForm").validate({
            errorLabelContainer: $(".regForm div.error")
        });
    });
</script>


<!-- include custom script for site  -->
<script src="resources/assets/js/script.js"></script>
</body>
</html>

