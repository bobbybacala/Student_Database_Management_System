package stud_manage_system;

import java.sql.*;

public class Conn {
    
    // connection is an interface inside java.sql
    Connection c;
    Statement s;

    Conn () {
        try {

            // 1. REg Driver Class
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Connection String
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "$uSm!t@MYSQL");
            s = c.createStatement();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
