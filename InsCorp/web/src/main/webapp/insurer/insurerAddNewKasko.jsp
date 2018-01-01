<%@ page import="kabilova.tu.inscorp.server.web.PolicyServer" %>
<%@ page import="kabilova.tu.inscorp.model.policy.Kasko" %>
<%@ page import="kabilova.tu.inscorp.model.vehicle.Vehicle" %>
<%@ page import="kabilova.tu.inscorp.model.tariff.TariffKasko" %><%--
  Created by IntelliJ IDEA.
  User: AcerPC
  Date: 20.10.2017 г.
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <%
        int id = 0;
        String username = null;
        String password = null;
        if(!request.getSession().isNew()) {
            id = Integer.parseInt(session.getAttribute("id").toString());
            username = session.getAttribute("username").toString();
            password = session.getAttribute("password").toString();
        }
        else {
            response.sendRedirect("insurer/login.jsp");
        }
    %>
    <title><%=username %></title>
    <link href = "../style.css" type="text/css" rel = "stylesheet"/>

    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="../js/calendar.js"></script>
    <script src="../js/setPremiq.js"></script>
    <script src="../js/validate.js"></script>
</head>

<body onload="addList()">
<div class="menu">
    <div class="menu-nav">
        <ul>
            <li><a href="#">Клиент</a>
                <ul>
                    <li><a href="insurer/addNewInsured.jsp">Добави</a></li>
                    <li><a href="insurer/loadInsuredForUpdate.jsp">Промени</a></li>
                    <li><a href="insurer/deleteInsured.jsp">Изтрий</a></li>
                    <li><a href="insurer/loadAllClients.jsp">Изведи всички</a></li>
                </ul>
            </li>
            <li><a href="#">МПС</a>
                <ul>
                    <li><a href="insurer/loadClient.jsp">Добави</a></li>
                    <li><a href="insurer/loadVehicle.jsp">Промени</a></li>
                    <li><a href="insurer/deleteVehicle.jsp">Изтрий</a></li>
                    <li><a href="insurer/loadAllVehicles.jsp">Изведи всички</a></li>
                    <li><a href="insurer/changeOwner.jsp">Смени собственик</a></li>
                </ul>
            </li>
            <li><a href="#">Нова застраховка</a>
                <ul>
                    <li><a href="insurer/loadMpsGO.jsp">Гражданска отговорност</a></li>
                    <li><a href="insurer/loadMpsKasko.jsp">Каско</a></li>
                </ul>
            </li>
            <li><a href="#">Търсене</a>
                <ul>
                    <li><a href="#">Гражданска отговорност</a>
                        <ul>
                            <li><a href="insurer/searchGO.jsp">Търсене по №</a></li>
                            <li><a href="insurer/seachGOByInsurer.jsp">Търсене по текущ застраховател</a></li>
                            <li><a href="insurer/searchGOAll.jsp">Изведи всички</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Каско</a>
                        <ul>
                            <li><a href="insurer/searchInsKaskoByID.jsp">Търсене по №</a></li>
                            <li><a href="insurer/searchKaskoByInsurer.jsp">Търсене по текущ застраховател</a></li>
                            <li><a href="insurer/searchKaskoAll.jsp">Изведи всички</a></li>
                        </ul>
                    </li>
                </ul>
            </li>
            <li><a href="#">Редакция</a>
                <ul>
                    <li><a href="insurer/insurerGoUpdateSearch.jsp">Гражданска отговорност</a></li>
                    <li><a href="insurer/insurerKaskoUpdateSearch.jsp">Каско</a></li>
                </ul>
            </li>
            <li><a href="insurer/insurerSettings.jsp">Настройки</a></li>
            <li><a href="logout">Изход</a>
        </ul>
    </div>
</div>

