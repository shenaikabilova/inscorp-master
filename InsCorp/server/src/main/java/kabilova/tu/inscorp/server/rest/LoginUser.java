package kabilova.tu.inscorp.server.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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

//        try {
//            return objectMapper.writeValueAsString(new UserDaoImpl().loadUser(username, password));
//            if (dao.loadUser(username, password) instanceof Admin) {
////                Admin admin = (Admin) dao.loadUser(username, password);
//                System.out.print(objectMapper.writeValueAsString(dao.loadUser(username, password)));
//                return objectMapper.writeValueAsString(dao.loadUser(username, password));
////            System.out.println(gson.toJson(admin, Admin.class));
////            return gson.toJson(admin, Admin.class);
//            } else if (dao.loadUser(username, password) instanceof Student) {
////                Student student = (Student) dao.loadUser(username, password);
////                System.out.println(gson.toJson(student));
////                return gson.toJson(student);
//                System.out.print(objectMapper.writeValueAsString(daol.loadUser(username, password)));
//                return objectMapper.writeValueAsString(dao.loadUser(username, password));
//            }
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
        return null;
    }
}
