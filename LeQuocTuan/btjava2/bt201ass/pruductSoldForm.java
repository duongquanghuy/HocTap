/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2.bt201ass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author LQT
 */
public class pruductSoldForm extends javax.swing.JFrame {

    DefaultTableModel tableModel;
    ArrayList<ProductSold> listProductSold = new ArrayList<>();

    /**
     * Creates new form pruductSoldForm
     */
    public pruductSoldForm() {
        initComponents();
        tableModel = (DefaultTableModel) tbProductSold.getModel();

        loadProductsSold();
        showProductsSold();
    }
    
    private void showProductsSold(){
        tableModel.setRowCount(0);
        for (int i = 0; i < listProductSold.size(); i++) {
            tableModel.addRow(new String[]{
                listProductSold.get(i).getName(),
                listProductSold.get(i).getNameCategory(),
                String.valueOf(listProductSold.get(i).getPrice()),
                listProductSold.get(i).getDateOfManufacture(),
                listProductSold.get(i).getDateOfSold()
            });
        }
    }
    
    private void loadProductsSold() {
        listProductSold.clear();

        Connection conn = null;
        Statement statement = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bt201"
                    + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root", "");

            String sql = "select * from productssold";
            statement = conn.createStatement();

            ResultSet rs = statement.executeQuery(sql);

            tableModel.setRowCount(0); // xoa het cac dong roi ghi du lieu lai

            while (rs.next()) {
                ProductSold productSold = new ProductSold(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getInt("price"),
                        rs.getString("dateOfManufacture"),
                        rs.getString("dateOfSold")
                );

                listProductSold.add(productSold);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProductSold = new javax.swing.JTable();
        btnSearchByDay = new javax.swing.JButton();
        btnSearchByMonth = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtSearchDay = new javax.swing.JTextField();
        txtSearchMonth = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sản phẩm đã bán", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        tbProductSold.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sản phẩm", "Danh mục", "Giá", "Ngày sản xuất", "Ngày bán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbProductSold);

        btnSearchByDay.setText("Theo ngày (YYYY-MM-DD)");
        btnSearchByDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchByDayActionPerformed(evt);
            }
        });

        btnSearchByMonth.setText("Theo Tháng (YYYY-MM)");
        btnSearchByMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchByMonthActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Tra cứu sản phẩm đã bán");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(279, 279, 279)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearchByDay)
                    .addComponent(btnSearchByMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSearchDay, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                    .addComponent(txtSearchMonth))
                .addGap(210, 210, 210))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearchByDay)
                    .addComponent(txtSearchDay, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearchByMonth)
                    .addComponent(txtSearchMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchByMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchByMonthActionPerformed
        // TODO add your handling code here:
        loadProductsSold();
        showProductsSoldByMonth();
    }//GEN-LAST:event_btnSearchByMonthActionPerformed
    private void showProductsSoldByMonth(){
        String monthSearch = txtSearchMonth.getText().toString();
        tableModel.setRowCount(0);
        for (int i = 0; i < listProductSold.size(); i++) {
            if(listProductSold.get(i).getDateOfSold().contains(monthSearch)){
                tableModel.addRow(new String[]{
                listProductSold.get(i).getName(),
                listProductSold.get(i).getNameCategory(),
                String.valueOf(listProductSold.get(i).getPrice()),
                listProductSold.get(i).getDateOfManufacture(),
                listProductSold.get(i).getDateOfSold()
            });
            }
        }
        
        if(tableModel.getRowCount() == 0){
            JOptionPane.showMessageDialog(this, "Kiểm tra lại ngày tháng nhập vào");
        }
        txtSearchMonth.setText("");
        txtSearchDay.setText("");
    }
    private void btnSearchByDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchByDayActionPerformed
        // TODO add your handling code here:
        loadProductsSold();
        showProductsSoldByDay();
        
    }//GEN-LAST:event_btnSearchByDayActionPerformed
    private void showProductsSoldByDay(){
        String daySearch = txtSearchDay.getText().toString();
        tableModel.setRowCount(0);
        for (int i = 0; i < listProductSold.size(); i++) {
            if(listProductSold.get(i).getDateOfSold().contains(daySearch)){
                tableModel.addRow(new String[]{
                listProductSold.get(i).getName(),
                listProductSold.get(i).getNameCategory(),
                String.valueOf(listProductSold.get(i).getPrice()),
                listProductSold.get(i).getDateOfManufacture(),
                listProductSold.get(i).getDateOfSold()
            });
            }
        }
        if(tableModel.getRowCount() == 0){
            JOptionPane.showMessageDialog(this, "Kiểm tra lại ngày tháng nhập vào");
        }
        
        txtSearchMonth.setText("");
        txtSearchDay.setText("");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(pruductSoldForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pruductSoldForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pruductSoldForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pruductSoldForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pruductSoldForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearchByDay;
    private javax.swing.JButton btnSearchByMonth;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbProductSold;
    private javax.swing.JTextField txtSearchDay;
    private javax.swing.JTextField txtSearchMonth;
    // End of variables declaration//GEN-END:variables
}
