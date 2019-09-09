
package sealine.stock;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Database {
    
//    Connection conn=null;
//    public static Connection ConnectDB(){       
//        try {
//            Class.forName("com.mysql.jdbc.Driver");         
//            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sealine_hotel_management_system","root","Try0n!c$");
//            return conn;   
//        }
//        catch(Exception e){
//            JOptionPane.showMessageDialog(null, e);
//            return null;
//        }
//    }
    
    public static Connection newConnection() throws Exception {
        
        String url = "jdbc:mysql://localhost/sealine_hotel_management_system?";
        String user = "root";
        String pass ="root";        
//        String pass ="Try0n!c$";

        
        Class.forName("com.mysql.jdbc.Driver");
        
        Connection con = DriverManager.getConnection(url, user, pass);
        
        return con;
        
    }
    
}
