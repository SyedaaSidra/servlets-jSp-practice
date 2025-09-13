<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h2>Hello from JSP!</h2>
<a href="${pageContext.request.contextPath}/hello">Go to HelloServlet</a>
<form action="users" method="post">
    Name: <input type="text" name="name">
    Email: <input type="email" name="email">
    <button type="submit">Add User</button>
</form>
</body>
</html>
