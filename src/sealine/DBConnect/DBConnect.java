/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author charith ellawala
 */
public class DBConnect {
    
    public Connection con;
    public Statement st;
    public ResultSet rs;
    
    
    
    public  DBConnect(){
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            con =DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","");
            st=con.createStatement();
//            JOptionPane.showConfirmDialog(null, "Connection Successfully Completed");
            System.out.println("Connection Successfully Completed");
    }catch (Exception ex){
        //System.out.println("Error :" +ex);
        JOptionPane.showMessageDialog(null,"couldn't connect to database");
        }
    }
    
//------------------------------------------------------------------------------(IReport connection)
    public static Connection mycon() throws ClassNotFoundException, SQLException
    {
    Class.forName("com.mysql.jdbc.Driver");
    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","");
    
        return c;
    }
//------------------------------------------------------------------------------(/IReport connection)
    
    
    
    
}
