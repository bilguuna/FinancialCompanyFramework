package FW;

import java.util.Vector;

public abstract class Account implements IAccount {
    
    private double accountNumber;
    private double balance;
    private Vector<IEntry> entryList;

    public Account(double accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
        entryList = new Vector<>();
    }
    
    @Override
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    @Override
    public double getBalance(){
        return balance;
    }
    
    @Override
    public void addEntry(IEntry entry){
        entryList.add(entry);
    }
    
    public void removeEntry(IEntry entry) {
    
    }
    
    
}
