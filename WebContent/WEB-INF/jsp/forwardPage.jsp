<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--
＊ForwardPage画面
＊オートインデントを使いました。
-->
<%
String name = request.getParameter("name");
String gender = request.getParameter("gender");
if(gender.equals("0")){
	gender = "男性";
} else if(gender.equals("1")){
	gender = "女性";
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録もどき</title>
</head>
<body>
	ForwardPage!!
	<p><%=name%>さん(<%=gender%>)を登録しました！</p>
</body>
</html>