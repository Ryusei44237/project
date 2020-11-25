<%@page import="Bean.account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- トップページ　html -->
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<!-- end -->
<!-- font awesome CSS -->
<script src="https://kit.fontawesome.com/86a6bb02b6.js"
	crossorigin="anonymous"></script>
<!-- end -->
<title><%=request.getAttribute("getname")%>さんのトップページ</title>

<!-- 投稿ボタンを押下した際に出てくる投稿モーダル -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">投稿エリア</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form action="/sotuken-project/PostServlet" enctype="multipart/form-data" method="POST" >
					<div class="form-group">
						<label for="exampleInputEmail1">投稿文</label>
						 <input type="text"class="form-control" name="PostContents" aria-describedby="emailHelp"placeholder="投稿文を入力">
						<input type="hidden"name="accountid"value=<%=request.getAttribute("getId")%>>
						<input type="file" name="file"/>
						<small id="emailHelp"class="form-text text-muted">誹謗中傷、荒らし行為禁止</small>
					</div>
					<div class="form-group form-check">
						<input type="checkbox" class="form-check-input" id="exampleCheck1">
						<label class="form-check-label" for="exampleCheck1">プライバシーポリシーに同意</label>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">キャンセル</button>
						<input type="submit" class="btn btn-primary" value="投稿">
					</div>
				</form>
			</div>

		</div>
	</div>
</div>
<!-- 投稿モーダルここまで -->
<div class="modal fade bd-example-modal-sm" tabindex="-1" role="dialog"
	aria-labelledby="mySmallModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<a href="">環境設定</a> <a href="">ガイドライン</a> <a href="">ログアウト</a>
			<!-- <a href=""></a> -->
		</div>
	</div>
</div>
<!--  -->

</head>
<!-- ヘッド終了　以下body -->
<body>
	<!-- hedear開始 -->
	<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="toppage.html"> <img
				src="../image/空.jpg" width="30" height="30"
				class="d-inline-block align-top" alt=""> 卒研ページ
			</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<!--ここでページ遷移を分岐させる-->
					<ul class="navbar-nav mr-auto">
						<li>
							<form action="/sotuken-project/tourokuServlet" method="get">
								<button type="submit" class="clear-decoration">登録</button>
							</form>
					</li>
						<li>
							<form action="/sotuken-project/TestServlet" method="get">
								<button type="submit" class="clear-decoration">ログイン</button>
							</form>
						</li>
						<li>
							<form action="/sotuken-project/UpdateServlet" method="get">
								<button type="submit" class="clear-decoration" name="id" value=<%=request.getAttribute("getid") %>>マイページ</button>
							</form>
						</li>
					</ul>

				<!--素材-->
				<div class="searchform">
					<form class="form-inline my-2 my-lg-0"
						action="/sotuken-project/PostSearch" method="get">
						<!--ここでヘッダー投稿フォームなど右寄せ-->
						<input class="form-control mr-sm-2" type="search"
							name="SearchText" placeholder="キーワード入力" aria-label="Search">
						<!--ここ検索キーワード-->
						<button class="btn btn-outline-success my-2 my-sm-0" type="submit">検索</button>
					</form>
				</div>
				<div class="postbutton">
					<button type="button" class="btn btn-primary" data-toggle="modal"
						data-target="#exampleModal">投稿ボタン</button>
				</div>
				<!-- Small modal -->
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target=".bd-example-modal-sm">
					<i class="fas fa-cog"></i>
				</button>
			</div>
		</nav>
	</header>
	<!-- header終了 -->

	<!--ここからカルーセル機能-->
	<div id="carouselExampleIndicators" class="carousel slide"
		data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleIndicators" data-slide-to="0"
				class="active"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<iframe width="560" height="315"src="https://www.youtube-nocookie.com/embed/WV5w19J-cAA? loop=1&playlist=vdxoDyNAoH0&autoplay=1&mute=1&rel=0&modestbranding=1"frameborder="0" allowfullscreen></iframe>
			</div>
			<div class="carousel-item">
				<iframe width="560" height="315"src="https://www.youtube-nocookie.com/embed/coYw-eVU0Ks? loop=1&playlist=vdxoDyNAoH0&autoplay=1&mute=1&rel=0&modestbranding=1"frameborder="0" allowfullscreen></iframe>
			</div>
			<div class="carousel-item">
				<iframe width="560" height="315"src="https://www.youtube-nocookie.com/embed/WXoMJJCaQPU? loop=1&playlist=vdxoDyNAoH0&autoplay=1&mute=1&rel=0&modestbranding=1"frameborder="0" allowfullscreen></iframe>
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleIndicators"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>
	<!--
      ここまでカルーセル機能・ここからカード機能
    -->
	<div class="card-deck">
		<div class="card" style="width: 18rem;">
			<img src="${pageContext.request.contextPath}/app-image/東日本大震災.jpg" alt="" width="100%" height="200">
			<div class="card-body">
				<h5 class="card-title">東日本大震災</h5>
				<p class="card-text">とても大きな地震</p>
				<form action="/sotuken-project/TimelineServlet" method="get">
					<input type="hidden" value="東日本大震災" name="tag">
					<input type="submit" class="btn btn-light" value="タイムラインへgo">
				</form>
			</div>
		</div>
		<div class="card" style="width: 18rem;">
			<img src="${pageContext.request.contextPath}/app-image/熊本地震.jpg" alt="" width="100%" height="200">
			<div class="card-body">
				<h5 class="card-title">熊本地震</h5>
				<p class="card-text">大きな揺れが人々を襲った</p>
				<a href="#" class="btn btn-primary stretched-link">タイムラインへGo</a>
			</div>
		</div>
		<div class="card" style="width: 18rem;">
			<img src="${pageContext.request.contextPath}/app-image/台風.jpg" alt="" width="100%" height="200">
			<div class="card-body">
				<h5 class="card-title">台風</h5>
				<p class="card-text">太平洋側の地域に大きな被害をもたらした。</p>
				<a href="#" class="btn btn-primary stretched-link">タイムラインへGo</a>
			</div>
		</div>
	</div>
	<!--
    ここまでカード機能
  -->

	<!--
    Optional JavaScript
  -->

	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>
	<!--ここまで-->

</body>
<!-- body終了 -->

</html>
