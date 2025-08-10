import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.sql.ResultSet;

public class FastCash implements ActionListener {

    private final String pinNumber;
    private JFrame frame;
    private JLabel imgLabel, text ;
    private JButton rs100 , rs500, rs1000, rs2000, rs5000 , rs10000 , back;
    private JComponent d, w, t ;


    public FastCash(String pinNumber) {
        this.pinNumber = pinNumber;
        initialize();
    }
    public void initialize(){

        frame = new JFrame();
        frame.setSize(900,900);
        frame.setLayout(null);
        frame.setLocation(300,0);
        frame.setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);

        imgLabel = new JLabel(image);
        imgLabel.setBounds(0,0,900, 900);
        frame.add(imgLabel);

        text = new JLabel("Select withdrawal amount");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        imgLabel.add(text);

        rs100 = new JButton("Rs 100");
        rs100.setBounds(170,415,150,30);
        rs100.addActionListener(this);
        imgLabel.add(rs100);

        rs500 = new JButton("Rs 500");
        rs500.setBounds(355,415,150,30);
        rs500.addActionListener(this);
        imgLabel.add(rs500);

        rs1000 = new JButton("Rs 1000");
        rs1000.setBounds(170,450,150,30);
        rs1000.addActionListener(this);
        imgLabel.add(rs1000);

        rs2000 = new JButton("Rs 2000");
        rs2000.setBounds(355,450,150,30);
        rs2000.addActionListener(this);
        imgLabel.add(rs2000);

        rs5000 = new JButton("Rs 5000");
        rs5000.setBounds(170,485,150,30);
        rs5000.addActionListener(this);
        imgLabel.add(rs5000);

        rs10000 = new JButton("Rs 10000");
        rs10000.setBounds(355,485,150,30);
        rs10000.addActionListener(this);
        imgLabel.add(rs10000);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        imgLabel.add(back);


        frame.setUndecorated(true); //to remove the above bar which has minimize, maximize, and exit button
        this.frame.setVisible(true);

    }

    public static void main(String[] args) {
        new FastCash("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            this.frame.setVisible(false);
            Transactions t = new Transactions(pinNumber);
            this.t.setVisible(true);

        }else{
            String amount = ((JButton) e.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pinNum = '"+pinNumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt((rs.getString("amount")));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(e.getSource() != back && balance < Integer.parseInt(amount) ){
                    JOptionPane.showMessageDialog(null,"Insufficient balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinNumber+"' , '"+date+"', 'Withdraw', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + amount + " debited successfully.");

                this.frame.setVisible(false);
                Transactions t = new Transactions(pinNumber);
                this.t.setVisible(true);

            }catch(Exception ex){
                System.out.println(ex);
            }


        }
    }
}
