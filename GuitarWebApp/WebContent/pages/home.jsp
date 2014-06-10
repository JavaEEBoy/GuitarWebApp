<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%@ include file="parts/head.jsp"%>

<body>
	<div class="navbar-wrapper">
		<div class="container">
			<div class="navbar navbar-inverse navbar-static-top"
				role="navigation">
				<div class="container">
					<%@ include file="parts/navLeft.jsp"%>
					<div class="navbar-collapse collapse">
						<%@ include file="parts/communityDropDown.jsp"%>
						<%@ include file="parts/navRight.jsp"%>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Carousel
    ================================================== -->
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="item active">
				<img data-src="holder.js/900x500/auto/#777:#7a7a7a/text:First slide"
					alt="First slide">
					<div class="container">
						<div class="carousel-caption">
							<h1>注册账号</h1>
							<p>还没注册账号？？？？太OUT了！！！！</p>
							<p>
								<a class="btn btn-lg btn-success" href="reg.jsp" role="button">Sign
									up today</a>
							</p>
						</div>
					</div>
			</div>
			<div class="item">
				<img
					data-src="holder.js/900x500/auto/#666:#6a6a6a/text:Second slide"
					alt="Second slide">
					<div class="container">
						<div class="carousel-caption">
							<h1>论坛视频展示</h1>
							<p>很多音乐达人，快来吧！！！！！！！！！！！！</p>
							<p>
								<a class="btn btn-lg btn-success" href="#" role="button">Learn
									more</a>
							</p>
						</div>
					</div>
			</div>
			<div class="item">
				<img data-src="holder.js/900x500/auto/#555:#5a5a5a/text:Third slide"
					alt="Third slide">
					<div class="container">
						<div class="carousel-caption">
							<h1>论坛活动</h1>
							<p>志同道合的人等着你！！！！</p>
							<p>
								<a class="btn btn-lg btn-success" href="#" role="button">Browse
									gallery</a>
							</p>
						</div>
					</div>
			</div>
		</div>
		<a class="left carousel-control" href="#myCarousel" data-slide="prev"><span
			class="glyphicon glyphicon-chevron-left"></span></a> <a
			class="right carousel-control" href="#myCarousel" data-slide="next"><span
			class="glyphicon glyphicon-chevron-right"></span></a>
	</div>
	<!-- /.carousel -->
	<!-- Marketing messaging and featurettes
    ================================================== -->
	<!-- Wrap the rest of the page in another container to center all the content. -->

	<div class="container marketing">

		<!-- Three columns of text below the carousel -->
		<div class="row">
			<div class="col-lg-4">
				<img class="img-circle" data-src="holder.js/140x140"
					alt="Generic placeholder image">
					<h2>Heading</h2>
					<p>Donec sed odio dui. Etiam porta sem malesuada magna mollis
						euismod. Nullam id dolor id nibh ultricies vehicula ut id elit.
						Morbi leo risus, porta ac consectetur ac, vestibulum at eros.
						Praesent commodo cursus magna.</p>
					<p>
						<a class="btn btn-default" href="#" role="button">View details
							&raquo;</a>
					</p>
			</div>
			<!-- /.col-lg-4 -->
			<div class="col-lg-4">
				<img class="img-circle" data-src="holder.js/140x140"
					alt="Generic placeholder image">
					<h2>Heading</h2>
					<p>Duis mollis, est non commodo luctus, nisi erat porttitor
						ligula, eget lacinia odio sem nec elit. Cras mattis consectetur
						purus sit amet fermentum. Fusce dapibus, tellus ac cursus commodo,
						tortor mauris condimentum nibh.</p>
					<p>
						<a class="btn btn-default" href="#" role="button">View details
							&raquo;</a>
					</p>
			</div>
			<!-- /.col-lg-4 -->
			<div class="col-lg-4">
				<img class="img-circle" data-src="holder.js/140x140"
					alt="Generic placeholder image">
					<h2>Heading</h2>
					<p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis
						in, egestas eget quam. Vestibulum id ligula porta felis euismod
						semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris
						condimentum nibh, ut fermentum massa justo sit amet risus.</p>
					<p>
						<a class="btn btn-default" href="#" role="button">View details
							&raquo;</a>
					</p>
			</div>
			<!-- /.col-lg-4 -->
		</div>
		<!-- /.row -->
		<!-- START THE FEATURETTES -->

		<hr class="featurette-divider">

			<div class="row featurette">
				<div class="col-md-7">
					<h2 class="featurette-heading">
						First featurette heading. <span class="text-muted">It'll
							blow your mind.</span>
					</h2>
					<p class="lead">Donec ullamcorper nulla non metus auctor
						fringilla. Vestibulum id ligula porta felis euismod semper.
						Praesent commodo cursus magna, vel scelerisque nisl consectetur.
						Fusce dapibus, tellus ac cursus commodo.</p>
				</div>
				<div class="col-md-5">
					<img class="featurette-image img-responsive"
						data-src="holder.js/500x500/auto" alt="Generic placeholder image">
				</div>
			</div>

			<hr class="featurette-divider">

				<div class="row featurette">
					<div class="col-md-5">
						<img class="featurette-image img-responsive"
							data-src="holder.js/500x500/auto" alt="Generic placeholder image">
					</div>
					<div class="col-md-7">
						<h2 class="featurette-heading">
							Oh yeah, it's that good. <span class="text-muted">See for
								yourself.</span>
						</h2>
						<p class="lead">Donec ullamcorper nulla non metus auctor
							fringilla. Vestibulum id ligula porta felis euismod semper.
							Praesent commodo cursus magna, vel scelerisque nisl consectetur.
							Fusce dapibus, tellus ac cursus commodo.</p>
					</div>
				</div>

				<hr class="featurette-divider">

					<div class="row featurette">
						<div class="col-md-7">
							<h2 class="featurette-heading">
								And lastly, this one. <span class="text-muted">Checkmate.</span>
							</h2>
							<p class="lead">Donec ullamcorper nulla non metus auctor
								fringilla. Vestibulum id ligula porta felis euismod semper.
								Praesent commodo cursus magna, vel scelerisque nisl consectetur.
								Fusce dapibus, tellus ac cursus commodo.</p>
						</div>
						<div class="col-md-5">
							<img class="featurette-image img-responsive"
								data-src="holder.js/500x500/auto"
								alt="Generic placeholder image">
						</div>
					</div>

					<hr class="featurette-divider">

						<!-- /END THE FEATURETTES -->


						<!-- FOOTER -->
						<footer>
						<p class="pull-right">
							<a href="#">Back to top</a>
						</p>
						<p>
							&copy; 2013 Company, Inc. &middot; <a href="#">Privacy</a>
							&middot; <a href="#">Terms</a>
						</p>
						</footer>
	</div>
	<!-- /.container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="js/jquery-1.10.2.js"></script>
	<script src="styles/bootstrap-3.0.3-dist/dist/js/bootstrap.min.js"></script>
	<script src="http://cdn.bootcss.com/holder/2.0/holder.min.js"></script>
</body>
</html>