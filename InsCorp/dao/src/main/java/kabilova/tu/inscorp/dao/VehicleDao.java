package kabilova.tu.inscorp.dao;

import kabilova.tu.inscorp.model.vehicle.Vehicle;

/**
 * Created by ShenaiKabilova
 */
public interface VehicleDao extends CrudDao<Vehicle> {
    Vehicle loadVehicle(String regNumber);
}
