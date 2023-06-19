/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Employee;
import model.Infor;

/**
 *
 * @author Administrator
 */
public class InforDAO implements DAOInterface<Infor> {

     public static InforDAO getInstance(){
        return new InforDAO();
    } 
    @Override
    public int insert(Infor t) {
        int ketQua = 0;
        try{
            // Tao ket noi den CSDL
        Connection conn = new ConnectDB().getConnectDB();
        
        // Tao doi tuong Statement
        Statement st = conn.createStatement();
        
        // Thuc thi cau lenh SQL
        String sql = "INSERT INTO Infor(IDEmp, NameEmp, Phone, Email)"
               + " VALUES('"+t.getIDEmp()+"','"+t.getNameEmp()+"','"+
                t.getPhone()+"','"+t.getEmail()+"'"+")";    
       
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
    public int update(Infor t) {
        int ketQua = 0;
        try{
        Connection conn = new ConnectDB().getConnectDB();
        Statement st = conn.createStatement();
        
        String sql = "UPDATE infor "+
                " SET "+               
            //    ", NameEmp='"+t.getNameEmp()+"'"+
           //     ", Phone='"+t.getPhone()+"'"+
                " Email='"+t.getEmail()+"'"+
                " WHERE IDEmp='"+t.getIDEmp()+"\'";
        
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
    public int delete(Infor t) {
        int ketQua = 0;
        try{
        Connection conn = new ConnectDB().getConnectDB();
        Statement st = conn.createStatement();
        
        String sql = "DELETE from infor "+                
                " WHERE IDEmp='"+t.getIDEmp()+"'";
        
    //    System.out.print(sql);
        
        ketQua = st.executeUpdate(sql);
        
        
        ConnectDB.closeConnectDB(conn);
        }
         catch (SQLException e){
             e.printStackTrace();
         }
        return ketQua;
    }

    public int deleteByID(int t) {
        int ketQua = 0;
        try{
        Connection conn = new ConnectDB().getConnectDB();
        Statement st = conn.createStatement();
        
        String sql = "DELETE from infor "+                
                " WHERE IDEmp='"+t+"'";
        
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
    public ArrayList<Infor> selectAll() {
        ArrayList<Infor> ketQua = new ArrayList<Infor>();
        try{
        Connection conn = new ConnectDB().getConnectDB();
        
        Statement st = conn.createStatement();
        
        String sql = "SELECT * FROM infor";        
    //    System.out.print(sql);        
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()){
            int IDEmp = Integer.parseInt(rs.getString("IDEmp"));
            String NameEmp = rs.getString("NameEmp");
            String Phone = rs.getString("Phone");
            String Email = rs.getString("Email");
          
            Infor infor = new Infor(IDEmp,NameEmp,Phone,Email);
            ketQua.add(infor);
        }
        ConnectDB.closeConnectDB(conn);
        }
         catch (SQLException e){
             e.printStackTrace();
         }
        return ketQua;
    }

    @Override
    public Infor selectById(Infor t) {
        Infor ketQua = null;
        try{
        Connection conn = new ConnectDB().getConnectDB();
        
        Statement st = conn.createStatement();
        
        String sql = "SELECT * FROM infor WHERE IDEmp='" + t.getIDEmp()+"'";        
    //    System.out.print(sql);        
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()){
            int IDEmp = Integer.parseInt(rs.getString("IDEmp"));
            String NameEmp = rs.getString("NameEmp");
            String Phone = rs.getString("Phone");
            String Email = rs.getString("Email");
            
            ketQua = new Infor(IDEmp,NameEmp,Phone,Email);
            
        }
        ConnectDB.closeConnectDB(conn);
        }
         catch (SQLException e){
             e.printStackTrace();
         }
        return ketQua;
    }

    @Override
    public ArrayList<Infor> selectByCondition(String condition) {
        ArrayList<Infor> ketQua = new ArrayList<Infor>();
        try{
        Connection conn = new ConnectDB().getConnectDB();
        
        Statement st = conn.createStatement();
        
        String sql = "SELECT * FROM infor WHERE "+condition;        
    //    System.out.print(sql);        
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()){
            int IDEmp = Integer.parseInt(rs.getString("IDEmp"));
            String NameEmp = rs.getString("NameEmp");
            String Phone = rs.getString("Phone");
            String Email = rs.getString("Email");
            
            Infor infor = new Infor(IDEmp,NameEmp,Phone,Email);
            ketQua.add(infor);
        }
        ConnectDB.closeConnectDB(conn);
        }
         catch (SQLException e){
             e.printStackTrace();
         }
        return ketQua;
    }
    
}
