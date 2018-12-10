package ristorante;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Viewer extends Canvas implements Runnable {

    // Atributes
    private ArrayList<Chef> chefs;
    private ArrayList<Customer> customers;
    private ArrayList<Table> tables;

    /* Atributes
    
     */
    // Constructor
    public Viewer(ArrayList chefs, ArrayList customers, ArrayList tables) {
        this.chefs = chefs;
        this.customers = customers;
        this.tables = tables;
    }

    // Private Methods
    // Public Methods
    public void paintImage(BufferedImage image, int x, int y, Graphics graphics) {
        super.paint(graphics);
        if (image != null) {
            graphics.drawImage(image, x, y, this);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }

    // Activity
    @Override
    public void run() {
        boolean exit = false;
        while (!exit) {

            for (int inc = 0; inc < chefs.size(); inc++) {
                chefs.get(inc).paint(this.getGraphics());
            }

            for (int inc = 0; inc < customers.size(); inc++) {
                customers.get(inc).paint(this.getGraphics());
            }

            for (int inc = 0; inc < tables.size(); inc++) {
                tables.get(inc).paintFood(this.getGraphics());
            }

        }
    }

}
