package kabilova.tu.inscorp.model.policy;

import kabilova.tu.inscorp.model.tariff.Tariff;
import kabilova.tu.inscorp.model.user.Insurer;

import java.util.Calendar;

/**
 * Created by ShenaiKabilova
 */
public class Kasko extends Policy {
    private String kaskoType;

    public Kasko() { }

    public Kasko(int policaID, Calendar dateFrom, Calendar dateTo, Insurer insurer, Tariff tariff, String kaskoType) {
        super(policaID, dateFrom, dateTo, insurer, tariff);
        this.kaskoType = kaskoType;
    }

    public Kasko(Calendar dateFrom, Calendar dateTo, Insurer insurer, Tariff tariff, String kaskoType) {
        super(dateFrom, dateTo, insurer, tariff);
        this.kaskoType = kaskoType;
    }

    public String getKaskoType() {
        return kaskoType;
    }

    public void setKaskoType(String kaskoType) {
        this.kaskoType = kaskoType;
    }
}
