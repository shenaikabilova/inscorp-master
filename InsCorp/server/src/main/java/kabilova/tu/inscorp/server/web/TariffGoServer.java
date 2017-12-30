package kabilova.tu.inscorp.server.web;

import kabilova.tu.inscorp.daoimpl.hb.TariffDaoImpl;
import kabilova.tu.inscorp.model.tariff.TariffGO;
import kabilova.tu.inscporp.bl.user.TariffGoEP;

/**
 * Created by ShenaiKabilova
 */
public class TariffGoServer extends TariffServer {
    private TariffGoEP tariffGoEP;

    public TariffGoServer(TariffGO tariffGO) {
        this.tariffGoEP = new TariffGoEP(tariffGO, new TariffDaoImpl());
    }

    public TariffGO loadTariffGo() {
        return tariffGoEP.loadTariffGo();
    }

}