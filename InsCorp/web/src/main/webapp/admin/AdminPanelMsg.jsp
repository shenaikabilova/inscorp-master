<%--
  Created by IntelliJ IDEA.
  User: AcerPC
  Date: 20.10.2017 г.
  Time: 12:19
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
                    <li><a href="admin/adminPanelAddInsurer.jsp">Добави</a></li>
                    <li><a href="admin/adminPanelSearchUser.jsp">Промени</a></li>
                    <li><a href="admin/adminPanelDeleteUser.jsp">Изтрий</a></li>
                    <li><a href="admin/adminPanelInsurers.jsp">Изведи</a></li>
                </ul>
            </li>
            <li><a href="#">МПС</a>
                <ul>
                    <li><a href="#">Тип МПС</a>
                        <ul>
                            <li><a href="admin/addVehicleType.jsp">Добави</a></li>
                            <li><a href="admin/vehicleSubtypeUpdate.jsp">Промени</a></li>
                            <li><a href="admin/vehicleTypeDelete.jsp">Изтрий</a></li>
                            <li><a href="admin/loadVehicleType.jsp">Преглед</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Подтип МПС</a>
                        <ul>
                            <li><a href="admin/addVehicleSubtype.jsp">Добави</a></li>
                            <li><a href="admin/vehicleSubtypeUpdate.jsp">Промени</a></li>
                            <li><a href="admin/vehicleSubtypeDelete.jsp">Изтрий</a></li>
                            <li><a href="admin/loadVehicleSubtype.jsp">Преглед</a></li>
                        </ul>
                    </li>
                </ul>
            </li>
            <li><a href="#">Тарифиране</a>
                <ul>
                    <li><a href="#">ГО</a>
                        <ul>
                            <li><a href="admin/loadTariffKasko.jsp">Добави тарифа ГО</a></li>
                            <li><a href="admin/viewTariffGo.jsp">Изведи тарифиране</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Каско</a>
                        <ul>
                            <li><a href="admin/addTariffKasko.jsp">Добави тарифа Каско</a></li>
                            <li><a href="admin/viewTariffKasko.jsp">Изведи тарифиране</a></li>
                        </ul>
                    </li>
                </ul>
            </li>
            <li><a href="admin/adminPanelSettings.jsp">Настройки</a></li>
            <li><a href="AdminLogout">Изход</a></li>
        </ul>
    </div>

        <center><% String message = (String) request.getAttribute("errmsg"); %>
            <%=message %></center>
    </body>
</html>