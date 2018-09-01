package se.cag.labs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {

    private Car car;

    // Replace Engine & FuelTank for mocked objects
    private Engine engine;
    private FuelTank fuelTank;

    @BeforeEach
    public void setup() {
        engine = new Engine();
        fuelTank = new FuelTank();
        fuelTank.setFuel(65);

        //TODO: Flytta in till facit
        //fuelTank = Mockito.mock(FuelTank.class);
        //fuelTank = Mockito.mock(FuelTank.class);

        car = new Car(engine, fuelTank);
    }

    /**
     * Tests that the car can be started without any exceptions
     */
    @Test
    public void carShouldStart() {
        //TODO: Flytta in till facit
        //when(engine.isRunning()).thenReturn(false, true);
        //when(fuelTank.getFuel()).thenReturn(65);

        car.start();
    }

}