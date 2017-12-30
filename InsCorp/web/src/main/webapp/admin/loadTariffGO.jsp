<%@ page import="kabilova.tu.inscorp.server.web.VehicleSubtypeServer" %>
<%@ page import="kabilova.tu.inscorp.model.vehicle.VehicleSubtype" %>
<%@ page import="kabilova.tu.inscorp.model.vehicle.VehicleType" %>
<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: AcerPC
  Date: 14.12.2017 г.
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String username = null;
        String password = null;
        if(!request.getSession().isNew()) {
            username = session.getAttribute("username").toString();
            password = session.getAttribute("password").toString();
        }
        else {
            response.sendRedirect("/AdminLogin");
        }
    %>
    <title><%=username %></title>
    <link href = "../style.css" type="text/css" rel = "stylesheet"/>
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
   <ul class="menu-nav">
       <li><a href="#">Застрахователни агенти</a>
           <ul>
               <li><a href="/adminPanelAddInsurer.jsp">Добави</a></li>
               <li><a href="admin/adminPanelInsurers.jsp">Изведи</a></li>
               <li><a href="admin/adminPanelSearchUser.jsp">Промени</a></li>
               <li><a href="admin/adminPanelDeleteUser.jsp">Изтрий</a></li>
           </ul>
       </li>
       <li><a href="#">МПС</a>
           <ul>
               <li><a href="admin/adminPanelAddVehicleType.jsp">Добави тип МПС</a></li>
               <li><a href="admin/adminPanelAddVehicleSubtype.jsp">Добави подтип МПС</a></li>
           </ul>
       </li>
       <li><a href="#">Тарифиране</a>
           <ul>
               <li><a href="#">ГО</a>
                   <ul>
                       <li><a href="admin/loadTariffGO.jsp">Добави тарифа ГО</a></li>
                       <li><a href="admin/viewTariffGo.jsp">Изведи тарифиране</a></li>
                   </ul>
               </li>
               <li><a href="tariffKasko.jsp">Каско</a>
                   <ul>
                       <li><a href="admin/addTariffKasko.jsp">Добави тарифа Каско</a></li>
                       <li><a href="admin/viewTariffKasko.jsp">Изведи тарифиране</a></li>
                   </ul>
               </li>
           </ul>
       </li>
       <li><a href="adminPanelSettings.jsp">Настройки</a></li>
       <li><a href="AdminLogout">Изход</a></li>
   </ul>
</div>

<div>
   <div class="shell">
       <form action="/loadTariffGO" method="post">
           <select class="field" id="vehicleType" name="vehicleType" onchange="onTypeSelect(this)"></select>
           <select id="vehicleSubtype" class="field" name="vehicleSubtype" ></select>
           <select class="field" id="zone" name="zone">
                <option value=1>Зона 1</option>
                <option value=2>Зона 2</option>
                <option value=3>Зона 3</option>
            </select>

        <input type="submit" value="Зареди тарифа">
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
