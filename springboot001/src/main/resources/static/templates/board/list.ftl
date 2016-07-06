<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/lib/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/lib/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="/lib/clean-blog/clean-blog.min.css">
<link rel="stylesheet" href="/css/header.css">
<link rel="stylesheet" href="/css/board/list.css">
<link rel="stylesheet" href="/css/member/modal/update.css">
<link rel="stylesheet" href="/css/board/modal/regist.css">
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic">
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800">
<title>Springboot001</title>
</head>
<body>
	
<#include "../header.ftl">

<!-- List Contents -->
<div class="container board-list">
<section class="content">
	<div class="row">
		<div class="col-md-10 col-md-offset-1">
			<div class="grid support-content">
				 <div class="grid-body">
					<br><br>
					<div class="row">
						<div class="col-md-8 col-md-offset-2">
							<div class="input-group">
				                <div class="input-group-btn search-panel">
				                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
				                    	<span id="searchType">Filter by</span> <span class="caret"></span>
				                    </button>
				                    <ul class="dropdown-menu" role="menu">
				                      <li><a class="search-type">Title</a></li>
				                      <li><a class="search-type">Content</a></li>
				                      <li><a class="search-type">Writer</a></li>
				                      <li class="divider"></li>
				                      <li><a class="search-type">Anything</a></li>
				                    </ul>
				                </div>
				                <input type="text" class="form-control" name="keyword" placeholder="Search">
				                <span class="input-group-btn">
				                    <button class="btn btn-primary" id="searchBtn" type="button"><span class="glyphicon glyphicon-search"></span></button>
				                </span>
				            </div>
						</div><br>
						<div class="col-md-12"><hr>
							<ul id="boardList" class="list-group fa-padding" style="word-break: break-all;"></ul>
						<hr></div>
						
						<div class="col-md-12">
							<div class="btn-group btn-group-sm dropup pull-left">
								<a class="btn btn-default dropdown-toggle" data-toggle="dropdown" 
									aria-haspopup="true" aria-expanded="false"><strong>Show rows per page</strong>
									<span class="fa fa-caret-up"></span>
								</a>
								<ul class="dropdown-menu" role="menu">
									<li><a class="text-center row-per-page">20 rows</a></li>
									<li><a class="text-center row-per-page">40 rows</a></li>
									<li><a class="text-center row-per-page">60 rows</a></li>
									<li><a class="text-center row-per-page">80 rows</a></li>
									<li><a class="text-center row-per-page">100 rows</a></li>
								</ul>
							</div>
							<span id="rowsPerPage" style="margin-left: 10px; color: #337ab7; font-size:22px; font-weight: bold;">20 rows</span>
							<ul class="pagination pagination-sm pull-right" style="margin: 0 0; font-weight: bold;"></ul>
						</div>
					</div><br><br><br>
				</div>
			</div>
		</div>
	</div>
</section>
</div><br>
<div id="goTop" class="col-md-12" style="width: 100%; margin:0px; padding:0px;">
	<a class="btn btn-block btn-link go-top">
	<i class="fa fa-chevron-up fa-fw text-danger"></i></a>
</div>

<#include "../footer.ftl">
<#include "../member/modal/update.ftl">
<#include "../board/modal/regist.ftl">

<script src="/lib/jquery/jquery.min.js"></script>
<script src="/lib/jquery-ui/ui/minified/jquery-ui.min.js"></script>
<script src="/lib/bootstrap/js/bootstrap.min.js"></script>
<script src="/lib/autogrow-textarea/jquery.autogrowtextarea.min.js"></script>
<script src="/lib/jquery-smooth-scroll/jquery.smooth-scroll.min.js"></script>
<script src="/js/common/jquery.typoshadow.js"></script>
<script src="/js/common/global.js"></script>
<script src="/js/header.js"></script>
<script src="/js/board/list.js"></script>
<script src="/js/member/modal/update.js"></script>
<script src="/js/board/modal/regist.js"></script>
<script src="/js/board/modal/detail.js"></script>

</body>
</html>