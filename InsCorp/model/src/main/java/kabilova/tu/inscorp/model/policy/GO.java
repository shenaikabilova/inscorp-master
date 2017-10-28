package kabilova.tu.inscorp.model.policy;

import kabilova.tu.inscorp.model.tariff.Tariff;
import kabilova.tu.inscorp.model.user.Insurer;

import java.util.Calendar;

/**
 * Created by ShenaiKabilova
 */
public class GO extends Policy {

    public GO () { }

    public GO(int policaID, Calendar dateFrom, Calendar dateTo, Insurer insurer, Tariff tariff) {
        super(policaID, dateFrom, dateTo, insurer, tariff);
    }

    public GO(Calendar dateFrom, Calendar dateTo, Insurer insurer, Tariff tariff) {
        super(dateFrom, dateTo, insurer, tariff);
    }
}
