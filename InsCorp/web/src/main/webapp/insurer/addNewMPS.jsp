<%@ page import="kabilova.tu.inscorp.model.user.Insured" %>
<%@ page import="java.util.List" %>
<%@ page import="kabilova.tu.inscorp.model.vehicle.VehicleSubtype" %>
<%@ page import="kabilova.tu.inscorp.model.vehicle.VehicleType" %>
<%@ page import="kabilova.tu.inscorp.server.web.VehicleSubtypeServer" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: AcerPC
  Date: 21.10.2017 г.
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
//    String userName = null;
//    Cookie[] cookies = request.getCookies();
//    if(cookies != null) {
//    for(Cookie cookie: cookies) {
//    if(cookie.getName().equals("user")) {
//    userName = cookie.getValue();
//    }
//    }
//    }
//    if(userName == null) {
//    response.sendRedirect("login.jsp");
//    }

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
    <script>
        var types = {};

        <%
            List<VehicleSubtype> vehicleSubtypes = new VehicleSubtypeServer().read();
            Map<VehicleType, List<VehicleSubtype>> map = new HashMap<>();

            for(VehicleSubtype v : vehicleSubtypes){
                map.computeIfAbsent(v.getVehicleType(), k->new ArrayList<>()).add(v);
            }

            for (Map.Entry<VehicleType, List<VehicleSubtype>> type : map.entrySet()) {%>
        types['<%=type.getKey().getVehicleType()%>'] = {};
        types['<%=type.getKey().getVehicleType()%>'].id = <%=type.getKey().getId()%>
                types['<%=type.getKey().getVehicleType()%>'].subtypes = [];

        <%for (int index = 0; index < type.getValue().size(); index++) {%>
        types['<%=type.getKey().getVehicleType()%>'].subtypes.push({});
        types['<%=type.getKey().getVehicleType()%>'].subtypes[<%=index%>].id = <%=type.getValue().get(index).getId()%>;
        types['<%=type.getKey().getVehicleType()%>'].subtypes[<%=index%>].subtype = "<%=type.getValue().get(index).getSubtype()%>";
        <%}
    }
%>
    </script>
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

<div>
    <div class="shell">
        <h3>Добавяне на ново МПС</h3>
            <form action="/addNewMps" method="post">
            <%
                Insured insured = (Insured)request.getAttribute("result");
            %>
                <div class="form-section">
                    <h4>Данни за собственик</h4>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>ID</label>
                            <input type="text" class="field" name="insuredID" value=<%=insured.getId()%>>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>Име</label>
                            <input type="text" class="field" name="insuredFirstName" value=<%=insured.getFirstName()%> maxlength="50">
                            <label>Презиме</label></td>
                            <input type="text" class="field" id="secondName" name="insuredSecondName" value=<%=insured.getSecondName()%> size="50" maxlength="50">
                            <label>Фамилия</label></td>
                            <input type="text" class="field" name="insuredLastName" value=<%=insured.getLastName()%> size="30" maxlength="50">
                       </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>ЕГН</label>
                            <input type="number" class="field" id="EGN" name="EGN" value=<%=insured.getEgn()%> maxlength="10">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>Държава</label>
                            <input type="text" class="field" id="country" name="country" value=<%=insured.getCountry()%> maxlength="50">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label >Пощенски код</label>
                            <input type="text" class="field" name="pKod" value=<%=insured.getPostCode()%> size="20" maxlength="4">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>Град/Село</label>
                            <input type="text" class="field" id="city" name="city" value=<%=insured.getCity()%> maxlength="50">
                        </div>
                        <div class="form-row-inner">
                            <label>Адрес</label>
                            <input type="text" class="field" id="address" name="address" value=<%=insured.getAddress()%> maxlength="100">
                        </div>
                    </div>
                </div>
                <div class="form-section">
                    <h4>МПС</h4>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>Регистрационен №</label>
                            <input type="text" class="field" id="regNum" name="regNum" placeholder="Регистрационен №" maxlength="7">
                        </div>
                        <div class="form-row-inner">
                            <label>Град</label>
                            <input type="text" class="field" id="regCity" name="regCity" placeholder="Град">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>Зона</label>
                            <select class="field" id="zone" name="zone">
                                <option value=1>Зона І - София</option>
                                <option value=2>Зона IІ - Пловдив, Варна и Бургас</option>
                                <option value=3>Зона ІІІ - Други</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>РАМА</label>
                            <input type="text" class="field" id="rama" name="rama" placeholder="РАМА" maxlength="17">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>Тип</label>
                            <select class="field" class="field" id="vehicleType" name="vehicleType" onchange="onTypeSelect(this)"></select>
                        </div>
                        <div class="form-row-inner">
                            <label>Подтип</label>
                            <select id="vehicleSubtype" class="field" name="vehicleSubtype" ></select>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>Регистрация</label>
                            <select class="field" id="regCountry" name="country">
                                <option>България</option>
                                <option>Чужбина</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>Марка</label>
                            <input type="text" class="field"id="brand" name="brand" placeholder="Марка">
                        </div>
                        <div class="form-row-inner">
                            <label>Модел</label>
                            <input type="text" class="field" id="model" name="model" placeholder="Модел">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>Първа регистрация</label>
                            <input type="text" class="field" placeholder="Първа регистрация" id="datepicker1" name="firstReg">
                        </div>
                        <div class="form-row-inner">
                            <label>Години</label>
                            <input type="number" class="field" id="years" name="years" placeholder="Години">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>Двигател</label>
                            <select class="field" id="engine" name="engine">
                                <option>1.2</option>
                                <option>1.4</option>
                                <option>1.6</option>
                                <option>2.0</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>Цвят</label>
                            <input type="text" class="field" id="color" name="color" placeholder="Цвят">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-row-inner">
                            <label>Брой места</label>
                            <input type="number" class="field" id="placeNumber" name="placeNumber" placeholder="Брой места">
                        </div>
                    </div>
                </div>
            <input type="submit" value="Добави">
        </form>
    </div>
</div>
</body>
<script>
    // Fill main list
    var vehicleType =  document.getElementById('vehicleType');
    for(var property in types) {
        if (types.hasOwnProperty(property)) {
            var option = document.createElement('option');
            option.innerHTML = property;
            option.value = types[property].id;
            vehicleType.appendChild(option);
        }
    }

    var vehicleSubtype =  document.getElementById('vehicleSubtype');

    var fillSubTypes = function(type) {
        // Clear the list
        vehicleSubtype.options.length = 0;

        for(var property in types) {
            if (types.hasOwnProperty(property) && property === type) {
                for (var i in types[property].subtypes) {
                    var option = document.createElement('option');
                    option.innerHTML = types[property].subtypes[i].subtype;
                    option.value = types[property].subtypes[i].id;
                    vehicleSubtype.appendChild(option);
                }
                break;
            }
        }
    };

    var onTypeSelect = function(selectList) {
        fillSubTypes(selectList.options[selectList.selectedIndex].innerHTML);
    };

    // Init with first type
    fillSubTypes(Object.keys(types)[0]);
</script>
</html>