/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form;

import SQLServerProvider.SQLServerProvider;
import com.DAO.TaiKhoanDAO;
import com.DTO.TaiKhoanDTO;
import com.raven.dialog.Message;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class Form_QuanLyTaiKhoan extends javax.swing.JPanel {
    private SQLServerProvider conn;
    private Main main;
    /**
     * Creates new form Form_QuanLyTaiKhoan
     */
    public Form_QuanLyTaiKhoan(Main main) {
        this.main = main;
        initComponents();
        conn = new SQLServerProvider();
        conn.open();
        hienThiDS();
        conn.close();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbTaiKhoan = new com.raven.component.Table();
        btnTraCuu = new com.raven.component.Button();
        txtTraCuu = new com.raven.component.TextField();
        cboSapXep = new combo_suggestion.ComboBoxSuggestion();
        btnXoaTK = new com.raven.component.Button();
        btnCapNhatTK = new com.raven.component.Button();
        btnThemTK = new com.raven.component.Button();
        btnSapXep = new com.raven.component.Button();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1008, 700));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("Admin / Quản Lý Nhân Viên");

        tbTaiKhoan.setBackground(new java.awt.Color(236, 234, 234));
        tbTaiKhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Tên hiển thị", "Tên đăng nhập", "Mật khẩu", "Tên nhân viên", "Email", "Phân quyền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbTaiKhoan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tbTaiKhoan.setGridColor(new java.awt.Color(204, 204, 204));
        tbTaiKhoan.setSelectionBackground(new java.awt.Color(102, 102, 255));
        tbTaiKhoan.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tbTaiKhoan.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tbTaiKhoan.setShowGrid(true);
        jScrollPane2.setViewportView(tbTaiKhoan);

        btnTraCuu.setBackground(new java.awt.Color(153, 153, 255));
        btnTraCuu.setForeground(new java.awt.Color(255, 255, 255));
        btnTraCuu.setText("Tra Cứu");
        btnTraCuu.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnTraCuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraCuuActionPerformed(evt);
            }
        });

        txtTraCuu.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtTraCuu.setName(""); // NOI18N
        txtTraCuu.setShadowColor(new java.awt.Color(99, 91, 255));

        cboSapXep.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Vui lòng chọn dữ liệu cần sắp xếp--", "Mã nhân viên", "Tên nhân viên", "Chức vụ", "Địa chỉ", "Email" }));
        cboSapXep.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        cboSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSapXepActionPerformed(evt);
            }
        });

        btnXoaTK.setBackground(new java.awt.Color(244, 67, 54));
        btnXoaTK.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/minus.png"))); // NOI18N
        btnXoaTK.setText("Xóa tài khoản");
        btnXoaTK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoaTK.setIconTextGap(10);
        btnXoaTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTKActionPerformed(evt);
            }
        });

        btnCapNhatTK.setBackground(new java.awt.Color(0, 140, 186));
        btnCapNhatTK.setForeground(new java.awt.Color(255, 255, 255));
        btnCapNhatTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/edit_1.png"))); // NOI18N
        btnCapNhatTK.setText("Cập nhật thông tin");
        btnCapNhatTK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCapNhatTK.setIconTextGap(10);
        btnCapNhatTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatTKActionPerformed(evt);
            }
        });

        btnThemTK.setBackground(new java.awt.Color(76, 175, 80));
        btnThemTK.setForeground(new java.awt.Color(255, 255, 255));
        btnThemTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/addWhite.png"))); // NOI18N
        btnThemTK.setText("Thêm tài khoản");
        btnThemTK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemTK.setIconTextGap(10);
        btnThemTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemTKActionPerformed(evt);
            }
        });

        btnSapXep.setBackground(new java.awt.Color(153, 153, 255));
        btnSapXep.setForeground(new java.awt.Color(255, 255, 255));
        btnSapXep.setText("Sắp xếp theo:");
        btnSapXep.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTraCuu, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnTraCuu, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 257, Short.MAX_VALUE)
                                .addComponent(btnSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnThemTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoaTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCapNhatTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTraCuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTraCuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemTK, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaTK, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhatTK, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTraCuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraCuuActionPerformed
//        DefaultTableModel model = (DefaultTableModel) tbTaiKhoan.getModel();
//        model.setRowCount(0);
//        hienThiDSTimKiem(txtTraCuu.getText());
    }//GEN-LAST:event_btnTraCuuActionPerformed

    private void cboSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSapXepActionPerformed
