/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package creditcard;

import creditcard.views.CreditCardForm;
import framework.view.MainForm;

/**
 *
 * @author javkhlant
 */
public class CreditCardApp {
    
    public static void main(String[] args) {
        MainForm form = new CreditCardForm("Credit Card Application");
        form.setVisible(true);
    }
}
