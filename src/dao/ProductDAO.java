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
import model.Product;

/**
 *
 * @author Administrator
 */
public class ProductDAO implements DAOInterface<Product> {

    public static ProductDAO getInstance(){
        return new ProductDAO();
    }   
    @Override    
    public int insert(Product t) {
        int ketQua = 0;
        try{
            // Tao ket noi den CSDL
        Connection conn = new ConnectDB().getConnectDB();
        
        // Tao doi tuong Statement
        Statement st = conn.createStatement();
        
        // Thuc thi cau lenh SQL
        String sql = "INSERT INTO product(IDProduct, ProductName, TypeName, Amount, PriceBuy,PriceSell)"
               + " VALUES('"+t.getIDProduct()+"','"+t.getProductName()+"','"+t.getTypeName()+"','"+t.getAmount()+"','"+t.getPriceBuy()+"','"+t.getPriceSell()+"'"+")";
        
        
        //
        ketQua = st.executeUpdate(sql);
   //     System.out.println("Ban da thuc thi: "+sql);
   //     System.out.println("Co " + ketQua +"dong bi thay doi");
        
        // Ngat ket noi
        ConnectDB.closeConnectDB(conn);
        }
         catch (SQLException e){
             e.printStackTrace();
         }
        return ketQua;
    }

    @Override
    public int update(Product t) {
        int ketQua = 0;
        try{
        Connection conn = new ConnectDB().getConnectDB();
        Statement st = conn.createStatement();
        
        String sql = "UPDATE product "+
                " SET "+       
           //     " TypeName='"+t.getTypeName()+"'"+
          //      " ProductName='"+t.getProductName()+"'"+
          //      ", Amount='"+t.getAmount()+"'"+
                " PriceBuy='"+t.getPriceBuy()+"'"+
                ", PriceSell='"+t.getPriceSell()+"'"+
                " WHERE IDProduct='"+t.getIDProduct()+"\'";
        
    //    System.out.print(sql);
        
        ketQua = st.executeUpdate(sql);
  //      System.out.println("Ban da thuc thi: "+sql);
  //      System.out.println("Co " + ketQua +"dong bi thay doi");
        
        ConnectDB.closeConnectDB(conn);
        }
         catch (SQLException e){
             e.printStackTrace();
         }
        return ketQua;
    }

    public int updateByProductName(String name,int amount) {
        int ketQua = 0;
        try{
        Connection conn = new ConnectDB().getConnectDB();
        Statement st = conn.createStatement();
        
        String sql = "UPDATE product "+
                " SET "+     
                " Amount='"+amount+"'"+
                " WHERE ProductName='"+name+"\'";
        
    //    System.out.print(sql);
        
        ketQua = st.executeUpdate(sql);
  //      System.out.println("Ban da thuc thi: "+sql);
  //      System.out.println("Co " + ketQua +"dong bi thay doi");
        
        ConnectDB.closeConnectDB(conn);
        }
         catch (SQLException e){
             e.printStackTrace();
         }
        return ketQua;
    }

    @Override
    public int delete(Product t) {
        int ketQua = 0;
        try{
        Connection conn = new ConnectDB().getConnectDB();
        Statement st = conn.createStatement();
        
        String sql = "DELETE from product "+                
                " WHERE IDProduct='"+t.getIDProduct()+"'";
        
    //    System.out.print(sql);
        
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
    public ArrayList<Product> selectAll() {
        ArrayList<Product> ketQua = new ArrayList<Product>();
        try{
        Connection conn = new ConnectDB().getConnectDB();
        
        Statement st = conn.createStatement();
        
        String sql = "SELECT * FROM product";        
    //    System.out.print(sql);        
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()){
            int IDProduct = Integer.parseInt(rs.getString("IDProduct"));
            String ProductName = rs.getString("ProductName");
            String TypeName = rs.getString("TypeName");
            int Amount = Integer.parseInt(rs.getString("Amount"));
            int PriceBuy = Integer.parseInt(rs.getString("PriceBuy"));
            int PriceSell = Integer.parseInt(rs.getString("PriceSell"));
            Product product = new Product(IDProduct, ProductName, TypeName, Amount, PriceBuy,PriceSell);
            ketQua.add(product);
        }
        ConnectDB.closeConnectDB(conn);
        }
         catch (SQLException e){
             e.printStackTrace();
         }
        return ketQua;
    }

    @Override
    public Product selectById(Product t) {
        Product ketQua = null;
        try{
        Connection conn = new ConnectDB().getConnectDB();
        
        Statement st = conn.createStatement();
        
        String sql = "SELECT * FROM product WHERE IDProduct='" + t.getIDProduct()+"'";        
    //    System.out.print(sql);        
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()){
            int IDProduct = Integer.parseInt(rs.getString("IDProduct"));
            String ProductName = rs.getString("ProductName");
            String TypeName = rs.getString("TypeName");
            int Amount = Integer.parseInt(rs.getString("Amount"));
            int PriceBuy = Integer.parseInt(rs.getString("PriceBuy"));
            int PriceSell = Integer.parseInt(rs.getString("PriceSell"));
            
            ketQua = new Product(IDProduct, ProductName, TypeName, Amount, PriceBuy, PriceSell);
            
        }
        ConnectDB.closeConnectDB(conn);
        }
         catch (SQLException e){
             e.printStackTrace();
         }
        return ketQua;
    }

