<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--
＊入力画面
＊オートインデントを使いました。
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ健康診断</title>
</head>
<body>
	<h1>スッキリ健康診断</h1>
	<form action="/example/HealthCheck" method="post">
		氏名：<input type="text" name="name"><br>
		年齢：<input type="text" name="age">歳<br>
		身長：<input type="text" name="height">(cm)<br>
		体重：<input type="text" name="weight">(kg)<br>
		<input type="submit" value="診断">
	</form>
</body>
</html>