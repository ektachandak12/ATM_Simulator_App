import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpTwo implements ActionListener {

    static long random;
    String formno;
    private JFrame frame;
    private JLabel additionalDetails, religion, category, income, educational, qualifications, occupation, pan, aadhar, seniorCitizen, eAcc;
    private JTextField panTextField, aadharTextField;
    private JButton next;
    private JRadioButton syes, sno, eyes, eno;
    JComboBox religionBox, categoryBox, incomeBox, educationBox, occupationBox;
    private JComponent s3;


    public SignUpTwo(String formno) {
        this.formno = formno;
        initialize();
    }

    public void initialize() {

        frame = new JFrame();

        frame.setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2 ");
        frame.setSize(850, 740);
        frame.setLocation(350, 10);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(null);

        additionalDetails = new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        frame.add(additionalDetails);

        religion = new JLabel("Religion: ");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 140, 100, 30);
        frame.add(religion);

        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religionBox = new JComboBox(valReligion);
        religionBox.setBounds(300, 140, 400, 30);
        religionBox.setBackground(Color.WHITE);
        frame.add(religionBox);

        category = new JLabel("Category: ");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100, 190, 200, 30);
        frame.add(category);

        String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
        categoryBox = new JComboBox(valCategory);
        categoryBox.setBounds(300, 190, 400, 30);
        categoryBox.setBackground(Color.WHITE);
        frame.add(categoryBox);

        income = new JLabel("Income : ");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 240, 200, 30);
        frame.add(income);

        String incomeVal[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "< 10,00,000", "> 10,00,000"};
        incomeBox = new JComboBox(incomeVal);
        incomeBox.setBounds(300, 240, 400, 30);
        incomeBox.setBackground(Color.WHITE);
        frame.add(incomeBox);

        educational = new JLabel("Educational : ");
        educational.setFont(new Font("Raleway", Font.BOLD, 20));
        educational.setBounds(100, 290, 200, 30);
        frame.add(educational);

        qualifications = new JLabel("Qualification : ");
        qualifications.setFont(new Font("Raleway", Font.BOLD, 20));
        qualifications.setBounds(100, 315, 200, 30);
        frame.add(qualifications);

        String educationVal[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Other"};
        educationBox = new JComboBox(educationVal);
        educationBox.setBounds(300, 310, 400, 30);
        educationBox.setBackground(Color.WHITE);
        frame.add(educationBox);

        occupation = new JLabel("Occupation : ");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 380, 200, 30);
        frame.add(occupation);

        String occupationVal[] = {"Salaried", "Self - Employed", "Business", "Student", "Retired", "Other"};
        occupationBox = new JComboBox(occupationVal);
        occupationBox.setBounds(300, 380, 400, 30);
        occupationBox.setBackground(Color.WHITE);
        frame.add(occupationBox);

        pan = new JLabel("PAN Number : ");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 430, 200, 30);
        frame.add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300, 430, 400, 30);
        frame.add(panTextField);

        aadhar = new JLabel("Aadhar Number : ");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100, 490, 200, 30);
        frame.add(aadhar);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(300, 490, 400, 30);
        frame.add(aadharTextField);

        seniorCitizen = new JLabel("Senior Citizen : ");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorCitizen.setBounds(100, 540, 200, 30);
        frame.add(seniorCitizen);

        syes = new JRadioButton("Yes");
        syes.setBackground(Color.WHITE);
        syes.setBounds(300, 540, 100, 30);
        frame.add(syes);

        sno = new JRadioButton("No");
        sno.setBackground(Color.WHITE);
        sno.setBounds(450, 540, 100, 30);
        frame.add(sno);

        ButtonGroup sGroup = new ButtonGroup();
        sGroup.add(syes);
        sGroup.add(sno);

        eAcc = new JLabel("Existing Account :");
        eAcc.setFont(new Font("Raleway", Font.BOLD, 20));
        eAcc.setBounds(100, 590, 200, 30);
        frame.add(eAcc);

        eyes = new JRadioButton("Yes");
        eyes.setBackground(Color.WHITE);
        eyes.setBounds(300, 590, 100, 30);
        frame.add(eyes);

        eno = new JRadioButton("No");
        eno.setBackground(Color.WHITE);
        eno.setBounds(450, 590, 100, 30);
        frame.add(eno);

        ButtonGroup eGroup = new ButtonGroup();
        eGroup.add(eyes);
        eGroup.add(eno);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 650, 80, 30);
        next.addActionListener(this);
        frame.add(next);

        this.frame.setVisible(true);

    }


    public static void main(String[] args) {
        new SignUpTwo("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = "" + random;
        String religion = religionBox.getSelectedItem().toString();
        String category = categoryBox.getSelectedItem().toString();
        String income = incomeBox.getSelectedItem().toString();
        String education = educationBox.getSelectedItem().toString();
        String occupation = occupationBox.getSelectedItem().toString();
        String sPan = panTextField.getText();
        String sAadhar = aadharTextField.getText();
        String seniorCitizen = null;
        if (syes.isSelected()) {
            seniorCitizen = "Yes";
        } else {
            seniorCitizen = "No";
        }
        String eAccount = null;
        if (eyes.isSelected()) {
            eAccount = "Yes";
        } else {
            eAccount = "No";
        }

        try {
            if (sPan.equals("") || sAadhar.equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the details");
            } else if (!sPan.matches("^[A-Z]{5}[0-9]{4}[A-Z]$")) {
                JOptionPane.showMessageDialog(null, "Invalid PAN format!\nFormat: ABCDE1234F", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Aadhaar validation
            else if (!sAadhar.matches("^\\d{12}$")) {
                JOptionPane.showMessageDialog(null, "Invalid Aadhaar format!\nIt must be a 12-digit number.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                Conn c = new Conn();
                String query = "insert into signuptwo values('" + formno + "', '" + religion + "', '" + category + "', '" + income + "' , '" + education + "' , '" + occupation + "' , '" + sPan + "', '" + sAadhar + "', '" + seniorCitizen + "', '" + eAccount + "')";
                c.s.executeUpdate(query);

                //SignUpThree object
                frame.setVisible(false);
                SignUpThree s3 = new SignUpThree(formno);
                this.s3.setVisible(true);

            }
        } catch (Exception ex) {
            System.out.println(ex);
        }


    }
}



