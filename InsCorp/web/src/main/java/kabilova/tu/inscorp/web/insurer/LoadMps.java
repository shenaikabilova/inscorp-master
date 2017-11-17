package kabilova.tu.inscorp.web.insurer;

import kabilova.tu.inscorp.model.vehicle.Vehicle;
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

        VehicleServer vehicleServer = new VehicleServer();
        List<Vehicle> result = new ArrayList<>();
        result.add(vehicleServer.loadVehicle());

        request.setAttribute("result", result);
        RequestDispatcher rd = null;
        if(request.getServletPath().equals("/loadMpsGO")) {
            rd = getServletContext().getRequestDispatcher("/insurer/insurerAddNewGO.jsp");
        } else if(request.getServletPath().equals("/loadMpsKasko")) {
            rd = getServletContext().getRequestDispatcher("/insurer/insurerAddNewKasko.jsp");
        }
        rd.forward(request, response);
    }
}
