package kabilova.tu.inscorp.model.policy;

import kabilova.tu.inscorp.model.tariff.Tariff;
import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscorp.model.user.Insurer;
import kabilova.tu.inscorp.model.vehicle.Vehicle;

import java.util.Calendar;

/**
 * Created by ShenaiKabilova
 */
public class GO extends Policy {

    public GO () { }

    public GO(int policaID, Calendar dateFrom, Calendar dateTo, Insurer insurer, Insured insured,
              Vehicle vehicle, Tariff tariff) {
        super(policaID, dateFrom, dateTo, insurer, insured, vehicle, tariff);
    }

    public GO(Calendar dateFrom, Calendar dateTo, Insurer insurer, Insured insured, Vehicle vehicle, Tariff tariff) {
        super(dateFrom, dateTo, insurer, insured, vehicle, tariff);
    }
}
