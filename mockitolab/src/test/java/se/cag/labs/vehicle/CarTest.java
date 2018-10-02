package se.cag.labs.vehicle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {

    private Engine engine = new Engine();
    private FuelTank fuelTank = new FuelTank();

    @BeforeEach
    public void setup() {
        fuelTank.setFuel(100);
    }

    /**
     * ÖVNING 1 -  testa att bilen kan startas utan att exceptions kastas.
     *
     * Byt ut FuelTank mot mockade objekt.
     * Använd inte annotering för detta.
     *
     */
    @Test
    void shouldStart_WithoutExceptions_1() {

        Car car = new Car(engine, fuelTank);

        car.start();
    }

    /**
     * ÖVNING 2 - testa att bilen kan startas utan att exceptions kastas.
     *
     * Byt ut Engine och FuelTank mot mockade objekt.
     * Använd annotering för detta.
     *
     *
     */
    @Test
    void shouldStart_WithoutExceptions_2() {

        Car car = new Car(engine, fuelTank);

        car.start();
    }
}