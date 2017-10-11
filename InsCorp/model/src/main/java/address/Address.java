package address;

/**
 * Created by ShenaiKabilova
 */
public class Address {
    private int id;
    private String country;
    private String city;
    private String street;
    private int block;
    private int floor;
    private int apartment;

    public Address() {
    }

    public Address(int id, String country, String city, String street, int block, int floor, int apartment) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.street = street;
        this.block = block;
        this.floor = floor;
        this.apartment = apartment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }
}

