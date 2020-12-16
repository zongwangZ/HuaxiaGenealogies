<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/logupService" method="post">
        <p>身份证号：<input type="text" name="userId"/></p>
        <p>姓名：<input type="text" name="userName"/></p>
        <p>密码：<input type="text" name="userPassword"/></p>
        <p>确认密码：<input type="text" name="userPasswordConfirm"/></p>
        <input type="submit" value="提交">
    </form>
</body>
</html>
