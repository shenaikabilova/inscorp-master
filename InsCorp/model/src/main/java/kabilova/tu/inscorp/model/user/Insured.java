package kabilova.tu.inscorp.model.user;

/**
 * Created by ShenaiKabilova
 */
public class Insured extends User {
    private String egn;
    private String phone;
    private int postCode;
    private String country;
    private String city;
    private String address;

    public Insured() {
    }

    public Insured(int id, String firstName, String secondName, String lastName, String username, String password,
                   String phoneNumber, String email, String egn, String phone,
                   int postCode, String country, String city, String address ) {
        super(id, firstName, secondName, lastName, username, password, phoneNumber, email);
        this.egn = egn;
        this.phone = phone;
        this.postCode = postCode;
        this.country = country;
        this.country = city;
        this.address = address;
    }

    public Insured(String firstName, String secondName, String lastName, String username, String password,
                   String phoneNumber, String email, String egn, String phone,
                   int postCode, String country, String city, String address ) {
        super(firstName, secondName, lastName, username, password, phoneNumber, email);
        this.egn = egn;
        this.phone = phone;
        this.postCode = postCode;
        this.country = country;
        this.country = city;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
