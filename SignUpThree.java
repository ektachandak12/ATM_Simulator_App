import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUpThree implements ActionListener {
    static long random;
    String formno;
    JFrame frame;
    JLabel l1, type, card, number, pin, pnumber, cardDetail, pinDetail, services;
    JRadioButton savingAcc, fdAcc, currentAcc, recurringAcc;
    JCheckBox atmCard, internetBanking, mobileBanking, emailAlerts, chequeBook, eStatement, declaration;
    JButton submit, cancel;
    private JComponent d;
    private JComponent l;

    public SignUpThree(String formno) {
       this.formno = formno;
        initialize();
    }

    public void initialize() {
        frame = new JFrame();
        frame.setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3 ");
        frame.setSize(850, 820);
        frame.setLocation(350, 10);
        frame.setLayout(null);
        frame.setBackground(Color.WHITE);

        l1 = new JLabel("Page 3 : Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        frame.add(l1);

        type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 110, 200, 30);
        frame.add(type);

        savingAcc = new JRadioButton("Savings Account");
        fdAcc = new JRadioButton("Fixed Deposit Account");
        currentAcc = new JRadioButton("Current Account");
        recurringAcc = new JRadioButton("Recurring Deposit Account");

        savingAcc.setFont(new Font("Raleway", Font.BOLD, 16));
        fdAcc.setFont(new Font("Raleway", Font.BOLD, 16));
        currentAcc.setFont(new Font("Raleway", Font.BOLD, 16));
        recurringAcc.setFont(new Font("Raleway", Font.BOLD, 16));

        savingAcc.setBackground(Color.WHITE);
        fdAcc.setBackground(Color.WHITE);
        currentAcc.setBackground(Color.WHITE);
        recurringAcc.setBackground(Color.WHITE);

        savingAcc.setBounds(100, 160, 250, 20);
        fdAcc.setBounds(350, 160, 250, 20);
        currentAcc.setBounds(100, 200, 250, 20);
        recurringAcc.setBounds(350, 200, 250, 20);

        ButtonGroup groupAcc = new ButtonGroup();
        groupAcc.add(savingAcc);
        groupAcc.add(fdAcc);
        groupAcc.add(currentAcc);
        groupAcc.add(recurringAcc);

        frame.add(savingAcc);
        frame.add(fdAcc);
        frame.add(currentAcc);
        frame.add(recurringAcc);

        card = new JLabel("Card Number :");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 250, 200, 30);
        frame.add(card);

        number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330, 250, 300, 30);
        frame.add(number);

        cardDetail = new JLabel("Your 16 Digit Card Number :");
        cardDetail.setFont(new Font("Raleway", Font.BOLD, 12));
        cardDetail.setBounds(100, 290, 300, 20);
        frame.add(cardDetail);

        pin = new JLabel("PIN :");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 340, 200, 30);
        frame.add(pin);

        pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pnumber.setBounds(330, 340, 300, 30);
        frame.add(pnumber);

        pinDetail = new JLabel("Your 4 Digit Password :");
        pinDetail.setFont(new Font("Raleway", Font.BOLD, 12));
        pinDetail.setBounds(100, 370, 300, 20);
        frame.add(pinDetail);

        services = new JLabel("Services Required :");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 415, 400, 30);
        frame.add(services);

        atmCard = new JCheckBox("ATM Card");
        atmCard.setFont(new Font("Raleway", Font.BOLD, 16));
        atmCard.setBackground(Color.WHITE);
        atmCard.setBounds(100, 450, 200, 30);
        frame.add(atmCard);

        internetBanking = new JCheckBox("Internet Banking");
        internetBanking.setFont(new Font("Raleway", Font.BOLD, 16));
        internetBanking.setBackground(Color.WHITE);
        internetBanking.setBounds(350, 450, 200, 30);
        frame.add(internetBanking);

        mobileBanking = new JCheckBox("Mobile Banking");
        mobileBanking.setFont(new Font("Raleway", Font.BOLD, 16));
        mobileBanking.setBackground(Color.WHITE);
        mobileBanking.setBounds(100, 480, 200, 30);
        frame.add(mobileBanking);

        emailAlerts = new JCheckBox("Email Alerts");
        emailAlerts.setFont(new Font("Raleway", Font.BOLD, 16));
        emailAlerts.setBackground(Color.WHITE);
        emailAlerts.setBounds(350, 480, 200, 30);
        frame.add(emailAlerts);

        chequeBook = new JCheckBox("Cheque Book");
        chequeBook.setFont(new Font("Raleway", Font.BOLD, 16));
        chequeBook.setBackground(Color.WHITE);
        chequeBook.setBounds(100, 510, 200, 30);
        frame.add(chequeBook);

        eStatement = new JCheckBox("E-Statement");
        eStatement.setFont(new Font("Raleway", Font.BOLD, 16));
        eStatement.setBackground(Color.WHITE);
        eStatement.setBounds(350, 510, 200, 30);
        frame.add(eStatement);

        declaration = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
        declaration.setFont(new Font("Raleway", Font.BOLD, 14));
        declaration.setBounds(100, 550, 700, 30);
        declaration.setBackground(Color.WHITE);
        frame.add(declaration);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(220, 620, 100, 30);
        submit.addActionListener(this);
        frame.add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420, 620, 100, 30);
        cancel.addActionListener(this);
        frame.add(cancel);

        frame.getContentPane().setBackground(Color.WHITE);
        this.frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String accountType = null;
            if (savingAcc.isSelected()) accountType = "Saving Account";
            else if (fdAcc.isSelected()) accountType = "Fixed Deposit Account";
            else if (currentAcc.isSelected()) accountType = "Current Account";
            else if (recurringAcc.isSelected()) accountType = "Recurring Account";

            Random random = new Random();
            String cardNum = "" + Math.abs((random.nextLong() % 9000000000000000L + 1000000000000000L));
            String pinNum = "" + Math.abs((random.nextInt(9000) + 1000)); // safer than nextLong for 4 digits

            // Concatenate selected services
            String facility = "";
            if (atmCard.isSelected()) facility += "ATM Card ";
            if (internetBanking.isSelected()) facility += "Internet Banking ";
            if (mobileBanking.isSelected()) facility += "Mobile Banking ";
            if (emailAlerts.isSelected()) facility += "Email & SMS Alerts ";
            if (chequeBook.isSelected()) facility += "Cheque Book ";
            if (eStatement.isSelected()) facility += "E-Statement ";

            try {
                // Validations
                if (accountType == null) {
                    JOptionPane.showMessageDialog(null, "Please select an account type.");
                } else if (facility.trim().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please select at least one service.");
                } else if (!declaration.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Please accept the declaration to proceed.");
                }

                else {
                    Conn c = new Conn();
                    String query1 = "INSERT INTO signupthree VALUES('" + formno + "', '" + accountType + "', '" + cardNum + "', '" + pinNum + "', '" + facility.trim() + "')";
                    String query2 = "INSERT INTO login VALUES('" + formno + "', '" + cardNum + "', '" + pinNum + "')";

                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Card Number: " + cardNum + "\nPIN: " + pinNum);
                    if (cardNum.length() != 16 || pinNum.length() != 4) {
                        JOptionPane.showMessageDialog(null, "System error: Generated card or PIN format is invalid.");
                    }else {
                        this.frame.setVisible(false);
                        Deposit d = new Deposit(pinNum);
                        this.d.setVisible(true);
                    }
                }
            } catch (Exception ex) {
                System.out.println("Error: " + ex);
            }

        } else if (e.getSource() == cancel) {
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel?", "Confirm Cancel", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                frame.setVisible(false);
                Login l = new Login();
                this.l.setVisible(true);
            }
        }
    }

    public static void main(String[] args) {
        new SignUpThree("");
    }

//
//    private class Login {
//        private boolean visible;
//
//        public void setVisible(boolean visible) {
//            this.visible = visible;
//        }
//    }
}
