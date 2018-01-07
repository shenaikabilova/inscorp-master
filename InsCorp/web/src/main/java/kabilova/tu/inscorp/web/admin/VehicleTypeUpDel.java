package kabilova.tu.inscorp.web.admin;

import kabilova.tu.inscorp.model.exception.InsCorpException;
import kabilova.tu.inscorp.server.web.VehicleTypeServer;
import kabilova.tu.inscorp.model.vehicle.Vehicle;
import kabilova.tu.inscorp.model.vehicle.VehicleType;
import kabilova.tu.inscorp.server.web.VehicleServer;

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

        if(id==0) {
            request.setAttribute("errmsg", "Моля, попълнете всички полета!");
            RequestDispatcher view = request.getRequestDispatcher("admin/AdminPanelMsg.jsp");
            view.forward(request, response);
        } else {
            VehicleType vehicleType = new VehicleType();
            vehicleType.setId(id);

            VehicleTypeServer vehicleTypeServer = new VehicleTypeServer(vehicleType);
            VehicleServer vehicleServer = new VehicleServer(new Vehicle());

            if (request.getServletPath().equals("/vehicleTypeUpdate")) {
                String newVehicleType = request.getParameter("newVehicleType");
                vehicleType.setVehicleType(newVehicleType);

                vehicleTypeServer.update();

                request.setAttribute("errmsg", "Успешен запис!");
                RequestDispatcher view = request.getRequestDispatcher("admin/AdminPanelMsg.jsp");
                view.forward(request, response);
            } else if (request.getServletPath().equals("/vehicleTypeDelete")) {
                boolean canDelete = true;

                for (Vehicle v : vehicleServer.read()) {
                    if (v.getVehicleType().getId() == id) {
                        canDelete = false;
                    }
                }

                if (canDelete) {
                    try {
                        vehicleTypeServer.delete();
                    } catch (InsCorpException e) {
                        String errorMsg = new String(e.getMessage().getBytes(), "UTF-8");
                        request.setAttribute("msg", errorMsg);
                        RequestDispatcher view = request.getRequestDispatcher("admin/AdminPanelMsg.jsp");
                        view.forward(request, response);
                    }

                    request.setAttribute("errmsg", "Успешен запис!");
                    RequestDispatcher view = request.getRequestDispatcher("admin/AdminPanelMsg.jsp");
                    view.forward(request, response);
                } else {
                    request.setAttribute("errmsg", "Невъзможно изтриване на тип МПС, по които има въведени МПС!");
                    RequestDispatcher view = request.getRequestDispatcher("admin/AdminPanelMsg.jsp");
                    view.forward(request, response);
                }
            }
        }
    }
}