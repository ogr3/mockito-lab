package se.cag.labs.vehicle;

public class Car {
    
    private Engine engine;
    private FuelTank fuelTank;

    public Car(Engine engine, FuelTank fuelTank) {
        this.engine = engine;
        this.fuelTank = fuelTank;
    }

    public void start() {

        if(fuelTank.getFuel() <= 0) {
            throw new IllegalStateException("Can't start: no fuel");
        }

        engine.start();

        if(!engine.isRunning()) {
            throw new IllegalStateException("Started engine but isn't running");
        }

        System.out.println("Car started!");
    }

    public boolean isRunning() {
        return engine.isRunning();
    }
}
