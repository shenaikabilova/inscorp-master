package kabilova.tu.inscorp.web.admin;

import kabilova.tu.inscorp.model.vehicle.VehicleSubtype;
import kabilova.tu.inscorp.model.vehicle.VehicleType;
import kabilova.tu.inscorp.server.web.VehicleSubtypeServer;

/**
 * Created by ShenaiKabilova
 */
public class Main {
    public static void main(String[] args) {
        VehicleType vehicleType = new VehicleType();
        vehicleType.setId(1);
        VehicleSubtype vehicleSubtype = new VehicleSubtype(vehicleType, "комби");
        VehicleSubtypeServer vehicleSubtypeServer = new VehicleSubtypeServer(vehicleSubtype);
        vehicleSubtypeServer.create();
    }
}
