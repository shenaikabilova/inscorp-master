package kabilova.tu.inscorp.web.admin;

import kabilova.tu.inscorp.model.vehicle.VehicleType;
import kabilova.tu.inscorp.server.web.VehicleTypeServer;

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
@WebServlet("/adminPanelAddVehicleType")
public class AddNewVehicleType extends HttpServlet {
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String vehicleType = request.getParameter("vehicleType");

        VehicleTypeServer vehicleTypeServer = new VehicleTypeServer(new VehicleType(vehicleType));
        vehicleTypeServer.create();
    }
}