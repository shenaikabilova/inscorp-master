package kabilova.tu.inscorp.model.tariff;

import kabilova.tu.inscorp.model.vehicle.VehicleSubtype;
import kabilova.tu.inscorp.model.vehicle.VehicleType;

/**
 * Created by ShenaiKabilova
 */
public class TariffGO extends Tariff {
    private int zone;

    public TariffGO() { }

    public TariffGO(int tariffID, VehicleType vechileType, VehicleSubtype vehicleSubtype, int zone, double value) {
        super(tariffID, vechileType, vehicleSubtype, value);
        this.zone = zone;
    }

    public int getZone() {
        return zone;
    }

    public void setZone(int zone) {
        this.zone = zone;
    }
}
