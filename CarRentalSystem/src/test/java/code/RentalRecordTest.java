package code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.Before;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.Random.class)
public class RentalRecordTest {
    private RentalRecord rentalRecord;
    private DateTime rentDate;
    private DateTime estimatedReturnDate;
    private DateTime actualReturnDate;

    @BeforeEach
    public void setUp() {
        rentDate = new DateTime(); // Add appropriate parameters if needed
        estimatedReturnDate = new DateTime(3); // Add appropriate parameters if needed
        this.rentalRecord = new RentalRecord("RentId1", rentDate, estimatedReturnDate);
    }

    @Test
    public void testConstructor() {
        assertEquals(rentDate, rentalRecord.getRentDate());
        assertEquals(estimatedReturnDate, rentalRecord.getEstimatedReturnDate());
    }



    @Test
    public void testToString() {
        String expected = "RentId1:" + rentDate.toString() + ":" + estimatedReturnDate.toString() + ":none:none:none";
        assertEquals(expected, rentalRecord.toString());
    }

    @Test
    public void testGetDetails() {
        String expected = "Record ID:             RentId1\nRent Date:             " + rentDate.toString() + "\nEstimated Return Date: " + estimatedReturnDate.toString();
        assertEquals(expected, rentalRecord.getDetails());
    }
}