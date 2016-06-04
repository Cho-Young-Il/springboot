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
					<input type="submit" id="signInBtn" class="btn btn-primary" value="Sign In">
					<input type="button" id="signUpBtn" class="btn btn-danger" value="Sign Up">
				</div>
			</form>
		</div>
	</div>
	
	<#include "../member/modal/regist.ftl">
	
	<script src="/lib/jquery/jquery.js"></script>
	<script src="/js/node-root.js"></script>
	<script src="/js/common/global.js"></script>
	<script src="/js/main/main.js"></script>
	<script src="/js/member/modal/regist.js"></script>
</body>
</html>