<div class="newKasko">
    <div class="shell">
        <h3>Сключване на застраховка "Каско"</h3>
        <form action="/addNewKasko" method="post">
            <div class="form-section">
                <div class="form-section">
                    <h4>Застрахователна полица ГО на МПС</h4>
                    <div class="form-row">
                        <label>№ на полица</label>
                        <%
                            PolicyServer policyServer = new PolicyServer(new Kasko());
                            String policyLastID = policyServer.getLastPolicyID();
                            int countZeros=0;
                            int max=0;
                            for(int i=0; i<policyLastID.length(); i++) {
                                char c = policyLastID.charAt(i);
                                if(c == '0') {
                                    countZeros++;
                                    max=countZeros;
                                }
                                else countZeros=0;
                            }
                            int i = Integer.parseInt(policyLastID);
                            i++;
                            max = max + String.valueOf(i).length();
                            String newPolicyID = String.format("%0"+max+"d", i);
                        %>
                        <input class="field" id="policaN" type="text" name="policaN" readonly="readonly" maxlength="6"
                               value=<%=newPolicyID%> readonly>
                    </div>
                    <div class="form-row">
                        <label>Застраховател ID</label>
                        <input type="text" id="insID" name="insID" value=<%=id%>>
                        <label>Застраховател</label>
                        <input class="field" type="text" value=<%=username%> name="userName" readonly="readonly" maxlength="6">
                    </div>
                </div>
                <div class="form-section">
                    <h4>Застрахован</h4>

                    <% Vehicle vehicle = (Vehicle) request.getAttribute("result");
                        TariffKasko tariffKasko = (TariffKasko) request.getAttribute("tariff");
                    %>
                    <label>ID</label>
                    <input type="text" class="field" name="insuredID" value=<%=vehicle.getInsured().getId()%>
                            <div class="form-row">
                    <label>Собственик</label>
                    <input type="text" class="field" name="insuredFirstName" value=<%=vehicle.getInsured().getFirstName()%> size="30" maxlength="50">
                    <input type="text" class="field" name="insuredSecondName" value=<%=vehicle.getInsured().getSecondName()%> size="30" maxlength="50">
                    <input type="text" class="field" name="insuredLastName" value=<%=vehicle.getInsured().getLastName()%> size="30" maxlength="50">
                </div>
                <div class="form-row">
                    <label>ЕГН</label>
                    <input type="text" id="EGN" class="field" name="EGN" value=<%=vehicle.getInsured().getEgn()%> maxlength="10" onchange="isValidateEGN();">
                </div>
                <input type="text" id="country" name="country" value=<%=vehicle.getInsured().getCountry()%> maxlength="50"><br>
                <div class="form-row-inner">
                    <label >Пощенски код</label>
                    <input type="text" class="field" name="pKod" value=<%=vehicle.getInsured().getPostCode()%> size="20" maxlength="4">
                </div>
                <label>Град/Село</label>
                <input type="text" id="city" name="city" value=<%=vehicle.getInsured().getCity()%> maxlength="50">
                <label>Адрес</label>
                <input type="text" id="address" name="address" value=<%=vehicle.getInsured().getAddress()%> maxlength="100">

                <div class="form-row">
                    <label>Мобилен телефон</label>
                    <input type="text" class="field" name="mobilePhone" value=<%=vehicle.getInsured().getPhoneNumber()%> size="30" maxlength="10">
                </div>

            </div>
            <div class="form-section">
                <h4>Данни за МПС</h4>
                <label>МПС - id</label>
                <input type="text" id="vehicleID" name="vehicleID" value=<%=vehicle.getVehicleID()%>>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label for="registrationNumber">Регистрационен №</label>
                        <input type="text" id="registrationNumber" class="field" name="registrationNumber" value=<%=vehicle.getRegNum()%> size="20" onchange="isValidRegNumber();" maxlength="8">
                    </div>

                    <div class="form-row-inner">
                        <label for="zone">Зона</label>
                        <select id="zone" class="field" name="zone" onchange="sum();">
                            <option value="1">Зона І - София</option>
                            <option value="2">Зона IІ - Пловдив, Варна и Бургас</option>
                            <option value="3">Зона ІІІ - Други</option>
                        </select>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-row-inner">
                        <label for="vehicleType">Вид МПС</label>
                        <select id="vehicleType" class="field" name="vehicleType">
                            <option value=<%=vehicle.getVehicleType().getId()%>><%=vehicle.getVehicleType().getVehicleType()%></option>
                        </select>
                    </div>
                    <div class="form-row-inner">
                        <label>Кубици</label>
                        <select id="vehicleSubtype" class="field" name="vehicleSubtype">
                            <option value=<%=vehicle.getVehicleSubtype().getId()%>><%=vehicle.getVehicleSubtype().getSubtype()%></option>
                        </select>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Рама №</label>
                        <input type="text" class="field" name="ramaN" value=<%=vehicle.getRAMA()%> size="30" maxlength="17">
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Марка</label>
                        <select id="vehicleBrand" class="field" name="vehicleBrand">
                            <option><%=vehicle.getBrand()%></option>
                        </select>
                    </div>
                    <div class="form-row-inner">
                        <label>Модел</label>
                        <input type="text" class="field" name="vehicleModel" value=<%=vehicle.getModel()%> size="30" maxlength="50">
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
                        <input class="field" type="text" placeholder="Крайна дата" id="datepicker2" name="toDate">
                    </div>
                </div>
                <div class="form-row">
                    <label>Срок</label>
                    <select id="period" class="field" name="period">
                        <option>12</option>
                    </select>
                </div>
            </div>

            <div class="form-section">
                <label>Тарифа ID</label>
                <input type="text" id="tariffID" name="tariffID" value=<%=tariffKasko.getTariffID()%>>
                <label>Оценка на МПС</label>
                <input type="text" id="vehicleValue" name="vehicleValue" placeholder="Оценка на МПС"
                       onchange="setKaskoPremiq();" onkeypress="onchange();" onpaste="this.onchange();" oninput="onchange();">
                <label>Тип Каско</label>
                <select id="kaskoType" name="kaskoType">
                    <option>Пълно Каско</option>
                    <option>Каско тип А</option>
                    <option>Каско тип Б</option>
                </select>
                <div class="form-row">
                    <label>Отстъпки</label>
                    <input
                            onchange="setKaskoPremiq();" onkeypress="onchange();" onpaste="this.onchange();" oninput="onchange();"
                            class="field" id="insOtstapki" type="text" name="insOtstapki" value="0">
                </div>
                <div class="form-row">
                    <label>Надбавки</label>
                    <input
                            onchange="setKaskoPremiq();" onkeypress="onchange();" onpaste="this.onchange();" oninput="onchange();"
                            class="field" id=insNadbavki type="text" name="insNadbavki" value="0">
                </div>
                <div class="form-row">
                    <label>Застрахователен %</label>
                    <input class="field" id="kaskoPercent" type="text" name="kaskoPercent" value=<%=tariffKasko.getKaskoPercent()%> readonly
                           onchange="setKaskoPremiq();" onkeypress="onchange();" onpaste="this.onchange();" oninput="onchange();">
                </div>
                <div class="form-row">
                    <label>Застрахователна премия</label>
                    <input class="field" id="value" type="text" name="value" readonly>
                </div>
            </div>

            <input type="submit" value="Сключи застраховка">
        </form>
    </div>
</div>
</body>
</html>