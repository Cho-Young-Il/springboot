<div class="section my-modal" id="myModal">
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<form id="signup" role="form" class="text">
					<div class="row myborder">
					<span id="close" class="close">
						<i class="fa fa-fw fa-close"></i>
					</span>
						<br/>
						<h3 style="margin: initial; margin-bottom: 10px; font-weight: bold;">CREATE YOUR ACCOUNT</h3>
						Fill in the form below to get instant access.
						<hr>
						<div class="input-group margin-bottom-20" id="midDiv">
							<span class="input-group-addon">
								<i class="glyphicon glyphicon-ok mycolor"></i>
							</span> 
							<input size="60" maxlength="255" class="form-control"
								required="required" placeholder="ID" name="mid"
								id="mid" type="text">
						</div>
						<div class="input-group margin-bottom-20">
							<span class="input-group-addon">
								<i class="glyphicon glyphicon-user mycolor"></i>
							</span> 
							<input size="60" maxlength="255" class="form-control"
								required="required" placeholder="Name" name="mname"
								id="mname" type="text">
						</div>
						<div class="input-group margin-bottom-20">
							<span class="input-group-addon">
								<i class="glyphicon glyphicon-lock mycolor"></i>
							</span> 
							<input size="60" maxlength="255" class="form-control"
								required="required" placeholder="Password" name="mpwd"
								id="mpwd" type="password" pattern=".{8,}" 
								title="At least 8 characters">
						</div>
						<div class="input-group margin-bottom-20">
							<span class="input-group-addon">
								<i class="glyphicon glyphicon-lock mycolor"></i>
							</span> 
								<input size="60" maxlength="255" class="form-control"
								required="required" placeholder="Confirm Password"
								name="mpwdConfirm" id="mpwdConfirm" type="password"
								pattern=".{8,}" title="At least 8 characters">
						</div>
						<div class="input-group margin-bottom-20">
							<span class="input-group-addon">
								<i class="glyphicon glyphicon-envelope mycolor"></i>
							</span> 
							<input size="60" maxlength="255" class="form-control"
								placeholder="Email" required="required"
								name="memail" id="memail" type="email">
						</div>
						<br/>
						<div class="row">
							<div class="col-md-12">
								<button id="memAddBtn" type="submit" class="btn btn-success">
                					<i class="fa fa-fw fa-user-plus"></i>Sign Up</button>
							</div>
						</div>
						<br/>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>