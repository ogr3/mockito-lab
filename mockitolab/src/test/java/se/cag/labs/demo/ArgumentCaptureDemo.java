package se.cag.labs.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import se.cag.labs.vehicle.Car;
import se.cag.labs.vehicle.Engine;
import se.cag.labs.vehicle.FuelTank;

public class ArgumentCaptureDemo {

    @Spy
    Engine engineSpy;

    @Spy
    FuelTank fuelSpy;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Demo att koden körs i det riktiga objektet
     */
    @Test
    public void shouldExecuteTheRealObjects() {

        // ArgumentCaptor here

        Car car = new Car(engineSpy, fuelSpy);
        car.fillItUp();

        // verify setFuel() with capture()
    }
}
