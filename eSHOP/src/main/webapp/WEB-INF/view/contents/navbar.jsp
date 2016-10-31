<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-collapse">
			<span class="sr-only"> Toggle navigation </span> <span
				class="icon-bar"> </span> <span class="icon-bar"> </span> <span
				class="icon-bar"> </span>
		</button>
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-cart">
			<i class="fa fa-shopping-cart colorWhite"> </i> <span
				class="cartRespons colorWhite"> Cart ($ ${wrapCart.wrapCartPayable}) </span>
		</button>
		<a class="navbar-brand " href="index"> <img
			src="resources/images/logo.png" alt="TSHOP">
		</a>

		<!-- this part for mobile -->
		<div class="search-box pull-right hidden-lg hidden-md hidden-sm">
			<div class="input-group">
				<button class="btn btn-nobg getFullSearch" type="button">
					<i class="fa fa-search"> </i>
				</button>
			</div>
			<!-- /input-group -->

		</div>
	</div>

	<!-- this part is duplicate from cartMenu  keep it for mobile -->
	<div class="navbar-cart  collapse">
		<div class="cartMenu  col-lg-4 col-xs-12 col-md-4 ">
			<div class="w100 miniCartTable scroll-pane">
				<table>
					<tbody>
						<tr class="miniCartProduct">
							<td style="width: 20%" class="miniCartProductThumb">
								<div>
									<a href="product-details"> <img
										src="resources/images/product/3.jpg" alt="img">
									</a>
								</div>
							</td>
							<td style="width: 40%">
								<div class="miniCartDescription">
									<h4>
										<a href="product-details"> TSHOP T shirt Black </a>
									</h4>
									<span class="size"> 12 x 1.5 L </span>

									<div class="price">
										<span> $8.80 </span>
									</div>
								</div>
							</td>
							<td style="width: 10%" class="miniCartQuantity"><a> X 1
							</a></td>
							<td style="width: 15%" class="miniCartSubtotal"><span>
									$8.80 </span></td>
							<td style="width: 5%" class="delete"><a> x </a></td>
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
											<td>
												<div class="CartDescription">
													<h4>
														<a href="product-details">${cartItemList.itemName} </a>
													</h4>
													<span class="size">${cartItemList.itemSize}</span><span
														class="size">${cartItemList.itemColor}</span>

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
											<td class="delete"><a title="Delete"> <i
													style="color: #e7711b"
													class="glyphicon glyphicon-trash fa-2x"></i></a></td>
										</tr>
									</c:forEach>
					</tbody>
				</table>
			</div>
			<!--/.miniCartTable-->

			<div class="miniCartFooter  miniCartFooterInMobile text-right">
				<h3 class="text-right subtotal">Subtotal: $ ${wrapCart.wrapCartPayable}</h3>
				<a class="btn btn-sm btn-danger" href="cart"> <i
					class="fa fa-shopping-cart"> </i> VIEW CART
				</a> 
				<c:if test="${wrapCart.wrapCartPayable>0}">
					<a href="checkout-1" class="btn btn-sm btn-primary"> CHECKOUT </a>
				</c:if>
			</div>
			<!--/.miniCartFooter-->

		</div>
		<!--/.cartMenu-->
	</div>
	<!--/.navbar-cart-->

	<div class="navbar-collapse collapse">
		<ul class="nav navbar-nav">
			
			<li class="active"><a href="index"> Home </a></li>
			
			<c:forEach items="${wrapNavModal.wrapNavTabList}" var="tabList">
						<li class="dropdown megamenu-80width ">
						<a data-toggle="dropdown" class="dropdown-toggle" href="#">
							 ${tabList.wrapTab.wrapTabName} <b class="caret"> </b>
						</a>
						<ul class="dropdown-menu">
							<li class="megamenu-content">
								
								<c:forEach items="${tabList.wrapNavColList}" var="colList">
									<ul class="col-lg-2  col-sm-2 col-md-2  unstyled noMarginLeft">
										<li>
											<p>
												<strong> ${colList.wrapColumn.wrapColName} </strong>
											</p>
										</li>
										<c:forEach items="${colList.wrapNavCatList}" var="catList">
											<li><a href="category?tabId=${catList.wrapCategory.wrapTabId}&
														colId=${catList.wrapCategory.wrapColId}&
														catId=${catList.wrapCategory.wrapCatId}"> ${catList.wrapCategory.wrapCatName}</a></li>
										</c:forEach>
										
									</ul>
								</c:forEach>
								
								<ul class="col-lg-3  col-sm-3 col-md-3 col-xs-6">
									<li class="no-margin productPopItem "><a
										href="product-details"> <img class="img-responsive"
											src="${tabList.image1Path}" alt="img">
									</a> <a class="text-center productInfo alpha90"
										href="product-details"> Eodem modo typi <br> <span>
												$60 </span>
									</a></li>
								</ul>
								<ul class="col-lg-3  col-sm-3 col-md-3 col-xs-6">
									<li class="no-margin productPopItem relative"><a
										href="product-details"> <img class="img-responsive"
											src="${tabList.image2Path}" alt="img">
									</a> <a class="text-center productInfo alpha90"
										href="product-details"> Eodem modo typi <br> <span>
												$60 </span>
									</a></li>
								</ul>
							</li>
						</ul>
					</li>
			</c:forEach>

		</ul>
		</ul>

		<!--- this part will be hidden for mobile version -->
		<div class="nav navbar-nav navbar-right hidden-xs">
			<div class="dropdown  cartMenu ">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown"> <i
					class="fa fa-shopping-cart"> </i> <span class="cartRespons">
						Cart ($ ${wrapCart.wrapCartPayable}) </span> <b class="caret"> </b>
				</a>

				<div class="dropdown-menu col-lg-4 col-xs-12 col-md-4 ">
					<div class="w100 miniCartTable scroll-pane">
						<table>
							<tbody>
								<c:forEach items="${wrapCart.wrapCartItemlList}"
										var="cartItemList">
										<tr class="miniCartProduct">
											<td style="width: 20%" class="miniCartProductThumb">
												<div>
													<a href="product-details"><img
														src="${cartItemList.itemImagePath}" alt="img"></a>
												</div>
											</td>
												<td style="width: 40%">
												<div class="miniCartDescription">
													<h4>
														<a href="product-details">${cartItemList.itemName} </a>
													</h4>
													<span class="size">${cartItemList.itemSize}</span><span
														class="size">${cartItemList.itemColor}</span>

													<div class="price">
														<span>$ ${cartItemList.itemMarkedPrice}</span>
													</div>
												</div>
											</td>
											<td style="width: 10%" class="miniCartQuantity"><a> X ${cartItemList.itemCount}</a></td>
											<td style="width: 15%" class="miniCartSubtotal"><span> $ ${cartItemList.itemSubToal} </span></td>
											<td class="delete" style="text-align:center;">
												<a title="Delete">
												 	<i style="color: #e7711b" class="glyphicon glyphicon-trash"></i>
												 </a>
											</td>
										</tr>
									</c:forEach>
								
								
								
							</tbody>
						</table>
					</div>
					<!--/.miniCartTable-->

					<div class="miniCartFooter text-right">
						<h3 class="text-right subtotal">Subtotal: $ ${wrapCart.wrapCartPayable}</h3>
						<a class="btn btn-sm btn-danger" href="cart"> <i
							class="fa fa-shopping-cart"> </i> VIEW CART
						</a>
						<c:if test="${wrapCart.wrapCartPayable>0}">
							<a href="checkout-1" class="btn btn-sm btn-primary"> CHECKOUT </a>
						</c:if>
						<!-- <a class="btn btn-sm btn-primary" href="checkout-1"> CHECKOUT </a> -->
					</div>
					<!--/.miniCartFooter-->

				</div>
				<!--/.dropdown-menu-->
			</div>
			<!--/.cartMenu-->

			<div class="search-box">
				<div class="input-group">
					<button class="btn btn-nobg getFullSearch" type="button">
						<i class="fa fa-search"> </i>
					</button>
				</div>
				<!-- /input-group -->

			</div>
			<!--/.search-box -->
		</div>
		<!--/.navbar-nav hidden-xs-->
	</div>
	<!--/.nav-collapse -->

</div>