package kabilova.tu.inscorp.model.user;

/**
 * Created by ShenaiKabilova
 */
public class Insured extends User {
    private String egn;
    private int postCode;
    private String country;
    private String city;
    private String address;

    public Insured() {
    }

    public Insured(int id, String firstName, String secondName, String lastName, String username, String password,
                   String egn, int postCode, String country, String city, String address, String phoneNumber, String email ) {
        super(id, firstName, secondName, lastName, username, password, phoneNumber, email);
        this.egn = egn;
        this.postCode = postCode;
        this.country = country;
        this.city = city;
        this.address = address;
    }

    public Insured(String firstName, String secondName, String lastName, String username, String password,
                   String egn, int postCode, String country, String city, String address, String phoneNumber, String email ) {
        super(firstName, secondName, lastName, username, password, phoneNumber, email);
        this.egn = egn;
        this.postCode = postCode;
        this.country = country;
        this.city = city;
        this.address = address;
    }
//    public void myMethod(int insuredID, Vehicle vehicle) {
//        Insured ins = loadInsured(insuredID);
//        ins.setVehicle(vehicle);
//        VehicleDaoImp
//                .create(vehicle);
//        userdaoimp -> update
//    }
//
//    private Insured loadInsured(Integer id) {
//        return new Insured();
//    }

    public String getEgn() {
        return egn;
    }

    public void setEgn(String egn) {
        this.egn = egn;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
