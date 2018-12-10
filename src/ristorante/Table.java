package ristorante;

import java.awt.Color;
import java.awt.Graphics;

public class Table extends Paintable {

    // Atributes
    private int maxAmount;
    private int currentAmount;

    // Constructor
    public Table(Viewer viewer, Color color, int x, int y, int height, int width, int maxAmount) {
        super(viewer, color, x, y, height, width);
        this.currentAmount = 0;
        this.maxAmount = maxAmount;
    }

    // Private Methods
    // Public Methods
    public int getMaxAmount() {
        return maxAmount;
    }

    public int getCurrentAmount() {
        return currentAmount;
    }

    public synchronized void addFood() {
        if (this.currentAmount < this.maxAmount) {
            this.currentAmount++;
            System.out.println("Sirvo, quedan " + this.currentAmount + " platos.");
            notifyAll();
        }
    }

    public synchronized void removeFood() {
        if (this.currentAmount > 0) {
            this.currentAmount--;
            System.out.println("Como, quedan " + this.currentAmount + " platos.");
            notifyAll();
        }
    }

    public synchronized void stopThread() {
        try {
            wait();
        } catch (InterruptedException e) {
        }
    }

    public void paintFood(Graphics g) {

        int rows = this.maxAmount / 5;
        int baseX = this.getX();

        for (int row = 0, item = 0; row < rows; row++) {
            this.setY(row * 10);
            for (int col = 0; col < 5; col++, item++) {
                if (item < currentAmount) {
                    this.setColor(Color.red);
                } else {
                    this.setColor(Color.black);
                }
                this.setX(baseX + (col * 10));
                this.paint(g);
            }
            this.setX(baseX);
        }

    }

}
