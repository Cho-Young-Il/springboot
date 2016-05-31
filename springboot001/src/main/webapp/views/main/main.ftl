<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/lib/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/lib/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="/css/main/main.css">
<title>Springboot001</title>
</head>
<body>
	<div class="login-container animated fadeInDown bootstrap snippets">
		<div class="logobox">
			<div class="logobox-title">Springboot001 Project</div>
		</div>
		<div class="loginbox bg-white">
			<div class="loginbox-title">SIGN IN</div>
			<div class="loginbox-social">
				<div class="social-title">Connect with Your Social Accounts</div>
				<div class="social-buttons">
					<a href="" class="button-facebook">
						<i class="social-icon fa fa-facebook"></i>
					</a>
					<a href="" class="button-twitter"> 
						<i class="social-icon fa fa-twitter"></i>
					</a> 
					<a href="" class="button-google"> 
						<i class="social-icon fa fa-google-plus"></i>
					</a>
				</div>
			</div>
			<div class="loginbox-or">
				<div class="or-line"></div>
				<div class="or">OR</div>
			</div>
			<form id="signin" role="form" class="text">
				<div class="loginbox-textbox">
					<input type="text" name="mid" class="form-control" placeholder="ID">
				</div>
				<div class="loginbox-textbox">
					<input type="password" name="mpwd" class="form-control" placeholder="Password">
				</div>
				<div class="loginbox-checkbox">
					<label class="checkbox">
						<input type="checkbox" name="useCookie">Remember Me
					</label>
				</div>
				<div class="loginbox-submit">
					<input type="button" id="signInBtn" class="btn btn-primary" value="Sign In">
					<input type="button" id="signUpBtn" class="btn btn-danger" value="Sign Up">
				</div>
			</form>
		</div>
	</div>
	
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
	<script src="/lib/jquery/jquery.js"></script>
	<script src="/js/node-root.js"></script>
	<script src="/js/common/global.js"></script>
	<script src="/js/main/main.js"></script>
</body>
</html>