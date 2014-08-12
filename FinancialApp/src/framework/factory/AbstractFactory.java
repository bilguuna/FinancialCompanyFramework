package framework.factory;

import framework.Account;
import framework.Customer;

public abstract class AbstractFactory<T> implements IFactory<T>{
    
    @Override
    public abstract Customer createCustomer(T e);
    
    @Override
    public abstract Account createAccount();
    
}
