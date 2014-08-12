/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.views;

import bank.commands.AddBankCustomerCommand;
import bank.factory.BankFactory;
import framework.IParty;
import framework.Invoker;
import framework.Receiver;
import framework.command.ICommand;
import framework.factory.IFactory;
import framework.view.DefaultAccountForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;

/**
 *
 * @author Bilguun
 */
public class BankAccountForm extends DefaultAccountForm {

    private String customerType;
    javax.swing.JRadioButton JRadioButton_Chk = new javax.swing.JRadioButton();
    javax.swing.JRadioButton JRadioButton_Sav = new javax.swing.JRadioButton();
    private Receiver receiver;
    private Invoker invoker;

    public BankAccountForm(Invoker invoker, Receiver receiver, String customerType) {
        super(invoker, receiver);
        this.receiver = receiver;
        this.invoker = invoker;
        this.customerType = customerType;
        JRadioButton_Chk.setText("Checkings");
        JRadioButton_Chk.setSelected(true);
        JRadioButton_Chk.setActionCommand("Checkings");
        getContentPane().add(JRadioButton_Chk);
        JRadioButton_Chk.setBounds(36, 0, 84, 24);
        JRadioButton_Sav.setText("Savings");
        JRadioButton_Sav.setActionCommand("Savings");
        getContentPane().add(JRadioButton_Sav);
        JRadioButton_Sav.setBounds(36, 24, 84, 24);

        SymMouse aSymMouse = new SymMouse();
        JRadioButton_Chk.addMouseListener(aSymMouse);
        JRadioButton_Sav.addMouseListener(aSymMouse);
        //removing action listener in the parent
//        this.getJButton_OK().removeActionListener(this.getJButton_OK().getActionListeners()[0]);
//        SymActionOk lSymAction = new SymActionOk();
//        this.getJButton_OK().addActionListener(lSymAction);
    }

    class SymMouse extends java.awt.event.MouseAdapter {

        @Override
        public void mouseClicked(java.awt.event.MouseEvent event) {
            Object object = event.getSource();
            if (object == JRadioButton_Chk) {
                JRadioButtonChk_mouseClicked(event);
            } else if (object == JRadioButton_Sav) {
                JRadioButtonSav_mouseClicked(event);
            }
        }
    }

    class SymActionOk implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            JButtonOK_actionPerformed(event);
        }
    }

    void JRadioButtonChk_mouseClicked(java.awt.event.MouseEvent event) {
        //When Checking radio is clicked make this radio on 
        //and make Saving account radio off
        JRadioButton_Chk.setSelected(true);
        JRadioButton_Sav.setSelected(false);
    }

    void JRadioButtonSav_mouseClicked(java.awt.event.MouseEvent event) {
        //When Saving radio is clicked make this radio on 
        //and make Checking account radio off
        JRadioButton_Chk.setSelected(false);
        JRadioButton_Sav.setSelected(true);

    }

    @Override
    public void JButtonOK_actionPerformed(ActionEvent event) {
        setAccountNumber(JTextField_ACNR.getText());
        super.setName(JTextField_NAME.getText());
        setStreet(JTextField_STR.getText());
        setCity(JTextField_CT.getText());
        setState(JTextField_ST.getText());
        setZip(JTextField_ZIP.getText());
        setEmail(JTextField_EM.getText());

        IFactory factory = new BankFactory();
        IParty customer = factory.createCustomer(this);
        ICommand addCustomer = new AddBankCustomerCommand(this.receiver, customer);
        invoker.submit(addCustomer);
//        this.receiver.print();

    }

    public JRadioButton getJRadioButton_Chk() {
        return JRadioButton_Chk;
    }

    public String getCustomerType() {
        return customerType;
    }

}
