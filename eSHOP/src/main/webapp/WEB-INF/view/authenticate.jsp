<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="resources/assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="resources/assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="resources/assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="ico/apple-touch-icon-57-precomposed.png">
    <link rel="shortcut icon" href="resources/assets/ico/favicon.png">
    <title>eSHOP</title>

    <!-- Bootstrap core CSS -->
    <link href="resources/assets/bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="resources/assets/css/style.css" rel="stylesheet">
	<link href="resources/assets/css/sweetalert2.css" rel="stylesheet">
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
    <!-- /.row -->


    <div class="row">

        <div class="col-lg-12 col-md-12  col-sm-12">

            <h1 class="section-title-inner"><span><i class="fa fa-lock"></i> Authentication</span></h1>
			<!-- <span class="label label-success" id="success_msg"></span>
			<span class="label label-danger" id="error_msg"></span> -->
			
			  <c:if test="${errorMessage != null}">
				<div class="alert alert-danger" role="alert">
				  	<strong>Oh snap!</strong> ${errorMessage}
				</div>
			  </c:if>	
			
            <div class="row userInfo">
                <div class="col-xs-12 col-sm-4">
                    <h2 class="block-title-2"> Create an account </h2>
                     <form id="createUserAccount" role="form"  method="post">
                        <div class="form-group">
                            <label for="firstName">First Name</label>
                            <input type="text" class="form-control firstName" id="firstName"></input>
                        </div>
                         <div class="form-group">
                            <label for="lastName">Last Name</label>
                            <input type="text" class="form-control lastName" id="lastName"></input>
                        </div>
                        <div class="form-group">
                            <label for="email">Email address</label>
                            <input type="email" class="form-control email" id="email"></input>
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input type="password" class="form-control password" id="password"></input>
                        </div>
                        <button type="submit" class="btn   btn-primary" class="createUserAccountSbmtBtn"><i class="fa fa-user"></i> Create an account
                        </button>
                    </form>
                </div>


                <div class="col-xs-12 col-sm-4">
                	
                    <h2 class="block-title-2"><span>Already registered?</span></h2>

                    <form role="form" action="login" method="post">
                        <div class="form-group">
                            <label for="Username">Username</label>
                            <input type="text" class="form-control"  id="username" name="username" placeholder="Username">
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" id="password" name="password">
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
                        <button type="submit" class="btn btn-primary"><i class="fa fa-sign-in"></i> Sign In</button>
                    </form>
                </div>
               <!--  <div class="col-xs-12 col-sm-4">
                    <h2 class="block-title-2"><span>Checkout as Guest</span></h2>

                    <p>Don't have an account and you don't want to register? Checkout as a guest instead!</p>
                    <a href="checkout-1-guest" class="btn btn-primary"><i class="fa fa-sign-in"></i> Checkout as
                        Guest</a></div> -->
            </div>
            <!--/row end-->

        </div>
    </div>
    <!--/row-->

    <div style="clear:both"></div>
</div>
<!-- /.main-container -->

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

<!-- include custom script for site  -->
<script src="resources/assets/js/script.js"></script>
<script src="resources/assets/js/sweetalert2.js"></script>
<script src="resources/assets/js/wrap.js"></script>
</body>
</html>

