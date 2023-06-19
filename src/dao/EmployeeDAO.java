

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
import model.Employee;

/**
 *
 * @author Administrator
 */
public class EmployeeDAO implements DAOInterface<Employee> {
    public static EmployeeDAO getInstance(){
        return new EmployeeDAO();
    }   

    @Override
    public int insert(Employee t) {
        int ketQua = 0;
        try{
            // Tao ket noi den CSDL
        Connection conn = new ConnectDB().getConnectDB();
        
        // Tao doi tuong Statement
        Statement st = conn.createStatement();
        
        // Thuc thi cau lenh SQL
        String sql = "INSERT INTO employee(IDEmp, NameEmp, Phone, Email)"
               + " VALUES('"+t.getIDEmp()+"','"+t.getNameEmp()+"','"+
                t.getPhone()+"','"+t.getEmail()+"'"+")";    
       
        //
        ketQua = st.executeUpdate(sql);
    //    System.out.println("Ban da thuc thi: "+sql);
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
    public int update(Employee t) {
        int ketQua = 0;
        try{
        Connection conn = new ConnectDB().getConnectDB();
        Statement st = conn.createStatement();
        
        String sql = "UPDATE employee "+
                " SET "+                
           //     " IDEmp='"+t.getIDEmp()+"'"+                
           //     ", NameEmp='"+t.getNameEmp()+"'"+
                " Phone='"+t.getPhone()+"'"+
                ", Email='"+t.getEmail()+"'"+
                " WHERE IDEmp='"+t.getIDEmp()+"\'";
    
        
        ketQua = st.executeUpdate(sql);
    //    System.out.println("Ban da thuc thi: "+sql);
    //    System.out.println("Co " + ketQua +"dong bi thay doi");
        
        ConnectDB.closeConnectDB(conn);
        }
         catch (SQLException e){
             e.printStackTrace();
         }
        return ketQua;
    }

    @Override
    public int delete(Employee t) {
        int ketQua = 0;
        try{
        Connection conn = new ConnectDB().getConnectDB();
        Statement st = conn.createStatement();
        
        String sql = "DELETE from employee "+                
                " WHERE IDEmp='"+t.getIDEmp()+"'";
        
    //    System.out.print(sql);
        
        ketQua = st.executeUpdate(sql);
   //     System.out.println("Ban da thuc thi: "+sql);
   //     System.out.println("Co " + ketQua +"dong bi thay doi");
        
        ConnectDB.closeConnectDB(conn);
        }
         catch (SQLException e){
             e.printStackTrace();
         }
        return ketQua;
    }

    @Override
    public ArrayList<Employee> selectAll() {
        ArrayList<Employee> ketQua = new ArrayList<Employee>();
        try{
        Connection conn = new ConnectDB().getConnectDB();
        
        Statement st = conn.createStatement();
        
        String sql = "SELECT * FROM employee ORDER BY IDEmp";        
    //    System.out.print(sql);        
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()){
            int IDEmp = Integer.parseInt(rs.getString("IDEmp"));
            String NameEmp = rs.getString("NameEmp");
            String Phone = rs.getString("Phone");
            String Email = rs.getString("Email");
          
            Employee employee = new Employee(IDEmp,NameEmp,Phone,Email);
            ketQua.add(employee);
        }
        ConnectDB.closeConnectDB(conn);
        }
         catch (SQLException e){
             e.printStackTrace();
         }
        return ketQua;
    }

    @Override
    public Employee selectById(Employee t) {
        Employee ketQua = null;
        try{
        Connection conn = new ConnectDB().getConnectDB();
        
        Statement st = conn.createStatement();
        
        String sql = "SELECT * FROM employee WHERE IDEmp='" + t.getIDEmp()+"'";        
    //    System.out.print(sql);        
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()){
            int IDEmp = Integer.parseInt(rs.getString("IDEmp"));
            String NameEmp = rs.getString("NameEmp");
            String Phone = rs.getString("Phone");
            String Email = rs.getString("Email");
            
            ketQua = new Employee(IDEmp,NameEmp,Phone,Email);
            
        }
        ConnectDB.closeConnectDB(conn);
        }
         catch (SQLException e){
             e.printStackTrace();
         }
        return ketQua;
    }


    @Override
    public ArrayList<Employee> selectByCondition(String condition) {
        ArrayList<Employee> ketQua = new ArrayList<Employee>();
        try{
        Connection conn = new ConnectDB().getConnectDB();
        
        Statement st = conn.createStatement();
        
        String sql = "SELECT * FROM employee WHERE "+condition;        
    //    System.out.print(sql);        
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()){
            int IDEmp = Integer.parseInt(rs.getString("IDEmp"));
            String NameEmp = rs.getString("NameEmp");
            String Phone = rs.getString("Phone");
            String Email = rs.getString("Email");
            
            Employee employee = new Employee(IDEmp,NameEmp,Phone,Email);
            ketQua.add(employee);
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
            String sql = "select max(IDEmp) from employee";
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
