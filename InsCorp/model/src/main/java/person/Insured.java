package person;

import address.Address;
import vehicle.Vehicle;

/**
 * Created by ShenaiKabilova
 */
public class Insured extends Person {
    private String egn;
    private String phone;
    private Address address;
    private Vehicle vehicle;

    public Insured() {
    }

    public Insured(String firstName, int id, String lastName, String password, String secondName, String username,
                   Address address, String egn, String phone, Vehicle vehicle) {
        super(firstName, id, lastName, password, secondName, username);
        this.address = address;
        this.egn = egn;
        this.phone = phone;
        this.vehicle = vehicle;
    }

    public String getEgn() {
        return egn;
    }

    public void setEgn(String egn) {
        this.egn = egn;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
