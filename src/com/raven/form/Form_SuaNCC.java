/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form;

import com.DAO.NhaCungCapDAO;
import com.DTO.NhaCungCapDTO;
import java.util.ArrayList;
import javaswingdev.message.MessageDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author ACER
 */
public class Form_SuaNCC extends javax.swing.JPanel {
    private Form_NhaCungCap formNhaCungCap;
    private Main main;
    /**
     * Creates new form Form_SuaNCC
     * @param formNhaCungCap
     */
    public Form_SuaNCC(Form_NhaCungCap formNhaCungCap,Main main, String maNCC, String tenNCC, String diaChiNCC, String soDT, String emailNCC, String trangThai) {
        initComponents();
        this.formNhaCungCap = formNhaCungCap;
        this.main = main;
        txtDiaChi.setText(diaChiNCC);
        txtEmail.setText(emailNCC);
        txtMaNCC.setText(maNCC);
        txtSDT.setText(soDT);
        txtTenNCC.setText(tenNCC);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtMaNCC = new textfield.TextField();
        txtSDT = new textfield.TextField();
        txtTenNCC = new textfield.TextField();
        txtDiaChi = new textfield.TextField();
        txtEmail = new textfield.TextField();
        btnCapNhat = new com.raven.component.Button();
        btnHuy = new com.raven.component.Button();

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        jLabel2.setText("SỬA NHÀ CUNG CẤP");

        txtMaNCC.setEnabled(false);
        txtMaNCC.setLabelText("Mã nhà cung cấp");

        txtSDT.setLabelText("Số điện thoại");

        txtTenNCC.setLabelText("Tên nhà cung cấp");

        txtDiaChi.setLabelText("Địa chỉ");

        txtEmail.setLabelText("Email");

        btnCapNhat.setBackground(new java.awt.Color(0, 140, 186));
        btnCapNhat.setForeground(new java.awt.Color(255, 255, 255));
        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/PenToSquare.png"))); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCapNhat.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCapNhat.setIconTextGap(15);
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnHuy.setBackground(new java.awt.Color(244, 67, 54));
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/cancel.png"))); // NOI18N
        btnHuy.setText("Hủy");
        btnHuy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHuy.setIconTextGap(15);
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(250, 250, 250))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTenNCC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(txtMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(170, 170, 170))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(16, 16, 16)
                .addComponent(txtTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        int selectedRow = formNhaCungCap.getSelectedRowIndex();
        if (selectedRow != -1) {
            if (txtTenNCC.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền tên nhà cung cấp.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
            }

            if (txtDiaChi.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng điền địa chỉ nhà cung cấp.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            String soDT = txtSDT.getText();
            if (!soDT.matches("\\d{10}")) { 
                JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ. Vui lòng nhập số điện thoại có 10 chữ số.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }

            NhaCungCapDTO ncc = new NhaCungCapDTO();
            ncc.setMaNCC(txtMaNCC.getText());
            ncc.setTenNCC(txtTenNCC.getText());
            ncc.setDiaChiNCC(txtDiaChi.getText());
            ncc.setEmailNCC(txtEmail.getText());
            ncc.setSoDT(soDT);
            ncc.setTrangThai("Đang giao dịch");
            ncc.setIsDelete(1);

            boolean kq = NhaCungCapDAO.capNhatNCC(ncc);
            if(kq)
            {
                JOptionPane.showMessageDialog(this, "Nhà cung cấp đã được cập nhật thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                ArrayList<NhaCungCapDTO> ds = NhaCungCapDAO.layDS();
                formNhaCungCap.updateTableData(ds);
                SwingUtilities.getWindowAncestor(this).dispose();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng muốn cập nhật.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        MessageDialog obj = new MessageDialog(main);
        
        obj.showMessage("Bạn chắc chắn muốn thoát ?", "Tất cả dữ liệu thay đổi sẽ mất");
        if (obj.getMessageType() == MessageDialog.MessageType.OK) {
            SwingUtilities.getWindowAncestor(this).dispose();
        } else {
            System.out.println("User clicked Cancel");
        }
    }//GEN-LAST:event_btnHuyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.component.Button btnCapNhat;
    private com.raven.component.Button btnHuy;
    private javax.swing.JLabel jLabel2;
    private textfield.TextField txtDiaChi;
    private textfield.TextField txtEmail;
    private textfield.TextField txtMaNCC;
    private textfield.TextField txtSDT;
    private textfield.TextField txtTenNCC;
    // End of variables declaration//GEN-END:variables
}
