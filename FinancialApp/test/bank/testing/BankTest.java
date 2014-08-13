/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.testing;

import bank.factory.BankFactory;
import bank.models.CustomerCompany;
import bank.models.CustomerPerson;
import bank.views.BankAccountForm;
import framework.Customer;
import framework.Invoker;
import framework.factory.IFactory;
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
public class BankTest {

    private Invoker invoker = new Invoker();
    BankAccountForm accountForm = new BankAccountForm(invoker, "personal");
    IFactory factory = new BankFactory();

    public BankTest() {

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
    public void isPersonalCustomer() {
        Customer customer = factory.createCustomer(accountForm);
        Assert.assertTrue("customer should be instance of CustomerPerson", customer instanceof CustomerPerson);

    }
    
    @Test
    public void isCompanyCustomer() {
        accountForm = new BankAccountForm(invoker, "company");
        Customer customer = factory.createCustomer(accountForm);
        Assert.assertTrue("customer should be instance of CustomerCompany", customer instanceof CustomerCompany);

    }
}
