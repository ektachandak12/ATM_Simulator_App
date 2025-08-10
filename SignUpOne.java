import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class SignUpOne implements ActionListener {

    long random;
    String formno;
    private JFrame frame;
    private JLabel formnoLabel, personalDetails, name, fname, dob, gender, email, maritalStatus, address, city, state, pincode;
    private JTextField nameTextField, fnameTextField, emailTextField, addresssTextField, cityTextField, stateTextField, pincodeTextField;
    private JRadioButton male, female, other, married, unmarried, divorced;
    private JButton next;
    JDateChooser dateChooser;


    public SignUpOne(String formno) {
        this.formno = formno;
        initialize();
    }

    public void initialize() {
        frame = new JFrame();
        frame.setSize(850, 740);
        frame.setLocation(350, 10);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(null);

        Random ran = new Random();
        random = (Math.abs((ran.nextLong() % 9000L) + 1000L));

        formnoLabel = new JLabel("APPLICATION FORM NO. " + random);
        formnoLabel.setFont(new Font("Raleway", Font.BOLD, 38));
        formnoLabel.setBounds(140, 20, 600, 40);
        frame.add(formnoLabel);

        personalDetails = new JLabel("Page 1 : Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(290, 80, 400, 30);
        frame.add(personalDetails);

        name = new JLabel("Name : ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        frame.add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        frame.add(nameTextField);

        fname = new JLabel("Father's Name : ");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        frame.add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(300, 190, 400, 30);
        frame.add(fnameTextField);

        dob = new JLabel("Date Of Birth : ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        frame.add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(Color.BLACK);
        frame.add(dateChooser);

        gender = new JLabel("Gender : ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        frame.add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.WHITE);
        frame.add(male);

        female = new JRadioButton("Female");
        female.setBounds(450, 290, 120, 30);
        female.setBackground(Color.WHITE);
        frame.add(female);

        other = new JRadioButton("Other");
        other.setBounds(600, 290, 120, 30);
        other.setBackground(Color.WHITE);
        frame.add(other);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);


        email = new JLabel("Email : ");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        frame.add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 340, 400, 30);
        frame.add(emailTextField);

        maritalStatus = new JLabel("Marital Status : ");
        maritalStatus.setFont(new Font("Raleway", Font.BOLD, 20));
        maritalStatus.setBounds(100, 390, 200, 30);
        frame.add(maritalStatus);

        married = new JRadioButton("Married");
        married.setBounds(300, 390, 120, 30);
        married.setBackground(Color.WHITE);
        frame.add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 120, 30);
        unmarried.setBackground(Color.WHITE);
        frame.add(unmarried);

        divorced = new JRadioButton("Divorced");
        divorced.setBounds(600, 390, 120, 30);
        divorced.setBackground(Color.WHITE);
        frame.add(divorced);

        ButtonGroup mStatusGroup = new ButtonGroup();
        mStatusGroup.add(married);
        mStatusGroup.add(unmarried);
        mStatusGroup.add(divorced);

        address = new JLabel("Address : ");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        frame.add(address);

        addresssTextField = new JTextField();
        addresssTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addresssTextField.setBounds(300, 440, 400, 30);
        frame.add(addresssTextField);

        city = new JLabel("City : ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        frame.add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300, 490, 400, 30);
        frame.add(cityTextField);

        state = new JLabel("State : ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        frame.add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300, 540, 400, 30);
        frame.add(stateTextField);

        pincode = new JLabel("Pin Code : ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        frame.add(pincode);

        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodeTextField.setBounds(300, 590, 400, 30);
        frame.add(pincodeTextField);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 645, 80, 30);
        next.addActionListener(this);
        frame.add(next);

        this.frame.setVisible(true);

    }


    public static void main(String[] args) {
        new SignUpOne("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        formno = "" + random; //long to string conversion

        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();

        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        } else if (other.isSelected()) {
            gender = "Other";
        }
        String email = emailTextField.getText();
        String maritalStatus = null;
        if (married.isSelected()) {
            maritalStatus = "Married";
        } else if (unmarried.isSelected()) {
            maritalStatus = "Unmarried";
        } else if (divorced.isSelected()) {
            maritalStatus = "Divorced";
        }
        String address = addresssTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pincode = pincodeTextField.getText();

        try {
            if (name.equals("") || fname.equals("") || dob.equals("") || email.equals("") || address.equals("") || city.equals("") || state.equals("") || pincode.equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the details");
            } else if (!pincode.matches("^\\d{6}$")) {
                JOptionPane.showMessageDialog(null, "Invalid Pin-Code format!\nIt must be a 6-digit number.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }else {
                Conn c = new Conn();
                String query = "insert into signup values('" + formno + "', '" + name + "', '" + fname + "', '" + dob + "' , '" + gender + "' , '" + email + "' , '" + maritalStatus + "', '" + address + "', '" + city + "', '" + state + "', '" + pincode + "')";
                c.s.executeUpdate(query);

                frame.setVisible(false);
                new SignUpTwo(formno);  // This will show the next frame

            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }
}