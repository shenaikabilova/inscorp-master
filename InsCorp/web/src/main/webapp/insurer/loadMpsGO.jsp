<%--
  Created by IntelliJ IDEA.
  User: AcerPC
  Date: 14.11.2017 г.
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
   <%
       String username = session.getAttribute("username").toString();
       String password = session.getAttribute("password").toString();
   %>
    <title><%=username %></title>
</head>
<body>
<div class="menu">
    <div class="menu-nav">
        <ul>
            <li><a href="#">Добави</a>
                <ul>
                    <li><a href="addNewInsured.jsp">Нов клиент</a></li>
                    <li><a href="addNewMPS.jsp">Ново МПС</a></li>
                </ul>
            </li>
            <li><a href="#">Нова застраховка</a>
                <ul>
                    <li><a href="insurerAddNewGO.jsp">Гражданска отговорност</a></li>
                    <li><a href="insurerAddNewKasko.jsp">Каско</a></li>
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
                            <li><a href="searchAllKasko.jsp">Изведи всички</a></li>
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

<form action="/loadMpsGO" method="post">
    <label>Намери МПС</label><br>
    <input type="text" name="searchVehicleRegNum" placeholder="Регистрационен №" maxlength="10">
    <input type="submit" value="Зареди МПС"><br>
</form>
</body>
</html>