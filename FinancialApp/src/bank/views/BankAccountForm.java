/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.views;

import framework.Invoker;
import framework.Receiver;
import framework.view.DefaultAccountForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Bilguun
 */
public class BankAccountForm extends DefaultAccountForm {

    private String accountType;
    javax.swing.JRadioButton JRadioButton_Chk = new javax.swing.JRadioButton();
    javax.swing.JRadioButton JRadioButton_Sav = new javax.swing.JRadioButton();

    public BankAccountForm(Invoker invoker, Receiver receiver, String accountType) {
        super(invoker, receiver);
        this.accountType = accountType;
        JRadioButton_Chk.setText("Checkings");
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
        this.getJButton_OK().removeActionListener(this.getJButton_OK().getActionListeners()[0]);
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

    class SymAction implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            JButtonOK_actionPerformed(event);
        }
    }

    void JButtonOK_actionPerformed(ActionEvent event) {
        setAccountNumber(JTextField_ACNR.getText());
        setName(JTextField_NAME.getText());
        setStreet(JTextField_STR.getText());
        setCity(JTextField_CT.getText());
        setState(JTextField_ST.getText());
        setZip(JTextField_ZIP.getText());
        setEmail(JTextField_EM.getText());
        
//        IFactory factory = (JRadioButton_Chk.isSelected()) ? new SavingsBankFactory() 
//                : new Checking;
//        IParty customer = factory.createCustomer(this);
//        
//        ICommand addDefault = new AddDefaulAccountCommand(this.receiver, customer);
//        invoker.submit(addDefault);
//        this.receiver.print();
        
    }

}
