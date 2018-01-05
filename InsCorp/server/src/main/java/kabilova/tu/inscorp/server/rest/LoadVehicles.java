package kabilova.tu.inscorp.server.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import kabilova.tu.inscorp.daoimpl.hb.VehicleDaoImpl;
import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscorp.model.vehicle.Vehicle;
import kabilova.tu.inscorp.bl.user.VehicleEP;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

/**
 * Created by ShenaiKabilova
 */
@Path("/loadVehicles")
public class LoadVehicles {
    @POST
    public String loadVehicles(@FormParam("insured") int user) {
        Insured insured = new Insured();
        insured.setId(user);

        Vehicle vehicle = new Vehicle();
        vehicle.setInsured(insured);
        VehicleEP vehicleEP = new VehicleEP(vehicle, new VehicleDaoImpl());
        List<Vehicle> vehicles = vehicleEP.loadVehicleByUser();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        try {
            System.out.println(objectMapper.writerWithType(new TypeReference<List<Vehicle>>(){}).writeValueAsString(vehicles));
            return objectMapper.writerWithType(new TypeReference<List<Vehicle>>(){}).writeValueAsString(vehicles);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
