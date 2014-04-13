<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<form action="formservlet" method="post">
			isim:<br>
			<input name="name" type="text"></input><br>
			sifre:<br>
			<input name="password" type="password"></input><br>
			<input type="submit" value="gönder">
			
		</form>
	</center>
	<%String isim = (String) request.getSession().getAttribute("name"); %>
	<%=isim %>
<a href="htmlservlet">Html Sevlet</a><br>
<a href="sessionsil">session sil</a><br>
<a href="htmlservletwithutil">Html Sevlet Yardımcı class</a><br>
<a href="headerservlet">Header Bilgisi</a><br>
<a href="browsercheck">Browser</a><br>
</body>
</html>