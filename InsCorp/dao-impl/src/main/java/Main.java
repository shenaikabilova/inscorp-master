import kabilova.tu.inscorp.model.user.Admin;

/**
 * Created by ShenaiKabilova
 */
public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin(1, "Admin", "Admin", "Admin", "admin", "admin");
        UserDao dao = new UserDaoImpl();
        dao.create(admin);
    }
}
