package framework;

public class DefaultCustomer extends Customer {
    
    public DefaultCustomer(String name, String street, String city, String State, String zip, String email, IAccount account) {
        super(name, street, city, State, zip, email);
        super.addAccount(account);
        
    }

    @Override
    public void addAccount(IAccount account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeAccount(IAccount account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
