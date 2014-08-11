package framework.view;

import framework.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MainForm extends JFrame {

    private JPanel JPanel1 = new JPanel();
    private JButton JButton_addAcc = new JButton();
    private JButton JButton_Deposit = new JButton();
    private JButton JButton_Withdraw = new JButton();
    private JButton JButton_Exit = new JButton();
    private DefaultTableModel model;
    private JTable JTable1;
    private JScrollPane JScrollPane1;

    private MainForm framework;
    private boolean newaccount;
    private Object rowdata[];
    private Invoker invoker = new Invoker();
    private Receiver receiver = new Receiver();
    private String title;
    

    public MainForm(String title) {

        framework = this;

        setTitle(title);
        setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(0, 0));
        setSize(590, 330);
        setVisible(false);
        JPanel1.setLayout(null);
        getContentPane().add(BorderLayout.CENTER, JPanel1);
        JPanel1.setBounds(0, 0, 575, 310);
        /*
         /Add five buttons on the pane 
         /for Adding personal account, Adding company account
         /Deposit, Withdraw and Exit from the system
         */
        JScrollPane1 = new JScrollPane();
        model = new DefaultTableModel();
        JTable1 = new JTable(model);
        model.addColumn("AccountNr");
        model.addColumn("Name");
        model.addColumn("City");
        model.addColumn("Customer type");
        model.addColumn("Account type");
        model.addColumn("Amount");
        rowdata = new Object[8];
        newaccount = false;

        JPanel1.add(JScrollPane1);
        JScrollPane1.setBounds(12, 92, 444, 160);
        JScrollPane1.getViewport().add(JTable1);
        JTable1.setBounds(0, 0, 420, 0);
//        rowdata = new Object[8];

        JButton_addAcc.setText("Add Default Account");
        JPanel1.add(JButton_addAcc);
        JButton_addAcc.setBounds(24, 20, 192, 33);

        JButton_Deposit.setText("Deposit");
        JPanel1.add(JButton_Deposit);
        JButton_Deposit.setBounds(468, 104, 96, 33);
        
        JButton_Withdraw.setText("Withdraw");
        JPanel1.add(JButton_Withdraw);
        JButton_Withdraw.setBounds(468, 164, 96, 33);
        
        JButton_Exit.setText("Exit");
        JPanel1.add(JButton_Exit);
        JButton_Exit.setBounds(468, 248, 96, 31);
        // lineBorder1.setRoundedCorners(true);
        // lineBorder1.setLineColor(java.awt.Color.green);
        //$$ lineBorder1.move(24,312);

        JButton_addAcc.setActionCommand("jbutton");

        SymWindow aSymWindow = new SymWindow();
        this.addWindowListener(aSymWindow);
        SymAction lSymAction = new SymAction();
        JButton_Exit.addActionListener(lSymAction);
        JButton_addAcc.addActionListener(lSymAction);
        JButton_Deposit.addActionListener(lSymAction);
        JButton_Withdraw.addActionListener(lSymAction);
    }
    
    class SymWindow extends WindowAdapter {

        public void windowClosing(WindowEvent event) {
            Object object = event.getSource();
            if (object == this) {
                framework_windowClosing(event);
            }
        }
    }

    class SymAction implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            Object object = event.getSource();
            if (object == JButton_Exit) {
                JButtonExit_actionPerformed(event);
            } else if(object == JButton_addAcc) {
                JButtonAddDefault_actionPerformed(event);
            } else if(object == JButton_Deposit) {
                JButtonDeposit_actionPerformed(event);
            } else if(object == JButton_Withdraw) {
                JButtonWithdraw_actionPerformed(event);
            }
        }
    }
    
    void JButtonExit_actionPerformed(ActionEvent event) {
        System.exit(0);
    }

    void framework_windowClosing(java.awt.event.WindowEvent event) {
        framework_windowClosing_Interaction1(event);
    }

    void framework_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
        try {
            this.exitApplication();
        } catch (Exception e) {
            e.toString();
        }
    }

    void exitApplication() {
        try {
            this.setVisible(false);    // hide the Frame
            this.dispose();            // free the system resources
            System.exit(0);            // close the application
        } catch (Exception e) {
            e.toString();
        }
    }
    
    void JButtonAddDefault_actionPerformed(ActionEvent event) {
        DefaultAccountForm defaultAcc = new DefaultAccountForm(this.invoker, this.receiver);
        defaultAcc.setBounds(450, 20, 300, 350);
        defaultAcc.show();
        defaultAcc.dispose();
        refreshLIst();
    }
    
    void JButtonDeposit_actionPerformed(ActionEvent event) {
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >= 0) {
            String accnr = (String) model.getValueAt(selection, 0);
            DepositForm depForm = new DepositForm(this.receiver, this.invoker, accnr);
            depForm.setBounds(450, 20, 300, 350);
            depForm.setVisible(true);
            depForm.dispose();
        }
        refreshLIst();
    }
    
    void JButtonWithdraw_actionPerformed(ActionEvent event) {
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >= 0) {
            String accnr = (String) model.getValueAt(selection, 0);
            WithdrawForm depForm = new WithdrawForm(this.receiver, this.invoker, accnr);
            depForm.setBounds(450, 20, 300, 350);
            depForm.setVisible(true);
            depForm.dispose();
        }
        refreshLIst();
    }
    
    public void refreshLIst() {
        model.setRowCount(0);
        Vector<IParty> customers = receiver.getCustomerList();
        Iterator it = customers.iterator();
        while(it.hasNext()) {
            Customer cus = (Customer)it.next();
            model.addRow(cus.getData());            
        }
    }

}