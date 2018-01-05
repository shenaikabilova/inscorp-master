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
        String username = null;
        String password = null;
        if(!request.getSession().isNew()) {
            username = session.getAttribute("username").toString();
            password = session.getAttribute("password").toString();
        }
        else {
            response.sendRedirect("/AdminLogin");
        }
    %>
    <title><%=username %></title>
    <link href = "../style.css" type="text/css" rel = "stylesheet"/>

    <script src="../js/validate.js"></script>
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
                            <li><a href="searchGOByID.jsp">Търсене по №</a></li>
                            <li><a href="seachGOByInsurer.jsp">Търсене по текущ застраховател</a></li>
                            <li><a href="searchGOAll.jsp">Изведи всички</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Каско</a>
                        <ul>
                            <li><a href="searchKaskoByID.jsp">Търсене по №</a></li>
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

<div class="addInsured">
    <div class="shell">
        <h3>Добавяне на нов клиент</h3>
        <form action="/addNewInsured" method="post">
            <div class="form-section">
                <div class="form-section">
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>Име</label>
                            <input type="text" class="field" id="firstName" name="firstName" placeholder="Име" maxlength="50">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>Презиме</label>
                            <input type="text" class="field" id="secondName" name="secondName" placeholder="Презиме" maxlength="50">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>Фамилия</label>
                            <input type="text" class="field" id="lastName" name="lastName" placeholder="Фамилия" maxlength="50">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>Потребителско име</label>
                            <input type="text" class="field" id="username" name="username" placeholder="Потребителско име" maxlength="50">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>Парола</label>
                            <input type="password" class="field" id="pass1" name="pass1" placeholder="Парола" maxlength="50">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>Повторете парола</label>
                            <input type="password" class="field" id="pass2" name="pass2" placeholder="Повторете парола" maxlength="50">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>ЕГН</label>
                            <input type="number" class="field" id="EGN" name="EGN" placeholder="ЕГН" maxlength="10">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>Пощенски код</label>
                            <input type="number" class="field" id="postCode" name="postCode" placeholder="ПК">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>Държава</label>
                            <input type="text" class="field" id="country" name="country" placeholder="Държава" maxlength="50">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>Град/Село</label>
                            <input type="text" class="field" id="city" name="city" placeholder="Град/Село" maxlength="50">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>Адрес</label>
                            <input type="text" class="field" id="address" name="address" placeholder="ж.к./ул/бл/вх/ет/ап" maxlength="100">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>Телефонен №</label>
                            <input type="text" class="field" id="phoneNumber" name="phoneNumber" placeholder="Телефон" maxlength="10">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>Е-майл</label>
                            <input type="text" class="field" id="email" name="email" placeholder="Е-майл" maxlength="50"/>
                        </div>
                    </div>
                <input type="submit" value="Добави">
            </div>
          </div>
        </form>
    </div>
</div>
</body>
</html>
