package kabilova.tu.inscorp.model.vehicle;

/**
 * Created by ShenaiKabilova
 */
public class VehicleSubtype {
    private int id;
    private VehicleType vehicleType;
    private String subtype;

    public VehicleSubtype() { }

    public VehicleSubtype(int id, VehicleType vehicleType, String subtype) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.subtype = subtype;
    }

    public VehicleSubtype(VehicleType vehicleType, String subtype) {
        this.vehicleType = vehicleType;
        this.subtype = subtype;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }
}
