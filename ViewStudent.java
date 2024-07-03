package stud_manage_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewStudent {
    private JFrame frame;
    private JPanel panel;
    private JLabel rollNumberLabel;
    private JTextField rollNumberTextField;
    private JButton searchButton;
    private JTextArea resultTextArea;

    private Connection connection;

    public ViewStudent() {
        // Create an instance of the Conn class to establish the database connection
        Conn conn = new Conn();
        connection = conn.c; // Get the Connection object from Conn

        // Initialize the JFrame and components
        frame = new JFrame("Student Information Search");
        panel = new JPanel();
        rollNumberLabel = new JLabel("Enter Roll Number:");
        rollNumberTextField = new JTextField(10);
        searchButton = new JButton("Search");
        resultTextArea = new JTextArea(10, 30); // Adjust the column count

        // Set up the layout
        panel.setLayout(new FlowLayout());
        panel.add(rollNumberLabel);
        panel.add(rollNumberTextField);
        panel.add(searchButton);
        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(resultTextArea), BorderLayout.CENTER);

        // Register an ActionListener for the search button
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchStudentInfo();
            }
        });

        // Set up the JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void searchStudentInfo() {
        String rollNumber = rollNumberTextField.getText();
        resultTextArea.setText(""); // Clear previous results

        try {
            // Prepare and execute a SQL query
            String query = "SELECT * FROM student WHERE rollno = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, rollNumber);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Display student information in the TextArea
                String studentInfo = "Name: " + resultSet.getString("name") + "\n"
                        + "Father's Name: " + resultSet.getString("fname") + "\n"
                        + "Roll Number: " + resultSet.getString("rollno") + "\n"
                        + "Date of Birth: " + resultSet.getString("dob") + "\n"
                        + "Address: " + resultSet.getString("address") + "\n"
                        + "Phone: " + resultSet.getString("phone") + "\n"
                        + "Email: " + resultSet.getString("email") + "\n"
                        + "Course: " + resultSet.getString("course") + "\n";
                resultTextArea.setText(studentInfo);
            } else {
                resultTextArea.setText("Student not found.");
            }

            // preparedStatement close();
        } catch (SQLException e) {
            e.printStackTrace();
            resultTextArea.setText("Error: " + e.getMessage());
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
