package kabilova.tu.inscorp.server.rest;

import com.google.gson.Gson;
import kabilova.tu.inscorp.model.policy.Policy;
import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscporp.bl.user.PolicyEP;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * Created by ShenaiKabilova
 */
@Path("/loadActivePolicies")
public class LoadActivePolicies {
    @POST
    public String loadActivePolicies(@QueryParam("user") int user) {
        Insured insured = new Insured();
        insured.setId(user);

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();

        PolicyEP policyEP = new PolicyEP();
        List<Policy> policies =  policyEP.loadActivePolicies(insured, calendar);

        Gson gson = new Gson();
        return gson.toJson(policies);
    }
}
