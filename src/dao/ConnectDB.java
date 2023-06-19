/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class ConnectDB {
   
    private Connection conn=null ;
    public Connection getConnectDB(){
          try 
          {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
              if (conn != null)
              {
           //    System.out.print("Connected to database successfully");    
               return conn;
              }       
//          }catch(Exception e)
//             {
//                 System.out.println("Not connected to database");
//             }*/
         }
          catch (Exception e)
          {
              e.printStackTrace();
          }
          return conn;
    } 
  
    public static void closeConnectDB(Connection conn)
    {
        try{
            if (conn!= null){
                conn.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }   
    } 
    
    public static void printInFo(Connection conn){
        try{
            if (conn!=null){
                DatabaseMetaData mtdt = conn.getMetaData();
                System.out.println(mtdt.getDatabaseProductName());
                System.out.print(mtdt.getDatabaseProductVersion());
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        
    }
    
}
