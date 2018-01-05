package kabilova.tu.inscorp.web.insurer;

import kabilova.tu.inscorp.model.exception.InsCorpException;
import kabilova.tu.inscorp.model.policy.GO;
import kabilova.tu.inscorp.model.tariff.TariffGO;
import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscorp.server.web.PolicyServer;
import kabilova.tu.inscorp.model.user.Insurer;
import kabilova.tu.inscorp.model.vehicle.Vehicle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by ShenaiKabilova
 */
@WebServlet("/addNewGO")
public class AddNewGO extends HttpServlet {
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String policaID = request.getParameter("policaN");
        int insurerID = Integer.parseInt(request.getParameter("insID"));
        int insuredID = Integer.parseInt(request.getParameter("insuredID"));
        int vehicleID = Integer.parseInt(request.getParameter("vehicleID"));

        if(policaID.trim().equals("") || insuredID==0 || insurerID==0 || vehicleID==0) {
            request.setAttribute("msg", "Моля, попълнете всички полета!");
            RequestDispatcher view = request.getRequestDispatcher("insurer/Msg.jsp");
            view.forward(request, response);
        } else {
            String strFromDate = request.getParameter("fromDate");
            String strToDate = request.getParameter("toDate");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Calendar calendarFromDate = Calendar.getInstance();
            Calendar calendarToDate = Calendar.getInstance();
            try {
                calendarFromDate.setTime(simpleDateFormat.parse(strFromDate));
                calendarToDate.setTime(simpleDateFormat.parse(strToDate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println(calendarFromDate.getTime());

            int tariffID = Integer.parseInt(request.getParameter("tariffID"));
            int period = Integer.parseInt(request.getParameter("period"));
            double value = Double.parseDouble(request.getParameter("value"));

            Insurer insurer = new Insurer();
            Insured insured = new Insured();
            Vehicle vehicle = new Vehicle();
            TariffGO tariff = new TariffGO();
            insurer.setId(insurerID);
            insured.setId(insuredID);
            vehicle.setVehicleID(vehicleID);
            tariff.setTariffID(tariffID);

            PolicyServer policyGOServer = new PolicyServer(new GO(policaID, calendarFromDate, calendarToDate, insurer,
                    insured, vehicle, tariff, period, value));
            try {
                policyGOServer.create();
            } catch (InsCorpException e) {
                request.setAttribute("msg", e.getMessage());
                RequestDispatcher view = request.getRequestDispatcher("insurer/Msg.jsp");
                view.forward(request, response);
            }

            request.setAttribute("msg", "Успешен запис");
            RequestDispatcher view = request.getRequestDispatcher("insurer/Msg.jsp");
            view.forward(request, response);
        }
    }
}