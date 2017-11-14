package kabilova.tu.inscorp.web.insurer;

import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscorp.model.vehicle.Vehicle;
import kabilova.tu.inscorp.model.vehicle.VehicleSubtype;
import kabilova.tu.inscorp.model.vehicle.VehicleType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

/**
 * Created by ShenaiKabilova
 */
@WebServlet("/addNewMps")
public class AddNewMps extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int insuredID = Integer.parseInt(request.getParameter("insuredID"));
        String regNum = request.getParameter("regNum");
        String rama = request.getParameter("rama");
        int typeID = Integer.parseInt(request.getParameter("type"));
        int subtypeID = Integer.parseInt(request.getParameter("subtype"));
        String country = request.getParameter("country");
        String brand;
        String model;
        Calendar firstReg; // = request.getParameter("firstReg");
        int years = Integer.parseInt(request.getParameter("years"));
        float engine = Float.parseFloat(request.getParameter("engine"));
        String color;
        int placeNumber = Integer.getInteger(request.getParameter("placeNumber"));

        Insured insured = new Insured();
        insured.setId(insuredID);
        VehicleType vehicleType = new VehicleType();
        vehicleType.setId(typeID);
        VehicleSubtype vehicleSubtype = new VehicleSubtype();
        vehicleSubtype.setId(subtypeID);

//        Vehicle vehicle = new Vehicle(insured, vehicleType, vehicleSubtype, regNum, rama, brand, model, firstReg, years, engine, color, placeNumber);

    }
}
