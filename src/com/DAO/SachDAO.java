/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;
import SQLServerProvider.SQLServerProvider;
import java.util.ArrayList;
import com.DTO.SachDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author ACER
 */
public class SachDAO {
    static SQLServerProvider conn = new SQLServerProvider();
    static ArrayList<SachDTO> ds = new ArrayList<SachDTO>();
    public static ArrayList<SachDTO> layDS() {
        try {
            String sql = "Select MASACH,TENNXB,TENTL,TENSACH,TENTG,NGAYXUATBAN,GIABAN,SOLUONGTON,ANHSACH,TRANGTHAI from SACH,NHAXUATBAN,THELOAI,TACGIA where SACH.MANXB=NHAXUATBAN.MANXB and SACH.MATL=THELOAI.MATL and SACH.MATG=TACGIA.MATG ORDER BY CAST(SUBSTRING(MASACH, 2, LEN(MASACH) - 1) AS INT)";
            conn.open();
            ResultSet rs = conn.executeQuery(sql);
            ArrayList<SachDTO> ds = new ArrayList<>();
            while(rs.next()) {
                SachDTO sach = new SachDTO();
                sach.setMaSach(rs.getString("MASACH"));
                sach.setMaNXB(rs.getString("TENNXB"));
                sach.setMaTL(rs.getString("TENTL"));
                sach.setTenSach(rs.getString("TENSACH"));
                sach.setMaTG(rs.getString("TENTG"));
                sach.setNgayXuatBan(rs.getDate("NGAYXUATBAN"));
                sach.setGiaBan(rs.getDouble("GIABAN"));
                sach.setSoLuongTon(rs.getInt("SOLUONGTON"));
                sach.setAnhSach(rs.getString("ANHSACH"));
                sach.setTrangThai(rs.getInt("TRANGTHAI"));
                ds.add(sach);
            }
            conn.close();
            return ds;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean themSach(SachDTO sach) {
        boolean kq = false;
        String sql = "INSERT INTO SACH VALUES(?,?,?,?,?,?,?,?,?,?)";
        conn.open();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sach.getMaSach());
            ps.setString(2, sach.getMaNXB());
            ps.setString(3, sach.getMaTL());
            ps.setString(4, sach.getTenSach());
            ps.setString(5, sach.getMaTG());
            ps.setDate(6, new java.sql.Date(sach.getNgayXuatBan().getTime()));
            ps.setDouble(7, sach.getGiaBan());
            ps.setInt(8, sach.getSoLuongTon());
            ps.setString(9, sach.getAnhSach());
            ps.setInt(10, sach.getTrangThai());
            int n = ps.executeUpdate();
            if(n == 1)
                kq = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        conn.close();
        return kq;
    }

    public static boolean xoaSach(String maSach) {
        boolean kq = false;
        String sql = "DELETE FROM SACH WHERE MaSach = ?";
        conn.open();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maSach);
            int n = ps.executeUpdate();
            if(n == 1)
                kq = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        conn.close();
        return kq;
    }

