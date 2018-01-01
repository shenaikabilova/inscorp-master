package kabilova.tu.inscporp.bl.user;

import kabilova.tu.inscorp.dao.TariffDao;
import kabilova.tu.inscorp.model.tariff.TariffGO;

import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public class TariffGoEP extends TariffEP {
    private TariffGO tariffGO;
    private TariffDao dao;

    public TariffGoEP(TariffGO tariffGO, TariffDao dao){
        this.tariffGO = tariffGO;
        this.dao = dao;
    }

    public TariffGO loadTariffGo() {
        return dao.loadTariffGo(tariffGO.getVehicleSubtype(), tariffGO.getZone());
    }

    public List<TariffGO> loadAllTariffGO() { return dao.readAllTariffGo(); }
}
