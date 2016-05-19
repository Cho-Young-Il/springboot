<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/lib/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/lib/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="/lib/clean-blog/clean-blog.min.css">
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic">
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800">
<title>Springboot001</title>
</head>
<body>
	<nav class="navbar navbar-default navbar-custom navbar-fixed-top">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/board/list">Spring Boot 001</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="/board/list">HOME</a>
                    </li>
                    <li>
                        <a href="https://github.com/Cho-Young-Il/springboot/tree/master/springboot001" target="_blank">GITHUB</a>
                    </li>
                    <li>
                        <a href="#">MYPAGE</a>
                    </li>
                    <li>
                        <a href="/member/logout">LOGOUT</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Page Header -->
    <!-- Set your background image for this header on the line below. -->
    <header class="intro-header" style="background-image: url('/images/homebg.jpg')">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                    <div class="site-heading">
                        <h1 id="typo">Springboot001</h1><br/>
                        <hr class="small">
                        <span class="subheading" style="font-weight: bold;">Spring Boot 001 Simple Project</span>
                        <span class="subheading" style="font-weight: bold;">Member and Board Management System</span>
                    </div>
                </div>
            </div>
        </div>
    </header>
    
    <!-- Main Content -->
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
				<h1>Success Login</h1>
            </div>
        </div>
    </div>
    
    <hr>
    
    <!-- Footer -->
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                    <ul class="list-inline text-center">
                        <li>
                            <a href="https://www.facebook.com/profile.php?id=100011789134527" target="_blank">
                                <span class="fa-stack fa-lg">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-facebook fa-stack-1x fa-inverse"></i>
                                </span>
                            </a>
                        </li>
                        <li>
                            <a href="https://github.com/Cho-Young-Il/springboot/tree/master/springboot001" target="_blank">
                                <span class="fa-stack fa-lg">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-github fa-stack-1x fa-inverse"></i>
                                </span>
                            </a>
                        </li>
                    </ul>
                    <p class="copyright text-muted">Copyright &copy; 2016</p>
                </div>
            </div>
        </div>
    </footer>
	<script src="/lib/jquery/jquery.min.js"></script>
	<script src="/lib/bootstrap/js/bootstrap.min.js"></script>
	<script src="/lib/clean-blog/clean-blog.min.js"></script>
	<script src="/js/common/jquery.typoshadow.js"></script>
	<script src="/js/board/list.js"></script>
</body>
</html>