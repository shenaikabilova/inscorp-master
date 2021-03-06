package kabilova.tu.inscorp.web.insurer;

import kabilova.tu.inscorp.model.exception.InsCorpException;
import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscorp.model.vehicle.Vehicle;
import kabilova.tu.inscorp.model.vehicle.VehicleSubtype;
import kabilova.tu.inscorp.model.vehicle.VehicleType;
import kabilova.tu.inscorp.server.web.VehicleServer;

import javax.servlet.RequestDispatcher;
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
@WebServlet("/updateMPS")
public class UpdateVehicle extends HttpServlet {
    public void init() throws ServletException {
        super.init();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        int vehicleID = Integer.parseInt(request.getParameter("vehicleID"));
        int insuredID = Integer.parseInt(request.getParameter("insuredID"));
        String regNum = request.getParameter("regNum");
        String regCity = request.getParameter("regCity");
        int zone = Integer.parseInt(request.getParameter("zone"));
        String rama = request.getParameter("rama");
        int typeID = Integer.parseInt(request.getParameter("vehicleType"));
        int subtypeID = Integer.parseInt(request.getParameter("vehicleSubtype"));
        String country = request.getParameter("country");
        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        String firstReg =  request.getParameter("firstReg");
        int years = request.getParameter("years") != "" ? Integer.parseInt(request.getParameter("years")) : 0;
        double engine = Double.parseDouble(request.getParameter("engine"));
        String color = request.getParameter("color");
        int placeNumber = request.getParameter("placeNumber") != "" ? Integer.parseInt(request.getParameter("placeNumber")) : 0;

        if(insuredID==0 || regNum.trim().equals("") || regCity.trim().equals("") || zone==0 || rama.trim().equals("") ||
                typeID==0 || subtypeID==0 || country.trim().equals("") || brand.trim().equals("") || model.trim().equals("") ||
                firstReg.trim().equals("") || years==0 ||engine==0 || color.trim().equals("") || placeNumber==0) {
            request.setAttribute("msg", "Моля, попълнете всички полета!");
            RequestDispatcher view = request.getRequestDispatcher("insurer/Msg.jsp");
            view.forward(request, response);
        } else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Calendar calendar = Calendar.getInstance();
            try {
                calendar.setTime(simpleDateFormat.parse(firstReg));
            } catch (ParseException e) {
                System.out.println("Exception :" + e);
            }

            Insured insured = new Insured();
            insured.setId(insuredID);
            VehicleType vehicleType = new VehicleType();
            vehicleType.setId(typeID);
            VehicleSubtype vehicleSubtype = new VehicleSubtype();
            vehicleSubtype.setId(subtypeID);

            VehicleServer vehicleServer = new VehicleServer(new Vehicle(vehicleID, insured, vehicleType, vehicleSubtype, regNum, country,
                    regCity, rama, brand, model, calendar, years, engine, color, placeNumber, zone));

//            try {
                vehicleServer.update();
//            } catch (InsCorpException e) {
//                String errorMsg = new String(e.getMessage().getBytes(), "UTF-8");
//                request.setAttribute("msg", errorMsg);
//                RequestDispatcher view = request.getRequestDispatcher("insurer/Msg.jsp");
//                view.forward(request, response);
//            }

            request.setAttribute("msg", "Успешен запис");
            RequestDispatcher view = request.getRequestDispatcher("insurer/Msg.jsp");
            view.forward(request, response);
        }
    }
}