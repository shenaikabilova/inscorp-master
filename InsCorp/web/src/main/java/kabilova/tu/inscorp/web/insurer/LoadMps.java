package kabilova.tu.inscorp.web.insurer;

import kabilova.tu.inscorp.model.tariff.Tariff;
import kabilova.tu.inscorp.model.tariff.TariffGO;
import kabilova.tu.inscorp.model.tariff.TariffKasko;
import kabilova.tu.inscorp.model.vehicle.Vehicle;
import kabilova.tu.inscorp.model.vehicle.VehicleSubtype;
import kabilova.tu.inscorp.server.web.TariffGoServer;
import kabilova.tu.inscorp.server.web.TariffKaskoServer;
import kabilova.tu.inscorp.server.web.TariffServer;
import kabilova.tu.inscorp.server.web.VehicleServer;

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
@WebServlet(urlPatterns = {"/loadMpsGO", "/loadMpsKasko"})
public class LoadMps extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vehicleReg = request.getParameter("searchVehicleRegNum");
        Vehicle vehicle = new Vehicle();
        vehicle.setRegNum(vehicleReg);

        VehicleServer vehicleServer = new VehicleServer(vehicle);

        request.setAttribute("result", vehicleServer.loadVehicle());
        RequestDispatcher rd = null;
        if(request.getServletPath().equals("/loadMpsGO")) {
            TariffGO tariffGO = new TariffGO();
            tariffGO.setVehicleSubtype(vehicleServer.loadVehicle().getVehicleSubtype());
            tariffGO.setZone(vehicleServer.loadVehicle().getZone());
            TariffGoServer tariffGoServer = new TariffGoServer(tariffGO);

            request.setAttribute("tariff", tariffGoServer.loadTariffGo());
            rd = getServletContext().getRequestDispatcher("/insurer/insurerAddNewGO.jsp");
        } else if(request.getServletPath().equals("/loadMpsKasko")) {
            TariffKasko tariffKasko = new TariffKasko();
            tariffKasko.setVehicleSubtype(vehicle.getVehicleSubtype());
            TariffKaskoServer tariffKaskoServer = new TariffKaskoServer(tariffKasko);

            request.setAttribute("tariff", tariffKaskoServer.loadTariffkasko());
            rd = getServletContext().getRequestDispatcher("/insurer/insurerAddNewKasko.jsp");
        }
        rd.forward(request, response);
    }
}
