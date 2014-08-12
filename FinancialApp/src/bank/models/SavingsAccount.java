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
public class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountNumber, double interestRate, String accountType) {
        super(accountNumber, interestRate, accountType);
    }
}
