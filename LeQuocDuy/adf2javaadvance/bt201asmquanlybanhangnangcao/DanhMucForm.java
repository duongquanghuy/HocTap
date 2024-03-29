/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adf2javaadvance.bt201asmquanlybanhangnangcao;

import static adf2javaadvance.bt201asmquanlybanhangnangcao.DangNhapVaDangKyForm.menuChuongTrinhForm;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Duy Lumiere
 */
public class DanhMucForm extends javax.swing.JFrame {

    DefaultTableModel tableModel;

    int chiSoHienTai = -1;
    boolean banGhiDanhMucDuocChon = false;

    List<DanhMuc> danhSachDanhMuc = new ArrayList<>();

    /**
     * Creates new form Main
     */
    public DanhMucForm() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                menuChuongTrinhForm.setVisible(true);
            }
        });

        tableModel = (DefaultTableModel) tblDanhMuc.getModel();

        layDanhMucTuCsdl();
        hienDanhMucTrongBang();

        tblDanhMuc.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    chiSoHienTai = tblDanhMuc.getSelectedRow();
                    DanhMuc dm = danhSachDanhMuc.get(chiSoHienTai);

                    banGhiDanhMucDuocChon = true;

                    txtMaDanhMuc.setText(dm.getMaDanhMuc());
                    txtTenDanhMuc.setText(dm.getTenDanhMuc());
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
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
        txtMaDanhMuc = new javax.swing.JTextField();
        txtTenDanhMuc = new javax.swing.JTextField();
        btnThemDm = new javax.swing.JButton();
        btnSuaDm = new javax.swing.JButton();
        btnXoaDm = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhMuc = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Mục Sản Phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 17))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 15)); // NOI18N
        jLabel1.setText("Mã Danh Mục:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 15)); // NOI18N
        jLabel2.setText("Tên Danh Mục:");

        txtMaDanhMuc.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        txtTenDanhMuc.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        btnThemDm.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnThemDm.setText("Thêm");
        btnThemDm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDmActionPerformed(evt);
            }
        });

        btnSuaDm.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnSuaDm.setText("Sửa");
        btnSuaDm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaDmActionPerformed(evt);
            }
        });

        btnXoaDm.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnXoaDm.setText("Xóa");
        btnXoaDm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnThemDm, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSuaDm, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaDm, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTenDanhMuc))
                .addContainerGap(153, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txtTenDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemDm)
                    .addComponent(btnSuaDm)
                    .addComponent(btnXoaDm))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        tblDanhMuc.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        tblDanhMuc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã Danh Mục", "Tên Danh Mục"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDanhMuc.setRowHeight(30);
        tblDanhMuc.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblDanhMuc);
        tblDanhMuc.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void layDanhMucTuCsdl() {
        danhSachDanhMuc.clear();

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bt201quanlybanhang?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

            String sqlSel = "select * from categories";

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(sqlSel);

            while (rs.next()) {
                DanhMuc danhMuc = new DanhMuc(rs.getString("categoryId"), rs.getString("categoryName"));
                danhSachDanhMuc.add(danhMuc);
            }

            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienDanhMucTrongBang() {
        tableModel.setRowCount(0);

        danhSachDanhMuc.forEach((dm) -> {
            tableModel.addRow(new Object[]{dm.getMaDanhMuc(), dm.getTenDanhMuc()});
        });
    }

    private void btnThemDmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDmActionPerformed
        if (txtMaDanhMuc.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập Mã Danh Mục!", "Thông Báo", 1);
            return;
        }

        if (txtTenDanhMuc.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập Tên Danh Mục!", "Thông Báo", 1);
            return;
        }
        
        String maDanhMuc = txtMaDanhMuc.getText();
        String tenDanhMuc = txtTenDanhMuc.getText();
        boolean kiemTraMaDanhMuc = false;

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bt201quanlybanhang?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

            String sqlSel = "select categoryId from categories";

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(sqlSel);

            while (rs.next()) {
                if (maDanhMuc.equals(rs.getString("categoryId"))) {
                    kiemTraMaDanhMuc = true;
                }
            }

            if (kiemTraMaDanhMuc) {
                JOptionPane.showMessageDialog(rootPane, "Mã Danh Mục đã tồn tại!\nVui lòng dùng Mã khác!", "Trùng Mã Danh Mục", 1);
            } else {
                String sqlIns = "insert into categories(categoryId, categoryName) values(?, ?)";

                PreparedStatement ps = conn.prepareStatement(sqlIns);

                ps.setString(1, maDanhMuc);
                ps.setString(2, tenDanhMuc);

                ps.execute();
                ps.close();
                JOptionPane.showMessageDialog(rootPane, "Thêm Danh Mục thành công!", "Thêm Danh Mục", 1);
            }

            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        txtMaDanhMuc.setText("");
        txtTenDanhMuc.setText("");
        layDanhMucTuCsdl();
        hienDanhMucTrongBang();
    }//GEN-LAST:event_btnThemDmActionPerformed

    private void btnSuaDmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaDmActionPerformed
        if (banGhiDanhMucDuocChon) {
            banGhiDanhMucDuocChon = false;
            int xacNhanSua = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc muốn Sửa Danh Mục này theo các thông tin đã nhập?", "Cảnh Báo", 2);
            if (xacNhanSua == JOptionPane.YES_OPTION) {
                String maDanhMuc = txtMaDanhMuc.getText();
                String tenDanhMuc = txtTenDanhMuc.getText();

                String sqlUpd = "update categories set categoryId=?, categoryName=? where categoryId=?";

                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bt201quanlybanhang?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

                    PreparedStatement ps = conn.prepareStatement(sqlUpd);

                    ps.setString(1, maDanhMuc);
                    ps.setString(2, tenDanhMuc);
                    ps.setString(3, maDanhMuc);

                    ps.execute();

                    ps.close();
                    conn.close();

                    JOptionPane.showMessageDialog(rootPane, "Cập nhật dữ liệu thành công!", "Thông Báo", 1);
                } catch (SQLException ex) {
                    Logger.getLogger(DanhMucForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Không có bất kỳ sự Thay Đổi Dữ Liệu nào đã diễn ra", "Thông Báo", 1);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn đối tượng nào để Sửa!\nVui lòng click đúp chuột vào 1 bản ghi bất kỳ để thực hiện tiến trình!", "Thông Báo", 1);
        }

        txtMaDanhMuc.setText("");
        txtTenDanhMuc.setText("");
        layDanhMucTuCsdl();
        hienDanhMucTrongBang();
    }//GEN-LAST:event_btnSuaDmActionPerformed

    private void btnXoaDmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDmActionPerformed
        if (banGhiDanhMucDuocChon) {
            banGhiDanhMucDuocChon = false;
            int xacNhanXoa = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc muốn Xóa Danh Mục này?", "Cảnh Báo", 2);
            if (xacNhanXoa == JOptionPane.YES_OPTION) {
                String maDanhMuc = txtMaDanhMuc.getText();

                String sqlDel = "delete from categories where categoryId=?";

                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bt201quanlybanhang?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

                    PreparedStatement ps = conn.prepareStatement(sqlDel);

                    ps.setString(1, maDanhMuc);

                    ps.execute();

                    ps.close();
                    conn.close();

                    JOptionPane.showMessageDialog(rootPane, "Cập nhật dữ liệu thành công!", "Thông Báo", 1);
                } catch (SQLException ex) {
                    Logger.getLogger(DanhMucForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Không có bất kỳ sự Thay Đổi Dữ Liệu nào đã diễn ra", "Thông Báo", 1);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn đối tượng nào để Xóa!\nVui lòng click đúp chuột vào 1 bản ghi bất kỳ để thực hiện tiến trình!", "Thông Báo", 1);
        }

        txtMaDanhMuc.setText("");
        txtTenDanhMuc.setText("");
        layDanhMucTuCsdl();
        hienDanhMucTrongBang();
    }//GEN-LAST:event_btnXoaDmActionPerformed

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
            java.util.logging.Logger.getLogger(DanhMucForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DanhMucForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DanhMucForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DanhMucForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DanhMucForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSuaDm;
    private javax.swing.JButton btnThemDm;
    private javax.swing.JButton btnXoaDm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDanhMuc;
    private javax.swing.JTextField txtMaDanhMuc;
    private javax.swing.JTextField txtTenDanhMuc;
    // End of variables declaration//GEN-END:variables
}
