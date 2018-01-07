package kabilova.tu.inscorp.web.insurer;

import kabilova.tu.inscorp.model.exception.InsCorpException;
import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscorp.model.vehicle.Vehicle;
import kabilova.tu.inscorp.server.web.InsuredServer;
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
@WebServlet("/changeOwner")
public class ChangeOwner extends HttpServlet {
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String regNum = request.getParameter("regNum");
        String egn = request.getParameter("egn");

        if(regNum.trim().equals("") || egn.trim().equals("")) {
            request.setAttribute("msg", "Моля, попълнете всички полета!");
            RequestDispatcher view = request.getRequestDispatcher("insurer/Msg.jsp");
            view.forward(request, response);
        } else {
            Insured insured = new Insured();
            insured.setEgn(egn);
            Vehicle vehicle = new Vehicle();
            vehicle.setRegNum(regNum);
            InsuredServer insuredServer = new InsuredServer(insured);
            try {
                insured.setId(insuredServer.loadByEgn().getId());

                vehicle.setInsured(insured);

                VehicleServer vehicleServer = new VehicleServer();
                vehicleServer.update();

                request.setAttribute("msg", "Успешен запис");
                RequestDispatcher view = request.getRequestDispatcher("insurer/Msg.jsp");
                view.forward(request, response);

            } catch (InsCorpException e) {
//                                String errorMsg = new String(e.getMessage().getBytes(), "UTF-8");
                request.setAttribute("errmsg", e.getMessage());
                RequestDispatcher view = request.getRequestDispatcher("insurer/Msg.jsp");
                view.forward(request, response);
            }
        }
    }
}