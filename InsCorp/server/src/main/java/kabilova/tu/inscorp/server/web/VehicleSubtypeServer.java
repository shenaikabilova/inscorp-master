package kabilova.tu.inscorp.server.web;

import exception.InsCorpException;
import kabilova.tu.inscorp.daoimpl.hb.VehicleSubtypeDaoImpl;
import kabilova.tu.inscorp.model.vehicle.VehicleSubtype;
import kabilova.tu.inscorp.model.vehicle.VehicleType;
import kabilova.tu.inscporp.bl.user.VehicleSubtypeEP;

import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public class VehicleSubtypeServer {
    private VehicleSubtypeEP vehicleSubtypeEP;

    public VehicleSubtypeServer() {
        vehicleSubtypeEP = new VehicleSubtypeEP(new VehicleSubtype(), new VehicleSubtypeDaoImpl());
    }

    public VehicleSubtypeServer(VehicleSubtype vehicleSubtype) {
        vehicleSubtypeEP = new VehicleSubtypeEP(vehicleSubtype, new VehicleSubtypeDaoImpl());
    }

    public void create() throws InsCorpException { vehicleSubtypeEP.create(); }

    public List<VehicleSubtype> read() { return vehicleSubtypeEP.read(); }

    public void update() { vehicleSubtypeEP.update();}

    public void delete() { vehicleSubtypeEP.delete(); }

}
