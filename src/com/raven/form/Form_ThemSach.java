/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form;

import SQLServerProvider.SQLServerProvider;
import com.DAO.SachDAO;
import com.DTO.NhaXuatBanDTO;
import java.sql.ResultSet;
import com.DTO.SachDTO;
import com.DTO.TacGiaDTO;
import com.DTO.TheLoaiDTO;
import java.sql.SQLException;
import com.java.loadNXB;
import com.java.loadTG;
import com.java.loaiTL;
import com.raven.component.Table;
import java.awt.Image;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javaswingdev.message.MessageDialog;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class Form_ThemSach extends javax.swing.JPanel {
    String duongDanAnh = "src\\com\\raven\\icon\\Book.png";
    private Form_QuanLySach formQuanLySach;
    private Main main;
    SQLServerProvider conn = new SQLServerProvider();
    /**
     * Creates new form Form_ThemSach
     */
    public Form_ThemSach(Form_QuanLySach formQuanLySach,Main main) {
        this.formQuanLySach = formQuanLySach;
        this.main = main;
        conn.open();
        initComponents();
        loadCbo();
        txtMaSach.setText("S"+(khoaChinhTuDong()+1));
        conn.close();
    }

    private void loadCbo()
    {
        loadCboNXB();
        loadCboTG();
        loadCboTL();
    }
    private void loadCboNXB()
    {  
        loadNXB load = new loadNXB();
        List<NhaXuatBanDTO> list = load.getData();
        cboNXB.removeAllItems();
        list.forEach(o -> {
            cboNXB.addItem(o);
        });
    }
    
    private void loadCboTG()
    {  
        loadTG load = new loadTG();
        List<TacGiaDTO> list = load.getData();
        cboTacGia.removeAllItems();
        list.forEach(o -> {
            cboTacGia.addItem(o);
        });
    }
    
    private void loadCboTL()
    {
        loaiTL load = new loaiTL();
        List<TheLoaiDTO> list = load.getData();
        cboTheLoai.removeAllItems();
        list.forEach(o -> {
            cboTheLoai.addItem(o);
        });
    }
    
    public int khoaChinhTuDong()
    {
        int count = 0;
        try {
            String sql = "SELECT COUNT(*) as count FROM SACH";
            ResultSet rs = conn.executeQuery(sql);
            while(rs.next())
                count = rs.getInt("count");
        } catch (Exception e) {
        }
        return count;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        passwordField1 = new com.raven.component.PasswordField();
        button1 = new com.raven.component.Button();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        btnThemNXB = new com.raven.component.Button();
        btnHuy = new com.raven.component.Button();
        btnThemSach = new com.raven.component.Button();
        btnThemTG = new com.raven.component.Button();
        btnThemTL = new com.raven.component.Button();
        txtMaSach = new textfield.TextField();
        txtTenSach = new textfield.TextField();
        cboNXB = new combobox.Combobox<>();
        txtGiaBan = new textfield.TextField();
        txtSoLuong = new textfield.TextField();
        cboTacGia = new combobox.Combobox<>();
        cboTheLoai = new combobox.Combobox<>();
        txtNgayXB = new textfield.TextField();
        lblAnh = new javax.swing.JLabel();
        btnThemAnh = new com.raven.component.Button();

        passwordField1.setText("passwordField1");

        button1.setText("button1");

        jScrollPane2.setViewportView(jTextPane2);

        setBackground(new java.awt.Color(255, 255, 255));
        setRequestFocusEnabled(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        jLabel2.setText("THÊM SÁCH MỚI");

        btnThemNXB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/add.png"))); // NOI18N
        btnThemNXB.setShadowColor(new java.awt.Color(102, 102, 255));

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

        btnThemSach.setBackground(new java.awt.Color(76, 175, 80));
        btnThemSach.setForeground(new java.awt.Color(255, 255, 255));
        btnThemSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/addWhite.png"))); // NOI18N
        btnThemSach.setText("Thêm sách");
        btnThemSach.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemSach.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnThemSach.setIconTextGap(15);
        btnThemSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSachActionPerformed(evt);
            }
        });

        btnThemTG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/add.png"))); // NOI18N
        btnThemTG.setShadowColor(new java.awt.Color(102, 102, 255));

        btnThemTL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/add.png"))); // NOI18N
        btnThemTL.setShadowColor(new java.awt.Color(102, 102, 255));

        txtMaSach.setEnabled(false);
        txtMaSach.setLabelText("Nhập mã sách");

        txtTenSach.setLabelText("Nhập tên sách");

        cboNXB.setLabeText("Chọn nhà xuất bản");

        txtGiaBan.setLabelText("Nhập giá bán");

        txtSoLuong.setText("0");
        txtSoLuong.setEnabled(false);
        txtSoLuong.setLabelText("Nhập số lượng");

        cboTacGia.setLabeText("Chọn tác giả");

        cboTheLoai.setLabeText("Chọn thể loại");

        txtNgayXB.setLabelText("Nhập ngày xuất bản");

        lblAnh.setBackground(new java.awt.Color(255, 255, 255));
        lblAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/Book.png"))); // NOI18N
        lblAnh.setToolTipText("");
        lblAnh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));

        btnThemAnh.setBackground(new java.awt.Color(102, 153, 255));
        btnThemAnh.setForeground(new java.awt.Color(255, 255, 255));
        btnThemAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/addWhite.png"))); // NOI18N
        btnThemAnh.setText("Thêm ảnh");
        btnThemAnh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemAnh.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnThemAnh.setIconTextGap(15);
        btnThemAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemAnhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(btnThemAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnThemSach, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(92, 92, 92)
                                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtMaSach, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                    .addComponent(txtTenSach, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                    .addComponent(txtGiaBan, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                    .addComponent(txtNgayXB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cboTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnThemNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cboNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnThemTL, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(cboTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnThemTG, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(jLabel2)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThemAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cboTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnThemNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cboNXB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNgayXB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnThemTL, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnThemTG, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cboTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThemSach, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        jLabel2.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSachActionPerformed

        if (txtMaSach.getText().isEmpty() || txtTenSach.getText().isEmpty() || txtGiaBan.getText().isEmpty() || txtSoLuong.getText().isEmpty() || txtNgayXB.getText().isEmpty() || cboNXB.getSelectedItem() == null || cboTacGia.getSelectedItem() == null || cboTheLoai.getSelectedItem() == null) {
        JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin sách.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        return;
        }

        try {
            Double.parseDouble(txtGiaBan.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Giá bán phải là một số.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            Integer.parseInt(txtSoLuong.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số lượng tồn phải là một số nguyên.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date ngayXuatBan = null;
        try {
            ngayXuatBan = dateFormat.parse(txtNgayXB.getText());
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Định dạng ngày không hợp lệ. Vui lòng nhập theo định dạng dd/MM/yyyy.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Tiến hành thêm sách vào cơ sở dữ liệu với các thông tin đã kiểm tra
        SachDTO s = new SachDTO();
        s.setMaSach(txtMaSach.getText());
        s.setTenSach(txtTenSach.getText());
        NhaXuatBanDTO nxb = (NhaXuatBanDTO) cboNXB.getSelectedItem();
        s.setMaNXB(nxb.getMaNXB());
        s.setGiaBan(Double.parseDouble(txtGiaBan.getText().toString()));
        TacGiaDTO tg = (TacGiaDTO) cboTacGia.getSelectedItem();
        s.setMaTG(tg.getMaTG());
        TheLoaiDTO tl = (TheLoaiDTO) cboTheLoai.getSelectedItem();
        s.setMaTL(tl.getMaTL());
        s.setSoLuongTon(Integer.parseInt(txtSoLuong.getText()));
        s.setNgayXuatBan(ngayXuatBan);
        s.setTrangThai(1);
        s.setAnhSach(duongDanAnh);
        boolean kq = SachDAO.themSach(s);
        if(kq)
        {
            JOptionPane.showMessageDialog(this, "Sách đã được thêm thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            ArrayList<SachDTO> ds = SachDAO.layDS();
            formQuanLySach.capNhatDuLieuBang(ds);
//            SwingUtilities.getWindowAncestor(this).dispose();
        }
        else
            JOptionPane.showMessageDialog(this, "Thêm sách thất bại.", "Thông báo", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_btnThemSachActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed

        MessageDialog obj = new MessageDialog(main);
       
        obj.showMessage("Bạn chắc chắn muốn thoát ?", "Tất cả dữ liệu đã nhập sẽ mất");
        if (obj.getMessageType() == MessageDialog.MessageType.OK) {
            SwingUtilities.getWindowAncestor(this).dispose();
        } else {
            System.out.println("User clicked Cancel");
        }

    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnThemAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemAnhActionPerformed
        try {
            JFileChooser f = new JFileChooser("D:\\QuanLyNhaSach\\src\\img");
            f.setDialogTitle("Mở File");
            f.showOpenDialog(null);
            File ftenAnh = f.getSelectedFile();
            duongDanAnh = ftenAnh.getAbsolutePath();
            if(duongDanAnh != null)
            {
                lblAnh.setIcon(ResizeImage(String.valueOf(duongDanAnh)));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chưa chọn ảnh");
        }
        
    }//GEN-LAST:event_btnThemAnhActionPerformed

    private Icon ResizeImage(String imagePath) {
        ImageIcon myImage = new ImageIcon(imagePath);
        Image img = myImage.getImage();
        Image newImg = img.getScaledInstance(lblAnh.getWidth(), lblAnh.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.component.Button btnHuy;
    private com.raven.component.Button btnThemAnh;
    private com.raven.component.Button btnThemNXB;
    private com.raven.component.Button btnThemSach;
    private com.raven.component.Button btnThemTG;
    private com.raven.component.Button btnThemTL;
    private com.raven.component.Button button1;
    private combobox.Combobox<Object> cboNXB;
    private combobox.Combobox<Object> cboTacGia;
    private combobox.Combobox<Object> cboTheLoai;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JLabel lblAnh;
    private com.raven.component.PasswordField passwordField1;
    private textfield.TextField txtGiaBan;
    private textfield.TextField txtMaSach;
    private textfield.TextField txtNgayXB;
    private textfield.TextField txtSoLuong;
    private textfield.TextField txtTenSach;
    // End of variables declaration//GEN-END:variables

    
}
