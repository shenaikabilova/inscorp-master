<%@ page import="kabilova.tu.inscorp.model.policy.GO" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: AcerPC
  Date: 20.10.2017 г.
  Time: 12:52
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

<body>
<div class="menu">
    <div class="menu-nav">
        <ul>
            <li><a href="#">Клиент</a>
                <ul>
                    <li><a href="insurer/addNewInsured.jsp">Добави</a></li>
                    <li><a href="insurer/loadInsuredForUpdate.jsp">Промени</a></li>
                    <li><a href="insurer/deleteInsured.jsp">Изтрий</a></li>
                    <li><a href="insurer/loadAllClients.jsp">Изведи всички</a></li>
                    <li><a href="insurer/changeOwner.jsp">Смени собственик</a></li>
                </ul>
            </li>
            <li><a href="#">МПС</a>
                <ul>
                    <li><a href="insurer/loadClient.jsp">Добави</a></li>
                    <li><a href="insurer/loadVehicle.jsp">Промени</a></li>
                    <li><a href="insurer/deleteVehicle.jsp">Изтрий</a></li>
                    <li><a href="insurer/loadAllVehicles.jsp">Изведи всички</a></li>
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
            <li><a href="insurer/logout">Изход</a>
        </ul>
    </div>
</div>

<div class="newGO">
    <div class="shell">
        <h3>Редакция на застраховка "Гражданеска отговорност"</h3>
        <form action="/updateGO" method="post">
            <div class="form-section">
                <div class="form-section">
                <%
                    GO go = (GO) request.getAttribute("policy");
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                %>
                <div class="form-row">
                    <div class="form-row-inner">
                        <input type="hidden" class="field" id="insID" name="insID" value=<%=id%> readonly>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>Застраховател</label>
                        <input class="field" type="text" value=<%=username%> name="userName" readonly="readonly" maxlength="6" readonly>
                    </div>
                </div>
                <h4>Застрахователна полица ГО на МПС</h4>
                <div class="form-row">
                    <div class="form-row-inner">
                        <input type="hidden" class="field" id="polID" name="polID" value=<%=go.getId()%> readonly>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-row-inner">
                        <label>№ на полица</label>
                        <input class="field" id="policaN" type="text" name="policaN" readonly="readonly" maxlength="6" value=<%=go.getPolicaID()%> readonly>
                    </div>
                </div>
                <div class="form-section">
                    <h4>Застрахован</h4>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <input type="hidden" class="field" name="insuredID" value=<%=go.getInsured().getId()%> readonly>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>Собственик</label>
                            <input type="text" class="field" name="insuredFirstName" value=<%=go.getInsured().getFirstName()%> size="30" maxlength="50" readonly>
                            <input type="text" class="field" name="insuredSecondName" value=<%=go.getInsured().getSecondName()%> size="30" maxlength="50" readonly>
                            <input type="text" class="field" name="insuredLastName" value=<%=go.getInsured().getLastName()%> size="30" maxlength="50" readonly>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>ЕГН</label>
                            <input type="text" id="EGN" class="field" name="EGN" value=<%=go.getInsured().getEgn()%> maxlength="10" onchange="isValidateEGN();" readonly>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>Държава</label>
                            <input type="text" class="field" id="country" name="country" value=<%=go.getInsured().getCountry()%> maxlength="50" readonly>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label >Пощенски код</label>
                            <input type="text" class="field" name="pKod" value=<%=go.getInsured().getPostCode()%> size="20" maxlength="4" readonly>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>Град/Село</label>
                            <input type="text" class="field" id="city" name="city" value=<%=go.getInsured().getCity()%> maxlength="50" readonly>
                        </div>
                        <div class="form-row-inner">
                            <label>Адрес</label>
                            <input type="text" class="field" id="address" name="address" value=<%=go.getInsured().getAddress()%> maxlength="100" readonly>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>Мобилен телефон</label>
                            <input type="text" class="field" name="mobilePhone" value=<%=go.getInsured().getPhoneNumber()%> size="30" maxlength="10" readonly>
                        </div>
                    </div>
                </div>
                <div class="form-section">
                    <h4>Данни за МПС</h4>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <input type="hidden" class="field" id="vehicleID" name="vehicleID" value=<%=go.getVehicle().getVehicleID()%> readonly>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label for="registrationNumber">Регистрационен №</label>
                            <input type="text" id="registrationNumber" class="field" name="registrationNumber" value=<%=go.getVehicle().getRegNum()%> size="20" onchange="isValidRegNumber();" maxlength="8" readonly>
                        </div>
                        <div class="form-row-inner">
                            <label>Град</label>
                            <input type="text" class="field" id="regCity" name="regCity" value=<%=go.getVehicle().getRegCity()%> readonly>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label for="zone">Зона</label>
                            <select id="zone" class="field" name="zone">
                                <option <%if(go.getVehicle().getZone()==1) {%> selected <% } %>>Зона І - София</option>
                                <option <%if(go.getVehicle().getZone()==2) {%> selected <% } %>>Зона IІ - Пловдив, Варна и Бургас</option>
                                <option <%if(go.getVehicle().getZone()==3) {%> selected <% } %>>Зона ІІІ - Други</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label for="vehicleType">Вид МПС</label>
                            <select id="vehicleType" class="field" name="vehicleType">
                                <option value=<%=go.getVehicle().getVehicleType().getId()%>><%=go.getVehicle().getVehicleType().getVehicleType()%></option>
                            </select>
                        </div>
                        <div class="form-row-inner">
                            <label>Подтип</label>
                            <select id="vehicleSubtype" class="field" name="vehicleSubtype">
                                <option value=<%=go.getVehicle().getVehicleSubtype().getId()%>><%=go.getVehicle().getVehicleSubtype().getSubtype()%>
                            </select>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>Рама №</label>
                            <input type="text" class="field" name="ramaN" value=<%=go.getVehicle().getRAMA()%> size="30" maxlength="17" readonly>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>Марка</label>
                            <select id="vehicleBrand" class="field" name="vehicleBrand">
                                <option><%=go.getVehicle().getBrand()%></option>
                            </select>
                        </div>
                        <div class="form-row-inner">
                            <label>Модел</label>
                            <input type="text" class="field" name="vehicleModel" value=<%=go.getVehicle().getModel()%> size="30" maxlength="50" readonly>
                        </div>
                        <div class="form-row-inner">
                            <label>Двигател</label>
                            <select id="engine" name="engine">
                                <option <%if(go.getVehicle().getEngine() == 1.4) { %> selected <% }%> >1.4</option>
                                <option <%if(go.getVehicle().getEngine() == 1.6) { %> selected <% }%> >1.6</option>
                                <option <%if(go.getVehicle().getEngine() == 1.8) { %> selected <% }%> >1.8</option>
                                <option <%if(go.getVehicle().getEngine() == 2.0) { %> selected <% }%> >2.0</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
                <div class="form-section">
                    <h4>Данни по полицата</h4>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>Дата на сключване</label>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>Начало</label>
                            <input class="field" type="text" placeholder="Начална дата" id="datepicker1" name="fromDate" value=<%=simpleDateFormat.format(go.getDateFrom().getTime())%>>
                        </div>
                        <div class="form-row-inner">
                            <label>Край</label>
                            <input class="field" type="text" placeholder="Крайна дата" id="datepicker2" name="toDate" value=<%=simpleDateFormat.format(go.getDateTo().getTime())%>>
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
                    <div class="form-row">
                        <div class="form-row-inner">
                            <input type="hidden" class="field" id="tariffID" name="tariffID" value=<%=go.getTariffGO().getTariffID()%> >
                        </div>
                    </div>
                    <h4>Застрахователна сума</h4>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>Застрахоателна сума</label>
                            <input type="text" class="field" id="vehicleInsValue" name="vehicleInsValue" size="30" readonly="readonly" value=<%=go.getTariffGO().getValue()%> readonly>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>Отстъпки</label>
                            <input onchange="setGOPremiq();" onkeypress="onchange();" onpaste="this.onchange();" oninput="onchange();"
                                    class="field" id="insOtstapki" type="text" name="insOtstapki" value="0">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>Надбавки</label>
                            <input onchange="setGOPremiq();" onkeypress="onchange();" onpaste="this.onchange();" oninput="onchange();"
                                    class="field" id=insNadbavki type="text" name="insNadbavki" value="0">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>Застрахователна премия</label>
                            <input class="field" id="value" type="text" name="value" value=<%=go.getTariffGO().getValue()%> readonly>
                        </div>
                    </div>
                </div>
                <input type="submit" value="Редактирай">
            </div>
        </form>
    </div>
</div>
</body>
</html>