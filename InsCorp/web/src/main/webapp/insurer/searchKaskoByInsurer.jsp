<%--
  Created by IntelliJ IDEA.
  User: AcerPC
  Date: 20.10.2017 г.
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%--<%@page import="model.Kasko"%>--%>
<%--<%@page import="dao_jdbc.KaskoDAOImpl"%>--%>
<%--<%@page import="dao_api.KaskoDAO"%>--%>

<%
    try {
        Class.forName("com.mysql.jdbc.Driver");
    }
    catch (Exception e) {
        throw new UnavailableException(e.getMessage());
    }
%>

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
    <%@ page contentType="text/html; charset=UTF-8" %>
    <link href = "../style.css" type="text/css" rel = "stylesheet"/>
</head>

<body>
<div class="menu">
    <div class="menu-nav">
        <ul>
            <li><a href="#">Нова застраховка</a>
                <ul>
                    <li><a href="insurerAddNewGO.jsp">Гражданска отговорност</a></li>
                    <li><a href="insurerAddNewKasko.jsp">Каско</a></li>
                </ul>
            </li>
            <li><a href="#">Търсене</a>
                <ul>
                    <li><a href="#">Гражданска отговорност</a>
                        <ul>
                            <li><a href="searchGO.jsp">Търсене по №</a></li>
                            <li><a href="seachGOByInsurer.jsp">Търсене по текущ застраховател</a></li>
                            <li><a href="searchGOAll.jsp">Изведи всички</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Каско</a>
                        <ul>
                            <li><a href="searchInsKaskoByID.jsp">Търсене по №</a></li>
                            <li><a href="searchKaskoByInsurer.jsp">Търсене по текущ застраховател</a></li>
                            <li><a href="searchAllKasko.jsp">Изведи всички</a></li>
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
    <h3>Застраховка "Каско" - изведи по текущ застраховател</h3>
    <table border="1">
        <th>Застраховател</th>
        <th>Полица №</th>
        <th>Тип</th>
        <th>Име</th>
        <th>Презиме</th>
        <th>Фамилия</th>
        <th>ЕГН</th>
        <th>Мобилен телефон</th>
        <th>Адрес</th>
        <th>Пощенски код</th>
        <th>Регистрационен №</th>
        <th>Тип</th>
        <th>Рама</th>
        <th>Марка</th>
        <th>Модел</th>
        <th>Цвят</th>
        <th>Година на производство</th>
        <th>Първа регистрация</th>
        <th>Двигател</th>
        <th>Брой места</th>
        <th>Начална дата</th>
        <th>Крайна дата</th>
        <th>Застрахователна стойност</th>
        <th>Застрахователна премия</th>

        <%--<%--%>
            <%--KaskoDAO searchKaskoByInsurer = new KaskoDAOImpl();--%>
            <%--for(Kasko all : searchKaskoByInsurer.searchKaskoByInsurer(userName)) { %>--%>
        <tr>
            <%--<td><%=all.getInsurerId()%></td>--%>
            <%--<td><%=all.getInsKaskoId()%></td>--%>
            <%--<td><%=all.getInsType()%></td>--%>
            <%--<td><%=all.getInsurenceFirstName()%></td>--%>
            <%--<td><%=all.getInsurenceSecondName()%></td>--%>
            <%--<td><%=all.getInsurenceFamily()%></td>--%>
            <%--<td><%=all.getInsurenceEGN()%></td>--%>
            <%--<td><%=all.getInsurenceMobilePhone()%></td>--%>
            <%--<td><%=all.getInsurenceAddress()%></td>--%>
            <%--<td><%=all.getInsurencePK()%></td>--%>
            <%--<td><%=all.getVehicleRegistrationNumber()%></td>--%>
            <%--<td><%=all.getVehicleType()%></td>--%>
            <%--<td><%=all.getVehicleRama()%></td>--%>
            <%--<td><%=all.getVehicleBrand()%></td>--%>
            <%--<td><%=all.getVehicleModel()%></td>--%>
            <%--<td><%=all.getVehicleColor()%></td>--%>
            <%--<td><%=all.getVehicleYear()%></td>--%>
            <%--<td><%=all.getVehicleFirstRegistration()%></td>--%>
            <%--<td><%=all.getVehicleEngine()%></td>--%>
            <%--<td><%=all.getVehiclePlaceNumber()%></td>--%>
            <%--<td><%=all.getInsurenceDateFrom()%></td>--%>
            <%--<td><%=all.getInsurenceDateTo()%></td>--%>
            <%--<td><%=all.getVehicleInsurenceValue()%></td>--%>
            <%--<td><%=all.getVehicleInsurencePremiq()%></td>--%>
        </tr>
        <%--<% } %>--%>
    </table>
</div>
</body>
</html>