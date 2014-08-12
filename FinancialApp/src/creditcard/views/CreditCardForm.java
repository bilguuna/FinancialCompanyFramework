/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package creditcard.views;

import creditcard.models.CreditCardCustomer;
import framework.Customer;
import framework.IParty;
import framework.Receiver;
import framework.observer.Observer;
import framework.view.MainForm;
import framework.view.WithdrawForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTable;

/**
 *
 * @author javkhlant
 */
public class CreditCardForm extends MainForm implements Observer {

    private JButton JButton_addAcc = new JButton();
    private SymAction lSymAction = new SymAction();
    private Receiver receiver;
    
    public CreditCardForm(String title) {
        super(title);
        JButton_addAcc.setActionCommand("jbutton");
        JButton_addAcc.addActionListener(lSymAction);
        drawButtons();
        receiver = Receiver.getInstance();
        receiver.addObserver(this);
    }

    @Override
    public void updateView() {
        model.setRowCount(0);
        Vector<IParty> customers = receiver.getCustomerList();
        Iterator it = customers.iterator();
        while (it.hasNext()) {
            Customer cus = (Customer) it.next();
            model.addRow(cus.getData());
        }
    }
    
    class SymAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            JDialog defaultAcc = new CreditCardAccountForm(invoker, receiver);
            defaultAcc.setBounds(450, 20, 300, 350);
            defaultAcc.setVisible(true);
            defaultAcc.dispose();
            refreshLIst();
        }
    }

    @Override
    public void drawColumns() {
        String[] columns = new String[]{"Account Nr", "Name", "CC number", 
            "Expire date", "Type", "Balance"};
        for (String column : columns) {
            model.addColumn(column);
        }
        JTable1 = new JTable(model);
        JTable1.setBounds(0, 0, 420, 0);
        JScrollPane1.getViewport().add(JTable1);
    }

    @Override
    public final void drawButtons() {
        JButton_addAcc.setText("Add Credit-card Account");
        JPanel1.add(JButton_addAcc);
        JButton_addAcc.setBounds(24, 20, 192, 33);
        JButton_Withdraw.setText("Charge");
    }
}
