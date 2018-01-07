package kabilova.tu.inscorp.dao;

import kabilova.tu.inscorp.model.exception.InsCorpException;
import kabilova.tu.inscorp.model.user.User;
import kabilova.tu.inscorp.model.policy.GO;
import kabilova.tu.inscorp.model.policy.Kasko;
import kabilova.tu.inscorp.model.policy.Policy;

import java.util.Calendar;
import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public interface PolicyDao extends CrudDao<Policy> {
    List<GO> loadActivePoliciesGO(User user, Calendar currentDate);
    List<Kasko> loadActivePoliciesKasko(User user, Calendar currentDate);
    List<GO> loadPoliciesGO(User user) throws InsCorpException;
    List<Kasko> loadPoliciesKasko(User user) throws InsCorpException;
    List<GO> loadAllGO() throws InsCorpException;
    List<Kasko> loadAllKasko();
    String getLastPolicyID();
    Policy getPolicaByPolicaNum(String policaNum) throws InsCorpException;
}
