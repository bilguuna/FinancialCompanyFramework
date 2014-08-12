/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.models;

import framework.Customer;
import framework.IAccount;
import framework.IPerson;

/**
 *
 * @author Bilguun
 */
public class CustomerPerson extends Customer implements IPerson {

    private int numberOfEmp;

    public CustomerPerson(String name, String street, String city, String State, String zip, String email, int numberOfEmp, IAccount account) {
        super(name, street, city, State, zip, email);
        this.numberOfEmp = numberOfEmp;
        super.addAccount(account);

    }

    @Override
    public Object[] getData() {
        BankAccount account = (BankAccount) getAccounts().get(0);
        return new Object[]{account.getAccountNumber(), this.getName(), this.getCity(), "Person",
            account.getAccountType(), account.getBalance()};
    }

}
