package ristorante;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Paintable {

    // Atributes
    private Viewer viewer;
    //private BufferedImage skin;
    private int height;
    private int width;
    private int x;
    private int y;
    private Color color;

    // Constructor
    public Paintable(Viewer viewer, Color color, int x, int y, int height, int width) {

        this.viewer = viewer;
        this.color = color;
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;

    }

    // Private Methods
    // Public Methods
    public void paint(Graphics g) {
        //this.viewer.paintImage(this.skin, 0, 0, this.viewer.getGraphics());
        g.setColor(this.color);
        g.fillRect(this.x, this.y, this.height, this.width);

    }
    
    public void setColor(Color color) {
        this.color = color;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public int getX() {
        return this.x;
    }

}