//        DefaultTableModel model = (DefaultTableModel) tbTaiKhoan.getModel();
//        model.setRowCount(0);
//        if("Mã nhân viên".equals(cboSapXep.getSelectedItem().toString()))
//        hienThiDSSapXep("MANV");
//        else if("Tên nhân viên".equals(cboSapXep.getSelectedItem().toString()))
//        hienThiDSSapXep("HOTENNV");
//        else if("Địa chỉ".equals(cboSapXep.getSelectedItem().toString()))
//        hienThiDSSapXep("DIACHINV");
//        else if("Email".equals(cboSapXep.getSelectedItem().toString()))
//        hienThiDSSapXep("EMAILNV");
//        else if("Chức vụ".equals(cboSapXep.getSelectedItem().toString()))
//        hienThiDSSapXep("TENCV");
//        else if(cboSapXep.getSelectedIndex()==0)
//        hienThiDS();
    }//GEN-LAST:event_cboSapXepActionPerformed
    public int getSelectedRowIndex() {
        return tbTaiKhoan.getSelectedRow();
    }
    
    private boolean showMessage(String message) {
        Message obj = new Message(Main.getFrames()[0], true);
        obj.showMessage(message);
        return obj.isOk();
    }
    
    private void btnXoaTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTKActionPerformed
        int selectedRow  = tbTaiKhoan.getSelectedRow();
        if(selectedRow != -1)
        {
            DefaultTableModel model = (DefaultTableModel) tbTaiKhoan.getModel();
            String maNV = model.getValueAt(selectedRow, 0).toString();
            String tenHT = model.getValueAt(selectedRow, 1).toString();
            String tenDN = model.getValueAt(selectedRow, 2).toString();
            String matKhau = model.getValueAt(selectedRow, 3).toString();
            String tenNV = model.getValueAt(selectedRow, 4).toString();
            String email = model.getValueAt(selectedRow, 5).toString();
            String phanQuyen = model.getValueAt(selectedRow, 6).toString();

            Form_XoaTaiKhoan frm = new Form_XoaTaiKhoan(this,maNV,tenHT,tenDN,matKhau,tenNV,email,phanQuyen);

            JDialog dialog = new JDialog((JFrame)null, "Hủy nhà cung cấp", true);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.getContentPane().add(frm);
            dialog.pack();
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        }
        else
        {
            boolean kq = showMessage("Vui lòng chọn dữ liệu muốn xóa");
        }
    }//GEN-LAST:event_btnXoaTKActionPerformed

    private void btnCapNhatTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatTKActionPerformed
        int selectedRow  = tbTaiKhoan.getSelectedRow();
        if(selectedRow != -1)
        {
            DefaultTableModel model = (DefaultTableModel) tbTaiKhoan.getModel();
            String maNV = model.getValueAt(selectedRow, 0).toString();
            String tenHT = model.getValueAt(selectedRow, 1).toString();
            String tenDN = model.getValueAt(selectedRow, 2).toString();
            String matKhau = model.getValueAt(selectedRow, 3).toString();
            String tenNV = model.getValueAt(selectedRow, 4).toString();
            String email = model.getValueAt(selectedRow, 5).toString();
            String phanQuyen = model.getValueAt(selectedRow, 6).toString();

            Form_SuaTaiKhoan frm = new Form_SuaTaiKhoan(this,maNV,tenHT,tenDN,matKhau,tenNV,email,phanQuyen);

            JDialog dialog = new JDialog((JFrame)null, "Sửa thông tin nhân viên", true);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.getContentPane().add(frm);
            dialog.pack();
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        }
        else
        {
            boolean kq = showMessage("Vui lòng chọn dữ liệu muốn sửa");
        }
    }//GEN-LAST:event_btnCapNhatTKActionPerformed

    private void btnThemTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemTKActionPerformed
        Form_ThemTaiKhoan frm = new Form_ThemTaiKhoan(this,main);

        JDialog dialog = new JDialog((JFrame)null, "Thêm tài khoản", true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.getContentPane().add(frm);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnThemTKActionPerformed
    public void hienThiDS() {
        ArrayList<TaiKhoanDTO> ds = TaiKhoanDAO.layDS();
        DefaultTableModel model = (DefaultTableModel) this.tbTaiKhoan.getModel();
        for (TaiKhoanDTO tk : ds) {
            Object[] rowData = {tk.getMaNV(), tk.getTenHT(), tk.getTenDN(),tk.getMatKhau(), tk.getTenNV(), tk.getEmail(), tk.getPhanQuyen()};
            model.addRow(rowData);
        }
        // Đặt trình vẽ cột cho bảng
        tbTaiKhoan.setDefaultRenderer(Object.class, new ImageRenderer());
    }
    public void capNhatDuLieuBang(ArrayList<TaiKhoanDTO> ds) {
        DefaultTableModel model = (DefaultTableModel) tbTaiKhoan.getModel();
        model.setRowCount(0);
        for (TaiKhoanDTO tk : ds) {
            Object[] rowData = {tk.getMaNV(), tk.getTenHT(), tk.getTenDN(),tk.getMatKhau(), tk.getTenNV(), tk.getEmail(), tk.getPhanQuyen()};
            model.addRow(rowData);
        }
        tbTaiKhoan.setDefaultRenderer(Object.class, new ImageRenderer());
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.component.Button btnCapNhatTK;
    private com.raven.component.Button btnSapXep;
    private com.raven.component.Button btnThemTK;
    private com.raven.component.Button btnTraCuu;
    private com.raven.component.Button btnXoaTK;
    private combo_suggestion.ComboBoxSuggestion cboSapXep;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.raven.component.Table tbTaiKhoan;
    private com.raven.component.TextField txtTraCuu;
    // End of variables declaration//GEN-END:variables
}