package framework;

import framework.view.FrameworkMainForm;
import framework.view.MainForm;

public class FinancialApp {
    public static void main(String[] args) {
        MainForm mainForm = new FrameworkMainForm("Financial Framework");
        mainForm.setVisible(true);
    }
}