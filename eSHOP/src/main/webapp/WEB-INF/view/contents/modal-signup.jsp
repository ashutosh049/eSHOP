<div class="modal signUpContent fade" id="ModalSignup" tabindex="-1"
	role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h3 class="modal-title-site text-center">REGISTER</h3>
			</div>
			<div class="modal-body">
				<form id="createUserAccountMdl" role="form"  method="post">	
				<div class="form-group reg-username">
					<div>
						<input name="login" class="form-control input firstName" id="firstNameMdl" size="20" required
							placeholder="First Name" type="text">
					</div>
				</div>
				<div class="form-group reg-username">
					<div>
						<input name="login" class="form-control input lastName" id="lastNameMdl" size="20" required
							placeholder="Last Name" type="text">
					</div>
				</div>
				<div class="form-group reg-email">
					<div>
						<input name="reg" class="form-control input email" id="emailMdl" size="20" required
							placeholder="Email" type="email">
					</div>
				</div>
				<div class="form-group reg-password">
					<div>
						<input name="password" class="form-control input password" id="passwordMdl" size="20" required
							placeholder="Password" type="password">
					</div>
				</div>
				<div class="form-group">
					<div>
						<div class="checkbox login-remember">
							<label> <input name="rememberme" id="rememberme"
								value="forever" checked="checked" type="checkbox">
								Remember Me
							</label>
						</div>
					</div>
				</div>
				<div>
					<div>
						<button id="createUserAccountMdlSbmtBtn" 
							    name="submit" 
							    class="btn  btn-block btn-lg btn-primary createUserAccountSbmtBtn" 
							    data-loading-text="<i class='fa fa-cog fa-spin fa-lg fa-fw' aria-hidden='true'></i> Processing.."
							    type="submit">REGISTER
						</button>
					</div>
				</div>
				</form>
				<!--userForm-->

			</div>
			<div class="modal-footer">
				<p class="text-center">
					Already member? <a data-toggle="modal" data-dismiss="modal"
						href="#ModalLogin"> Sign in </a>
				</p>
			</div>
		</div>
		<!-- /.modal-content -->

	</div>
	<!-- /.modal-dialog -->

</div>