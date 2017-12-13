package kabilova.tu.inscorp.dao;

import kabilova.tu.inscorp.model.policy.GO;
import kabilova.tu.inscorp.model.policy.Kasko;
import kabilova.tu.inscorp.model.policy.Policy;
import kabilova.tu.inscorp.model.user.User;

import java.util.Calendar;
import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public interface PolicyDao extends CrudDao<Policy> {
    List<GO> loadActivePoliciesGO(User user, Calendar currentDate);
    List<Kasko> loadActivePoliciesKasko(User user, Calendar currentDate);
}
