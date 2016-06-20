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

${loginMember}
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
				                <input type="hidden" name="type" value="anything">
				                <input type="text" class="form-control" name="keyword" placeholder="Search">
				                <span class="input-group-btn">
				                    <button class="btn btn-primary" type="button"><span class="glyphicon glyphicon-search"></span></button>
				                </span>
				            </div>
						</div><br>
						<div class="col-md-12"><hr>
							<ul class="list-group fa-padding" style="word-break: break-all;">
								<li class="list-group-item" data-toggle="modal" data-target="#issue">
									<div class="media">
										<i class="fa fa-file-o pull-left"></i><span class="number pull-right"># 13698</span>
										<div class="media-body">
											<div class="btitle">Add drag and drop config import closes</div>
											<p class="info">
												Written by jwilliams
												<strong> /</strong>
												<i class="fa fa-fw fa-clock-o"></i>16-05-07 11:11
												<strong> /</strong>
												<i class="fa fa-comments"></i> 2 comments
											</p>
										</div>
									</div>
								</li>
								<li class="list-group-item" data-toggle="modal" data-target="#issue">
									<div class="media">
										<i class="pull-left">&nbsp;&nbsp;</i>
										<i class="fa fa-code-fork pull-left"></i>
										<span class="number pull-right"># 13697</span>
										<div class="media-body">
											<div class="label label-primary">ㄴREPLY</div><br>
											<div class="btitle">Document that Helvetica Neue can cause problems on Windows</div>
											<p class="info">
												Written by jwilliams
												<strong> /</strong>
												<i class="fa fa-fw fa-clock-o"></i>16-05-07 11:11
												<strong> /</strong>
												<i class="fa fa-comments"></i> 2 comments
											</p>
										</div>
									</div>
								</li>
								<li class="list-group-item" data-toggle="modal" data-target="#issue">
									<div class="media">
										<i class="pull-left">&nbsp;&nbsp;</i>
										<i class="pull-left">&nbsp;&nbsp;</i>
										<i class="fa fa-code-fork pull-left"></i>
										<span class="number pull-right"># 13697</span>
										<div class="media-body">
											<div class="label label-primary">ㄴREPLY</div><br>
											<div class="btitle">Document that Helvetica Neue can cause problems on Windows</div>
											<p class="info">
												Written by jwilliams
												<strong> /</strong>
												<i class="fa fa-fw fa-clock-o"></i>16-05-07 11:11
												<strong> /</strong>
												<i class="fa fa-comments"></i> 2 comments
											</p>
										</div>
									</div>
								</li>
								<li class="list-group-item" data-toggle="modal" data-target="#issue">
									<div class="media">
										<i class="pull-left">&nbsp;&nbsp;</i>
										<i class="pull-left">&nbsp;&nbsp;</i>
										<i class="pull-left">&nbsp;&nbsp;</i>
										<i class="fa fa-code-fork pull-left"></i>
										<span class="number pull-right"># 13697</span>
										<div class="media-body">
											<div class="label label-primary">ㄴREPLY</div><br>
											<div class="btitle">Document that Helvetica Neue can cause problems on Windows</div>
											<p class="info">
												Written by jwilliams
												<strong> /</strong>
												<i class="fa fa-fw fa-clock-o"></i>16-05-07 11:11
												<strong> /</strong>
												<i class="fa fa-comments"></i> 2 comments
											</p>
										</div>
									</div>
								</li>
								<li class="list-group-item" data-toggle="modal" data-target="#issue">
									<div class="media">
										<i class="pull-left">&nbsp;&nbsp;</i>
										<i class="pull-left">&nbsp;&nbsp;</i>
										<i class="pull-left">&nbsp;&nbsp;</i>
										<i class="pull-left">&nbsp;&nbsp;</i>
										<i class="fa fa-code-fork pull-left"></i>
										<span class="number pull-right"># 13697</span>
										<div class="media-body">
											<div class="label label-primary">ㄴREPLY</div><br>
											<div class="btitle">Document that Helvetica Neue can cause problems on Windows</div>
											<p class="info">
												Written by jwilliams
												<strong> /</strong>
												<i class="fa fa-fw fa-clock-o"></i>16-05-07 11:11
												<strong> /</strong>
												<i class="fa fa-comments"></i> 2 comments
											</p>
										</div>
									</div>
								</li>
								<li class="list-group-item" data-toggle="modal" data-target="#issue">
									<div class="media">
										<i class="fa fa-file-o pull-left"></i><span class="number pull-right"># 13698</span>
										<div class="media-body">
											<div class="btitle">Add drag and drop config import closes</div>
											<p class="info">
												Written by jwilliams
												<strong> /</strong>
												<i class="fa fa-fw fa-clock-o"></i>16-05-07 11:11
												<strong> /</strong>
												<i class="fa fa-comments"></i> 2 comments
											</p>
										</div>
									</div>
								</li>
								<li class="list-group-item" data-toggle="modal" data-target="#issue">
									<div class="media">
										<i class="fa fa-file-o pull-left"></i><span class="number pull-right"># 13698</span>
										<div class="media-body">
											<div class="btitle">Add drag and drop config import closes</div>
											<p class="info">
												Written by jwilliams
												<strong> /</strong>
												<i class="fa fa-fw fa-clock-o"></i>16-05-07 11:11
												<strong> /</strong>
												<i class="fa fa-comments"></i> 2 comments
											</p>
										</div>
									</div>
								</li>
								<li class="list-group-item" data-toggle="modal" data-target="#issue">
									<div class="media">
										<!-- 
											게시판 계층의 depth가 7이상은 댓글 달수 없게 하자
											왜냐면 반응형웹이기 때문에 ui가 깨짐.
										 -->
										<i class="pull-left">&nbsp;&nbsp;</i>
										<i class="pull-left">&nbsp;&nbsp;</i>
										<i class="pull-left">&nbsp;&nbsp;</i>
										<i class="pull-left">&nbsp;&nbsp;</i>
										<i class="pull-left">&nbsp;&nbsp;</i>
										<i class="pull-left">&nbsp;&nbsp;</i>
										<i class="pull-left">&nbsp;&nbsp;</i>
										<i class="fa fa-code-fork pull-left"></i>
										<span class="number pull-right"># 13697</span>
										<div class="media-body">
											<div class="label label-primary">ㄴREPLY</div><br>
											<div class="btitle">Documentsdfsasdasddf that Helvetica Neue can cause problems on Windows</div>
											<p class="info">
												Written by jwilliams
												<strong> /</strong>
												<i class="fa fa-fw fa-clock-o"></i>16-05-07 11:11
												<strong> /</strong>
												<i class="fa fa-comments"></i> 2 comments
											</p>
										</div>
									</div>
								</li>
							</ul><hr>
						</div>
						
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
							<ul class="pagination pagination-sm pull-right" style="margin: 0 0; font-weight: bold;">
								<li><a href="#"><i class="fa fa-fw fa-angle-double-left"></i></a></li>
								<li><a href="#"><i class="fa fa-fw fa-angle-left"></i></a></li>
								<li class="active"><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
								<li><a href="#"><i class="fa fa-fw fa-angle-right"></i></a></li>
								<li><a href="#"><i class="fa fa-fw fa-angle-double-right"></i></a></li>
							</ul>
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

</body>
</html>