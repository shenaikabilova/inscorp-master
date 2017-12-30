package kabilova.tu.inscorp.dao;

import kabilova.tu.inscorp.model.user.Insurer;

import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public interface InsurerDao extends UserDao {
    List<Insurer> readInsurers();
    
}
