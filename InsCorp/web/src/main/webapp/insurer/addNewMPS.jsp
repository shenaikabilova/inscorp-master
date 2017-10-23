<%--
  Created by IntelliJ IDEA.
  User: AcerPC
  Date: 21.10.2017 г.
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--<%--%>
    <%--String userName = null;--%>
    <%--Cookie[] cookies = request.getCookies();--%>
    <%--if(cookies != null) {--%>
    <%--for(Cookie cookie: cookies) {--%>
    <%--if(cookie.getName().equals("user")) {--%>
    <%--userName = cookie.getValue();--%>
    <%--}--%>
    <%--}--%>
    <%--}--%>
    <%--if(userName == null) {--%>
    <%--response.sendRedirect("login.jsp");--%>
    <%--}--%>
    <%--%>--%>
    <%--<title><%=userName %></title>--%>
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
                    <li><a href="addNewMPS.jsp">Ново МПС</a></li>
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

    <form action="addNewMps" method="post">
        Добавяне на ново МПС <br>
        <label>Собственик</label><br>
        <label>ЕГН</label>
        <input type="number" id="searchEGN" name="searchEGN" placeholder="ЕГН" maxlength="10">
        <input type="submit" value="Зареди клиент"><br>

        Данни за собственик
        <label>Име</label>
        <input type="text" id="firstName" name="firstName" placeholder="Име" maxlength="50">
        <label>Презиме</label>
        <input type="text" id="secondName" name="secondName" placeholder="Презиме" maxlength="50">
        <label>Фамилия</label>
        <input type="text" id="lastName" name="lastName" placeholder="Фамилия" maxlength="50"><br>

        <label>ЕГН</label>
        <input type="number" id="EGN" name="EGN" placeholder="ЕГН" maxlength="10">
        <label>Държава</label>
        <input type="text" id="country" name="country" placeholder="Държава" maxlength="50"><br>

        <label>Град/Село</label>
        <input type="text" id="city" name="city" placeholder="Град/Село" maxlength="50">
        <label>Адрес</label>
        <input type="text" id="address" name="address" placeholder="ж.к./ул/бл/вх/ет/ап" maxlength="100">

        МПС
        <label>Регистрационен №</label>
        <input type="text" id="regNum" name="RegNum" placeholder="Регистрационен №" maxlength="7">
        <label>РАМА</label>
        <input type="text" id="rama" name="rama" placeholder="РАМА" maxlength="17">
        <label>Регистрация</label>
        <select name="country">
            <option>България</option>
            <option>Чужбина</option>
        </select> <br>

        <label>Тип</label>
        <%--TODO type from db--%>
        <label>Кубици</label>
        <%--TODO subtype from db--%>

        <br>
        <label>Марка</label>
        <label>Модел</label>
        <label>Първа регистрация</label>
        <input type="text" placeholder="Първа регистрация" id="datepicker1" name="firstReg">
        <label>Години</label>
        <input type="number" id="years" name="years" placeholder="Години">
        <br>

        <label>Цвят</label>
        <%--TODO color--%>
        <label>Брой места</label>
        <input type="number" id="placeNumber" name="placeNumber" placeholder="Брой места">
        <br>

        <input type="submit" value="Добави">
    </form>
</body>
</html>