/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adf2javaadvance.bt201asmquanlybanhangnangcao;

import static adf2javaadvance.bt201asmquanlybanhangnangcao.DangNhapVaDangKyForm.dangNhapVaDangKyForm;
import static adf2javaadvance.bt201asmquanlybanhangnangcao.DangNhapVaDangKyForm.danhMucForm;
import static adf2javaadvance.bt201asmquanlybanhangnangcao.DangNhapVaDangKyForm.sanPhamForm;
import static adf2javaadvance.bt201asmquanlybanhangnangcao.DangNhapVaDangKyForm.thongKeForm;
import javax.swing.JOptionPane;

/**
 *
 * @author Duy Lumiere
 */
public class MenuChuongTrinhForm extends javax.swing.JFrame {

    /**
     * Creates new form MenuChuongTrinh
     */
    public MenuChuongTrinhForm() {
        initComponents();
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(rootPane,
                    "Bạn có thực sự muốn Thoát khỏi chương trình?", "Xác nhận Thoát?", 2) == 0) {
                    System.exit(0);
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnSanPhamAccess = new javax.swing.JButton();
        btnThongKeAccess = new javax.swing.JButton();
        btnDanhMucAccess = new javax.swing.JButton();
        btnDangXuatAccess = new javax.swing.JButton();
        btnThoatAccess = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 23)); // NOI18N
        jLabel1.setText("QUẢN LÝ BÁN HÀNG");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 23)); // NOI18N
        jLabel2.setText("CHƯƠNG TRÌNH");

        btnSanPhamAccess.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        btnSanPhamAccess.setText("Sản phẩm");
        btnSanPhamAccess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSanPhamAccessActionPerformed(evt);
            }
        });

        btnThongKeAccess.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        btnThongKeAccess.setText("Thống kê");
        btnThongKeAccess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeAccessActionPerformed(evt);
            }
        });

        btnDanhMucAccess.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        btnDanhMucAccess.setText("Danh mục");
        btnDanhMucAccess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDanhMucAccessActionPerformed(evt);
            }
        });

        btnDangXuatAccess.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        btnDangXuatAccess.setText("Đăng xuất");
        btnDangXuatAccess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatAccessActionPerformed(evt);
            }
        });

        btnThoatAccess.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        btnThoatAccess.setText("Thoát");
        btnThoatAccess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatAccessActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDanhMucAccess, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSanPhamAccess, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThongKeAccess, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDangXuatAccess, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(btnThoatAccess, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel1)))
                .addContainerGap(72, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(105, 105, 105))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(btnDanhMucAccess)
                .addGap(26, 26, 26)
                .addComponent(btnSanPhamAccess)
                .addGap(27, 27, 27)
                .addComponent(btnThongKeAccess)
                .addGap(27, 27, 27)
                .addComponent(btnDangXuatAccess)
                .addGap(26, 26, 26)
                .addComponent(btnThoatAccess)
                .addContainerGap(22, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSanPhamAccessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSanPhamAccessActionPerformed
        this.setVisible(false);
        sanPhamForm.setVisible(true);
    }//GEN-LAST:event_btnSanPhamAccessActionPerformed

    private void btnDanhMucAccessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDanhMucAccessActionPerformed
        this.setVisible(false);
        danhMucForm.setVisible(true);
    }//GEN-LAST:event_btnDanhMucAccessActionPerformed

    private void btnThoatAccessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatAccessActionPerformed
        int confirmQuit = JOptionPane.showConfirmDialog(rootPane, "Bạn có thực sự muốn Thoát khỏi chương trình?", "Xác nhận Thoát?", 2);
        if (confirmQuit == JOptionPane.OK_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnThoatAccessActionPerformed

    private void btnDangXuatAccessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatAccessActionPerformed
        int confirmQuit = JOptionPane.showConfirmDialog(rootPane, "Bạn có thực sự muốn Đăng Xuất khỏi chương trình?", "Đăng Xuất", 2);
        if (confirmQuit == JOptionPane.OK_OPTION) {
            dangNhapVaDangKyForm.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnDangXuatAccessActionPerformed

    private void btnThongKeAccessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeAccessActionPerformed
        this.setVisible(false);
        thongKeForm.setVisible(true);
    }//GEN-LAST:event_btnThongKeAccessActionPerformed

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
            java.util.logging.Logger.getLogger(MenuChuongTrinhForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuChuongTrinhForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuChuongTrinhForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuChuongTrinhForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuChuongTrinhForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangXuatAccess;
    private javax.swing.JButton btnDanhMucAccess;
    private javax.swing.JButton btnSanPhamAccess;
    private javax.swing.JButton btnThoatAccess;
    private javax.swing.JButton btnThongKeAccess;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
