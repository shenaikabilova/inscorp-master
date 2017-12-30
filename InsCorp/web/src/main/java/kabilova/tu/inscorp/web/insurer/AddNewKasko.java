package kabilova.tu.inscorp.web.insurer;

import kabilova.tu.inscorp.model.policy.Kasko;
import kabilova.tu.inscorp.model.tariff.TariffKasko;
import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscorp.model.user.Insurer;
import kabilova.tu.inscorp.model.vehicle.Vehicle;
import kabilova.tu.inscorp.server.web.PolicyServer;

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
@WebServlet("/addNewKasko")
public class AddNewKasko extends HttpServlet {
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String policaID = request.getParameter("policaN");
        int insurerID = Integer.parseInt(request.getParameter("insID"));
        int insuredID = Integer.parseInt(request.getParameter("insuredID"));
        int vehicleID = Integer.parseInt(request.getParameter("vehicleID"));

        String strFromDate =  request.getParameter("fromDate");
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
        String kaskoType = request.getParameter("kaskoType");
        double vehicleValue = Double.parseDouble(request.getParameter("vehicleValue"));
        int period = Integer.parseInt(request.getParameter("period"));
        double value = Double.parseDouble(request.getParameter("value"));

        Insurer insurer = new Insurer();
        Insured insured = new Insured();
        Vehicle vehicle = new Vehicle();
        TariffKasko tariff = new TariffKasko();
        insurer.setId(insurerID);
        insured.setId(insuredID);
        vehicle.setVehicleID(vehicleID);
        tariff.setTariffID(tariffID);

        PolicyServer policyKaskoServer = new PolicyServer(new Kasko(policaID, calendarFromDate, calendarToDate, insurer,
                insured, vehicle, tariff, kaskoType, period, value, vehicleValue));
        policyKaskoServer.create();

        request.setAttribute("msg", "Успешен запис");
        RequestDispatcher view = request.getRequestDispatcher("insurer/ErrorLogin.jsp");
        view.forward(request, response);
    }
}
