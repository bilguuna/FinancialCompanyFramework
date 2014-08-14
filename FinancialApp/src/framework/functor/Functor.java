package framework.functor;

import framework.Customer;
import framework.IParty;

public class Functor implements IFunctor<IParty> {
    
    public String type;
    private double amount;
    
    public Functor(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }
    
    @Override
    public void updateBalance(IParty customer) {
        if(type.equals("deposit")) {
            ((Customer)customer).getAccount().deposit(amount, type);
        } else if (type.equals("withdraw")) {
            ((Customer)customer).getAccount().withdraw(amount, type);
        }
    }
}
