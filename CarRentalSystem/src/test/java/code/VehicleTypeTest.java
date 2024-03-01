package code;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class VehicleTypeTest {
    private VehicleType carType;
    private VehicleType vanType;

    @Before
    public void setUp() {
        carType = new VehicleType(4);
        vanType = new VehicleType(15, new DateTime());
    }

    @Test
    public void testGetSeats() {
        assertEquals(4, carType.getSeats("car"));
        assertEquals(15, vanType.getSeats("van"));
    }

    @Test
    public void testGetCarSeats() {
        assertEquals(4, carType.getCarSeats());
    }

    @Test
    public void testSetCarSeats() {
        carType.setCarSeats(5);
        assertEquals(5, carType.getCarSeats());
    }

    @Test
    public void testGetLastMaintenance() {
        DateTime dateTime = new DateTime();
        vanType.setLastMaintenance(dateTime);
        assertEquals(dateTime, vanType.getLastMaintenance());
    }

    @Test
    public void testCanBeRentedForMinimumDays() {
        assertEquals(2, carType.canBeRentedForMinimumDays(new DateTime(2), "car"));
        assertEquals(1, vanType.canBeRentedForMinimumDays(new DateTime(1), "van"));
    }

    @Test
    public void testIsUnderMaintenance() {
        carType.setLastMaintenance(new DateTime());
        vanType.setLastMaintenance(new DateTime());
        assertFalse(carType.IsUnderMaintenance(new DateTime(), "car", 5));
        assertFalse(vanType.IsUnderMaintenance(new DateTime(), "van", 5));
    }
}
