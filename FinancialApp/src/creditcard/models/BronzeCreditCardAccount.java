/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package creditcard.models;

/**
 *
 * @author javkhlant
 */
public class BronzeCreditCardAccount extends CreditCardAccount {

    private double x;
    private double y;
    
    public BronzeCreditCardAccount(String accountNumber, String cardType) {
        super(accountNumber, cardType);
        x = 0.05;
        y = 0.12;
    }

    @Override
    public double getNewMonthlyBalance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getMonthlyAmountDue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
