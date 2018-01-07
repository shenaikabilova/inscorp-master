package kabilova.tu.inscorp.web.insurer;

import kabilova.tu.inscorp.bl.user.PolicyEP;
import kabilova.tu.inscorp.daoimpl.hb.PolicyDaoImpl;
import kabilova.tu.inscorp.model.policy.GO;
import kabilova.tu.inscorp.model.policy.Kasko;
import kabilova.tu.inscorp.model.tariff.TariffGO;
import kabilova.tu.inscorp.server.web.TariffKaskoServer;
import kabilova.tu.inscorp.model.tariff.TariffKasko;
import kabilova.tu.inscorp.model.vehicle.Vehicle;
import kabilova.tu.inscorp.server.web.TariffGoServer;
import kabilova.tu.inscorp.server.web.VehicleServer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

/**
 * Created by ShenaiKabilova
 */
@WebServlet(urlPatterns = {"/loadMpsGO", "/loadMpsKasko"})
public class LoadMps extends HttpServlet {
    public void init() throws ServletException {
        super.init();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String vehicleReg = request.getParameter("searchVehicleRegNum");
        if(vehicleReg.trim().equals("")) {
            request.setAttribute("msg", "Моля, попълнете всички полета!");
            RequestDispatcher view = request.getRequestDispatcher("insurer/Msg.jsp");
            view.forward(request, response);
        } else {
            Vehicle vehicle = new Vehicle();
            vehicle.setRegNum(vehicleReg);

            VehicleServer vehicleServer = new VehicleServer(vehicle);
            PolicyEP policyEP = new PolicyEP(new PolicyDaoImpl());
            request.setAttribute("result", vehicleServer.loadVehicle());
            if (request.getServletPath().equals("/loadMpsGO")) {
                for(GO go : policyEP.loadActivePoliciesGO(vehicleServer.loadVehicle().getInsured(), Calendar.getInstance())){
                    if(go.getVehicle().getRegNum().equals(vehicleReg)){
                        request.setAttribute("msg", "Има сключена полица ГО за това моторно превозно средство!");
                        RequestDispatcher view = request.getRequestDispatcher("insurer/Msg.jsp");
                        view.forward(request, response);
                    }
                }
                TariffGO tariffGO = new TariffGO();
                tariffGO.setVehicleSubtype(vehicleServer.loadVehicle().getVehicleSubtype());
                tariffGO.setZone(vehicleServer.loadVehicle().getZone());
                TariffGoServer tariffGoServer = new TariffGoServer(tariffGO);

                request.setAttribute("tariff", tariffGoServer.loadTariffGo());
                RequestDispatcher rd = request.getRequestDispatcher("insurer/insurerAddNewGO.jsp");
                rd.forward(request, response);
            } else if (request.getServletPath().equals("/loadMpsKasko")) {
                for(Kasko kasko : policyEP.loadActivePoliciesKasko(vehicleServer.loadVehicle().getInsured(), Calendar.getInstance())){
                    if(kasko.getVehicle().getRegNum().equals(vehicleReg)){
                        request.setAttribute("msg", "Има сключена полица Каско за това моторно превозно средство!");
                        RequestDispatcher view = request.getRequestDispatcher("insurer/Msg.jsp");
                        view.forward(request, response);
                    }
                }
                TariffKasko tariffKasko = new TariffKasko();
                tariffKasko.setVehicleSubtype(vehicleServer.loadVehicle().getVehicleSubtype());
                TariffKaskoServer tariffKaskoServer = new TariffKaskoServer(tariffKasko);

                request.setAttribute("tariff", tariffKaskoServer.loadTariffkasko());
                RequestDispatcher rd = request.getRequestDispatcher("insurer/insurerAddNewKasko.jsp");
                rd.forward(request, response);
            }

        }
    }
}