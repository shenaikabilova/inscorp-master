<%--
  Created by IntelliJ IDEA.
  User: AcerPC
  Date: 20.10.2017 г.
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%--<%@page import="kabilova.tu.inscorp.model.user.Insurer"%>--%>
<%--<%@page import="kabilova.tu.inscorp.daoimpl.hb.UserDaoImpl"%>--%>
<%--<%@page import="dao_api.InsurerDAO"%>--%>

<%--<%--%>
    <%--try {--%>
        <%--Class.forName("com.mysql.jdbc.Driver");--%>
    <%--}--%>
    <%--catch (Exception e) {--%>
        <%--throw new UnavailableException(e.getMessage());--%>
    <%--}--%>
<%--%>--%>

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
        <li><a href="#">МПС</a>
            <lu>
                <li><a href="adminPanelAddVehicleType.jsp">Добави тип МПС</a></li>
                <li><a href="adminPanelAddVehicleSubtype.jsp">Добави подтип МПС</a></li>
            </lu>
        </li>
        <li><a href="AdminLogout">Изход</a></li>
    </ul>
</div>

<div class="viewInsurers shell">
    <%--<form action = "updateInsurer" method="get">--%>
        <%--<table border="1">--%>
            <%--<th>ID</th>--%>
            <%--<th>Име</th>--%>
            <%--<th>Фамилия</th>--%>
            <%--<th>Е-майл</th>--%>
            <%--<th>Парола</th>--%>

                <%--<%--%>
					<%--InsurerDAO insurers = new InsurerDAOImpl();--%>
					<%--for(Insurer insurer : insurers.listInsurers()) { %>--%>
            <%--<tr>--%>
                <%--<td><%=insurer.getInsurerId()%></td>--%>
                <%--<td><%=insurer.getInsurerName()%></td>--%>
                <%--<td><%=insurer.getInsurerFamily()%></td>--%>
                <%--<td><%=insurer.getInsurerEmail()%></td>--%>
                <%--<td><%=insurer.getInsurerPassword()%></td>--%>
            <%--</tr>--%>
    <%--</form>--%>
    <%--<% } %>--%>
    <%--</table>--%>
</div>
</body>
</html>
