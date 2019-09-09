/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sealine;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class DbConnect {
    Connection conn=null;
    public static Connection ConnectDB(){       
        try {
            Class.forName("com.mysql.jdbc.Driver");         
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sealine_hotel_management_system","root","root");
            return conn;   
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
