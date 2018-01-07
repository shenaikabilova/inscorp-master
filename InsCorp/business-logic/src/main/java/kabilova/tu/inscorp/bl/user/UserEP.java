package kabilova.tu.inscorp.bl.user;

import kabilova.tu.inscorp.model.exception.InsCorpException;
import kabilova.tu.inscorp.dao.UserDao;
import kabilova.tu.inscorp.model.user.Insurer;
import kabilova.tu.inscorp.model.user.User;

import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public class UserEP {
    private User user;
    private UserDao dao;

    public UserEP() { }

    public UserEP(User user, UserDao dao){
        this.user = user;
        this.dao = dao;
    }

    public User loadUser(String username, String password) throws InsCorpException {
        return dao.loadUser(username, password);
    }

    public void createUser() throws InsCorpException {
        dao.create(user);
    }

    public List readUsers() {
        return dao.read();
    }

    public void update() {
        dao.update(user);
    }

    public void delete() throws InsCorpException {
        dao.delete(user);
    }

    public User loadByUsername()throws InsCorpException  { return dao.loadByUsername(user.getUsername()); }

    public List<Insurer> readInsurers() { return dao.readInsurers(); }
}
