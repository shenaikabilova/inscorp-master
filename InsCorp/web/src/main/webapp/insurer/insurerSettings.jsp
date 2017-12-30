<%@ page import="kabilova.tu.inscorp.model.user.Insurer" %>
<%@ page import="kabilova.tu.inscorp.server.web.UserServer" %><%--
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
</div>

<div class="insurerSettings">
    <div class="shell">
        <form action="/insurerSettingsUpdate" method="post">
            <%
                UserServer userServer = new UserServer(new Insurer());
                if(userServer.loadUser(username, password) instanceof Insurer) {
                    Insurer insurer = (Insurer) userServer.loadUser(username, password);
            %>
            <table width="100%">
                <tr>
                    <td></td>
                    <td><h3>Добави застрахователен агент</h3></td>
                </tr>
                <tr>
                    <td><label id="insurerID" for="insurerID">Служебен №</label></td>
                    <td><input type="number" class="field" name="insurerID" value=<%=insurer.getInsurerID()%> size="30" maxlength="6"></td>
                </tr>
                <tr>
                    <td><label>Име</label></td>
                    <td><input type="text" class="field" name="insurerFirstName" value=<%=insurer.getFirstName()%> size="30" maxlength="50"></td>
                </tr>
                <tr>
                    <td><label>Презиме</label></td>
                    <td><input type="text" id="secondName" name="insurerSecondName" value=<%=insurer.getSecondName()%> size="50" maxlength="50"></td>
                </tr>
                <tr>
                    <td><label>Фамилия</label></td>
                    <td><input type="text" class="field" name="insurerLastName" value=<%=insurer.getLastName()%> size="30" maxlength="50"></td>
                </tr>
                <tr>
                    <td><label>Потребителско име</label></td>
                    <td><input type="text" id="username" name="username" value=<%=insurer.getUsername()%> maxlength="50"></td>
                </tr>
                <tr>
                    <td><label>Парола</label></td>
                    <td><input type="password" class="field" name="password1" size="30" maxlength="50"></td>
                </tr>
                <tr>
                    <td><label>Повторете парола</label></td>
                    <td><input type="password" class="field" name="password2"  size="30" maxlength="50"></td>
                </tr>
                <tr>
                    <td><label>Е-майл</label></td>
                    <td><input id="e-mail" type="text" class="field" value=<%=insurer.getEmail()%> name="e-mail" size="30" onchange="validateEmail();" maxlength="100"></td>
                </tr>
                <tr>
                    <td><label>Телефонен №</label></td>
                    <td><input type="number" id="phoneNumber" value=<%=insurer.getPhoneNumber()%>></td>
                </tr>
                <% } %>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Промени"></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>