<%@ page import="kabilova.tu.inscorp.server.web.VehicleSubtypeServer" %>
<%@ page import="kabilova.tu.inscorp.model.vehicle.VehicleType" %>
<%@ page import="kabilova.tu.inscorp.model.vehicle.VehicleSubtype" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="kabilova.tu.inscorp.model.user.Insured" %>
<%@ page import="kabilova.tu.inscorp.model.vehicle.Vehicle" %><%--
  Created by IntelliJ IDEA.
  User: AcerPC
  Date: 28.12.2017 г.
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            response.sendRedirect("login.jsp");
        }
    %>
    <title><%=username %></title>
    <link href = "../style.css" type="text/css" rel = "stylesheet"/>

    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
    <link rel="stylesheet" href="/resources/demos/style.css">
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
                    <li><a href="addNewInsured.jsp">Добави</a></li>
                    <li><a href="loadInsuredForUpdate.jsp">Промени</a></li>
                    <li><a href="deleteInsured.jsp">Изтрий</a></li>
                    <li><a href="loadAllClients.jsp">Изведи всички</a></li>
                </ul>
            </li>
            <li><a href="#">МПС</a>
                <ul>
                    <li><a href="loadClient.jsp">Добави</a></li>
                    <li><a href="loadVehicle.jsp">Промени</a></li>
                    <li><a href="deleteVehicle.jsp">Изтрий</a></li>
                    <li><a href="loadAllVehicles.jsp">Изведи всички</a></li>
                </ul>
            </li>
            <li><a href="#">Нова застраховка</a>
                <ul>
                    <li><a href="loadMpsGO.jsp">Гражданска отговорност</a></li>
                    <li><a href="loadMpsKasko.jsp">Каско</a></li>
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
                            <li><a href="searchKaskoAll.jsp">Изведи всички</a></li>
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
<form action="/addNewMps" method="post">
    <%
        Vehicle vehicle = (Vehicle) request.getAttribute("result");
    %>
    Данни за собственик

    <label>ID</label>
    <input type="text" class="field" name="insuredID" value=<%=vehicle.getInsured().getId()%>>
    <label>Име</label>
    <input type="text" class="field" name="insuredFirstName" value=<%=vehicle.getInsured().getFirstName()%> maxlength="50">

    <label>Презиме</label></td>
    <input type="text" id="secondName" name="insuredSecondName" value=<%=vehicle.getInsured().getSecondName()%> size="50" maxlength="50">

    <label>Фамилия</label></td>
    <input type="text" class="field" name="insuredLastName" value=<%=vehicle.getInsured().getLastName()%> size="30" maxlength="50">


    <label>ЕГН</label>
    <input type="number" id="EGN" name="EGN" value=<%=vehicle.getInsured().getEgn()%> maxlength="10">
    <label>Държава</label>
    <input type="text" id="country" name="country" value=<%=vehicle.getInsured().getCountry()%> maxlength="50"><br>
    <label >Пощенски код</label>
    <input type="text" class="field" name="pKod" value=<%=vehicle.getInsured().getPostCode()%> size="20" maxlength="4">

    <label>Град/Село</label>
    <input type="text" id="city" name="city" value=<%=vehicle.getInsured().getCity()%> maxlength="50">
    <label>Адрес</label>
    <input type="text" id="address" name="address" value=<%=vehicle.getInsured().getAddress()%> maxlength="100">

    МПС
    <label>Регистрационен №</label>
    <input type="text" id="regNum" name="regNum" placeholder="Регистрационен №" maxlength="7">
    <label>Регистрирана в Град</label>
    <input type="text" id="regCity" name="regCity" placeholder="Град">
    <label>Зона</label>
    <select class="field" id="zone" name="zone">
        <option value=1>Зона 1</option>
        <option value=2>Зона 2</option>
        <option value=3>Зона 3</option>
    </select>
    <label>РАМА</label>
    <input type="text" id="rama" name="rama" placeholder="РАМА" maxlength="17">

    <label>Тип</label>
    <select class="field" id="vehicleType" name="vehicleType" onchange="onTypeSelect(this)"></select>
    <label>Подтип</label>
    <select id="vehicleSubtype" class="field" name="vehicleSubtype" ></select>

    <label>Регистрация</label>
    <select name="country">
        <option>България</option>
        <option>Чужбина</option>
    </select> <br>

    <br>
    <label>Марка</label>
    <input type="text" id="brand" name="brand" placeholder="Марка">
    <label>Модел</label>
    <input type="text" id="model" name="model" placeholder="Модел">

    <label>Първа регистрация</label>
    <input type="text" placeholder="Първа регистрация" id="datepicker1" name="firstReg">
    <label>Години</label>
    <input type="number" id="years" name="years" placeholder="Години">
    <br>

    <label>Двигател</label>
    <select id="engine" name="engine">
        <option>1.2</option>
        <option>1.4</option>
        <option>1.6</option>
    </select>
    <label>Цвят</label>
    <%--TODO color--%>
    <label>Брой места</label>
    <input type="number" id="placeNumber" name="placeNumber" placeholder="Брой места">
    <br>

    <input type="submit" value="Добави">
</form>
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