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
    public void init() throws ServletException {
        super.init();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String vehicleReg = request.getParameter("searchVehicleRegNum");
        if(vehicleReg.trim().equals("")) {
            request.setAttribute("msg", "Моля, попълнете всички полета!");
            RequestDispatcher view = request.getRequestDispatcher("insurer/Msg.jsp");
            view.forward(request, response);
        } else {
            Vehicle vehicle = new Vehicle();
            vehicle.setRegNum(vehicleReg);

            VehicleServer vehicleServer = new VehicleServer(vehicle);

            request.setAttribute("result", vehicleServer.loadVehicle());
//             rd = null;
            if (request.getServletPath().equals("/loadMpsGO")) {
                TariffGO tariffGO = new TariffGO();
                tariffGO.setVehicleSubtype(vehicleServer.loadVehicle().getVehicleSubtype());
                tariffGO.setZone(vehicleServer.loadVehicle().getZone());
                TariffGoServer tariffGoServer = new TariffGoServer(tariffGO);

                request.setAttribute("tariff", tariffGoServer.loadTariffGo());
                RequestDispatcher rd = request.getRequestDispatcher("insurer/insurerAddNewGO.jsp");
                rd.forward(request, response);
            } else if (request.getServletPath().equals("/loadMpsKasko")) {
                TariffKasko tariffKasko = new TariffKasko();
                tariffKasko.setVehicleSubtype(vehicleServer.loadVehicle().getVehicleSubtype());
                TariffKaskoServer tariffKaskoServer = new TariffKaskoServer(tariffKasko);

                request.setAttribute("tariff", tariffKaskoServer.loadTariffkasko());
                RequestDispatcher rd = request.getRequestDispatcher("insurer/insurerAddNewKasko.jsp");
                rd.forward(request, response);
            }

        }
    }
}
