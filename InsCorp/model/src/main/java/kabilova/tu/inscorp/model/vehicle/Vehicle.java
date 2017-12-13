package kabilova.tu.inscorp.model.vehicle;

import com.fasterxml.jackson.annotation.JsonFormat;
import kabilova.tu.inscorp.model.user.Insured;

import java.util.Calendar;

/**
 * Created by ShenaiKabilova
 */
public class Vehicle {
    private int      vehicleID;
    private Insured  insured;
    private VehicleType vehicleType;
    private VehicleSubtype vehicleSubtype;
    private String   regNum;
    private String   RAMA;
    private String   brand;
    private String   model;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "UTC+2")
    private Calendar firstReg;
    private int      years;
    private double    engine;
    private String   color;
    private int      placeNumber;

    public Vehicle() {
    }

    public Vehicle(int vehicleID, Insured insured, VehicleType vehicleType, VehicleSubtype vehicleSubtype, String regNum, String RAMA, String brand, String model,
                    Calendar firstReg, int years, double engine, String color, int placeNumber) {
        this.vehicleID = vehicleID;
        this.insured = insured;
        this.vehicleType = vehicleType;
        this.vehicleSubtype = vehicleSubtype;
        this.regNum = regNum;
        this.RAMA = RAMA;
        this.brand = brand;
        this.model = model;
        this.firstReg = firstReg;
        this.years = years;
        this.engine = engine;
        this.color = color;
        this.placeNumber = placeNumber;
    }

    public Vehicle(Insured insured, VehicleType vehicleType, VehicleSubtype vehicleSubtype, String regNum, String RAMA, String brand, String model,
                   Calendar firstReg, int years, double engine, String color, int placeNumber) {
        this.insured = insured;
        this.vehicleType = vehicleType;
        this.vehicleSubtype = vehicleSubtype;
        this.RAMA = RAMA;
        this.brand = brand;
        this.model = model;
        this.firstReg = firstReg;
        this.years = years;
        this.engine = engine;
        this.color = color;
        this.placeNumber = placeNumber;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public Insured getInsured() {
        return insured;
    }

    public void setInsured(Insured insured) {
        this.insured = insured;
    }

    public VehicleSubtype getVehicleSubtype() {
        return vehicleSubtype;
    }

    public void setVehicleSubtype(VehicleSubtype vehicleSubtype) {
        this.vehicleSubtype = vehicleSubtype;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getEngine() {
        return engine;
    }

    public void setEngine(double engine) {
        this.engine = engine;
    }

    public Calendar getFirstReg() {
        return firstReg;
    }

    public void setFirstReg(Calendar firstReg) {
        this.firstReg = firstReg;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    public String getRAMA() {
        return RAMA;
    }

    public void setRAMA(String RAMA) {
        this.RAMA = RAMA;
    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }


    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }
}
