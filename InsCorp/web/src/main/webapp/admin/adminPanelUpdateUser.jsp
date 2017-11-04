<%--
  Created by IntelliJ IDEA.
  User: AcerPC
  Date: 20.10.2017 г.
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <ul>
                <li><a href="adminPanelAddVehicleType.jsp">Добави тип МПС</a></li>
                <li><a href="adminPanelAddVehicleSubtype.jsp">Добави подтип МПС</a></li>
            </ul>
        </li>
        <li><a href="AdminLogout">Изход</a></li>
    </ul>
</div>


<div class="updateUser">
    <div class="shell">
        <form action="updateUser" method="get">
            <div class="form-section">
                <div class="form-row">
                    <label>ID на застраховател</label>
                    <input class="field" type="text" name="username" placeholder="Въведете № на застраховател" >
                    <input type="submit" value="Търсене" name="updateUser">
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>