<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sign-up.css">
<title>Registration</title>
</head>
<header>
	<nav class="navbar navbar-expand-lg navbar-light bg-light ">
		<a class="nav-link disabled" href="../html/toppage.html">
			<div class="aaa">
				<img src="../image/空.jpg" width="30" height="30"
					class="d-inline-block align-top" alt=""> 卒研ページ
			</div>
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link"
					href="login.jsp">ログイン<span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item active"><a class="nav-link disabled"
					href="test.html">登録</a></li>
			</ul>
		</div>
	</nav>
</header>
<body>
	<form action="/sotuken-project/SignInServlet" method="post" >
		<h2>新規アカウント登録</h2>
		<p>無料でご利用いただけます。</p>
		<div class="form-group col-md-12">
			<label for="exampleInputName">アカウント名</label> <input type="text"
				class="form-control" name="name"
				placeholder="アカウント名の入力...">
		</div>
		<div class="form-group col-md-12">
			<label for="exampleInputEmail1">メールアドレス</label> <input type="email"
				class="form-control" name="mail"
				aria-describedby="emailHelp" placeholder="メールアドレスの入力...">
		</div>
		<p>生年月日</p>
		<div class="form-row" style="margin-left: 28px;">
			<div class="form-group col-md-3">
				 <input type="text"
					class="form-control" name="AcountYear" placeholder="年">
			</div>

			<div class="form-group col-md-4">
				 <select id="inputState"
					class="form-control" name="AcountMonth">
					<option selected>月</option>
					<option>01</option>
					<option>02</option>
					<option>03</option>
					<option>04</option>
					<option>05</option>
					<option>06</option>
					<option>07</option>
					<option>08</option>
					<option>09</option>
					<option>10</option>
					<option>11</option>
					<option>12</option>
				</select>
			</div>

			<div class="form-group col-md-4">
				 <select id="inputState"
					class="form-control" name="AcountDay">
					<option selected>日</option>
					<option>01</option>
					<option>02</option>
					<option>03</option>
					<option>04</option>
					<option>05</option>
					<option>06</option>
					<option>07</option>
					<option>08</option>
					<option>09</option>
					<option>10</option>
					<option>11</option>
					<option>12</option>
					<option>13</option>
					<option>14</option>
					<option>15</option>
					<option>16</option>
					<option>17</option>
					<option>18</option>
					<option>19</option>
					<option>20</option>
					<option>21</option>
					<option>22</option>
					<option>23</option>
					<option>24</option>
					<option>25</option>
					<option>26</option>
					<option>27</option>
					<option>28</option>
					<option>29</option>
					<option>30</option>
					<option>31</option>
				</select>
			</div>

		</div>
		<div class="form-group col-md-12">
			<label for="exampleInputPassword1">パスワード</label> <input
				type="password" class="form-control" id="exampleInputPassword1"
				placeholder="パスワードの入力..."> <input type="password"
				class="form-control" name="password"
				placeholder="パスワードの再入力...">
		</div>
		<div class="form-group col-md-12">
			<label for="exampleInputTel">電話番号</label> <input type="text"
				class="form-control" name="tell" placeholder="電話番号の入力...">
		</div>
		<input type="hidden" name="token" value="sessions">
		<div class="form-group">
			<input type="submit" class="btn btn-primary"
				style="margin-bottom: 5px;" value="アカウント登録">
		</div>
	</form>
</body>
</html>