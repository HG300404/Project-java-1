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
import java.util.List;
import javax.swing.JOptionPane;
import model.Product;
import model.Revenue;
import model.RevenueBean;

/**
 *
 * @author Administrator
 */
public class RevenueDAO implements DAOInterface<Revenue>{

    public static RevenueDAO getInstance(){
        return new RevenueDAO();
    }   

    @Override
    public int insert(Revenue t) {
         int ketQua = 0;
        try{
            // Tao ket noi den CSDL
        Connection conn = new ConnectDB().getConnectDB();
        
        // Tao doi tuong Statement
        Statement st = conn.createStatement();
        
        // Thuc thi cau lenh SQL
        String sql = "INSERT INTO revenue(Date,ProductName,Price,Quantity,Total)"
               + " VALUES('"+t.getDate()+"','"+t.getProductName()+"','"+t.getPrice()+"','"+t.getQuantity()+"','"+t.getTotal()+"'"+")";
        
        
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
    public int update(Revenue t) {
        int ketQua = 0;
        try{
        Connection conn = new ConnectDB().getConnectDB();
        Statement st = conn.createStatement();
        
        String sql = "UPDATE revenue "+
                " SET "+  
                " ProductName='"+t.getProductName()+"'"+
                ", Price='"+t.getPrice()+"'"+
                ", Quantity='"+t.getQuantity()+"'"+
                ", Total='"+t.getTotal()+"'"+
                " WHERE Date='"+t.getDate()+"\'";
        
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
    public int delete(Revenue t) {
         int ketQua = 0;
        try{
        Connection conn = new ConnectDB().getConnectDB();
        Statement st = conn.createStatement();
        
        String sql = "DELETE from revenue "+                
                " WHERE Date='"+t.getDate()+"' and ProductName ='"+t.getProductName()+"'";
        
    
        
        ketQua = st.executeUpdate(sql);
        
        ConnectDB.closeConnectDB(conn);
        }
         catch (SQLException e){
             e.printStackTrace();
         }
        return ketQua;
    }

    @Override
    public ArrayList<Revenue> selectAll() {
       ArrayList<Revenue> ketQua = new ArrayList<Revenue>();
        try{
        Connection conn = new ConnectDB().getConnectDB();
        
        Statement st = conn.createStatement();
        
        String sql = "SELECT * FROM revenue";        
       
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()){
            String Date = rs.getString("Date");
            String ProductName = rs.getString("ProductName");
            String Price = rs.getString("Price");
            String Quantity = rs.getString("Quantity");
            String Total = rs.getString("Total");
            Revenue revenue = new Revenue(Date,ProductName,Price,Quantity,Total);
            ketQua.add(revenue);
        }
        ConnectDB.closeConnectDB(conn);
        }
         catch (SQLException e){
             e.printStackTrace();
         }
        return ketQua;
    }

    @Override
    public Revenue selectById(Revenue t) {
        Revenue ketQua = null;
        try{
        Connection conn = new ConnectDB().getConnectDB();
        
        Statement st = conn.createStatement();
        
        String sql = "SELECT * FROM revenue WHERE Date='" + t.getDate()+"'";        
     
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()){
            String Date = rs.getString("Date");
            String ProductName = rs.getString("ProductName");
            String Price = rs.getString("Price");
            String Quantity = rs.getString("Quantity");
            String Total = rs.getString("Total");
            
            ketQua = new Revenue(Date,ProductName,Price,Quantity,Total);
            
        }
        ConnectDB.closeConnectDB(conn);
        }
         catch (SQLException e){
             e.printStackTrace();
         }
        return ketQua;
    }

    @Override
    public ArrayList<Revenue> selectByCondition(String condition) {
         ArrayList<Revenue> ketQua = new ArrayList<Revenue>();
        try{
        Connection conn = new ConnectDB().getConnectDB();
        
        Statement st = conn.createStatement();
        
        String sql = "SELECT * FROM revenue WHERE "+condition;        
    //    System.out.print(sql);        
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()){
            String Date = rs.getString("Date");
            String ProductName = rs.getString("ProductName");
            String Price = rs.getString("Price");
            String Quantity = rs.getString("Quantity");
            String Total = rs.getString("Total");
            
            Revenue revenue = new Revenue(Date,ProductName,Price,Quantity,Total);
            ketQua.add(revenue);
        }
        ConnectDB.closeConnectDB(conn);
        }
         catch (SQLException e){
             e.printStackTrace();
         }
        return ketQua;
    }
    
   
}
