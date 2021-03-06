package kabilova.tu.inscorp.bl.user;

import kabilova.tu.inscorp.dao.TariffDao;
import kabilova.tu.inscorp.model.tariff.TariffKasko;

import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public class TariffKaskoEP extends TariffEP {
    private TariffKasko tariffKasko;
    private TariffDao dao;

    public TariffKaskoEP(TariffKasko tariffKasko, TariffDao dao){
        this.tariffKasko = tariffKasko;
        this.dao = dao;
    }

    public TariffKasko loadTariffKasko() {
        return dao.loadTariffkasko(tariffKasko.getVehicleSubtype());
    }

    public List<TariffKasko> loadAllTariffKaskos() { return dao.readAllTariffKasko(); }
}
