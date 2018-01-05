package kabilova.tu.inscorp.server.web;

import kabilova.tu.inscorp.daoimpl.hb.PolicyDaoImpl;
import kabilova.tu.inscorp.model.policy.Kasko;
import kabilova.tu.inscorp.model.user.Insurer;
import kabilova.tu.inscorp.bl.user.PolicyEP;

import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public class PolicyKaskoServer extends PolicyServer {
    private PolicyEP policyEP;

    public PolicyKaskoServer() { }

    public PolicyKaskoServer (Kasko kasko){
        policyEP = new PolicyEP(kasko, new PolicyDaoImpl());
    }

    public List<Kasko> loadPoliciesKasko(Insurer insurer) { return policyEP.loadPoliciesKasko(insurer);}

    public List<Kasko> loadAllKasko() { return policyEP.loadAllKasko(); }
}
