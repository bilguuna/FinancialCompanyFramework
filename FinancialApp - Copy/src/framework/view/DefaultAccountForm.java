package framework.view;

import framework.IParty;
import framework.Invoker;
import framework.Receiver;
import framework.command.ICommand;
import framework.command.AddDefaulAccountCommand;
import framework.factory.Factory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DefaultAccountForm extends JDialog {
    
    JLabel JLabel1 = new JLabel();
    JLabel JLabel2 = new JLabel();
    JLabel JLabel3 = new JLabel();
    JLabel JLabel4 = new JLabel();
    JLabel JLabel5 = new JLabel();
    JLabel JLabel6 = new JLabel();
    JLabel JLabel7 = new JLabel();
    JLabel JLabel8 = new JLabel();
    JTextField JTextField_NAME = new JTextField();
    JTextField JTextField_CT = new JTextField();
    JTextField JTextField_ST = new JTextField();
    JTextField JTextField_STR = new JTextField();
    JTextField JTextField_ZIP = new JTextField();
    JTextField JTextField_EM = new JTextField();
    JButton JButton_OK = new JButton();
    JButton JButton_Calcel = new JButton();
    JTextField JTextField_ACNR = new JTextField();
    
    private String AccountNumber;
    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String email;
    
    private DefaultAccountForm defaultAcc;
    private Invoker invoker;
    private Receiver receiver;
    
    public DefaultAccountForm(Invoker invoker, Receiver receiver) {
        this.invoker = invoker;
        this.receiver = receiver;
        //defaultAcc = new DefaultAccountForm();
        
        //new DefaultAccountForm();
        
        // This code is automatically generated by Visual Cafe when you add
        // components to the visual environment. It instantiates and initializes
        // the components. To modify the code, only use code syntax that matches
        // what Visual Cafe can generate, or Visual Cafe may be unable to back
        // parse your Java file into its visual environment.
        //{{INIT_CONTROLS
        setTitle("Add Default Account");
        setModal(true);
        getContentPane().setLayout(null);
        setSize(340, 350);
        setVisible(false);
        
        JLabel8.setText("Acc Number");
        getContentPane().add(JLabel8);
        JLabel8.setForeground(java.awt.Color.black);
        JLabel8.setBounds(12, 72, 60, 24);

        JLabel1.setText("Name");
        getContentPane().add(JLabel1);
        JLabel1.setForeground(java.awt.Color.black);
        JLabel1.setBounds(12, 96, 48, 24);
        
        JLabel2.setText("Street");
        getContentPane().add(JLabel2);
        JLabel2.setForeground(java.awt.Color.black);
        JLabel2.setBounds(12, 120, 48, 24);
        
        JLabel3.setText("City");
        getContentPane().add(JLabel3);
        JLabel3.setForeground(java.awt.Color.black);
        JLabel3.setBounds(12, 144, 48, 24);
        
        JLabel4.setText("State");
        getContentPane().add(JLabel4);
        JLabel4.setForeground(java.awt.Color.black);
        JLabel4.setBounds(12, 168, 48, 24);
        
        JLabel5.setText("Zip");
        getContentPane().add(JLabel5);
        JLabel5.setForeground(java.awt.Color.black);
        JLabel5.setBounds(12, 192, 48, 24);
        
        JLabel7.setText("Email");
        getContentPane().add(JLabel7);
        JLabel7.setForeground(java.awt.Color.black);
        JLabel7.setBounds(12, 216, 96, 24);
                
        getContentPane().add(JTextField_NAME);
        JTextField_NAME.setBounds(120, 96, 156, 20);
        getContentPane().add(JTextField_CT);
        JTextField_CT.setBounds(120, 144, 156, 20);
        getContentPane().add(JTextField_ST);
        JTextField_ST.setBounds(120, 168, 156, 20);
        getContentPane().add(JTextField_STR);
        JTextField_STR.setBounds(120, 120, 156, 20);
        getContentPane().add(JTextField_ZIP);
        JTextField_ZIP.setBounds(120, 192, 156, 20);
        getContentPane().add(JTextField_EM);
        JTextField_EM.setBounds(120, 216, 156, 20);
        JButton_OK.setText("OK");
        JButton_OK.setActionCommand("OK");
        getContentPane().add(JButton_OK);
        JButton_OK.setBounds(48, 276, 84, 24);
        JButton_Calcel.setText("Cancel");
        JButton_Calcel.setActionCommand("Cancel");
        getContentPane().add(JButton_Calcel);
        JButton_Calcel.setBounds(156, 276, 84, 24);
        getContentPane().add(JTextField_ACNR);
        JTextField_ACNR.setBounds(120, 72, 156, 20);
		//}}

        //{{REGISTER_LISTENERS
        SymAction lSymAction = new SymAction();
        JButton_OK.addActionListener(lSymAction);
        JButton_Calcel.addActionListener(lSymAction);
        //}}
    }

    class SymAction implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            Object object = event.getSource();
            if (object == JButton_OK) {
                JButtonOK_actionPerformed(event);
            } else if (object == JButton_Calcel) {
                JButtonCalcel_actionPerformed(event);
            }
        }
    }

    void JButtonOK_actionPerformed(ActionEvent event) {
        AccountNumber = JTextField_ACNR.getText();
        name = JTextField_NAME.getText();
        street = JTextField_STR.getText();
        city = JTextField_CT.getText();
        state = JTextField_ST.getText();
        zip = JTextField_ZIP.getText();
        email = JTextField_EM.getText();
        
        Factory factory = new Factory();
        IParty customer = factory.createCustomer(this);
        
        ICommand addDefault = new AddDefaulAccountCommand(this.receiver, customer);
        invoker.submit(addDefault);
        this.receiver.print();
        
    }
    
    void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event) {
        dispose();
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getEmail() {
        return email;
    }
    
    public String getName() {
        return name;
    }
    
}
