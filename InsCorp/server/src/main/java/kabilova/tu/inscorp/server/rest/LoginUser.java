package kabilova.tu.inscorp.server.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kabilova.tu.inscorp.daoimpl.hb.UserDaoImpl;
import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscorp.bl.user.UserEP;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by ShenaiKabilova
 */
@Path("/loginUser")
public class LoginUser {
    @GET
    public String loginUser(@QueryParam("username") String username,
                            @QueryParam("password") String password) {
        ObjectMapper objectMapper = new ObjectMapper();

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

        UserEP userEP = new UserEP(new Insured(), new UserDaoImpl());
        try {
            return objectMapper.writeValueAsString(userEP.loadUser(username, String.format("%1$032x", passEncrypt)));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
