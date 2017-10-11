package person;

/**
 * Created by ShenaiKabilova
 */
public abstract class Person {
    private int id;
    private String firstName;
    private String secondName;
    private String lastName;
    private String username;
    private String password;

    public Person() {
    }

    public Person(String firstName, int id, String lastName, String password, String secondName, String username) {
        this.firstName = firstName;
        this.id = id;
        this.lastName = lastName;
        this.password = password;
        this.secondName = secondName;
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
