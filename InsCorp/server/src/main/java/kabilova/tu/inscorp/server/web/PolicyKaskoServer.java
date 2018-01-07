package kabilova.tu.inscorp.server.web;

import kabilova.tu.inscorp.daoimpl.hb.PolicyDaoImpl;
import kabilova.tu.inscorp.model.exception.InsCorpException;
import kabilova.tu.inscorp.model.policy.GO;
import kabilova.tu.inscorp.model.policy.Kasko;
import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscorp.model.user.Insurer;
import kabilova.tu.inscorp.bl.user.PolicyEP;

import java.util.Calendar;
import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public class PolicyKaskoServer extends PolicyServer {
    private PolicyEP policyEP;

    public PolicyKaskoServer() { }

    public PolicyKaskoServer (Kasko kasko){
        super(kasko);
        policyEP = new PolicyEP(kasko, new PolicyDaoImpl());
    }

    public List<Kasko> loadPoliciesKasko(Insurer insurer) throws InsCorpException { return policyEP.loadPoliciesKasko(insurer);}

    public List<Kasko> loadAllKasko() { return policyEP.loadAllKasko(); }

    public List<Kasko> loadActivePoliciesKasko(Insured insured, Calendar currentDate) {
        return policyEP.loadActivePoliciesKasko(insured, currentDate);
    }
}
