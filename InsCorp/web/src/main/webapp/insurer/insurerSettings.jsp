<%--
  Created by IntelliJ IDEA.
  User: AcerPC
  Date: 20.10.2017 г.
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<%--<%@page import="dao_jdbc.InsurerDAOImpl"%>--%>
<%--<%@page import="dao_api.InsurerDAO"%>--%>
<%
    try {
        Class.forName("com.mysql.jdbc.Driver");
    }
    catch (Exception e) {
        throw new UnavailableException(e.getMessage());
    }
%>

<%
    String userName = null;
    Cookie[] cookies = request.getCookies();
    if(cookies != null) {
        for(Cookie cookie: cookies) {
            if(cookie.getName().equals("user")) {
                userName = cookie.getValue();
            }
        }
    }
    if(userName == null) {
        response.sendRedirect("login.jsp");
    }
%>

<html>
<head>
    <title><%=userName %></title>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <link href = "../style.css" type="text/css" rel = "stylesheet"/>
</head>

<body>
<div class="menu">
    <div class="menu">
        <div class="menu-nav">
            <ul>
                <li><a href="insurer.jsp">Нова застраховка</a>
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
</div>

<div class="insurerSettings">
    <div class="shell">
        <form action="insurerSettings" method="post">
            <%--<%--%>
                <%--InsurerDAO insurer = new InsurerDAOImpl();--%>
            <%--%>--%>
            <%--<h3>Настройки</h3>--%>
            <%--<table width="100%">--%>
                <%--<tr>--%>
                    <%--<td><label>ID</label></td>--%>
                    <%--<td><input type="text" class="field" name="userID" size="30" readonly="readonly"--%>
                               <%--value=<%=insurer.searchUserName(userName).getInsurerId()%>></td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td><label>Име</label></td>--%>
                    <%--<td><input type="text" class="field" name="userName" size="30"--%>
                               <%--value=<%=insurer.searchUserName(userName).getInsurerName()%>></td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td><label>Фамилия</label></td>--%>
                    <%--<td><input type="text" class="field" name="userFamily" size="30"--%>
                               <%--value=<%=insurer.searchUserName(userName).getInsurerFamily()%>></td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td><label>Е-майл</label></td>--%>
                    <%--<td><input type="text" class="field" name="userEmail" size="30"--%>
                               <%--value=<%=insurer.searchUserName(userName).getInsurerEmail()%>></td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td><label>Парола</label></td>--%>
                    <%--<td><input type="password" class="field" name="password1" size="30"--%>
                               <%--value=<%=insurer.searchUserName(userName).getInsurerPassword()%>></td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td><label>Повторете парола</label></td>--%>
                    <%--<td><input type="password" class="field" name="password2" size="30"></td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td></td>--%>
                    <%--<td><input type="submit" value="Промяна"></td>--%>
                <%--</tr>--%>
            <%--</table>--%>
        </form>
    </div>
</div>
</body>
</html>