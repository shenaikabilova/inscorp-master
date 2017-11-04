package kabilova.tu.inscporp.bl.user;

import kabilova.tu.inscorp.dao.CrudDao;
import kabilova.tu.inscorp.model.vehicle.Vehicle;

import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public class VehicleEP {
    private Vehicle vehicle;
    private CrudDao dao;

    public VehicleEP(Vehicle vehicle, CrudDao dao) {
        this.vehicle = vehicle;
        this.dao = dao;
    }

    public void create() { dao.create(vehicle); }

    public List<Vehicle> read() { return dao.read(); }

    public void update() { dao.update(vehicle); }

    public void delete() { dao.delete(vehicle); }
}
