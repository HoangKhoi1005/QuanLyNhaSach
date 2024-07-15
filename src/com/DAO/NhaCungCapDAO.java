/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import SQLServerProvider.SQLServerProvider;
import static com.DAO.SachDAO.conn;
import com.DTO.NhaCungCapDTO;
import com.DTO.SachDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class NhaCungCapDAO {
    static SQLServerProvider conn = new SQLServerProvider();
    static ArrayList<NhaCungCapDTO> ds = new ArrayList<NhaCungCapDTO>();
    public static ArrayList<NhaCungCapDTO> layDS() {
        try {
            String sql = "SELECT * FROM NHACUNGCAP ORDER BY CAST(RIGHT(MANCC, 3) AS INT)";
            conn.open();
            ResultSet rs = conn.executeQuery(sql);
            ArrayList<NhaCungCapDTO> ds = new ArrayList<>();
            while(rs.next()) {
                NhaCungCapDTO ncc = new NhaCungCapDTO();
                ncc.setMaNCC(rs.getString("MANCC"));
                ncc.setTenNCC(rs.getNString("TENNCC"));
                ncc.setDiaChiNCC(rs.getNString("DIACHINCC"));
                ncc.setEmailNCC(rs.getString("EMAILNCC"));
                ncc.setSoDT(rs.getNString("SODT"));
                ncc.setTrangThai(rs.getNString("TRANGTHAI"));
                ncc.setIsDelete(rs.getInt("isDelete"));
                ds.add(ncc);
            }
            conn.close();
            return ds;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static boolean themNCC(NhaCungCapDTO nhacc) {
        boolean kq = false;
        String sql = "INSERT INTO NHACUNGCAP VALUES(?,?,?,?,?,?,?)";
        conn.open();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nhacc.getMaNCC());
            ps.setString(2, nhacc.getTenNCC());
            ps.setString(3, nhacc.getDiaChiNCC());
            ps.setString(4, nhacc.getSoDT());
            ps.setString(5, nhacc.getEmailNCC());
            ps.setString(6, nhacc.getTrangThai());
            ps.setInt(7, nhacc.getIsDelete());
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
    
    public static boolean huyNCC(String maNCC) {
        boolean kq = false;
        String sql = String.format("UPDATE NHACUNGCAP SET isDelete = 0 WHERE MANCC = '%s' ",maNCC);
        conn.open();
        int n = conn.executeUpdate(sql);
        if (n == 1)
            kq = true;
        conn.close();
        return kq;
    }
    
    public static boolean capNhatNCC(NhaCungCapDTO nhacc) {
        boolean kq = false;
        String sql = "UPDATE NHACUNGCAP SET TENNCC = ?, DIACHINCC = ?, SODT = ?, EMAILNCC = ?, TRANGTHAI = ? WHERE MANCC = ?";
        conn.open();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nhacc.getTenNCC());
            ps.setString(2, nhacc.getDiaChiNCC());
            ps.setString(3, nhacc.getSoDT());
            ps.setString(4, nhacc.getEmailNCC());
            ps.setString(5, nhacc.getTrangThai());
            ps.setString(6, nhacc.getMaNCC());
            int n = ps.executeUpdate();
            if(n == 1)
                kq = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        conn.close();
        return kq;
    }
    
    public static ArrayList<NhaCungCapDTO> timKiem(String traCuu) {
        try {
            String sql = "SELECT * FROM NHACUNGCAP WHERE (MANCC + TENNCC + DIACHINCC + SODT + EMAILNCC + TRANGTHAI) like N'%" + traCuu.trim().toLowerCase() + "%' ORDER BY CAST(RIGHT(MANCC, 3) AS INT)";
            conn.open();
            ResultSet rs = conn.executeQuery(sql);
            ArrayList<NhaCungCapDTO> ds = new ArrayList<>();
            while(rs.next()) {
                NhaCungCapDTO ncc = new NhaCungCapDTO();
                ncc.setMaNCC(rs.getString("MANCC"));
                ncc.setTenNCC(rs.getNString("TENNCC"));
                ncc.setDiaChiNCC(rs.getNString("DIACHINCC"));
                ncc.setEmailNCC(rs.getString("EMAILNCC"));
                ncc.setSoDT(rs.getNString("SODT"));
                ncc.setTrangThai(rs.getNString("TRANGTHAI"));
                ds.add(ncc);
            }
            conn.close();
            return ds;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static ArrayList<NhaCungCapDTO> sapXep(String truongDuLieu) {
        try {
            String sql = "SELECT * FROM NHACUNGCAP " +
                         "ORDER BY " + truongDuLieu;
            conn.open();
            ResultSet rs = conn.executeQuery(sql);
            ArrayList<NhaCungCapDTO> ds = new ArrayList<>();
            while (rs.next()) {
                NhaCungCapDTO ncc = new NhaCungCapDTO();
                    ncc.setMaNCC(rs.getString("MANCC"));
                    ncc.setTenNCC(rs.getNString("TENNCC"));
                    ncc.setDiaChiNCC(rs.getNString("DIACHINCC"));
                    ncc.setEmailNCC(rs.getString("EMAILNCC"));
                    ncc.setSoDT(rs.getNString("SODT"));
                    ncc.setTrangThai(rs.getNString("TRANGTHAI"));
                    ds.add(ncc);
            }
            conn.close();
            return ds;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
