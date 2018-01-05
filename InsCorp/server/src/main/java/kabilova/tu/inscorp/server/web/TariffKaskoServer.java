package kabilova.tu.inscorp.server.web;

import kabilova.tu.inscorp.daoimpl.hb.TariffDaoImpl;
import kabilova.tu.inscorp.model.tariff.TariffKasko;
import kabilova.tu.inscorp.bl.user.TariffKaskoEP;

import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public class TariffKaskoServer {
    private TariffKaskoEP tariffKaskoEP;

    public TariffKaskoServer(TariffKasko tariffKasko) {
        this.tariffKaskoEP = new TariffKaskoEP(tariffKasko, new TariffDaoImpl());
    }

    public List<TariffKasko> loadAllTariffKasko() { return tariffKaskoEP.loadAllTariffKaskos(); }

    public TariffKasko loadTariffkasko() {
        return tariffKaskoEP.loadTariffKasko();
    }
}
