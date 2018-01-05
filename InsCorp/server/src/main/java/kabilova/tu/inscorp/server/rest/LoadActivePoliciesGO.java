package kabilova.tu.inscorp.server.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscorp.daoimpl.hb.PolicyDaoImpl;
import kabilova.tu.inscorp.model.policy.GO;
import kabilova.tu.inscorp.model.policy.Policy;
import kabilova.tu.inscorp.bl.user.PolicyEP;

import javax.ws.rs.*;
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
