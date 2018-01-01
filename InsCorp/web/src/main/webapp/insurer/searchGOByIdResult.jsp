<%@ page import="kabilova.tu.inscorp.model.policy.GO" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: AcerPC
  Date: 20.10.2017 г.
  Time: 13:00
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
                    <li><a href="insurer/addNewInsured.jsp">Добави</a></li>
                    <li><a href="insurer/loadInsuredForUpdate.jsp">Промени</a></li>
                    <li><a href="insurer/deleteInsured.jsp">Изтрий</a></li>
                    <li><a href="insurer/loadAllClients.jsp">Изведи всички</a></li>
                </ul>
            </li>
            <li><a href="#">МПС</a>
                <ul>
                    <li><a href="insurer/loadClient.jsp">Добави</a></li>
                    <li><a href="insurer/loadVehicle.jsp">Промени</a></li>
                    <li><a href="insurer/deleteVehicle.jsp">Изтрий</a></li>
                    <li><a href="insurer/loadAllVehicles.jsp">Изведи всички</a></li>
                    <li><a href="insurer/changeOwner.jsp">Смени собственик</a></li>
                </ul>
            </li>
            <li><a href="#">Нова застраховка</a>
                <ul>
                    <li><a href="insurer/loadMpsGO.jsp">Гражданска отговорност</a></li>
                    <li><a href="insurer/loadMpsKasko.jsp">Каско</a></li>
                </ul>
            </li>
            <li><a href="#">Търсене</a>
                <ul>
                    <li><a href="#">Гражданска отговорност</a>
                        <ul>
                            <li><a href="insurer/searchGOByID.jsp">Търсене по №</a></li>
                            <li><a href="insurer/seachGOByInsurer.jsp">Търсене по текущ застраховател</a></li>
                            <li><a href="insurer/searchGOAll.jsp">Изведи всички</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Каско</a>
                        <ul>
                            <li><a href="insurer/searchKaskoByID.jsp">Търсене по №</a></li>
                            <li><a href="insurer/searchKaskoByInsurer.jsp">Търсене по текущ застраховател</a></li>
                            <li><a href="insurer/searchKaskoAll.jsp">Изведи всички</a></li>
                        </ul>
                    </li>
                </ul>
            </li>
            <li><a href="#">Редакция</a>
                <ul>
                    <li><a href="insurer/insurerGoUpdateSearch.jsp">Гражданска отговорност</a></li>
                    <li><a href="insurer/insurerKaskoUpdateSearch.jsp">Каско</a></li>
                </ul>
            </li>
            <li><a href="insurer/insurerSettings.jsp">Настройки</a></li>
            <li><a href="logout">Изход</a>
        </ul>
    </div>
</div>

<div class="searchInsurers viewInsurers shell">
    <h3>Застраховка "Гражданска отговорност" по № на полица</h3>
    <table border="1">
        <th>Полица №</th>
        <th>Име</th>
        <th>Презиме</th>
        <th>Фамилия</th>
        <th>ЕГН</th>
        <th>Държава</th>
        <th>Град</th>
        <th>Пощенски код</th>
        <th>Адрес</th>
        <th>Мобилен телефон</th>
        <th>Имейл</th>
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
        <th>Дата от:</th>
        <th>Дата до:</th>
        <th>Брой месеци</th>
        <th>Застрахователна стойност</th>
        <th>Застрахователна премия</th>

        <%
            GO go = (GO) request.getAttribute("result");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        %>
        <tr>
            <td><%=go.getPolicaID()%></td>
            <td><%=go.getInsured().getFirstName()%></td>
            <td><%=go.getInsured().getSecondName()%></td>
            <td><%=go.getInsured().getLastName()%></td>
            <td><%=go.getInsured().getEgn()%></td>
            <td><%=go.getInsured().getCountry()%></td>
            <td><%=go.getInsured().getCity()%></td>
            <td><%=go.getInsured().getPostCode()%></td>
            <td><%=go.getInsured().getAddress()%></td>
            <td><%=go.getInsured().getPhoneNumber()%></td>
            <td><%=go.getInsured().getEmail()%></td>
            <td><%=go.getVehicle().getRegNum()%></td>
            <td><%=go.getVehicle().getRAMA()%></td>
            <td><%=go.getVehicle().getVehicleType().getVehicleType()%></td>
            <td><%=go.getVehicle().getVehicleSubtype().getSubtype()%></td>
            <td><%=go.getVehicle().getBrand()%></td>
            <td><%=go.getVehicle().getModel()%></td>
            <td><%=simpleDateFormat.format(go.getVehicle().getFirstReg().getTime())%></td>
            <td><%=go.getVehicle().getYears()%></td>
            <td><%=go.getVehicle().getEngine()%></td>
            <td><%=go.getVehicle().getColor()%></td>
            <td><%=go.getVehicle().getPlaceNumber()%></td>
            <td><%=simpleDateFormat.format(go.getDateFrom().getTime())%></td>
            <td><%=simpleDateFormat.format(go.getDateTo().getTime())%></td>
            <td><%=go.getPeriod()%></td>
            <td><%=go.getTariffGO().getValue()%></td>
            <td><%=go.getValue()%></td>
        </tr>
    </table>
</div>
</body>
</html>