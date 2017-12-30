package kabilova.tu.inscorp.model.policy;

import kabilova.tu.inscorp.model.tariff.Tariff;
import kabilova.tu.inscorp.model.tariff.TariffGO;
import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscorp.model.user.Insurer;
import kabilova.tu.inscorp.model.vehicle.Vehicle;

import java.util.Calendar;

/**
 * Created by ShenaiKabilova
 */
public class GO extends Policy {
    private TariffGO tariffGO;

    public GO () { }

    public GO(int id, String policaID, Calendar dateFrom, Calendar dateTo, Insurer insurer, Insured insured,
              Vehicle vehicle, TariffGO tariffGO, int period, double value) {
        super(id, policaID, dateFrom, dateTo, insurer, insured, vehicle, period, value);
        this.tariffGO = tariffGO;
    }

    public GO(String policaID, Calendar dateFrom, Calendar dateTo, Insurer insurer, Insured insured, Vehicle vehicle, TariffGO tariffGO,
              int period, double value) {
        super(policaID, dateFrom, dateTo, insurer, insured, vehicle, period, value);
        this.tariffGO = tariffGO;
    }

    public TariffGO getTariffGO() {
        return tariffGO;
    }

    public void setTariffGO(TariffGO tariffGO) {
        this.tariffGO = tariffGO;
    }
}
