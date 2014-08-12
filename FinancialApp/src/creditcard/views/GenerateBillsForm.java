/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package creditcard.views;

import framework.Invoker;
import framework.Receiver;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author JChimidregzen
 */
public class GenerateBillsForm extends JDialog {
    
    private Receiver receiver;
    private Invoker invoker;
    
    private JScrollPane JScrollPane1;
    private JTextField JTextField1;
    private JButton JButton_OK;
    
    private String billstring;

    public GenerateBillsForm(Receiver receiver, Invoker invoker) {
        this.receiver = receiver;
        this.invoker = invoker;
        
	setTitle("Generate Monthly Bills");
        setModal(true);
        getContentPane().setLayout(null);
        setSize(405,367);
        setVisible(false);
        
        JScrollPane1 = new JScrollPane();
        JTextField1 = new JTextField();
        JButton_OK = new JButton();
        
        getContentPane().add(JScrollPane1);
        JScrollPane1.setBounds(24,24,358,240);
        JScrollPane1.getViewport().add(JTextField1);
        JTextField1.setBounds(0,0,355,237);
        JButton_OK.setText("OK");
        JButton_OK.setActionCommand("OK");
        getContentPane().add(JButton_OK);
        JButton_OK.setBounds(156,276,96,24);

        // generate the string for the monthly bill
        billstring = "Name= John White\r\n";
        billstring += "Address= 1000 Main, Fairfield, IA, 52556\r\n";
        billstring += "CC number= 2341 3421 4444 5689\r\n";
        billstring += "CC type= GOLD\r\n";
        billstring += "Previous balance = $ 100.00\r\n";
        billstring += "Total Credits = $ 25.00\r\n";
        billstring += "Total Charges = $ 560.00\r\n";
        billstring += "New balance = $ 638.75\r\n";
        billstring += "Total amount due = $ 63.88\r\n";		
        billstring += "\r\n";		
        billstring += "\r\n";		
        billstring += "Name= Frank Summer\r\n";
        billstring += "Address= 1000 N, 4th St, Fairfield, IA, 52556\r\n";
        billstring += "CC number= 0099 3421 4321 6577\r\n";
        billstring += "CC type= BRONZE\r\n";
        billstring += "Previous balance = $ 200.00\r\n";
        billstring += "Total Credits = $ 45.00\r\n";
        billstring += "Total Charges = $ 150.00\r\n";
        billstring += "New balance = $ 313.53\r\n";
        billstring += "Total amount due = $ 34.49\r\n";
        JTextField1.setText(billstring);
        
        SymAction lSymAction = new SymAction();
        JButton_OK.addActionListener(lSymAction);
    }

    class SymAction implements java.awt.event.ActionListener {
        
        @Override
        public void actionPerformed(java.awt.event.ActionEvent event) {
            Object object = event.getSource();
            if (object == JButton_OK) {
                JButtonOK_actionPerformed(event);
            }
        }
    }

    void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
        dispose();
    }
}
