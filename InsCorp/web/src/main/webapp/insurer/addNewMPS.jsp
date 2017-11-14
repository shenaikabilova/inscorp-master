<%@ page import="kabilova.tu.inscorp.model.user.Insured" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: AcerPC
  Date: 21.10.2017 г.
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
//    String userName = null;
//    Cookie[] cookies = request.getCookies();
//    if(cookies != null) {
//    for(Cookie cookie: cookies) {
//    if(cookie.getName().equals("user")) {
//    userName = cookie.getValue();
//    }
//    }
//    }
//    if(userName == null) {
//    response.sendRedirect("login.jsp");
//    }

        String username = session.getAttribute("username").toString();
        String password = session.getAttribute("password").toString();
    %>
    <title><%=username %></title>
    <link href = "../style.css" type="text/css" rel = "stylesheet"/>

        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <link rel="stylesheet" href="/resources/demos/style.css">
</head>
<body>
<div class="menu">
    <div class="menu-nav">
        <ul>
            <li><a href="#">Добави</a>
                <ul>
                    <li><a href="addNewInsured.jsp">Нов клиент</a></li>
                    <li><a href="loadClient.jsp">Ново МПС</a></li>
                </ul>
            </li>
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

    <%--<form action="/loadClient" method="post">--%>
        <%--Добавяне на ново МПС <br>--%>
        <%--<label>Собственик</label><br>--%>
        <%--<label>ЕГН</label>--%>
        <%--<input type="number" name="searchEGN" placeholder="ЕГН" maxlength="10">--%>
        <%--<input type="submit" value="Зареди клиент"><br>--%>
    <%--</form>--%>

    <form action="/addNewMps" method="post">
        <%
            List<Insured> insurers = (List<Insured>)request.getAttribute("result");
            for(Insured insured : insurers) {
        %>
        Данни за собственик

        <label>ID</label>
        <input type="text" class="field" name="insuredID" value=<%=insured.getId()%>>
        <label>Име</label>
        <input type="text" class="field" name="insuredFirstName" value=<%=insured.getFirstName()%> maxlength="50">

        <label>Презиме</label></td>
        <input type="text" id="secondName" name="insuredSecondName" value=<%=insured.getSecondName()%> size="50" maxlength="50">

        <label>Фамилия</label></td>
        <input type="text" class="field" name="insuredLastName" value=<%=insured.getLastName()%> size="30" maxlength="50">


        <label>ЕГН</label>
        <input type="number" id="EGN" name="EGN" value=<%=insured.getEgn()%> maxlength="10">
        <label>Държава</label>
        <input type="text" id="country" name="country" value=<%=insured.getCountry()%> maxlength="50"><br>

        <label>Град/Село</label>
        <input type="text" id="city" name="city" value=<%=insured.getCity()%> maxlength="50">
        <label>Адрес</label>
        <input type="text" id="address" name="address" value=<%=insured.getAddress()%> maxlength="100">

        <% } %>

        МПС
        <label>Регистрационен №</label>
        <input type="text" id="regNum" name="regNum" placeholder="Регистрационен №" maxlength="7">
        <label>РАМА</label>
        <input type="text" id="rama" name="rama" placeholder="РАМА" maxlength="17">

        <label>Тип</label>
        <%--TODO type from db--%>
        <select id="vehicleType" name="vehicleType">
            <option></option>
        </select>
        <label>Кубици</label>
        <%--TODO subtype from db--%>
        <select id="vehicleSubtype" name="vehicleSubtype">
            <option></option>
        </select>

        <label>Регистрация</label>
        <select name="country">
            <option>България</option>
            <option>Чужбина</option>
        </select> <br>

        <br>
        <label>Марка</label>
        <label>Модел</label>

        <label>Първа регистрация</label>
        <input type="text" placeholder="Първа регистрация" id="datepicker1" name="firstReg">
        <label>Години</label>
        <input type="number" id="years" name="years" placeholder="Години">
        <br>

        <label>Двигател</label>
        <select id="engine" name="engine">
            <option>1.2</option>
            <option>1.4</option>
            <option>1.6</option>
        </select>
        <label>Цвят</label>
        <%--TODO color--%>
        <label>Брой места</label>
        <input type="number" id="placeNumber" name="placeNumber" placeholder="Брой места">
        <br>

        <input type="submit" value="Добави">
    </form>
</body>
</html>
