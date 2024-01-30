/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmartDAo;

import Emart.dbutil.DBconnection;
import Emart.pojo.Productspojo;
import Emart.pojo.Userprofile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rajpr
 */
public class OrderDAO {
    public static String getNextOrderId() throws SQLException
    {
        Connection conn=DBconnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("Select max (order_id) from orders");
        rs.next();
        String ordId=rs.getString(1);
        if(ordId==null){
            return "o-101";
        }
        
        int ordno=Integer.parseInt(ordId.substring(2));
        ordno++;
        return "o-"+ordno;
    }
    public static boolean addOrder(ArrayList<Productspojo>al,String ordId)throws SQLException
    {
        Connection conn=DBconnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into ORDERS values(?,?,?,?)");
        int count=0;
        for(Productspojo p:al){
            ps.setString(1, ordId);
            ps.setString(2, p.getProductId());
            ps.setInt(3, p.getQuantity());
            ps.setString(4, Userprofile.getUserid());
            count =count+ps.executeUpdate();
        }
        return count==al.size();
    }
    public static List<String> getAllorderId() throws SQLException
    {
        Connection conn=DBconnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("Select order_id from orders order by order_id");
        ArrayList<String> allorderId=new ArrayList<String>();
        while(rs.next())
        {
            allorderId.add(rs.getString(1));
        }
        return allorderId;
    }
    public static List<Productspojo> getOrderDetails(String o_id) throws SQLException
    {
        Connection conn=DBconnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from products where p_id in(select p_id from orders where order_id=?)");
        ps.setString(1,o_id);
        ResultSet rs=ps.executeQuery();
        ArrayList <Productspojo> ProductsList=new ArrayList<>();
        while(rs.next()){
             // System.out.println(" "+rs.getString(1)+" "+rs.getString(2) );
            Productspojo p=new Productspojo();
            p.setProductId(rs.getString(1));
            p.setProductName(rs.getString(2));
            p.setProductCompany(rs.getString(3));
            p.setProductPrice(rs.getDouble(4));
          
            p.setOurPrice(rs.getDouble(5));
            p.setTax(rs.getInt(6));
            p.setQuantity(rs.getInt(7));
            ProductsList.add(p);
        }
       // System.out.println(ProductsList);
        return ProductsList;
    }
}
