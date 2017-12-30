package kabilova.tu.inscorp.model.policy;

import kabilova.tu.inscorp.model.tariff.TariffKasko;
import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscorp.model.user.Insurer;
import kabilova.tu.inscorp.model.vehicle.Vehicle;

import java.util.Calendar;

/**
 * Created by ShenaiKabilova
 */
public class Kasko extends Policy {
    private TariffKasko tariffKasko;
    private String kaskoType;
    private double vehicleValue;

    public Kasko() { }

    public Kasko(int id, String policaID, Calendar dateFrom, Calendar dateTo, Insurer insurer, Insured insured, Vehicle vehicle,
                 TariffKasko tariffKasko, String kaskoType, int period, double value, double vehicleValue) {
        super(id, policaID, dateFrom, dateTo, insurer, insured, vehicle, period, value);
        this.tariffKasko = tariffKasko;
        this.kaskoType = kaskoType;
        this.vehicleValue = vehicleValue;
    }

    public Kasko(String policaID, Calendar dateFrom, Calendar dateTo, Insurer insurer, Insured insured, Vehicle vehicle,
                 TariffKasko tariffKasko, String kaskoType, int period, double value, double vehicleValue) {
        super(policaID, dateFrom, dateTo, insurer, insured, vehicle, period, value);
        this.tariffKasko = tariffKasko;
        this.kaskoType = kaskoType;
        this.vehicleValue = vehicleValue;
    }

    public TariffKasko getTariffKasko() {
        return tariffKasko;
    }

    public void setTariffKasko(TariffKasko tariffKasko) {
        this.tariffKasko = tariffKasko;
    }

    public String getKaskoType() {
        return kaskoType;
    }

    public void setKaskoType(String kaskoType) {
        this.kaskoType = kaskoType;
    }

    public double getVehicleValue() {
        return vehicleValue;
    }

    public void setVehicleValue(double vehicleValue) {
        this.vehicleValue = vehicleValue;
    }
}
