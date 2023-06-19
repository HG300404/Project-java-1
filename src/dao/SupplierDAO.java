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
import model.Supplier;

/**
 *
 * @author Administrator
 */
public class SupplierDAO implements DAOInterface<Supplier> {

    public static SupplierDAO getInstance(){
        return new SupplierDAO();
    }
    @Override
    public int insert(Supplier t) {
        int ketQua = 0;
        try{
            // Tao ket noi den CSDL
        Connection conn = new ConnectDB().getConnectDB();
        
        // Tao doi tuong Statement
        Statement st = conn.createStatement();
        
        // Thuc thi cau lenh SQL
        String sql = "INSERT INTO supplier(IDSup,SupName,DateAdd,Phone,Email)"
               + " VALUES('"+t.getIDSup()+"','"+t.getSupName()+"','"+t.getDateAdd()+"','"+t.getPhone()+"','"+t.getEmail()+"'"+")";
        
        
        //
        ketQua = st.executeUpdate(sql);
        System.out.println("Ban da thuc thi: "+sql);
        System.out.println("Co " + ketQua +"dong bi thay doi");
        
        // Ngat ket noi
        ConnectDB.closeConnectDB(conn);
        }
         catch (SQLException e){
             e.printStackTrace();
         }
        return ketQua;
    }

    @Override
    public int update(Supplier t) {
        int ketQua = 0;
        try{
        Connection conn = new ConnectDB().getConnectDB();
        Statement st = conn.createStatement();
        
        String sql = "UPDATE suplier "+
                " SET "+  
                ", SupName='"+t.getSupName()+"'"+
                ", DateAdd='"+t.getDateAdd()+"'"+
                ", Phone='"+t.getPhone()+"'"+
                ", Email='"+t.getEmail()+"'"+
                " WHERE IDSup='"+t.getIDSup()+"\'";
        
    //    System.out.print(sql);
        
        ketQua = st.executeUpdate(sql);
        System.out.println("Ban da thuc thi: "+sql);
        System.out.println("Co " + ketQua +"dong bi thay doi");
        
        ConnectDB.closeConnectDB(conn);
        }
         catch (SQLException e){
             e.printStackTrace();
         }
        return ketQua;
    }

    @Override
    public int delete(Supplier t) {
        int ketQua = 0;
        try{
        Connection conn = new ConnectDB().getConnectDB();
        Statement st = conn.createStatement();
        
        String sql = "DELETE from supplier "+                
                " WHERE IDSup='"+t.getIDSup()+"'";
        
    //    System.out.print(sql);
        
        ketQua = st.executeUpdate(sql);
        System.out.println("Ban da thuc thi: "+sql);
        System.out.println("Co " + ketQua +"dong bi thay doi");
        
        ConnectDB.closeConnectDB(conn);
        }
         catch (SQLException e){
             e.printStackTrace();
         }
        return ketQua;
    }

    @Override
    public ArrayList<Supplier> selectAll() {
        ArrayList<Supplier> ketQua = new ArrayList<Supplier>();
        try{
        Connection conn = new ConnectDB().getConnectDB();
        
        Statement st = conn.createStatement();
        
        String sql = "SELECT * FROM supplier";        
    //    System.out.print(sql);        
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()){
            int IDSup = Integer.parseInt(rs.getString("IDSup"));
            String SupName = rs.getString("SupName");
            String DateAdd = rs.getString("DateAdd");
            String Phone = rs.getString("Phone");
            String Email = rs.getString("Email");
            
            Supplier supplier = new Supplier(IDSup,SupName,DateAdd,Phone,Email);
            ketQua.add(supplier);
        }
        ConnectDB.closeConnectDB(conn);
        }
         catch (SQLException e){
             e.printStackTrace();
         }
        return ketQua;
    }

    @Override
    public Supplier selectById(Supplier t) {
        Supplier ketQua = null;
        try{
        Connection conn = new ConnectDB().getConnectDB();
        
        Statement st = conn.createStatement();
        
        String sql = "SELECT * FROM supplier WHERE IDSup='" + t.getIDSup()+"'";        
    //    System.out.print(sql);        
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()){
            int IDSup = Integer.parseInt(rs.getString("IDSup"));
            String SupName = rs.getString("SupName");
            String DateAdd = rs.getString("DateAdd");
            String Phone = rs.getString("Phone");
            String Email = rs.getString("Email");
            
            ketQua = new Supplier(IDSup,SupName,DateAdd,Phone,Email);
            
        }
        ConnectDB.closeConnectDB(conn);
        }
         catch (SQLException e){
             e.printStackTrace();
         }
        return ketQua;
    }

    @Override
    public ArrayList<Supplier> selectByCondition(String condition) {
        ArrayList<Supplier> ketQua = new ArrayList<Supplier>();
        try{
        Connection conn = new ConnectDB().getConnectDB();
        
        Statement st = conn.createStatement();
        
        String sql = "SELECT * FROM supplier WHERE "+condition;        
    //    System.out.print(sql);        
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()){
            int IDSup = Integer.parseInt(rs.getString("IDSup"));
            String SupName = rs.getString("SupName");
            String DateAdd = rs.getString("DateAdd");
            String Phone = rs.getString("Phone");
            String Email = rs.getString("Email");
            
            Supplier supplier = new Supplier(IDSup,SupName,DateAdd,Phone,Email);
            ketQua.add(supplier);
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
            String sql = "select max(IDSup) from supplier";
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
