/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creditcard.views;

import creditcard.factory.CreditCardFactory;
import framework.IParty;
import framework.Invoker;
import framework.Receiver;
import framework.command.AddDefaulAccountCommand;
import framework.command.ICommand;
import framework.view.DefaultAccountForm;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author javkhlant
 */
public class CreditCardAccountForm extends DefaultAccountForm {

    javax.swing.JRadioButton JRadioButton_Gold = new javax.swing.JRadioButton();
    javax.swing.JRadioButton JRadioButton_Silver = new javax.swing.JRadioButton();
    javax.swing.JRadioButton JRadioButton_Bronze = new javax.swing.JRadioButton();
    javax.swing.JLabel JLabel6 = new javax.swing.JLabel();
    javax.swing.JLabel Label7 = new javax.swing.JLabel();
    javax.swing.JTextField JTextField_CCNR = new javax.swing.JTextField();
    javax.swing.JTextField JTextField_ExpDate = new javax.swing.JTextField();
    
    private final SimpleDateFormat dateFormat;
    
    private String ccnr;
    private Date expDate;
    private String cardType;
    
    private Invoker invoker;
    private Receiver receiver;
    
    public CreditCardAccountForm(Invoker invoker, Receiver receiver) {
        super(invoker, receiver);
        this.invoker = invoker;
        this.receiver = receiver;
        setMinimumSize(new Dimension(300, 400));
        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        
        JRadioButton_Gold.setText("Gold");
        JRadioButton_Gold.setActionCommand("Checkings");
        getContentPane().add(JRadioButton_Gold);
        JRadioButton_Gold.setBounds(36,12,84,24);
        JRadioButton_Silver.setText("Silver");
        JRadioButton_Silver.setActionCommand("Savings");
        getContentPane().add(JRadioButton_Silver);
        JRadioButton_Silver.setBounds(36,36,84,24);
        JRadioButton_Bronze.setText("Bronze");
        JRadioButton_Bronze.setActionCommand("Savings");
        getContentPane().add(JRadioButton_Bronze);
        JRadioButton_Bronze.setBounds(36,60,84,24);
        JRadioButton_Bronze.setSelected(true);
        cardType = JRadioButton_Bronze.getText();
        JLabel8.setText("Acc Nr");
        JLabel8.setBounds(12,108,48,24);
        JLabel1.setBounds(12,132,48,24);
        JLabel2.setBounds(12,156,48,24);
        JLabel3.setBounds(12,180,48,24);
        JLabel4.setBounds(12,204,48,24);
        JLabel5.setBounds(12,228,48,24);
        JLabel7.setBounds(12,252,96,24);
        JLabel6.setText("CC number");
        getContentPane().add(JLabel6);
        JLabel6.setForeground(java.awt.Color.black);
        JLabel6.setBounds(12,276,72,24);
        Label7.setText("Exp. Date");
        getContentPane().add(Label7);
        Label7.setForeground(java.awt.Color.black);
        Label7.setBounds(12,300,72,24);
        
        JTextField_ACNR.setBounds(84,108,156,20);
        JTextField_NAME.setBounds(84,156,156,20);
        JTextField_CT.setBounds(84,180,156,20);
        JTextField_ST.setBounds(84,132,156,20);
        JTextField_STR.setBounds(84,204,156,20);
        JTextField_ZIP.setBounds(84,228,156,20);
        JTextField_EM.setBounds(84,252,156,20);
        getContentPane().add(JTextField_CCNR);
        JTextField_CCNR.setBounds(84,276,156,20);
        getContentPane().add(JTextField_ExpDate);
        JTextField_ExpDate.setBounds(84,300,156,20);
        JTextField_ExpDate.setText(dateFormat.format(new Date()));
        JButton_OK.setBounds(48,336,84,24);
        JButton_Calcel.setBounds(156,336,84,24);
        
        SymMouse aSymMouse = new SymMouse();
        JRadioButton_Gold.addMouseListener(aSymMouse);
        JRadioButton_Silver.addMouseListener(aSymMouse);
        JRadioButton_Bronze.addMouseListener(aSymMouse);
    }

    /**
     * @return the ccnr
     */
    public String getCcnr() {
        return ccnr;
    }

    /**
     * @param ccnr the ccnr to set
     */
    public void setCcnr(String ccnr) {
        this.ccnr = ccnr;
    }

    /**
     * @return the expDate
     */
    public Date getExpDate() {
        return expDate;
    }

    /**
     * @param expDate the expDate to set
     */
    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    /**
     * @return the cardType
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * @param cardType the cardType to set
     */
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
    
    class SymMouse extends java.awt.event.MouseAdapter
    {
            public void mouseClicked(java.awt.event.MouseEvent event)
            {
                    Object object = event.getSource();
                    if (object == JRadioButton_Gold)
                            JRadioButtonChk_mouseClicked(event);
                    else if (object == JRadioButton_Silver)
                            JRadioButtonSav_mouseClicked(event);
                    else if (object == JRadioButton_Bronze)
                            JRadioButtonBronze_mouseClicked(event);


            }
    }
    
    void JRadioButtonChk_mouseClicked(java.awt.event.MouseEvent event)
    {
            cardType = JRadioButton_Gold.getText();
            JRadioButton_Gold.setSelected(true);
            JRadioButton_Silver.setSelected(false);
            JRadioButton_Bronze.setSelected(false);
    }

    void JRadioButtonSav_mouseClicked(java.awt.event.MouseEvent event)
    {
            cardType = JRadioButton_Silver.getText();
            JRadioButton_Gold.setSelected(false);
            JRadioButton_Silver.setSelected(true);
            JRadioButton_Bronze.setSelected(false);
    }
    void JRadioButtonBronze_mouseClicked(java.awt.event.MouseEvent event)
    {
            cardType = JRadioButton_Bronze.getText();
            JRadioButton_Gold.setSelected(false);
            JRadioButton_Silver.setSelected(false);
            JRadioButton_Bronze.setSelected(true);
    }
    
    @Override
    public void JButtonOK_actionPerformed(ActionEvent event) {
        if (!JTextField_ACNR.getText().isEmpty()) {
            
            setAccountNumber(JTextField_ACNR.getText());
            setName(JTextField_NAME.getText());
            setStreet(JTextField_STR.getText());
            setCity(JTextField_CT.getText());
            setState(JTextField_ST.getText());
            setZip(JTextField_ZIP.getText());
            setEmail(JTextField_EM.getText());
            setCcnr(JTextField_CCNR.getText());
            try {
                setExpDate(dateFormat.parse(JTextField_ExpDate.getText()));
            } catch (ParseException ex) {
                Logger.getLogger(CreditCardAccountForm.class.getName()).log(Level.SEVERE, null, ex);
            }

            CreditCardFactory factory = new CreditCardFactory();
            IParty customer = factory.createCustomer(this);

            ICommand addDefault = new AddDefaulAccountCommand(customer);
            invoker.submit(addDefault);
            dispose();
        }
    }
}