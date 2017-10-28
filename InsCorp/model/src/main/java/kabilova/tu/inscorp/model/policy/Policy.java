package kabilova.tu.inscorp.model.policy;

import kabilova.tu.inscorp.model.user.Insurer;
import kabilova.tu.inscorp.model.tariff.Tariff;

import java.util.Calendar;

/**
 * Created by ShenaiKabilova
 */
public abstract class Policy {
    private int policaID;
    private Calendar dateFrom;
    private Calendar dateTo;
    private Insurer insurer;
    private Tariff tariff;

    public Policy() {
    }

    public Policy(int policaID, Calendar dateFrom, Calendar dateTo, Insurer insurer, Tariff tariff) {
        this.policaID = policaID;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.insurer = insurer;
        this.tariff = tariff;
    }

    public Policy(Calendar dateFrom, Calendar dateTo, Insurer insurer, Tariff tariff) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.insurer = insurer;
        this.tariff = tariff;
    }

    public Calendar getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Calendar dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Calendar getDateTo() {
        return dateTo;
    }

    public void setDateTo(Calendar dateTo) {
        this.dateTo = dateTo;
    }

    public Insurer getInsurer() {
        return insurer;
    }

    public void setInsurer(Insurer insurer) {
        this.insurer = insurer;
    }

    public int getPolicaID() {
        return policaID;
    }

    public void setPolicaID(int policaID) {
        this.policaID = policaID;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }
}
