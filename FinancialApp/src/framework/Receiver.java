package framework;

import java.util.Iterator;
import java.util.Vector;

public class Receiver {
    
    private Vector<IParty> customerList;
    
    public Receiver() {
        customerList = new Vector<>();
    }
    
    public void add(IParty customer) {
        customerList.add(customer);
    }

    public void print() {
        for(IParty p : customerList) {
            System.out.println("" + p.toString());
        }
    }

    public Vector<IParty> getCustomerList() {
        return customerList;
    }
    
    public void deposit(String accountNumber, double value) {
        Customer customer = this.getCustomerByAccountNumber(accountNumber);
        customer.getAccounts().get(0).deposit(value);
    }
    
    public void withdraw(String accountNumber, double value) {
        Customer customer = this.getCustomerByAccountNumber(accountNumber);
        customer.getAccounts().get(0).withdraw(value);
    }
    
    public Customer getCustomerByAccountNumber(String accountNumber) {
        Iterator it = customerList.iterator();
        while(it.hasNext()) {
            Customer cus = (Customer)it.next();
            if(cus.getAccount().getAccountNumber().equals(accountNumber))
                return cus;
        }
        
        return null;
    }
}
