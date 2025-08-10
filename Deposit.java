import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.*;

public class Deposit implements ActionListener {
    String pinNumber;
    JFrame frame;
    JLabel imgLabel, text ;
    JTextField amount;
    JButton deposit, back ;
    private JComponent t;

    public Deposit(String pinNumber){
        this.pinNumber = pinNumber;
        initialize();
    }

    public void initialize(){
        frame = new JFrame();
        frame.setSize(900,900);
        frame.setLocation(300,0);
        frame.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);

        imgLabel = new JLabel(image);
        imgLabel.setBounds(0,0,900, 900);
        frame.add(imgLabel);

        text = new JLabel("Enter the amount you want to deposit : ");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170,300,400,20);
        imgLabel.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD,  22));
        amount.setBounds(170,350,320,25);
        imgLabel.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(355,485,150,30);
        deposit.addActionListener(this);
        imgLabel.add(deposit);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        imgLabel.add(back);


        frame.setUndecorated(true);
        this.frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Deposit("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == deposit){
            String depositAmt = amount.getText();
            Date date = new Date();
            if(depositAmt.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit ");
            }
            else{
                Conn c = new Conn();
                String query = "insert into bank values('"+pinNumber+"',  '"+date+"', '"+ "Deposit" +"', '"+depositAmt+"' ) ";
                try {
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. " + depositAmt + " deposited successfully.");
                    frame.setVisible(false);
                    Transactions t = new Transactions(pinNumber);
                    this.t.setVisible(true);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }

        }else if(e.getSource() == back){
            frame.setVisible(false);
            Transactions t = new Transactions(pinNumber);
            this.t.setVisible(true);
        }
    }
}
