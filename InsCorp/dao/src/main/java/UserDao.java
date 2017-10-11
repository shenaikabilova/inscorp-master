import model.User;

/**
 * Created by ShenaiKabilova
 */
public interface UserDao extends CrudDao {
    boolean isUser(User user);
}
