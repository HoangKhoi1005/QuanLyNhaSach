package com.DAO;

import SQLServerProvider.SQLServerProvider;
import com.DTO.NhanVienDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class NhanVienDAO {
    static SQLServerProvider conn = new SQLServerProvider();

    public static ArrayList<NhanVienDTO> layDS() {
        try {
            String sql = "SELECT MANV, TENCV, HOTENNV, DIACHINV, SODT, EMAILNV, ANHNV, TRANGTHAI FROM NHANVIEN, CHUCVU WHERE NHANVIEN.MACV = CHUCVU.MACV ORDER BY CAST(SUBSTRING(MANV, 3, LEN(MANV) - 1) AS INT)";
            conn.open();
            ResultSet rs = conn.executeQuery(sql);
            ArrayList<NhanVienDTO> ds = new ArrayList<>();
            while (rs.next()) {
                NhanVienDTO nhanvien = new NhanVienDTO();
                nhanvien.setMaNV(rs.getString("MANV"));
                nhanvien.setMaCV(rs.getString("TENCV"));
                nhanvien.setHoTenNV(rs.getString("HOTENNV"));
                nhanvien.setDiaChiNV(rs.getString("DIACHINV"));
                nhanvien.setSoDT(rs.getString("SODT"));
                nhanvien.setEmailNV(rs.getString("EMAILNV"));
                nhanvien.setAnhNV(rs.getString("ANHNV"));
                nhanvien.setTrangThai(rs.getInt("TRANGTHAI"));
                ds.add(nhanvien);
            }
            conn.close();
            return ds;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean themNhanVien(NhanVienDTO nhanvien) {
        boolean kq = false;
        String sql = "INSERT INTO NHANVIEN VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        conn.open();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nhanvien.getMaNV());
            ps.setString(2, nhanvien.getMaCV());
            ps.setString(3, nhanvien.getHoTenNV());
            ps.setString(4, nhanvien.getDiaChiNV());
            ps.setString(5, nhanvien.getSoDT());
            ps.setString(6, nhanvien.getEmailNV());
            ps.setString(7, nhanvien.getAnhNV());
            ps.setInt(8, nhanvien.getTrangThai());
            int n = ps.executeUpdate();
            if (n == 1)
                kq = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        conn.close();
        return kq;
    }

    public static boolean xoaNhanVien(String maNV) {
        boolean kq = false;
        String sql = "DELETE FROM NHANVIEN WHERE MANV = ?";
        conn.open();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maNV);
            int n = ps.executeUpdate();
            if (n == 1)
                kq = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        conn.close();
        return kq;
    }

    public static boolean capNhatNhanVien(NhanVienDTO nhanvien) {
        boolean kq = false;
        String sql = "UPDATE NHANVIEN SET MACV = ?, HOTENNV = ?, DIACHINV = ?, SODT = ?, EMAILNV = ?, ANHNV = ? WHERE MANV = ?";
        conn.open();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nhanvien.getMaCV());
            ps.setString(2, nhanvien.getHoTenNV());
            ps.setString(3, nhanvien.getDiaChiNV());
            ps.setString(4, nhanvien.getSoDT());
            ps.setString(5, nhanvien.getEmailNV());
            ps.setString(6, nhanvien.getAnhNV());
            ps.setString(7, nhanvien.getMaNV());
            int n = ps.executeUpdate();
            if (n == 1)
                kq = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        conn.close();
        return kq;
    }
    
    public static boolean capNhatAnhNhanVien(NhanVienDTO nhanvien) {
        boolean kq = false;
        String sql = "UPDATE NHANVIEN SET ANHNV = ? WHERE MANV = ?";
        conn.open();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nhanvien.getAnhNV());
            ps.setString(2, nhanvien.getMaNV());
            int n = ps.executeUpdate();
            if (n == 1)
                kq = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        conn.close();
        return kq;
    }
    
    public static boolean huyNhanVien(String maNV) {
        boolean kq = false;
        String sql = "UPDATE NHANVIEN SET TRANGTHAI = 0 WHERE MANV = ?";
        conn.open();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maNV);
            int n = ps.executeUpdate();
            if (n == 1)
                kq = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        conn.close();
        return kq;
    }
    
    public static ArrayList<NhanVienDTO> timKiem(String traCuu) {
        try {
            String sql = "SELECT MANV, TENCV, HOTENNV, DIACHINV, SODT, EMAILNV, ANHNV, TRANGTHAI FROM NHANVIEN, CHUCVU WHERE NHANVIEN.MACV = CHUCVU.MACV AND (HOTENNV + MANV + DIACHINV + EMAILNV) LIKE N'%" + traCuu.trim().toLowerCase() + "%' ORDER BY CAST(SUBSTRING(MANV, 3, LEN(MANV) - 1) AS INT)";
            conn.open();
            ResultSet rs = conn.executeQuery(sql);
            ArrayList<NhanVienDTO> ds = new ArrayList<>();
            while (rs.next()) {
                NhanVienDTO nhanvien = new NhanVienDTO();
                nhanvien.setMaNV(rs.getString("MANV"));
                nhanvien.setMaCV(rs.getString("TENCV"));
                nhanvien.setHoTenNV(rs.getString("HOTENNV"));
                nhanvien.setDiaChiNV(rs.getString("DIACHINV"));
                nhanvien.setSoDT(rs.getString("SODT"));
                nhanvien.setEmailNV(rs.getString("EMAILNV"));
                nhanvien.setAnhNV(rs.getString("ANHNV"));
                nhanvien.setTrangThai(rs.getInt("TRANGTHAI"));
                ds.add(nhanvien);
            }
            conn.close();
            return ds;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static ArrayList<NhanVienDTO> sapXep(String truongDuLieu) {
        try {
            String sql = "SELECT MANV, TENCV, HOTENNV, DIACHINV, SODT, EMAILNV, ANHNV, TRANGTHAI FROM NHANVIEN, CHUCVU WHERE NHANVIEN.MACV = CHUCVU.MACV ORDER BY " + truongDuLieu;
            conn.open();
            ResultSet rs = conn.executeQuery(sql);
            ArrayList<NhanVienDTO> ds = new ArrayList<>();
            while (rs.next()) {
                NhanVienDTO nhanvien = new NhanVienDTO();
                nhanvien.setMaNV(rs.getString("MANV"));
                nhanvien.setMaCV(rs.getString("TENCV"));
                nhanvien.setHoTenNV(rs.getString("HOTENNV"));
                nhanvien.setDiaChiNV(rs.getString("DIACHINV"));
                nhanvien.setSoDT(rs.getString("SODT"));
                nhanvien.setEmailNV(rs.getString("EMAILNV"));
                nhanvien.setAnhNV(rs.getString("ANHNV"));
                nhanvien.setTrangThai(rs.getInt("TRANGTHAI"));
                ds.add(nhanvien);
            }
            conn.close();
            return ds;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
