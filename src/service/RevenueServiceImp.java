/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.CharDAO;
import dao.CharDAOImp;
import dao.RevenueDAO;
import java.util.List;
import model.RevenueBean;

/**
 *
 * @author Administrator
 */
public class RevenueServiceImp implements RevenueService {

    private CharDAO revenueDAO = null;
    
    public RevenueServiceImp(){
        revenueDAO = new CharDAOImp();
    }
    @Override
    public List<RevenueBean> getListRevenue() {
        return revenueDAO.getListRevenue();
    }
    
   
}
