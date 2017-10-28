<%--
  Created by IntelliJ IDEA.
  User: AcerPC
  Date: 20.10.2017 г.
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@page import="model.Insurer"%>--%>
<%--<%@page import="java.util.List"%>--%>
<html>
<head>
    <%
        String userName = null;
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for(Cookie cookie: cookies) {
                if(cookie.getName().equals("user")) {
                    userName = cookie.getValue();
                }
            }
        }
        if(userName == null) {
            response.sendRedirect("login.jsp");
        }
    %>
    <title><%=userName %></title>
    <link href = "../style.css" type="text/css" rel = "stylesheet"/>
</head>

<body>
<div class="menu">
    <ul class="menu-nav">
        <li><a href="adminPanel.jsp">Добави</a>
            <ul>
                <li><a href="adminPanelAddInsurer.jsp">Застрахователен агент</a></li>
            </ul>
        </li>
        <li><a href="adminPanelSettings.jsp">Настройки</a></li>
        <li><a href="#">Застрахователни агенти</a>
            <ul>
                <li><a href="adminPanelInsurers.jsp">Изведи</a></li>
                <li><a href="adminPanelUpdateUser.jsp">Промени</a></li>
                <li><a href="adminPanelDeleteUser.jsp">Изтрий</a></li>
            </ul>
        </li>
        <li><a href="#">МПС</a>
            <lu>
                <li><a href="adminPanelAddVehicleType.jsp">Добави тип МПС</a></li>
                <li><a href="adminPanelAddVehicleSubtype.jsp">Добави подтип МПС</a></li>
            </lu>
        </li>
        <li><a href="AdminLogout">Изход</a></li>
    </ul>
</div>

<div class="adminpanelSettings">
    <div class="shell">
        <%--<form action="updateInsurer" method="post">--%>
            <%--<table width="100%">--%>
                <%--<%--%>
                    <%--List<Insurer> insurer = (List<Insurer>)request.getAttribute("result");--%>
                    <%--for(Insurer i : insurer) {--%>
                <%--%>--%>
                <%--<tr>--%>
                    <%--<td></td>--%>
                    <%--<td><h3>Настройки на застраховател</h3></td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td><label for="admin">ID</label></td>--%>
                    <%--<td><input type="text" class="field" name="userID" size="30" value=<%=i.getInsurerId()%> readonly="readonly"></td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td><label for="adminName">Име</label></td>--%>
                    <%--<td><input type="text" class="field" name="userName" size="30" value=<%=i.getInsurerName()%>></td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td><label>Фамилия</label>--%>
                    <%--<td><input type="text" class="field" name="userFamily" size="30" value=<%=i.getInsurerFamily()%>></td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td><label for="adminEmail">Е-майл</label></td>--%>
                    <%--<td><input type="text" class="field" name="userEmail" size="30" value=<%=i.getInsurerEmail()%>></td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td><label for="password1">Парола</label></td>--%>
                    <%--<td><input type="password" class="field" name="password1" size="30" value=<%=i.getInsurerPassword()%>></td>--%>
                <%--</tr>--%>
                <%--<% } %>--%>
                <%--<tr>--%>
                    <%--<td><label for="password2">Повторете парола</label></td>--%>
                    <%--<td><input type="password" class="field" name="password2" size="30"></td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td></td>--%>
                    <%--<td><input type="submit" value="Промени" name="updateInsurer"></td>--%>
                <%--</tr>--%>
            <%--</table>--%>
        <%--</form>--%>
    </div>
</div>
</body>
</html>