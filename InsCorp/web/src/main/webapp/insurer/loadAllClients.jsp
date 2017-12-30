<%@ page import="kabilova.tu.inscorp.server.web.InsuredServer" %>
<%@ page import="kabilova.tu.inscorp.model.user.Insured" %><%--
  Created by IntelliJ IDEA.
  User: AcerPC
  Date: 28.12.2017 г.
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
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
                            <li><a href="searchGO.jsp">Търсене по №</a></li>
                            <li><a href="seachGOByInsurer.jsp">Търсене по текущ застраховател</a></li>
                            <li><a href="searchGOAll.jsp">Изведи всички</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Каско</a>
                        <ul>
                            <li><a href="searchInsKaskoByID.jsp">Търсене по №</a></li>
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

<form method="post">
    <table border="1">
        <th>Име</th>
        <th>Презиме</th>
        <th>Фамилия</th>
        <th>Потребителско име</th>
        <th>ЕГН</th>
        <th>Пощенски код</th>
        <th>Държава</th>
        <th>Град/Село</th>
        <th>Адрес</th>
        <th>Телефонен №</th>
        <th>Е-майл</th>

        <% InsuredServer insuredServer = new InsuredServer(new Insured());
            for(Insured insured : insuredServer.readInsured()) {
        %>
        <tr>
            <td><%=insured.getFirstName()%></td>
            <td><%=insured.getSecondName()%></td>
            <td><%=insured.getLastName()%></td>
            <td><%=insured.getUsername()%></td>
            <td><%=insured.getEgn()%></td>
            <td><%=insured.getPostCode()%></td>
            <td><%=insured.getCountry()%></td>
            <td><%=insured.getCity()%></td>
            <td><%=insured.getAddress()%></td>
            <td><%=insured.getPhoneNumber()%></td>
            <td><%=insured.getEmail()%></td>
        </tr>
        <%}%>
    </table>
</form>
</body>
</html>
