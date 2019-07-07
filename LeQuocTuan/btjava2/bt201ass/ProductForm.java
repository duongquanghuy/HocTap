/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2.bt201ass;

import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LQT
 */
public class ProductForm extends javax.swing.JFrame {

    ArrayList<Category> categoryList = new ArrayList<>();

    DefaultTableModel tableModel;

    ArrayList<Product> productList = new ArrayList<>();

    /**
     * Creates new form ProductForm
     */
    public ProductForm() {
        initComponents();
        tableModel = (DefaultTableModel) tbProduct.getModel();
        loadCategoryDatabase();
        //hien thi danh muc ra commbo box
        DefaultComboBoxModel<String> comboBoxModel = (DefaultComboBoxModel<String>) cbCategory.getModel();
        comboBoxModel.removeAllElements();
        for (Category category : categoryList) {
            comboBoxModel.addElement(category.getName());
        }

        loadProducts();
        showProducts();

        tbProduct.addMouseListener(new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = tbProduct.getSelectedRow();
                Product product = productList.get(index);
                txtName.setText(product.getName());
                txtPrice.setText(String.valueOf(product.getPrice()));
                txtDateOfManufacture.setText(product.getDateOfManufacture());

                btnUpdate.setEnabled(true);
                btnDelete.setEnabled(true);
                btnSoldProduct.setEnabled(true);
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

            @Override
            public void mouseDragged(MouseEvent e) {
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });
    }

