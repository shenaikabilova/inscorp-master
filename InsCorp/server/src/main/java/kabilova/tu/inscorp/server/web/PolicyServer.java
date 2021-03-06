package kabilova.tu.inscorp.server.web;

import kabilova.tu.inscorp.model.exception.InsCorpException;
import kabilova.tu.inscorp.daoimpl.hb.PolicyDaoImpl;
import kabilova.tu.inscorp.model.policy.Policy;
import kabilova.tu.inscorp.bl.user.PolicyEP;

import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public class PolicyServer {
    private PolicyEP policyEP;

    public PolicyServer() { }

    public PolicyServer (Policy policy){
        policyEP = new PolicyEP(policy, new PolicyDaoImpl());
    }

    public void create() throws InsCorpException{ policyEP.create(); }

    public List<Policy> read() { return policyEP.read(); }

    public void update() { policyEP.update(); }

    public void delete() throws InsCorpException { policyEP.delete(); }

    public String getLastPolicyID() { return policyEP.getLastPolicyID(); }

    public Policy getPolicyByPolicyNum() throws InsCorpException { return policyEP.getPolicyByPolicyNum();}
}
