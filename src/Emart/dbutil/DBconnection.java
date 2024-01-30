/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Emart.dbutil;

import static java.lang.Class.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author rajpr
 */
public class DBconnection {
   private static Connection conn; 
   static {
       try{
           Class.forName("oracle.jdbc.driver.OracleDriver");
           conn=DriverManager.getConnection("jdbc:oracle:thin:@//LAPTOP-9GSH1AN6:1521/xe","market","prishu123");
           JOptionPane.showMessageDialog(null, "connection opened successfully", "Success",JOptionPane.INFORMATION_MESSAGE);
       }
       catch(ClassNotFoundException ex){
           JOptionPane.showMessageDialog(null, "Error in lOading the driver","driver Error",JOptionPane.ERROR_MESSAGE);
           ex.printStackTrace();
           System.exit(1);
       
       }
       catch(SQLException ex){
           JOptionPane.showMessageDialog(null, "Error in opening connection","Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
           System.exit(1);
       }
   }
   public static void closeconnection()throws SQLException{
      try{
       conn.close();
       JOptionPane.showMessageDialog(null, "connection close successfully", "Success",JOptionPane.ERROR_MESSAGE);
   }
   catch(SQLException ex)
   {
           JOptionPane.showMessageDialog(null, "Error in closing connection","error in close connection",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        
   }}
public static Connection getConnection(){
    return conn;
}
}
           
