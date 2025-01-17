/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form;

import SQLServerProvider.SQLServerProvider;
import com.DAO.ChiTietKhuyenMaiDAO;
import com.DAO.KhuyenMaiDAO;
import com.DTO.ChiTietKhuyenMaiDTO;
import com.DTO.KhuyenMaiDTO;
import com.DTO.SachDTO;
import com.java.loadKhuyenMai;
import com.java.loadSach;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER NITRO5
 */
public class Form_ThemSachKhuyenMai extends javax.swing.JPanel {

    private Main main;
    SQLServerProvider conn = new SQLServerProvider();
    /**
     * Creates new form Form_ThemSachKhuyenMai
     */
    public Form_ThemSachKhuyenMai(Main main) {
        this.main = main;
        initComponents();
        conn.open();
        loadCboSach();
        loadCboMaKM();
        tblKhuyenMai.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                displaySelectedRow();
            }
        }});
        loadtblKhachHang();
        conn.close();
    }
    public void displaySelectedRow() {
        int selectedRow = tblKhuyenMai.getSelectedRow();
        if (selectedRow != -1) {
            // Lấy giá trị từ các cột của dòng được chọn
            int id = Integer.parseInt(tblKhuyenMai.getValueAt(selectedRow, 0).toString());
            String maSach = (String) tblKhuyenMai.getValueAt(selectedRow, 1);
            String maKM = (String) tblKhuyenMai.getValueAt(selectedRow, 2);
            double khuyenMai = Double.parseDouble(tblKhuyenMai.getValueAt(selectedRow, 3).toString());
            
            cboMaKM.setSelectedItem(maKM);
            cboMaSach.setSelectedItem(maSach);
            txtId.setText(String.valueOf(id));
            txtGiamGia.setText(String.valueOf(khuyenMai));
        }
    }
    public void loadCboSach()
    {
        loadSach load = new loadSach();
        List<SachDTO> list = load.getData();
        cboMaSach.removeAllItems();
        
        List<String> maSachList = new ArrayList<>();
        for (SachDTO s : list) {
            maSachList.add(s.getMaSach());
        }
        
        maSachList.forEach(o -> {
            cboMaSach.addItem(o);
        });
    }
    public void loadCboMaKM()
    {
        loadKhuyenMai load = new loadKhuyenMai();
        List<KhuyenMaiDTO> list = load.getData();
        cboMaKM.removeAllItems();
        
        List<String> maKMList = new ArrayList<>();
        for (KhuyenMaiDTO s : list) {
            maKMList.add(s.getMaKM());
        }
        
        maKMList.forEach(o -> {
            cboMaKM.addItem(o);
        });
    }
    public void loadtblKhachHang()
    {
        conn.open();
        String sql = "Select ID, MASACH, SACHKHUYENMAI.MAKM, GIAMGIA FROM SACHKHUYENMAI, KHUYENMAI WHERE SACHKHUYENMAI.MAKM = KHUYENMAI.MAKM";
        ResultSet rs = conn.executeQuery(sql);
        DefaultTableModel model = (DefaultTableModel) this.tblKhuyenMai.getModel();
        model.setRowCount(0);
        try {
            while(rs.next()) {
                int id = rs.getInt("ID");
                String maSach = String.valueOf(rs.getString("MASACH"));
                String maKM = String.valueOf(rs.getString("MAKM"));
                double khuyenMai = Double.parseDouble(rs.getString("GIAMGIA"));
                Object[] rowData = {id,maSach,maKM,khuyenMai};
                    model.addRow(rowData);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
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

        panelShadow2 = new com.raven.swing.PanelShadow();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtGiamGia = new com.raven.component.TextField();
        btnThemKM = new com.raven.component.Button();
        btnXoaKM = new com.raven.component.Button();
        jLabel12 = new javax.swing.JLabel();
        txtTenSach = new com.raven.component.TextField();
        cboMaSach = new combo_suggestion.ComboBoxSuggestion();
        cboMaKM = new combo_suggestion.ComboBoxSuggestion();
        jLabel11 = new javax.swing.JLabel();
        txtTenKM = new com.raven.component.TextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtId = new com.raven.component.TextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhuyenMai = new com.raven.component.Table();

        setOpaque(false);

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(140, 110, 207));
        jLabel7.setText("Thông tin khuyến mãi");
        jLabel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Mã khuyến mãi");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Tên khuyến mãi");

        txtGiamGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiamGiaActionPerformed(evt);
            }
        });

        btnThemKM.setBackground(new java.awt.Color(76, 175, 80));
        btnThemKM.setForeground(new java.awt.Color(255, 255, 255));
        btnThemKM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/addWhite.png"))); // NOI18N
        btnThemKM.setText("Áp dụng KM");
        btnThemKM.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemKM.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnThemKM.setIconTextGap(15);
        btnThemKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKMActionPerformed(evt);
            }
        });

        btnXoaKM.setBackground(new java.awt.Color(244, 67, 54));
        btnXoaKM.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaKM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/cancel.png"))); // NOI18N
        btnXoaKM.setText("Xóa KM");
        btnXoaKM.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoaKM.setIconTextGap(15);
        btnXoaKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaKMActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Mã sách");

        txtTenSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenSachActionPerformed(evt);
            }
        });

        cboMaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMaSachActionPerformed(evt);
            }
        });

        cboMaKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMaKMActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Tên sách");

        txtTenKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKMActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Giảm giá");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("ID");

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelShadow2Layout = new javax.swing.GroupLayout(panelShadow2);
        panelShadow2.setLayout(panelShadow2Layout);
        panelShadow2Layout.setHorizontalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow2Layout.createSequentialGroup()
                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelShadow2Layout.createSequentialGroup()
                        .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelShadow2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenKM, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelShadow2Layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(btnThemKM, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(41, 41, 41)
                        .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelShadow2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(cboMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelShadow2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnXoaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(44, 44, 44)
                        .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelShadow2Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(29, 29, 29)
                                .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelShadow2Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(71, 71, 71)
                                .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelShadow2Layout.setVerticalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow2Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(7, 7, 7)
                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(cboMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(txtTenKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXoaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemKM, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        tblKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Mã sách", "Mã khuyến mãi", "Giảm giá"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblKhuyenMai.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tblKhuyenMaiPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhuyenMai);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelShadow2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1041, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtGiamGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiamGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiamGiaActionPerformed

    private void btnThemKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKMActionPerformed

        try {
                String maKM = (String) cboMaKM.getSelectedItem();
                String maSach = (String) cboMaSach.getSelectedItem();
                ChiTietKhuyenMaiDTO kh = new ChiTietKhuyenMaiDTO();
                kh.setId(Integer.parseInt(txtId.getText()));
                kh.setMaKM(maKM);
                kh.setMaSach(maSach);
                boolean kq = ChiTietKhuyenMaiDAO.themKhuyenMai(kh);
                if(kq)
                {
                    JOptionPane.showMessageDialog(this, "Áp dụng khuyến mãi thành công");
                    loadtblKhachHang();
                }
                else
                    JOptionPane.showMessageDialog(this, "Khuyến mãi đã tồn tại");
                
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid date format. Please enter the date in yyyy-MM-dd format.");
        }
    }//GEN-LAST:event_btnThemKMActionPerformed

    private void btnXoaKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaKMActionPerformed

        try {
            boolean kq = ChiTietKhuyenMaiDAO.xoaKhuyenMai(Integer.parseInt(txtId.getText()));
                if(kq)
                {
                    JOptionPane.showMessageDialog(this, "Xóa khuyến mãi thành công");
                    loadtblKhachHang();
                }
                else
                    JOptionPane.showMessageDialog(this, "Khuyến mãi đang được sử dụng");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Khóa chính đang được sử dụng.");
        }
    }//GEN-LAST:event_btnXoaKMActionPerformed

    private void txtTenSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenSachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenSachActionPerformed

    private void cboMaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMaSachActionPerformed
        // TODO add your handling code here:
        conn.open();
        String sach = (String) cboMaSach.getSelectedItem();
        String sql = "Select TENSACH FROM SACH WHERE MASACH = '"+sach+"'";
        ResultSet rs = conn.executeQuery(sql);
        try {
            while(rs.next()) {
                txtTenSach.setText(rs.getString("TENSACH"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        conn.close();
    }//GEN-LAST:event_cboMaSachActionPerformed

    private void cboMaKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMaKMActionPerformed
        // TODO add your handling code here:
        conn.open();
        String km = (String) cboMaKM.getSelectedItem();
        String sql = "Select TENKM FROM KHUYENMAI WHERE MAKM = '"+km+"'";
        ResultSet rs = conn.executeQuery(sql);
        try {
            while(rs.next()) {
                txtTenKM.setText(rs.getString("TENKM"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        conn.close();
    }//GEN-LAST:event_cboMaKMActionPerformed

    private void txtTenKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKMActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void tblKhuyenMaiPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblKhuyenMaiPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tblKhuyenMaiPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.component.Button btnThemKM;
    private com.raven.component.Button btnXoaKM;
    private combo_suggestion.ComboBoxSuggestion cboMaKM;
    private combo_suggestion.ComboBoxSuggestion cboMaSach;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.PanelShadow panelShadow2;
    private com.raven.component.Table tblKhuyenMai;
    private com.raven.component.TextField txtGiamGia;
    private com.raven.component.TextField txtId;
    private com.raven.component.TextField txtTenKM;
    private com.raven.component.TextField txtTenSach;
    // End of variables declaration//GEN-END:variables
}
