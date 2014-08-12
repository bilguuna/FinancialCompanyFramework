package framework;

import framework.observer.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Receiver {

    private Vector<IParty> customerList;
    private List<Observer> observers;

    public Receiver() {
        customerList = new Vector<>();
        observers = new ArrayList<>();
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

    public void deposit(String accountNumber, double value) {
        Customer customer = this.getCustomerByAccountNumber(accountNumber);
        customer.getAccounts().get(0).deposit(value);
        updateView();
    }

    public void withdraw(String accountNumber, double value) {
        Customer customer = this.getCustomerByAccountNumber(accountNumber);
        customer.getAccounts().get(0).withdraw(value);
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
