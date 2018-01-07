package kabilova.tu.inscorp.server.web;

import kabilova.tu.inscorp.model.exception.InsCorpException;
import kabilova.tu.inscorp.daoimpl.hb.VehicleTypeDaoImpl;
import kabilova.tu.inscorp.model.vehicle.VehicleType;
import kabilova.tu.inscorp.bl.user.VehicleTypeEP;

import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public class VehicleTypeServer {
    private VehicleTypeEP vehicleTypeEP;
//    private VehicleType vehicleType;
//    private CrudDao<VehicleType> dao = new VehicleTypeDaoImpl();

    public VehicleTypeServer() {
//        vehicleType = new VehicleType();
        vehicleTypeEP = new VehicleTypeEP(new VehicleType(), new VehicleTypeDaoImpl());
    }

    public VehicleTypeServer(VehicleType vehicleType) {
//        this.vehicleType = vehicleType;
        vehicleTypeEP = new VehicleTypeEP(vehicleType, new VehicleTypeDaoImpl());
    }

    public void create() throws InsCorpException { vehicleTypeEP.create(); }

    public List<VehicleType> read() { return vehicleTypeEP.read(); }

    public void update() { vehicleTypeEP.update();}

    public void delete() throws InsCorpException { vehicleTypeEP.delete(); }

}
