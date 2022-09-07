<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--
＊Redirect画面
＊オートインデントを使いました。
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録もどき</title>
</head>
<body>
	RedirectPage!!
	<p><%=session.getAttribute("errorMsg").toString() %></p>
</body>
</html>