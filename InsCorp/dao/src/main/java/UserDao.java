import kabilova.tu.inscorp.user.User;

/**
 * Created by ShenaiKabilova
 */
public interface UserDao extends CrudDao<User> {
    User loadUser(String username, String password);
}
