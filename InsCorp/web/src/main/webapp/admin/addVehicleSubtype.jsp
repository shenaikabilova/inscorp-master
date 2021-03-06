<%@ page import="kabilova.tu.inscorp.server.web.VehicleTypeServer" %>
<%@ page import="kabilova.tu.inscorp.model.vehicle.VehicleType" %><%--
  Created by IntelliJ IDEA.
  User: AcerPC
  Date: 4.11.2017 г.
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                        <li><a href="adminPanelAddInsurer.jsp">Добави</a></li>
                        <li><a href="adminPanelSearchUser.jsp">Промени</a></li>
                        <li><a href="adminPanelDeleteUser.jsp">Изтрий</a></li>
                        <li><a href="adminPanelInsurers.jsp">Изведи</a></li>
                    </ul>
                </li>
                <li><a href="#">МПС</a>
                    <ul>
                        <li><a href="#">Тип МПС</a>
                            <ul>
                                <li><a href="addVehicleType.jsp">Добави</a></li>
                                <li><a href="vehicleTypeUpdate.jsp">Промени</a></li>
                                <li><a href="vehicleTypeDelete.jsp">Изтрий</a></li>
                                <li><a href="loadVehicleType.jsp">Преглед</a></li>
                            </ul>
                        </li>
                        <li><a href="#">Подтип МПС</a>
                            <ul>
                                <li><a href="addVehicleSubtype.jsp">Добави</a></li>
                                <li><a href="vehicleSubtypeUpdate.jsp">Промени</a></li>
                                <li><a href="vehicleSubtypeDelete.jsp">Изтрий</a></li>
                                <li><a href="loadVehicleSubtype.jsp">Преглед</a></li>
                            </ul>
                        </li>
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

<div>
<div class="shell">
    <h3>Добавяне на подтип МПС</h3>
    <form action="/adminPanelAddVehicleSubtype" method="post">
        <div class="form-section">
            <div class="form-row">
                <div class="form-row-inner">
                    <label>Тип МПС</label>
                    <select class="field" id="vehicleType" name="vehicleType">
                        <option disabled="" selected="value"></option>
                        <%
                            VehicleTypeServer vehicleTypeServer = new VehicleTypeServer();
                            for(VehicleType vehicleType : vehicleTypeServer.read()) {
                        %>
                        <option value=<%=vehicleType.getId()%> ><%=vehicleType.getVehicleType()%></option>
                        <% } %>
                    </select>
                </div>
                <div class="form-row-inner">
                    <label>Подтип МПС</label>
                    <input type="text" class="field" name="vehicleSubtype" placeholder="Подтип МПС" maxlength="50">
                </div>
            </div>
        <input type="submit" value="Добави">
        </div>
    </form>
</div>
</div>
</body>
</html>
