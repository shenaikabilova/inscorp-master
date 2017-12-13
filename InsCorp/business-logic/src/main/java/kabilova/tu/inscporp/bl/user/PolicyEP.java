package kabilova.tu.inscporp.bl.user;

import kabilova.tu.inscorp.dao.PolicyDao;
import kabilova.tu.inscorp.model.policy.GO;
import kabilova.tu.inscorp.model.policy.Kasko;
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

    public PolicyEP(PolicyDao dao) {
        this.dao = dao;
    }

    public PolicyEP(Policy policy, PolicyDao dao) {
        this.policy = policy;
        this.dao = dao;
    }

    public void create() { dao.create(policy); }

    public List<Policy> read() { return dao.read(); }

    public void update() { dao.update(policy); }

    public void delete() { dao.delete(policy); }

    public List<GO> loadActivePoliciesGO(Insured insured, Calendar currentDate) { return dao.loadActivePoliciesGO(insured, currentDate); }

    public List<Kasko> loadActivePoliciesKasko(Insured insured, Calendar currentDate) { return dao.loadActivePoliciesKasko(insured, currentDate); }
}
