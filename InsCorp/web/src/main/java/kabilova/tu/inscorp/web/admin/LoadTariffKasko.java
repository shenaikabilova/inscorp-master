package kabilova.tu.inscorp.web.admin;

import kabilova.tu.inscorp.model.tariff.TariffKasko;
import kabilova.tu.inscorp.model.vehicle.VehicleSubtype;
import kabilova.tu.inscorp.server.web.TariffKaskoServer;

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
@WebServlet("/loadTariffKasko")
public class LoadTariffKasko extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int vehicleSubtypeID = Integer.parseInt(request.getParameter("vehicleSubtype"));

        if(vehicleSubtypeID==0){
            request.setAttribute("errmsg", "Моля, попълнете всички полета!");
            RequestDispatcher view = request.getRequestDispatcher("admin/AdminPanelMsg.jsp");
            view.forward(request, response);
        } else {
            VehicleSubtype vehicleSubtype = new VehicleSubtype();
            vehicleSubtype.setId(vehicleSubtypeID);

            TariffKasko tariffKasko = new TariffKasko();
            tariffKasko.setVehicleSubtype(vehicleSubtype);

            TariffKaskoServer tariffServer = new TariffKaskoServer(tariffKasko);

            request.setAttribute("result", tariffServer.loadTariffkasko());
            RequestDispatcher view = request.getRequestDispatcher("admin/addTariffKasko.jsp");
            view.forward(request, response);
        }
    }
}