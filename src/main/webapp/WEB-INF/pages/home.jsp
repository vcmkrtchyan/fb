<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form style="position: absolute; right: 10px; top: 10px;" action="${pageContext.request.contextPath}/logout" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Logout">
</form>
<form action="${pageContext.request.contextPath}/" method="post" >
    <label>
        What's on your mind? <textarea name="data"></textarea>
    </label>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Post">
</form>

<c:forEach items="${posts}" var="post">
    ${post.user} - ${post.data}
    <hr />
</c:forEach>
</body>
</html>
