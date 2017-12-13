package kabilova.tu.inscorp.model.tariff;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import kabilova.tu.inscorp.model.user.Admin;
import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscorp.model.user.Insurer;
import kabilova.tu.inscorp.model.vehicle.VehicleSubtype;
import kabilova.tu.inscorp.model.vehicle.VehicleType;

/**
 * Created by ShenaiKabilova
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property="type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = TariffGO.class, name="tariffgo"),
        @JsonSubTypes.Type(value = TariffKasko.class, name="tariffkasko")
})
public abstract class Tariff {
    private int tariffID;
    private VehicleType vechileType;
    private VehicleSubtype vehicleSubtype;
    private double value;

    public Tariff() {
    }

    public Tariff(int tariffID, VehicleType vechileType, VehicleSubtype vehicleSubtype, double value) {
        this.tariffID = tariffID;
        this.vechileType = vechileType;
        this.vehicleSubtype = vehicleSubtype;
        this.value = value;
    }

    public Tariff(VehicleType vechileType, VehicleSubtype vehicleSubtype, double value) {
        this.vechileType = vechileType;
        this.vehicleSubtype = vehicleSubtype;
        this.value = value;
    }

    public int getTariffID() {
        return tariffID;
    }

    public void setTariffID(int tariffID) {
        this.tariffID = tariffID;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public VehicleType getVechileType() {
        return vechileType;
    }

    public void setVechileType(VehicleType vechileType) {
        this.vechileType = vechileType;
    }

    public VehicleSubtype getVehicleSubtype() {
        return vehicleSubtype;
    }

    public void setVehicleSubtype(VehicleSubtype vehicleSubtype) {
        this.vehicleSubtype = vehicleSubtype;
    }
}
