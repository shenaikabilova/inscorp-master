package kabilova.tu.inscorp.web.admin;

import kabilova.tu.inscorp.model.exception.InsCorpException;
import kabilova.tu.inscorp.model.tariff.TariffGO;
import kabilova.tu.inscorp.model.tariff.TariffKasko;
import kabilova.tu.inscorp.model.vehicle.VehicleSubtype;
import kabilova.tu.inscorp.server.web.TariffServer;
import kabilova.tu.inscorp.server.web.VehicleSubtypeServer;
import kabilova.tu.inscorp.model.vehicle.VehicleType;

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
@WebServlet("/adminPanelAddVehicleSubtype")
public class AddVehicleSubtype extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        int vehicleTypeID = Integer.parseInt(request.getParameter("vehicleType"));
        String newVehicleSubtype = request.getParameter("vehicleSubtype");

        if(vehicleTypeID==0 || newVehicleSubtype.trim().equals("")) {
            request.setAttribute("errmsg", "Моля, попълнете всички полета!");
            RequestDispatcher view = request.getRequestDispatcher("admin/AdminPanelMsg.jsp");
            view.forward(request, response);
        } else {
            VehicleType vehicleType = new VehicleType();
            vehicleType.setId(vehicleTypeID);
            VehicleSubtype vehicleSubtype = new VehicleSubtype();
            vehicleSubtype.setVehicleType(vehicleType);
            vehicleSubtype.setSubtype(newVehicleSubtype);

            VehicleSubtypeServer vehicleSubtypeServer = new VehicleSubtypeServer(vehicleSubtype);
            try {
                vehicleSubtypeServer.create();


            TariffGO tariffGO = new TariffGO();
            tariffGO.setVechileType(vehicleType);
            tariffGO.setVehicleSubtype(vehicleSubtype);
            TariffServer tariffGoServer = new TariffServer(tariffGO);
            for (int i = 1; i <= 3; i++) {
                tariffGO.setZone(i);
                try {
                    tariffGoServer.create();
                } catch (InsCorpException e) {
                    request.setAttribute("errmsg", e.getMessage());
                    RequestDispatcher view = request.getRequestDispatcher("admin/AdminPanelMsg.jsp");
                    view.forward(request, response);
                }
            }

            TariffKasko tariffKasko = new TariffKasko();
            tariffKasko.setVechileType(vehicleType);
            tariffKasko.setVehicleSubtype(vehicleSubtype);
            TariffServer tariffKaskoServer = new TariffServer(tariffKasko);
            try {
                tariffKaskoServer.create();
            } catch (InsCorpException e) {
                request.setAttribute("errmsg", e.getMessage());
                RequestDispatcher view = request.getRequestDispatcher("admin/AdminPanelMsg.jsp");
                view.forward(request, response);
            }

            request.setAttribute("errmsg", "Успешен запис!");
            RequestDispatcher view = request.getRequestDispatcher("admin/AdminPanelMsg.jsp");
            view.forward(request, response);

            } catch (InsCorpException e) {
                request.setAttribute("errmsg", e.getMessage());
                RequestDispatcher view = request.getRequestDispatcher("admin/AdminPanelMsg.jsp");
                view.forward(request, response);
            }
        }
    }
}
