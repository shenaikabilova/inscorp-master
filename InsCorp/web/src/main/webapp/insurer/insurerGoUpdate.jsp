<%--
  Created by IntelliJ IDEA.
  User: AcerPC
  Date: 20.10.2017 г.
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%--<%@page import="model.GrajdanskaOtgovornost"%>--%>
<%--<%@page import="java.util.List"%>--%>
<%--<%@page import="dao_jdbc.VehicleBrandDAOImpl"%>--%>
<%--<%@page import="dao_api.VehicleBrandDAO"%>--%>
<%--<%@page import="model.VehicleBrand"%>--%>
<%--<%@page import="dao_jdbc.VehicleTypeDAOImpl"%>--%>
<%--<%@page import="model.Country"%>--%>
<%--<%@page import="dao_jdbc.CountryDAOImpl"%>--%>
<%--<%@page import="dao_api.CountryDAO"%>--%>
<%--<%@page import="model.InsurerType"%>--%>
<%--<%@page import="dao_jdbc.InsurerTypeDAOImpl"%>--%>
<%--<%@page import="dao_api.InsurerTypeDAO"%>--%>
<%--<%@page import="model.VehicleType"%>--%>
<%--<%@page import="dao_api.VehicleTypeDAO"%>--%>
<html>
<head>
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
    <title><%=userName %></title>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <link href = "../style.css" type="text/css" rel = "stylesheet"/>

    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="js/GO/calendarGO.js"></script>
    <script src="js/GO/setKubici.js"></script>
    <script src="js/GO/setGOValue.js"></script>
    <script src="js/validate.js"></script>
    <script src="js/GO/onLoad.js"></script>
</head>

<body onload="onLoad();">
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

