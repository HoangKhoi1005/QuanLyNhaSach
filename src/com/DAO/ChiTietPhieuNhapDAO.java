/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import SQLServerProvider.SQLServerProvider;
import com.DTO.ChiTietPhieuNhapDTO;
import com.DTO.SachDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class ChiTietPhieuNhapDAO {
    static SQLServerProvider conn = new SQLServerProvider();
    static ArrayList<ChiTietPhieuNhapDTO> ds = new ArrayList<ChiTietPhieuNhapDTO>();
    

    public static boolean themChiTietPN(ChiTietPhieuNhapDTO ctpn) {
        boolean kq = false;
        String sql = "INSERT INTO CHITIETPN VALUES(?,?,?,?,?)";
        conn.open();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ctpn.getMaSach());
            ps.setString(2, ctpn.getMaPhieuNhap());
            ps.setDouble(3, ctpn.getGiaNhap());
            ps.setInt(4, ctpn.getSoLuongNhap());
            ps.setDouble(5, ctpn.getTongTien());
            int n = ps.executeUpdate();
            if(n == 1)
                kq = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        conn.close();
        return kq;
    }

    public static boolean xoaChiTietPN(String maSach,String maPhieuNhap) {
        boolean kq = false;
        String sql = "DELETE CHITIETPN WHERE MaSach = ? and MAPHIEUNHAP = ?";
        conn.open();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maSach);
            ps.setString(2, maPhieuNhap);
            int n = ps.executeUpdate();
            if(n == 1)
                kq = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        conn.close();
        return kq;
    }
    
    public static boolean xoaChiTietPNTheoMa(String maPhieuNhap) {
        boolean kq = false;
        String sql = "DELETE CHITIETPN WHERE MAPHIEUNHAP = ?";
        conn.open();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maPhieuNhap);
            int n = ps.executeUpdate();
            if(n == 1)
                kq = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        conn.close();
        return kq;
    }
    
    public static boolean kiemTraTrungKhoaChinh(String maSach, String maPhieuNhap) {
        boolean trungKhoaChinh = false;
        String sql = "SELECT COUNT(*) AS COUNT FROM CHITIETPN WHERE MASACH = ? AND MAPHIEUNHAP = ?";

        conn.open();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maSach);
            ps.setString(2, maPhieuNhap);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int count = rs.getInt("COUNT");
                if (count > 0) {
                    trungKhoaChinh = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        conn.close();
        return trungKhoaChinh;
    }

}
