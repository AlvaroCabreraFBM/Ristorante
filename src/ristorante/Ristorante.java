package ristorante;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Ristorante extends JFrame {
    
    // Atributes

    private ArrayList<Chef> chefs;
    private ArrayList<Customer> customers;
    private ArrayList<Table> tables;
    
    private Viewer viewer;
    private JFrame window;
    private Controller controller;

    // Constructor
    public Ristorante() {
        
        this.tables = new ArrayList();
        this.customers = new ArrayList();
        this.chefs = new ArrayList();
        
        this.newViewer();
        this.newTable();
        this.newChef();
        this.newCustomer();
        this.newController();
        this.newWindow();
        new Thread(this.viewer).start();
    
    }
    
    // Private Methods
    public void newChef() {
        Chef chef = new Chef(this.viewer, Color.yellow, 0, 15 * this.chefs.size(), 5, 10, this.tables.get(0));
        this.chefs.add(chef);
        new Thread(chef).start();
    }
    
    public void newCustomer() {
        Customer customer = new Customer(this.viewer, Color.blue, 10, 15 * this.customers.size(), 5, 10, this.tables.get(0));
        this.customers.add(customer);
        new Thread(customer).start();
    }
    
    private void newTable() {
        Table table = new Table(this.viewer, Color.red, 20, 0, 5, 5, 10);
        this.tables.add(table);
    }
    
    private void newViewer() {
        this.viewer = new Viewer(this.chefs, this.customers, this.tables);
        
    }
    
    private void newWindow() {
        this.window = new JFrame("Ristorante");
        this.window.setSize(500, 500);
        this.window.setLocationRelativeTo(null);
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.getContentPane().setLayout(new GridLayout());
        this.window.setVisible(true);
        this.window.add(this.viewer, 0, 0);
        this.window.add(this.controller, 1, 0);
    }
    
    private void newController() {
        this.controller = new Controller(this);
    }
    
    // Public Methods
    
    // Main activity
    public static void main(String[] args) {
        
        Ristorante ristorante = new Ristorante();
        
    }
    
}
