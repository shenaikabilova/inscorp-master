<%--
  Created by IntelliJ IDEA.
  User: AcerPC
  Date: 20.10.2017 г.
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
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
        <h3>Сключване на застраховка "Гражданеска отговорност"</h3>
        <form action="addNewGO" method="post">
            <div class="form-section">
                <div class="form-section">
                    <h4>Застрахователна полица ГО на МПС</h4>
                    <div class="form-row">
                        <label>№ на полица</label>
                        <%
                            GrajdanskaOtgovornostDAO insID = new GrajdanskaOtgovornostDAOImpl();
                            String id = insID.getLastInsID();
                            int countZeros=0;
                            int max=0;
                            for(int i=0; i<id.length(); i++) {
                                char c = id.charAt(i);
                                if(c == '0') {
                                    countZeros++;
                                    max=countZeros;
                                }
                                else countZeros=0;
                            }
                            int i = Integer.parseInt(id);
                            System.out.println(max);
                            System.out.println(i);
                            i++;
                            max = max + String.valueOf(i).length();
                            String newID = String.format("%0"+max+"d", i);
                        %>
                        <input class="field" id="policaN" type="text" name="policaN" readonly="readonly" maxlength="6"
                               value=<%=newID%>>
                    </div>
                    <div class="form-row">
                        <label>Застраховател</label>
                        <input class="field" type="text" value=<%=userName%> name="userName" readonly="readonly" maxlength="6">
                    </div>
                </div>
                <div class="form-section">
                    <h4>Застрахован</h4>
                    <div class="form-row">
                        <label>Тип на клиента:</label>
                        <select id="insType" class="field" name="insType">
                            <%
                                InsurerTypeDAO insTypes = new InsurerTypeDAOImpl();
                                for(InsurerType type : insTypes.listInsurerTypes()) { %>
                            <option><%=type.getInsurerType() %></option>
                            <%} %>
                        </select>
                    </div>
                    <div class="form-row">
                        <label>Собственик</label>
                        <input type="text" class="field" name="insuredFirstName" placeholder="Име" size="30" maxlength="50">
                        <input type="text" class="field" name="insuredSecondName" placeholder="Презиме" size="30" maxlength="50">
                        <input type="text" class="field" name="insuredLastName" placeholder="Фамилия" size="30" maxlength="50">
                    </div>
                    <div class="form-row">
                        <label>ЕГН</label>
                        <input type="text" id="EGN" class="field" name="EGN" placeholder="ЕГН" maxlength="10" onchange="isValidateEGN();">
                    </div>
                    <div class="form-row">
                        <label>Държава</label>
                        <select class="field" name="country">
                            <%
                                CountryDAO countries = new CountryDAOImpl();
                                for(Country country : countries.listCountries()) { %>
                            <option><%=country.getCountry()%></option>
                            <%} %>
                        </select>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label for="address">Адрес на собственика</label>
                            <input type="text" class="field" name="address" placeholder="гр. ж.к. ул. бл. вх. ет. ап." size="50" maxlength="200">
                        </div>
                        <div class="form-row-inner">
                            <label for="pKod">Пощенски код</label>
                            <input type="text" class="field" name="pKod" placeholder="Пощенски код" size="20" maxlength="4">
                        </div>
                    </div>
                    <div class="form-row">
                        <label>Мобилен телефон</label>
                        <input type="text" class="field" name="mobilePhone" placeholder="Мобилен телефон" size="30" maxlength="10">
                    </div>
                </div>
            </div>
            <div class="form-section">
                <h4>Данни за МПС</h4>

                <div class="form-row">
                    <div class="form-row-inner">
                        <label for="registrationNumber">Регистрационен №</label>
                        <input type="text" id="registrationNumber" class="field" name="registrationNumber" placeholder="Регистрационен №" size="20" onchange="isValidRegNumber();" maxlength="8">
                    </div>

                    <div class="form-row-inner">
                        <label for="zone">Зона</label>
                        <select id="zone" class="field" name="zone" onchange="sum();">
                            <option>Зона І - София</option>
                            <option>Зона IІ - Пловдив, Варна и Бургас</option>
                            <option>Зона ІІІ - Други</option>
                        </select>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-row-inner">
                        <label for="vehicleType">Вид МПС</label>
                        <select id="vehicleType" class="field" name="vehicleType" onchange="change();">
                            <%
                                VehicleTypeDAO vTypes = new VehicleTypeDAOImpl();
                                for(VehicleTypeServer type : vTypes.listVehicleTypes()) { %>
                            <option><%=type.getVehicleType() %></option>
                            <%} %>
                        </select>
                    </div>
                    <div class="form-row-inner">
                        <label for="kubici">Кубици</label>
                        <select id="kubici" class="field" name="kubici" onchange="sum();"></select>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-row-inner">
                        <label for="ramaN">Рама №</label>
                        <input type="text" class="field" name="ramaN" placeholder="Рама №" size="30" maxlength="17">
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-row-inner">
                        <label for="vehicleBrand">Марка</label>
                        <select id="vehicleBrand" class="field" name="vehicleBrand">
                            <%
                                VehicleBrandDAO brands = new VehicleBrandDAOImpl();
                                for(VehicleBrand brand : brands.listAllVehicleBrand()) { %>
                            <option><%=brand.getVehicleBrand() %></option>
                            <%} %>
                        </select>
                    </div>
                    <div class="form-row-inner">
                        <label>Модел</label>
                        <input type="text" class="field" name="vehicleModel" placeholder="Модел" size="30" maxlength="50">
                    </div>
                </div>

                <div class="form-row">
                    <label>Дата на сключване</label>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Начало</label>
                        <input class="field" type="text" placeholder="Начална дата" id="datepicker1" name="fromDate">
                    </div>
                    <div class="form-row-inner">
                        <label>Край</label>
                        <input class="field" type="text" placeholder="Крайна датва" id="datepicker2" name="toDate">
                    </div>
                </div>
                <div class="form-row">
                    <label>Срок</label>
                    <select id="months" class="field" name="months">
                        <option>12</option>
                    </select>
                </div>
            </div>

            <div class="form-section">
                <h4>Застрахователна сума</h4>
                <div class="form-row">
                    <label>Застрахоателна сума</label>
                    <input type="text"
                           class="field" id="vehicleInsValue" name="vehicleInsValue" size="30" readonly="readonly">
                </div>
                <div class="form-row">
                    <label>Отстъпки</label>
                    <input
                            onchange="setGOPremiq();" onkeypress="onchange();" onpaste="this.onchange();" oninput="onchange();"
                            class="field" id="insOtstapki" type="text" name="insOtstapki" value="0">
                </div>
                <div class="form-row">
                    <label>Надбавки</label>
                    <input
                            onchange="setGOPremiq();" onkeypress="onchange();" onpaste="this.onchange();" oninput="onchange();"
                            class="field" id=insNadbavki type="text" name="insNadbavki" value="0">
                </div>
                <div class="form-row">
                    <label>Застрахователна премия</label>
                    <input class="field" id="insPremiq" type="text" name="insPremiq">
                </div>
            </div>

            <input type="submit" value="Сключи застраховка">
        </form>
    </div>
</div>
</body>
</html>