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
          <a class="nav-link" href="/WebContent/WEB-INF/view/login.jsp">ログイン<span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/WebContent/WEB-INF/view/mypage.jsp">マイページ</a>
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

  <!-- ▼▼twitter風ここから -->
  <div class="twitter__container">
    <!-- ▼タイムラインエリア scrollを外すと高さ固定解除 -->
    <div class="twitter__contents scroll">
    <!-- ここに吹き出しやスタンプのタグを追加していく -->
    <!-- 記事エリア -->
      <div class="twitter__block">
        <figure>
          <img src="icon.png" />
        </figure>
        <div class="twitter__block-text">
          <div class="name">うさきち<span class="name_reply">@usa_tan</span></div>
          <div class="date">10分前</div>
          <div class="text">
            今日も終電だよ～<br>
          </div>
        </div>
      </div>

      <!-- 記事エリア -->
      <div class="twitter__block">
        <figure>
          <img src="icon.png" />
        </figure>
        <div class="twitter__block-text">
          <div class="name">あ<span class="name_reply">@abcde</span></div>
          <div class="date">1時間前</div>
          <div class="text">
            残業でお腹空いたから朝までやってるお店でラーメン食べることにした(^o^)神の食べ物すぎる・・うまぁ
            <div class="in-pict">
              <img src="sample.jpg">
            </div>
          </div>
        </div>
      </div>

      <!-- 記事エリア -->
      <div class="twitter__block">
        <figure>
          <img src="icon.png" />
        </figure>
        <div class="twitter__block-text">
          <div class="name">うさきち<span class="name_reply">@usa_tan</span></div>
          <div class="date">2018/06/24 5:34</div>
          <div class="text">
            睡眠２時間で出社なんだけど…
            <a href="https://nakox.jp/">https://nakox.jp/</a>
          </div>
        </div>
      </div>

      <div class="twitter__block">
        <figure>
          <img src="icon.png" />
        </figure>
        <div class="twitter__block-text">
          <div class="name">うさきち<span class="name_reply">@usa_tan</span></div>
          <div class="date">10分前</div>
          <div class="text">
            今日も終電だよ～<br>
          </div>
        </div>
      </div>

      <!-- 記事エリア -->
      <div class="twitter__block">
        <figure>
          <img src="icon.png" />
        </figure>
        <div class="twitter__block-text">
          <div class="name">あ<span class="name_reply">@abcde</span></div>
          <div class="date">1時間前</div>
          <div class="text">
            残業でお腹空いたから朝までやってるお店でラーメン食べることにした(^o^)神の食べ物すぎる・・うまぁ
            <div class="in-pict">
              <img src="sample.jpg">
            </div>
          </div>
        </div>
      </div>

      <!-- 記事エリア -->
      <div class="twitter__block">
        <figure>
          <img src="icon.png" />
        </figure>
        <div class="twitter__block-text">
          <div class="name">うさきち<span class="name_reply">@usa_tan</span></div>
          <div class="date">2018/06/24 5:34</div>
          <div class="text">
            睡眠２時間で出社なんだけど…
            <a href="https://nakox.jp/">https://nakox.jp/</a>
          </div>
        </div>
      </div>

    </div>
    <!--　▲タイムラインエリア ここまで -->
  </div>
  <!--　▲twitter風ここまで -->

	</body>
</html>