    public static boolean capNhatSach(SachDTO sach) {
        boolean kq = false;
        String sql = "UPDATE SACH SET TenSach = ?, MaNXB = ?, MaTL = ?, MaTG = ?, NgayXuatBan = ?, GiaBan = ?, SoLuongTon = ?, AnhSach = ? WHERE MaSach = ?";
        conn.open();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sach.getTenSach());
            ps.setString(2, sach.getMaNXB());
            ps.setString(3, sach.getMaTL());
            ps.setString(4, sach.getMaTG());
            ps.setDate(5, new java.sql.Date(sach.getNgayXuatBan().getTime()));
            ps.setDouble(6, sach.getGiaBan());
            ps.setInt(7, sach.getSoLuongTon());
            ps.setString(8, sach.getAnhSach());
            ps.setString(9, sach.getMaSach());
            int n = ps.executeUpdate();
            if(n == 1)
                kq = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        conn.close();
        return kq;
    }

    public static boolean huySach(String maSach) {
        boolean kq = false;
        String sql = String.format("UPDATE SACH SET TRANGTHAI = 0, SOLUONGTON = 0 WHERE MASACH = '%s' ",maSach);
        conn.open();
        int n = conn.executeUpdate(sql);
        if (n == 1)
            kq = true;
        conn.close();
        return kq;
    }
    
    public static ArrayList<SachDTO> timKiem(String traCuu) {
        try {
            String sql = "Select MASACH,TENNXB,TENTL,TENSACH,TENTG,NGAYXUATBAN,GIABAN,SOLUONGTON,ANHSACH,TRANGTHAI from Sach,NHAXUATBAN,THELOAI,TACGIA where SACH.MANXB=NHAXUATBAN.MANXB and SACH.MATL=THELOAI.MATL and SACH.MATG=TACGIA.MATG and (TENSACH + MASACH + TENNXB + TENTL + TENTG) like N'%" + traCuu.trim().toLowerCase() + "%' ORDER BY CAST(SUBSTRING(MASACH, 2, LEN(MASACH) - 1) AS INT)";
            conn.open();
            ResultSet rs = conn.executeQuery(sql);
            ArrayList<SachDTO> ds = new ArrayList<>();
            while(rs.next()) {
                SachDTO sach = new SachDTO();
                sach.setMaSach(rs.getString("MASACH"));
                sach.setMaNXB(rs.getString("TENNXB"));
                sach.setMaTL(rs.getString("TENTL"));
                sach.setTenSach(rs.getString("TENSACH"));
                sach.setMaTG(rs.getString("TENTG"));
                sach.setNgayXuatBan(rs.getDate("NGAYXUATBAN"));
                sach.setGiaBan(rs.getDouble("GIABAN"));
                sach.setSoLuongTon(rs.getInt("SOLUONGTON"));
                sach.setAnhSach(rs.getString("ANHSACH"));
                sach.setTrangThai(rs.getInt("TRANGTHAI"));
                ds.add(sach);
            }
            conn.close();
            return ds;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static ArrayList<SachDTO> sapXep(String truongDuLieu) {
        try {
            String sql = "SELECT MASACH, TENNXB, TENTL, TENSACH, TENTG, NGAYXUATBAN, GIABAN, SOLUONGTON, ANHSACH, TRANGTHAI " +
                         "FROM Sach, NHAXUATBAN, THELOAI, TACGIA " +
                         "WHERE SACH.MANXB = NHAXUATBAN.MANXB AND SACH.MATL = THELOAI.MATL AND SACH.MATG = TACGIA.MATG " +
                         "ORDER BY " + truongDuLieu;
            conn.open();
            ResultSet rs = conn.executeQuery(sql);
            ArrayList<SachDTO> ds = new ArrayList<>();
            while (rs.next()) {
                SachDTO sach = new SachDTO();
                sach.setMaSach(rs.getString("MASACH"));
                sach.setMaNXB(rs.getString("TENNXB"));
                sach.setMaTL(rs.getString("TENTL"));
                sach.setTenSach(rs.getString("TENSACH"));
                sach.setMaTG(rs.getString("TENTG"));
                sach.setNgayXuatBan(rs.getDate("NGAYXUATBAN"));
                sach.setGiaBan(rs.getDouble("GIABAN"));
                sach.setSoLuongTon(rs.getInt("SOLUONGTON"));
                sach.setAnhSach(rs.getString("ANHSACH"));
                sach.setTrangThai(rs.getInt("TRANGTHAI"));
                ds.add(sach);
            }
            conn.close();
            return ds;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static boolean capNhatTonKho(int soLuong, String maSach) {
        boolean kq = false;
        String sql = "UPDATE SACH SET SOLUONGTON = (SOLUONGTON - ?) WHERE MASACH = ?";
        conn.open();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, soLuong);
            ps.setString(2, maSach);
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
