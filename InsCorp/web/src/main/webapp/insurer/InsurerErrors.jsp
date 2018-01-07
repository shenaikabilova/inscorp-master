<%--
  Created by IntelliJ IDEA.
  User: AcerPC
  Date: 20.10.2017 г.
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link href = "../style.css" type="text/css" rel = "stylesheet"/>
</head>

<body>
    <center><% String message = (String) request.getAttribute("errmsg"); %>
        <%=message %></center>
    </body>
</html>