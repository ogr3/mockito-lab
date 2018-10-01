package se.cag.labs.vehicle;

public class FuelTank {

    public static final int MAX = 100;

    private int fuel;

    public int getFuel() {
        System.out.println("Getting fuel: " + this.fuel);
        return this.fuel;
    }

    public void setFuel(int fuel) {
        System.out.println("Setting fuel: " + fuel);
        this.fuel = fuel;
    }
}
