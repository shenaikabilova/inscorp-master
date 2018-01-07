package kabilova.tu.inscorp.server.web;

import kabilova.tu.inscorp.model.exception.InsCorpException;
import kabilova.tu.inscorp.daoimpl.hb.UserDaoImpl;
import kabilova.tu.inscorp.model.user.Insurer;
import kabilova.tu.inscorp.model.user.User;
import kabilova.tu.inscorp.bl.user.UserEP;

import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public class UserServer {
    private UserEP userEP;

    public UserServer() { }

    public UserServer(User user) {
        userEP = new UserEP(user, new UserDaoImpl());
    }

    public void createUser() throws InsCorpException {
        userEP.createUser();
    }

    public List readAll() { return userEP.readUsers(); }

    public User loadUser(String username, String password) throws InsCorpException {
        return userEP.loadUser(username, password);
    }

    public void update() { userEP.update(); }

    public void delete() throws InsCorpException { userEP.delete(); }

    public User loadByUsername() throws InsCorpException  { return userEP.loadByUsername(); }

    public List<Insurer> readInsurers() { return userEP.readInsurers(); }
}
