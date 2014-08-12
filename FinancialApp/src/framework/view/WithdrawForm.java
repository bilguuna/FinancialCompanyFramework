package framework.view;

import framework.Invoker;
import framework.Receiver;
import framework.command.DepositCommand;
import framework.command.ICommand;
import framework.command.WithdrawCommand;
import framework.functor.Functor;
import framework.functor.IFunctor;
import framework.predicate.IPredicate;
import framework.predicate.Predicate;

public class WithdrawForm extends javax.swing.JDialog {

    private String accnr;
    private Receiver receiver;
    private Invoker invoker;

    public WithdrawForm(Receiver receiver, Invoker invoker, String aaccnr) {
        accnr = aaccnr;
        this.receiver = receiver;
        this.invoker = invoker;
	setTitle("Withdraw");
        setModal(true);
        getContentPane().setLayout(null);
        setSize(300, 160);
        setVisible(false);
        JLabel1.setText("Acc Nr");
        getContentPane().add(JLabel1);
        JLabel1.setForeground(java.awt.Color.black);
        JLabel1.setBounds(12, 12, 48, 24);
        JLabel2.setText("Amount");
        getContentPane().add(JLabel2);
        JLabel2.setForeground(java.awt.Color.black);
        JLabel2.setBounds(12, 36, 48, 24);
        JTextField_NAME.setEditable(false);
        JTextField_NAME.setText(accnr);
        getContentPane().add(JTextField_NAME);
        JTextField_NAME.setBounds(84, 12, 156, 20);
        getContentPane().add(JTextField_AMT);
        JTextField_AMT.setBounds(84, 36, 156, 20);
        JButton_OK.setText("OK");
        JButton_OK.setActionCommand("OK");
        getContentPane().add(JButton_OK);
        JButton_OK.setBounds(48, 84, 84, 24);
        JButton_Calcel.setText("Cancel");
        JButton_Calcel.setActionCommand("Cancel");
        getContentPane().add(JButton_Calcel);
        JButton_Calcel.setBounds(156, 84, 84, 24);

        JTextField_NAME.setText(accnr);

        SymAction lSymAction = new SymAction();
        JButton_OK.addActionListener(lSymAction);
        JButton_Calcel.addActionListener(lSymAction);

    }

    javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
    javax.swing.JLabel JLabel2 = new javax.swing.JLabel();
    javax.swing.JTextField JTextField_NAME = new javax.swing.JTextField();
    javax.swing.JTextField JTextField_AMT = new javax.swing.JTextField();
    javax.swing.JButton JButton_OK = new javax.swing.JButton();
    javax.swing.JButton JButton_Calcel = new javax.swing.JButton();

    class SymAction implements java.awt.event.ActionListener {

        public void actionPerformed(java.awt.event.ActionEvent event) {
            Object object = event.getSource();
            if (object == JButton_OK) {
                JButtonOK_actionPerformed(event);
            } else if (object == JButton_Calcel) {
                JButtonCalcel_actionPerformed(event);
            }
        }
    }

    void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
        double amount = 0;
        amount = Double.parseDouble(JTextField_AMT.getText());
        //ICommand command = new WithdrawCommand(receiver, accnr, amount);
        IPredicate predicate = new Predicate(accnr);
        IFunctor functor = new Functor("withdraw", amount);
        ICommand command = new WithdrawCommand(receiver, functor, predicate);
        invoker.submit(command);
        dispose();
    }

    void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event) {
        dispose();
    }
}
