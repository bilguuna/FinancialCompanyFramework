package framework.factory;

import framework.Account;
import framework.Customer;
import framework.DefaultAccount;
import framework.view.DefaultAccountForm;
import framework.DefaultCustomer;

public class FrameworkFactory<T> extends AbstractFactory<T>{

    @Override
    public Customer createCustomer(T defaultAcc) {
        DefaultAccountForm accountForm = (DefaultAccountForm)defaultAcc;
        return new DefaultCustomer(accountForm.getName(), accountForm.getStreet(), accountForm.getCity(), 
                accountForm.getState(), accountForm.getZip(), accountForm.getEmail(), new DefaultAccount(accountForm.getAccountNumber()));
    }

    @Override
    public Account createAccount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
