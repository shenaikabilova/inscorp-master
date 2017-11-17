package kabilova.tu.inscporp.bl.user;

import kabilova.tu.inscorp.dao.PolicyDao;
import kabilova.tu.inscorp.model.policy.Policy;
import kabilova.tu.inscorp.model.user.Insured;

import java.util.Calendar;
import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public class PolicyEP {
    private Policy policy;
    private PolicyDao dao;

    public PolicyEP() { }

    public PolicyEP(Policy policy, PolicyDao dao) {
        this.policy = policy;
        this.dao = dao;
    }

    public void create() { dao.create(policy); }

    public List<Policy> read() { return dao.read(); }

    public void update() { dao.update(policy); }

    public void delete() { dao.delete(policy); }

    public List<Policy> loadActivePolicies(Insured insured, Calendar currentDate) { return dao.loadActivePolicies(insured, currentDate); }
}
