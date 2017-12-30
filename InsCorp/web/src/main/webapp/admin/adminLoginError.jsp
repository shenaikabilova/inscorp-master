<%--
  Created by IntelliJ IDEA.
  User: AcerPC
  Date: 13.12.2017 г.
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <center><% String message = (String) request.getAttribute("errmsg"); %>
        <%=message %></center>

</body>
</html>
