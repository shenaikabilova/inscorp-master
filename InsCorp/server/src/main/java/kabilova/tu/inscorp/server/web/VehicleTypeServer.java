package kabilova.tu.inscorp.server.web;

import kabilova.tu.inscorp.dao.CrudDao;
import kabilova.tu.inscorp.daoimpl.hb.VehicleTypeDaoImpl;
import kabilova.tu.inscorp.model.vehicle.VehicleType;

import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public class VehicleTypeServer {
    private VehicleType vehicleTypeEP;
    private VehicleType vehicleType;
    private CrudDao<VehicleType> dao = new VehicleTypeDaoImpl();

    public VehicleTypeServer() {
        vehicleType = new VehicleType();
    }

    public VehicleTypeServer(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void create() { dao.create(vehicleType); }

    public List<VehicleType> read() { return dao.read(); }

    public void update() { dao.update(vehicleType);}
}
