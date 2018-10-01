package se.cag.labs.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import se.cag.labs.vehicle.Car;
import se.cag.labs.vehicle.Engine;
import se.cag.labs.vehicle.FuelTank;

import static org.mockito.Mockito.*;

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
     * Demo att koden körs i det riktiga objektet
     */
    @Test
    public void shouldExecuteTheRealObjects() {

        fuelSpy.setFuel(44);

        Car car = new Car(engineSpy, fuelSpy);

        car.start();

        verify(engineSpy, times(0)).stop();
    }


    /**
     * Demo att koden INTE körs i det riktiga objektet
     */
    @Test
    public void spyWithMock() {
        fuelSpy.setFuel(44);

        when(fuelSpy.getFuel()).thenReturn(0);

        //doReturn(33).when(fuelSpy).getFuel();
        Car car = new Car(engineSpy, fuelSpy);

        car.start();

        verify(engineSpy, times(0)).stop();
    }

}
