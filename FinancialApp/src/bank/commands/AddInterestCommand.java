package bank.commands;

import framework.command.*;
import framework.Receiver;

public class AddInterestCommand implements ICommand {
    
    private Receiver receiver;
    
    public AddInterestCommand(Receiver receiver) {
        this.receiver = receiver;
    }
    
    @Override
    public void execute() {
        receiver.addInterest();
    }
    
}
