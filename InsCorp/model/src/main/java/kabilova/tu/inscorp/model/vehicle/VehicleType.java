package kabilova.tu.inscorp.model.vehicle;

import java.util.Set;

/**
 * Created by ShenaiKabilova
 */
public class VehicleType {
    private int id;
    private String vehicleType;

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
}
