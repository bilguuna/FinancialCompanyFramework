package FW;

public abstract class Customer implements IParty {
    
    private String name;
    private String street;
    private String city;
    private String State;
    private String zip;
    private String email;
    private IAccount account;

    public Customer(String name, String street, String city, String State, String zip, String email, IAccount account) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.State = State;
        this.zip = zip;
        this.email = email;
        this.account = account;
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
    
    @Override
    public abstract void addAccount(IAccount account);
    
    @Override
    public abstract void removeAccount(IAccount account);
    
    @Override
    public abstract void sendEmailToCustomer(IParty customer);
    
}
