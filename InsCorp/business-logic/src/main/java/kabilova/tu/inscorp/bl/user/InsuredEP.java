package kabilova.tu.inscorp.bl.user;

import kabilova.tu.inscorp.dao.UserDao;
import kabilova.tu.inscorp.model.exception.InsCorpException;
import kabilova.tu.inscorp.model.user.Insured;

import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public class InsuredEP extends UserEP {
    private Insured insured;
    private UserDao dao;

    public InsuredEP(Insured insured, UserDao dao) {
        this.insured = insured;
        this.dao = dao;
    }

    public Insured loadByEgn () throws InsCorpException {
        return (Insured) dao.loadByEGN(insured.getEgn());
    }

    public List<Insured> readInsured() { return dao.readInsured(); }
}
