package kabilova.tu.inscorp.model.user;

/**
 * Created by ShenaiKabilova
 */
public class Insurer extends User {
    private int insurerID;

    public Insurer() {
    }

    public Insurer(int id, int insurerID, String firstName, String secondName, String lastName, String username,
                   String password, String phoneNumber, String email) {
        super(id, firstName, secondName, lastName, username, password, phoneNumber, email);
        this.insurerID = insurerID;
    }

    public Insurer(int insurerID, String firstName, String secondName, String lastName, String username, String password,
                   String phoneNumber, String email) {
        super(firstName, secondName, lastName, username, password, phoneNumber, email);
        this.insurerID = insurerID;
    }

    public int getInsurerID() {
        return insurerID;
    }

    public void setInsurerID(int insurerID) {
        this.insurerID = insurerID;
    }
}
