package kabilova.tu.inscorp.bl.user;

import kabilova.tu.inscorp.model.exception.InsCorpException;
import kabilova.tu.inscorp.dao.PolicyDao;
import kabilova.tu.inscorp.model.policy.GO;
import kabilova.tu.inscorp.model.policy.Kasko;
import kabilova.tu.inscorp.model.policy.Policy;
import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscorp.model.user.User;

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

    public void create() throws InsCorpException { dao.create(policy); }

    public List<Policy> read() { return dao.read(); }

    public void update() { dao.update(policy); }

    public void delete() throws InsCorpException { dao.delete(policy); }

    public List<GO> loadActivePoliciesGO(Insured insured, Calendar currentDate) { return dao.loadActivePoliciesGO(insured, currentDate); }

    public List<Kasko> loadActivePoliciesKasko(Insured insured, Calendar currentDate) { return dao.loadActivePoliciesKasko(insured, currentDate); }

    public List<GO> loadPoliciesGO(User user) throws InsCorpException { return dao.loadPoliciesGO(user); }

    public List<Kasko> loadPoliciesKasko(User user) throws InsCorpException { return dao.loadPoliciesKasko(user); }

    public List<GO> loadAllGO() throws InsCorpException { return dao.loadAllGO(); }

    public List<Kasko> loadAllKasko() { return dao.loadAllKasko(); }

    public String getLastPolicyID() { return dao.getLastPolicyID(); }

    public Policy getPolicyByPolicyNum() throws InsCorpException { return dao.getPolicaByPolicaNum(policy.getPolicaID()); }
}
