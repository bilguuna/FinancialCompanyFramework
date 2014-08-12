/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package creditcard.models;

import framework.Customer;
import framework.IParty;
import java.util.Date;

/**
 *
 * @author javkhlant
 */
public class CreditCardCustomer extends Customer {

    private String ccNumber;
    private Date expireDate;

    public CreditCardCustomer(String name, String street, String city, String State, 
            String zip, String email, String ccNumber, Date expireDate) {
        super(name, street, city, State, zip, email);
        this.ccNumber = ccNumber;
        this.expireDate = expireDate;
    }
    
    @Override
    public void sendEmailToCustomer(IParty customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
