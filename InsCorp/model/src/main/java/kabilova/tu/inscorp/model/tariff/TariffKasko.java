package kabilova.tu.inscorp.model.tariff;

import kabilova.tu.inscorp.model.policy.Kasko;
import kabilova.tu.inscorp.model.vehicle.VehicleSubtype;
import kabilova.tu.inscorp.model.vehicle.VehicleType;

/**
 * Created by ShenaiKabilova
 */
public class TariffKasko extends Tariff {
    private int kaskoPercent;

    public TariffKasko() { }

    public TariffKasko(int tariffID, VehicleType vechileType, VehicleSubtype vehicleSubtype, int kaskoPercent, double value) {
        super(tariffID, vechileType, vehicleSubtype, value);
        this.kaskoPercent = kaskoPercent;
    }

    public int getKaskoPercent() {
        return kaskoPercent;
    }

    public void setKaskoPercent(int kaskoPercent) {
        this.kaskoPercent = kaskoPercent;
    }
}
