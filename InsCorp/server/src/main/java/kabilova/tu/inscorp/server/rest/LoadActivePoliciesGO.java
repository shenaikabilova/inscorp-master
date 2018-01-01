package kabilova.tu.inscorp.server.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import kabilova.tu.inscorp.daoimpl.hb.PolicyDaoImpl;
import kabilova.tu.inscorp.model.policy.GO;
import kabilova.tu.inscorp.model.policy.Policy;
import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscporp.bl.user.PolicyEP;
import org.codehaus.jettison.json.JSONException;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by ShenaiKabilova
 */
@Path("/loadActivePoliciesGO")
public class LoadActivePoliciesGO {
    @POST
    public String loadActivePoliciesGO(@FormParam("insured") int user) {
        Insured insured = new Insured();
        insured.setId(user);

        System.out.println(user);

        PolicyEP policyEP = new PolicyEP(new PolicyDaoImpl());
        List<GO> policies =  policyEP.loadActivePoliciesGO(insured, Calendar.getInstance());
//
//        for(Policy p : )) {
//            System.out.println(p.getPolicaID());
//            policies.add(p);
//        }


//        GsonBuilder gsonBuilder = new GsonBuilder();
//        gsonBuilder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
//        Gson gson = gsonBuilder.create();
//        try {
//            System.out.println(gson.toJson(policies));
//            return gson.toJson(policies);
//        } catch (JsonParseException e) {
//            System.out.println(e.getMessage());
//        }
//        return null;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        try {
            System.out.println(objectMapper.writerWithType(new TypeReference<List<Policy>>(){}).writeValueAsString(policies));
            return objectMapper.writerWithType(new TypeReference<List<Policy>>(){}).writeValueAsString(policies);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}