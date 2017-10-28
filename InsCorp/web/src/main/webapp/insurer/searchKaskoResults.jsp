<%--
  Created by IntelliJ IDEA.
  User: AcerPC
  Date: 20.10.2017 г.
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@page import="java.util.List"%>--%>
<%--<%@page import="model.Kasko"%>--%>
<%--<%@page import="dao_jdbc.KaskoDAOImpl"%>--%>
<%--<%@page import="dao_api.KaskoDAO"%>--%>

<!DOCTYPE html>
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
    <h3>Застраховка "Каско" - търсене по № на полица</h3>
    <table border="1">
        <th>Застраховател</th>
        <th>Полица №</th>
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

        <%--<% List<Kasko> list = (List<Kasko>)request.getAttribute("result");--%>
            <%--for(Kasko i : list) { %>--%>
        <tr>
            <%--<td><%=i.getInsurerId()%></td>--%>
            <%--<td><%=i.getInsKaskoId()%></td>--%>
            <%--<td><%=i.getInsurenceFirstName()%></td>--%>
            <%--<td><%=i.getInsurenceSecondName()%></td>--%>
            <%--<td><%=i.getInsurenceFamily()%></td>--%>
            <%--<td><%=i.getInsurenceEGN()%></td>--%>
            <%--<td><%=i.getInsurenceMobilePhone()%></td>--%>
            <%--<td><%=i.getInsurenceAddress()%></td>--%>
            <%--<td><%=i.getInsurencePK()%></td>--%>
            <%--<td><%=i.getVehicleRegistrationNumber()%></td>--%>
            <%--<td><%=i.getVehicleType()%></td>--%>
            <%--<td><%=i.getVehicleRama()%></td>--%>
            <%--<td><%=i.getVehicleBrand()%></td>--%>
            <%--<td><%=i.getVehicleModel()%></td>--%>
            <%--<td><%=i.getVehicleColor()%></td>--%>
            <%--<td><%=i.getVehicleYear()%></td>--%>
            <%--<td><%=i.getVehicleFirstRegistration()%></td>--%>
            <%--<td><%=i.getVehicleEngine()%></td>--%>
            <%--<td><%=i.getVehiclePlaceNumber()%></td>--%>
            <%--<td><%=i.getInsurenceDateFrom()%></td>--%>
            <%--<td><%=i.getInsurenceDateTo()%></td>--%>
            <%--<td><%=i.getVehicleInsurenceValue()%></td>--%>
            <%--<td><%=i.getVehicleInsurencePremiq()%></td>--%>
        </tr>
        <%--<% } %>--%>
    </table>
</div>
</body>
</html>