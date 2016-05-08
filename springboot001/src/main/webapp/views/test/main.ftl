<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Springboot001 Login</title>
<style>
	* {
		margin: 0;
		padding: 0;
	}
	
	/* background */
	body {
		background: url("/images/home/homebg.jpg")
					no-repeat center fixed;
		background-size: cover;
		-ms-filter: "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='/springboot001/images/home/homebg.jpg',sizingMethod='scale')";
		text-align: center
	}
	
	/* typo intro */
	#typo {
		margin-top: 350px;
	    font-weight: bold;
	    font-size: 60px;
	    color: #fff;
	    text-align: center;
	    line-height: 100px;
	    height: 500px;
	    -webkit-user-select: none;
	    -moz-user-select: none;
	    -ms-user-select: none;
	}
	
	/* ghost button */
	div.ghost-buttons {
		width: 100%;
		bottom: 100px;
		position: absolute;
	}
	a.ghost-button {
		display: inline-block;
		position: relative;
		padding: 10px 20px;
		margin: 50px 15px;
		border: 2px solid #fff;
		color: #fff;
		text-align: center;
		text-decoration: none;
		font-weight: bold;
	}
	a.ghost-button:hover {
		background-color: #fff;
		color: black;
	}
</style>
</head>
<body>
	<div id="typo">
		<div class="inner">Springboot001 Project</div>
	</div>
	<div class="ghost-buttons">
		<a href="#" class="ghost-button">Sign In</a>
		<a href="#" class="ghost-button">Sign Up</a>
	</div>
	<script src="/lib/jquery/jquery.js"></script>
</body>
</html>