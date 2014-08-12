/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package framework.command;

import framework.Receiver;
import framework.functor.IFunctor;
import framework.predicate.IPredicate;

/**
 *
 * @author mkong
 */
public class DepositCommand implements ICommand {

    //private Receiver receiver;
    private String accountNumber;
    private double amount;
    private IFunctor functor;
    private IPredicate predicate;
    
    public DepositCommand(String accountNumber, double amount) {
        //this.receiver = receiver;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }
    
    public DepositCommand(IFunctor functor, IPredicate predicate) {
        //this.receiver = receiver;
        this.functor = functor;
        this.predicate = predicate;
    }

    @Override
    public void execute() {
        //Receiver.getInstance().deposit(accountNumber, amount);
        Receiver.getInstance().updateBalance(functor, predicate);
    }
    
}
