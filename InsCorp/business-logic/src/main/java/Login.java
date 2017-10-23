import kabilova.tu.inscorp.user.User;

/**
 * Created by ShenaiKabilova
 */
public class Login {
    private User user;
    private UserDao dao;

    public Login(User user, UserDao dao){
        this.user = user;
        this.dao = dao;
    }

//    public boolean hasUser() {
//        return dao.loadUser(user.getUsername(), user.getPassword());
//    }
}
