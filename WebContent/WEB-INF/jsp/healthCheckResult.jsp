<%@page import="model.Health"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--
＊健康診断の結果画面
＊オートインデントを使いました。
-->
<%
Health health = (Health)request.getAttribute("health");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ健康診断</title>
</head>
<body>
	<h1>スッキリ健康診断の結果</h1>
	<p>
		氏名：<%= health.getName() %><br>
		年齢：<%= health.getAge() %><br>
		身長：<%= health.getHeight() %><br>
		体重：<%= health.getWeight() %><br>
		BMI：<%= health.getBmi() %><br>
		体型：<%= health.getBodyType() %>
	</p>
	<a href="/example/HealthCheck">戻る</a>
</body>
</html>