package com.raven.form;

import SQLServerProvider.SQLServerProvider;
import com.raven.chart.ModelChart;
import com.raven.dialog.Message;
import com.raven.model.ModelCard;
import com.raven.model.ModelStudent;
import com.raven.model.Model_Card;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import com.raven.swing.noticeboard.ModelNoticeBoard;
import com.raven.swing.table.EventAction;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class Form_Home extends javax.swing.JPanel {

    String hoTen;
    SQLServerProvider conn = new SQLServerProvider();
    LocalDate currentDate = LocalDate.now();
    public Form_Home(String hoTen) {
        this.hoTen = hoTen;
        initComponents();
        setOpaque(false);
        initData();
        ImageIcon img = new ImageIcon(getClass().getResource("/img/background.png"));
        JPanel panel1 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
    };
    panel1.setOpaque(false); // Đảm bảo rằng panel1 không che phủ hình nền của JPanel chính
    add(panel1);
    panel1.setLayout(new FlowLayout()); // Đảm bảo các thành phần khác được thêm vào panel1 được hiển thị đúng cách
}


    private void initData() {

        initTableData();
        testData();
    }
    DecimalFormat decimalFormat = new DecimalFormat("#,##0 VND");
    public String doanhThuTrongThang()
    {
        conn.open();
        String tongTien;
        String thanhTienFormatted;
        int thang = currentDate.getMonthValue();
        int nam = currentDate.getYear();
        String sql = "select sum(THANHTIEN) AS TONG from HOADON where MONTH(NGAYLAP) = "+thang+" and YEAR(NGAYLAP) = "+nam+"";
        ResultSet rs = conn.executeQuery(sql);
        try {
            while(rs.next()) {
                tongTien = rs.getString("TONG");
                if(tongTien == null || tongTien.isEmpty())
                {
                    return "0" + "VND";
                }
                else
                {
                    double tongTienNumber = Double.parseDouble(tongTien);
                    thanhTienFormatted = decimalFormat.format(tongTienNumber);
                    return thanhTienFormatted;
                }
                    
                    
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        conn.close();
        return "0" + "VND";
    }
    
    public String doanhThuNVTrongThang()
    {
        conn.open();
        String tongTien;
        String thanhTienFormatted;
        int thang = currentDate.getMonthValue();
        int nam = currentDate.getYear();
        String sql = "SELECT SUM(THANHTIEN) AS TONG FROM HOADON, NHANVIEN WHERE HOADON.MANV = NHANVIEN.MANV AND MONTH(NGAYLAP) ="+thang+" AND YEAR(NGAYLAP) = "+nam+" AND HOTENNV = N'"+hoTen+"'";
        
        ResultSet rs = conn.executeQuery(sql);
        try {
            while(rs.next()) {
                tongTien = rs.getString("TONG");
                if(tongTien == null || tongTien.isEmpty())
                {
                    return "0" + "VND";
                }
                else
                {
                    double tongTienNumber = Double.parseDouble(tongTien);
                    thanhTienFormatted = decimalFormat.format(tongTienNumber);
                    return thanhTienFormatted;
                }
                    
                    
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        conn.close();
        return "0" + "VND";
    }
    public String SoLuongHDTrongThang()
    {
        conn.open();
        String tongTien;
        int thang = currentDate.getMonthValue();
        int nam = currentDate.getYear();
        String sql = "select count(*) AS SOLUONG from HOADON where MONTH(NGAYLAP) = " + thang + " and YEAR(NGAYLAP) = " + nam + "";
        
        ResultSet rs = conn.executeQuery(sql);
        try {
            while(rs.next()) {
                tongTien = rs.getString("SOLUONG");
                if(tongTien == null || tongTien.isEmpty())
                {
                    return "0" + "đơn";
                }
                else
                {
                    return tongTien;
                }
                    
                    
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        conn.close();
        return "0" + "đơn";
    }
    public double laySL(int sql1)
    {
        conn.open();
        DecimalFormat decimalFormat1 = new DecimalFormat("#,##0");
        String tongTien;
        String thanhTienFormatted;
        int thang = currentDate.getMonthValue();;
        int nam = currentDate.getYear();;
        String sql = "select sum(THANHTIEN) AS SOLUONG from HOADON where MONTH(NGAYLAP) = "+sql1+" and YEAR(NGAYLAP) = "+nam+"";
        
        ResultSet rs = conn.executeQuery(sql);
        try {
            while(rs.next()) {
                tongTien = rs.getString("SOLUONG");
                if(tongTien == null || tongTien.isEmpty())
                {
                    return 0;
                }
                else
                {
                    
                    double tongTienNumber = Double.parseDouble(tongTien);
                    
                    return tongTienNumber;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        conn.close();
        return 0; 
    }

    private void testData() {
        cardDoanhThu.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/income.png")), "Doanh thu trong tháng", doanhThuTrongThang()));
        cardTienThu.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/other_income.png")), "Tổng tiền nhân viên thu", doanhThuNVTrongThang()));
        cardTonKho.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/expense.png")), "Tổng hóa đơn tháng", SoLuongHDTrongThang()));
        chart.addLegend("VND", new Color(245, 189, 135));
        chart.addData(new ModelChart("Tháng 1", new double[]{laySL(1)}));
        chart.addData(new ModelChart("Tháng 2", new double[]{laySL(2)}));
        chart.addData(new ModelChart("Tháng 3", new double[]{laySL(3)}));
        chart.addData(new ModelChart("Tháng 4", new double[]{laySL(4)}));
        chart.addData(new ModelChart("Tháng 5", new double[]{laySL(5)}));
        chart.addData(new ModelChart("Tháng 6", new double[]{laySL(6)}));
        chart.addData(new ModelChart("Tháng 7", new double[]{laySL(7)}));
        chart.addData(new ModelChart("Tháng 8", new double[]{laySL(8)}));
        chart.addData(new ModelChart("Tháng 9", new double[]{laySL(9)}));
        chart.addData(new ModelChart("Tháng 10", new double[]{laySL(10)}));
        chart.addData(new ModelChart("Tháng 11", new double[]{laySL(11)}));
        chart.addData(new ModelChart("Tháng 12", new double[]{laySL(12)}));
    }
    
    private void initTableData() {
        EventAction eventAction = new EventAction() {
            @Override
            public void delete(ModelStudent student) {
                if (showMessage("Delete Student : " + student.getName())) {
                    System.out.println("User click OK");
                } else {
                    System.out.println("User click Cancel");
                }
            }

            @Override
            public void update(ModelStudent student) {
                if (showMessage("Update Student : " + student.getName())) {
                    System.out.println("User click OK");
                } else {
                    System.out.println("User click Cancel");
                }
            }
        };
        
    }
    private boolean showMessage(String message) {
        Message obj = new Message(Main.getFrames()[0], true);
        obj.showMessage(message);
        return obj.isOk();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cardDoanhThu = new com.raven.component.Card1();
        jLabel1 = new javax.swing.JLabel();
        cardTienThu = new com.raven.component.Card1();
        cardTonKho = new com.raven.component.Card1();
        panelShadow1 = new com.raven.swing.PanelShadow();
        jLabel2 = new javax.swing.JLabel();
        chart = new com.raven.chart.Chart();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("Dashboard / Home");

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(140, 110, 207));
        jLabel2.setText("Biểu đồ thống kê doanh thu trong năm");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 967, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 0));
        jLabel3.setText("DOANH THU TRONG THÁNG");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cardDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cardTienThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(cardTonKho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(362, 362, 362)
                .addComponent(jLabel3)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cardDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardTonKho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardTienThu, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.component.Card1 cardDoanhThu;
    private com.raven.component.Card1 cardTienThu;
    private com.raven.component.Card1 cardTonKho;
    private com.raven.chart.Chart chart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private com.raven.swing.PanelShadow panelShadow1;
    // End of variables declaration//GEN-END:variables
}
