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
            String username = null;
            String password = null;
            if(!request.getSession().isNew() && session!=null) {
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
        <h3>Добави застрахователен агент</h3>
        <form action="/adminPanelAddInsurer" method="post">
            <div class="form-section">
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Служебен №</label>
                        <input type="text" class="field" name="insurerID" placeholder="Служебен №" size="50" maxlength="6">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Име</label>
                        <input type="text" class="field" name="insurerFirstName" placeholder="Име" size="50" maxlength="50">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Презиме</label>
                        <input type="text" class="field" id="secondName" name="insurerSecondName" placeholder="Презиме" size="50" maxlength="50">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Фамилия</label>
                        <input type="text" class="field" name="insurerLastName" placeholder="Фамилия" size="50" maxlength="50">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Потребителско име</label></td>
                        <input type="text" class="field" id="username" name="username" placeholder="Потребителско име" maxlength="50">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Парола</label></td>
                        <input type="password" class="field" name="password1" placeholder="Парола" size="30" maxlength="50">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Повторете парола</label></td>
                        <input type="password" class="field" name="password2" placeholder="Повторете паролата" size="30" maxlength="50">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Е-майл</label></td>
                        <input id="e-mail" type="text" class="field" placeholder="Е-майл" name="e-mail" size="30" onchange="validateEmail();" maxlength="100">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Телефонен №</label></td>
                        <input type="number" class="field" id="phoneNumber" name="phoneNumber" placeholder="Телефонен №">
                    </div>
                </div>
                <input type="submit" value="Добави"></td>
            </div>
        </form>
    </div>
</div>
</body>
</html>