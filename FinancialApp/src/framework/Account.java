package framework;

import java.util.Date;
import java.util.Vector;

public abstract class Account implements IAccount {
    
    private String accountNumber;
    private double balance;
    private Vector<IEntry> entryList;

    public Account(String accountNumber) {
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

    /**
     * @return the accountNumber
     */
    @Override
    public String getAccountNumber() {
        return accountNumber;
    }
    
    @Override
    public void deposit(double amount) {
        IEntry entry = new Entry(amount, new Date(), "Deposit");
        this.addEntry(entry);
        this.balance += amount;
    }
    
    @Override
    public void withdraw(double amount) {
        IEntry entry = new Entry(amount, new Date(), "Withdraw");
        this.addEntry(entry);
        this.balance -= amount;
    }
}
