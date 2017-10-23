package kabilova.tu.inscorp.vehicle;

/**
 * Created by ShenaiKabilova
 */
public class VehicleSubtype {
    private int id;
    private String subtype;

    public VehicleSubtype() { }

    public VehicleSubtype(int id, String subtype) {
        this.id = id;
        this.subtype = subtype;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }
}
