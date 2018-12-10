package ristorante;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Controller extends JPanel implements ActionListener{
    
    // Atributes
    private JButton addCustomerButton;
    private JButton addChefButton;
    private Container container;
    private Ristorante ristorante;
    
    // Constructor
    public Controller(Ristorante ristorante) {
        super();
        this.setLayout(new FlowLayout());
        this.addChefButton = new JButton("Add Chef");
        this.addCustomerButton = new JButton("Add Customer");
        this.addChefButton.addActionListener(this);
        this.addCustomerButton.addActionListener(this);
        this.add(this.addChefButton);
        this.add(this.addCustomerButton);
        this.ristorante = ristorante;
    }
    
    // Private Methods
    
    // Public Methods

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getActionCommand() == "Add Chef") {
            this.ristorante.newChef();
        }
        
        if (ae.getActionCommand() == "Add Customer") {
            this.ristorante.newCustomer();
        }
        
    }
    
}
