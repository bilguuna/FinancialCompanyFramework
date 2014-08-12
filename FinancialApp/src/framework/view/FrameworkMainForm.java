/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTable;

/**
 *
 * @author mkong
 */
public class FrameworkMainForm extends MainForm {

    private JButton JButton_addAcc = new JButton();
    private SymAction lSymAction = new SymAction();

    public FrameworkMainForm(String title) {
        super(title);
        JButton_addAcc.setActionCommand("jbutton");
        JButton_addAcc.addActionListener(lSymAction);
        drawButtons();
    }

    class SymAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            DefaultAccountForm defaultAcc = new DefaultAccountForm(invoker, receiver);
            defaultAcc.setBounds(450, 20, 300, 350);
            defaultAcc.setVisible(true);
            defaultAcc.dispose();
            refreshLIst();
        }
    }

    @Override
    public void drawColumns() {
        String[] columns = new String[]{"AccountNr", "Name", "City", "Customer type", "Account type", "Amount"};
        for (int i = 0; i < columns.length; i++) {
            model.addColumn(columns[i]);
        }
        JTable1 = new JTable(model);
        JTable1.setBounds(0, 0, 420, 0);
        JScrollPane1.getViewport().add(JTable1);
    }

    @Override
    public final void drawButtons() {
        JButton_addAcc.setText("Add Default Account");
        JPanel1.add(JButton_addAcc);
        JButton_addAcc.setBounds(24, 20, 192, 33);
    }

}
