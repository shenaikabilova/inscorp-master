package kabilova.tu.inscorp.vehicle;

import java.util.Set;

/**
 * Created by ShenaiKabilova
 */
public class VehicleType {
    private int id;
    private String vehicleType;
    private Set<VehicleSubtype> subtype;

    public VehicleType() { }

    public VehicleType(int id, String vehicleType) {
        this.id = id;
        this.vehicleType = vehicleType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Set<VehicleSubtype> getSubtype() {
        return subtype;
    }

    public void setSubtype(Set<VehicleSubtype> subtype) {
        this.subtype = subtype;
    }
}
