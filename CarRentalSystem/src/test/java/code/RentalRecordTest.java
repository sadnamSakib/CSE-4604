package code;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import code.DateTime;

public class RentalRecordTest {
    private RentalRecord rentalRecord;
    private DateTime dummyDate;


    @Before
    public void setUp() {
        dummyDate = new DateTime();
        rentalRecord = new RentalRecord("R_123", dummyDate, dummyDate);


    }


    @Test
    public void testGetEstimatedReturnDate() {
        assertEquals(dummyDate, rentalRecord.getEstimatedReturnDate());
    }

    @Test
    public void testGetRentDate() {
        assertEquals(dummyDate, rentalRecord.getRentDate());
    }

    @Test
    public void testToString() {
        String expected = "R_123:" + dummyDate.toString() + ":" + dummyDate.toString() + ":none:none:none";
        assertEquals(expected, rentalRecord.toString());
    }

    @Test
    public void testGetDetails() {
        String expected = "Record ID:             R_123\nRent Date:             " + dummyDate.toString() + "\nEstimated Return Date: " + new DateTime().toString();
        assertEquals(expected, rentalRecord.getDetails());
    }
}
