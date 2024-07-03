package stud_manage_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    // scope of the variables is global, instance variables.
    JButton login, cancel;
    JTextField tfusername, tfpassword;
    
    Login () {
        
        // sets the background color.
        getContentPane().setBackground(Color.WHITE);
        // sets default null.
        setLayout(null);
        
        // add a label to the frame.
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 20);
        add(lblusername);
        
        // input field entered by the user.
        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 20);
        add(tfusername);
        

        // add a label 
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 70, 100, 20);
        add(lblpassword);
        
        // input the password, JPasswordField(): hides the text so that 3rd person cant see it
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 70, 150, 20);
        add(tfpassword);
        
        // Login Button
        login = new JButton("Login");
        login.setBounds(40, 140, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        // for click event, this function interanlly calls actionPerformed().
        login.addActionListener(this);
        login.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(login);
        

        // Cancel BUtton
        cancel = new JButton("Cancel");
        cancel.setBounds(180, 140, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        // image on the login frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);
        
        // frame settings
        setSize(600, 300);
        setLocation(500, 250);
        setVisible(true);
    }
    
    // abstract method inside ActionListener interface.
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {

            // to get the text from textfield, entered by the user.
            String username = tfusername.getText();
            String password = tfpassword.getText();
            

            // hit operation: creating the mysql query.
            String query = "select * from login where username='"+username+"' and password='"+password+"'";
            

            // mysql is an external entity can throw errors, there inside try and catch block.
            try {

                // to create the connection, create the object of the 'Conn' class.
                Conn c = new Conn();

                // execute the query
                ResultSet rs = c.s.executeQuery(query);
                

                // if - else block checks password entered or not.
                if (rs.next()) {
                    setVisible(false);
                    new Project();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    setVisible(false);
                    System.exit(0);
                }

                // close the connection.
                // c.s.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
