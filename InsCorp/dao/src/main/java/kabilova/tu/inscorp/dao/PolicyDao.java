package kabilova.tu.inscorp.dao;

import kabilova.tu.inscorp.model.policy.Policy;
import kabilova.tu.inscorp.model.user.User;

import java.util.Calendar;
import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public interface PolicyDao extends CrudDao<Policy> {
    List<Policy> loadActivePolicies(User user, Calendar currentDate);
}
