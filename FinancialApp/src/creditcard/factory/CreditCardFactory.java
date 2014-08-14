/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package creditcard.factory;

import creditcard.models.BronzeCreditCardAccount;
import creditcard.models.CreditCardCustomer;
import creditcard.models.GoldCreditCardAccount;
import creditcard.models.SilverCreditCardAccount;
import creditcard.views.CreditCardAccountForm;
import framework.Account;
import framework.Customer;
import framework.factory.AbstractFactory;

/**
 *
 * @author javkhlant
 * @param <T>
 */
public class CreditCardFactory<T> extends AbstractFactory<T> {

    @Override
    public Account createAccount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer createCustomer(T e) {
        CreditCardAccountForm form = (CreditCardAccountForm) e;
        if(form.getCardType().equalsIgnoreCase("gold"))
            return new CreditCardCustomer(form.getName(), form.getStreet(), 
                form.getCity(), form.getState(), form.getZip(), form.getEmail(), 
                new GoldCreditCardAccount(form.getAccountNumber(), form.getCardType()), form.getCcnr(), form.getExpDate());
        else if(form.getCardType().equalsIgnoreCase("silver"))
            return new CreditCardCustomer(form.getName(), form.getStreet(), 
                form.getCity(), form.getState(), form.getZip(), form.getEmail(), 
                new SilverCreditCardAccount(form.getAccountNumber(), form.getCardType()), form.getCcnr(), form.getExpDate());
        else
            return new CreditCardCustomer(form.getName(), form.getStreet(), 
                form.getCity(), form.getState(), form.getZip(), form.getEmail(), 
                new BronzeCreditCardAccount(form.getAccountNumber(), form.getCardType()), form.getCcnr(), form.getExpDate());
    }
}
