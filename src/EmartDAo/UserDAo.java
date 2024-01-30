/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmartDAo;

import Emart.dbutil.DBconnection;
import Emart.pojo.Userpojo;
import Emart.pojo.Userprofile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rajpr
 */
public class UserDAo {
    public static boolean validateuser(Userpojo user)throws SQLException
    {
        Connection conn=DBconnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Select * from users where userid=? and password=? and usertype=?");
        ps.setString(1, user.getUserid());
         ps.setString(2, user.getPassword());
          ps.setString(3, user.getUsertype());
          ResultSet rs=ps.executeQuery();
          if(rs.next()){
              String username=rs.getString(5);
              Userprofile.setUsername(username);
              return true;
             
          }
           return false;
    }
    public static boolean isUserPresent(String empid)throws SQLException
    {
        Connection conn=DBconnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from users where empid=?");
        ps.setString(1, empid);
        ResultSet rs=ps.executeQuery();
        return rs.next();
        
    }
}
    
   

