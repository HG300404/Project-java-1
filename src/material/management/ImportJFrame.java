/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package material.management;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import common.OpenPdf;
import dao.BillDAO;
import dao.CategoryDAO;
import dao.CustomerDAO;
import dao.ImportDAO;
import dao.InforDAO;
import dao.ProductDAO;
import dao.SupplierDAO;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Category;
import model.Customer;
import model.Infor;
import model.Input;
import model.Product;
import model.Supplier;

/**
 *
 * @author Administrator
 */
public class ImportJFrame extends javax.swing.JFrame {

    /**
     * Creates new form ImportJFrame
     */
    public int billID ;
    public int grandTotal;
    public int productPrice;
    public int productTotal;
    public String emailPattern = "^[a-zA-Z0-9] + [@]+ [a-zA-Z0-9] + [.] + [a-zA-Z0-9] + $";
    public String phone = "^[0-9]*$";
    DefaultTableModel dtm;
    
     public ImportJFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        txtProductName.setEditable(false);
        txtPrice.setEditable(false);
        txtProductTotal.setEditable(false);
        butAddtoCart.setEnabled(false);
        butGenerate.setEnabled(false);
        JFormattedTextField tf = ((JSpinner.DefaultEditor) jSpinner1.getEditor()).getTextField();
        tf.setEnabled(true);
        ArrayList<Infor> listInfor = InforDAO.getInstance().selectAll();
        
