import kabilova.tu.inscorp.dao.CrudDao;
import kabilova.tu.inscorp.daoimpl.hb.VehicleSubtypeDaoImpl;
import kabilova.tu.inscorp.model.user.Admin;
import kabilova.tu.inscorp.model.vehicle.VehicleSubtype;

/**
 * Created by ShenaiKabilova
 */
public class Main {
    public static void main(String[] args) {
//        Admin admin = new Admin(1, "Admin", "Admin", "Admin", "admin", "admin");
//        kabilova.tu.inscorp.dao.UserDao dao = new kabilova.tu.inscorp.daoimpl.hb.UserDaoImpl();
//        dao.create(admin);

        CrudDao<VehicleSubtype> dao = new VehicleSubtypeDaoImpl();
        for(VehicleSubtype vehicleSubtype: dao.read()){
            System.out.println(vehicleSubtype.getId() + " " + vehicleSubtype.getVehicleType().getVehicleType() + " " + vehicleSubtype.getSubtype());
        }
    }
}
