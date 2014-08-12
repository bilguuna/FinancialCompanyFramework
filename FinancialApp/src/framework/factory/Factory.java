package framework.factory;

import framework.Account;
import framework.Customer;
import framework.DefaultAccount;
import framework.view.DefaultAccountForm;
import framework.DefaultCustomer;

public class Factory extends AbstractFactory {

    @Override
    public Customer createCustomer(DefaultAccountForm defaultAcc) {
        return new DefaultCustomer(defaultAcc.getName(), defaultAcc.getStreet(), defaultAcc.getCity(), defaultAcc.getState(), defaultAcc.getZip(), defaultAcc.getEmail(), new DefaultAccount(defaultAcc.getAccountNumber()));
    }

    @Override
    public Account createAccount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
