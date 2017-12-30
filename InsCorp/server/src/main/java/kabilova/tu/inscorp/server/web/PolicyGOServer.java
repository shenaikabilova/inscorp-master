package kabilova.tu.inscorp.server.web;

import kabilova.tu.inscorp.daoimpl.hb.PolicyDaoImpl;
import kabilova.tu.inscorp.model.policy.GO;
import kabilova.tu.inscorp.model.user.Insurer;
import kabilova.tu.inscporp.bl.user.PolicyEP;

import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public class PolicyGOServer extends PolicyServer {
    private PolicyEP policyEP;

    public PolicyGOServer() { }

    public PolicyGOServer (GO go){
        policyEP = new PolicyEP(go, new PolicyDaoImpl());
    }

    public List<GO> loadPoliciesGO(Insurer insurer) { return policyEP.loadPoliciesGO(insurer);}

    public List<GO> loadAllGo() { return policyEP.loadAllGO(); }
}
