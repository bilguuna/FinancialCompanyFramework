/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.views;

import framework.Receiver;
import framework.observer.Observer;
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
public class BankMainForm extends MainForm implements Observer {
    JButton JButton_PerAC = new javax.swing.JButton();
    JButton JButton_CompAC = new javax.swing.JButton();
    private SymAction lSymAction = new SymAction();

    public BankMainForm(String title) {
        super(title);
        drawButtons();
        receiver = Receiver.getInstance();
        receiver.addObserver(this);
        JButton_PerAC.addActionListener(lSymAction);
    }

    @Override
    public void updateView() {
        refreshLIst();
    }
    
    class SymAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            DefaultAccountForm bankAccount = new BankAccountForm(invoker, receiver, "asd");
            bankAccount.setBounds(450, 20, 300, 350);
            bankAccount.setVisible(true);
            bankAccount.dispose();
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
        JButton_PerAC.setText("Add personal account");
        JPanel1.add(JButton_PerAC);
        JButton_PerAC.setBounds(24, 20, 192, 33);
        JButton_CompAC.setText("Add company account");
        JButton_CompAC.setActionCommand("jbutton");
        JPanel1.add(JButton_CompAC);
        JButton_CompAC.setBounds(240, 20, 192, 33);
    }
    
}
