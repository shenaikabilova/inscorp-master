package kabilova.tu.inscorp.web.admin;

import kabilova.tu.inscorp.model.vehicle.VehicleType;
import kabilova.tu.inscorp.server.web.VehicleTypeServer;

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
@WebServlet(urlPatterns = {"/vehicleTypeUpdate", "/vehicleTypeDelete"})
public class VehicleTypeUpDel extends HttpServlet {
    public void init() throws ServletException {
        super.init();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        Integer id = Integer.parseInt(request.getParameter("vehicleType"));
        VehicleType vehicleType = new kabilova.tu.inscorp.model.vehicle.VehicleType();
        vehicleType.setId(id);

        VehicleTypeServer vehicleTypeServer = new VehicleTypeServer(vehicleType);

        if(request.getServletPath().equals("/vehicleTypeUpdate")){
            String newVehicleType = request.getParameter("newVehicleType");
            vehicleType.setVehicleType(newVehicleType);

            vehicleTypeServer.update();

            request.setAttribute("errmsg", "Успешен запис!");
            RequestDispatcher view = request.getRequestDispatcher("admin/AdminPanelMsg.jsp");
            view.forward(request,response);
        } else if(request.getServletPath().equals("/vehicleTypeDelete")){
            vehicleTypeServer.delete();
            request.setAttribute("errmsg", "Успешен запис!");
            RequestDispatcher view = request.getRequestDispatcher("admin/AdminPanelMsg.jsp");
            view.forward(request,response);
        }
    }
}