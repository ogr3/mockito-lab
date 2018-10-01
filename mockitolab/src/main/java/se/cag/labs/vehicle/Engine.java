package se.cag.labs.vehicle;

public class Engine {

    private boolean running;

    public boolean isRunning() {
        System.out.println("Engine is running: " + this.running);
        return this.running;
    }

    public void start() {
        System.out.println("Starting..." );
        this.running = true;
    }

    public void stop() {
        System.out.println("Stopping..." );
        this.running = false;
    }
}