    private void loadProducts() {
        productList.clear();

        Connection conn = null;
        Statement statement = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bt201"
                    + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root", "");

            String sql = "SELECT products.*, categories.ID id_Cat, categories.NAME name_Cat FROM products, categories WHERE products.idCategory = categories.ID";
            statement = conn.createStatement();

            ResultSet rs = statement.executeQuery(sql);

            tableModel.setRowCount(0); // xoa het cac dong roi ghi du lieu lai

            while (rs.next()) {
                Product product = new Product(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("dateOfManufacture"),
                        rs.getInt("idCategory"),
                        rs.getString("name_Cat"),
                        "");
                productList.add(product);

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

    private void showProducts() {
        tableModel.setRowCount(0);
        for (int i = 0; i < productList.size(); i++) {
            tableModel.addRow(new String[]{
                productList.get(i).getName(),
                productList.get(i).getNameCategory(),
                String.valueOf(productList.get(i).getPrice()),
                productList.get(i).getDateOfManufacture(),
                productList.get(i).checkStatus(productList.get(i).getDateOfManufacture()) //productList.get(i).getStatus()
            });
        }
    }

    private void loadCategoryDatabase() {
        // lưu dữ liệu vào list category
        categoryList.clear();

        Connection conn = null;
        Statement statement = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bt201"
                    + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root", "");

            String sql = "select * from categories";
            statement = conn.createStatement();

            ResultSet rs = statement.executeQuery(sql);

            tableModel.setRowCount(0); // xoa het cac dong roi ghi du lieu lai
            while (rs.next()) {
                Category category = new Category(rs.getInt("id"), rs.getString("name"));
                categoryList.add(category);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtName = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtPrice = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDateOfManufacture = new javax.swing.JTextPane();
        cbCategory = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnSoldProduct = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbProduct = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "San pham", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Danh mục sản phẩm");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Ngày sản xuất (YYYY-MM-DD)");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Giá sản phẩm");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Tên sản phẩm");

        jScrollPane1.setViewportView(txtName);

        txtPrice.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane2.setViewportView(txtPrice);

        jScrollPane3.setViewportView(txtDateOfManufacture);

        cbCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAdd.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnUpdate.setText("Sửa");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnSoldProduct.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnSoldProduct.setText("Bán");
        btnSoldProduct.setToolTipText("");
        btnSoldProduct.setEnabled(false);
        btnSoldProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoldProductActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSoldProduct)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnAdd)
                                        .addGap(114, 114, 114)
                                        .addComponent(btnUpdate)
                                        .addGap(114, 114, 114)
                                        .addComponent(btnDelete)
                                        .addGap(114, 114, 114)
                                        .addComponent(btnSearch))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(71, 71, 71)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(55, 55, 55))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(btnSoldProduct)
                .addGap(17, 17, 17))
        );

        tbProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên sản phẩm", "Danh mục", "GIá bán", "Ngày sản xuất", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tbProduct);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        String nameProduct = txtName.getText().toString();
        int priceProduct = 0;
        try {
            priceProduct = Integer.parseInt(txtPrice.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Kiểm tra lại định dạng giá");
        }

        String dateOfManufacture = txtDateOfManufacture.getText().toString();
        Category category = categoryList.get(cbCategory.getSelectedIndex());
        int idCategory = category.getId();
        if (nameProduct.equals("")) {
            JOptionPane.showMessageDialog(this, "Tên sản phẩm không được để trống");
        } else if (String.valueOf(priceProduct).equals("")) {
            JOptionPane.showMessageDialog(this, "Giá sản phẩm không được để trống");
        } else if (dateOfManufacture.equals("") || dateOfManufacture.contains(" ")) {
            JOptionPane.showMessageDialog(this, "Kiểm tra lại định dạng ngày sản xuất");
        } else {
            addProduct(nameProduct, priceProduct, dateOfManufacture, idCategory);
        }
        loadProducts();
        showProducts();

        txtName.setText("");
        txtPrice.setText("");
        txtDateOfManufacture.setText("");


    }//GEN-LAST:event_btnAddActionPerformed

    private void addProduct(String nameProduct, int priceProduct, String dateOfManufacture, int idCategory) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bt201"
                    + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root", "");
            String sql = "insert into products (name, price, dateOfManufacture, idCategory) values (?, ?, ?, ?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, nameProduct);
            preparedStatement.setString(2, String.valueOf(priceProduct));
            preparedStatement.setString(3, dateOfManufacture);
            preparedStatement.setString(4, String.valueOf(idCategory));
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int index = tbProduct.getSelectedRow();
        Product product = productList.get(index);
        deleteProduct(product.getId());
        loadProducts();
        showProducts();
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
    }//GEN-LAST:event_btnDeleteActionPerformed
    private void deleteProduct(int id) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bt201"
                    + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root", "");
            String sql = "delete from products where id = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }


    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        int index = tbProduct.getSelectedRow();
        Product product = productList.get(index);
        String nameProduct = txtName.getText().toString();
        int priceProduct = 0;
        try {
            priceProduct = Integer.parseInt(txtPrice.getText());
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Kiểm tra lại định dạng giá");
        }
        String dateOfManufacture = txtDateOfManufacture.getText().toString();
        Category category = categoryList.get(cbCategory.getSelectedIndex());
        int idCategory = category.getId();
        int idProduct = product.getId();
        if (nameProduct.equals("")) {
            JOptionPane.showMessageDialog(this, "Tên sản phẩm không được để trống");
        } else if (String.valueOf(priceProduct).equals("")) {
            JOptionPane.showMessageDialog(this, "Giá sản phẩm không được để trống");
        } else if (dateOfManufacture.equals("") || dateOfManufacture.contains(" ")) {
            JOptionPane.showMessageDialog(this, "Kiểm tra lại định dạng ngày sản xuất");
        } else {
            try {
                updateProduct(nameProduct, priceProduct, dateOfManufacture, idCategory, idProduct);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Kiểm tra lại định dạng ngày sản xuất");
            }
        }
        loadProducts();
        showProducts();

        txtName.setText("");
        txtPrice.setText("");
        txtDateOfManufacture.setText("");
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void updateProduct(String nameProduct, int priceProduct, String dateOfManufacture, int idCategory, int idProduct) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bt201"
                    + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root", "");
            String sql = "update products set name = ?, price = ?, dateOfManufacture = ?, idCategory = ? where id = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, nameProduct);
            preparedStatement.setString(2, String.valueOf(priceProduct));
            preparedStatement.setString(3, dateOfManufacture);
            preparedStatement.setString(4, String.valueOf(idCategory));
            preparedStatement.setString(5, String.valueOf(idProduct));
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String nameProduct = txtName.getText().toString();

        searchProducts(nameProduct);
        showProducts();

        txtName.setText("");
        txtPrice.setText("");
        txtDateOfManufacture.setText("");
    }//GEN-LAST:event_btnSearchActionPerformed

    private void searchProducts(String nameProduct) {
        productList.clear();

        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bt201"
                    + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root", "");

            String sql = "SELECT products.*, categories.ID id_Cat, categories.NAME name_Cat FROM products, categories WHERE products.name = ? and products.idCategory = categories.ID";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, nameProduct);
            preparedStatement.execute();
            ResultSet rs = preparedStatement.executeQuery();

            tableModel.setRowCount(0); // xoa het cac dong roi ghi du lieu lai

            while (rs.next()) {
                Product product = new Product(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("dateOfManufacture"),
                        rs.getInt("idCategory"),
                        rs.getString("name_Cat"),
                        "");
                productList.add(product);

            }

            if (tableModel.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Không có sản phẩm này !!!");
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
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void btnSoldProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoldProductActionPerformed
        // TODO add your handling code here:
        String nameProduct = txtName.getText().toString();
        int priceProduct = Integer.parseInt(txtPrice.getText());
        String nameCategory = cbCategory.getSelectedItem().toString();
        String dateOfManufacture = txtDateOfManufacture.getText().toString();
        String dateOfSold = java.time.LocalDate.now().toString();

//      Xoa cot dang chon khoi danh sach hàng còn
        int index = tbProduct.getSelectedRow();
        Product product = productList.get(index);
        deleteProduct(product.getId());

//        Thêm dòng đang chọn vào bảng sản phẩm đã bán ở database
        addProductSold(nameProduct, nameCategory, priceProduct, dateOfManufacture, dateOfSold);

        loadProducts();
        showProducts();
    }//GEN-LAST:event_btnSoldProductActionPerformed

    private void addProductSold(String nameProduct, String category, int price, String dateOfManufacture, String dateOfSold) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bt201"
                    + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root", "");
            String sql = "insert into productssold (name, category, price, dateOfManufacture, dateOfSold) values (?, ?, ?, ?, ?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, nameProduct);
            preparedStatement.setString(2, category);
            preparedStatement.setString(3, String.valueOf(price));
            preparedStatement.setString(4, dateOfManufacture);
            preparedStatement.setString(5, dateOfSold);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
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
            java.util.logging.Logger.getLogger(ProductForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSoldProduct;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tbProduct;
    private javax.swing.JTextPane txtDateOfManufacture;
    private javax.swing.JTextPane txtName;
    private javax.swing.JTextPane txtPrice;
    // End of variables declaration//GEN-END:variables
}
