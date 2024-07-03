package stud_manage_system;

import javax.swing.*;
import java.awt.*;
// import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class AddStudent extends JFrame implements ActionListener {

    // declared globally

    JTextField tfname, tffname, tfphone, tfemail, tfprn, tfay_year, tfachieve;
    JDateChooser dcdob;
    JComboBox cbcourse, cbbranch;
    JButton submit, cancel;

    AddStudent() {

        // frame settings
        setSize(900, 700);
        setLocation(350, 50);
        setLayout(null);

        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(285, 50, 520, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);

        // Personal Roll NO label and textfield
        JLabel lblrollno = new JLabel("General Roll Number: ");
        lblrollno.setBounds(300, 140, 200, 30);
        lblrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(lblrollno);

        tfprn = new JTextField();
        tfprn.setBounds(500, 140, 75, 30);
        add(tfprn);

        // Name label and textfield
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 220, 100, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 220, 150, 30);
        add(tfname);

        // Fathers name label and textfield
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(450, 220, 200, 30);
        lblfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfname);

        tffname = new JTextField();
        tffname.setBounds(650, 220, 150, 30);
        add(tffname);

        // DOB label and calender
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(450, 300, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(650, 300, 150, 30);
        add(dcdob);

        // address label and textfield
        JLabel lblay_year = new JLabel("AY - Year");
        lblay_year.setBounds(50, 300, 200, 30);
        lblay_year.setFont(new Font("serif", Font.BOLD, 20));
        add(lblay_year);

        tfay_year = new JTextField();
        tfay_year.setBounds(200, 300, 150, 30);
        add(tfay_year);

        // phone label and textfield
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(450, 380, 200, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(650, 380, 150, 30);
        add(tfphone);

        // email id label and textfield
        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50, 380, 200, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 380, 150, 30);
        add(tfemail);

        // course label and drop down menu
        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(50, 460, 200, 30);
        lblcourse.setFont(new Font("serif", Font.BOLD, 20));
        add(lblcourse);

        // JComboBox used to create a drop down field
        String course[] = { "Computer", "IT", "EnTC", "AIDS", "CSAIML", "CSAI", "Instrumention", "Chemical",
                "Mechanical" };
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200, 460, 150, 30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);

        // achievement label and textfield
        JLabel lblachieve = new JLabel("Achievement");
        lblachieve.setBounds(450, 460, 200, 30);
        lblachieve.setFont(new Font("serif", Font.BOLD, 20));
        add(lblachieve);

        tfachieve = new JTextField();
        tfachieve.setBounds(650, 460, 150, 30);
        add(tfachieve);

        // Submit Button
        submit = new JButton("Submit");
        submit.setBounds(280, 560, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        // cancel button
        cancel = new JButton("Cancel");
        cancel.setBounds(480, 560, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        // frame setting
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            // extract textfield data
            String name = tfname.getText();
            String fname = tffname.getText();
            String rollno = tfprn.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String ay_year = tfay_year.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String course = (String) cbcourse.getSelectedItem();
            String achieve = tfachieve.getText();

            // mysql query executed in try and catch block, external entity.
            try {

                // DML query
                String query = "insert into student values('" + name + "', '" + fname + "', '" + rollno + "', '" + dob
                        + "', '" + ay_year + "', '" + phone + "', '" + email + "', '" + course + "', '" + achieve +"')";

                Conn con = new Conn();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddStudent();
    }
}
