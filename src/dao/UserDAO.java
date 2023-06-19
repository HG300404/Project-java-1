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
import model.User;

/**
 *
 * @author Administrator
 */
public class UserDAO implements DAOInterface<User>{

    public static UserDAO getInstance(){
        return new UserDAO();
    }
    
    @Override
    public int insert(User t) {
        int ketQua = 0;
        try{
            // Tao ket noi den CSDL
        Connection conn = new ConnectDB().getConnectDB();
        
        // Tao doi tuong Statement
        Statement st = conn.createStatement();
        
        // Thuc thi cau lenh SQL
        String sql = "INSERT INTO user(UserName,Password,Role,IDUser)"
               + " VALUES('"+t.getUserName()+"','"+t.getPassword()+"','"+t.getRole()+"','"+t.getIDUser()+"'"+")";    
       
        //
        ketQua = st.executeUpdate(sql);
     //   System.out.println("Ban da thuc thi: "+sql);
    //    System.out.println("Co " + ketQua +"dong bi thay doi");
        
        // Ngat ket noi
        ConnectDB.closeConnectDB(conn);
        }
         catch (SQLException e){
             e.printStackTrace();
         }
        return ketQua;
    }

    @Override
    public int update(User t) {
        int ketQua = 0;
        try{
        Connection conn = new ConnectDB().getConnectDB();
        Statement st = conn.createStatement();
        
        String sql = "UPDATE user "+
                " SET "+                
            //    " UserName='"+t.getUserName()+"'"+                
                " Password='"+t.getPassword()+"'"+
                ", Role='"+t.getRole()+"'"+
            //    ", IDUser='"+t.getIDUser()+"'"+
                " WHERE UserName='"+t.getUserName()+"\'";
        
    //    System.out.print(sql);
        
        ketQua = st.executeUpdate(sql);
     //   System.out.println("Ban da thuc thi: "+sql);
    //    System.out.println("Co " + ketQua +"dong bi thay doi");
        
        ConnectDB.closeConnectDB(conn);
        }
         catch (SQLException e){
             e.printStackTrace();
         }
        return ketQua;
    }

    @Override
    public int delete(User t) {
       int ketQua = 0;
        try{
        Connection conn = new ConnectDB().getConnectDB();
        Statement st = conn.createStatement();
        
        String sql = "DELETE from user "+                
                " WHERE UserName='"+t.getUserName()+"'";
        
    //    System.out.print(sql);
        
        ketQua = st.executeUpdate(sql);
    //    System.out.println("Ban da thuc thi: "+sql);
   //     System.out.println("Co " + ketQua +"dong bi thay doi");
        
        ConnectDB.closeConnectDB(conn);
        }
         catch (SQLException e){
             e.printStackTrace();
         }
        return ketQua;
    }

    @Override
    public ArrayList<User> selectAll() {
      ArrayList<User> ketQua = new ArrayList<User>();
        try{
        Connection conn = new ConnectDB().getConnectDB();
        
        Statement st = conn.createStatement();
        
        String sql = "SELECT * FROM user ORDER BY IDUser";        
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()){
            String UserName = rs.getString("UserName");
            String Password = rs.getString("Password");
            String Role = rs.getString("Role");
            int IDUser = Integer.parseInt(rs.getString("IDUser"));
           
            User user = new User(UserName,Password,Role,IDUser);
            ketQua.add(user);
        }
        ConnectDB.closeConnectDB(conn);
        }
         catch (SQLException e){
             e.printStackTrace();
         }
        return ketQua;
    }

    @Override
    public User selectById(User t) {
        User ketQua = null;
        try{
        Connection conn = new ConnectDB().getConnectDB();
        
        Statement st = conn.createStatement();
        
        String sql = "SELECT * FROM user WHERE UserName='" + t.getUserName()+"'";        
            
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()){
            String UserName = rs.getString("UserName");
            String Password = rs.getString("Password");
            String Role = rs.getString("Role");
             int IDUser = Integer.parseInt(rs.getString("IDUser"));
            
            ketQua = new User(UserName,Password,Role,IDUser);
            
        }
        ConnectDB.closeConnectDB(conn);
        }
         catch (SQLException e){
             e.printStackTrace();
         }
        return ketQua;
    }

    @Override
    public ArrayList<User> selectByCondition(String condition) {
         ArrayList<User> ketQua = new ArrayList<User>();
        try{
        Connection conn = new ConnectDB().getConnectDB();
        
        Statement st = conn.createStatement();
        
        String sql = "SELECT * FROM user WHERE "+condition;        
        
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()){
            String UserName = rs.getString("UserName");
            String Password = rs.getString("Password");
            String Role = rs.getString("Role");
            int IDUser = Integer.parseInt(rs.getString("IDUser"));
            
            User user = new User(UserName,Password,Role,IDUser);
            ketQua.add(user);
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
            String sql = "select max(IDUser) from user";
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
