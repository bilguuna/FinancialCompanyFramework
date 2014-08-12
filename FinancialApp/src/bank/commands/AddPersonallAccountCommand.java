package bank.commands;

import framework.command.*;
import framework.IParty;
import framework.Receiver;

public class AddPersonallAccountCommand implements ICommand {
    
    private Receiver receiver;
    private IParty customer;

    public AddPersonallAccountCommand(Receiver receiver, IParty customer) {
        this.receiver = receiver;
        this.customer = customer;
    }
    
    @Override
    public void execute() {
        receiver.add(customer);
    }
    
}
