package framework;

import java.util.Calendar;
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
    public double getPrevMonthBalance() {
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
        double balance = 0;
        
        for(IEntry entry : this.entryList) {
            if(entry.getDate().getMonth() == currentMonth) {
                if(entry.getType().equalsIgnoreCase("deposit")) {
                    balance -= entry.getAmount();
                }
                else {
                    balance += entry.getAmount();
                }
            }
        }
        
        return this.getBalance() - balance;
    }
    
    @Override
    public double getTotalAddedMoneyByMonth(int month, String type) {
        double total = 0;
        for(IEntry entry : this.entryList) {
            if (entry.getDate().getMonth() == month && entry.getType().equalsIgnoreCase(type))
                total += entry.getAmount();
        }
        
        return total;
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
    public void deposit(double amount, String type) {
        IEntry entry = new Entry(amount, new Date(), type);
        this.addEntry(entry);
        this.balance += amount;
    }
    
    @Override
    public void withdraw(double amount, String type) {
        IEntry entry = new Entry(amount, new Date(), type);
        this.addEntry(entry);
        this.balance -= amount;
    }
    
}