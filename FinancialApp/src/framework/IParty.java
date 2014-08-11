package framework;

public interface IParty {
    public void addAccount(IAccount account);
    public void removeAccount(IAccount account);
    public void sendEmailToCustomer(IParty customer);
    
}
