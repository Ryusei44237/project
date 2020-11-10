<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script>onLoad="setTimeout(5000)"</script>
<meta charset="UTF-8">
<title>アカウント管理</title>
</head>
<body>
<h1>insert</h1>
<form action="ManagerServlet" method="get">
	<input type="number" name="id" placeholder="アカウントID">
	<input type="text" name="name" placeholder="アカウント名">
	<input type="text" name="mail" placeholder="メールアドレス">
	<input type="text" name="password" placeholder="パスワード">
	<input type="text" name="birthday" placeholder="生年月日">
	<input type="text" name="tell" placeholder="電話番号">
	<input type="hidden" name="token"value="test">
	<input type="hidden" name="create_at" value="20200101">
	<input type="hidden" name="update_at" value="20200101">
	<input type="submit">
</form>
</body>
</html>