/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import model.Bill;
/**
 *
 * @author Administrator
 */
public class BillDAO {
    public static String getID(){
        int id = 1;
        try{
            Connection conn = new ConnectDB().getConnectDB();
            String sql = "select max(IDBill) from bill";
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
    public static void save(Bill bill){
        String sql = "insert into bill values ('"+bill.getID()+"','"+bill.getCusName()+"','"+bill.getPhone()+"','"+bill.getEmail()+"','"+bill.getDate()+"','"+bill.getTotal()+"','"+bill.getNameEmp()+"')";
        try{
            Connection conn = new ConnectDB().getConnectDB();
            Statement st = conn.createStatement();
            int ketQua = st.executeUpdate(sql);
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
