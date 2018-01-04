import exception.InsCorpException;
import kabilova.tu.inscorp.dao.CrudDao;
import kabilova.tu.inscorp.dao.PolicyDao;
import kabilova.tu.inscorp.dao.UserDao;
import kabilova.tu.inscorp.dao.VehicleDao;
import kabilova.tu.inscorp.daoimpl.hb.PolicyDaoImpl;
import kabilova.tu.inscorp.daoimpl.hb.UserDaoImpl;
import kabilova.tu.inscorp.daoimpl.hb.VehicleDaoImpl;
import kabilova.tu.inscorp.daoimpl.hb.VehicleSubtypeDaoImpl;
import kabilova.tu.inscorp.model.policy.GO;
import kabilova.tu.inscorp.model.policy.Policy;
import kabilova.tu.inscorp.model.user.Admin;
import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscorp.model.user.Insurer;
import kabilova.tu.inscorp.model.user.User;
import kabilova.tu.inscorp.model.vehicle.Vehicle;
import kabilova.tu.inscorp.model.vehicle.VehicleSubtype;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ShenaiKabilova
 */
public class Main {
    public static void main(String[] args) {
//        Admin admin = new Admin(1, "Admin", "Admin", "Admin", "admin", "admin");
//        kabilova.tu.inscorp.dao.UserDao dao = new kabilova.tu.inscorp.daoimpl.hb.UserDaoImpl();
//        try {
//            dao.create(new Insurer(1111, "a","a","a","username","pass","124","meil"));
//        } catch (InsCorpException e) {
//            e.printStackTrace();
//        }
//        dao.create(admin);
//
//        UserDao dao = new UserDaoImpl();
//        Insurer insurer = new Insurer();
//        insurer.setId(5);
//        insurer.setPhoneNumber("555");
//        dao.delete(insurer);
//        System.out.println(dao.loadByUsername("1111"));

//        Insured insured = new Insured();
//        insured.setId(2);
//        VehicleDao dao = new VehicleDaoImpl();
//        for(Vehicle v : dao.loadVehicleByUser(insured)) {
//            System.out.println(v.getVehicleID());
//        }

//        Insurer insurer = new Insurer();
//        insurer.setId(3);
//        PolicyDao dao = new PolicyDaoImpl();
//        for(GO go : dao.loadPoliciesGO(insurer)){
//            System.out.println(go.getVehicle().getVehicleID());
//        }
////
//        GO go = (GO) dao.getPolicaByPolicaNum("000001");
//        System.out.println("last policyID: " + go.getPolicaID());
    }
}
