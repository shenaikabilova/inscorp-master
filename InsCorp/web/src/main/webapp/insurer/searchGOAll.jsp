<%--
  Created by IntelliJ IDEA.
  User: AcerPC
  Date: 20.10.2017 г.
  Time: 12:59
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
        String username = session.getAttribute("username").toString();
        String password = session.getAttribute("password").toString();
    %>
    <title><%=username %></title>
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
    <h3>Застраховка "Гражданска отговорност" - изведи всички</h3>
    <table border="1">
        <th>Застраховател</th>
        <th>Полица №</th>
        <th>Тип</th>
        <th>Име</th>
        <th>Презиме</th>
        <th>Фамилия</th>
        <th>ЕГН</th>
        <th>Държава</th>
        <th>Адрес</th>
        <th>Пощенски код</th>
        <th>Мобилен телефон</th>
        <th>Регистрационен №</th>
        <th>Зона</th>
        <th>Тип</th>
        <th>Рама</th>
        <th>Марка</th>
        <th>Модел</th>
        <th>Дата от:</th>
        <th>Дата до:</th>
        <th>Брой месеци</th>
        <th>Застрахователна стойност</th>
        <th>Застрахователна премия</th>

        <%--<%--%>
            <%--GrajdanskaOtgovornostDAO searchAll = new GrajdanskaOtgovornostDAOImpl();--%>
            <%--for(GrajdanskaOtgovornost all : searchAll.listGO()) { %>--%>
        <tr>
            <%--<td><%=all.getInsurerID()%></td>--%>
            <%--<td><%=all.getInsurenceGrajdanskaOtgovornostID()%></td>--%>
            <%--<td><%=all.getInsurenceType()%></td>--%>
            <%--<td><%=all.getInsurenceFirstName()%></td>--%>
            <%--<td><%=all.getInsurenceSecondName()%></td>--%>
            <%--<td><%=all.getInsurenceLastName()%></td>--%>
            <%--<td><%=all.getInsurenceEGN()%></td>--%>
            <%--<td><%=all.getInsurenceCountry()%></td>--%>
            <%--<td><%=all.getInsurenceAddress()%></td>--%>
            <%--<td><%=all.getInsurencePK()%></td>--%>
            <%--<td><%=all.getInsurenceMobilePhone()%></td>--%>
            <%--<td><%=all.getVehicleRegNumber()%></td>--%>
            <%--<td><%=all.getZone()%></td>--%>
            <%--<td><%=all.getVehicleType()%></td>--%>
            <%--<td><%=all.getVehicleRama()%></td>--%>
            <%--<td><%=all.getVehicleBrand()%></td>--%>
            <%--<td><%=all.getVehicleModel()%></td>--%>
            <%--<td><%=all.getInsurenceDateFrom()%></td>--%>
            <%--<td><%=all.getInsurenceDateTo()%></td>--%>
            <%--<td><%=all.getInsurenceMonths()%></td>--%>
            <%--<td><%=all.getInsurenceValue()%></td>--%>
            <%--<td><%=all.getInsurencePremiq()%></td>--%>
        </tr>
        <%--<% } %>--%>
    </table>
</div>
</body>
</html>