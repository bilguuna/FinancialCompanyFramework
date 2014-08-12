package creditcard.models;

import framework.*;

public abstract class CreditCardAccount extends Account {

    private String cardType;
    
    public CreditCardAccount(String accountNumber, String cardType) {
        super(accountNumber);
//        this.x = x;
//        this.y = y;
//        this.cardType = cardType;
    }
    
    public abstract double getNewMonthlyBalance();
    
    public abstract double getMonthlyAmountDue(); 
}
