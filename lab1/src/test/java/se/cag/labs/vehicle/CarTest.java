package se.cag.labs.vehicle;

import org.junit.jupiter.api.Test;

public class CarTest {


    /**
     * ÖVNING 1 -  testar att bilen kan startas utan att exceptions kastas.
     *
     * Byt ut Engine och FuelTank mot mockade objekt.
     * Använd inte annotering för detta.
     *

     */
    @Test
    public void shouldStart_WithoutExceptions_1() {
        //TODO: Ersätt Engine och FuelTank med mockar
        Engine engine = new Engine();
        FuelTank fuelTank = new FuelTank();
        fuelTank.setFuel(55);

        Car car = new Car(engine, fuelTank);

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
        Engine engine = new Engine();
        FuelTank fuelTank = new FuelTank();
        fuelTank.setFuel(55);

        Car car = new Car(engine, fuelTank);

        car.start();
    }
}