package ristorante;

import java.awt.Color;

public class Customer extends Paintable implements Runnable {

    // Atributes
    private Table table;
    private double eatProbability;

    // Constructor
    public Customer(Viewer viewer, Color color, int x, int y, int height, int width, Table table) {
        super(viewer, color, x, y, height, width);
        this.eatProbability = 0.3;
        this.table = table;
    }

    public synchronized void eat() {
        if (this.eatProbability >= Math.random()) {
            this.table.removeFood();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }

        } else {
            this.table.stopThread();
        }
    }

    // Private Methods
    // Public Methods
    // Activity
    @Override
    public void run() {
        boolean exit = false;
        while (!exit) {
            this.eat();
        }
    }

}
