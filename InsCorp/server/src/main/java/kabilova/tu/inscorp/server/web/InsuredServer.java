package kabilova.tu.inscorp.server.web;

import kabilova.tu.inscorp.daoimpl.hb.UserDaoImpl;
import kabilova.tu.inscorp.model.exception.InsCorpException;
import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscorp.bl.user.InsuredEP;

import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public class InsuredServer extends UserServer {
    private InsuredEP insuredEP;

    public InsuredServer(Insured insured) {
        super(insured);
        insuredEP = new InsuredEP(insured, new UserDaoImpl());
    }

    public Insured loadByEgn() throws InsCorpException {
        return insuredEP.loadByEgn();
    }

    public List<Insured> readInsured() { return insuredEP.readInsured(); }
}
