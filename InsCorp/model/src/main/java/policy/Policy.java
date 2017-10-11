package policy;

import person.Insurer;
import tariff.Tariff;

import java.util.Calendar;

/**
 * Created by ShenaiKabilova
 */
public abstract class Policy {
    private String policaID;
    private Calendar dateTo;
    private Calendar dateFrom;
    private Insurer insurer;
    private Tariff tariff;

    public Policy() {
    }

    public Policy(Calendar dateFrom, Calendar dateTo, Insurer insurer, String policaID, Tariff tariff) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.insurer = insurer;
        this.policaID = policaID;
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

    public String getPolicaID() {
        return policaID;
    }

    public void setPolicaID(String policaID) {
        this.policaID = policaID;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }
}
