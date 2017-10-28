package kabilova.tu.inscorp.server.web;

import kabilova.tu.inscorp.dao.UserDao;
import kabilova.tu.inscorp.daoimpl.hb.UserDaoImpl;
import kabilova.tu.inscorp.model.user.User;
import kabilova.tu.inscporp.bl.user.LoginEP;

/**
 * Created by ShenaiKabilova
 */
public class UserServer {
    private LoginEP loginEP;
    private User user;
    private UserDao dao = new UserDaoImpl();

    public UserServer(User user) {
        this.user = user;
        loginEP = new LoginEP(user, dao);
    }

    public void createUser() {
        dao.create(user);
    }
}
