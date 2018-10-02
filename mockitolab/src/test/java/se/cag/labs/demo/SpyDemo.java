package se.cag.labs.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import se.cag.labs.vehicle.Car;
import se.cag.labs.vehicle.Engine;
import se.cag.labs.vehicle.FuelTank;

public class SpyDemo {

    @Spy
    Engine engineSpy;

    @Spy
    FuelTank fuelSpy;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * När man använder Spy kommer koden i objektet att köras.
     */
    @Test
    public void should_ExecuteTheRealObject() {

        // Set fuel i spy

        Car car = new Car(engineSpy, fuelSpy);
        car.start();

        // Verifiera att Engine.stop() inte anropats
    }


    /**
     * När man använder Spy kommer koden i objektet att köras.
     *
     * MEN, det går att undvikas...
     *
     */
    @Test
    public void shouldNot_ExecuteTheRealObject() {

        // Set fuel i spy

        // doReturn
        Car car = new Car(engineSpy, fuelSpy);

        car.start();

        // Verifiera att Engine.stop() inte anropats
    }
}
