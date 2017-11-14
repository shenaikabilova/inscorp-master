package kabilova.tu.inscorp.server.web;

import kabilova.tu.inscorp.daoimpl.hb.UserDaoImpl;
import kabilova.tu.inscorp.model.user.User;
import kabilova.tu.inscporp.bl.user.UserEP;

import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public class UserServer<T> {
    private UserEP userEP;

    public UserServer() {

    }

    public UserServer(User user) {
        userEP = new UserEP(user, new UserDaoImpl());
    }

    public void createUser() {
        userEP.createUser();
    }

    public List<T> readAll() { return userEP.readUsers(); }

    public User loadUser(String username, String password) {
        return userEP.loadUser(username, password);
    }

    public void update() { userEP.update(); }

    public void delete() { userEP.delete(); }

    public User loadByUsername() { return userEP.loadByUsername(); }
}
