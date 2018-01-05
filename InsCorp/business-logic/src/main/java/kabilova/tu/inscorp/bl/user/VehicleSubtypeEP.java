package kabilova.tu.inscorp.bl.user;

import kabilova.tu.inscorp.model.exception.InsCorpException;
import kabilova.tu.inscorp.dao.CrudDao;
import kabilova.tu.inscorp.model.vehicle.VehicleSubtype;

import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public class VehicleSubtypeEP {
    private VehicleSubtype vehicleSubtype;
    private CrudDao dao;

    public VehicleSubtypeEP(VehicleSubtype vehicleSubtype, CrudDao dao) {
        this.vehicleSubtype = vehicleSubtype;
        this.dao = dao;
    }

    public void create() throws InsCorpException{
        dao.create(vehicleSubtype);
    }

    public List<VehicleSubtype> read() {
        return dao.read();
    }

    public void update() {
        dao.update(vehicleSubtype);
    }

    public void delete() {
        dao.delete(vehicleSubtype);
    }
}
