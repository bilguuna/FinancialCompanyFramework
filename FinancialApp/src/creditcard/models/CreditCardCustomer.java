/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package creditcard.models;

import framework.Customer;
import framework.DefaultCustomer;
import framework.IAccount;
import framework.IParty;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author javkhlant
 */
public class CreditCardCustomer extends DefaultCustomer {

    private String ccNumber;
    private Date expireDate;
    private final SimpleDateFormat dateFormat;

    public CreditCardCustomer(String name, String street, String city, String state, 
            String zip, String email, IAccount account, String ccNumber, Date expireDate) {
        super(name, street, city, state, zip, email, account);
        this.ccNumber = ccNumber;
        this.expireDate = expireDate;
        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    }
    
    /**
     * @return the ccNumber
     */
    public String getCcNumber() {
        return ccNumber;
    }

    /**
     * @param ccNumber the ccNumber to set
     */
    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    /**
     * @return the expireDate
     */
    public Date getExpireDate() {
        return expireDate;
    }

    /**
     * @param expireDate the expireDate to set
     */
    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }
    
    @Override
    public Object[] getData() {
        return new Object[]{getAccount().getAccountNumber(), getName(), getCcNumber(), dateFormat.format(getExpireDate()), "Credit Card", 0};
    }

    @Override
    public String toString() {
        return "Customer{" + "name=" + getAccount().getAccountNumber() + "name=" + getName() + ", street=" + getStreet() + ", city=" 
                + getCity() + ", state=" + getState() + ", zip=" + getZip() + ", email=" 
                + getEmail() + ", ccNumber=" + getCcNumber() + ", ExpireDate=" + getExpireDate() + '}';
    }
}
