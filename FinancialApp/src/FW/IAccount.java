package FW;

public interface IAccount {
    
    public void setBalance(double balance);
    public double getBalance();
    public void addEntry(IEntry entry);
    
}
