<%@ page import="kabilova.tu.inscorp.model.user.Insured" %><%--
  Created by IntelliJ IDEA.
  User: AcerPC
  Date: 28.12.2017 г.
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            response.sendRedirect("insurer/login.jsp");
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
                            <li><a href="insurer/searchInsKaskoByID.jsp">Търсене по №</a></li>
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

<div>
    <div class="shell">
        <h3>Редактиране на клиент</h3>
        <form action="/updateInsured" method="post">
            <% Insured insured = (Insured) request.getAttribute("result");%>
            <div class="form-section">
                <div class="form-row">
                    <div class="form-row-inner">
                        <input type="hidden" class="field" id="insuredID" name="insuredID" value=<%=insured.getId()%> >
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Име</label>
                        <input type="text" class="field" id="firstName" name="firstName" value=<%=insured.getFirstName()%> maxlength="50">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Презиме</label>
                        <input type="text" class="field" id="secondName" name="secondName" value=<%=insured.getSecondName()%> maxlength="50">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Фамилия</label>
                        <input type="text" class="field" id="lastName" name="lastName" value=<%=insured.getLastName()%> maxlength="50"><br>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Потребителско име</label>
                        <input type="text" class="field" id="username" name="username" value=<%=insured.getUsername()%> maxlength="50">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Парола</label>
                        <input type="password" class="field" id="pass1" name="pass1" maxlength="50">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Повторете парола</label>
                        <input type="password" class="field" id="pass2" name="pass2" maxlength="50">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>ЕГН</label>
                        <input type="number" class="field" id="EGN" name="EGN" value=<%=insured.getEgn()%> maxlength="10">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Пощенски код</label>
                        <input type="text" class="field" id="postCode" name="postCode" value=<%=insured.getPostCode()%> placeholder="ПК">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Държава</label>
                        <input type="text" class="field" id="country" name="country" value=<%=insured.getCountry()%> maxlength="50"><br>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Град/Село</label>
                        <input type="text" class="field" id="city" name="city" value=<%=insured.getCity()%> maxlength="50">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Адрес</label>
                        <input type="text" class="field" id="address" name="address" value=<%=insured.getAddress()%> maxlength="100">
                   </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Телефонен №</label>
                        <input type="text" class="field" id="phoneNumber" name="phoneNumber" value=<%=insured.getPhoneNumber()%> maxlength="10">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Е-майл</label>
                        <input type="text" class="field" id="email" name="email" value=<%=insured.getEmail()%> maxlength="50"/>
                    </div>
                </div>
            <input type="submit" value="Промени">
        </div>
    </form>
    </div>
</div>
</body>
</html>
