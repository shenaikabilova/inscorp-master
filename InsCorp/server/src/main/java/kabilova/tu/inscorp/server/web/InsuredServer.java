package kabilova.tu.inscorp.server.web;

import kabilova.tu.inscorp.daoimpl.hb.UserDaoImpl;
import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscporp.bl.user.InsuredEP;

/**
 * Created by ShenaiKabilova
 */
public class InsuredServer extends UserServer {
    private InsuredEP insuredEP;

    public InsuredServer(Insured insured) {
        insuredEP = new InsuredEP(insured, new UserDaoImpl());
    }

    public Insured loadByEgn() {
        return insuredEP.loadByEgn();
    }
}
