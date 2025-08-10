import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class PinChange implements  ActionListener {
    String pinNumber;
    private JFrame frame;
    private JLabel imgLabel, text, pinText, rePinText;
    private JPasswordField pinTextField, rePinTextField;
    private JButton change, back;
    private JComponent t;
    String rpin;

    public PinChange(String pinNumber) {
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

        text = new JLabel("Change your pin");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 18));
        text.setBounds(250, 280, 500, 35);
        imgLabel.add(text);

        pinText = new JLabel("Enter new PIN:");
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("System", Font.BOLD, 18));
        pinText.setBounds(165, 330, 200, 25);
        imgLabel.add(pinText);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(330, 330, 180, 25);
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 22));
        imgLabel.add(pinTextField);

        rePinText = new JLabel("Re-Enter new PIN:");
        rePinText.setForeground(Color.WHITE);
        rePinText.setFont(new Font("System", Font.BOLD, 18));
        rePinText.setBounds(165, 370, 200, 25);
        imgLabel.add(rePinText);

        rePinTextField = new JPasswordField();
        rePinTextField.setBounds(330, 370, 180, 25);
        rePinTextField.setFont(new Font("Raleway", Font.BOLD, 22));
        imgLabel.add(rePinTextField);

        change = new JButton("Change");
        change.setFont(new Font("Raleway", Font.BOLD, 16));
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        imgLabel.add(change);

        back = new JButton("Back");
        back.setFont(new Font("Raleway", Font.BOLD, 16));
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        imgLabel.add(back);

        frame.setUndecorated(true);
        this.frame.setVisible(true);
    }


    public static void main(String[] args) {
        new PinChange("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == change) {
            try {
                String npin = new String(pinTextField.getPassword());
                String rpin = new String(rePinTextField.getPassword());


                if (!npin.equals(rpin))
                {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not matches");
                    return;
                }else if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter valid PIN");
                    return;
                }else if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                    return;
                }

                if (npin.length() != 4 || !npin.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "PIN must be a 4-digit number");
                    return;
                }


                Conn c = new Conn();
                String query1 = "UPDATE bank SET pinNum = '"+rpin+"' WHERE pinNum = '"+pinNumber+"'";
                String query2 = "UPDATE login SET pinNum = '"+rpin+"' WHERE pinNum = '"+pinNumber+"'";
                String query3 = "UPDATE signupthree SET pinNum = '"+rpin+"' WHERE pinNum = '"+pinNumber+"'";


                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"PIN changed sucessfully");

                this.frame.setVisible(false);
                Transactions t = new Transactions(rpin);
                this.t.setVisible(true);

            } catch (Exception ex) {
                System.out.println(ex);
            }

        }else{
            this.frame.setVisible(false);
            Transactions t = new Transactions(rpin);
            this.t.setVisible(true);
        }
    }
}
