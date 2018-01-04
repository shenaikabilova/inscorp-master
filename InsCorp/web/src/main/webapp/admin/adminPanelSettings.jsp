<%@ page import="kabilova.tu.inscorp.server.web.UserServer" %>
<%@ page import="kabilova.tu.inscorp.model.user.Admin" %>
<%@ page import="java.security.MessageDigest" %>
<%@ page import="java.math.BigInteger" %>
<%@ page import="java.security.NoSuchAlgorithmException" %><%--
  Created by IntelliJ IDEA.
  User: AcerPC
  Date: 20.10.2017 г.
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%
//    String userName = null;
//    Cookie[] cookies = request.getCookies();
//    if(cookies != null) {
//        for(Cookie cookie: cookies) {
//            if(cookie.getName().equals("user")) {
//                userName = cookie.getValue();
//            }
//        }
//    }
//    if(userName == null) {
//        response.sendRedirect("login.jsp");
//    }
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

<html>
<head>
    <title><%=username %></title>
    <link href = "../style.css" type="text/css" rel = "stylesheet"/>
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
                        <li><a href="adminPanelSearchVehicleType">Промени</a></li>
                        <li><a href="adminPanelSearchVehicleType">Изтрий</a></li>
                        <li><a href="adminPanelLoadVehicleType">Преглед</a></li>
                    </ul>
                </li>
                <li><a href="#">Подтип МПС</a>
                    <ul>
                        <li><a href="addVehicleSubtype.jsp">Добави</a></li>
                        <li><a href="adminPaneSearchVehicleSubtype">Промени</a></li>
                        <li><a href="adminPanelSearchVehicleSubtype">Изтрий</a></li>
                        <li><a href="adminPanelLoadVehicleSubtype">Преглед</a></li>
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

<div class="adminpanelSettings">
    <div class="shell">
        <form action="adminPanelSettings" method="post">
            <table width="100%">
                <%
                    MessageDigest m;
                    BigInteger passEncrypt = null;
                    try {
                        m = MessageDigest.getInstance("MD5");
                        m.update(password.getBytes(), 0, password.length());
                        passEncrypt = new BigInteger(1, m.digest());
                        System.out.println(String.format("%1$032x", passEncrypt));
                    } catch (NoSuchAlgorithmException e1) {
                        e1.printStackTrace();
                    }

                    Admin admin = new Admin();
                    admin.setUsername(username);
                    admin.setPassword(String.format("%1$032x", passEncrypt));
                    UserServer userServer = new UserServer(admin);

                %>
                <tr>
                    <td></td>
                    <td><h3>Настройки на администратора</h3></td>
                </tr>
                <tr>
                    <td><label>ID</label></td>
                    <td><input type="text" class="field" name="userID" size="30" value=<%=userServer.loadUser(username, String.format("%1$032x", passEncrypt)).getId()%> ></td>
                </tr>
                <tr>
                    <td><label>Потребителско име</label></td>
                    <td><input type="text" class="field" name="userName" size="30" value=<%=userServer.loadUser(username, String.format("%1$032x", passEncrypt)).getUsername()%>></td>
                </tr>
                <tr>
                    <td><label>Име</label></td>
                    <td><input type="text" class="field" name="userName" size="30" value=<%=userServer.loadUser(username, String.format("%1$032x", passEncrypt)).getFirstName()%>></td>
                </tr>
                <tr>
                    <td><label>Презиме</label></td>
                    <td><input type="text" class="field" name="secondName" size="30" value=<%=userServer.loadUser(username, String.format("%1$032x", passEncrypt)).getSecondName()%>></td>
                </tr>
                <tr>
                    <td><label>Фамилия</label>
                    <td><input type="text" class="field" name="lastName" size="30" value=<%=userServer.loadUser(username, String.format("%1$032x", passEncrypt)).getLastName()%>></td>
                </tr>
                <tr>
                    <td><label>Е-майл</label></td>
                    <td><input type="text" class="field" name="userEmail" size="30" value=<%=userServer.loadUser(username, String.format("%1$032x", passEncrypt)).getEmail()%>></td>
                </tr>
                <tr>
                    <td><label>Парола</label></td>
                    <td><input type="password" class="field" name="password1" size="30" ></td>
                </tr>
                <tr>
                    <td><label>Повторете парола</label></td>
                    <td><input type="password" class="field" name="password2" size="30"></td>
                </tr>
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