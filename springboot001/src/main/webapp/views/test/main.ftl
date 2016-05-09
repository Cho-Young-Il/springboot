<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/lib/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="/lib/font-awesome/css/font-awesome.min.css">
<style type="text/css">
body{
	margin-top:200px;
	background: url("/images/home/homebg.jpg")
					no-repeat center fixed;
	background-size: cover;
	-ms-filter: "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='/springboot001/images/home/homebg.jpg',sizingMethod='scale')";
	text-align: center
}

.login-container {
    position: relative;
    margin: 0 auto;
    max-width: 390px;
}

.login-container .loginbox {
    position: relative;
    width: 390px !important;
    height: auto !important;
    padding: 0 0 20px 0;
    -webkit-box-shadow: 0 0 14px rgba(0,0,0,.1);
    -moz-box-shadow: 0 0 14px rgba(0,0,0,.1);
    box-shadow: 0 0 14px rgba(0,0,0,.1);
}

.bg-white {
    background-color: rgba( 255, 255, 255, 0.9 ) !important;
}

.login-container .loginbox .loginbox-title {
    position: relative;
    text-align: center;
    width: 100%;
    height: 35px;
    padding-top: 10px;
    font-family: 'Lucida Sans','trebuchet MS',Arial,Helvetica;
    font-size: 20px;
    font-weight: normal;
    color: #444;
}

.login-container .loginbox .loginbox-social {
    padding: 0 10px 10px;
    text-align: center;
}

.login-container .loginbox .loginbox-social .social-title {
    font-size: 14px;
    font-weight: 500;
    color: #a9a9a9;
    margin-top: 10px;
}

.login-container .loginbox .loginbox-social .social-buttons {
    height: 80px;
    width: 420px;
    padding: 15px 80px;
    text-align: center;
}

.login-container .loginbox .loginbox-social .social-buttons .button-facebook {
    float: left;
    border: 2px solid #3b5998;
    color: #3b5998;
    border-radius: 50%;
    width: 50px;
    height: 50px;
    margin-right: 30px;
    background-color: #fff;
}

.login-container .loginbox .loginbox-social .social-buttons .button-twitter {
    float: left;
    border: 2px solid #29c1f6;
    color: #29c1f6;
    border-radius: 50%;
    width: 50px;
    height: 50px;
    margin-right: 30px;
    background-color: #fff;
}

.login-container .loginbox .loginbox-social .social-buttons .button-google  {
    float: left;
    border: 2px solid #ef4f1d;
    color: #ef4f1d;
    border-radius: 50%;
    width: 50px;
    height: 50px;
    margin-right: 30px;
    background-color: #fff;
}

.login-container .loginbox .loginbox-social .social-buttons .button-facebook i {
    font-size: 26px;
    line-height: 50px;
}

.login-container .loginbox .loginbox-social .social-buttons .button-twitter i {
    font-size: 26px;
    line-height: 50px;
}

.login-container .loginbox .loginbox-social .social-buttons .button-google i {
    font-size: 26px;
    line-height: 50px;
}

.login-container .loginbox .loginbox-or {
    position: relative;
    text-align: center;
    height: 20px;
}

.login-container .loginbox .loginbox-or .or-line {
    position: absolute;
    height: 1px;
    top: 10px;
    left: 40px;
    right: 40px;
    background-color: #ccc;
}

.login-container .loginbox .loginbox-or .or {
    position: absolute;
    top: 0;
    -lh-property: 0;
    left: -webkit-calc(50% - 25px);
    left: -moz-calc(50% - 25px);
    left: calc(50% - 25px);
    width: 50px;
    height: 20px;
    background-color: #fff;
    color: #999;
    margin: 0 auto;
}

.login-container .loginbox .loginbox-textbox {
    padding: 10px 40px;
}

.login-container .loginbox .loginbox-textbox .form-control {
    -webkit-border-radius: 3px !important;
    -webkit-background-clip: padding-box !important;
    -moz-border-radius: 3px !important;
    -moz-background-clip: padding !important;
    border-radius: 3px !important;
    background-clip: padding-box !important;
}

.login-container .loginbox .loginbox-checkbox label {
    font-size: 13px;
    color: #666;
}

.login-container .loginbox .loginbox-submit {
    padding: 10px 40px;   
}

.login-container .loginbox .loginbox-submit input {
	width:80px;
}

.login-container .logobox {
    width: 390px !important;
    height: 50px !important;
    padding: 5px;
    margin-bottom: 15px;
    -webkit-box-shadow: 0 0 14px rgba(0,0,0,.1);
    -moz-box-shadow: 0 0 14px rgba(0,0,0,.1);
    box-shadow: 0 0 14px rgba(0,0,0,.1);
    background-color: rgba( 255, 255, 255, 0.9 );
    text-align: left;
}
.logobox-title {
	padding-top: 5px;
	font-family: 'Lucida Sans','trebuchet MS',Arial,Helvetica;
    font-size: 20px;
    font-weight: bold;
    color: black;
    text-align: center;
}
.loginbox, .logobox {
	border-radius: 2px;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<div class="login-container animated fadeInDown bootstrap snippets">
		<div class="logobox">
			<div class="logobox-title">Springboot001 Project</div>
		</div>
		<div class="loginbox bg-white">
			<div class="loginbox-title">SIGN IN</div>
			<div class="loginbox-social">
				<div class="social-title ">Connect with Your Social Accounts</div>
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
			<div class="loginbox-textbox">
				<input type="text" class="form-control" placeholder="ID">
			</div>
			<div class="loginbox-textbox">
				<input type="text" class="form-control" placeholder="Password">
			</div>
			<div class="loginbox-checkbox">
				<label class="checkbox">
					<input type="checkbox" value="remember-me">Remember Me
				</label>
			</div>
			<div class="loginbox-submit">
				<input type="button" class="btn btn-primary" value="Sign In">
				<input type="button" class="btn btn-danger" value="Sign Up">
			</div>
		</div>
	</div>
</body>
</html>