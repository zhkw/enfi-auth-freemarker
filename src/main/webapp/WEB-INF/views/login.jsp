<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2020/6/20
  Time: 8:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><font color="red">${errorMessage}</font></p>
<form action="/login.do" method="POST">
    Name : <input name="name" type="text" /> Password : <input name="password" type="password" /> <input type="submit" />
</form>
</body>
</html>
