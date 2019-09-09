/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sealine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author charith ellawala
 */
public class DatabaseConnect {
    
    public Connection con;
    public Statement st;
    public ResultSet rs;
    
    
    
    public  DatabaseConnect(){
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sealine_hotel_management_system","root","root");
            st=con.createStatement();
//            JOptionPane.showConfirmDialog(null, "Connection Successfully Completed");
            System.out.println("Connection Successfully Completed");
    }catch (Exception ex){
        //System.out.println("Error :" +ex);
        JOptionPane.showMessageDialog(null,"couldn't connect to database");
        }
    }
    
    
    
    
}
