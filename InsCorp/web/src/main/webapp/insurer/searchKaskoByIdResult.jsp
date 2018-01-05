<%@ page import="kabilova.tu.inscorp.model.policy.Kasko" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: AcerPC
  Date: 20.10.2017 г.
  Time: 13:02
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
    <h3>Застраховка "Каско" - търсене по № на полица</h3>
    <table border="1">
        <th>Полица №</th>
        <th>Вид Каско</th>
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
        <th>Оценка на МПС</th>
        <th>Застрахователна стойност - %</th>
        <th>Застрахователна премия</th>

        <%
            Kasko kasko = (Kasko) request.getAttribute("result");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        %>
        <tr>
            <td><%=kasko.getPolicaID()%></td>
            <td><%=kasko.getKaskoType()%></td>
            <td><%=kasko.getInsured().getFirstName()%></td>
            <td><%=kasko.getInsured().getSecondName()%></td>
            <td><%=kasko.getInsured().getLastName()%></td>
            <td><%=kasko.getInsured().getEgn()%></td>
            <td><%=kasko.getInsured().getCountry()%></td>
            <td><%=kasko.getInsured().getCity()%></td>
            <td><%=kasko.getInsured().getPostCode()%></td>
            <td><%=kasko.getInsured().getAddress()%></td>
            <td><%=kasko.getInsured().getPhoneNumber()%></td>
            <td><%=kasko.getInsured().getEmail()%></td>
            <td><%=kasko.getVehicle().getRegNum()%></td>
            <td><%=kasko.getVehicle().getRAMA()%></td>
            <td><%=kasko.getVehicle().getVehicleType().getVehicleType()%></td>
            <td><%=kasko.getVehicle().getVehicleSubtype().getSubtype()%></td>
            <td><%=kasko.getVehicle().getBrand()%></td>
            <td><%=kasko.getVehicle().getModel()%></td>
            <td><%=simpleDateFormat.format(kasko.getVehicle().getFirstReg().getTime())%></td>
            <td><%=kasko.getVehicle().getYears()%></td>
            <td><%=kasko.getVehicle().getEngine()%></td>
            <td><%=kasko.getVehicle().getColor()%></td>
            <td><%=kasko.getVehicle().getPlaceNumber()%></td>
            <td><%=simpleDateFormat.format(kasko.getDateFrom().getTime())%></td>
            <td><%=simpleDateFormat.format(kasko.getDateTo().getTime())%></td>
            <td><%=kasko.getPeriod()%></td>
            <td><%=kasko.getVehicleValue()%></td>
            <td><%=kasko.getTariffKasko().getKaskoPercent() + "%"%></td>
            <td><%=kasko.getValue()%></td>
        </tr>
    </table>
</div>
</body>
</html>