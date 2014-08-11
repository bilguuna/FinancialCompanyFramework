/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package framework.command;

import framework.Receiver;

/**
 *
 * @author mkong
 */
public class DepositCommand implements ICommand {

    private Receiver receiver;
    private String accountNumber;
    private double amount;
    
    public DepositCommand(Receiver receiver, String accountNumber, double amount) {
        this.receiver = receiver;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    @Override
    public void execute() {
        receiver.deposit(accountNumber, amount);
    }
    
}
