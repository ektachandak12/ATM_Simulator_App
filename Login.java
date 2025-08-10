import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Login implements ActionListener {

    JFrame frame ;
    JLabel label, text, cardno, pin ;
    JTextField cardTextField;
    JPasswordField pinTextField ;
    JButton login, clear, signup ;
    private JComponent s;

    public Login(){
        initialize();
    }

    private void initialize(){
        frame = new JFrame();
        frame.setTitle("AUTOMATED TELLER MACHINE");
        frame.setSize(800,480);
        frame.setLocation(350,200);
        frame.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        label = new JLabel(i3);
        label.setBounds(70,10,100,100);

        frame.add(label);

        frame.getContentPane().setBackground(Color.WHITE);

        text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200,40,400,40);
        frame.add(text);

        cardno = new JLabel("Card No. : ");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120,150,150,30);
        frame.add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 260, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 28));
        frame.add(cardTextField);

        pin = new JLabel("Pin : ");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120,220,250,30);
        frame.add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 260, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 28));
        frame.add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        frame.add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        frame.add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        frame.add(signup);


        this.frame.setVisible(true);

    }

    public static void main(String[] args) {
        new Login();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if (e.getSource() == login){
            Conn c = new Conn();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
            String query = "select * from login where cardNum = '"+cardNumber+"' and pinNum = '"+pinNumber+"'  ";
            try{
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    frame.setVisible(false);
                    new Transactions(pinNumber);
                } else if (!cardNumber.matches("^\\d{16}$")) {
                    JOptionPane.showMessageDialog(null, "Invalid Card Number! It must be 16 digits.");
                } else if (!pinNumber.matches("^\\d{4}$")) {
                    JOptionPane.showMessageDialog(null, "Invalid PIN! It must be exactly 4 digits.");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Card number or PIN");
                }
            }catch(Exception ex){
                System.out.println(ex);
            }

        }else if(e.getSource() == signup){
            frame.setVisible(false);
            SignUpOne s = new SignUpOne("");
            this.s.setVisible(true);
        }


    }
}
