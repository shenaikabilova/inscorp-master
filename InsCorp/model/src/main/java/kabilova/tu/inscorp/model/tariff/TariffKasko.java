package kabilova.tu.inscorp.model.tariff;

import kabilova.tu.inscorp.model.vehicle.VehicleSubtype;
import kabilova.tu.inscorp.model.vehicle.VehicleType;

/**
 * Created by ShenaiKabilova
 */
public class TariffKasko extends Tariff {
    private int kaskoPercent;

    public TariffKasko() { }

    public TariffKasko(int tariffID, VehicleType vechileType, VehicleSubtype vehicleSubtype, int kaskoPercent) {
        super(tariffID, vechileType, vehicleSubtype);
        this.kaskoPercent = kaskoPercent;
    }

    public int getKaskoPercent() {
        return kaskoPercent;
    }

    public void setKaskoPercent(int kaskoPercent) {
        this.kaskoPercent = kaskoPercent;
    }
}
