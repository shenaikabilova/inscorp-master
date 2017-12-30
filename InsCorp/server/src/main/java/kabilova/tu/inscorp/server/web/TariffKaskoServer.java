package kabilova.tu.inscorp.server.web;

import kabilova.tu.inscorp.daoimpl.hb.TariffDaoImpl;
import kabilova.tu.inscorp.model.tariff.TariffKasko;
import kabilova.tu.inscporp.bl.user.TariffKaskoEP;

/**
 * Created by ShenaiKabilova
 */
public class TariffKaskoServer {
    private TariffKaskoEP tariffKaskoEP;

    public TariffKaskoServer(TariffKasko tariffKasko) {
        this.tariffKaskoEP = new TariffKaskoEP(tariffKasko, new TariffDaoImpl());
    }

    public TariffKasko loadTariffkasko() {
        return tariffKaskoEP.loadTariffKasko();
    }
}
