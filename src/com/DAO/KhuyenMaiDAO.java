/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import SQLServerProvider.SQLServerProvider;
import static com.DAO.NhaCungCapDAO.conn;
import com.DTO.KhachHangDTO;
import com.DTO.KhuyenMaiDTO;
import com.DTO.NhaCungCapDTO;
import java.sql.PreparedStatement;

/**
 *
 * @author ACER NITRO5
 */
public class KhuyenMaiDAO {
    static SQLServerProvider conn = new SQLServerProvider();
    public static boolean themKhuyenMai(KhuyenMaiDTO km) {
        boolean kq = false;
        String sql = "INSERT INTO KHUYENMAI VALUES(?,?,?,?,?)";
        conn.open();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, km.getMaKM());
            ps.setString(2, km.getTenKM());
            java.sql.Date sqlDate = new java.sql.Date(km.getNgayBD().getTime());
            java.sql.Date sqlDate1 = new java.sql.Date(km.getNgayKT().getTime());
            ps.setDate(3, sqlDate);
            ps.setDate(4, sqlDate1);
            ps.setDouble(5, km.getGiamGia());
            int n = ps.executeUpdate();
            if(n == 1)
                kq = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        conn.close();
        return kq;
    }
    public static boolean capNhatKhuyenMai(KhuyenMaiDTO km) {
        boolean kq = false;
        String sql = "UPDATE KHUYENMAI SET TENKM = ?, NGAYBD = ?, NGAYKT = ?, GIAMGIA = ? WHERE MAKM = ?";
        conn.open();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(5, km.getMaKM());
            ps.setString(1, km.getTenKM());
            java.sql.Date sqlDate = new java.sql.Date(km.getNgayBD().getTime());
            java.sql.Date sqlDate1 = new java.sql.Date(km.getNgayKT().getTime());
            ps.setDate(2, sqlDate);
            ps.setDate(3, sqlDate1);
            ps.setDouble(4, km.getGiamGia());
            int n = ps.executeUpdate();
            if(n == 1)
                kq = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        conn.close();
        return kq;
    }
    public static boolean xoaKhuyenMai(String maKM) {
        boolean kq = false;
        String sql = "DELETE FROM KHUYENMAI WHERE MAKM = ?";
        conn.open();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maKM);
            int n = ps.executeUpdate();
            if(n == 1)
                kq = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        conn.close();
        return kq;
    }
}
