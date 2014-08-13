package bank.commands;

import framework.command.*;
import framework.IParty;
import framework.Receiver;

public class AddBankCustomerCommand implements ICommand {
    
    private Receiver receiver;
    private IParty customer;

    public AddBankCustomerCommand(IParty customer) {
        this.customer = customer;
    }
    
    @Override
    public void execute() {
        Receiver.getInstance().add(customer);
    }
    
}
