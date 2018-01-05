<%@ page import="kabilova.tu.inscorp.model.user.Insurer" %>
<%@ page import="kabilova.tu.inscorp.server.web.UserServer" %>
<%@ page import="java.security.MessageDigest" %>
<%@ page import="java.math.BigInteger" %>
<%@ page import="java.security.NoSuchAlgorithmException" %><%--
  Created by IntelliJ IDEA.
  User: AcerPC
  Date: 20.10.2017 г.
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
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
</div>

<div class="insurerSettings">
    <div class="shell">
        <h3>Добави застрахователен агент</h3>
        <form action="/insurerSettingsUpdate" method="post">
            <div class="form-section">
            <%
                UserServer userServer = new UserServer(new Insurer());
                if(userServer.loadUser(username, password) instanceof Insurer) {
                    Insurer insurer = (Insurer) userServer.loadUser(username, password);
            %>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>ID</label>
                        <input type="text" class="field" id="insID" name="insID" value=<%=insurer.getId()%>>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Служебен №</label>
                        <input type="number" class="field" name="insurerID" value=<%=insurer.getInsurerID()%> size="30" maxlength="6">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Име</label>
                        <input type="text" class="field" name="insurerFirstName" value=<%=insurer.getFirstName()%> size="30" maxlength="50">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Презиме</label>
                        <input type="text" class="field" id="secondName" name="insurerSecondName" value=<%=insurer.getSecondName()%> size="50" maxlength="50">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Фамилия</label>
                        <input type="text" class="field" name="insurerLastName" value=<%=insurer.getLastName()%> size="30" maxlength="50">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Потребителско име</label>
                        <input type="text" class="field" id="username" name="username" value=<%=insurer.getUsername()%> maxlength="50">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Парола</label>
                        <input type="password" class="field" name="password1" size="30" maxlength="50">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Повторете парола</label>
                        <input type="password" class="field" name="password2"  size="30" maxlength="50">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Е-майл</label>
                        <input id="e-mail" type="text" class="field" value=<%=insurer.getEmail()%> name="e-mail" size="30" onchange="validateEmail();" maxlength="100">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Телефонен №</label>
                        <input type="number" class="field" id="phoneNumber" value=<%=insurer.getPhoneNumber()%>>
                    </div>
                </div>
                <% } %>
                <input type="submit" value="Промени">
            </div>
        </form>
    </div>
</div>
</body>
</html>