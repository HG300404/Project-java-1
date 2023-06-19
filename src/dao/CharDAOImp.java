/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.RevenueBean;

/**
 *
 * @author Administrator
 */
public class CharDAOImp implements CharDAO {
      public static CharDAOImp getInstance(){
        return new CharDAOImp();
    }   

    @Override
    public List<RevenueBean> getListRevenue() {
        try{
        Connection conn = new ConnectDB().getConnectDB();
        String sql ="SELECT Date, Sum(Total) AS Sum FROM revenue GROUP BY Date";
        List<RevenueBean> list = new ArrayList<>();
        PreparedStatement ps = conn.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next())
        {
            RevenueBean revenueBean = new RevenueBean();
            revenueBean.setDate(rs.getString("Date"));
            revenueBean.setTotal((int) Double.parseDouble(rs.getString("Sum")));
            list.add(revenueBean);
        }
        return list;
        } catch (SQLException ex){
           ex.printStackTrace();
        }
        return null;
    }
 
}
