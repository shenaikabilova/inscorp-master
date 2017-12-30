package kabilova.tu.inscorp.dao;

import kabilova.tu.inscorp.model.tariff.Tariff;
import kabilova.tu.inscorp.model.tariff.TariffGO;
import kabilova.tu.inscorp.model.tariff.TariffKasko;
import kabilova.tu.inscorp.model.vehicle.VehicleSubtype;

/**
 * Created by ShenaiKabilova
 */
public interface TariffDao extends CrudDao<Tariff> {
    TariffGO loadTariffGo(VehicleSubtype vehicleSubtype, int zone);
    TariffKasko loadTariffkasko(VehicleSubtype vehicleSubtype);
}
