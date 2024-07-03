package stud_manage_system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class StudentDetails extends JFrame implements ActionListener {

    // instance variables
    Choice crollno;
    JTable table;
    JButton search, print, update, add, cancel;

    StudentDetails() {

        // frame settings
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Label and drop down
        JLabel heading = new JLabel("Search by Roll Number");
        heading.setBounds(45, 20, 150, 20);
        add(heading);

        // creating obj of 'Choice' class, to create a drop down menu
        crollno = new Choice();
        crollno.setBounds(205, 20, 150, 20);
        add(crollno);

        // SQL query inside try and catch block
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while (rs.next()) {
                crollno.add(rs.getString("prn"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // obj created, to create a table
        table = new JTable();

        // to set a table from SQL
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            // this function used to set table on the frame
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // to scroll the table, we separately create a scrollpane
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(45, 120, 800, 510);
        add(jsp);

        // search button
        search = new JButton("Search");
        search.setBounds(45, 70, 80, 20);
        search.addActionListener(this);
        add(search);

        // print button
        print = new JButton("Print");
        print.setBounds(145, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        // add button
        add = new JButton("Add");
        add.setBounds(245, 70, 80, 20);
        add.addActionListener(this);
        add(add);
        
        // cancel button
        cancel = new JButton("Cancel");
        cancel.setBounds(345, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);

        // frame settings
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            new ViewStudent();
        } else if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == add) {
            setVisible(false);
            new AddStudent();
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentDetails();
    }
}
