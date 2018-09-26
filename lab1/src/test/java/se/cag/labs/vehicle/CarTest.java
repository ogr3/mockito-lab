package se.cag.labs.vehicle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {

    private Car car;

    // Replace Engine & FuelTank for mocked objects
    private Engine engine;
    private FuelTank fuelTank;

    @BeforeEach
    public void setup() {

        //TODO: Ersätt Engine och FuelTank med mockar
        //fuelTank = Mockito.mock(FuelTank.class);
        //engine = Mockito.mock(Engine.class);

        engine = new Engine();
        fuelTank = new FuelTank();
        fuelTank.setFuel(65);


        car = new Car(engine, fuelTank);
    }

    /**
     * Övning 1. Byt utt Engine och FuelTank mot mockade objekt. Använd inte annotering för detta.
     *
     */

    /**
     * Övning 2. Byt utt Engine och FuelTank mot mockade objekt. Använd annotering för detta.
     *
     */



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