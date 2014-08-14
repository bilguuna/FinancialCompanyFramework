package framework;

public interface IAccount {
    
    public void setBalance(double balance);
    public double getBalance();
    public void addEntry(IEntry entry);
    public String getAccountNumber();
    public void deposit(double amount, String type);
    public void withdraw(double amount, String type);
    public double getPrevMonthBalance();
    public double getTotalAddedMoneyByMonth(int month, String type);
}
