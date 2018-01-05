package kabilova.tu.inscorp.server.web;

import kabilova.tu.inscorp.model.exception.InsCorpException;
import kabilova.tu.inscorp.daoimpl.hb.VehicleDaoImpl;
import kabilova.tu.inscorp.model.vehicle.Vehicle;
import kabilova.tu.inscorp.bl.user.VehicleEP;

import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public class VehicleServer {
    private VehicleEP vehicleEP;

    public VehicleServer() {
        vehicleEP = new VehicleEP(new Vehicle(), new VehicleDaoImpl());
    }

    public VehicleServer(Vehicle vehicle) {
        vehicleEP = new VehicleEP(vehicle, new VehicleDaoImpl());
    }

    public void create() throws InsCorpException { vehicleEP.create(); }

    public List<Vehicle> read() { return vehicleEP.read(); }

    public void update() { vehicleEP.update(); }

    public void delete() { vehicleEP.delete(); }

    public Vehicle loadVehicle() { return vehicleEP.loadVehicle(); }

}
