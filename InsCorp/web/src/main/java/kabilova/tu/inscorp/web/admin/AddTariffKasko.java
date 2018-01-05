package kabilova.tu.inscorp.web.admin;

import kabilova.tu.inscorp.model.tariff.TariffKasko;
import kabilova.tu.inscorp.model.vehicle.VehicleSubtype;
import kabilova.tu.inscorp.server.web.TariffServer;
import kabilova.tu.inscorp.model.vehicle.VehicleType;

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
@WebServlet("/addTariffKasko")
public class AddTariffKasko extends HttpServlet {
    public void init (ServletConfig config)throws ServletException {
        super.init(config);
    }

    protected void doPost (HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("tariffID"));
        int vehicleTypeID = Integer.parseInt(request.getParameter("vehicleType"));
        int vehicleSubtypeID = Integer.parseInt(request.getParameter("vehicleSubtype"));
        int kaskoPercent = Integer.parseInt(request.getParameter("kaskoPercent"));

        if(id==0 || vehicleTypeID==0 || vehicleSubtypeID==0 || kaskoPercent==0) {
            request.setAttribute("errmsg", "Моля, попълнете всички полета!");
            RequestDispatcher view = request.getRequestDispatcher("admin/AdminPanelMsg.jsp");
            view.forward(request, response);
        } else {
            VehicleType vehicleType = new VehicleType();
            vehicleType.setId(vehicleTypeID);
            VehicleSubtype vehicleSubtype = new VehicleSubtype();
            vehicleSubtype.setId(vehicleSubtypeID);

            TariffServer tariffServer = new TariffServer(new TariffKasko(id, vehicleType, vehicleSubtype, kaskoPercent));
            tariffServer.update();

            request.setAttribute("errmsg", "Успешен запис!");
            RequestDispatcher view = request.getRequestDispatcher("admin/AdminPanelMsg.jsp");
            view.forward(request, response);
        }
    }
}