<%--
  Created by IntelliJ IDEA.
  User: AcerPC
  Date: 20.10.2017 г.
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%--<%@page import="java.util.List"%>--%>
<%--<%@page import="model.GrajdanskaOtgovornost"%>--%>
<%--<%@page import="dao_jdbc.GrajdanskaOtgovornostDAOImpl"%>--%>
<%--<%@page import="dao_api.GrajdanskaOtgovornostDAO"%>--%>
<%--<%@page import="model.Kasko"%>--%>
<%--<%@page import="dao_jdbc.KaskoDAOImpl"%>--%>
<%--<%@page import="dao_api.KaskoDAO"%>--%>
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
    <h3>Застраховка "Гражданска отговорност" по № на полица</h3>
    <table border="1">
        <th>Застраховател</th>
        <th>№ на полица</th>
        <th>Тип на застрахован</th>
        <th>Име</th>
        <th>Презиме</th>
        <th>Фамилия</th>
        <th>ЕГН</th>
        <th>Държава</th>
        <th>Адрес</th>
        <th>Пощенски код</th>
        <th>Телефон</th>
        <th>Регистрационен №</th>
        <th>Зона</th>
        <th>Вид МПС</th>
        <th>РАМА</th>
        <th>Марка</th>
        <th>Модел</th>
        <th>Застраховка - от дата</th>
        <th>Застраховка - до дата</th>
        <th>Месеци</th>
        <th>Застрахователна сума</th>
        <th>Застрахователна премия</th>

        <%--<%--%>
            <%--List<GrajdanskaOtgovornost> list = (List<GrajdanskaOtgovornost>)request.getAttribute("result");--%>
            <%--for(GrajdanskaOtgovornost go : list) {--%>
        <%--%>--%>
        <tr>
            <%--<td><%=go.getInsurerID()%></td>--%>
            <%--<td><%=go.getInsurenceGrajdanskaOtgovornostID()%></td>--%>
            <%--<td><%=go.getInsurenceType()%></td>--%>
            <%--<td><%=go.getInsurenceFirstName()%></td>--%>
            <%--<td><%=go.getInsurenceSecondName()%></td>--%>
            <%--<td><%=go.getInsurenceLastName()%></td>--%>
            <%--<td><%=go.getInsurenceEGN()%></td>--%>
            <%--<td><%=go.getInsurenceCountry()%></td>--%>
            <%--<td><%=go.getInsurenceAddress()%></td>--%>
            <%--<td><%=go.getInsurencePK()%></td>--%>
            <%--<td><%=go.getInsurenceMobilePhone()%></td>--%>
            <%--<td><%=go.getVehicleRegNumber()%></td>--%>
            <%--<td><%=go.getZone()%></td>--%>
            <%--<td><%=go.getVehicleType()%></td>--%>
            <%--<td><%=go.getVehicleRama()%></td>--%>
            <%--<td><%=go.getVehicleBrand()%></td>--%>
            <%--<td><%=go.getVehicleModel()%></td>--%>
            <%--<td><%=go.getInsurenceDateFrom()%></td>--%>
            <%--<td><%=go.getInsurenceDateTo()%></td>--%>
            <%--<td><%=go.getInsurenceMonths()%></td>--%>
            <%--<td><%=go.getInsurenceValue()%></td>--%>
            <%--<td><%=go.getInsurencePremiq()%></td>--%>
        </tr>

        <%--<% } %>--%>
    </table>
</div>
</body>
</html>