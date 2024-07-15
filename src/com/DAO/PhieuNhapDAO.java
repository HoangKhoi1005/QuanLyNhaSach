/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import SQLServerProvider.SQLServerProvider;
import static com.DAO.SachDAO.conn;
import com.DTO.PhieuNhapDTO;
import com.DTO.SachDTO;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ACER
 */
public class PhieuNhapDAO {
    static SQLServerProvider conn = new SQLServerProvider();

    public static ArrayList<PhieuNhapDTO> layDS() {
        try {
            String sql = "Select MAPHIEUNHAP,NGAYNHAP,THANHTIEN,NHANVIEN.HOTENNV,NHACUNGCAP.TENNCC from PHIEUNHAP,NHACUNGCAP,NHANVIEN where PHIEUNHAP.MANCC=NHACUNGCAP.MANCC and PHIEUNHAP.MANV=NHANVIEN.MANV";
            conn.open();
            ResultSet rs = conn.executeQuery(sql);
            ArrayList<PhieuNhapDTO> ds = new ArrayList<>();
            while(rs.next()) {
                PhieuNhapDTO phieuNhap = new PhieuNhapDTO();
                phieuNhap.setMaPhieuNhap(rs.getString("MAPHIEUNHAP"));
                phieuNhap.setNgayNhap(rs.getDate("NGAYNHAP"));
                phieuNhap.setThanhTien(rs.getDouble("THANHTIEN"));
                phieuNhap.setMaNV(rs.getString("HOTENNV"));
                phieuNhap.setMaNCC(rs.getString("TENNCC"));
                ds.add(phieuNhap);
            }
            conn.close();
            return ds;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean themPhieuNhap(PhieuNhapDTO phieuNhap) {
        boolean kq = false;
        String sql = "INSERT INTO PHIEUNHAP VALUES(?, ?, ?, ?, ?)";
        conn.open();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, phieuNhap.getMaPhieuNhap());
            ps.setDate(2, new java.sql.Date(phieuNhap.getNgayNhap().getTime()));
            ps.setDouble(3, phieuNhap.getThanhTien());
            ps.setString(4, phieuNhap.getMaNV());
            ps.setString(5, phieuNhap.getMaNCC());
            int n = ps.executeUpdate();
            if(n == 1)
                kq = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        conn.close();
        return kq;
    }

    public static boolean xoaPhieuNhap(String maPhieuNhap) {
        boolean kq = false;
        String sql = "DELETE FROM PHIEUNHAP WHERE MAPHIEUNHAP = ?";
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

    public static boolean capNhatPhieuNhap(PhieuNhapDTO phieuNhap) {
        boolean kq = false;
        String sql = "UPDATE PHIEUNHAP SET NGAYNHAP = ?, THANHTIEN = ?, MANV = ?, MANCC = ? WHERE MAPHIEUNHAP = ?";
        conn.open();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(phieuNhap.getNgayNhap().getTime()));
            ps.setDouble(2, phieuNhap.getThanhTien());
            ps.setString(3, phieuNhap.getMaNV());
            ps.setString(4, phieuNhap.getMaNCC());
            ps.setString(5, phieuNhap.getMaPhieuNhap());
            int n = ps.executeUpdate();
            if(n == 1)
                kq = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        conn.close();
        return kq;
    }
    
    public static ArrayList<PhieuNhapDTO> timKiem(String traCuu) {
        try {
            String sql = "Select MAPHIEUNHAP,NGAYNHAP,THANHTIEN,NHANVIEN.HOTENNV,NHACUNGCAP.TENNCC from PHIEUNHAP,NHACUNGCAP,NHANVIEN where PHIEUNHAP.MANCC=NHACUNGCAP.MANCC and PHIEUNHAP.MANV=NHANVIEN.MANV";
            conn.open();
            ResultSet rs = conn.executeQuery(sql);
            ArrayList<PhieuNhapDTO> ds = new ArrayList<>();
            while(rs.next()) {
                PhieuNhapDTO phieuNhap = new PhieuNhapDTO();
                phieuNhap.setMaPhieuNhap(rs.getString("MAPHIEUNHAP"));
                phieuNhap.setNgayNhap(rs.getDate("NGAYNHAP"));
                phieuNhap.setThanhTien(rs.getDouble("THANHTIEN"));
                phieuNhap.setMaNV(rs.getString("HOTENNV"));
                phieuNhap.setMaNCC(rs.getString("TENNCC"));
                ds.add(phieuNhap);
            }
            conn.close();
            return ds;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static ArrayList<PhieuNhapDTO> sapXep(String truongDuLieu) {
    try {
        String sql ="Select MAPHIEUNHAP,NGAYNHAP,THANHTIEN,NHANVIEN.HOTENNV,NHACUNGCAP.TENNCC from PHIEUNHAP,NHACUNGCAP,NHANVIEN where PHIEUNHAP.MANCC=NHACUNGCAP.MANCC and PHIEUNHAP.MANV=NHANVIEN.MANV " +
                     "ORDER BY " + truongDuLieu;
        conn.open();
        ResultSet rs = conn.executeQuery(sql);
        ArrayList<PhieuNhapDTO> ds = new ArrayList<>();
        while (rs.next()) {
            PhieuNhapDTO phieuNhap = new PhieuNhapDTO();
            phieuNhap.setMaPhieuNhap(rs.getString("MAPHIEUNHAP"));
            phieuNhap.setNgayNhap(rs.getDate("NGAYNHAP"));
            phieuNhap.setThanhTien(rs.getDouble("THANHTIEN"));
            phieuNhap.setMaNV(rs.getString("HOTENNV"));
            phieuNhap.setMaNCC(rs.getString("TENNCC"));
            ds.add(phieuNhap);
        }
        conn.close();
        return ds;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
