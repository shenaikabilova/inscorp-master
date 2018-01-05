<%@ page import="kabilova.tu.inscorp.model.policy.Kasko" %><%--
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
                            <li><a href="insurer/searchGOByID.jsp">Търсене по №</a></li>
                            <li><a href="insurer/seachGOByInsurer.jsp">Търсене по текущ застраховател</a></li>
                            <li><a href="insurer/searchGOAll.jsp">Изведи всички</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Каско</a>
                        <ul>
                            <li><a href="insurer/searchKaskoByID.jsp">Търсене по №</a></li>
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
        <form action="/updateKasko" method="post">
            <%
                Kasko kasko = (Kasko) request.getAttribute("policy");
            %>
            <div class="form-section">
                <h4>Застрахователна полица ГО на МПС</h4>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>№ на полица</label>
                            <input class="field" id="policaN" type="text" name="policaN" readonly="readonly" maxlength="6" value=<%=kasko.getPolicaID()%> readonly>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>Застраховател ID</label>
                            <input type="text" class="field" id="insID" name="insID" value=<%=id%>>
                        </div>
                        <div class="form-row-inner">
                            <label>Застраховател</label>
                            <input class="field" type="text" value=<%=username%> name="userName" readonly="readonly" maxlength="6">
                        </div>
                    </div>
            </div>
            <div class="form-section">
                <h4>Застрахован</h4>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>ID</label>
                        <input type="text" class="field" name="insuredID" value=<%=kasko.getVehicle().getInsured().getId()%>>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Собственик</label>
                        <input type="text" class="field" name="insuredFirstName" value=<%=kasko.getInsured().getFirstName()%> size="30" maxlength="50">
                        <input type="text" class="field" name="insuredSecondName" value=<%=kasko.getInsured().getSecondName()%> size="30" maxlength="50">
                        <input type="text" class="field" name="insuredLastName" value=<%=kasko.getInsured().getLastName()%> size="30" maxlength="50">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>ЕГН</label>
                        <input type="text" id="EGN" class="field" name="EGN" value=<%=kasko.getVehicle().getInsured().getEgn()%> maxlength="10" onchange="isValidateEGN();">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Държава</label>
                        <input type="text" class="field" id="country" name="country" value=<%=kasko.getVehicle().getInsured().getCountry()%> maxlength="50"><br>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Пощенски код</label>
                        <input type="text" class="field" name="pKod" value=<%=kasko.getVehicle().getInsured().getPostCode()%> size="20" maxlength="4">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Град/Село</label>
                        <input type="text" class="field" id="city" name="city" value=<%=kasko.getVehicle().getInsured().getCity()%> maxlength="50">
                    </div>
                    <div class="form-row-inner">
                        <label>Адрес</label>
                        <input type="text" class="field" id="address" name="address" value=<%=kasko.getVehicle().getInsured().getAddress()%> maxlength="100">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Мобилен телефон</label>
                        <input type="text" class="field" name="mobilePhone" value=<%=kasko.getVehicle().getInsured().getPhoneNumber()%> size="30" maxlength="10">
                    </div>
                </div>
            </div>
            <div class="form-section">
                <h4>Данни за МПС</h4>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>МПС - id</label>
                        <input type="text" class="field" id="vehicleID" name="vehicleID" value=<%=kasko.getVehicle().getVehicleID()%>>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label for="registrationNumber">Регистрационен №</label>
                        <input type="text" id="registrationNumber" class="field" name="registrationNumber" value=<%=kasko.getVehicle().getRegNum()%> size="20" onchange="isValidRegNumber();" maxlength="8">
                    </div>
                    <div class="form-row-inner">
                        <label>Град</label>
                        <input type="text" class="field" id="regCity" name="regCity" value=<%=kasko.getVehicle().getRegCity()%>>
                    </div>
                </div>
                <div class="form-row">
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
                            <option value=<%=kasko.getVehicle().getVehicleType().getId()%>><%=kasko.getVehicle().getVehicleType().getVehicleType()%></option>
                        </select>
                    </div>
                    <div class="form-row-inner">
                        <label>Подтип</label>
                        <select id="vehicleSubtype" class="field" name="vehicleSubtype">
                            <option value=<%=kasko.getVehicle().getVehicleSubtype().getId()%>><%=kasko.getVehicle().getVehicleSubtype().getSubtype()%></option>
                        </select>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Рама №</label>
                        <input type="text" class="field" name="ramaN" value=<%=kasko.getVehicle().getRAMA()%> size="30" maxlength="17">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Марка</label>
                        <select id="vehicleBrand" class="field" name="vehicleBrand">
                            <option><%=kasko.getVehicle().getBrand()%></option>
                        </select>
                    </div>
                    <div class="form-row-inner">
                        <label>Модел</label>
                        <input type="text" class="field" name="vehicleModel" value=<%=kasko.getVehicle().getModel()%> size="30" maxlength="50">
                    </div>
                    <div class="form-row-inner">
                        <label>Двигател</label>
                        <select id="engine" name="engine">
                            <option <%if(kasko.getVehicle().getEngine() == 1.4) { %> selected <% }%> >1.4</option>
                            <option <%if(kasko.getVehicle().getEngine() == 1.6) { %> selected <% }%> >1.6</option>
                            <option <%if(kasko.getVehicle().getEngine() == 1.8) { %> selected <% }%> >1.8</option>
                            <option <%if(kasko.getVehicle().getEngine() == 2.0) { %> selected <% }%> >2.0</option>
                        </select>
                    </div>
                </div>
            </div>
           <div class="form-section">
               <h4>Дата на сключване</h4>
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
                    <div class="form-row-inner">
                        <label>Срок</label>
                        <select id="period" class="field" name="period">
                            <option>12</option>
                        </select>
                    </div>
                </div>
           </div>
           <div class="form-section">
               <h4>Данни по полица</h4>
               <div class="form-row">
                   <div class="form-row-inner">
                        <label>Тарифа ID</label>
                        <input type="text" class="field" id="tariffID" name="tariffID" value=<%=kasko.getTariffKasko().getTariffID()%>>
                   </div>
               </div>
               <div class="form-row">
                   <div class="form-row-inner">
                        <label>Оценка на МПС</label>
                        <input type="text" class="field" id="vehicleValue" name="vehicleValue" placeholder="Оценка на МПС"
                           onchange="setKaskoPremiq();" onkeypress="onchange();" onpaste="this.onchange();" oninput="onchange();">
                    </div>
               </div>
               <div class="form-row">
                   <div class="form-row-inner">
                       <label>Тип Каско</label>
                        <select class="field" id="kaskoType" name="kaskoType">
                            <option <%if(kasko.getKaskoType().equals("Пълно Каско")) { %> selected <% } %>>Пълно Каско</option>
                            <option <%if(kasko.getKaskoType().equals("Каско тип А")) { %> selected <% } %>>Каско тип А</option>
                            <option <%if(kasko.getKaskoType().equals("Каско тип Б")) { %> selected <% } %>>Каско тип Б</option>
                        </select>
                   </div>
               </div>
               <div class="form-row">
                   <div class="form-row-inner">
                        <label>Отстъпки</label>
                        <input onchange="setKaskoPremiq();" onkeypress="onchange();" onpaste="this.onchange();" oninput="onchange();"
                                class="field" id="insOtstapki" type="text" name="insOtstapki" value="0">
                    </div>
               </div>
               <div class="form-row">
                   <div class="form-row-inner">
                        <label>Надбавки</label>
                        <input onchange="setKaskoPremiq();" onkeypress="onchange();" onpaste="this.onchange();" oninput="onchange();"
                                class="field" id=insNadbavki type="text" name="insNadbavki" value="0">
                    </div>
               </div>
               <div class="form-row">
                   <div class="form-row-inner">
                        <label>Застрахователен %</label>
                        <input class="field" id="kaskoPercent" type="text" name="kaskoPercent" value=<%=kasko.getTariffKasko().getKaskoPercent()%> readonly
                               onchange="setKaskoPremiq();" onkeypress="onchange();" onpaste="this.onchange();" oninput="onchange();">
                    </div>
               </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Застрахователна премия</label>
                        <input class="field" id="value" type="text" name="value" value=<%=kasko.getValue()%> readonly>
                    </div>
                </div>
           </div>
           <input type="submit" value="Сключи застраховка">
        </form>
    </div>
</div>
</body>
</html>