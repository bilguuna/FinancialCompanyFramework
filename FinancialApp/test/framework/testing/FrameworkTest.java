/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.testing;

import framework.Customer;
import framework.Invoker;
import framework.Receiver;
import framework.factory.Factory;
import framework.factory.IFactory;
import framework.view.DefaultAccountForm;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Bilguun
 */
public class FrameworkTest {

    private Invoker invoker = new Invoker();
    private Receiver receiver = Receiver.getInstance();
    DefaultAccountForm accountForm = new DefaultAccountForm(invoker, receiver);
    IFactory factory = new Factory();

    public FrameworkTest() {
        accountForm.setName("John");
        accountForm.setAccountNumber("100");
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void isNameJohn() {
        Customer customer = factory.createCustomer(accountForm);
        Assert.assertTrue("customer should be John", "John".equals(customer.getName()));

    }
    
    @Test
    public void isAccountNumber100() {
        Customer customer = factory.createCustomer(accountForm);
        Assert.assertTrue("Account number should be 100", 
                customer.getAccounts().get(0).getAccountNumber().equals("100"));

    }
    
    @Test
    public void isSingleton() {
        Receiver receiverSame = Receiver.getInstance();
        Assert.assertTrue("Receiver should be singleton", receiver == receiverSame);
    }
}
