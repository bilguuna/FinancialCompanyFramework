/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package creditcard.factory;

import framework.Account;
import framework.Customer;
import framework.factory.AbstractFactory;
import framework.view.DefaultAccountForm;

/**
 *
 * @author javkhlant
 */
public class CreditCardCustomerFactory extends AbstractFactory {

    @Override
    public Account createAccount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer createCustomer(Object defaultAcc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
