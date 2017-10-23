package kabilova.tu.inscorp.model.vehicle;

import kabilova.tu.inscorp.model.user.Insured;

import java.util.Calendar;

/**
 * Created by ShenaiKabilova
 */
public class Vehicle {
    private int      vehicleID;
    private Insured  insured;
    private String   type;
    private String   brand;
    private String   model;
    private String   regNum;
    private String   RAMA;
    private Calendar firstReg;
    private int      year;
    private String   color;
    private float    engine;
    private int      placeNumber;

    public Vehicle() {
    }

    public Vehicle(int vehicleID, String brand, String color, float engine, Calendar firstReg, String model, int placeNumber,
                   String RAMA, String regNum, String type, int year) {
        this.vehicleID = vehicleID;
        this.brand = brand;
        this.color = color;
        this.engine = engine;
        this.firstReg = firstReg;
        this.model = model;
        this.placeNumber = placeNumber;
        this.RAMA = RAMA;
        this.regNum = regNum;
        this.type = type;
        this.year = year;
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

    public float getEngine() {
        return engine;
    }

    public void setEngine(float engine) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
