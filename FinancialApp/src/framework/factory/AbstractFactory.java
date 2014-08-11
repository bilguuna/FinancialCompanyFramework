package framework.factory;

import framework.Account;
import framework.Customer;
import framework.view.DefaultAccountForm;

public abstract class AbstractFactory implements IFactory{
    
    @Override
    public abstract Customer createCustomer(DefaultAccountForm defaultAcc);
    @Override
    public abstract Account createAccount();
    
}
