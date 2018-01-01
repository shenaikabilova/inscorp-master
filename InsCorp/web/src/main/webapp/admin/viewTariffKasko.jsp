<%@ page import="kabilova.tu.inscorp.server.web.TariffKaskoServer" %>
<%@ page import="kabilova.tu.inscorp.model.tariff.TariffKasko" %><%--
  Created by IntelliJ IDEA.
  User: AcerPC
  Date: 30.12.2017 г.
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String username = null;
        String password = null;
        if(!request.getSession().isNew()) {
            username = session.getAttribute("username").toString();
            password = session.getAttribute("password").toString();
        }
        else {
            response.sendRedirect("/AdminLogin");
        }
    %>
    <title><%=username %></title>
    <link href = "../style.css" type="text/css" rel = "stylesheet"/>
</head>

<body>
<div class="menu">
    <ul class="menu-nav">
        <li><a href="#">Застрахователни агенти</a>
            <ul>
                <li><a href="adminPanelAddInsurer.jsp">Добави</a></li>
                <li><a href="adminPanelInsurers.jsp">Изведи</a></li>
                <li><a href="adminPanelSearchUser.jsp">Промени</a></li>
                <li><a href="adminPanelDeleteUser.jsp">Изтрий</a></li>
            </ul>
        </li>
        <li><a href="#">МПС</a>
            <ul>
                <li><a href="adminPanelAddVehicleType.jsp">Добави тип МПС</a></li>
                <li><a href="adminPanelAddVehicleSubtype.jsp">Добави подтип МПС</a></li>
            </ul>
        </li>
        <li><a href="#">Тарифиране</a>
            <ul>
                <li><a href="#">ГО</a>
                    <ul>
                        <li><a href="loadTariffGO.jsp">Добави тарифа ГО</a></li>
                        <li><a href="viewTariffGo.jsp">Изведи тарифиране</a></li>
                    </ul>
                </li>
                <li><a href="#">Каско</a>
                    <ul>
                        <li><a href="loadTariffKasko.jsp">Добави тарифа Каско</a></li>
                        <li><a href="viewTariffKasko.jsp">Изведи тарифиране</a></li>
                    </ul>
                </li>
            </ul>
        </li>
        <li><a href="adminPanelSettings.jsp">Настройки</a></li>
        <li><a href="AdminLogout">Изход</a></li>
    </ul>
</div>

<form>
    <table border="1">
        <th>Тип МПС</th>
        <th>Подтоп МПС</th>
        <th>Застрахователна стойност</th>

        <%
            TariffKaskoServer tariffGoServer = new TariffKaskoServer(new TariffKasko());
            for(TariffKasko kasko : tariffGoServer.loadAllTariffKasko()) {
        %>
        <tr>
            <td><%=kasko.getVechileType().getVehicleType()%></td>
            <td><%=kasko.getVehicleSubtype().getSubtype()%></td>
            <td><%=kasko.getKaskoPercent()%></td>
        </tr>
        <% } %>
    </table>
</form>
</body>
</html>