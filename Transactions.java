import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions implements ActionListener {

    private final String pinNumber;
    private JFrame frame;
    private JLabel imgLabel, text;
    private JButton deposit, cashWithdrawal, fastCash, miniStatement, pinChange, balEnquiry, exit;
    private JComponent d, w, f, p, b, m;


    public Transactions(String pinNumber) {
        this.pinNumber = pinNumber;
        initialize();
    }

    public void initialize() {


        frame = new JFrame();
        frame.setSize(900, 900);
        frame.setLayout(null);
        frame.setLocation(300, 0);
        frame.setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);

        imgLabel = new JLabel(image);
        imgLabel.setBounds(0, 0, 900, 900);
        frame.add(imgLabel);

        text = new JLabel("Please select your transaction");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        imgLabel.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        imgLabel.add(deposit);

        cashWithdrawal = new JButton("Cash Withdrawal");
        cashWithdrawal.setBounds(355, 415, 150, 30);
        cashWithdrawal.addActionListener(this);
        imgLabel.add(cashWithdrawal);

        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(170, 450, 150, 30);
        fastCash.addActionListener(this);
        imgLabel.add(fastCash);

        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(355, 450, 150, 30);
        miniStatement.addActionListener(this);
        imgLabel.add(miniStatement);

        pinChange = new JButton("Pin Change");
        pinChange.setBounds(170, 485, 150, 30);
        pinChange.addActionListener(this);
        imgLabel.add(pinChange);

        balEnquiry = new JButton("Balance Enquiry");
        balEnquiry.setBounds(355, 485, 150, 30);
        balEnquiry.addActionListener(this);
        imgLabel.add(balEnquiry);

        exit = new JButton("Exit");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);
        imgLabel.add(exit);


        frame.setUndecorated(true); //to remove the default title bar
        this.frame.setVisible(true);

    }

    public static void main(String[] args) {
        new Transactions("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            System.exit(0);
        } else if (e.getSource() == deposit) {
            frame.setVisible(false);
            Deposit d = new Deposit(pinNumber);
            this.d.setVisible(true);
        } else if (e.getSource() == cashWithdrawal) {
            this.frame.setVisible(false);
            Withdraw w = new Withdraw(pinNumber);
            this.w.setVisible(true);
        } else if (e.getSource() == fastCash) {
            this.frame.setVisible(false);
            FastCash f = new FastCash(pinNumber);
            this.f.setVisible(true);
        } else if (e.getSource() == pinChange) {
            this.frame.setVisible(false);
            PinChange p = new PinChange(pinNumber);
            this.p.setVisible(true);
        } else if (e.getSource() == balEnquiry) {
            this.frame.setVisible(false);
            BalanceEnquiry b = new BalanceEnquiry(pinNumber);
            this.b.setVisible(true);
        } else if (e.getSource() == miniStatement) {
            MiniStatement m = new MiniStatement(pinNumber);
            this.m.setVisible(true);
        }
    }
}
