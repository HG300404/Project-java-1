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
import model.Category;

/**
 *
 * @author Administrator
 */
public class CategoryDAO implements DAOInterface<Category> {

    public static CategoryDAO getInstance(){
        return new CategoryDAO();
    }  
    @Override
    public int insert(Category t) {
        int ketQua = 0;
        try{
            // Tao ket noi den CSDL
        Connection conn = new ConnectDB().getConnectDB();
        
        // Tao doi tuong Statement
        Statement st = conn.createStatement();
        
        // Thuc thi cau lenh SQL
        String sql = "INSERT INTO category(IDCategory,Category)"
               + " VALUES('"+t.getIDCategory()+"','"+t.getCategory()+"'"+")";    
       
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
    public int update(Category t) {
       int ketQua = 0;
        try{
        Connection conn = new ConnectDB().getConnectDB();
        Statement st = conn.createStatement();
        
        String sql = "UPDATE Category "+
                " SET "+                
                " Category='"+t.getCategory()+"'"+
                " WHERE IDCategory='"+t.getIDCategory()+"\'";
        
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
    public int delete(Category t) {
        int ketQua = 0;
        try{
        Connection conn = new ConnectDB().getConnectDB();
        Statement st = conn.createStatement();
        
        String sql = "DELETE from category "+                
                " WHERE IDCategory='"+t.getIDCategory()+"'";
        
    
        ketQua = st.executeUpdate(sql);
        
        ConnectDB.closeConnectDB(conn);
        }
         catch (SQLException e){
             e.printStackTrace();
         }
        return ketQua;
    }

    @Override
    public ArrayList<Category> selectAll() {
         ArrayList<Category> ketQua = new ArrayList<Category>();
        try{
        Connection conn = new ConnectDB().getConnectDB();
        
        Statement st = conn.createStatement();
        
        String sql = "SELECT * FROM category ORDER BY IDCategory";        
       
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()){
            int IDCategory = Integer.parseInt(rs.getString("IDCategory"));
            String Category = rs.getString("Category");
            Category category = new Category(IDCategory,Category);
            ketQua.add(category);
        }
        ConnectDB.closeConnectDB(conn);
        }
         catch (SQLException e){
             e.printStackTrace();
         }
        return ketQua;
    }

    @Override
    public Category selectById(Category t) {
        Category ketQua = null;
        try{
        Connection conn = new ConnectDB().getConnectDB();
        
        Statement st = conn.createStatement();
        
        String sql = "SELECT * FROM category WHERE IDCategory='" + t.getIDCategory()+"'";        
       
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()){
            int IDCategory = Integer.parseInt(rs.getString("IDCategory"));
            String Category = rs.getString("Category");
            ketQua = new Category(IDCategory,Category);
        }
        
        ConnectDB.closeConnectDB(conn);
        }
         catch (SQLException e){
             e.printStackTrace();
         }
        return ketQua;
    }

    @Override
    public ArrayList<Category> selectByCondition(String condition) {
         ArrayList<Category> ketQua = new ArrayList<Category>();
        try{
        Connection conn = new ConnectDB().getConnectDB();
        
        Statement st = conn.createStatement();
        
        String sql = "SELECT * FROM category WHERE "+condition;        
          
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()){
            int IDCategory = Integer.parseInt(rs.getString("IDCategory"));
            String Category = rs.getString("Category");
            Category category = new Category(IDCategory,Category);
            ketQua.add(category);
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
            String sql = "select max(IDCategory) from category";
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
}