    @Override
    public ArrayList<Product> selectByCondition(String condition) {
        ArrayList<Product> ketQua = new ArrayList<Product>();
        try{
        Connection conn = new ConnectDB().getConnectDB();
        
        Statement st = conn.createStatement();
        
        String sql = "SELECT * FROM product WHERE "+condition;        
    //    System.out.print(sql);        
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()){
            int IDProduct = Integer.parseInt(rs.getString("IDProduct"));
            String ProductName = rs.getString("ProductName");
            String TypeName = rs.getString("TypeName");
            Integer Amount = rs.getInt("Amount");
            int PriceBuy = Integer.parseInt(rs.getString("PriceBuy"));
            int PriceSell = Integer.parseInt(rs.getString("PriceSell"));
            
            Product product = new Product(IDProduct, ProductName, TypeName, Amount, PriceBuy, PriceSell);
            ketQua.add(product);
        }
        ConnectDB.closeConnectDB(conn);
        }
         catch (SQLException e){
             e.printStackTrace();
         }
        return ketQua;
    }
    public static ArrayList<Product> getAllRecordsByCategory(String category){
        ArrayList<Product> arrayList = new ArrayList<>();
        try{
            Connection conn = new ConnectDB().getConnectDB();
            Statement st = conn.createStatement();
            String sql = "select * from product where typename='"+category+"'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                Product p = new Product();
                p.setProductName(rs.getString("ProductName"));
                arrayList.add(p);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
     public static ArrayList<Product> filterProductByName(String name, String category){
        ArrayList<Product> arrayList = new ArrayList<>();
        try{
            Connection conn = new ConnectDB().getConnectDB();
            Statement st = conn.createStatement();
            String sql = "select * from product where ProductName like '%"+ name + "%' and TypeName ='"+category+"'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                Product p = new Product();
                p.setProductName(rs.getString("ProductName"));
                arrayList.add(p);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
      public static Product getProductBuyByName(String name){
         Product p = new Product();
         try{
             Connection conn = new ConnectDB().getConnectDB();
             Statement st = conn.createStatement();
             String sql = "select * from product where ProductName='"+name+"'";
             ResultSet rs = st.executeQuery(sql);
             while (rs.next()){
                 p.setProductName(rs.getString("ProductName"));
                 p.setTypeName(rs.getString("TypeName"));
                 p.setPriceBuy(Integer.parseInt(rs.getString("PriceBuy")));
             }
         }catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
         }
         return p;
     }
     public static Product getProductSellByName(String name){
         Product p = new Product();
         try{
             Connection conn = new ConnectDB().getConnectDB();
             Statement st = conn.createStatement();
             String sql = "select * from product where ProductName='"+name+"'";
             ResultSet rs = st.executeQuery(sql);
             while (rs.next()){
                 p.setProductName(rs.getString("ProductName"));
                 p.setTypeName(rs.getString("TypeName"));
                 p.setPriceSell(Integer.parseInt(rs.getString("PriceSell")));
             }
         }catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
         }
         return p;
     }
     public static String getID(){
        int id = 1;
        try{
            Connection conn = new ConnectDB().getConnectDB();
            String sql = "select max(IDProduct) from product";
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
