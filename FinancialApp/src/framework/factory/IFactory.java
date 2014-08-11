package framework.factory;

import framework.Account;
import framework.Customer;
import framework.view.DefaultAccountForm;

public interface IFactory {
    
    public Customer createCustomer(DefaultAccountForm defaultAcc);
    public Account createAccount();
    
}
