package bank.commands;

import framework.command.*;
import framework.IParty;
import framework.Receiver;

public class AddBankCustomerCommand implements ICommand {
    
    private Receiver receiver;
    private IParty customer;

    public AddBankCustomerCommand(Receiver receiver, IParty customer) {
        this.receiver = receiver;
        this.customer = customer;
    }
    
    @Override
    public void execute() {
        receiver.add(customer);
    }
    
}
