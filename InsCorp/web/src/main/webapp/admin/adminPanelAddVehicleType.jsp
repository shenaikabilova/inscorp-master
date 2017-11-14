<%--
  Created by IntelliJ IDEA.
  User: AcerPC
  Date: 20.10.2017 г.
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <%
//            String userName = null;
//            Cookie[] cookies = request.getCookies();
//            if(cookies != null) {
//                for(Cookie cookie: cookies) {
//                    if(cookie.getName().equals("user")) {
//                        userName = cookie.getValue();
//                    }
//                }
//            }
//            if(userName == null) {
//                response.sendRedirect("login.jsp");
//            }
            String username = session.getAttribute("username").toString();
            String password = session.getAttribute("password").toString();
        %>
        <title><%=username %></title>
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
            <li><a href="AdminLogout">Изход</a></li>
        </ul>
    </div>

        <div>
            <div class="shell">
                <form action="/adminPanelAddVehicleType" method="post">
                    <label>Тип МПС</label>
                    <input type="text" name="vehicleType" placeholder="Тип МПС" maxlength="50">
                    <input type="submit" value="Добави">
                </form>
            </div>
        </div>
    </body>
</html>
