package stud_manage_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewStudent extends JFrame implements ActionListener {
    JButton search;
    JTextField tfrollno;
    JTextArea ta;
    String rollno;

    ViewStudent() {
        // Frame settings
        setSize(600, 250);
        setLocation(450, 200);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ta = new JTextArea();
        ta.setBounds(10, 60, 300, 350);
        add(ta);

        // Search by Roll number textfield and label
        JLabel lblrollno = new JLabel("Enter Roll Number: ");
        lblrollno.setBounds(100, 30, 150, 20);
        add(lblrollno);

        tfrollno = new JTextField();
        tfrollno.setBounds(220, 30, 150, 20);
        add(tfrollno);

        // Search button
        search = new JButton("Search");
        search.setBounds(390, 30, 100, 20);
        search.addActionListener(this);
        add(search);

        // Frame settings
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        rollno = tfrollno.getText();

        try {
            // Prepare and execute the SQL query
            String query = "SELECT * FROM student WHERE prn = ?";
            Conn c = new Conn();
            Connection connection = c.c;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, rollno);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                // Display student info
                String studentInfo = "Name: " + rs.getString("name") + "\n"
                        + "Father's Name: " + rs.getString("fname") + "\n"
                        + "PRN: " + rs.getString("prn") + "\n"
                        + "Date of Birth: " + rs.getString("dob") + "\n"
                        + "AY - Year: " + rs.getString("ay_year") + "\n"
                        + "Phone: " + rs.getString("phone") + "\n"
                        + "Email: " + rs.getString("email") + "\n"
                        + "Course: " + rs.getString("course") + "\n"
                        + "Achievement: " + rs.getString("achievement") + "\n";
                ta.setText(studentInfo);
            } else {
                ta.setText("Student Not Found!");
            }

            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            ta.setText("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ViewStudent();
            }
        });
    }
}
