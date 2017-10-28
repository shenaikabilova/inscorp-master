package kabilova.tu.inscorp.model.tariff;

import kabilova.tu.inscorp.model.vehicle.VehicleSubtype;
import kabilova.tu.inscorp.model.vehicle.VehicleType;

/**
 * Created by ShenaiKabilova
 */
public class Tariff {
    private int tariffID;
    private int zone;
    private VehicleType vechileType;
    private VehicleSubtype vehicleSubtype;
    private double value;

    public Tariff() {
    }

    public Tariff(int tariffID, double value, VehicleType vechileType, VehicleSubtype vehicleSubtype, int zone) {
        this.tariffID = tariffID;
        this.value = value;
        this.vechileType = vechileType;
        this.vehicleSubtype = vehicleSubtype;
        this.zone = zone;
    }

    public int getTariffID() {
        return tariffID;
    }

    public void setTariffID(int tariffID) {
        this.tariffID = tariffID;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public VehicleType getVechileType() {
        return vechileType;
    }

    public void setVechileType(VehicleType vechileType) {
        this.vechileType = vechileType;
    }

    public VehicleSubtype getVehicleSubtype() {
        return vehicleSubtype;
    }

    public void setVehicleSubtype(VehicleSubtype vehicleSubtype) {
        this.vehicleSubtype = vehicleSubtype;
    }

    public int getZone() {
        return zone;
    }

    public void setZone(int zone) {
        this.zone = zone;
    }
}
