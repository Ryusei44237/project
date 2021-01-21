<%@page import="Bean.account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja" class="no-js">
    <head>
    <!-- 確認 -->
        <meta charset="UTF-8">
        <meta name=" viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/timeline.css">
        <script src="https://kit.fontawesome.com/86a6bb02b6.js"	crossorigin="anonymous"></script>
        <title>Registration</title>
</head>


<body>
 <div id="modal">
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
                <form id="postform" action="/sotuken-project/PostServlet" method="post">
                    <class class="form-group">
                        <label for="exampleInputEmail1">投稿文</label>
                        <input type="text"class="form-control" id = "testname" name="PostContents" aria-describedby="emailHelp"placeholder="投稿文を入力">
                        <input type="hidden"name="accountid" value=<%=request.getAttribute("accountid")%>>
                    </class>
                            <div class="form-group col-md-4">
                                 <select id="inputState"
                                    class="form-control" name="PostTags">
                                    <option selected>タグ選択</option>
                                    <option value="1">台風</option>
                                    <option value="2">地震</option>
                                    <option value="3">津波</option>
                                    <option value="4">洪水</option>
                                </select>
                            </div>
                            <input type="hidden" name="value" value="post">
                        <button type="submit" class="btn btn-primary" id="submit">投稿</button>
                    </div>
                    </form>
            </div>
        </div>
    </div>
    </div>
	<section class="header">
        <div class="header_items">
            <!-- ロゴ -->
            <div id="h_item1">
                <div id="logo">
                    <img src="https://getbootstrap.jp/docs/4.5/assets/brand/bootstrap-solid.svg" alt="">
                </div>
            </div>
            <!-- 画面遷移 -->
            <div id="h_item2">
                <div id="form_group">
                    <form action="/sotuken-project/tourokuServlet" method="get"><button type="submit" class="clear-decoration">登録</button></form>
                    <form action="/sotuken-project/TestServlet" method="get"><button type="submit" class="clear-decoration">ログイン</button></form>
                    <form action="/sotuken-project/MyPageServlet" method="get"><input type="hidden" name="account_id" value=<%=request.getAttribute("accountid")%>><button type="submit" class="clear-decoration" name="name" value=<%=request.getAttribute("getname") %>>マイページ</button></form>
                </div>
            </div>
            <!-- タイトル -->
            <div id="h_item3">
                <div id="title">
                    <p id="title-text">災害情報共有</p>
                </div>
            </div>
            <!-- 検索バー -->
            <div id="h_item4">
                <div id="searchform">
                    <form class="form-inline my-2 my-lg-0" style="width: 20vw; display: flex;" action="/sotuken-project/PostSearch"method="get">
                        <input class="form-control mr-sm-2" type="text" name="Search"placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>
                </div>
                 <!-- 投稿ボタン -->
                 <button type="button" data-toggle="modal" data-target="#exampleModal" class="btn btn-primary" id="post_button">投稿</button>
            </div>
        </div>
    </section>


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
          <div class="name">中村<span class="name_reply">@usa_tan</span></div>
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
          <div class="name">い<span class="name_reply">@usa_tan</span></div>
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
          <div class="name">大沼<span class="name_reply">@usa_tan</span></div>
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
          <div class="name">ヨロズツバサ<span class="name_reply">@abcde</span></div>
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
          <div class="name">萬<span class="name_reply">@usa_tan</span></div>
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
