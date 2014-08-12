package framework.factory;

import framework.Account;
import framework.Customer;

public abstract class AbstractFactory<T> implements IFactory<T>{
    
    @Override
    public abstract Customer createCustomer(T defaultAcc);
    @Override
    public abstract Account createAccount();
    
}
