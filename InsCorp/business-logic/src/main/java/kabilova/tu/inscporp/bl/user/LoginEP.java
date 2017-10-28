package kabilova.tu.inscporp.bl.user;

import kabilova.tu.inscorp.dao.UserDao;
import kabilova.tu.inscorp.model.user.User;

import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public class LoginEP {
    private User user;
    private UserDao dao;

    public LoginEP(User user, UserDao dao){
        this.user = user;
        this.dao = dao;
    }

    public User loadUser() {
        return dao.loadUser(user.getUsername(), user.getPassword());
    }

    public void createUser() {
        dao.create(user);
    }

    public List<User> readUsers() {
        return dao.read();
    }

    public void update() {
        dao.update(user);
    }

    public void delete() {
        dao.delete(user);
    }
}
