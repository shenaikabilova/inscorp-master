package kabilova.tu.inscporp.bl.user;

import kabilova.tu.inscorp.dao.UserDao;
import kabilova.tu.inscorp.model.user.User;

import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public class UserEP {
    private User user;
    private UserDao dao;

    public UserEP(User user, UserDao dao){
        this.user = user;
        this.dao = dao;
    }

    public User loadUser(String username, String password) {
        return dao.loadUser(username, password);
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