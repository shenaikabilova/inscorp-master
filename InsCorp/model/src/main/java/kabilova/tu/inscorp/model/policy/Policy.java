package kabilova.tu.inscorp.model.policy;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import kabilova.tu.inscorp.model.user.Admin;
import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscorp.model.user.Insurer;
import kabilova.tu.inscorp.model.tariff.Tariff;
import kabilova.tu.inscorp.model.vehicle.Vehicle;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by ShenaiKabilova
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property="policytype"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = GO.class, name="go"),
        @JsonSubTypes.Type(value = Kasko.class, name="kasko")
})
public abstract class Policy {
    private int id;
    private String policaID;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "UTC+2")
    private Calendar dateFrom;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private Calendar dateTo;
    private Insurer insurer;
    private Insured insured;
    private Vehicle vehicle;
    private int period;
    private double value;

    public Policy() { }

    public Policy(int id, String policaID, Calendar dateFrom, Calendar dateTo, Insurer insurer, Insured insured, Vehicle vehicle, int period, double value) {
        this.id = id;
        this.policaID = policaID;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.insurer = insurer;
        this.insured = insured;
        this.vehicle = vehicle;
        this.period = period;
        this.value = value;
    }

    public Policy(String policaID, Calendar dateFrom, Calendar dateTo, Insurer insurer, Insured insured, Vehicle vehicle, int period, double value) {
        this.policaID = policaID;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.insurer = insurer;
        this.insured = insured;
        this.vehicle = vehicle;
        this.period = period;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Insured getInsured() {
        return insured;
    }

    public void setInsured(Insured insured) {
        this.insured = insured;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
