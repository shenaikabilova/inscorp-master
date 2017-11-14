package kabilova.tu.inscorp.dao;

import kabilova.tu.inscorp.dao.CrudDao;
import kabilova.tu.inscorp.model.user.User;

/**
 * Created by ShenaiKabilova
 */
public interface UserDao extends CrudDao<User> {
    User loadUser(String username, String password);
    User loadByUsername(String username);
    User loadByEGN (String egn);
}
