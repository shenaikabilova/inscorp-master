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
    private int policaID;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "UTC+2")
//    @JsonDeserialize(using = JsonDeserializer.class, as=Calendar.class)
    private Calendar dateFrom;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private Calendar dateTo;
    private Insurer insurer;
    private Insured insured;
    private Vehicle vehicle;
    private Tariff tariff;

    public Policy() { }

    public Policy(int policaID, Calendar dateFrom, Calendar dateTo, Insurer insurer, Insured insured, Vehicle vehicle, Tariff tariff) {
        this.policaID = policaID;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.insurer = insurer;
        this.insured = insured;
        this.vehicle = vehicle;
        this.tariff = tariff;
    }

    public Policy(Calendar dateFrom, Calendar dateTo, Insurer insurer, Insured insured, Vehicle vehicle, Tariff tariff) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.insurer = insurer;
        this.insured = insured;
        this.vehicle = vehicle;
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
}
