/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Administrator
 */
public class OpenPdf {
    public static void openById(String id){
        try{
            if ((new File("D:\\Bill"+id+".pdf")).exists()){
                Process p = Runtime
                        .getRuntime()
                        .exec(" D:\\Bill"+id+".pdf");
            }
            else 
                JOptionPane.showMessageDialog(null,"File is not Exists");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void openFile(String file){
        try{
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch(IOException ioe){
            System.out.println(ioe);
        }
    }
    
    public void exportarExcel(JTable jt)
    {
       try{
           JFileChooser jFileChooser = new JFileChooser();
           jFileChooser.showSaveDialog(jt);
           File saveFile = jFileChooser.getSelectedFile();
           if (saveFile != null){
               saveFile = new File (saveFile.toString()+".xlsx");
               Workbook wb = new XSSFWorkbook();
               Sheet sheet = wb.createSheet("film");
               Row rowCol = sheet.createRow(0);
               
               for (int i=0; i<jt.getColumnCount();++i){
                   Cell cell = rowCol.createCell(i);
                   cell.setCellValue(jt.getColumnName(i));
               }
               
               for (int j=0; j<jt.getRowCount(); j++){
                   Row row = sheet.createRow(j+1);
                   for (int k =0; k<jt.getColumnCount(); k++){
                       Cell cell = row.createCell(k);
                       if (jt.getValueAt(j,k) != null){
                           cell.setCellValue(jt.getValueAt(j, k).toString());
                       }
                   }
               }
               
               FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
               wb.write(out);
               wb.close();
               out.close();
               openFile(saveFile.toString());
           } else {
               JOptionPane.showMessageDialog(null,"File is not Exists");
           }
       }
           catch(FileNotFoundException e)
                   {
                 System.out.println(e);
                   } 
           catch(IOException io){
                   System.out.println(io);
                      }
           
       }     
}
