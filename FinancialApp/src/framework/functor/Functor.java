package framework.functor;

import framework.Customer;
import framework.IParty;

public class Functor implements IFunctor {
    
    public String type;
    private double amount;
    
    public Functor(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }
    
    @Override
    public void updateBalance(IParty customer) {
        if(type.equals("deposit")) {
            double oldAmount = ((Customer)customer).getAccount().getBalance();
            double newAmount = 0;
            newAmount = oldAmount + amount;
            ((Customer)customer).getAccount().setBalance(newAmount);
        } else if (type.equals("withdraw")) {
            double oldAmount = ((Customer)customer).getAccount().getBalance();
            double newAmount = 0;
            newAmount = oldAmount - amount;
            ((Customer)customer).getAccount().setBalance(newAmount);
        }
    }
     
}
