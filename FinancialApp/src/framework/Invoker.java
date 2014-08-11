package framework;

import framework.command.ICommand;

public class Invoker {
    
    private ICommand command;
    
    public void submit(ICommand command) {
        command.execute();
    }
    
    
}
