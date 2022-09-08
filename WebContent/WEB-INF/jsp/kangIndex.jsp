<%@page import="model.SiteEV"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
SiteEV siteEV = (SiteEV) application.getAttribute("siteEV");
%>
<html>
<head>
<meta charset="UTF-8">
<title>姜くんのページ</title>
</head>
<body>
	<h1>姜くんのページへようこそ</h1>
	<p>
		<a href="/example/KangIndex?action=like">いいね</a>:
		<%=siteEV.getLike()%>人
		<a href="/example/KangIndex?action=dislike">よくないね</a>:
		<%=siteEV.getDislike()%>人
	</p>
	<h2>姜くんとは！？</h2>
	<p>・・・</p>
</body>
</html>