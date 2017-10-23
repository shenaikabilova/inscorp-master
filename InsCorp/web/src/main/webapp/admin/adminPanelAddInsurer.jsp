<%--
  Created by IntelliJ IDEA.
  User: AcerPC
  Date: 20.10.2017 г.
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
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

        <script src="js/validate.js"></script>
    </head>

    <body>
        <div class="menu">
            <div class="shell">
                <ul class="menu-nav">
                    <li><a href="adminPanel.jsp">Добави</a>
                        <ul>
                            <li><a href="adminPanelAddInsurer.jsp">Застрахователен агент</a></li>
                            <li><a href="addVehicleType.jsp">Тип МПС</a></li>
                            <li><a href="addVehicleSubtype.jsp">Подтип МПС</a></li>
                        </ul>
                    </li>
                    <li><a href="adminPanelSettings.jsp">Настройки</a></li>
                    <li><a href="#">Застрахователни агенти</a>
                        <ul>
                            <li><a href="adminPanelInsurers.jsp">Изведи</a></li>
                            <li><a href="adminPanelUpdateUser.jsp">Промени</a></li>
                            <li><a href="adminPanelDeleteUser.jsp">Изтрий</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Тарифиране</a>
                        <ul>
                            <li><a href="tariffGO.jsp">ГО</a></li>
                            <li><a href="tariffKasko.jsp">Каско</a></li>
                        </ul>
                    </li>
                    <li><a href="AdminLogout">Изход</a></li>
                </ul>
            </div>
        </div>

        <div class="addInsurer">
            <div class="shell">
                <form action="adminPanelAddInsurer" method="post">
                    <table width="100%">
                        <tr>
                            <td></td>
                            <td><h3>Добави застрахователен агент</h3></td>
                        </tr>
                        <tr>
                            <td><label id="insurerID" for="insurerID">ID</label></td>
                            <td><input type="text" class="field" name="insurerID" placeholder="ID" size="30" maxlength="6"></td>
                        </tr>
                        <tr>
                            <td><label>Име</label></td>
                            <td><input type="text" class="field" name="insurerName" placeholder="Име" size="30" maxlength="50"></td>
                        </tr>
                        <tr>
                            <td><label>Фамилия</label></td>
                            <td><input type="text" class="field" name="insurerFamily" placeholder="Фамилия" size="30" maxlength="50"></td>
                        </tr>
                        <tr>
                            <td><label>Е-майл</label></td>
                            <td><input id="e-mail" type="text" class="field" placeholder="Е-майл" name="e-mail" size="30" onchange="validateEmail();" maxlength="100"></td>
                        </tr>
                        <tr>
                            <td><label>Парола</label></td>
                            <td><input type="password" class="field" name="password1" placeholder="Парола" size="30" maxlength="50"></td>
                        </tr>
                        <tr>
                            <td><label>Повторете парола</label></td>
                            <td><input type="password" class="field" name="password2" placeholder="Повторете паролата" size="30" maxlength="50"></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="submit" value="Добави"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>