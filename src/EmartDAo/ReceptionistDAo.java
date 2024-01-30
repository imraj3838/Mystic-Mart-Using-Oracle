
package EmartDAo;


import Emart.dbutil.DBconnection;
import Emart.pojo.Receptionistpojo;
import Emart.pojo.Userpojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class ReceptionistDAo {
   public static Map<String,String> getNonRegisteredReceptionists() throws SQLException
    {
        Connection con=DBconnection.getConnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select empid,empname from employees where job='receptionist' and empid not in (select empid from users where usertype='receptionist')");
        HashMap <String,String> receptionistList=new HashMap<>();
        while(rs.next())
        {
            String id=rs.getString(1);
            String name=rs.getString(2);
            receptionistList.put(id,name);
        }
        return receptionistList;
    }
   public static boolean addReceptionist(Userpojo user)throws SQLException
    {
        Connection con=DBconnection.getConnection();
        PreparedStatement ps=con.prepareStatement("Insert into users values(?,?,?,?,?)");
        ps.setString(1,user.getUserid());
        ps.setString(2, user.getEmpid());
        ps.setString(3, user.getPassword());
        ps.setString(4, user.getUsertype());
        ps.setString(5, user.getUsername());
        int result=ps.executeUpdate();
        return result==1;
        
    }
   public static List<Receptionistpojo> getAllReceptionistDetails() throws SQLException
    {
        Connection con=DBconnection.getConnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select users.empid,empname,userid,job,salary from users,employees where usertype='Receptionist' and users.empid=employees.empid");
        ArrayList<Receptionistpojo> al=new ArrayList<>();
        while(rs.next())
        {
            Receptionistpojo recep=new Receptionistpojo();
            recep.setEmpid(rs.getString(1));
            recep.setEmpname(rs.getString(2));
            recep.setUserid(rs.getString(3));
            recep.setJob(rs.getString(4));
            recep.setSalary(rs.getDouble(5));
            al.add(recep);
            
        }
        return al;
        
    }
    public static Map<String,String> getAllReceptionistId() throws SQLException
    {
        Connection con=DBconnection.getConnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select userid,username from users where usertype='Receptionist' order by userid");
        HashMap <String,String> receptionistList=new HashMap<>();
        while(rs.next())
        {
            String id=rs.getString(1);
            String name=rs.getString(2);
            receptionistList.put(id,name);
        }
        return receptionistList;
    }
    public static boolean updatePassword(String userid,String password)throws SQLException
    {
        Connection conn=DBconnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update users set password=? where userid=?");//Dynamic query
        ps.setString(1, password);
        ps.setString(2, userid);
        return ps.executeUpdate()==1;
    }
    public static List<String> getAllReceptionistUserId()throws SQLException
    {
        Connection con=DBconnection.getConnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select userid from users where usertype='Receptionist' order by userid");
        List <String> receptionistList=new ArrayList<>();
        while(rs.next())
        {
            String id=rs.getString(1);
            receptionistList.add(id);
        }
        return receptionistList;
    }
    public static boolean deleteReceptionist(String userid)throws SQLException
    {
        Connection conn=DBconnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("delete from users where userid=?");
        ps.setString(1, userid);
        return ps.executeUpdate()==1;
        
    }
}
