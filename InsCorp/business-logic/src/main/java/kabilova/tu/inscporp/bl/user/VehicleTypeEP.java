package kabilova.tu.inscporp.bl.user;

import exception.InsCorpException;
import kabilova.tu.inscorp.dao.CrudDao;
import kabilova.tu.inscorp.model.vehicle.VehicleType;

import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public class VehicleTypeEP {
    private VehicleType vehicleType;
    private CrudDao dao;

    public VehicleTypeEP(VehicleType vehicleType, CrudDao dao) {
        this.vehicleType = vehicleType;
        this.dao = dao;
    }

    public void create() throws InsCorpException{
        dao.create(vehicleType);
    }

    public List<VehicleType> read() {
        return dao.read();
    }

    public void update() {
        dao.update(vehicleType);
    }

    public void delete() {
        dao.delete(vehicleType);
    }
}
