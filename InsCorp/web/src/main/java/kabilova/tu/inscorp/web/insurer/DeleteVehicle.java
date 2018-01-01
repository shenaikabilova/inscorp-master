package kabilova.tu.inscorp.web.insurer;

import kabilova.tu.inscorp.model.vehicle.Vehicle;
import kabilova.tu.inscorp.server.web.VehicleServer;

import javax.servlet.RequestDispatcher;
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
@WebServlet("/deleteVehicle")
public class DeleteVehicle extends HttpServlet {
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String regNum = request.getParameter("regNum");
        Vehicle vehicle = new Vehicle();
        vehicle.setRegNum(regNum);
        VehicleServer vehicleServer = new VehicleServer(vehicle);
        vehicle.setVehicleID(vehicleServer.loadVehicle().getVehicleID());
        vehicleServer.delete();

        request.setAttribute("msg", "Успешно изтриване");
        RequestDispatcher view = request.getRequestDispatcher("insurer/Msg.jsp");
        view.forward(request, response);
    }
}