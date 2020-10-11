<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>File Upload - Insert 페이지</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
 
<h1>파일 업로드</h1>
<form action="fileupload" method="post" enctype="multipart/form-data">
    <input type="file" name="uploadfile" placeholder="파일 선택" /><br/>
    <input type="submit" value="업로드">
</form>

<h2>다중 파일 업로드</h2>
<form action="fileupload2" method="post" enctype="multipart/form-data">
    <input type="file" name="uploadfiles" placeholder="파일 선택" multiple/><br/>
    <input type="submit" value="업로드">
</form>

</body>
</html>
