package framework;

import bank.models.BankAccount;
import framework.functor.IFunctor;
import framework.observer.Observer;
import framework.predicate.IPredicate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Receiver {

    private Vector<IParty> customerList;
    private List<Observer> observers;
    
    private static Receiver instance = null;
    
    private Receiver() {
        customerList = new Vector<>();
        observers = new ArrayList<>();
    }
    
    public static Receiver getInstance() {
        if(instance == null) {
            instance = new Receiver();
        }
        return instance;
    }

    public void add(IParty customer) {
        customerList.add(customer);
        updateView();
    }

    public void print() {
        for (IParty p : customerList) {
            System.out.println("" + p.toString());
        }
    }

    public Vector<IParty> getCustomerList() {
        return customerList;
    }
    
    public void updateBalance(IFunctor functor, IPredicate predicate) {
        for(IParty customer : customerList) {
            if(predicate.check(customer)) {
                functor.updateBalance(customer);
            }
        }
        updateView();
    }

//    public void deposit(String accountNumber, double value) {
//        Customer customer = this.getCustomerByAccountNumber(accountNumber);
//        customer.getAccounts().get(0).deposit(value, "");
//        updateView();
//    }
//
//    public void withdraw(String accountNumber, double value) {
//        Customer customer = this.getCustomerByAccountNumber(accountNumber);
//        customer.getAccounts().get(0).withdraw(value);
//        updateView();
//    }
    
    public void addInterest() {
        for(IParty party : getCustomerList()) {
            Customer customer = (Customer)party;
            for(IAccount account : customer.getAccounts()) {
                BankAccount bankAccount = (BankAccount)account;
                bankAccount.addInterest();
            }
        }
        updateView();
    }

    public Customer getCustomerByAccountNumber(String accountNumber) {
        Iterator it = customerList.iterator();
        while (it.hasNext()) {
            Customer cus = (Customer) it.next();
            if (cus.getAccount().getAccountNumber().equals(accountNumber)) {
                return cus;
            }
        }
        return null;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void updateView() {
        for (Observer ob : observers) {
            ob.updateView();
        }
    }

}
