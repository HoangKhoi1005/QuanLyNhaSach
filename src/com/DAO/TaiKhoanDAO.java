package com.DAO;

import SQLServerProvider.SQLServerProvider;
import com.DTO.TaiKhoanDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TaiKhoanDAO {
    static SQLServerProvider conn = new SQLServerProvider();

    public static ArrayList<TaiKhoanDTO> layDS() {
        try {
            String sql = "Select TENDN, TENHT,MATKHAU,PHANQUYEN,TAIKHOAN.MANV,HOTENNV,EMAILNV from TAIKHOAN,NHANVIEN where TAIKHOAN.MANV=NHANVIEN.MANV";
            conn.open();
            ResultSet rs = conn.executeQuery(sql);
            ArrayList<TaiKhoanDTO> ds = new ArrayList<>();
            while (rs.next()) {
                TaiKhoanDTO taiKhoan = new TaiKhoanDTO();
                taiKhoan.setTenDN(rs.getString("TENDN"));
                taiKhoan.setTenHT(rs.getString("TENHT"));
                taiKhoan.setMatKhau(rs.getString("MATKHAU"));
                taiKhoan.setPhanQuyen(rs.getString("PHANQUYEN"));
                taiKhoan.setMaNV(rs.getString("MANV"));
                taiKhoan.setTenNV(rs.getNString("HOTENNV"));
                taiKhoan.setEmail(rs.getString("EMAILNV"));
                ds.add(taiKhoan);
            }
            conn.close();
            return ds;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean themTaiKhoan(TaiKhoanDTO taiKhoan) {
        boolean kq = false;
        String sql = "INSERT INTO TAIKHOAN VALUES (?, ?, ?, ?, ?)";
        conn.open();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, taiKhoan.getTenDN());
            ps.setString(2, taiKhoan.getTenHT());
            ps.setString(3, taiKhoan.getMatKhau());
            ps.setString(4, taiKhoan.getPhanQuyen());
            ps.setString(5, taiKhoan.getMaNV());
            int n = ps.executeUpdate();
            if (n == 1)
                kq = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        conn.close();
        return kq;
    }

    public static boolean xoaTaiKhoan(String tenDN) {
        boolean kq = false;
        String sql = "DELETE FROM TAIKHOAN WHERE TENDN = ?";
        conn.open();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tenDN);
            int n = ps.executeUpdate();
            if (n == 1)
                kq = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        conn.close();
        return kq;
    }

    public static boolean capNhatTaiKhoan(TaiKhoanDTO taiKhoan) {
        boolean kq = false;
        String sql = "UPDATE TAIKHOAN SET TENHT = ?, MATKHAU = ?, PHANQUYEN = ?, MANV = ? WHERE TENDN = ?";
        conn.open();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, taiKhoan.getTenHT());
            ps.setString(2, taiKhoan.getMatKhau());
            ps.setString(3, taiKhoan.getPhanQuyen());
            ps.setString(4, taiKhoan.getMaNV());
            ps.setString(5, taiKhoan.getTenDN());
            int n = ps.executeUpdate();
            if (n == 1)
                kq = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        conn.close();
        return kq;
    }

    public static ArrayList<TaiKhoanDTO> timKiem(String traCuu) {
        try {
            String sql = "SELECT TENDN, TENHT, MATKHAU, PHANQUYEN, MANV FROM TAIKHOAN WHERE TENDN LIKE ?";
            conn.open();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + traCuu + "%");
            ResultSet rs = ps.executeQuery();
            ArrayList<TaiKhoanDTO> ds = new ArrayList<>();
            while (rs.next()) {
                TaiKhoanDTO taiKhoan = new TaiKhoanDTO();
                taiKhoan.setTenDN(rs.getString("TENDN"));
                taiKhoan.setTenHT(rs.getString("TENHT"));
                taiKhoan.setMatKhau(rs.getString("MATKHAU"));
                taiKhoan.setPhanQuyen(rs.getString("PHANQUYEN"));
                taiKhoan.setMaNV(rs.getString("MANV"));
                ds.add(taiKhoan);
            }
            conn.close();
            return ds;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
