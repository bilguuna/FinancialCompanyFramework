package framework.command;

import framework.IParty;
import framework.Receiver;

public class AddDefaulAccountCommand implements ICommand {
    
    //private Receiver receiver;
    private IParty customer;

    public AddDefaulAccountCommand(IParty customer) {
        //this.receiver = Receiver.getInstance();
        this.customer = customer;
    }
    
    @Override
    public void execute() {
        Receiver.getInstance().add(customer);
    }
    
}
