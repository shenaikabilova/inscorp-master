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
        <%
//            String userName = null;
//            Cookie[] cookies = request.getCookies();
//            if(cookies != null) {
//                for(Cookie cookie: cookies) {
//                    if(cookie.getName().equals("user")) {
//                        userName = cookie.getValue();
//                    }
//                }
//            }
//            if(userName == null) {
//                response.sendRedirect("login.jsp");
//            }
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
        <ul class="menu-nav">
            <li><a href="#">Застрахователни агенти</a>
                <ul>
                    <li><a href="adminPanelAddInsurer.jsp">Добави</a></li>
                    <li><a href="adminPanelSearchUser.jsp">Промени</a></li>
                    <li><a href="adminPanelDeleteUser.jsp">Изтрий</a></li>
                    <li><a href="adminPanelInsurers.jsp">Изведи</a></li>
                </ul>
            </li>
            <li><a href="#">МПС</a>
                <ul>
                    <li><a href="#">Тип МПС</a>
                        <ul>
                            <li><a href="addVehicleType.jsp">Добави</a></li>
                            <li><a href="vehicleSubtypeUpdate.jsp">Промени</a></li>
                            <li><a href="vehicleTypeDelete.jsp">Изтрий</a></li>
                            <li><a href="loadVehicleType.jsp">Преглед</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Подтип МПС</a>
                        <ul>
                            <li><a href="addVehicleSubtype.jsp">Добави</a></li>
                            <li><a href="vehicleSubtypeUpdate.jsp">Промени</a></li>
                            <li><a href="vehicleSubtypeDelete.jsp">Изтрий</a></li>
                            <li><a href="loadVehicleSubtype.jsp">Преглед</a></li>
                        </ul>
                    </li>
                </ul>
            </li>
            <li><a href="#">Тарифиране</a>
                <ul>
                    <li><a href="#">ГО</a>
                        <ul>
                            <li><a href="loadTariffGO.jsp">Добави тарифа ГО</a></li>
                            <li><a href="viewTariffGo.jsp">Изведи тарифиране</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Каско</a>
                        <ul>
                            <li><a href="loadTariffKasko.jsp">Добави тарифа Каско</a></li>
                            <li><a href="viewTariffKasko.jsp">Изведи тарифиране</a></li>
                        </ul>
                    </li>
                </ul>
            </li>
            <li><a href="adminPanelSettings.jsp">Настройки</a></li>
            <li><a href="AdminLogout">Изход</a></li>
        </ul>
    </div>

        <div class="addInsurer">
            <div class="shell">
                <form action="/adminPanelAddInsurer" method="post">
                    <table width="100%">
                        <tr>
                            <td></td>
                            <td><h3>Добави застрахователен агент</h3></td>
                        </tr>
                        <tr>
                            <td><label id="insurerID" for="insurerID">Служебен №</label></td>
                            <td><input type="number" class="field" name="insurerID" placeholder="ID" size="30" maxlength="6"></td>
                        </tr>
                        <tr>
                            <td><label>Име</label></td>
                            <td><input type="text" class="field" name="insurerFirstName" placeholder="Име" size="30" maxlength="50"></td>
                        </tr>
                        <tr>
                            <td><label>Презиме</label></td>
                            <td><input type="text" id="secondName" name="insurerSecondName" placeholder="Презиме" size="50" maxlength="50"></td>
                        </tr>
                        <tr>
                            <td><label>Фамилия</label></td>
                            <td><input type="text" class="field" name="insurerLastName" placeholder="Фамилия" size="30" maxlength="50"></td>
                        </tr>
                        <tr>
                            <td><label>Потребителско име</label></td>
                            <td><input type="text" id="username" name="username" placeholder="Потребителско име" maxlength="50"></td>
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
                            <td><label>Е-майл</label></td>
                            <td><input id="e-mail" type="text" class="field" placeholder="Е-майл" name="e-mail" size="30" onchange="validateEmail();" maxlength="100"></td>
                        </tr>
                        <tr>
                            <td><label>Телефонен №</label></td>
                            <td><input type="number" id="phoneNumber" name="phoneNumber" placeholder="Телефонен №"></td>
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