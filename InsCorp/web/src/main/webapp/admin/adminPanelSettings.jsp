<%--
  Created by IntelliJ IDEA.
  User: AcerPC
  Date: 20.10.2017 г.
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%--<%@page import="dao_jdbc.InsurerDAOImpl"%>--%>
<%--<%@page import="dao_api.InsurerDAO"%>--%>
<%--<%--%>
    <%--try {--%>
        <%--Class.forName("com.mysql.jdbc.Driver");--%>
    <%--}--%>
    <%--catch (Exception e) {--%>
        <%--throw new UnavailableException(e.getMessage());--%>
    <%--}--%>
<%--%>--%>

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

<html>
<head>
    <title><%=userName %></title>
    <link href = "../style.css" type="text/css" rel = "stylesheet"/>
</head>

<body>
<div class="menu">
    <div class="shell">
        <ul class="menu-nav">
            <li><a href="adminPanelAddInsurer.jsp">Добави</a>
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
                <ul>
                    <li><a href="adminPanelAddVehicleType.jsp">Добави тип МПС</a></li>
                    <li><a href="adminPanelAddVehicleSubtype.jsp">Добави подтип МПС</a></li>
                </ul>
            </li>
            <li><a href="AdminLogout">Изход</a></li>
        </ul>
    </div>
</div>

<div class="adminpanelSettings">
    <div class="shell">
        <%--<form action="adminPanelSettings" method="post">--%>
            <%--<table width="100%">--%>
                <%--<%--%>
                    <%--InsurerDAO insurer = new InsurerDAOImpl();--%>
                <%--%>--%>
                <%--<tr>--%>
                    <%--<td></td>--%>
                    <%--<td><h3>Настройки на администратора</h3></td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td><label for="admin">ID</label></td>--%>
                    <%--<td><input type="text" class="field" name="userID" size="30" value=<%=insurer.searchUserName(userName).getInsurerId()%> ></td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td><label for="adminName">Име</label></td>--%>
                    <%--<td><input type="text" class="field" name="userName" size="30" value=<%=insurer.searchUserName(userName).getInsurerName()%>></td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td><label>Фамилия</label>--%>
                    <%--<td><input type="text" class="field" name="userFamily" size="30" value=<%=insurer.searchUserName(userName).getInsurerFamily()%>></td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td><label for="adminEmail">Е-майл</label></td>--%>
                    <%--<td><input type="text" class="field" name="userEmail" size="30" value=<%=insurer.searchUserName(userName).getInsurerEmail()%>></td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td><label for="password1">Парола</label></td>--%>
                    <%--<td><input type="password" class="field" name="password1" size="30" value=<%=insurer.searchUserName(userName).getInsurerPassword()%>></td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td><label for="password2">Повторете парола</label></td>--%>
                    <%--<td><input type="password" class="field" name="password2" size="30"></td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td></td>--%>
                    <%--<td><input type="submit" value="Промени"></td>--%>
                <%--</tr>--%>
            <%--</table>--%>
        <%--</form>--%>
    </div>
</div>
</body>
</html>