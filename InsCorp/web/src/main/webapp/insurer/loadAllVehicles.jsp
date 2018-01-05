<%@ page import="kabilova.tu.inscorp.server.web.VehicleServer" %>
<%@ page import="kabilova.tu.inscorp.model.vehicle.Vehicle" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %><%--
  Created by IntelliJ IDEA.
  User: AcerPC
  Date: 28.12.2017 г.
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <%
        int id = 0;
        String username = null;
        String password = null;
        if(!request.getSession().isNew()) {
            id = Integer.parseInt(session.getAttribute("id").toString());
            username = session.getAttribute("username").toString();
            password = session.getAttribute("password").toString();
        }
        else {
            response.sendRedirect("login.jsp");
        }
    %>
    <title><%=username %></title>
    <link href = "../style.css" type="text/css" rel = "stylesheet"/>
</head>

<body>
<div class="menu">
    <div class="menu-nav">
        <ul>
            <li><a href="#">Клиент</a>
                <ul>
                    <li><a href="addNewInsured.jsp">Добави</a></li>
                    <li><a href="loadInsuredForUpdate.jsp">Промени</a></li>
                    <li><a href="deleteInsured.jsp">Изтрий</a></li>
                    <li><a href="loadAllClients.jsp">Изведи всички</a></li>
                </ul>
            </li>
            <li><a href="#">МПС</a>
                <ul>
                    <li><a href="loadClient.jsp">Добави</a></li>
                    <li><a href="loadVehicle.jsp">Промени</a></li>
                    <li><a href="deleteVehicle.jsp">Изтрий</a></li>
                    <li><a href="loadAllVehicles.jsp">Изведи всички</a></li>
                    <li><a href="changeOwner.jsp">Смени собственик</a></li>
                </ul>
            </li>
            <li><a href="#">Нова застраховка</a>
                <ul>
                    <li><a href="loadMpsGO.jsp">Гражданска отговорност</a></li>
                    <li><a href="loadMpsKasko.jsp">Каско</a></li>
                </ul>
            </li>
            <li><a href="#">Търсене</a>
                <ul>
                    <li><a href="#">Гражданска отговорност</a>
                        <ul>
                            <li><a href="searchGOByID.jsp">Търсене по №</a></li>
                            <li><a href="seachGOByInsurer.jsp">Търсене по текущ застраховател</a></li>
                            <li><a href="searchGOAll.jsp">Изведи всички</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Каско</a>
                        <ul>
                            <li><a href="searchKaskoByID.jsp">Търсене по №</a></li>
                            <li><a href="searchKaskoByInsurer.jsp">Търсене по текущ застраховател</a></li>
                            <li><a href="searchKaskoAll.jsp">Изведи всички</a></li>
                        </ul>
                    </li>
                </ul>
            </li>
            <li><a href="#">Редакция</a>
                <ul>
                    <li><a href="insurerGoUpdateSearch.jsp">Гражданска отговорност</a></li>
                    <li><a href="insurerKaskoUpdateSearch.jsp">Каско</a></li>
                </ul>
            </li>
            <li><a href="insurerSettings.jsp">Настройки</a></li>
            <li><a href="logout">Изход</a>
        </ul>
    </div>
</div>
<div class="searchInsurers viewInsurers shell">
    <form>
        <label>Списък на всички записани МПС</label>
        <table border="1">
            <th>Име</th>
            <th>Презиме</th>
            <th>Фамилия</th>
            <th>ЕГН</th>
            <th>Пощенски код</th>
            <th>Държава</th>
            <th>Град/Село</th>
            <th>Адрес</th>
            <th>Телефонен №</th>
            <th>Регистрационен №</th>
            <th>РАМА</th>
            <th>Тип</th>
            <th>Подтип</th>
            <th>Марка</th>
            <th>Модел</th>
            <th>Първа регистрация</th>
            <th>Години</th>
            <th>Двигател</th>
            <th>Цвят</th>
            <th>Брой места</th>


            <%
                VehicleServer vehicleServer = new VehicleServer(new Vehicle());
                for(Vehicle vehicle : vehicleServer.read()) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            %>
            <tr>
                <td><%=vehicle.getInsured().getFirstName()%></td>
                <td><%=vehicle.getInsured().getSecondName()%></td>
                <td><%=vehicle.getInsured().getLastName()%></td>
                <td><%=vehicle.getInsured().getEgn()%></td>
                <td><%=vehicle.getInsured().getPostCode()%></td>
                <td><%=vehicle.getInsured().getCountry()%></td>
                <td><%=vehicle.getInsured().getCity()%></td>
                <td><%=vehicle.getInsured().getAddress()%></td>
                <td><%=vehicle.getInsured().getPhoneNumber()%></td>
                <td><%=vehicle.getRegNum()%></td>
                <td><%=vehicle.getRAMA()%></td>
                <td><%=vehicle.getVehicleType().getVehicleType()%></td>
                <td><%=vehicle.getVehicleSubtype().getSubtype()%></td>
                <td><%=vehicle.getBrand()%></td>
                <td><%=vehicle.getModel()%></td>
                <td><%=simpleDateFormat.format(vehicle.getFirstReg().getTime())%></td>
                <td><%=vehicle.getYears()%></td>
                <td><%=vehicle.getEngine()%></td>
                <td><%=vehicle.getColor()%></td>
                <td><%=vehicle.getPlaceNumber()%></td>
            </tr>
            <% } %>
        </table>
    </form>
</div>
</body>
</html>