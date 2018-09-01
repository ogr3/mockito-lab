package se.cag.labs;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class CarTest {
    private Car car;
    private Engine engine;
    private FuelTank fuelTank;

    @BeforeEach
    public void setup() {
        engine = Mockito.mock(Engine.class);
        fuelTank = Mockito.mock(FuelTank.class);

        car = new Car(engine, fuelTank);
    }

    @Test
    public void isRunning() {
        when(engine.isRunning()).thenReturn(true);
        assertEquals(true, car.isRunning());

        when(engine.isRunning()).thenReturn(false);
        assertEquals(false, car.isRunning());
    }

    @Test
    public void startCarShouldWork() {
        when(engine.isRunning()).thenReturn(false, true);
        when(fuelTank.getFuel()).thenReturn(100);

        car.start();
    }

    @Test
    public void start_NoFuel() {
        when(engine.isRunning()).thenReturn(false);
        when(fuelTank.getFuel()).thenReturn(0);

        assertThrows(IllegalStateException.class, () -> {
            car.start();
        },"no fuel");

    }

    @Test
    public void start_IsRunning() {
        when(fuelTank.getFuel()).thenReturn(100);
        when(engine.isRunning()).thenReturn(true);

        assertThrows(IllegalStateException.class, () -> {
            car.start();
        }, "already running");
    }

    @Test
    public void start_DidNotStart() {
        when(engine.isRunning()).thenReturn(false, false);
        when(fuelTank.getFuel()).thenReturn(100);

        assertThrows(IllegalStateException.class, () -> {
            car.start();
        }, "Started engine but isn't running");
    }
}