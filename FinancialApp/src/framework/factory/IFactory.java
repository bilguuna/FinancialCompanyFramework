package framework.factory;

import framework.Account;
import framework.Customer;

public interface IFactory<T> {
    
    public Customer createCustomer(T e);
    
    public Account createAccount();
    
}
