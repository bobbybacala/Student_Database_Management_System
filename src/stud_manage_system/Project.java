package stud_manage_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {

    Project() {

        // frame settings
        setLocation(250, 50);
        setSize(1024, 720);

        // add image to frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons_vit/lawn.jpg"));
        // to scale the image accordingly we use 'Image' class
        Image i2 = i1.getImage().getScaledInstance(1024, 720, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        // 'JMenuBar' class used to add dashboard menu to the frame.
        JMenuBar mb = new JMenuBar();

        // New Information
        // JMenu class : creates a menu
        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.BLUE);
        mb.add(newInformation);

        // JMenuItems: list Menu items under Menu.
        // further Menu items listed under 'New information' Menu option
        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);

        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.WHITE);
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);

        // Details
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.RED);
        mb.add(details);

        // further Menu items listed under 'Details' Menu option
        JMenuItem facultydetails = new JMenuItem("View Faculty Details");
        facultydetails.setBackground(Color.WHITE);
        facultydetails.addActionListener(this);
        details.add(facultydetails);

        JMenuItem studentdetails = new JMenuItem("View Student Details");
        studentdetails.setBackground(Color.WHITE);
        studentdetails.addActionListener(this);
        details.add(studentdetails);

        // sets the dashboards Menu bar
        setJMenuBar(mb);

        setVisible(true);
    }

    //
    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();

        if (msg.equals("Exit")) {
            setVisible(false);
            System.exit(0);
        } else if (msg.equals("New Faculty Information")) {
            new AddTeacher();
        } else if (msg.equals("New Student Information")) {
            new AddStudent();
        } else if (msg.equals("View Faculty Details")) {
            new TeacherDetails();
        } else if (msg.equals("View Student Details")) {
            new StudentDetails();
        } 
    }

    public static void main(String[] args) {
        new Project();
    }
}
