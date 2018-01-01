package kabilova.tu.inscorp.web.admin;

import kabilova.tu.inscorp.model.tariff.TariffGO;
import kabilova.tu.inscorp.model.tariff.TariffKasko;
import kabilova.tu.inscorp.model.vehicle.VehicleSubtype;
import kabilova.tu.inscorp.server.web.TariffGoServer;
import kabilova.tu.inscorp.server.web.TariffKaskoServer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

        VehicleSubtype vehicleSubtype = new VehicleSubtype();
        vehicleSubtype.setId(vehicleSubtypeID);

        TariffKasko tariffKasko = new TariffKasko();
        tariffKasko.setVehicleSubtype(vehicleSubtype);

        TariffKaskoServer tariffServer = new TariffKaskoServer(tariffKasko);

        System.out.println(tariffServer.loadTariffkasko().getTariffID());
        request.setAttribute("result", tariffServer.loadTariffkasko());
        RequestDispatcher view = request.getRequestDispatcher("admin/addTariffKasko.jsp");
        view.forward(request, response);
    }
}