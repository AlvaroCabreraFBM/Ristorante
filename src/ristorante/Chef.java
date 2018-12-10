package ristorante;

import java.awt.Color;

public class Chef extends Paintable implements Runnable {

    // Atributes
    private Table table;
    private double generationProbability;

    // Constructor
    public Chef(Viewer viewer, Color color, int x, int y, int height, int width, Table table) {
        super(viewer, color, x, y, height, width);
        this.generationProbability = 1;
        this.table = table;
    }

    // Private Methods
    // Public Methods
    public synchronized void serve() {
        if (this.generationProbability >= Math.random()) {
            this.table.addFood();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }

        } else {
            this.table.stopThread();
        }
    }

    // Activity
    @Override
    public void run() {
        boolean exit = false;
        while (!exit) {
            serve();
        }
    }

}
