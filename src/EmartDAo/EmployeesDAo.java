 
package EmartDAo;

import Emart.dbutil.DBconnection;
import Emart.pojo.Employeespojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class EmployeesDAo {
    public static String getNextEmpid()throws SQLException
    {
        Connection conn=DBconnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select max(empid) from employees");
        rs.next();
        String empid=rs.getString(1);
        int empno =Integer.parseInt(empid.substring(1));
        empno +=1;
        return "E"+empno;
        
    }
    public static boolean addEmployees(Employeespojo emp) throws SQLException{
        Connection conn = DBconnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into Employees values(?,?,?,?)");
        ps.setString(1,emp.getEmpid());
        ps.setString(2, emp.getEmpName());
        ps.setString(3, emp.getJob());
        ps.setDouble(4, emp.getSalary());
        int result=ps.executeUpdate();
        return result==1;
        
        
    }
   public static ArrayList<Employeespojo> viewAllEmployees()throws SQLException{
        Connection conn=DBconnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select * from employees order by empid");
        ArrayList<Employeespojo>empList=new ArrayList<>();
        while(rs.next()){
            Employeespojo e=new Employeespojo();
            e.setEmpid(rs.getString(1));
            e.setEmpName(rs.getString(2));
            e.setJob(rs.getString(3));
            e.setSalary(rs.getDouble(4));
            empList.add(e);
            
        }
        return empList;
    } 
    public static List<String> getAllEmpId() throws SQLException
    {
        Connection conn=DBconnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("Select empid from employees order by empid");
        ArrayList<String> allId=new ArrayList<String>();
        while(rs.next())
        {
            allId.add(rs.getString(1));
        }
        return allId;
    }
    public static Employeespojo findEmpById(String empid)throws SQLException
    {
        Connection conn=DBconnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Select * from employees where empid=?");//here set dynamically 
        ps.setString(1, empid);
        ResultSet rs=ps.executeQuery();
        rs.next();
        Employeespojo e=new Employeespojo();
        e.setEmpid(rs.getString(1));
        e.setEmpName(rs.getString(2));
        e.setJob(rs.getString(3));
        e.setSalary(rs.getDouble(4));
        return e;
    }
    public static boolean updateEmployee(Employeespojo e)throws SQLException
    {
        Connection conn=DBconnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Update employees set empname=?,job=?,salary=? where empid=?");
        ps.setString(1, e.getEmpName());
        ps.setString(2, e.getJob());
        ps.setDouble(3, e.getSalary());
        ps.setString(4,e.getEmpid());
        int x=ps.executeUpdate();
        if(x==0)
            return false;
        else 
        {
            boolean result=UserDAo.isUserPresent(e.getEmpid());
            if(result==false)
                return true;
        ps=conn.prepareStatement("Update users set username=?,usertype=? where empid=?");
        ps.setString(1, e.getEmpName());
        ps.setString(2, e.getJob());
        ps.setString(3,e.getEmpid());
        int y=ps.executeUpdate();
        return y==1;
    }
    }
    public static boolean deleteEmployee(String empid)throws SQLException
    {
        Connection conn=DBconnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("delete from employees where empid=?");//here set dynamically
        ps.setString(1, empid);
        int x=ps.executeUpdate();
        return x==1;
    }
}


