/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package framework.predicate;

import framework.Customer;
import framework.IParty;

/**
 *
 * @author Marlin
 */
public class Predicate implements IPredicate {
    
    private String accountNumber;

    public Predicate(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    @Override
    public boolean check(IParty customer) {
        if(((Customer)customer).getAccount().getAccountNumber().equals(accountNumber)) {
            return true;
        }
        return false;
    }
    
}
