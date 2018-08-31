package se.cag.labs;

import org.junit.Before;
import org.junit.Test;

public class CarTest {

    private Car car;
    private Engine engine;
    private FuelTank fuelTank;

    @Before
    public void setup() {
        engine = new Engine();
        fuelTank = new FuelTank();
        fuelTank.setFuel(65);

        //TODO: Flytta in till facit
        //fuelTank = Mockito.mock(FuelTank.class);
        //fuelTank = Mockito.mock(FuelTank.class);

        car = new Car(engine, fuelTank);
    }

    @Test
    public void carShouldStart() {
        //TODO: Flytta in till facit
        //when(engine.isRunning()).thenReturn(false, true);
        //when(fuelTank.getFuel()).thenReturn(65);

        car.start();
    }

}