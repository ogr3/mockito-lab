package se.cag.labs.vehicle;

public class Engine {

    private boolean running;

    public boolean isRunning() {
        return this.running;
    }

    public void start() {
        this.running = true;
    }

    public void stop() {
        this.running = false;
    }
}
