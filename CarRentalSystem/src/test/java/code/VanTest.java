package code;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@TestMethodOrder(MethodOrderer.Random.class)
public class VanTest {
    private Van van;
    private VehicleType vehicleType;

    @Before
    public void setUp() {
        vehicleType = new VehicleType(15, new DateTime());
        van = new Van("V_123", 2022, "Make", "Model", 0, vehicleType);
    }

    @Test
    @DisplayName("Test should check the late fee for a van")
    public void testGetLateFee() {
        DateTime expected_returnDay = new DateTime(1);
        DateTime actual_returnDay = new DateTime(3);
        van.rent("V_123", new DateTime(), 1);
        van.returnVehicle(actual_returnDay);
        double expected_fee = 299*2;
        assertEquals(expected_fee, van.getLateFee(actual_returnDay,expected_returnDay), 0.001);
    }

    @Test
    @DisplayName("Test should check the late fee for a van when a late fee should not be charged")
    public void testGetLateFee2() {
        DateTime expected_returnDay = new DateTime(2);
        DateTime actual_returnDay = new DateTime(1);
        van.rent("V_123", new DateTime(), 1);
        van.returnVehicle(actual_returnDay);
        double expected_fee = 0;
        assertEquals(expected_fee, van.getLateFee(actual_returnDay,expected_returnDay), 0.001);
    }

    @Test
    public void testReturnVehicle() {
        assertFalse(van.returnVehicle(new DateTime()));
    }

    @Test
    public void testCompleteMaintenance() {
        assertFalse(van.completeMaintenance(new DateTime()));
    }

    @Test
    public void testToString() {
        String expected = "V_123:2022:Make:Model:15:Available:" + vehicleType.getLastMaintenance().toString();
        assertEquals(expected, van.toString());
    }

    @Test
    public void testGetDetails() {
        String expected = "Vehicle ID:\tV_123\n Year:\t 2022\n Make:\tMake\n Model:\tModel\n Number of Seats:\t15\n Status:\tAvailable\nLast maintenance date:\t" + vehicleType.getLastMaintenance().toString() + "\nRENTAL RECORD:\tempty";
        assertEquals(expected, van.getDetails());
    }
}
