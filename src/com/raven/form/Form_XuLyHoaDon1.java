/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form;

import SQLServerProvider.SQLServerProvider;
import com.DAO.NhaCungCapDAO;
import com.DAO.SachDAO;
import com.DAO.XuLyHoaDonDAO;
import com.DTO.ChiTietHoaDonDTO;
import com.DTO.HoaDonDTO;
import com.DTO.KhachHangDTO;
import com.DTO.NhaCungCapDTO;
import com.DTO.NhanVienDTO;
import com.DTO.SachDTO;
import com.java.loadNV;
import com.java.loadSach;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ACER NITRO5
 */
public class Form_XuLyHoaDon1 extends javax.swing.JPanel {
    private Main main;
    SQLServerProvider conn = new SQLServerProvider();
    private DefaultTableModel model;
    private double TongTien = 0;
    String maHD;
    /**
     * Creates new form Form_XuLyHoaDon1
     */
    public Form_XuLyHoaDon1(Main main) {
        this.main = main;
        initComponents();
        conn.open();
        loadCbo();
        layNgayHienTai();
        txtSoLuong.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                updateThanhTien();
            }

            public void removeUpdate(DocumentEvent e) {
                updateThanhTien();
            }

            public void changedUpdate(DocumentEvent e) {
                updateThanhTien();
            }
        });
        conn.close();
    }
    
    public boolean KTraTonKho(int soLuong, String maSach)
    {
        conn.open();
        String sql = "Select SOLUONGTON FROM SACH WHERE MASACH ='"+maSach+"'";
        int a = 0;
        int b = 0;
        ResultSet rs = conn.executeQuery(sql);
        try {
            while(rs.next()) {
                a = Integer.parseInt(rs.getString("SOLUONGTON"));
            }
            b = a - soLuong;
            if(b >= 0)
            {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        conn.close();
        return false;
    }
    
    private void updateThanhTien() {
        String input = txtSoLuong.getText();
        if (isNumeric(input)) {
            int soLuong = Integer.parseInt(txtSoLuong.getText());
            int donGia = Integer.parseInt(txtDonGia.getText());
            int thanhTien = soLuong * donGia;
            txtThanhTien.setText(String.valueOf(thanhTien));
        } else {
            txtThanhTien.setText(""); // Clear the thanhTien field if input is not valid
            JOptionPane.showMessageDialog(this, "Dữ liệu nhập không đúng định dạng!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public int HamKtra( String table , String colums)
        {
        conn.open();
        List<Integer> a1 = new ArrayList<>();
        int tong = 0;
        String sql = "Select * FROM "+table+"";
        String c1;
        String c2;
        ResultSet rs = conn.executeQuery(sql);
        try {
            while(rs.next()) {
                c2 = rs.getString(""+colums+"");
                c1 = c2.substring(2);
                a1.add(Integer.parseInt(c1));

            }
            tong = Collections.max(a1) + 1;
            return tong;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        conn.close();
        
        return 0;
       }

    public void layNgayHienTai()
    {
        Date dt = new Date(); // Khởi tạo Date với thời gian hiện tại
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng ngày giờ
        String now = sdf.format(dt); // Chuyển đổi Date sang chuỗi
        txtNgayLap.setText(now); // Đặt chuỗi vào JTextField
    }
    public double kTraKhuyenMai()
    {
        
        conn.open();
        String sach = (String) cboSach.getSelectedItem();
        String sql = "select GIAMGIA from KHUYENMAI,SACHKHUYENMAI where KHUYENMAI.MAKM = SACHKHUYENMAI.MAKM and GETDATE() between NGAYBD and NGAYKT and SACHKHUYENMAI.MASACH = '"+sach+"'";
        ResultSet rs = conn.executeQuery(sql);
        try {
            while(rs.next()) {
                Double km = Double.parseDouble(rs.getString("GIAMGIA"));
                return km;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
        conn.close();
        return 0;
    }
    public String layNXB()
    {
        conn.open();
        String sach = (String) cboSach.getSelectedItem();
        String sql = "Select TENSACH, TENNXB FROM SACH, NHAXUATBAN WHERE SACH.MANXB = NHAXUATBAN.MANXB AND MASACH = '"+sach+"'";
        ResultSet rs = conn.executeQuery(sql);
        try {
            while(rs.next()) {
                String tenNXB = rs.getString("TENNXB");
                return tenNXB;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        conn.close();
        return "a";
    }
    public void loadCboNV()
    {  
        
        loadNV load = new loadNV();
        List<NhanVienDTO> list = load.getData();
        cboNhanVien.removeAllItems();
        
        List<String> manvList = new ArrayList<>();
        for (NhanVienDTO nv : list) {
            manvList.add(nv.getMaNV());
        }
        manvList.forEach(o -> {
            cboNhanVien.addItem(o);
        });
    }
    
    public void loadCboSach()
    {
        loadSach load = new loadSach();
        List<SachDTO> list = load.getData();
        cboSach.removeAllItems();
        
        List<String> maSachList = new ArrayList<>();
        for (SachDTO s : list) {
            maSachList.add(s.getMaSach());
        }
        
        maSachList.forEach(o -> {
            cboSach.addItem(o);
        });
    }
    public void loadCbo()
    {
        loadCboNV();
        loadCboSach();
    }
    public boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
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
        txtTenNV = new com.raven.component.TextField();
        jLabel9 = new javax.swing.JLabel();
        cboNhanVien = new combo_suggestion.ComboBoxSuggestion();
        jLabel10 = new javax.swing.JLabel();
        txtNgayLap = new com.raven.component.TextField();
        jLabel11 = new javax.swing.JLabel();
        txtDiaChi = new com.raven.component.TextField();
        jLabel17 = new javax.swing.JLabel();
        txtTenKH = new com.raven.component.TextField();
        txtSoDT = new com.raven.component.TextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtEmail = new com.raven.component.TextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGioHang = new com.raven.component.Table();
        panelShadow3 = new com.raven.swing.PanelShadow();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cboSach = new combo_suggestion.ComboBoxSuggestion();
        jLabel15 = new javax.swing.JLabel();
        txtDonGia = new com.raven.component.TextField();
        jLabel16 = new javax.swing.JLabel();
        btnThem = new com.raven.component.Button();
        txtTenSach = new com.raven.component.TextField();
        txtSoLuong = new com.raven.component.TextField();
        jLabel20 = new javax.swing.JLabel();
        txtThanhTien = new com.raven.component.TextField();
        jLabel22 = new javax.swing.JLabel();
        txtTacGia = new com.raven.component.TextField();
        jLabel23 = new javax.swing.JLabel();
        txtTheLoai = new com.raven.component.TextField();
        btnThemHoaDon = new com.raven.component.Button();
        btnIn = new com.raven.component.Button();
        btnHuy = new com.raven.component.Button();
        jLabel21 = new javax.swing.JLabel();
        txtTongTien = new com.raven.component.TextField();

        setOpaque(false);

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(140, 110, 207));
        jLabel7.setText("Thông tin hóa đơn");
        jLabel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Mã nhân viên");

        txtTenNV.setBackground(new java.awt.Color(235, 235, 235));
        txtTenNV.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Tên khách hàng");

        cboNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNhanVienActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Địa chỉ");

        txtNgayLap.setEnabled(false);
        txtNgayLap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayLapActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Ngày lập");

        txtDiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChiActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Tên nhân viên");

        txtTenKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKHActionPerformed(evt);
            }
        });

        txtSoDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoDTActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Số điện thoại");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Email");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelShadow2Layout = new javax.swing.GroupLayout(panelShadow2);
        panelShadow2.setLayout(panelShadow2Layout);
        panelShadow2Layout.setHorizontalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow2Layout.createSequentialGroup()
                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow2Layout.createSequentialGroup()
                        .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelShadow2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel11))
                                .addGap(20, 20, 20))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)))
                        .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cboNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                                .addComponent(txtTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSoDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(39, 39, 39)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        panelShadow2Layout.setVerticalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow2Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(14, 14, 14)
                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(cboNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow2Layout.createSequentialGroup()
                        .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelShadow2Layout.createSequentialGroup()
                                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 13, Short.MAX_VALUE))
                            .addGroup(panelShadow2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(txtSoDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelShadow2Layout.createSequentialGroup()
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sách", "Tên sách", "Thể loại", "Nhà Xuất Bản", "Tác Giả", "Đơn Giá", "Số lượng", "Khuyến mãi", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblGioHang);

        jLabel12.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(140, 110, 207));
        jLabel12.setText("Thông tin mặt hàng");
        jLabel12.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Mã sách");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Tên sách");

        cboSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSachActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Số lượng");

        txtDonGia.setBackground(new java.awt.Color(235, 235, 235));
        txtDonGia.setEnabled(false);
        txtDonGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDonGiaActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Đơn giá");

        btnThem.setBackground(new java.awt.Color(0, 140, 186));
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/edit_1.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnThem.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnThem.setIconTextGap(15);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        txtTenSach.setBackground(new java.awt.Color(235, 235, 235));
        txtTenSach.setEnabled(false);
        txtTenSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenSachActionPerformed(evt);
            }
        });

        txtSoLuong.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtSoLuongInputMethodTextChanged(evt);
            }
        });
        txtSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongActionPerformed(evt);
            }
        });
        txtSoLuong.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtSoLuongPropertyChange(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Thành tiền");

        txtThanhTien.setBackground(new java.awt.Color(235, 235, 235));
        txtThanhTien.setEnabled(false);
        txtThanhTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThanhTienActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Tác giả");

        txtTacGia.setBackground(new java.awt.Color(235, 235, 235));
        txtTacGia.setEnabled(false);
        txtTacGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTacGiaActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Thể loại");

        txtTheLoai.setBackground(new java.awt.Color(235, 235, 235));
        txtTheLoai.setEnabled(false);
        txtTheLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTheLoaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelShadow3Layout = new javax.swing.GroupLayout(panelShadow3);
        panelShadow3.setLayout(panelShadow3Layout);
        panelShadow3Layout.setHorizontalGroup(
            panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow3Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(854, Short.MAX_VALUE))
            .addGroup(panelShadow3Layout.createSequentialGroup()
                .addGroup(panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel13)
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15)))
                .addGroup(panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(cboSach, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelShadow3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addGroup(panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel14))
                .addGap(22, 22, 22)
                .addGroup(panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                    .addComponent(txtTenSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow3Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelShadow3Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(16, 16, 16))
        );
        panelShadow3Layout.setVerticalGroup(
            panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow3Layout.createSequentialGroup()
                .addGroup(panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGroup(panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelShadow3Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20)
                                    .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22)
                                    .addComponent(txtTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)))
                        .addGroup(panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23)
                            .addComponent(txtTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelShadow3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(cboSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        btnThemHoaDon.setBackground(new java.awt.Color(102, 204, 0));
        btnThemHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnThemHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/Tick Box.png"))); // NOI18N
        btnThemHoaDon.setText("Thêm hóa đơn");
        btnThemHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemHoaDon.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnThemHoaDon.setIconTextGap(15);
        btnThemHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemHoaDonActionPerformed(evt);
            }
        });

        btnIn.setBackground(new java.awt.Color(255, 128, 0));
        btnIn.setForeground(new java.awt.Color(255, 255, 255));
        btnIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/Tick Box.png"))); // NOI18N
        btnIn.setText("In hóa đơn");
        btnIn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnIn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnIn.setIconTextGap(15);
        btnIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInActionPerformed(evt);
            }
        });

        btnHuy.setBackground(new java.awt.Color(255, 51, 0));
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/Tick Box.png"))); // NOI18N
        btnHuy.setText("Hủy hóa đơn");
        btnHuy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHuy.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnHuy.setIconTextGap(15);
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Tổng tiền");

        txtTongTien.setBackground(new java.awt.Color(235, 235, 235));
        txtTongTien.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThemHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIn, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(jLabel21)
                .addGap(35, 35, 35)
                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(panelShadow3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(panelShadow2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelShadow2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelShadow3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNgayLapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayLapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayLapActionPerformed

    private void txtDonGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDonGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDonGiaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if(txtSoLuong.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Chưa nhập số lượng", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            String maSach = (String) cboSach.getSelectedItem();
            String tenSach = txtTenSach.getText();
            String theLoai = txtTheLoai.getText();
            String nhaXuatBan = layNXB();
            String tacGia = txtTacGia.getText();
            String donGia = txtDonGia.getText();
            String soLuong = txtSoLuong.getText();
            
            int soLuong1 = Integer.parseInt(soLuong);
                    
            String khuyenMai = String.valueOf(kTraKhuyenMai());
            double tong =  Double.parseDouble(txtThanhTien.getText()) - (Double.parseDouble(txtThanhTien.getText()) * Double.parseDouble(khuyenMai));
            TongTien = TongTien + tong;
            String thanhTien = String.valueOf(tong);
            if (soLuong.isEmpty()) {
                       JOptionPane.showMessageDialog(this,
                                "Vui lòng nhập số lượng",
                                "Lỗi",
                                JOptionPane.ERROR_MESSAGE);
            }
            else if(KTraTonKho(soLuong1, maSach) == false)
            {
                JOptionPane.showMessageDialog(this, "Số luọng tồn không đủ", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
            else {
                    tblGioHang.addRow(new Object[]{maSach, tenSach, theLoai, nhaXuatBan, tacGia, donGia, soLuong, khuyenMai, thanhTien});
                    txtSoLuong.setText("");
                    txtThanhTien.setText("");
                    txtTongTien.setText(String.valueOf(TongTien));
                 }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void cboNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNhanVienActionPerformed
        // TODO add your handling code here:
        conn.open();
        String nv = (String) cboNhanVien.getSelectedItem();
        String sql = "Select HOTENNV from NHANVIEN WHERE MANV = '"+nv+"'";
        ResultSet rs = conn.executeQuery(sql);
        try {
            while(rs.next()) {
                txtTenNV.setText(rs.getString("HOTENNV"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        conn.close();
        
    }//GEN-LAST:event_cboNhanVienActionPerformed

    private void txtDiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChiActionPerformed

    private void txtTenKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKHActionPerformed

    private void txtSoDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoDTActionPerformed

    private void txtTenSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenSachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenSachActionPerformed

    private void txtSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongActionPerformed
        // TODO add your handling code here:
         String input = txtSoLuong.getText();
                if (isNumeric(input)) {
                    int soLuong = Integer.parseInt(txtSoLuong.getText());
                    int donGia = Integer.parseInt(txtDonGia.getText());
                    int thanhTien = soLuong * donGia;
                    txtThanhTien.setText(String.valueOf(thanhTien));
                } else {
                    
                    JOptionPane.showMessageDialog(this, "Dữ liệu nhập không đúng định dạng!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                }
    }//GEN-LAST:event_txtSoLuongActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtThanhTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThanhTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtThanhTienActionPerformed

    private void btnThemHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemHoaDonActionPerformed
        // TODO add your handling code here:
        KhachHangDTO kh = new KhachHangDTO();
        int layMaKH = HamKtra("KHACHHANG", "MAKH");
        String maKH = "KH" + String.valueOf(layMaKH);
        kh.setMaKH(maKH);
        kh.setHoTenKH(txtTenKH.getText());
        kh.setDiaChi(txtDiaChi.getText());
        if(txtSoDT.getText() == null)
        {
            kh.setSoDT(0);
        }
        
        kh.setEmail(txtEmail.getText());
        boolean kq = XuLyHoaDonDAO.themKhachHang(kh);
        if(kq)
        {
            JOptionPane.showMessageDialog(this, "Thêm thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            //ArrayList<NhaCungCapDTO> ds = NhaCungCapDAO.layDS();
            //            SwingUtilities.getWindowAncestor(this).dispose();
        }
        else
            JOptionPane.showMessageDialog(this, "Thêm khách hàng thất bại", "Thông báo", JOptionPane.WARNING_MESSAGE);
        
        try
        {
            HoaDonDTO hd = new HoaDonDTO();
            int layMaHD = HamKtra("HOADON", "MAHD");
            maHD = "HD" + String.valueOf(layMaHD);
            String layMaNV = (String) cboNhanVien.getSelectedItem();
            hd.setMaHD(maHD);
            hd.setMaNV(layMaNV);
            hd.setMaKH(maKH);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = formatter.parse(txtNgayLap.getText());
            hd.setNgayLap(date);
            hd.setTrangthaiDH("Hoàn thành");
            double swap = Double.parseDouble(txtTongTien.getText());
            int doiInt = (int) swap;
            System.out.println(doiInt);
            hd.setThanhTien(doiInt);
            boolean kq1 = XuLyHoaDonDAO.themHoaDon(hd);
            for (int row = 0; row < tblGioHang.getRowCount(); row++) {
                ChiTietHoaDonDTO ct = new ChiTietHoaDonDTO();
                String maSach = (String) tblGioHang.getValueAt(row, 0);
                ct.setMaSach(maSach);
                ct.setMaHD(maHD);
                int giaBan = Integer.parseInt((String) tblGioHang.getValueAt(row, 5));
                ct.setGiaBan(giaBan);
                int soLuong = Integer.parseInt((String) tblGioHang.getValueAt(row, 6));
                ct.setSoLuong(soLuong);
                double tongTienDouble = Double.parseDouble((String) tblGioHang.getValueAt(row, 8));
                int tongTien = (int) tongTienDouble;
                ct.setTongTien(tongTien);
                boolean kq2 = XuLyHoaDonDAO.themChiTietHD(ct);
                boolean kq3 = SachDAO.capNhatTonKho(soLuong, maSach);
                System.out.println(tblGioHang.getValueAt(row, 0));
            }
            if(kq1)
            {
                JOptionPane.showMessageDialog(this, "Thêm hóa đơn thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(this, "Thêm hóa đơn thất bại", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
        
        catch(ParseException e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnThemHoaDonActionPerformed

    private void btnInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInActionPerformed
            
            try {
                // Tạo kết nối và PreparedStatement
                JasperReport rpt = JasperCompileManager.compileReport(getClass().getResourceAsStream("/Report/rptHoaDon.jrxml"));

                // Khởi tạo đối tượng SQLServerProvider
                SQLServerProvider conn = SQLServerProvider.getInstance();
                conn.open();

                Connection connection = conn.getConn();

                Map<String, Object> parameters = new HashMap<>();
                parameters.put("maHoaDon", maHD);
                parameters.put("tenNhaSach", "Nhà sách nhóm 6");
                parameters.put("diaChi", "Địa chỉ: 140 Lê Trọng Tấn");
                parameters.put("soDienThoai", "Liên hệ: 0999999999");
                parameters.put("hoaDon", "HÓA ĐƠN");
                parameters.put("soHoaDon", "Mã hóa đơn:");
                parameters.put("ngayLapHoaDon", "Ngày lập hóa đơn:");
                parameters.put("tenKhachHang", "Tên khách hàng:");
                parameters.put("tenNhanVienLap", "Tên nhân viên lập:");
                parameters.put("stt", "STT");
                parameters.put("tongCong", "Tổng cộng:");
                parameters.put("nguoiLap", "Người nhập:");
                parameters.put("maHoaDon", maHD);
                JasperPrint p = JasperFillManager.fillReport(rpt, parameters, connection);

                JasperViewer.viewReport(p, false);

            } catch (Exception  ex) {
                ex.printStackTrace();
            }
    }//GEN-LAST:event_btnInActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        txtTenKH.setText("");
        txtDiaChi.setText("");
        txtSoDT.setText("");
        txtEmail.setText("");
        txtSoLuong.setText("");
        txtThanhTien.setText("");
        txtTongTien.setText("");
        DefaultTableModel model = (DefaultTableModel) tblGioHang.getModel();
        model.setRowCount(0); // Xóa tất cả các dòng
        
    }//GEN-LAST:event_btnHuyActionPerformed

    private void cboSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSachActionPerformed
        // TODO add your handling code here:
        conn.open();
        String sach = (String) cboSach.getSelectedItem();
        String sql = "Select TENSACH, GIABAN, TENTG, TENTL from SACH, TACGIA, THELOAI WHERE SACH.MATG=TACGIA.MATG AND SACH.MATL=THELOAI.MATL AND MASACH = '"+sach+"'";
        ResultSet rs = conn.executeQuery(sql);
        try {
            while(rs.next()) {
                txtTenSach.setText(rs.getString("TENSACH"));
                txtDonGia.setText(String.valueOf(rs.getInt("GIABAN")));
                txtTacGia.setText(rs.getString("TENTG"));
                txtTheLoai.setText(rs.getString("TENTL"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        conn.close();
    }//GEN-LAST:event_cboSachActionPerformed

    private void txtTacGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTacGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTacGiaActionPerformed

    private void txtTheLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTheLoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTheLoaiActionPerformed

    private void txtSoLuongInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtSoLuongInputMethodTextChanged
        
    }//GEN-LAST:event_txtSoLuongInputMethodTextChanged

    private void txtSoLuongPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtSoLuongPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.component.Button btnHuy;
    private com.raven.component.Button btnIn;
    private com.raven.component.Button btnThem;
    private com.raven.component.Button btnThemHoaDon;
    private combo_suggestion.ComboBoxSuggestion cboNhanVien;
    private combo_suggestion.ComboBoxSuggestion cboSach;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.PanelShadow panelShadow2;
    private com.raven.swing.PanelShadow panelShadow3;
    private com.raven.component.Table tblGioHang;
    private com.raven.component.TextField txtDiaChi;
    private com.raven.component.TextField txtDonGia;
    private com.raven.component.TextField txtEmail;
    private com.raven.component.TextField txtNgayLap;
    private com.raven.component.TextField txtSoDT;
    private com.raven.component.TextField txtSoLuong;
    private com.raven.component.TextField txtTacGia;
    private com.raven.component.TextField txtTenKH;
    private com.raven.component.TextField txtTenNV;
    private com.raven.component.TextField txtTenSach;
    private com.raven.component.TextField txtThanhTien;
    private com.raven.component.TextField txtTheLoai;
    private com.raven.component.TextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
