package kabilova.tu.inscorp.server.web;

import kabilova.tu.inscorp.daoimpl.hb.PolicyDaoImpl;
import kabilova.tu.inscorp.model.exception.InsCorpException;
import kabilova.tu.inscorp.model.policy.GO;
import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscorp.model.user.Insurer;
import kabilova.tu.inscorp.bl.user.PolicyEP;

import java.util.Calendar;
import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public class PolicyGOServer extends PolicyServer {
    private PolicyEP policyEP;

    public PolicyGOServer() { }

    public PolicyGOServer (GO go){
        super(go);
        policyEP = new PolicyEP(go, new PolicyDaoImpl());
    }

    public List<GO> loadPoliciesGO(Insurer insurer) throws InsCorpException { return policyEP.loadPoliciesGO(insurer);}

    public List<GO> loadAllGo() throws InsCorpException { return policyEP.loadAllGO(); }

    public List<GO> loadActivePoliciesGO(Insured insured, Calendar currentDate) {
        return policyEP.loadActivePoliciesGO(insured, currentDate);
    }
}
