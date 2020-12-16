<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/loginService" method="post">
        <p>身份证号：<input type="text" name="userId"/></p>
        <p>密码：<input type="text" name="userPassword"/></p>
        <input type="submit" value="登录">
    </form>
</body>
</html>
