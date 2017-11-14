<%--
  Created by IntelliJ IDEA.
  User: AcerPC
  Date: 20.10.2017 г.
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><!DOCTYPE html>
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
    <%@ page contentType="text/html; charset=UTF-8" %>
    <link href = "../style.css" type="text/css" rel = "stylesheet"/>

    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="js/Kasko/calendarKasko.js"></script>
    <script type="text/javascript" src="js/Kasko/setKaskoSettings.js"></script>
    <script src="js/Kasko/setKaskoValue.js"></script>
    <script src="js/validate.js"></script>
    <script src="js/GO/calendarGO.js"></script>
</head>

<body onload="addList()">
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

<div class="newKasko">
    <div class="shell">
        <h3>Редакция на застраховка "Каско"</h3>
        <form action="kaskoUpdate" method="post">

            <%--<% List<Kasko> list = (List<Kasko>)request.getAttribute("result");--%>
                <%--for(Kasko i : list) {--%>
            <%--%>--%>

            <%--<div class="form-section">--%>
                <%--<div class="form-row">--%>
                    <%--<label>Застраховател №</label>--%>
                    <%--<input class="field" type="text" value=<%=userName%> name="userName" readonly="readonly" maxlength="6">--%>
                <%--</div>--%>
                <%--<div class="form-row">--%>
                    <%--<label>№ на полица</label>--%>
                    <%--<input type="text" class="field" value=<%=i.getInsKaskoId() %> name="insurenceID" placeholder="№ на застраховка" size="30" maxlength="6">--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="form-section">--%>
                <%--<h4>Застрахован</h4>--%>
                <%--<div class="form-row">--%>
                    <%--<label>Тип на клиента</label>--%>
                    <%--<select id="insType" class="field" name="insType">--%>
                        <%--<%--%>
                            <%--InsurerTypeDAO insTypes = new InsurerTypeDAOImpl();--%>
                            <%--for(InsurerType type : insTypes.listInsurerTypes()) { %>--%>
                        <%--<option--%>
                                <%--<%--%>
                                    <%--if(type.getInsurerType().equals(i.getInsType())) { %>--%>
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
                    <%--<input type="text" class="field" value=<%=i.getInsurenceFamily() %> name="insuredLastName" placeholder="Фамилия" size="30" maxlength="50">--%>
                <%--</div>--%>
                <%--<div class="form-row">--%>
                    <%--<label for="EGN">ЕГН</label>--%>
                    <%--<input type="text" id="EGN" class="field" value=<%=i.getInsurenceEGN() %> name="EGN" placeholder="ЕГН" size="30" maxlength="10">--%>
                <%--</div>--%>
                <%--<div class="form-row">--%>
                    <%--<label for="mobilePhone">Мобилен телефон</label>--%>
                    <%--<input type="text" class="field" value=<%=i.getInsurenceMobilePhone() %> name="mobilePhone" placeholder="Мобилен телефон" size="30" maxlength="10">--%>
                <%--</div>--%>
                <%--<!-- 						<div class="form-row"> -->--%>
                <%--<!-- 							<label>Държава</label> -->--%>
                <%--<!-- 							<select class="field"> -->--%>
                <%--&lt;%&ndash; 								<%--%>
                <%--// 									CountryDAO countries = new CountryDAOImpl();--%>
                <%--&lt;%&ndash; 									for(Country country : countries.listCountries()) { %> &ndash;%&gt;--%>
                <%--<!-- 										<option -->--%>

                <%--&lt;%&ndash; 										><%=country.getCountry() %></option> &ndash;%&gt;--%>
                <%--&lt;%&ndash; 									<%} %> &ndash;%&gt;--%>
                <%--<!-- 							</select> -->--%>
                <%--<!-- 						</div> -->--%>
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
            <%--</div>--%>
            <%--<div class="form-section">--%>
                <%--<h4>Данни за МПС</h4>--%>
                <%--<div class="form-row">--%>
                    <%--<label for="registrationNumber">Регистрационен №</label>--%>
                    <%--<input type="text" id="registrationNumber" class="field" value=<%=i.getVehicleRegistrationNumber() %> name="registrationNumber" placeholder="Регистрационен №" size="20" onchange="isValidRegNumber();" maxlength="8">--%>
                <%--</div>--%>

                <%--<div class="form-row">--%>
                    <%--<div class="form-row-inner">--%>
                        <%--<label for="vehicleType">Вид МПС</label>--%>
                        <%--<select id="vehicleType" class="field" name="vehicleType">--%>
                            <%--<%--%>
                                <%--VehicleTypeDAO vTypes = new VehicleTypeDAOImpl();--%>
                                <%--for(VehicleTypeServer type : vTypes.listVehicleTypes()) { %>--%>
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
                        <%--<label for="ramaN">Рама №</label>--%>
                        <%--<input type="text" class="field" value=<%=i.getVehicleRama() %> name="ramaN" placeholder="Рама №" size="30" maxlength="17">--%>
                    <%--</div>--%>
                <%--</div>--%>

                <%--<div class="form-row">--%>
                    <%--<div class="form-row-inner">--%>
                        <%--<label for="vehicleBrand">Марка</label>--%>
                        <%--<select id="vehicleBrand" class="field" name="vehicleBrand">--%>
                            <%--<%--%>
                                <%--VehicleBrandDAO types = new VehicleBrandDAOImpl();--%>
                                <%--for(VehicleBrand type : types.listAllVehicleBrand()) { %>--%>
                            <%--<option--%>
                                    <%--<%--%>
                                        <%--if(type.getVehicleBrand().equals(i.getVehicleBrand())) { %>--%>
                                    <%--selected--%>
                                    <%--<% } %>--%>
                            <%--><%=type.getVehicleBrand() %></option>--%>
                            <%--<%} %>--%>
                        <%--</select>--%>
                    <%--</div>--%>
                    <%--<div class="form-row-inner">--%>
                        <%--<label>Модел</label>--%>
                        <%--<input type="text" class="field" value=<%=i.getVehicleModel() %> name="vehicleModel" placeholder="Модел" size="30" maxlength="50">--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="form-row">--%>
                    <%--<div class="form-row-inner">--%>
                        <%--<label>Цвят</label>--%>
                        <%--<select id="vehicleColor" class="field" name="vehicleColor">--%>
                            <%--<%--%>
                                <%--VehicleColorDAO colors = new VehicleColorDAOImpl();--%>
                                <%--for(VehicleColor color : colors.listAllVehicleColors()) { %>--%>
                            <%--<option--%>
                                    <%--<%--%>
                                        <%--if(color.getVehicleColor().equals(i.getVehicleColor())) { %>--%>
                                    <%--selected--%>
                                    <%--<% } %>--%>
                            <%--><%=color.getVehicleColor() %></option>--%>
                            <%--<% } %>--%>
                        <%--</select>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="form-row">--%>
                    <%--<div class="form-row-inner">--%>
                        <%--<label>Година на производство</label>--%>
                        <%--<select id="year" class="field" name="year">--%>
                            <%--<option><%=i.getVehicleYear()%></option>--%>
                        <%--</select>--%>
                    <%--</div>--%>
                    <%--<div class="form-row-inner">--%>
                        <%--<label>Дата на първа регистрация</label>--%>
                        <%--<input type="text" class="field" value=<%=i.getVehicleFirstRegistration() %> name="vehicleFirstReg" placeholder="Дата на първа регистрация" id="datepicker" size="30">--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="form-row">--%>
                    <%--<div class="form-row-inner">--%>
                        <%--<label>Обем на двигателя</label>--%>
                        <%--<select id="vehicleEngine" class="field" name="vehicleEngine">--%>
                            <%--<option><%=i.getVehicleEngine()%></option>--%>
                        <%--</select>--%>
                    <%--</div>--%>
                    <%--<div class="form-row-inner">--%>
                        <%--<label>Брой места</label>--%>
                        <%--<select id="vehiclePlaces" class="field" name="vehiclePlaces">--%>
                            <%--<option><%=i.getVehiclePlaceNumber()%></option>--%>

                        <%--</select>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="form-row">--%>
                    <%--<div class="form-row-inner">--%>
                        <%--<label>Начало</label>--%>
                        <%--<input class="field" type="text" value=<%=i.getInsurenceDateFrom()%> id="datepicker1" name="fromDate">--%>
                    <%--</div>--%>
                    <%--<div class="form-row-inner">--%>
                        <%--<label>Край</label>--%>
                        <%--<input class="field" type="text" value=<%=i.getInsurenceDateTo()%> id="datepicker2" name="toDate">--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="form-row">--%>
                    <%--<label>Застрахоателна сума</label>--%>
                    <%--<input type="text"--%>
                           <%--onchange="change();" onkeypress="onchange();" onpaste="this.onchange();" oninput="onchange();"--%>
                           <%--class="field" value=<%=i.getVehicleInsurenceValue() %> id="vehicleInsValue" name="vehicleInsValue" size="30" value="0">--%>
                <%--</div>--%>
                <%--<div class="form-row">--%>
                    <%--<label>Застрахователна премия</label>--%>
                    <%--<input type="text" class="field" value=<%=i.getVehicleInsurencePremiq() %> id="vehicleInsPremiq" name="vehicleInsPremiq" size="30">--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<input type="submit" value="Промени" name="kaskoUpdate">--%>

            <%--<% } %>--%>
        </form>
    </div>
</div>
</body>
</html>