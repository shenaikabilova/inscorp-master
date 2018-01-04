package kabilova.tu.inscporp.bl.user;

import exception.InsCorpException;
import kabilova.tu.inscorp.dao.VehicleDao;
import kabilova.tu.inscorp.model.vehicle.Vehicle;

import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public class VehicleEP {
    private Vehicle vehicle;
    private VehicleDao dao;

    public VehicleEP(VehicleDao dao) {
        this.dao = dao;
    }

    public VehicleEP(Vehicle vehicle, VehicleDao dao) {
        this.vehicle = vehicle;
        this.dao = dao;
    }

    public void create() throws InsCorpException{ dao.create(vehicle); }

    public List<Vehicle> read() { return dao.read(); }

    public void update() { dao.update(vehicle); }

    public void delete() { dao.delete(vehicle); }

    public Vehicle loadVehicle() { return dao.loadVehicle(vehicle.getRegNum()); }

    public List<Vehicle> loadVehicleByUser() { return dao.loadVehicleByUser(vehicle.getInsured()); }
}
