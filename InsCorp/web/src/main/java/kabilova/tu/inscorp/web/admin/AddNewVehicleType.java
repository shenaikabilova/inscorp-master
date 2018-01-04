package kabilova.tu.inscorp.web.admin;

import exception.InsCorpException;
import kabilova.tu.inscorp.model.vehicle.VehicleType;
import kabilova.tu.inscorp.server.web.VehicleTypeServer;

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
@WebServlet("/adminPanelAddVehicleType")
public class AddNewVehicleType extends HttpServlet {
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String vehicleType = request.getParameter("vehicleType");

        if(vehicleType.trim().equals("")){
            request.setAttribute("errmsg", "Моля, попълнете всички полета!");
            RequestDispatcher view = request.getRequestDispatcher("admin/AdminPanelMsg.jsp");
            view.forward(request, response);
        } else {
            VehicleTypeServer vehicleTypeServer = new VehicleTypeServer(new VehicleType(vehicleType));
            try {
                vehicleTypeServer.create();

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