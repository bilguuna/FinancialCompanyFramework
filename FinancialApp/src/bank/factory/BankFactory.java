package bank.factory;

import bank.models.CheckingsAccount;
import bank.models.CustomerCompany;
import bank.models.CustomerPerson;
import bank.models.SavingsAccount;
import bank.views.BankAccountForm;
import framework.factory.*;
import framework.Account;
import framework.Customer;
import framework.IAccount;

public class BankFactory<T> extends AbstractFactory<T>{

    @Override
    public Customer createCustomer(T e) {
        BankAccountForm accountForm = (BankAccountForm)e;
        IAccount account = (accountForm.getJRadioButton_Chk().isSelected()) 
                ? new CheckingsAccount(accountForm.getAccountNumber(), 0.8, "Checking")
                : new SavingsAccount(accountForm.getAccountNumber(), 0.6, "Saving");
        
        if(accountForm.getCustomerType().equalsIgnoreCase("personal"))
            return new CustomerPerson(accountForm.getName(), accountForm.getStreet(), accountForm.getCity(), 
                accountForm.getState(), accountForm.getZip(), accountForm.getEmail(), 0, account);
        else
            return new CustomerCompany(accountForm.getName(), accountForm.getStreet(), accountForm.getCity(), 
                accountForm.getState(), accountForm.getZip(), accountForm.getEmail(), 0, account);
    }

    @Override
    public Account createAccount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
