package code;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RentSystemTest {

    private RentSystem rentSystem;
    private Car mockCar;
    private Van mockVan;
    private Scanner mockScanner;

    @Before
    public void setUp() {
        rentSystem = new RentSystem();
        mockCar = Mockito.mock(Car.class);
        mockVan = Mockito.mock(Van.class);
        rentSystem.run();
    }

    @Test
    public void testRun() {
        // Create a mock Scanner
        Scanner mockScanner = Mockito.mock(Scanner.class);

        // Define the behavior of the mock Scanner
        when(mockScanner.nextLine()).thenReturn("1", "7");

        // Use reflection to set the Scanner in the RentSystem class
        try {
            Field scannerField = RentSystem.class.getDeclaredField("sc");
            ((Field) scannerField).setAccessible(true);
            scannerField.set(rentSystem, mockScanner);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // Run the method
        rentSystem.run();

        // Verify that the add method was called once
        verify(rentSystem, times(1)).add(any(Scanner.class));
    }

}
