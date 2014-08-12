package framework;

import framework.view.FrameworkMainForm;
import framework.view.MainForm;

public class FinancialApp {
    public static void main(String[] args) {
//        String laf = UIManager.getSystemLookAndFeelClassName();
//        try {
//            UIManager.setLookAndFeel(laf);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(FinancialApp.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            Logger.getLogger(FinancialApp.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            Logger.getLogger(FinancialApp.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (UnsupportedLookAndFeelException ex) {
//            Logger.getLogger(FinancialApp.class.getName()).log(Level.SEVERE, null, ex);
//        }
        MainForm mainForm = new FrameworkMainForm("Financial Framework");
        mainForm.setVisible(true);
    }
}