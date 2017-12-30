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
import java.util.ArrayList;
import java.util.List;

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

        VehicleSubtype vehicleSubtype = new VehicleSubtype();
        vehicleSubtype.setId(vehicleSubtypeID);

        TariffGO tariffGO = new TariffGO();
        tariffGO.setVehicleSubtype(vehicleSubtype);
        tariffGO.setZone(zone);

        TariffGoServer tariffServer = new TariffGoServer(tariffGO);
        List<TariffGO> result = new ArrayList<>();
        result.add(tariffServer.loadTariffGo());

        request.setAttribute("result", tariffServer.loadTariffGo());
        RequestDispatcher view = request.getRequestDispatcher("admin/addTariffGo.jsp");
        view.forward(request,response);
    }
}
