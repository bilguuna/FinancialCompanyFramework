/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package creditcard.models;

/**
 *
 * @author JChimidregzen
 */
public class GoldCreditCardAccount extends CreditCardAccount {
    
    private double x;
    private double y;
    
    public GoldCreditCardAccount(String accountNumber, String cardType) {
        super(accountNumber, cardType);
        x = 0.06;
        y = 0.1;
    }

    @Override
    public double getMonthlyAmountDue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getNewMonthlyBalance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
