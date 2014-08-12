package bank.commands;

import bank.models.BankAccount;
import framework.Customer;
import framework.IAccount;
import framework.command.*;
import framework.IParty;
import framework.Receiver;

public class AddInterestCommand implements ICommand {
    
    private Receiver receiver;
    private IParty customer;

    public AddInterestCommand(Receiver receiver, IParty customer) {
        this.receiver = receiver;
        this.customer = customer;
    }
    
    @Override
    public void execute() {
        for(IParty party : receiver.getCustomerList()) {
            Customer customer = (Customer)party;
            for(IAccount account : customer.getAccounts()) {
                BankAccount bankAccount = (BankAccount)account;
                bankAccount.addInterest();
            }
        }
    }
    
}
