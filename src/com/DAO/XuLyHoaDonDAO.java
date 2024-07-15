/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import SQLServerProvider.SQLServerProvider;
import static com.DAO.NhanVienDAO.conn;
import com.DTO.ChiTietHoaDonDTO;
import com.DTO.HoaDonDTO;
import com.DTO.KhachHangDTO;
import com.DTO.NhanVienDTO;
import java.sql.Date;
import java.sql.PreparedStatement;

/**
 *
 * @author ACER NITRO5
 */
public class XuLyHoaDonDAO {
    static SQLServerProvider conn = new SQLServerProvider();
    
    public static boolean themKhachHang(KhachHangDTO khachhang) {
        boolean kq = false;
        String sql = "INSERT INTO KHACHHANG VALUES (?, ?, ?, ?, ?)";
        conn.open();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            //ps.setString(1, khachhang.getMaKH());
            //ps.setString(2, khachhang.getHoTenKH());
            //ps.setString(3, khachhang.getDiaChi());
            //ps.setInt(4, khachhang.getSoDT());
            //ps.setString(5, khachhang.getEmail());
            setParameter(ps, 1, khachhang.getMaKH());
            setParameter(ps, 2, khachhang.getHoTenKH());
            setParameter(ps, 3, khachhang.getDiaChi());
            String soDT = String.valueOf(khachhang.getSoDT());
            if (soDT == "0") {
               
                ps.setNull(4, java.sql.Types.INTEGER);
            } else {
                ps.setInt(4, khachhang.getSoDT());
            }
            setParameter(ps, 5, khachhang.getEmail());
            int n = ps.executeUpdate();
            if (n == 1)
                kq = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        conn.close();
        return kq;
    }
    
    public static boolean themHoaDon(HoaDonDTO hoadon) {
        boolean kq = false;
        String sql = "INSERT INTO HOADON VALUES (?, ?, ?, ?, ?, ?)";
        conn.open();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hoadon.getMaHD());
            ps.setString(2, hoadon.getMaNV());
            ps.setString(3, hoadon.getMaKH());
            java.sql.Date sqlDate = new java.sql.Date(hoadon.getNgayLap().getTime());
            ps.setDate(4,sqlDate);
            ps.setString(5, hoadon.getTrangthaiDH());
            ps.setInt(6, hoadon.getThanhTien());
            int n = ps.executeUpdate();
            if (n == 1)
                kq = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        conn.close();
        return kq;
    }
    public static boolean themChiTietHD(ChiTietHoaDonDTO hoadon) {
        boolean kq = false;
        String sql = "INSERT INTO CHITIETHD VALUES (?, ?, ?, ?, ?)";
        conn.open();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hoadon.getMaSach());
            ps.setString(2, hoadon.getMaHD());
            ps.setInt(3, hoadon.getGiaBan());
            ps.setInt(4, hoadon.getSoLuong());
            ps.setInt(5, hoadon.getTongTien());
            int n = ps.executeUpdate();
            if (n == 1)
                kq = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        conn.close();
        return kq;
    }
    private static void setParameter(PreparedStatement pstmt, int index, String value) {
        try
        {
            //if (value == null ||value.trim().isEmpty() &&)
            if (value == null || value.trim().isEmpty()) {
            pstmt.setNull(index, java.sql.Types.VARCHAR);
        } else {
            pstmt.setString(index, value);
        }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
}
