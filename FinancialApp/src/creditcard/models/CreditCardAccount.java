package creditcard.models;

import framework.*;

public abstract class CreditCardAccount extends Account {

    private String cardType;
    
    public CreditCardAccount(String accountNumber, String cardType) {
        super(accountNumber);
        this.cardType = cardType;
    }
    
    public abstract double getNewMonthlyBalance();
    
    public abstract double getMonthlyAmountDue(); 

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
}
