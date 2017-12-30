<%--
  Created by IntelliJ IDEA.
  User: AcerPC
  Date: 21.10.2017 г.
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
//        if(userName == null) { response.sendRedirect("login.jsp");}
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

<form action="/addNewInsured" method="post">
    Добавяне на нов клиент<br>
    <label>Име</label>
    <input type="text" id="firstName" name="firstName" placeholder="Име" maxlength="50">
    <label>Презиме</label>
    <input type="text" id="secondName" name="secondName" placeholder="Презиме" maxlength="50">
    <label>Фамилия</label>
    <input type="text" id="lastName" name="lastName" placeholder="Фамилия" maxlength="50"><br>

    <label>Потребителско име</label>
    <input type="text" id="username" name="username" placeholder="Потребителско име" maxlength="50">
    <label>Парола</label>
    <input type="password" id="pass1" name="pass1" placeholder="Парола" maxlength="50">
    <label>Повторете парола</label>
    <input type="password" id="pass2" name="pass2" placeholder="Повторете парола" maxlength="50">

    <label>ЕГН</label>
    <input type="number" id="EGN" name="EGN" placeholder="ЕГН" maxlength="10">
    <label>Пощенски код</label>
    <input type="number" id="postCode" name="postCode" placeholder="ПК">
    <label>Държава</label>
    <input type="text" id="country" name="country" placeholder="Държава" maxlength="50"><br>

    <label>Град/Село</label>
    <input type="text" id="city" name="city" placeholder="Град/Село" maxlength="50">
    <label>Адрес</label>
    <input type="text" id="address" name="address" placeholder="ж.к./ул/бл/вх/ет/ап" maxlength="100">

    <br>
    <label>Телефонен №</label>
    <input type="text" id="phoneNumber" name="phoneNumber" placeholder="Телефон" maxlength="10">
    <label>Е-майл</label>
    <input type="text" id="email" name="email" placeholder="Е-майл" maxlength="50"/>
    <br>

    <input type="submit" value="Добави">
</form>
</body>
</html>
