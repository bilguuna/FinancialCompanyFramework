package bank.commands;

import framework.Receiver;
import framework.command.*;

public class AddInterestCommand implements ICommand {
    
    public AddInterestCommand() {
        }
    
    @Override
    public void execute() {
        Receiver.getInstance().addInterest();
    }
    
}
