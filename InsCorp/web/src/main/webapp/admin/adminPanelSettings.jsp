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
        <h3>Настройки на администратора</h3>
        <form action="/adminPanelSettings" method="post">
        <%
            Admin admin = new Admin();
            admin.setUsername(username);
            admin.setPassword(password);
            UserServer userServer = new UserServer(admin);

        %>
            <div class="form-section">
               <div class="form-row">
                    <div class="form-row-inner">
                        <input type="hidden" class="field" name="adminID" size="30" value=<%=userServer.loadUser(username, password).getId()%> >
                    </div>
               </div>
               <div class="form-row">
                   <div class="form-row-inner">
                      <label>Потребителско име</label> 
                      <input type="text" class="field" name="username" size="30" value=<%=userServer.loadUser(username, password).getUsername()%>>
                    </div>
               </div>
               <div class="form-row">
                   <div class="form-row-inner">
                      <label>Име</label> 
                      <input type="text" class="field" name="firstName" size="30" value=<%=userServer.loadUser(username, password).getFirstName()%>>
                   </div>
               </div>
               <div class="form-row">
                   <div class="form-row-inner">
                      <label>Презиме</label> 
                      <input type="text" class="field" name="secondName" size="30" value=<%=userServer.loadUser(username, password).getSecondName()%>>
                   </div>
               </div>
               <div class="form-row">
                   <div class="form-row-inner">
                      <label>Фамилия</label>
                      <input type="text" class="field" name="lastName" size="30" value=<%=userServer.loadUser(username, password).getLastName()%>>
                   </div>
               </div>
               <div class="form-row">
                   <div class="form-row-inner">
                      <label>Е-майл</label> 
                      <input type="text" class="field" name="email" size="30" value=<%=userServer.loadUser(username, password).getEmail()%>>
                   </div>
               </div>
               <div class="form-row">
                   <div class="form-row-inner">
                       <label>Телефонен №</label></td>
                       <input type="text" class="field" id="phoneNumber" value=<%=userServer.loadUser(username,password).getPhoneNumber()%>>
                    </div>
                </div>
               <div class="form-row">
                   <div class="form-row-inner">
                      <label>Парола</label> 
                      <input type="password" class="field" name="password1" size="30" placeholder="Парола">
                   </div>
               </div>
               <div class="form-row">
                   <div class="form-row-inner">
                      <label>Повторете парола</label> 
                      <input type="password" class="field" name="password2" size="30" placeholder="Повторете парола">
                   </div>
               </div>
                <input type="submit" value="Промени">
               </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>