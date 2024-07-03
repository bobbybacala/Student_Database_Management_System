package stud_manage_system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class AddTeacher extends JFrame implements ActionListener {

    // instance variables

    // JTextField tfname, tffname, tfaddress, tfphone, tfemail, tfx, tfxii,
    // tfaadhar;
    JTextField tfname, tffname, tfaddress, tfphone, tfemail;
    JLabel labelempId;
    JDateChooser dcdob;
    JComboBox cbqualify, cbdept;
    JButton submit, cancel;

    // random class to generate random number.
    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

    AddTeacher() {

        // frame settings
        setSize(900, 700);
        setLocation(350, 50);

        setLayout(null);

        // heading and label
        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(275, 50, 520, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);

        // employee ID label and randomly generated number.
        JLabel lblempId = new JLabel("Employee No");
        lblempId.setBounds(320, 140, 200, 40);
        lblempId.setFont(new Font("serif", Font.BOLD, 20));
        add(lblempId);

        labelempId = new JLabel("1000" + first4);
        labelempId.setBounds(450, 140, 200, 40);
        labelempId.setFont(new Font("serif", Font.BOLD, 20));
        add(labelempId);

        // name label and textfield
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 220, 100, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 220, 150, 30);
        add(tfname);

        // fathers name label and textfield.
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(450, 220, 200, 30);
        lblfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfname);

        tffname = new JTextField();
        tffname.setBounds(650, 220, 150, 30);
        add(tffname);

        // dob label and calender
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(450, 300, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(650, 300, 150, 30);
        add(dcdob);

        // address label and textfield
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 300, 200, 30);
        lbladdress.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 300, 150, 30);
        add(tfaddress);

        // phone number label and textfield
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

        // Qualification label and drop down menu
        JLabel lblqualify = new JLabel("Qualification");
        lblqualify.setBounds(50, 460, 200, 30);
        lblqualify.setFont(new Font("serif", Font.BOLD, 20));
        add(lblqualify);

        String qualify[] = { "B.Tech", "M.Tech", "PHd", "Bsc", "Msc", "MBA" };
        cbqualify = new JComboBox(qualify);
        cbqualify.setBounds(200, 460, 150, 30);
        cbqualify.setBackground(Color.WHITE);
        add(cbqualify);

        // Department label and drop down menu
        JLabel lbldept = new JLabel("Department");
        lbldept.setBounds(450, 460, 200, 30);
        lbldept.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldept);

        String dept[] = { "Computer", "IT", "EnTC", "Chem / Instru", "Mechanical", "DESH", "DOME" };
        cbdept = new JComboBox(dept);
        cbdept.setBounds(650, 460, 150, 30);
        cbdept.setBackground(Color.WHITE);
        add(cbdept);

        // __________________________________________________________________
        // Submit Button
        submit = new JButton("Submit");
        submit.setBounds(280, 550, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        // Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(480, 550, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        // frame settings
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String name = tfname.getText();
            String fname = tffname.getText();
            String emp_no = labelempId.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String qualify = (String) cbqualify.getSelectedItem();
            String dept = (String) cbdept.getSelectedItem();

            // SQL entity inside try and catch block
            try {
                String query = "insert into teacher values('" + name + "', '" + fname + "', '" + emp_no + "', '" + dob
                        + "', '" + address + "', '" + phone + "', '" + email + "', '" + qualify + "', '" + dept + "')";

                // eshtablish the connection
                Conn con = new Conn();
                // execute the DML query
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Teacher Details Inserted Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddTeacher();
    }
}
