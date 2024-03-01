
package code;

import java.util.Arrays;
import java.util.Collection;

import code.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import code.Vehicle;
import org.mockito.Mockito;
import code.VehicleType;

import static org.junit.Assert.*;


public class VehicleTest {
    private Vehicle car_vehicle;
    private Vehicle van_vehicle;

    private Vehicle unavailable_vehicle;

    @Before
    public void setUp() {
        VehicleType car = new VehicleType(4);
        car_vehicle = new Vehicle("C_123", 2022, "Make", "Model", 0, car);
        DateTime dateTime = new DateTime();
        VehicleType van = new VehicleType(15, dateTime);
        van_vehicle = new Vehicle("V_123", 2022, "Make", "Model", 0, van);
        VehicleType unavailable = new VehicleType(4);
        unavailable_vehicle = new Vehicle("U_123", 2022, "Make", "Model", 2, unavailable);
    }

    @Test
    @DisplayName("Test should verify the behavior of get vehicle id for a car")
    public void testGetVehicleIdForCar() {
        assertEquals("C_123", car_vehicle.getVehicleId());
    }

    @Test
    @DisplayName("Test should verify the behavior of get vehicle id for a van")
    public void testGetVehicleIdForVan() {
        assertEquals("V_123", van_vehicle.getVehicleId());
    }

    @Test
    @DisplayName("Test should verify the behavior of rent for a car.Test should return true if car is rented successfully")
    public void testRentForCar1() {
        assertTrue(car_vehicle.rent("C_123", new DateTime(), 5));
    }
    @Test
    @DisplayName("Test should verify the behavior of rent for a car.Test should return false if car can't be rented")
    public void testRentForCar2() {
        assertFalse(car_vehicle.rent("C_123", new DateTime(), 14));
    }

    @Test
    @DisplayName("Test should verify the behavior of rent for a van.Test should return true if van is rented successfully")
    public void testRentForVan1() {
        assertTrue(van_vehicle.rent("V_123", new DateTime(), 5));
    }
    @Test
    @DisplayName("Test should verify the behavior of rent for a van.Test should return false if van can't be rented")
    public void testRentForVan2() {
        assertFalse(van_vehicle.rent("V_123", new DateTime(), 0));
    }
    @Test
    @DisplayName("Test should verify the behavior of rent for a van.Test should return false if vehicle is under maintenance")
    public void testRentForVan3() {
        assertFalse(unavailable_vehicle.rent("U_123", new DateTime(), 5));
    }

    @Test
    @DisplayName("Test should verify the behavior of perform maintenance for a car")
    public void testPerformMaintenance() {
        assertTrue(car_vehicle.performMaintenance());
    }

    @Test
    @DisplayName("Test should verify the behavior of perform maintenance for a van")
    public void testPerformMaintenanceForVan() {
        assertTrue(van_vehicle.performMaintenance());
    }

    @Test
    @DisplayName("Test should verify the behavior of perofmr maintenance for a vehicle which is already under maintenance")
    public void testPerformMaintenanceForUnavailableVehicle() {
        assertFalse(unavailable_vehicle.performMaintenance());
    }

    @Test
    @DisplayName("Test should verify the behavior of return vehicle for a car")
    public void testToStringForCar() {
        String expected = "C_123:2022:Make:Model:4:Available";
        assertEquals(expected, car_vehicle.toString());
    }

    @Test
    @DisplayName("Test should verify the behavior of return vehicle for a van")
    public void testToStringForVan() {
        String expected = "V_123:2022:Make:Model:15:Available";
        assertEquals(expected, van_vehicle.toString());
    }

    @Test
    @DisplayName("Test should verify the behavior of get details for a car")
    public void testGetDetailsForCar() {
        String expected = "Vehicle ID:\tC_123\n Year:\t 2022\n Make:\tMake\n Model:\tModel\n Number of Seats:\t4\n Status:\tAvailable";
        assertEquals(expected, car_vehicle.getDetails());
    }

    @Test
    @DisplayName("Test should verify the behavior of get details for a van")
    public void testGetDetailsForVan() {
        String expected = "Vehicle ID:\tV_123\n Year:\t 2022\n Make:\tMake\n Model:\tModel\n Number of Seats:\t15\n Status:\tAvailable";
        assertEquals(expected, van_vehicle.getDetails());
    }

    @Test
    @DisplayName("Test should verify the behavior of get last element index")
    public void testGetLastElementIndex() {
        assertEquals(-1, car_vehicle.getLastElementIndex());
        car_vehicle.rent("C_123", new DateTime(), 5);
        assertEquals(0, car_vehicle.getLastElementIndex());
    }
}
