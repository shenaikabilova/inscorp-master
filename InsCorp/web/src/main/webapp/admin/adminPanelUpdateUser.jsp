<%@ page import="kabilova.tu.inscorp.model.user.Insurer" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: AcerPC
  Date: 20.10.2017 г.
  Time: 12:47
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
    <ul class="menu-nav">
        <li><a href="adminPanel.jsp">Добави</a>
            <ul>
                <li><a href="adminPanelAddInsurer.jsp">Застрахователен агент</a></li>
            </ul>
        </li>
        <li><a href="adminPanelSettings.jsp">Настройки</a></li>
        <li><a href="#">Застрахователни агенти</a>
            <ul>
                <li><a href="adminPanelInsurers.jsp">Изведи</a></li>
                <li><a href="adminPanelSearchUser.jsp">Промени</a></li>
                <li><a href="adminPanelDeleteUser.jsp">Изтрий</a></li>
            </ul>
        </li>
        <li><a href="#">МПС</a>
            <lu>
                <li><a href="adminPanelAddVehicleType.jsp">Добави тип МПС</a></li>
                <li><a href="adminPanelAddVehicleSubtype.jsp">Добави подтип МПС</a></li>
            </lu>
        </li>
        <li><a href="AdminLogout">Изход</a></li>
    </ul>
</div>

<div class="adminpanelSettings">
    <div class="shell">
        <form action="/updateInsurer" method="post">
            <table width="100%">
                <%
                    List<Insurer> insurers = (List<Insurer>)request.getAttribute("result");
                    for(Insurer insurer : insurers) {
                %>
                <tr>
                    <td><h3>Настройки на застраховател</h3></td>
                </tr>
                <tr>
                    <td><label>ID</label></td>
                    <td><input type="text" class="field" name="userID" size="30" value=<%=insurer.getInsurerID()%> readonly="readonly"></td>
                <tr>
                    <td><label>Име</label></td>
                    <td><input type="text" class="field" name="insurerFirstName" value=<%=insurer.getFirstName()%> maxlength="50"></td>
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
                    <td><input type="password" class="field" name="password1" value=<%=insurer.getPassword()%> size="30" maxlength="50"></td>
                </tr>
                <tr>
                    <td><label>Повторете парола</label></td>
                    <td><input type="password" class="field" name="password2" placeholder="Повторете паролата" size="30" maxlength="50"></td>
                </tr>
                <tr>
                    <td><label>Телфонен №</label></td>
                    <td><input type="number" id="phoneNumber" name="phoneNumber" value=<%=insurer.getPhoneNumber()%></td>
                </tr>
                <tr>
                    <td><label>Е-майл</label></td>
                    <td><input id="e-mail" type="text" class="field" value=<%=insurer.getEmail()%> name="e-mail" size="30" onchange="validateEmail();" maxlength="100"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Добави"></td>
                </tr>
                <% } %>
            </table>
        </form>
    </div>
</div>
</body>
</html>