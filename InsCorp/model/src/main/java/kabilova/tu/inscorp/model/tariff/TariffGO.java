package kabilova.tu.inscorp.model.tariff;

import kabilova.tu.inscorp.model.vehicle.VehicleSubtype;
import kabilova.tu.inscorp.model.vehicle.VehicleType;

/**
 * Created by ShenaiKabilova
 */
public class TariffGO extends Tariff {
    private int zone;
    private double value;

    public TariffGO() { }

    public TariffGO(int tariffID, VehicleType vechileType, VehicleSubtype vehicleSubtype, int zone, double value) {
        super(tariffID, vechileType, vehicleSubtype);
        this.zone = zone;
        this.value = value;
    }

    public TariffGO(VehicleType vechileType, VehicleSubtype vehicleSubtype, int zone, double value) {
        super(vechileType, vehicleSubtype);
        this.zone = zone;
        this.value = value;
    }

    public int getZone() {
        return zone;
    }

    public void setZone(int zone) {
        this.zone = zone;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
