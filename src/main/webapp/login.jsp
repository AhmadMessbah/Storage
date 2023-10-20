<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="j_security_check">
    <label for="userId">UserName</label>
    <input id="userId" type="text" name="j_username">
    <label for="passId">Password</label>
    <input id="passId" type="password" name="j_password">
    <input type="submit" value="Login">
</form>
</body>
</html>
