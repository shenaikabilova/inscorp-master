package kabilova.tu.inscorp.server.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kabilova.tu.inscorp.daoimpl.hb.UserDaoImpl;
import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscporp.bl.user.UserEP;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * Created by ShenaiKabilova
 */
@Path("/loginUser")
public class LoginUser {
    @GET
    public String loginUser(@QueryParam("username") String username,
                            @QueryParam("password") String password) {
        ObjectMapper objectMapper = new ObjectMapper();

        UserEP userEP = new UserEP(new Insured(), new UserDaoImpl());
        try {
            return objectMapper.writeValueAsString(userEP.loadUser(username, password));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
