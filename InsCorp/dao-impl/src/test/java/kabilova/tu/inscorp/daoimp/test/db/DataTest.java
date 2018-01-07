package kabilova.tu.inscorp.daoimp.test.db;

import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscorp.model.user.Insurer;
import kabilova.tu.inscorp.model.vehicle.Vehicle;
import kabilova.tu.inscorp.model.vehicle.VehicleSubtype;
import kabilova.tu.inscorp.model.vehicle.VehicleType;

import java.util.Calendar;

/**
 * Created by ShenaiKabilova
 */
public class DataTest {
    public static Insurer getInsurerTest() {
        return new Insurer(1, 1234, "ins1", "ins1", "ins1", "username", "password", "123111", "mail@mail.vom");
    }

    public static Insured getInsuredTest() {
        return new Insured(1, "clientFirstName", "clientSecondName", "clientLastName", "user", "pass",
                "1111111111", 9000, "BG", "Varna", "Mladosr1", "123456", "client@gmail.com" );
    }

    public static Vehicle getVehicleTest() {
        return new Vehicle(1, getInsuredTest(), getVehicleTypeTest(), getVehicleSubtypeTest(), "B1234A",
                "BG", "Varna", "BG478AS4578ASDDF", "Audi", "A8",
                Calendar.getInstance(), 1, 1.6, "Black", 5, 2);
    }

    public static VehicleType getVehicleTypeTest() {
        return new VehicleType(1, "Car");
    }

    public static VehicleSubtype getVehicleSubtypeTest() {
        return new VehicleSubtype(1, getVehicleTypeTest(), "Sedan");
    }
}
