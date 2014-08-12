package framework.view;

import framework.*;
import framework.observer.Observer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public abstract class MainForm extends JFrame{

    protected JPanel JPanel1 = new JPanel();
    private JButton JButton_Deposit = new JButton();
    private JButton JButton_Withdraw = new JButton();
    private JButton JButton_Exit = new JButton();
    protected DefaultTableModel model;
    protected JTable JTable1;
    protected JScrollPane JScrollPane1;
    protected Invoker invoker = new Invoker();
    protected Receiver receiver;

    public MainForm(String title) {

        setTitle(title);
        setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(0, 0));
        setSize(590, 330);
        setVisible(false);
        JPanel1.setLayout(null);
        getContentPane().add(BorderLayout.CENTER, JPanel1);
        JPanel1.setBounds(0, 0, 575, 310);
        JScrollPane1 = new JScrollPane();
        JPanel1.add(JScrollPane1);
        JScrollPane1.setBounds(12, 92, 444, 160);
       
        model = new DefaultTableModel();
        drawColumns();
//        drawButtons();
        
        JButton_Deposit.setText("Deposit");
        JPanel1.add(JButton_Deposit);
        JButton_Deposit.setBounds(468, 104, 96, 33);
        
        JButton_Withdraw.setText("Withdraw");
        JPanel1.add(JButton_Withdraw);
        JButton_Withdraw.setBounds(468, 164, 96, 33);
        
        JButton_Exit.setText("Exit");
        JPanel1.add(JButton_Exit);
        JButton_Exit.setBounds(468, 248, 96, 31);
        SymWindow aSymWindow = new SymWindow();
        this.addWindowListener(aSymWindow);
        SymAction lSymAction = new SymAction();
        JButton_Exit.addActionListener(lSymAction);
        JButton_Deposit.addActionListener(lSymAction);
        JButton_Withdraw.addActionListener(lSymAction);
        
        //receiver.addObserver(this);
    }
    
    
    public abstract void drawColumns();
    
    public abstract void drawButtons();

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
    
    void JButtonDeposit_actionPerformed(ActionEvent event) {
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >= 0) {
            String accnr = (String) model.getValueAt(selection, 0);
            DepositForm depForm = new DepositForm(Receiver.getInstance(), this.invoker, accnr);
            depForm.setBounds(450, 20, 300, 350);
            depForm.setVisible(true);
            depForm.dispose();
        }
        //refreshLIst();
    }
    
    void JButtonWithdraw_actionPerformed(ActionEvent event) {
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >= 0) {
            String accnr = (String) model.getValueAt(selection, 0);
            WithdrawForm depForm = new WithdrawForm(Receiver.getInstance(), this.invoker, accnr);
            depForm.setBounds(450, 20, 300, 350);
            depForm.setVisible(true);
            depForm.dispose();
        }
        //refreshLIst();
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
