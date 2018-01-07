package kabilova.tu.inscorp.web.admin;

import kabilova.tu.inscorp.model.tariff.TariffGO;
import kabilova.tu.inscorp.model.vehicle.VehicleSubtype;
import kabilova.tu.inscorp.model.vehicle.VehicleType;
import kabilova.tu.inscorp.server.web.TariffServer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ShenaiKabilova
 */
@WebServlet("/addTariffGO")
public class AddTariffGO extends HttpServlet {
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("tariffID"));
        int vehicleTypeID = Integer.parseInt(request.getParameter("vehicleType"));
        int vehicleSubtypeID = Integer.parseInt(request.getParameter("vehicleSubtype"));
        System.out.println(request.getParameter("zone"));
        int zone = Integer.parseInt(request.getParameter("zone"));
        double value = Double.parseDouble(request.getParameter("value"));

        if(id==0 || vehicleTypeID==0 || vehicleSubtypeID==0 || zone==0 || value==0) {
            request.setAttribute("errmsg", "Моля, попълнете всички полета!");
            RequestDispatcher view = request.getRequestDispatcher("admin/AdminPanelMsg.jsp");
            view.forward(request, response);
        } else {
            VehicleType vehicleType = new VehicleType();
            vehicleType.setId(vehicleTypeID);
            VehicleSubtype vehicleSubtype = new VehicleSubtype();
            vehicleSubtype.setId(vehicleSubtypeID);

            TariffServer tariffServer = new TariffServer(new TariffGO(id, vehicleType, vehicleSubtype, zone, value));
            tariffServer.update();

            request.setAttribute("errmsg", "Успешен запис!");
            RequestDispatcher view = request.getRequestDispatcher("admin/AdminPanelMsg.jsp");
            view.forward(request, response);
        }
    }
}
