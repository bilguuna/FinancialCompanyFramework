package framework.command;

import framework.IParty;
import framework.Receiver;

public class AddDefaulAccountCommand implements ICommand {
    
    private Receiver receiver;
    private IParty customer;

    public AddDefaulAccountCommand(Receiver receiver, IParty customer) {
        this.receiver = receiver;
        this.customer = customer;
    }
    
    @Override
    public void execute() {
        receiver.add(customer);
    }
    
}
