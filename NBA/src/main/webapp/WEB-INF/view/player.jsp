<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
	<html lang="">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Title Page</title>


		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
		<script type="text/javascript" src="js/tools.js"></script>
		<style>
			td,
			th {
				'vertical-align: middle;text-align: center;

			}

			.table-responsive {
				overflow-x: scroll;
			}

			img {
				height: 90%;
			}
		</style>

	</head>

	<body style="">
		<nav class="navbar navbar-default navbar-inverse" role="navigation">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#" style="padding: 0;padding-left: 10"><img src="img/nbalogo.png" ></a>
				</div>
		
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse navbar-ex1-collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#" >Link</a></li>
						<li><a href="#"></a></li>
					</ul>
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Search">
						</div>
						<button type="submit" class="btn btn-default">Submit</button>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#">Link</a></li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li><a href="#">Separated link</a></li>
							</ul>
						</li>
					</ul>
				</div><!-- /.navbar-collapse -->
			</div>
		</nav>
		

		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-12">
					<p class="page-header">常规赛场均</p>
					<div class="table-responsive">
						${stat_box_avg_season}
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<p class="page-header">常规赛总</p>
					<div class="table-responsive">
						${stat_box_tot_season}
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<p class="page-header">常规赛单场</p>
					<div class="table-responsive">
						${stat_box_single_season}
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<p class="page-header">进阶数据</p>
					<div class="table-responsive">
						${stat_box_advanced_basic_season}
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<p class="page-header">进阶数据</p>
					<div class="table-responsive">
						${stat_box_advanced_shooting_season}
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<p class="page-header">季后赛场均</p>
					<div class="table-responsive">
						${stat_box_avg}
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<p class="page-header">季后赛总</p>
					<div class="table-responsive">
						${stat_box_tot}
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<p class="page-header">季后赛单场</p>
					<div class="table-responsive">
						${stat_box_single}
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<p class="page-header">进阶数据</p>
					<div class="table-responsive">
						${stat_box_advanced_basic}
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<p class="page-header">进阶数据</p>
					<div class="table-responsive">
						${stat_box_advanced_shooting}
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-12">
					<p class="page-header">明星赛场均</p>
					<div class="table-responsive">
						${stat_box_avg_allstar}
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<p class="page-header">明星赛总</p>
					<div class="table-responsive">
						${stat_box_tot_allstar}
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<p class="page-header">明星赛单场</p>
					<div class="table-responsive">
						${stat_box_single_allstar}
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<p class="page-header">进阶数据</p>
					<div class="table-responsive">
						${stat_box_advanced_basic_allstar}
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<p class="page-header">进阶数据</p>
					<div class="table-responsive">
						${stat_box_advanced_shooting_allstar}
					</div>
				</div>
			</div>


		</div>
	</body>

	</html>
	<script>
		$("table").attr("style", "");
		$("table *").removeAttr("style", "");
		$("table a").removeAttr("href");
		$("table").addClass("table table-striped table-hover table-bordered table-condensed");
		$("table th").attr("onclick", "");
	</script>