package fw.factory;

import FW.Account;
import FW.Customer;
import FW.DefaultAccount;
import FW.DefaultAccountForm;
import FW.DefaultCustomer;

public class Factory implements IFactory {

    @Override
    public Customer createCustomer(DefaultAccountForm defaultAcc) {
        return new DefaultCustomer(defaultAcc.getName(), defaultAcc.getStreet(), defaultAcc.getCity(), defaultAcc.getState(), defaultAcc.getZip(), defaultAcc.getEmail(), new DefaultAccount(defaultAcc.getAccountNumber()));
    }

    @Override
    public Account createAccount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
