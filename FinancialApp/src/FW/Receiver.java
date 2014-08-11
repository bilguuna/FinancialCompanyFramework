package FW;

import java.util.Vector;

public class Receiver {
    
    private Vector<IParty> receiver;
    
    public Receiver() {
        receiver = new Vector<>();
    }
    
    public void add(IParty account) {
        receiver.add(account);
    }
    
}
