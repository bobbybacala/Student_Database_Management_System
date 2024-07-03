package stud_manage_system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class TeacherDetails extends JFrame implements ActionListener {

    Choice cEmpId;
    JTable table;
    JButton search, print, update, add, cancel;
    
    TeacherDetails() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // label and drop down field
        JLabel heading = new JLabel("Search by Employee Id");
        heading.setBounds(45, 20, 150, 20);
        add(heading);
        
        // employee id
        cEmpId = new Choice();
        cEmpId.setBounds(205, 20, 150, 20);
        add(cEmpId);
        
        // sql query
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while(rs.next()) {
                cEmpId.add(rs.getString("emp_no"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // scrolling component
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
            String query = "select * from teacher where rollno = '"+cEmpId.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == add) {
            setVisible(false);
            new AddTeacher();
        } else if (ae.getSource() == update) {
            setVisible(false);
            // new UpdateTeacher();
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new TeacherDetails();
    }
}
