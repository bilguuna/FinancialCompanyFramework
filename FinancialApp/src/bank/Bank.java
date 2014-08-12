package bank;

import bank.views.BankMainForm;
import framework.view.MainForm;

public class Bank {
    public static void main(String[] args) {
        MainForm mainForm = new BankMainForm("Bank system");
        mainForm.setVisible(true);
    }
}