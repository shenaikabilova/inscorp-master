package kabilova.tu.inscorp.server.web;

import kabilova.tu.inscorp.model.exception.InsCorpException;
import kabilova.tu.inscorp.daoimpl.hb.TariffDaoImpl;
import kabilova.tu.inscorp.model.tariff.Tariff;
import kabilova.tu.inscorp.bl.user.TariffEP;

import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public class TariffServer {
    private TariffEP tariffEP;

    public TariffServer() {}

    public TariffServer(Tariff tariff){
        tariffEP = new TariffEP(tariff, new TariffDaoImpl());
    }

    public void create() throws InsCorpException {
        tariffEP.create();
    }

    public List read() {
        return tariffEP.read();
    }

    public void update() {
        tariffEP.update();
    }

    public void delete() throws InsCorpException {
        tariffEP.delete();
    }
}
