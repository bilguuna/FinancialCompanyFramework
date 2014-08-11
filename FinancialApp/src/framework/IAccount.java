package framework;

public interface IAccount {
    
    public void setBalance(double balance);
    public double getBalance();
    public void addEntry(IEntry entry);
    public String getAccountNumber();
    public void deposit(double amount);
    public void withdraw(double amount);
}
