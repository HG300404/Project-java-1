/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Customer;
import model.Product;

/**
 *
 * @author Administrator
 */
public class CustomerDAO implements DAOInterface<Customer>{
    public static CustomerDAO getInstance(){
        return new CustomerDAO();
}

    @Override
    public int insert(Customer t) {
       int ketQua = 0;
        try{
            // Tao ket noi den CSDL
        Connection conn = new ConnectDB().getConnectDB();
        
        // Tao doi tuong Statement
        Statement st = conn.createStatement();
        
        // Thuc thi cau lenh SQL
        String sql = "INSERT INTO customer(IDCus, CusName, DateAdd, Phone, Email,Unpaid)"
               + " VALUES('"+t.getIDCus()+"','"+t.getCusName()+"','"+t.getDateAdd()+"','"+
                t.getPhone()+"','"+t.getEmail()+"','"+t.getUnpaid()+"'"+")";    
       
        //
        ketQua = st.executeUpdate(sql);
    
        
        // Ngat ket noi
        ConnectDB.closeConnectDB(conn);
        }
         catch (SQLException e){
             e.printStackTrace();
         }
        return ketQua;
    }

    @Override
    public int update(Customer t) {
        int ketQua = 0;
        try{
        Connection conn = new ConnectDB().getConnectDB();
        Statement st = conn.createStatement();
        
        String sql = "UPDATE customer "+
                " SET "+                
             //   " IDCus='"+t.getIDCus()+"'"+
            //    ", CusName='"+t.getCusName()+"'"+
                " DateAdd='"+t.getDateAdd()+"'"+
                ", Phone='"+t.getPhone()+"'"+
                ", Email='"+t.getEmail()+"'"+
                ", Unpaid='"+t.getUnpaid()+"'"+
                " WHERE IDCus='"+t.getIDCus()+"\'";
        
    //    System.out.print(sql);
        
        ketQua = st.executeUpdate(sql);
       
        
        ConnectDB.closeConnectDB(conn);
        }
         catch (SQLException e){
             e.printStackTrace();
         }
        return ketQua;
    }

    @Override
    public int delete(Customer t) {
        int ketQua = 0;
        try{
        Connection conn = new ConnectDB().getConnectDB();
        Statement st = conn.createStatement();
        
        String sql = "DELETE from customer "+                
                " WHERE IDCus='"+t.getIDCus()+"'";
        
    //    System.out.print(sql);
        
        ketQua = st.executeUpdate(sql);
             
        ConnectDB.closeConnectDB(conn);
        }
         catch (SQLException e){
             e.printStackTrace();
         }
        return ketQua;
    }

    @Override
    public ArrayList<Customer> selectAll() {
         ArrayList<Customer> ketQua = new ArrayList<Customer>();
        try{
        Connection conn = new ConnectDB().getConnectDB();
        
        Statement st = conn.createStatement();
        
        String sql = "SELECT * FROM customer ORDER BY IDCus";        
    
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()){
            int IDCus = Integer.parseInt(rs.getString("IDCus"));
            String CusName = rs.getString("CusName");
            String DateAdd = rs.getString("DateAdd");
            String Phone = rs.getString("Phone");
            String Email = rs.getString("Email");
            int Unpaid = Integer.parseInt(rs.getString("Unpaid"));
            Customer customer = new Customer(IDCus,CusName,DateAdd,Phone,Email,Unpaid);
            ketQua.add(customer);
        }
        ConnectDB.closeConnectDB(conn);
        }
         catch (SQLException e){
             e.printStackTrace();
         }
        return ketQua;
    }

    @Override
    public Customer selectById(Customer t) {
        Customer ketQua = null;
        try{
        Connection conn = new ConnectDB().getConnectDB();
        
        Statement st = conn.createStatement();
        
        String sql = "SELECT * FROM customer WHERE IDCus='" + t.getIDCus()+"'";        
        
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()){
            int IDCus = Integer.parseInt(rs.getString("IDCus"));
            String CusName = rs.getString("CusName");
            String DateAdd = rs.getString("DateAdd");
            String Phone = rs.getString("Phone");
            String Email = rs.getString("Email");
            int Unpaid = Integer.parseInt(rs.getString("Unpaid"));
            
            ketQua = new Customer(IDCus,CusName,DateAdd,Phone,Email,Unpaid);
            
        }
        ConnectDB.closeConnectDB(conn);
        }
         catch (SQLException e){
             e.printStackTrace();
         }
        return ketQua;
    }

    @Override
    public ArrayList<Customer> selectByCondition(String condition) {
        ArrayList<Customer> ketQua = new ArrayList<Customer>();
        try{
        Connection conn = new ConnectDB().getConnectDB();
        
        Statement st = conn.createStatement();
        
        String sql = "SELECT * FROM customer WHERE "+condition;        
      
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()){
            int IDCus = Integer.parseInt(rs.getString("IDCus"));
            String CusName = rs.getString("CusName");
            String DateAdd = rs.getString("DateAdd");
            String Phone = rs.getString("Phone");
            String Email = rs.getString("Email");
            int Unpaid = Integer.parseInt(rs.getString("Unpaid"));
            
            Customer customer = new Customer(IDCus,CusName,DateAdd,Phone,Email,Unpaid);
            ketQua.add(customer);
        }
        ConnectDB.closeConnectDB(conn);
        }
         catch (SQLException e){
             e.printStackTrace();
         }
        return ketQua;
    } 
     public static String getID(){
        int id = 1;
        try{
            Connection conn = new ConnectDB().getConnectDB();
            String sql = "select max(IDCus) from customer";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                id = rs.getInt(1);
                id = id + 1;
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return String.valueOf(id);
    }
     public static ArrayList<Customer> filterUnpaidByName(String name){
        ArrayList<Customer> arrayList = new ArrayList<>();
        try{
            Connection conn = new ConnectDB().getConnectDB();
            Statement st = conn.createStatement();
            String sql = "select * from customer where CusName = '"+ name +"'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                Customer p = new Customer();
                p.setUnpaid(Integer.parseInt(rs.getString("Unpaid")));
                p.setPhone(rs.getString("Phone"));
                p.setEmail(rs.getString("Email"));
                arrayList.add(p);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
}
