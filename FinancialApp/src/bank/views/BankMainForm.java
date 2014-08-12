/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.views;

import framework.view.DefaultAccountForm;
import framework.view.MainForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTable;

/**
 *
 * @author Bilguun
 */
public class BankMainForm extends MainForm {
    JButton JButton_PerAC = new javax.swing.JButton();
    JButton JButton_CompAC = new javax.swing.JButton();
    private SymAction lSymAction = new SymAction();

    public BankMainForm(String title) {
        super(title);
    }
    
    class SymAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            DefaultAccountForm defaultAcc = new DefaultAccountForm(invoker, receiver);
            defaultAcc.setBounds(450, 20, 300, 350);
            defaultAcc.setVisible(true);
            defaultAcc.dispose();
            //refreshLIst();
        }
    }

    @Override
    public void drawColumns() {
        String[] columns = new String[]{"AccountNr", "Name", "City", "P/C", "Ch/S", "Amount"};
        for (int i = 0; i < columns.length; i++) {
            model.addColumn(columns[i]);
        }
        JTable1 = new JTable(model);
        JTable1.setBounds(0, 0, 420, 0);
        JScrollPane1.getViewport().add(JTable1);
    }

    @Override
    public void drawButtons() {

    }

}
