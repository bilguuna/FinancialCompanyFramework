/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bank.models;

import framework.Account;

/**
 *
 * @author Bilguun
 */
public abstract class BankAccount extends Account {
    private double interestRate;
    private String accountType;
    
    public BankAccount(String accountNumber, double interestRate, String accountType) {
        super(accountNumber);
        this.interestRate = interestRate;
        this.accountType = accountType;
    }
    
    public void addInterest(){
        double newValue = this.getBalance() * (1 + interestRate);
        this.setBalance(newValue);
    }

    public String getAccountType() {
        return accountType;
    }
    
}