<div class="newGO">
    <div class="shell">
        <h3>Редакция на застраховка "Гражданска отговорност"</h3>
        <form action="GoUpdate" method="post">
            <%--<%--%>
                <%--List<GrajdanskaOtgovornost> list = (List<GrajdanskaOtgovornost>)request.getAttribute("result");--%>
                <%--for(GrajdanskaOtgovornost i : list) {--%>
            <%--%>--%>
            <%--<div class="form-section">--%>
                <%--<div class="form-section">--%>
                    <%--<h4>Застрахователна полица ГО на МПС</h4>--%>
                    <%--<div class="form-row">--%>
                        <%--<label>№ на полица</label>--%>
                        <%--<input class="field" type="text" value=<%=i.getInsurenceGrajdanskaOtgovornostID() %> name="policaN" maxlength="6">--%>
                    <%--</div>--%>
                    <%--<div class="form-row">--%>
                        <%--<label>Застраховател</label>--%>
                        <%--<input class="field" type="text" value=<%=userName%> name="userName" readonly="readonly" maxlength="6">--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="form-section">--%>
                    <%--<h4>Застрахован</h4>--%>
                    <%--<div class="form-row">--%>
                        <%--<label>Тип на клиента:</label>--%>

                        <%--<select id="insType" class="field" name="insType">--%>
                            <%--<%--%>
                                <%--InsurerTypeDAO insTypes = new InsurerTypeDAOImpl();--%>
                                <%--for(InsurerType type : insTypes.listInsurerTypes()) { %>--%>
                            <%--<option--%>
                                    <%--<%--%>
                                        <%--if(type.getInsurerType().equals(i.getInsurenceType())) { %>--%>
                                    <%--selected--%>
                                    <%--<% } %>--%>
                            <%--><%=type.getInsurerType() %></option>--%>
                            <%--<%} %>--%>
                        <%--</select>--%>
                    <%--</div>--%>
                    <%--<div class="form-row">--%>
                        <%--<label>Собственик</label>--%>
                        <%--<input type="text" class="field" value=<%=i.getInsurenceFirstName() %> name="insuredFirstName" placeholder="Име" size="30" maxlength="50">--%>
                        <%--<input type="text" class="field" value=<%=i.getInsurenceSecondName() %> name="insuredSecondName" placeholder="Презиме" size="30" maxlength="50">--%>
                        <%--<input type="text" class="field" value=<%=i.getInsurenceLastName() %> name="insuredLastName" placeholder="Фамилия" size="30" maxlength="50">--%>
                    <%--</div>--%>
                    <%--<div class="form-row">--%>
                        <%--<label>ЕГН</label>--%>
                        <%--<input type="text" class="field" value=<%=i.getInsurenceEGN() %> name="EGN" placeholder="ЕГН" maxlength="10">--%>
                    <%--</div>--%>
                    <%--<div class="form-row">--%>
                        <%--<label>Държава</label>--%>
                        <%--<select class="field" name="country">--%>
                            <%--<%--%>
                                <%--CountryDAO countries = new CountryDAOImpl();--%>
                                <%--for(Country country : countries.listCountries()) { %>--%>
                            <%--<option--%>
                                    <%--<%--%>
                                        <%--if(country.getCountry().equals(i.getInsurenceCountry())) { %>--%>
                                    <%--selected--%>
                                    <%--<% } %>--%>
                            <%--><%=country.getCountry()%></option>--%>
                            <%--<%} %>--%>
                        <%--</select>--%>
                    <%--</div>--%>
                    <%--<div class="form-row">--%>
                        <%--<div class="form-row-inner">--%>
                            <%--<label for="address">Адрес на собственика</label>--%>
                            <%--<input type="text" class="field" value=<%=i.getInsurenceAddress() %> name="address" placeholder="гр. ж.к. ул. бл. вх. ет. ап." size="50" maxlength="200">--%>
                        <%--</div>--%>
                        <%--<div class="form-row-inner">--%>
                            <%--<label for="pKod">Пощенски код</label>--%>
                            <%--<input type="text" class="field" value=<%=i.getInsurencePK() %> name="pKod" placeholder="Пощенски код" size="20" maxlength="4">--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="form-row">--%>
                        <%--<label>Мобилен телефон</label>--%>
                        <%--<input type="text" class="field" value=<%=i.getInsurenceMobilePhone() %> name="mobilePhone" placeholder="Мобилен телефон" size="30" maxlength="10">--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="form-action">--%>
                <%--<h4>Данни за МПС</h4>--%>
                <%--<div class="form-row">--%>
                    <%--<div class="form-row">--%>
                        <%--<div class="form-row-inner">--%>
                            <%--<label for="registrationNumber">Регистрационен №</label>--%>
                            <%--<input type="text" id="registrationNumber" class="field" value=<%=i.getVehicleRegNumber() %> name="registrationNumber" placeholder="Регистрационен №" size="20" onchange="isValidRegNumber();" maxlength="8">--%>
                        <%--</div>--%>

                        <%--<div class="form-row-inner">--%>
                            <%--<label for="zone">Зона</label>--%>
                            <%--<select id="zone" class="field" name="zone" onchange="sum();">--%>
                                <%--<option--%>
                                        <%--<%--%>
                                            <%--if(i.getZone().equals("Зона І - София")) { %>--%>
                                        <%--selected--%>
                                        <%--<% }%>--%>
                                <%-->Зона І - София</option>--%>
                                <%--<option--%>
                                        <%--<%--%>
                                            <%--if(i.getZone().equals("Зона IІ - Пловдив, Варна и Бургас")) { %>--%>
                                        <%--selected--%>
                                        <%--<% }%>--%>
                                <%-->Зона IІ - Пловдив, Варна и Бургас</option>--%>
                                <%--<option--%>
                                        <%--<%--%>
                                            <%--if(i.getZone().equals("Зона ІІІ - Други")) { %>--%>
                                        <%--selected--%>
                                        <%--<% }%>--%>
                                <%-->Зона ІІІ - Други</option>--%>
                            <%--</select>--%>
                        <%--</div>--%>
                    <%--</div>--%>

                    <%--<div class="form-row">--%>
                        <%--<div class="form-row-inner">--%>
                            <%--<label for="vehicleType">Вид МПС</label>--%>
                            <%--<select id="vehicleType" class="field" name="vehicleType" onchange="change();">--%>
                                <%--<%--%>
                                    <%--VehicleTypeDAO vTypes = new VehicleTypeDAOImpl();--%>
                                    <%--for(VehicleType type : vTypes.listVehicleTypes()) { %>--%>
                                <%--<option--%>
                                        <%--<%--%>
                                            <%--if(type.getVehicleType().equals(i.getVehicleType())) { %>--%>
                                        <%--selected--%>
                                        <%--<% } %>--%>
                                <%--><%=type.getVehicleType() %></option>--%>
                                <%--<%} %>--%>
                            <%--</select>--%>
                        <%--</div>--%>
                        <%--<div class="form-row-inner">--%>
                            <%--<label for="kubici">Кубици</label>--%>
                            <%--<select id="kubici" class="field" name="kubici" onchange="sum();"></select>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="form-row">--%>
                        <%--<div class="form-row-inner">--%>
                            <%--<label for="ramaN">Рама №</label>--%>
                            <%--<input type="text" class="field" value=<%=i.getVehicleRama() %> name="ramaN" placeholder="Рама №" size="30" maxlength="17">--%>
                        <%--</div>--%>
                    <%--</div>--%>

                    <%--<div class="form-row">--%>
                        <%--<div class="form-row-inner">--%>
                            <%--<label for="vehicleBrand">Марка</label>--%>
                            <%--<select id="vehicleBrand" class="field" name="vehicleBrand">--%>
                                <%--<%--%>
                                    <%--VehicleBrandDAO brands = new VehicleBrandDAOImpl();--%>
                                    <%--for(VehicleBrand brand : brands.listAllVehicleBrand()) { %>--%>
                                <%--<option--%>
                                        <%--<%--%>
                                            <%--if(brand.getVehicleBrand().equals(i.getVehicleBrand())) { %>--%>
                                        <%--selected--%>
                                        <%--<% } %>--%>
                                <%--><%=brand.getVehicleBrand() %></option>--%>
                                <%--<%} %>--%>
                            <%--</select>--%>
                        <%--</div>--%>
                        <%--<div class="form-row-inner">--%>
                            <%--<label>Модел</label>--%>
                            <%--<input type="text" class="field" value=<%=i.getVehicleModel() %> name="vehicleModel" placeholder="Модел" size="30" maxlength="50">--%>
                        <%--</div>--%>
                    <%--</div>--%>

                    <%--<div class="form-row">--%>
                        <%--<label>Дата на сключване</label>--%>
                    <%--</div>--%>
                    <%--<div class="form-row">--%>
                        <%--<div class="form-row-inner">--%>
                            <%--<label>Начало</label>--%>
                            <%--<input class="field" type="text" value=<%=i.getInsurenceDateFrom() %> placeholder="Начална дата" id="datepicker1" name="fromDate">--%>
                        <%--</div>--%>
                        <%--<div class="form-row-inner">--%>
                            <%--<label>Край</label>--%>
                            <%--<input class="field" type="text" value=<%=i.getInsurenceDateTo() %> placeholder="Крайна датва" id="datepicker2" name="toDate">--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="form-row">--%>
                        <%--<label>Срок</label>--%>
                        <%--<select id="months" class="field" name="months">--%>
                            <%--<option--%>
                                    <%--<%--%>
                                        <%--if(i.getInsurenceMonths() == 12) { %>--%>
                                    <%--selected--%>
                                    <%--<% }%>--%>
                            <%-->12</option>--%>
                        <%--</select>--%>
                    <%--</div>--%>
                <%--</div>--%>

                <%--<div class="form-action">--%>
                    <%--<h4>Застрахователна сума</h4>--%>
                    <%--<div class="form-row">--%>
                        <%--<label>Застрахоателна сума</label>--%>
                        <%--<input type="text"--%>
                               <%--class="field" value=<%=i.getInsurenceValue() %> id="vehicleInsValue" name="vehicleInsValue" size="30" readonly="readonly" >--%>

                    <%--</div>--%>
                    <%--<!-- 						<div class="form-row"> -->--%>
                    <%--<!-- 							<label>Отстъпки</label> -->--%>
                    <%--<!-- 							<input  -->--%>
                    <%--<!-- 							onchange="setGOPremiq();" onkeypress="onchange();" onpaste="this.onchange();" oninput="onchange();" -->--%>
                    <%--<!-- 							class="field" id="insOtstapki" type="text" name="insOtstapki" value="0"> -->--%>
                    <%--<!-- 						</div> -->--%>
                    <%--<!-- 						<div class="form-row"> -->--%>
                    <%--<!-- 							<label>Надбавки</label> -->--%>
                    <%--<!-- 							<input -->--%>
                    <%--<!-- 							onchange="setGOPremiq();" onkeypress="onchange();" onpaste="this.onchange();" oninput="onchange();" -->--%>
                    <%--<!-- 							class="field" id=insNadbavki type="text" name="insNadbavki" value="0"> -->--%>
                    <%--<!-- 						</div> -->--%>
                    <%--<div class="form-row">--%>
                        <%--<label>Застрахователна премия</label>--%>
                        <%--<input class="field" value=<%=i.getInsurencePremiq() %>  id="insPremiq" type="text" name="insPremiq" readonly="readonly" >--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<input type="submit" value="Сключи застраховка" name="GoUpdate">--%>
            <%--<% } %>--%>
        </form>
    </div>
</div>
</body>
</html>