package code;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.sql.Date;
import java.text.SimpleDateFormat;
import code.DateTime;

public class DateTimeTest {
    private DateTime dateTime;

    @Before
    public void setUp() {
        dateTime = new DateTime();
    }

    @Test
    public void testGetTime() {
        long expected = System.currentTimeMillis();
        long actual = dateTime.getTime();
        assertEquals(expected, actual, 1000); // Allow 1 second difference
    }

    @Test
    public void testGetNameOfDay() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        String expected = sdf.format(new Date(System.currentTimeMillis()));
        String actual = dateTime.getNameOfDay();
        assertEquals(expected, actual);
    }

    @Test
    public void testToString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String expected = sdf.format(new Date(System.currentTimeMillis()));
        String actual = dateTime.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetFormattedDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String expected = sdf.format(new Date(System.currentTimeMillis()));
        String actual = dateTime.getFormattedDate();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetEightDigitDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        String expected = sdf.format(new Date(System.currentTimeMillis()));
        String actual = dateTime.getEightDigitDate();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetCurrentTime() {
        Date date = new Date(System.currentTimeMillis());
        String expected = date.toString();
        String actual = DateTime.getCurrentTime();
        assertEquals(expected, actual);
    }
}