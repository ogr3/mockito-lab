package se.cag.labs.vehicle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CarTest {

    @Mock
    Engine engineMockAnnotate;

    @Mock
    FuelTank fuelTankMockAnnotate;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * ÖVNING 1 -  testar att bilen kan startas utan att exceptions kastas.
     *
     * Byt ut FuelTank mot mockade objekt.
     * Använd inte annotering för detta.
     *

     */
    @Test
    public void shouldStart_WithoutExceptions_1() {
        //TODO: Ersätt FuelTank med mock
        Engine engine = new Engine();
        FuelTank fuelTankMock = mock(FuelTank.class);

        when(fuelTankMock.getFuel()).thenReturn(55);
        Car car = new Car(engine, fuelTankMock);

        car.start();
    }

    /**
     * ÖVNING 2 - testar att bilen kan startas utan att exceptions kastas.
     *
     * Byt utt Engine och FuelTank mot mockade objekt.
     * Använd annotering för detta.
     *
     *
     */
    @Test
    public void shouldStart_WithoutExceptions_2() {

        when(fuelTankMockAnnotate.getFuel()).thenReturn(1);
        when(engineMockAnnotate.isRunning()).thenReturn(true);

        Car car = new Car(engineMockAnnotate, fuelTankMockAnnotate);

        car.start();
    }
}