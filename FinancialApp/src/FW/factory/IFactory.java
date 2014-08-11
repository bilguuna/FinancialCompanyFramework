package fw.factory;

import FW.Account;
import FW.Customer;
import FW.DefaultAccountForm;

public interface IFactory {
    
    public Customer createCustomer(DefaultAccountForm defaultAcc);
    public Account createAccount();
    
}
