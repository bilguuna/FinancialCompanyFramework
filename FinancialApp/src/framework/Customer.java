package framework;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Customer implements IParty {
    
    private String name;
    private String street;
    private String city;
    private String State;
    private String zip;
    private String email;
    private List<IAccount> accounts = new ArrayList<IAccount>();

    public Customer(String name, String street, String city, String State, String zip, String email) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.State = State;
        this.zip = zip;
        this.email = email;
//        this.account = account;
    }
    
    @Override
    public void addAccount(IAccount account) {
        this.accounts.add(account);
    }
    
    @Override
    public void removeAccount(IAccount account) {
        this.accounts.remove(account);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<IAccount> getAccounts() {
        return accounts;
    }
    
    public IAccount getAccount() {
        if(this.accounts == null || this.accounts.isEmpty())
            return null;
        return this.accounts.get(0);
    }
    
    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", street=" + street + ", city=" + city + ", State=" + State + ", zip=" + zip + ", email=" + email + ", account=" + accounts.get(0).getAccountNumber() + '}';
    }
    
    public abstract Object[] getData();
    
    public void sendEmailToCustomer() {
        
    }
    
}
