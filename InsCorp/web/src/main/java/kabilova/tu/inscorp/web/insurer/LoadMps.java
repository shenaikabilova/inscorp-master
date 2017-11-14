package kabilova.tu.inscorp.web.insurer;

import kabilova.tu.inscorp.model.vehicle.Vehicle;
import kabilova.tu.inscorp.server.web.VehicleServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ShenaiKabilova
 */
@WebServlet("/loadMps")
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

        VehicleServer vehicleServer = new VehicleServer();
    }
}
