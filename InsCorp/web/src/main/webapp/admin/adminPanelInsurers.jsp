<%@ page import="kabilova.tu.inscorp.server.web.UserServer" %>
<%@ page import="kabilova.tu.inscorp.model.user.Insurer" %><%--
  Created by IntelliJ IDEA.
  User: AcerPC
  Date: 20.10.2017 г.
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <%
//        String userName = null;
//        Cookie[] cookies = request.getCookies();
//        if(cookies != null) {
//            for(Cookie cookie: cookies) {
//                if(cookie.getName().equals("user")) {
//                    userName = cookie.getValue();
//                }
//            }
//        }
//        if(userName == null) {
//            response.sendRedirect("login.jsp");
//        }
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

<div class="viewInsurers shell">
    <form>
        <table border="1">
            <th>Служебен №</th>
            <th>Потребителско име</th>
            <th>Име</th>
            <th>Презиме</th>
            <th>Фамилия</th>
            <th>Телефонен №</th>
            <th>Е-майл</th>

                <%
					UserServer userServer = new UserServer(new Insurer());
					for(Insurer insurer : userServer.readInsurers()) { %>
            <tr>
                <td><%=insurer.getInsurerID()%></td>
                <td><%=insurer.getUsername()%></td>
                <td><%=insurer.getFirstName()%></td>
                <td><%=insurer.getSecondName()%></td>
                <td><%=insurer.getLastName()%></td>
                <td><%=insurer.getPhoneNumber()%></td>
                <td><%=insurer.getEmail()%></td>
            </tr>
    </form>
    <% } %>
    </table>
</div>
</body>
</html>
