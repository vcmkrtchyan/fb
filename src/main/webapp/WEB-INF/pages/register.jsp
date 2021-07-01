<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/register" method="post">
    <label>
        Username: <input name="username" type="text"/>
    </label>
    <label>
        Password: <input name="password" type="password"/>
    </label>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input value="Register" type="submit">
</form>
</body>
</html>
