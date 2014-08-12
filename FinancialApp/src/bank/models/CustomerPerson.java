/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bank.models;

import framework.Customer;
import framework.ICompany;

/**
 *
 * @author Bilguun
 */
public class CustomerPerson extends Customer implements ICompany {
    private int numberOfEmp;

    public CustomerPerson(String name, String street, String city, String State, String zip, String email, int numberOfEmp) {
        super(name, street, city, State, zip, email);
        this.numberOfEmp = numberOfEmp;
    }

    
    
}
