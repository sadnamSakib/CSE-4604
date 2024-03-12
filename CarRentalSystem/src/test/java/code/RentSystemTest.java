package code;


import org.junit.jupiter.api.*;
import org.junit.runners.MethodSorters;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class RentSystemTest {
    private static RentSystem rentSystem;
    private static Scanner scanner;

    @BeforeAll
    public static void setUp() {
        rentSystem = new RentSystem();
        scanner = new Scanner(System.in);
    }

    @Test
    @Order(1)
    public void testAddCar() {
        // Simulate user input for adding a car
        String input = "car\n2022\nToyota\nCorolla\n1\n4\n";
        scanner = new Scanner(input);
        rentSystem.add(scanner);

        // Check if the car was added
        // This assumes you have a method to get a car by its ID
        Car car = rentSystem.cars[0];
        String details = car.getDetails();
        String expected = "Vehicle ID:\tC_1\n Year:\t 2022\n Make:\tToyota\n Model:\tCorolla\n Number of Seats:\t4\n Status:\tAvailable\nRENTAL RECORD:\tempty";
        assertEquals(expected, details);

    }
    @Test
    @Order(2)
    public void testRentCar() {

        // Simulate user input for renting a car
        String inputCar = "C_1\n1\n10/03/2024\n2\n";
        Scanner scannerCar = new Scanner(inputCar);
        rentSystem.rent(scannerCar);

        // Check if the car was rented
        Car car = rentSystem.cars[0];
        assertEquals(1, car.vehicleStatus); // Assuming 1 is the status for rented vehicles

    }
    @Test
    @Order(3)
    public void testAddVan() {
        // Simulate user input for adding a van
        String input = "van\n2022\nToyota\nHiace\n1\n15\n11/03/2024\n";
        scanner = new Scanner(input);
        rentSystem.add(scanner);

        // Check if the van was added
        Van van = rentSystem.vans[0]; // Assuming the second van is at index 1
        String details = van.getDetails();
        String expected = "Vehicle ID:\tV_1\n Year:\t 2022\n Make:\tToyota\n Model:\tHiace\n Number of Seats:\t15\n Status:\tAvailable\nLast maintenance date:\t11/03/2024\nRENTAL RECORD:\tempty";
        assertEquals(expected, details);
    }
    @Test
    @Order(4)
    public void testRentVan() {

        // Simulate user input for renting a van
        String inputVan = "V_1\n1\n01/03/2024\n5\n";
        Scanner scannerVan = new Scanner(inputVan);
        rentSystem.rent(scannerVan);

        // Check if the van was rented
        Van van = rentSystem.vans[0];
        assertEquals(1, van.vehicleStatus); // Assuming 1 is the status for rented vehicles

    }
    @Test
    @Order(5)
    public void testReturnCar() {
        // Simulate user input for returning a car
        String inputCar = "C_1\n02/01/2022\n";
        Scanner scannerCar = new Scanner(inputCar);
        rentSystem.returnCar(scannerCar);

        // Check if the car was returned
        Car car = rentSystem.cars[0];
        assertEquals(1, car.vehicleStatus); // Assuming 0 is the status for available vehicles

        // Assuming 0 is the status for available vehicles
    }
    @Test
    @Order(6)
    public void testReturnVan() {
        // Simulate user input for returning a van
        String inputVan = "V_1\n20/03/2024\n";
        Scanner scannerVan = new Scanner(inputVan);
        rentSystem.returnCar(scannerVan);

        // Check if the van was returned
        Van van = rentSystem.vans[0];
        assertEquals(0, van.vehicleStatus); // Assuming 0 is the status for available vehicles
    }
    @Test
    @Order(7)
    public void testVehicleMaintenance() {
        // Simulate user input for setting a car to maintenance
        String inputCar = "C_1\n";
        Scanner scannerCar = new Scanner(inputCar);
        rentSystem.vehicleMaintenance(scannerCar);

        // Check if the car was set to maintenance
        Car car = rentSystem.cars[0];
        assertEquals(1, car.vehicleStatus); // Assuming 2 is the status for vehicles under maintenance

        // Simulate user input for setting a van to maintenance
        String inputVan = "V_1\n";
        Scanner scannerVan = new Scanner(inputVan);
        rentSystem.vehicleMaintenance(scannerVan);

        // Check if the van was set to maintenance
        Van van = rentSystem.vans[0];
        assertEquals(2, van.vehicleStatus); // Assuming 2 is the status for vehicles under maintenance
    }
    @Test
    @Order(8)
    public void testCompleteMaintenance() {
        // Simulate user input for completing maintenance of a car
        String inputCar = "C_1\n02/01/2022\n";
        Scanner scannerCar = new Scanner(inputCar);
        rentSystem.completeMaintenance(scannerCar);

        // Check if the car has completed maintenance
        Car car = rentSystem.cars[0];
        assertEquals(1, car.vehicleStatus); // Assuming 0 is the status for available vehicles

        // Simulate user input for completing maintenance of a van
        String inputVan = "V_1\n02/01/2022\n";
        Scanner scannerVan = new Scanner(inputVan);
        rentSystem.completeMaintenance(scannerVan);

        // Check if the van has completed maintenance
        Van van = rentSystem.vans[0];
        assertEquals(0, van.vehicleStatus); // Assuming 0 is the status for available vehicles
    }
    @Test
    @Order(9)
    public void testGetDetails() {

        // Capture the output of the getDetails method
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        rentSystem.getDetails();

        // Check if the output contains the details of the car and the van
        String output = outContent.toString();
        String expectedOutput = "***********Cars**********\nVehicle ID:\tC_1\n Year:\t 2022\n Make:\tToyota\n Model:\tCorolla\n Number of Seats:\t4\n Status:\tAvailable\nRENTAL RECORD:\tempty\n***********Vans**********\nVehicle ID:\tV_1\n Year:\t 2022\n Make:\tToyota\n Model:\tHiace\n Number of Seats:\t15\n Status:\tAvailable\nLast maintenance date:\t11/03/2024\nRENTAL RECORD:\tempty\n";
        assertEquals(expectedOutput,output);

    }


    // Similar tests can be written for other methods like rent, returnCar, vehicleMaintenance, completeMaintenance, getDetails
}