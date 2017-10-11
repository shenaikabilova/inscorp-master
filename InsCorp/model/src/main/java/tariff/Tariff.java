package tariff;

/**
 * Created by ShenaiKabilova
 */
public class Tariff {
    private int zone;
    private String vechileType;
    private String vehicleSubtype;
    private double value;

    public Tariff() {
    }

    public Tariff(double value, String vechileType, String vehicleSubtype, int zone) {
        this.value = value;
        this.vechileType = vechileType;
        this.vehicleSubtype = vehicleSubtype;
        this.zone = zone;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getVechileType() {
        return vechileType;
    }

    public void setVechileType(String vechileType) {
        this.vechileType = vechileType;
    }

    public String getVehicleSubtype() {
        return vehicleSubtype;
    }

    public void setVehicleSubtype(String vehicleSubtype) {
        this.vehicleSubtype = vehicleSubtype;
    }

    public int getZone() {
        return zone;
    }

    public void setZone(int zone) {
        this.zone = zone;
    }
}
