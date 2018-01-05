package kabilova.tu.inscorp.web.admin;

import kabilova.tu.inscorp.model.tariff.TariffGO;
import kabilova.tu.inscorp.model.vehicle.VehicleSubtype;
import kabilova.tu.inscorp.server.web.TariffGoServer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ShenaiKabilova
 */
@WebServlet("/loadTariffGO")
public class LoadTariffGO extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int vehicleSubtypeID = Integer.parseInt(request.getParameter("vehicleSubtype"));
        int zone = Integer.parseInt(request.getParameter("zone"));

        if(vehicleSubtypeID==0 || zone==0) {
            request.setAttribute("errmsg", "Моля, попълнете всички полета!");
            RequestDispatcher view = request.getRequestDispatcher("admin/AdminPanelMsg.jsp");
            view.forward(request, response);
        } else {
            VehicleSubtype vehicleSubtype = new VehicleSubtype();
            vehicleSubtype.setId(vehicleSubtypeID);

            TariffGO tariffGO = new TariffGO();
            tariffGO.setVehicleSubtype(vehicleSubtype);
            tariffGO.setZone(zone);

            TariffGoServer tariffServer = new TariffGoServer(tariffGO);

            request.setAttribute("result", tariffServer.loadTariffGo());
            RequestDispatcher view = request.getRequestDispatcher("admin/addTariffGo.jsp");
            view.forward(request, response);
        }
    }
}
