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
    <title>TSHOP - Bootstrap E-Commerce Parallax Theme </title>

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
                <li><a href="account">My Account</a></li>
                <li class="active"> Add Address</li>
            </ul>
        </div>
    </div>


    <div class="row">
        <div class="col-lg-9 col-md-9 col-sm-7">

            <h1 class="section-title-inner"><span><i class="fa fa-map-marker"></i> Add Your addresses </span></h1>

            <div class="row userInfo">


                <div class="col-lg-12 col-xs-12">
                    <h2 class="block-title-2"> To add a new address, please fill out the form below. </h2>

                    <p class="required"><sup>*</sup> Required field</p>
                </div>

                <form:form action="addNewAddress" method="post" modelAttribute="wrapUserAddress">
					<input type="hidden" value="${wrapUserAddress.country}" id="userCountry"/>
					<input type="hidden" value="${wrapUserAddress.state}" id="userState"/>
					<input type="hidden" value="${wrapUserAddress.additionalinfo}" id="additional_info"/>
					
					<!-- col-1 -->
                    <div class="col-xs-12 col-sm-6">

                        <div class="form-group required">
                            <form:label path="mobilenumber">Mobile phone <sup>*</sup></form:label>
                            <form:input required="required" type="tel" name="mobilenumber" class="form-control" id="mobilenumber" path="mobilenumber"></form:input>
                        </div>

                        <div class="form-group required">
                            <form:label path="addressLine1">Address (Line 1)<sup>*</sup> </form:label>
                            <form:input required="required" type="text" class="form-control" id="addressLine1" path="addressLine1"></form:input>
                        </div>

                        <div class="form-group">
                            <form:label path="city">City </form:label>
                            <form:input type="text" class="form-control" id="city" path="city"></form:input>
                        </div>

                       <div class="form-group required">
                            <form:label path="state">State <sup>*</sup> </form:label>
                            <form:select required="required" aria-required="true" id="state" name="state" path="state">
                               <option value="">Select State</option>
												<option value="AL">Alabama</option>
												<option value="AK">Alaska</option>
												<option value="AZ">Arizona</option>
												<option value="AR">Arkansas</option>
												<option value="CA">California</option>
												<option value="CO">Colorado</option>
												<option value="CT">Connecticut</option>
												<option value="DE">Delaware</option>
												<option value="DC">District of Columbia</option>
												<option value="FL">Florida</option>
												<option value="GA">Georgia</option>
												<option value="HI">Hawaii</option>
												<option value="ID">Idaho</option>
												<option value="IL">Illinois</option>
												<option value="IN">Indiana</option>
												<option value="IA">Iowa</option>
												<option value="KS">Kansas</option>
												<option value="KY">Kentucky</option>
												<option value="LA">Louisiana</option>
												<option value="ME">Maine</option>
												<option value="MD">Maryland</option>
												<option value="MA">Massachusetts</option>
												<option value="MI">Michigan</option>
												<option value="MN">Minnesota</option>
												<option value="MS">Mississippi</option>
												<option value="MO">Missouri</option>
												<option value="MT">Montana</option>
												<option value="NE">Nebraska</option>
												<option value="NV">Nevada</option>
												<option value="NH">New Hampshire</option>
												<option value="NJ">New Jersey</option>
												<option value="NM">New Mexico</option>
												<option value="NY">New York</option>
												<option value="NC">North Carolina</option>
												<option value="ND">North Dakota</option>
												<option value="OH">Ohio</option>
												<option value="OK">Oklahoma</option>
												<option value="OR">Oregon</option>
												<option value="PA">Pennsylvania</option>
												<option value="RI">Rhode Island</option>
												<option value="SC">South Carolina</option>
												<option value="SD">South Dakota</option>
												<option value="TN">Tennessee</option>
												<option value="TX">Texas</option>
												<option value="UT">Utah</option>
												<option value="VT">Vermont</option>
												<option value="VA">Virginia</option>
												<option value="WA">Washington</option>
												<option value="WV">West Virginia</option>
												<option value="WI">Wisconsin</option>
												<option value="WY">Wyoming</option>
                            </form:select>
                        </div>
                        
                         <div class="form-group">
                            <form:label path="additionalinfo">Additional information</form:label>
                            <textarea rows="3" cols="26" name="additionalinfo" class="form-control"
                                      id="additionalinfo" path="additionalinfo"></textarea>
                        </div>

                    </div>

					<!-- col 2 -->
                    <div class="col-xs-12 col-sm-6">
						
						
                        <div class="form-group required">
                            <form:label path="addresstitle">Please assign an address title for future reference. <sup>*</sup></form:label>

                            <form:input required="required" type="text" name="addresstitle" class="form-control"
                                   id="addresstitle" path="addresstitle"></form:input>

                        </div>
						
						 <div class="form-group">
                            <form:label path="addressLine2">Address (Line 2) </form:label>
                            <form:input type="text" class="form-control" id="addressLine2" path="addressLine2"></form:input>
                        </div>

                        <div class="form-group required">
                            <form:label path="postalcode">Zip / Postal Code <sup>*</sup> </form:label>
                            <form:input required="required" type="text" class="form-control" id="postalcode"
                                   path="postalcode"></form:input>
                        </div>
                        
                        <div class="form-group required">
                            <form:label path="country">Country <sup>*</sup> </form:label>
                            <form:select required="required" name="country" id="country" class="form-control" path="country">
                               <option value="">Select Country</option>
												<option value="MH">Marshall Islands</option>
												<option value="MQ">Martinique</option>
												<option value="MR">Mauritania</option>
												<option value="MU">Mauritius</option>
												<option value="YT">Mayotte</option>
												<option value="MX">Mexico</option>
												<option value="FM">Micronesia, Federated States of</option>
												<option value="MD">Moldova, Republic of</option>
												<option value="MC">Monaco</option>
												<option value="MN">Mongolia</option>
												<option value="ME">Montenegro</option>
												<option value="MS">Montserrat</option>
												<option value="MA">Morocco</option>
												<option value="MZ">Mozambique</option>
												<option value="MM">Myanmar</option>
												<option value="NA">Namibia</option>
												<option value="NR">Nauru</option>
												<option value="NP">Nepal</option>
												<option value="NL">Netherlands</option>
												<option value="NC">New Caledonia</option>
												<option value="NZ">New Zealand</option>
												<option value="NI">Nicaragua</option>
												<option value="NE">Niger</option>
												<option value="NG">Nigeria</option>
												<option value="NU">Niue</option>
												<option value="NF">Norfolk Island</option>
												<option value="MP">Northern Mariana Islands</option>
												<option value="NO">Norway</option>
												<option value="OM">Oman</option>
												<option value="PK">Pakistan</option>
												<option value="PW">Palau</option>
												<option value="PS">Palestinian Territory, Occupied</option>
												<option value="PA">Panama</option>
												<option value="PG">Papua New Guinea</option>
												<option value="PY">Paraguay</option>
												<option value="PE">Peru</option>
												<option value="PH">Philippines</option>
												<option value="PN">Pitcairn</option>
												<option value="PL">Poland</option>
												<option value="PT">Portugal</option>
												<option value="PR">Puerto Rico</option>
												<option value="QA">Qatar</option>
												<option value="RE">Réunion</option>
												<option value="RO">Romania</option>
												<option value="RU">Russian Federation</option>
												<option value="RW">Rwanda</option>
												<option value="BL">Saint Barthélemy</option>
												<option value="SH">Saint Helena, Ascension and
													Tristan da Cunha</option>
												<option value="KN">Saint Kitts and Nevis</option>
												<option value="LC">Saint Lucia</option>
												<option value="MF">Saint Martin (French part)</option>
												<option value="PM">Saint Pierre and Miquelon</option>
												<option value="VC">Saint Vincent and the Grenadines</option>
												<option value="WS">Samoa</option>
												<option value="SM">San Marino</option>
												<option value="ST">Sao Tome and Principe</option>
												<option value="SA">Saudi Arabia</option>
												<option value="SN">Senegal</option>
												<option value="RS">Serbia</option>
												<option value="SC">Seychelles</option>
												<option value="SL">Sierra Leone</option>
												<option value="SG">Singapore</option>
												<option value="SX">Sint Maarten (Dutch part)</option>
												<option value="SK">Slovakia</option>
												<option value="SI">Slovenia</option>
												<option value="SB">Solomon Islands</option>
												<option value="SO">Somalia</option>
												<option value="ZA">South Africa</option>
												<option value="GS">South Georgia and the South
													Sandwich Islands</option>
												<option value="SS">South Sudan</option>
												<option value="ES">Spain</option>
												<option value="LK">Sri Lanka</option>
												<option value="SD">Sudan</option>
												<option value="SR">Suriname</option>
												<option value="SJ">Svalbard and Jan Mayen</option>
												<option value="SZ">Swaziland</option>
												<option value="SE">Sweden</option>
												<option value="CH">Switzerland</option>
												<option value="SY">Syrian Arab Republic</option>
												<option value="TW">Taiwan, Province of China</option>
												<option value="TJ">Tajikistan</option>
												<option value="TZ">Tanzania, United Republic of</option>
												<option value="TH">Thailand</option>
												<option value="TL">Timor-Leste</option>
												<option value="TG">Togo</option>
												<option value="TK">Tokelau</option>
												<option value="TO">Tonga</option>
												<option value="TT">Trinidad and Tobago</option>
												<option value="TN">Tunisia</option>
												<option value="TR">Turkey</option>
												<option value="TM">Turkmenistan</option>
												<option value="TC">Turks and Caicos Islands</option>
												<option value="TV">Tuvalu</option>
												<option value="UG">Uganda</option>
												<option value="UA">Ukraine</option>
												<option value="AE">United Arab Emirates</option>
												<option value="GB">United Kingdom</option>
												<option value="US">United States</option>
												<option value="UM">United States Minor Outlying
													Islands</option>
												<option value="UY">Uruguay</option>
												<option value="UZ">Uzbekistan</option>
												<option value="VU">Vanuatu</option>
												<option value="VE">Venezuela, Bolivarian Republic
													of</option>
												<option value="VN">Viet Nam</option>
												<option value="VG">Virgin Islands, British</option>
												<option value="VI">Virgin Islands, U.S.</option>
												<option value="WF">Wallis and Futuna</option>
												<option value="EH">Western Sahara</option>
												<option value="YE">Yemen</option>
												<option value="ZM">Zambia</option>
												<option value="ZW">Zimbabwe</option>
                            </form:select>
                        </div>

                    </div>

                    <div class="col-lg-12 col-xs-12 clearfix">
                        <button type="submit" class="btn   btn-primary"><i class="fa fa-map-marker"></i> Save Address
                        </button>
                    </div>

            </form:form>


                <div class="col-lg-12 col-xs-12  clearfix ">

                    <ul class="pager">
                        <li class="previous pull-right"><a href="index"> <i class="fa fa-home"></i> Go to Shop </a>
                        </li>
                        <li class="next pull-left"><a href="my-address">&larr; Back to My Address</a></li>
                    </ul>
                </div>


            </div>
            <!--/row end-->


        </div>
        <div class="col-lg-3 col-md-3 col-sm-5">
        </div>


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

<!-- include custom script for site  -->
<script src="resources/assets/js/script.js"></script>
<script type="text/javascript">
		$("#country").val($("#userCountry").val());
		$("#state").val($("#userState").val());
		$("#additionalinfo").text($("#additional_info").val());
		
	</script>

</body>
</html>
