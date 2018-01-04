package kabilova.tu.inscorp.server.rest;

import kabilova.tu.inscorp.dao.PolicyDao;
import kabilova.tu.inscorp.daoimpl.hb.PolicyDaoImpl;
import kabilova.tu.inscorp.model.policy.Policy;
import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscorp.model.vehicle.VehicleSubtype;
import kabilova.tu.inscorp.model.vehicle.VehicleType;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Created by ShenaiKabilova
 */
public class Example {
    public static void main(String[] args) {
        String password = "1111";
        MessageDigest m;
        BigInteger passEncrypt = null;
        try {
            m = MessageDigest.getInstance("MD5");
            m.update(password.getBytes(), 0, password.length());
            passEncrypt = new BigInteger(1, m.digest());
            System.out.println(String.format("%1$032x", passEncrypt));
        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        }
//        VehicleType v1 = new VehicleType("v1");
//        VehicleType v2 = new VehicleType("v2");
//        VehicleType v3 = new VehicleType("v3");
//        VehicleType v4 = new VehicleType("v4");
//        VehicleType v5 = new VehicleType("v5");
//
//        VehicleSubtype vs1 = new VehicleSubtype(v1, "v1-1");
//        VehicleSubtype vs2 = new VehicleSubtype(v5, "v5-1");
//        VehicleSubtype vs3 = new VehicleSubtype(v4, "v4-1");
//        VehicleSubtype vs4 = new VehicleSubtype(v4, "v4-2");
//        VehicleSubtype vs5 = new VehicleSubtype(v1, "v1-2");
//        VehicleSubtype vs6 = new VehicleSubtype(v2, "v2-1");
//        VehicleSubtype vs7 = new VehicleSubtype(v3, "v3-1");
//        VehicleSubtype vs8 = new VehicleSubtype(v1, "v1-1");
//
//        List<VehicleSubtype> vehicleSubtypes = new ArrayList<>();
//        vehicleSubtypes.add(vs1);
//        vehicleSubtypes.add(vs2);
//        vehicleSubtypes.add(vs3);
//        vehicleSubtypes.add(vs4);
//        vehicleSubtypes.add(vs5);
//        vehicleSubtypes.add(vs6);
//        vehicleSubtypes.add(vs7);
//        vehicleSubtypes.add(vs8);
//
//        Map<VehicleType, List<VehicleSubtype>> map = new HashMap<>();
//        for(VehicleSubtype v : vehicleSubtypes){
//            map.computeIfAbsent(v.getVehicleType(), k->new ArrayList<>()).add(v);
//        }
//
//        Iterator<Map.Entry<VehicleType, List<VehicleSubtype>>> entries = map.entrySet().iterator();
//        while (entries.hasNext()) {
//            Map.Entry<VehicleType, List<VehicleSubtype>> entry = entries.next();
//            System.out.println(entry.getKey().getVehicleType());
//
//            for(VehicleSubtype vs : entry.getValue()) {
//                System.out.println(vs.getSubtype());
//            }
//        }

//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
////        Calendar calendar = Calendar.getInstance().getTime();
//        String s = dateFormat.format(Calendar.getInstance().getTime());
//        Date d = null ;
//        try {
//            d = dateFormat.parse(dateFormat.format(Calendar.getInstance().getTime()).toString());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        System.out.println(s + " " + d);
//
//
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        Calendar calendarDate = Calendar.getInstance();
//        if (calendarDate!= null) {
//            System.out.println(sdf.format(calendarDate.getTime()));
//        }
//
//        Date date = new Date();
//        System.out.println(date.getTime());

//        Insured insured = new Insured();
//        insured.setId(2);
//        PolicyDao dao = new PolicyDaoImpl();
//        for(Policy p : dao.loadActivePoliciesGO(insured, Calendar.getInstance())){
//            System.out.println(p.getPolicaID());
//        }

//        PolicyEP policyEP = new PolicyEP(new PolicyDaoImpl());
//        List<Policy> policies =  policyEP.loadActivePoliciesGO(insured, Calendar.getInstance());
//
//        for(Policy p : policyEP.loadActivePoliciesGO(insured, Calendar.getInstance())) {
//            System.out.println(p.getPolicaID());
//        }
    }
}
