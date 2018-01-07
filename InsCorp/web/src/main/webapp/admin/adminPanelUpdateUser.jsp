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
</head>

<body>
<div class="menu">
    <ul class="menu-nav">
        <li><a href="#">Застрахователни агенти</a>
            <ul>
                <li><a href="admin/adminPanelAddInsurer.jsp">Добави</a></li>
                <li><a href="admin/adminPanelSearchUser.jsp">Промени</a></li>
                <li><a href="admin/adminPanelDeleteUser.jsp">Изтрий</a></li>
                <li><a href="admin/adminPanelInsurers.jsp">Изведи</a></li>
            </ul>
        </li>
        <li><a href="#">МПС</a>
            <ul>
                <li><a href="#">Тип МПС</a>
                    <ul>
                        <li><a href="admin/adminPanelAddVehicleType.jsp">Добави</a></li>
                        <li><a href="admin/adminPanelSearchVehicleType">Промени</a></li>
                        <li><a href="admin/adminPanelSearchVehicleType">Изтрий</a></li>
                        <li><a href="admin/adminPanelLoadVehicleType">Преглед</a></li>
                    </ul>
                </li>
                <li><a href="#">Подтип МПС</a>
                    <ul>
                        <li><a href="admin/adminPanelAddVehicleSubtype.jsp">Добави</a></li>
                        <li><a href="admin/adminPaneSearchVehicleSubtype">Промени</a></li>
                        <li><a href="admin/adminPanelSearchVehicleSubtype">Изтрий</a></li>
                        <li><a href="admin/adminPanelLoadVehicleSubtype">Преглед</a></li>
                    </ul>
                </li>
            </ul>
        </li>
        <li><a href="#">Тарифиране</a>
            <ul>
                <li><a href="#">ГО</a>
                    <ul>
                        <li><a href="admin/loadTariffGO.jsp">Добави тарифа ГО</a></li>
                        <li><a href="admin/viewTariffGo.jsp">Изведи тарифиране</a></li>
                    </ul>
                </li>
                <li><a href="#">Каско</a>
                    <ul>
                        <li><a href="admin/loadTariffKasko.jsp">Добави тарифа Каско</a></li>
                        <li><a href="admin/viewTariffKasko.jsp">Изведи тарифиране</a></li>
                    </ul>
                </li>
            </ul>
        </li>
        <li><a href="admin/adminPanelSettings.jsp">Настройки</a></li>
        <li><a href="AdminLogout">Изход</a></li>
    </ul>
</div>

<div class="adminpanelSettings">
    <div class="shell">
        <h3>Настройки на застраховател</h3>
        <form action="/updateInsurer" method="post">
        <%
            Insurer insurer = (Insurer) request.getAttribute("result");
        %>
            <div class="form-section">
                <div class="form-row">
                    <div class="form-row-inner">
                        <input type="hidden" class="field" name="id" size="30" value=<%=insurer.getId()%> readonly="readonly">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Служебен №</label>
                        <input type="text" class="field" name="insurerID" size="30" value=<%=insurer.getInsurerID()%> readonly="readonly">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Име</label>
                        <input type="text" class="field" name="insurerFirstName" value=<%=insurer.getFirstName()%> maxlength="50">
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
                        <input type="password" class="field" name="password1" size="30" placeholder="Парола" maxlength="50">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Повторете парола</label>
                        <input type="password" class="field" name="password2" placeholder="Повторете паролата" size="30" maxlength="50">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Телефонен №</label>
                        <input type="text" class="field" id="phoneNumber" name="phoneNumber" value=<%=insurer.getPhoneNumber()%>>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Е-майл</label>
                        <input id="e-mail" type="text" class="field" name="e-mail"  value=<%=insurer.getEmail()%> size="30" onchange="validateEmail();" maxlength="100">
                    </div>
                </div>
                <input type="submit" value="Промени">
            </div>
        </form>
    </div>
</div>
</body>
</html>