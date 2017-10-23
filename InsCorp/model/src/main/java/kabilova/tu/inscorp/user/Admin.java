package kabilova.tu.inscorp.user;

/**
 * Created by ShenaiKabilova
 */
public class Admin extends User {
    public Admin() {
    }

    public Admin(int id, String firstName, String secondName,  String lastName, String username, String password,
                 String phoneNumber, String email) {
        super(id, firstName, secondName, lastName, username, password, phoneNumber, email);
    }

    public Admin(String firstName, String secondName,  String lastName, String username, String password,
                 String phoneNumber, String email) {
        super(firstName, secondName, lastName, username, password, phoneNumber, email);
    }
}
