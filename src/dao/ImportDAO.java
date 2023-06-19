/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.Input;

/**
 *
 * @author Administrator
 */
public class ImportDAO {
    public static String getID(){
        int id = 1;
        try{
            Connection conn = new ConnectDB().getConnectDB();
            String sql = "select max(IDInput) from input";
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
    public static void save(Input input){
        String sql = "insert into input values ('"+input.getID()+"','"+input.getSupName()+"','"+input.getPhone()+"','"+input.getEmail()+"','"+input.getDate()+"','"+input.getTotal()+"','"+input.getNameEmp()+"')";
        try{
            Connection conn = new ConnectDB().getConnectDB();
            Statement st = conn.createStatement();
            int ketQua = st.executeUpdate(sql);
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
