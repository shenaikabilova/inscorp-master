package kabilova.tu.inscorp.dao;

import kabilova.tu.inscorp.model.exception.InsCorpException;
import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscorp.model.user.Insurer;
import kabilova.tu.inscorp.model.user.User;

import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public interface UserDao extends CrudDao<User> {
    User loadUser(String username, String password) throws InsCorpException;
    User loadByUsername(String username) throws InsCorpException;
    User loadByEGN (String egn) throws InsCorpException;
    List<Insurer> readInsurers();
    List<Insured> readInsured();
}
