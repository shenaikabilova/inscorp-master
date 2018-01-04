package kabilova.tu.inscorp.web.admin;

import kabilova.tu.inscorp.model.vehicle.Vehicle;
import kabilova.tu.inscorp.model.vehicle.VehicleSubtype;
import kabilova.tu.inscorp.model.vehicle.VehicleType;
import kabilova.tu.inscorp.server.web.VehicleServer;
import kabilova.tu.inscorp.server.web.VehicleSubtypeServer;

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
@WebServlet(urlPatterns = {"/vehicleSubtypeUpdate", "/vehicleSubtypeDelete"})
public class VehicleSubtypeUpdDel extends HttpServlet{
    public void init() throws ServletException {
        super.init();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        Integer id = Integer.parseInt(request.getParameter("vehicleSubtype"));
        Integer typeID = Integer.parseInt(request.getParameter("vehicleType"));

        if(id==0 || typeID==0) {
            request.setAttribute("errmsg", "Моля, попълнете всички полета!");
            RequestDispatcher view = request.getRequestDispatcher("admin/AdminPanelMsg.jsp");
            view.forward(request, response);
        } else {
            VehicleSubtype vehicleSubtype = new VehicleSubtype();
            VehicleType vehicleType = new VehicleType();
            vehicleType.setId(typeID);
            vehicleSubtype.setId(id);
            vehicleSubtype.setVehicleType(vehicleType);

            VehicleSubtypeServer vehicleTypeServer = new VehicleSubtypeServer(vehicleSubtype);
            VehicleServer vehicleServer = new VehicleServer(new Vehicle());

            if (request.getServletPath().equals("/vehicleSubtypeUpdate")) {
                String newVehicleSubtype = request.getParameter("newVehicleSubtype");
                vehicleSubtype.setSubtype(newVehicleSubtype);

                vehicleTypeServer.update();

                request.setAttribute("errmsg", "Успешен запис!");
                RequestDispatcher view = request.getRequestDispatcher("admin/AdminPanelMsg.jsp");
                view.forward(request, response);
            } else if (request.getServletPath().equals("/vehicleSubtypeDelete")) {
                boolean canDelete = true;

                for (Vehicle v : vehicleServer.read()) {
                    if (v.getVehicleType().getId() == id) {
                        canDelete = false;
                    }
                }

                if (canDelete) {
                    vehicleTypeServer.delete();
                    request.setAttribute("errmsg", "Успешен запис!");
                    RequestDispatcher view = request.getRequestDispatcher("admin/AdminPanelMsg.jsp");
                    view.forward(request, response);
                } else {
                    request.setAttribute("errmsg", "Невъзможно изтриване на подтип МПС, по които има въведени МПС!");
                    RequestDispatcher view = request.getRequestDispatcher("admin/AdminPanelMsg.jsp");
                    view.forward(request, response);
                }
            }
        }
    }
}
