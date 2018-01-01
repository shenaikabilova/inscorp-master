package kabilova.tu.inscorp.server.web;

import kabilova.tu.inscorp.daoimpl.hb.TariffDaoImpl;
import kabilova.tu.inscorp.model.tariff.Tariff;
import kabilova.tu.inscorp.model.tariff.TariffGO;
import kabilova.tu.inscorp.model.tariff.TariffKasko;
import kabilova.tu.inscporp.bl.user.TariffEP;

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

    public void create() {
        tariffEP.create();
    }

    public List read() {
        return tariffEP.read();
    }

    public void update() {
        tariffEP.update();
    }

    public void delete() {
        tariffEP.delete();
    }
}