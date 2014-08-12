/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bank.models;

import framework.Customer;
import framework.ICompany;
import framework.IParty;

/**
 *
 * @author Bilguun
 */
public class CustomerCompany extends Customer implements ICompany {

    public CustomerCompany(String name, String street, String city, String State, String zip, String email) {
        super(name, street, city, State, zip, email);
    }

    @Override
    public void sendEmailToCustomer(IParty customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
