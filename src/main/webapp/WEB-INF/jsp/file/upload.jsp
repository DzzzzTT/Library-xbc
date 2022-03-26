<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html lang="en" >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>文件上传</title>
</head>
<body>

<form method="post"
      action="./multipart" enctype="multipart/form-data">
<%--    <img th:src="@{photoURL}">--%>
    <input type="file" name="photo" value="请选择上传的文件" />
    <input type="submit" value="提交" />
</form>

</body>
</html>