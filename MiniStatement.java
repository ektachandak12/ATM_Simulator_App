import javax.swing.*;
import java.sql.ResultSet;

public class MiniStatement {
    JFrame frame;
    String pinNumber;
    JLabel balance, bank, mini, card ;

    public MiniStatement(String pinNumber){
        this.pinNumber =  pinNumber;
        initialize();
    }

    public void initialize(){
        frame = new JFrame();
        frame.setLayout(null);
        frame.setTitle("Mini Statement");
        frame.setSize(400,600);
        frame.setLocation(20,20);


        mini = new JLabel();
        mini.setBounds(20,140,400,200);
        frame.add(mini);

        bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        frame.add(bank);

        card = new JLabel();
        card.setBounds(20,80,300,20);
        frame.add(card);

        balance = new JLabel();
        balance.setBounds(20,400,300,20);
        frame.add(balance);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pinNum = '"+pinNumber+"'  ");
            while(rs.next()){
                card.setText("Card Number : " + rs.getString("cardNum").substring(0,4) + "XXXXXXXX" + rs.getString("cardNum").substring(12));
            }

        }catch(Exception e){
            System.out.println(e);
        }

        try{
            Conn c = new Conn();
            int bal = 0;
            ResultSet rs = c.s.executeQuery("select * from bank where pinNum = '"+pinNumber+"'  ");
            while(rs.next()){
                mini.setText(mini.getText() +  "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>" );
                if(rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt((rs.getString("amount")));
                }else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your current account balance is : Rs " + bal);

        }catch(Exception e){
            System.out.println(e);
        }

        this.frame.setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
