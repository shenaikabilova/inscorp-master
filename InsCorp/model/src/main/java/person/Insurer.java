package person;

/**
 * Created by ShenaiKabilova
 */
public class Insurer extends Person {
    private int insurerID;

    public Insurer() {
    }

    public Insurer(String firstName, int id, String lastName, String password, String secondName, String username,
                   int insurerID) {
        super(firstName, id, lastName, password, secondName, username);
        this.insurerID = insurerID;
    }

    public int getInsurerID() {
        return insurerID;
    }

    public void setInsurerID(int insurerID) {
        this.insurerID = insurerID;
    }
}