        txtEmployee.setText(listInfor.get(0).getNameEmp());
     }
     
    public void productNameByCategory(String category){
        dtm =  (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        ArrayList<Product> list = ProductDAO.getAllRecordsByCategory(category);
        Iterator<Product> itr = list.iterator();
        while (itr.hasNext()){
            Product productObj = itr.next();
            dtm.addRow(new Object[]{productObj.getProductName()});
        }
    }
    public void filterProductByName(String name, String category){
        dtm =  (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        ArrayList<Product> list = ProductDAO.filterProductByName(name, category);
        Iterator<Product> itr = list.iterator();
        while (itr.hasNext()){
            Product productObj = itr.next();
            dtm.addRow(new Object[]{productObj.getProductName()});
        }
    }
    public void clearProductFields(){
        txtProductName.setText("");
        txtPrice.setText("");
        jSpinner1.setValue(1);
        txtProductTotal.setText("");
        butAddtoCart.setEnabled(false);
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxCategory = new javax.swing.JComboBox<>();
        txtSupName = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        txtProductTotal = new javax.swing.JTextField();
        butClear = new javax.swing.JButton();
        butAddtoCart = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jlbGrandTotal = new javax.swing.JLabel();
        butGenerate = new javax.swing.JButton();
        butExit = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jlbID = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtEmployee = new javax.swing.JTextField();
        butSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/check-list.png"))); // NOI18N
        jLabel1.setText("Place Import");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Bill ID:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Supplier Details:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Name");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Phone Number");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Email");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Category:");

        jComboBoxCategory.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBoxCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCategoryActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Search");

        txtSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Name");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Price");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Quantity");

        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Total");

        butClear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        butClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/remove-from-cart.png"))); // NOI18N
        butClear.setText("Clear");
        butClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butClearActionPerformed(evt);
            }
        });

        butAddtoCart.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        butAddtoCart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add-to-cart.png"))); // NOI18N
        butAddtoCart.setText("Add to Cart");
        butAddtoCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAddtoCartActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Quantity", "Price", "Total"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel12.setText("Grand Total: Rs");

        jlbGrandTotal.setText("000");

        butGenerate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        butGenerate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bill.png"))); // NOI18N
        butGenerate.setText("Generate Bill & Print");
        butGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butGenerateActionPerformed(evt);
            }
        });

        butExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit-full-screen.png"))); // NOI18N
        butExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butExitActionPerformed(evt);
            }
        });

        jlbID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlbID.setText("..");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Name Employee: ");

        txtEmployee.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        butSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        butSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        butSearch.setText("Search");
        butSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlbID, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(83, 83, 83)
                                .addComponent(jLabel7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3)
                                        .addComponent(txtSupName)
                                        .addComponent(txtPhone)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                        .addComponent(jLabel14)
                                        .addComponent(txtEmployee))
                                    .addComponent(butSearch))
                                .addGap(55, 55, 55)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSearch)
                                    .addComponent(jButton1)
                                    .addComponent(jComboBoxCategory, 0, 203, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                        .addGap(71, 71, 71)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10))
                                    .addComponent(jSpinner1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel9)
                                    .addComponent(txtProductTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(butClear)
                                    .addComponent(butAddtoCart)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(butGenerate)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(532, 532, 532)
                        .addComponent(jLabel12)
                        .addGap(27, 27, 27)
                        .addComponent(jlbGrandTotal)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 912, Short.MAX_VALUE)
                .addComponent(butExit)
                .addGap(54, 54, 54))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(butExit)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13)
                    .addComponent(jlbID))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butClear))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jButton1)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtProductTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(butAddtoCart))
                            .addComponent(txtSupName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel6)
                        .addGap(28, 28, 28)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(txtEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(butSearch))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(butGenerate)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(jlbGrandTotal))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jComboBoxCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCategoryActionPerformed
        // TODO add your handling code here:
        String category = (String) jComboBoxCategory.getSelectedItem();
        productNameByCategory(category);
    }//GEN-LAST:event_jComboBoxCategoryActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        String name = txtSearch.getText();
        String category = (String) jComboBoxCategory.getSelectedItem();
        filterProductByName(name,category);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int index = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        String productName = model.getValueAt(index,0).toString();
        Product product = ProductDAO.getProductBuyByName(productName);
        txtProductName.setText(product.getProductName());
        txtPrice.setText(String.valueOf(product.getPriceBuy()));
        jSpinner1.setValue(1);
        txtProductTotal.setText(String.valueOf(product.getPriceBuy()));
        productPrice = product.getPriceBuy();
        productTotal = product.getPriceBuy();
        butAddtoCart.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        // TODO add your handling code here:
        int quantity = (Integer) jSpinner1.getValue();
        if (quantity <=1){
            jSpinner1.setValue(1);
            quantity = 1;
        }
        productTotal = productPrice * quantity;
        txtProductTotal.setText(String.valueOf(productTotal));
    }//GEN-LAST:event_jSpinner1StateChanged

    private void butClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butClearActionPerformed
        // TODO add your handling code here:
        clearProductFields();
    }//GEN-LAST:event_butClearActionPerformed

    private void butAddtoCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAddtoCartActionPerformed
        // TODO add your handling code here:
        String name = txtProductName.getText();
        String price = txtPrice.getText();
        String quantity = String.valueOf(jSpinner1.getValue());
        DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
        dtm.addRow(new Object[] {name,price,quantity,productTotal});
        grandTotal = grandTotal + productTotal;
        
        ArrayList<Product> list = ProductDAO.getInstance().selectByCondition("ProductName = '"+name+"'");
        for (Product p : list)
        {
           int kq = ProductDAO.getInstance().updateByProductName(name,p.getAmount() + Integer.parseInt(quantity));
        }
        
        jlbGrandTotal.setText(String.valueOf(grandTotal));

        butGenerate.setEnabled(true);
        clearProductFields();
    }//GEN-LAST:event_butAddtoCartActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int index = jTable2.getSelectedRow();
        int a = JOptionPane.showConfirmDialog(null,"Do you want to remove this product","Select",JOptionPane.YES_NO_OPTION);
        if (a==0){
            TableModel model = jTable2.getModel();
            String total = model.getValueAt(index,3).toString();
            String name = model.getValueAt(index,0).toString();
            String quantity = model.getValueAt(index,1).toString();
            grandTotal = grandTotal - Integer.parseInt(total);
            
             ArrayList<Product> list = ProductDAO.getInstance().selectByCondition("ProductName = '"+name+"'");
            for (Product p : list)
             {
               int kq = ProductDAO.getInstance().updateByProductName(name,p.getAmount() - Integer.parseInt(quantity));
             }
            
            jlbGrandTotal.setText(String.valueOf(grandTotal));
            ((DefaultTableModel) jTable2.getModel()).removeRow(index);
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void butGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butGenerateActionPerformed
        // TODO add your handling code here:
        String supName = txtSupName.getText();
        String supPhone = txtPhone.getText();
        String supEmail = txtEmail.getText();
        String employeeName = txtEmployee.getText();

        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String todaydate = dFormat.format(date);

        Supplier p = new Supplier();
        p.setIDSup(Integer.parseInt(SupplierDAO.getID()));
        p.setSupName(supName);
        p.setDateAdd(todaydate);
        p.setPhone(supPhone);
        p.setEmail(supEmail);
        
        ArrayList<Supplier> list = SupplierDAO.getInstance().selectByCondition("SupName = '"+supName+"'");
        if (list.isEmpty()) SupplierDAO.getInstance().insert(p);

        String total = String.valueOf(grandTotal);
       
        Input input = new Input();
        input.setID(billID);
        input.setSupName(supName);
        input.setPhone(supPhone);
        input.setEmail(supEmail);
        input.setDate(todaydate);
        input.setTotal(total);
        input.setNameEmp(employeeName);
        ImportDAO.save(input);

        //Creating document
        String path = "D:\\Import";
        com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
        try{
            PdfWriter.getInstance(doc,new FileOutputStream(path+""+billID+".pdf"));
            doc.open();
            Paragraph materialName = new Paragraph ("                                      Material Management System\n");
            doc.add(materialName);
            Paragraph startLine = new Paragraph("*******************************************************************************************************");
            doc.add(startLine);
            Paragraph paragraph3 = new Paragraph("\tBill ID:"+billID+"\nCustomer Name: "+supName+"   Total Paid: "+grandTotal);
            doc.add(paragraph3);
            doc.add(startLine);
            PdfPTable tb1 = new PdfPTable(4);
            tb1.addCell("Name");
            tb1.addCell("Price");
            tb1.addCell("Quantity");
            tb1.addCell("Total");
            for (int i=0; i<jTable2.getRowCount(); i++){
                String n = jTable2.getValueAt(i,0).toString();
                String b = jTable2.getValueAt(i,1).toString();
                String q = jTable2.getValueAt(i,2).toString();
                String t = jTable2.getValueAt(i, 3).toString();
                tb1.addCell(n);
                tb1.addCell(b);
                tb1.addCell(q);
                tb1.addCell(t);
            }
            doc.add(tb1);
            doc.add(startLine);
            Paragraph thanksMsq = new Paragraph("Thank you, Please visit Again.");
            doc.add(thanksMsq);
            doc.close();
            
            try{
            if ((new File("D:\\Import"+billID+".pdf")).exists())
            {
              /*  Process r = Runtime
                        .getRuntime()
                        .exec(" D:\\Import"+billID+".pdf");*/
                Runtime rt = Runtime.getRuntime();
                try{
                    String filePath = "D:\\Import"+billID+".pdf";
                    rt.exec("hh.exe "+filePath);
                }catch (Exception ex) 
                {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Cannot load help file!","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
            else 
                JOptionPane.showMessageDialog(null,"File is not Exists");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
       
    //    setVisible(false);
    }//GEN-LAST:event_butGenerateActionPerformed

    private void butExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butExitActionPerformed
        // TODO add your handling code here:
        ViewEmployee v = new ViewEmployee();
        v.show();
        hide();
    }//GEN-LAST:event_butExitActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
         billID = Integer.parseInt(ImportDAO.getID());
        jlbID.setText(ImportDAO.getID());
        ArrayList<Category> list = CategoryDAO.getInstance().selectAll();
        Iterator<Category> itr = list.iterator();
        while (itr.hasNext()){
            Category categoryObj = itr.next();
            jComboBoxCategory.addItem(categoryObj.getCategory());
        }
        String category = (String)  jComboBoxCategory.getSelectedItem();
        productNameByCategory(category);
    }//GEN-LAST:event_formComponentShown

    private void butSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSearchActionPerformed
        // TODO add your handling code here:
        String supName = txtSupName.getText();
        ArrayList<Supplier> list = SupplierDAO.getInstance().selectByCondition("SupName = '" +supName+"'");
        if (!list.isEmpty()) 
        {
                txtPhone.setText(list.get(0).getPhone());
                txtEmail.setText(list.get(0).getEmail());
        }
    }//GEN-LAST:event_butSearchActionPerformed

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butAddtoCart;
    private javax.swing.JButton butClear;
    private javax.swing.JButton butExit;
    private javax.swing.JButton butGenerate;
    private javax.swing.JButton butSearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel jlbGrandTotal;
    private javax.swing.JLabel jlbID;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmployee;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtProductTotal;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSupName;
    // End of variables declaration//GEN-END:variables
}
