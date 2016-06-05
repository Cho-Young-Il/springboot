<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/lib/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/lib/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="/lib/clean-blog/clean-blog.min.css">
<link rel="stylesheet" href="/css/header.css">
<link rel="stylesheet" href="/css/member/modal/update.css">
<link rel="stylesheet" href="/css/board/modal/regist.css">
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic">
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800">
<title>Springboot001</title>
</head>
<body>
	
	<#include "../header.ftl">
	<div>${loginMember}</div>
	sdfsfd
	<hr><hr><hr><hr><hr><hr><hr><hr><hr><hr><hr><hr><hr><hr><hr><hr><hr><hr><hr>
	<!-- Main Content -->
	<div class="container">
	    <div class="row">
	        <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
				<h1>Success Login</h1>
	        </div>
	    </div>
	</div>
	
	<#include "../footer.ftl">
	<#include "../member/modal/update.ftl">
	<#include "../board/modal/regist.ftl">
	
	<script src="/lib/jquery/jquery.min.js"></script>
	<script src="/lib/bootstrap/js/bootstrap.min.js"></script>
	<script src="/lib/autogrow-textarea/jquery.autogrowtextarea.min.js"></script>
	<script src="/js/common/jquery.typoshadow.js"></script>
	<script src="/js/common/global.js"></script>
	<script src="/js/header.js"></script>
	<script src="/js/member/modal/update.js"></script>
	<script src="/js/board/modal/regist.js"></script>
</body>
</html>