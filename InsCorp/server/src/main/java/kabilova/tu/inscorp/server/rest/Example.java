package kabilova.tu.inscorp.server.rest;

import kabilova.tu.inscorp.dao.PolicyDao;
import kabilova.tu.inscorp.daoimpl.hb.PolicyDaoImpl;
import kabilova.tu.inscorp.model.policy.Policy;
import kabilova.tu.inscorp.model.user.Insured;

import java.util.Calendar;

/**
 * Created by ShenaiKabilova
 */
public class Example {
    public static void main(String[] args) {
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

        Insured insured = new Insured();
        insured.setId(2);
        PolicyDao dao = new PolicyDaoImpl();
        for(Policy p : dao.loadActivePoliciesGO(insured, Calendar.getInstance())){
            System.out.println(p.getPolicaID());
        }

//        PolicyEP policyEP = new PolicyEP(new PolicyDaoImpl());
//        List<Policy> policies =  policyEP.loadActivePoliciesGO(insured, Calendar.getInstance());
//
//        for(Policy p : policyEP.loadActivePoliciesGO(insured, Calendar.getInstance())) {
//            System.out.println(p.getPolicaID());
//        }
    }
}
