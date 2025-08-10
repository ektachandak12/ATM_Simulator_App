import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BalanceEnquiry implements ActionListener {

    JFrame frame;
    JLabel imgLabel , text ;
    JButton back ;
    String pinNumber ;
    private JComponent t;

    public BalanceEnquiry(String pinNumber){
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

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        imgLabel.add(back);

        int balance = 0;
        Conn c = new Conn();
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pinNum = '" + pinNumber + "'");

            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt((rs.getString("amount")));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

            frame.setUndecorated(true);
            this.frame.setVisible(true);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        text = new JLabel("Your current account balance is : " + balance);
        text.setForeground(Color.WHITE);
        text.setBounds(170,300,400,30);
        imgLabel.add(text);

    }
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.frame.setVisible(false);
        Transactions t = new Transactions(pinNumber);
        this.t.setVisible(true);
    }
}
