package framework.factory;

import framework.Account;
import framework.Customer;
import framework.view.DefaultAccountForm;

public interface IFactory<T> {
    
    public Customer createCustomer(T defaultAcc);
    public Account createAccount();
    
}
