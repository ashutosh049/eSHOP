
<div class="modal signUpContent fade" id="ModalLogin" tabindex="-1"
	role="dialog">
	<div class="modal-dialog ">
		<form role="form" action="login" method="post" id="loginUserAccountMdlSbmtForm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h3 class="modal-title-site text-center">Login to TSHOP</h3>
			</div>
			<div class="modal-body">
				<div class="form-group login-username">
					<div>
						<input id="login-user" class="form-control input" name="username" required="required"
							size="20" placeholder="Username" type="text">
					</div>
				</div>
				<div class="form-group login-password">
					<div>
						<input id="login-password" name="password"
							class="form-control input" size="20" placeholder="Password" required="required"
							type="password">
					</div>
				</div>
				<div class="form-group">
					<div>
						<div class="checkbox login-remember">
							<label> <input name="rememberme" value="forever"
								checked="checked" type="checkbox"> Remember Me
							</label>
						</div>
					</div>
				</div>
				<div>
					<div>
						<!-- <input name="submit" class="btn  btn-block btn-lg btn-primary"
							value="" type="submit"> -->
							
						<button id="loginUserAccountMdlSbmtBtn" 
							    name="submit" 
							    class="btn  btn-block btn-lg btn-primary" 
							    data-loading-text="<i class='fa fa-cog fa-spin fa-lg fa-fw' aria-hidden='true'></i> Processing.."
							    type="submit">LOGIN
						</button>	
					</div>
				</div>
				<!--userForm-->

			</div>
			<div class="modal-footer">
				<p class="text-center">
					Not here before? <a data-toggle="modal" data-dismiss="modal"
						href="#ModalSignup"> Sign Up. </a> <br> <a
						href="forgot-password"> Lost your password? </a>
				</p>
			</div>
		</div>
		</form>
		<!-- /.modal-content -->

	</div>
	<!-- /.modal-dialog -->

</div>