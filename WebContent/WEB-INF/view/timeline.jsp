<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja" class="no-js">
    <head>
    <!-- 確認 -->
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/timeline.css">
        <title>Registration</title>
	</head>
	
    <header>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
          <a class="navbar-brand" href="#">
            <img src="../image/空.jpg" width="30" height="30" class="d-inline-block align-top" alt="">
            Bootstrap
          </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item active">
          <a class="nav-link" href="login.jsp">ログイン<span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">マイページ</a>
        </li>
        <li class="nav-item">
        
      </ul>
    </div>
    </nav>
	</header>

	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>災害情報</title>
		<meta name="description" content="Blueprint: Vertical Timeline" />
		<meta name="keywords" content="timeline, vertical, layout, style, component, web development, template, responsive" />
		<meta name="author" content="Codrops" />
		<link rel="shortcut icon" href="../favicon.ico">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/timeline.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/timeline2.css" />
		<script src="/WebContent/js/timeline.js"></script>
	</head>
	<body>
		<div class="container">
			<header class="clearfix">
				<span>Disaster Information</span>
				<h1>災害情報</h1>
				<nav>
					<a href="" class="icon-arrow-left" data-info="previous Blueprint">Previous Blueprint</a>
					<a href="" class="icon-drop" data-info="back to the Codrops article">back to the Codrops article</a>
				</nav>
			</header>
			<div class="main">
				<ul class="cbp_tmtimeline">
					<li>
						<time class="cbp_tmtime" datetime="2013-04-10 18:30"><span>4/10/13</span> <span>18:30</span></time>
						<div class="cbp_tmicon cbp_tmicon-phone"></div>
						<div class="cbp_tmlabel">
							<h2>津波来た</h2>
							<p>わたしのおうちがああああああああああああああああ</p>
						</div>
					</li>
					<li>
						<time class="cbp_tmtime" datetime="2013-04-11T12:04"><span>4/11/13</span> <span>12:04</span></time>
						<div class="cbp_tmicon cbp_tmicon-screen"></div>
						<div class="cbp_tmlabel">
							<h2>無事です</h2>
							<p>気仙沼小学校の避難所にいます。</p>
						</div>
					</li>
					<li>
						<time class="cbp_tmtime" datetime="2013-04-13 05:36"><span>4/13/13</span> <span>05:36</span></time>
						<div class="cbp_tmicon cbp_tmicon-mail"></div>
						<div class="cbp_tmlabel">
							<h2>帰宅困難者の方々へ</h2>
							<p>東京大学では帰宅困難者のために一時体育館を開放しています。水や食料もあるそうです。</p>
						</div>
					</li>
					<li>
						<time class="cbp_tmtime" datetime="2013-04-15 13:15"><span>4/15/13</span> <span>13:15</span></time>
						<div class="cbp_tmicon cbp_tmicon-phone"></div>
						<div class="cbp_tmlabel">
							<h2>地震</h2>
							<p>地震はマグニチュード8，0だそうです。みなさん津波の危険性を考えて高台に避難しましょう！</p>
						</div>
					</li>
					<li>
						<time class="cbp_tmtime" datetime="2013-04-16 21:30"><span>4/16/13</span> <span>21:30</span></time>
						<div class="cbp_tmicon cbp_tmicon-earth"></div>
						<div class="cbp_tmlabel">
							<h2>蔵人屋</h2>
							<p>避難所暮らしが続くと蔵人屋のラーメンが食べたくなる。。。もちろん全部マックス</p>
						</div>
					</li>
					<li>
						<time class="cbp_tmtime" datetime="2013-04-17 12:11"><span>4/17/13</span> <span>12:11</span></time>
						<div class="cbp_tmicon cbp_tmicon-screen"></div>
						<div class="cbp_tmlabel">
							<h2></h2>
							<p>#東日本大震災 より9年
								#熊本地震 より4年
								#スマスマ が終わってからも自然災害が沢山起きています今年はコロナも。すべての皆様が健康で日常を送れます様に…
								#復興に向けて手を繋ごう
								#SMAP の思いを継いで…
								#日本財団 #日本赤十字社
								#東日本大震災復興支援財団
								https://news.1242.com/article/123091</p>
						</div>
					</li>
					<li>
						<time class="cbp_tmtime" datetime="2013-04-18 09:56"><span>4/18/13</span> <span>09:56</span></time>
						<div class="cbp_tmicon cbp_tmicon-phone"></div>
						<div class="cbp_tmlabel">
							<h2>im tired</h2>
							<p>俺たちの広瀬すずが。。。。。</p>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</body>
</html>
