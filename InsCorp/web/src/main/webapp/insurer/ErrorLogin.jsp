<%--
  Created by IntelliJ IDEA.
  User: AcerPC
  Date: 20.10.2017 г.
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>InsuranceCorporation</title>
        <link href = "../style.css" type="text/css" rel = "stylesheet"/>
    </head>

    <body>
        <center class="error-msg"><% String message = (String) request.getAttribute("errmsg"); %>
            <%=message %></center>
    </body>
</html>