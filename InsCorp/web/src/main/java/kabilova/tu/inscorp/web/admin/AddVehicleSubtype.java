package kabilova.tu.inscorp.web.admin;

import kabilova.tu.inscorp.model.vehicle.VehicleSubtype;
import kabilova.tu.inscorp.model.vehicle.VehicleType;
import kabilova.tu.inscorp.server.web.VehicleSubtypeServer;

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
        String vehicleSubtype = request.getParameter("vehicleSubtype");

        System.out.print(vehicleTypeID);

        VehicleType vehicleType = new VehicleType();
        vehicleType.setId(vehicleTypeID);
        VehicleSubtype vehicleSubtypeO = new VehicleSubtype();
        vehicleSubtypeO.setVehicleType(vehicleType);
        vehicleSubtypeO.setSubtype(vehicleSubtype);

        VehicleSubtypeServer vehicleSubtypeServer = new VehicleSubtypeServer(vehicleSubtypeO);
        vehicleSubtypeServer.create();
    }
}
