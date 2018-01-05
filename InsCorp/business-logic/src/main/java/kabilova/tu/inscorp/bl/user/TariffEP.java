package kabilova.tu.inscorp.bl.user;

import kabilova.tu.inscorp.model.exception.InsCorpException;
import kabilova.tu.inscorp.dao.TariffDao;
import kabilova.tu.inscorp.model.tariff.Tariff;

import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public class TariffEP {
    private Tariff tariff;
    private TariffDao dao;

    public TariffEP() { }

    public TariffEP(Tariff tariff, TariffDao dao){
        this.tariff = tariff;
        this.dao = dao;
    }

    public void create() throws InsCorpException{
        dao.create(tariff);
    }

    public List read() {
        return dao.read();
    }

    public void update() {
        dao.update(tariff);
    }

    public void delete() {
        dao.delete(tariff);
    }
}
