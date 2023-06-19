/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JPanel;
import model.RevenueBean;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import service.RevenueService;
import service.RevenueServiceImp;

/**
 *
 * @author Administrator
 */
public class RevenueController {
    
     private RevenueService revenueService = null;
     
     public RevenueController(){
         revenueService = new RevenueServiceImp();
     }
     public void setDate(JPanel jpnItem){
         List<RevenueBean> listItem = revenueService.getListRevenue();
         if(listItem != null)
         {
         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
         for(RevenueBean item : listItem){
             dataset.addValue(item.getTotal(), "Revenue", item.getDate());
            }
             JFreeChart chart = ChartFactory.createBarChart("THỐNG KÊ DOANH THU", "Date", "Money", dataset);
             ChartPanel chartPanel = new ChartPanel(chart);
             chartPanel.setPreferredSize(new Dimension(1100,350));
            
             jpnItem.removeAll();
             jpnItem.setLayout(new CardLayout());
             jpnItem.add(chartPanel);
             jpnItem.validate();
             jpnItem.repaint();
         } 
     }
}
