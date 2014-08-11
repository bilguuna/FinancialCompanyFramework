package fw.factory;

import FW.Account;
import FW.Customer;

public interface IFactory {
    
    public Customer createCustomer();
    public Account createAccount();
    
}
