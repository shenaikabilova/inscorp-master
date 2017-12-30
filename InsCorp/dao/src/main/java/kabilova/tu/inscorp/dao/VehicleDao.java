package kabilova.tu.inscorp.dao;

import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscorp.model.vehicle.Vehicle;

import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public interface VehicleDao extends CrudDao<Vehicle> {
    Vehicle loadVehicle(String regNumber);
    List<Vehicle> loadVehicleByUser(Insured insured);
}
