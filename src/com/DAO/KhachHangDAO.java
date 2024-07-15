/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import static com.DAO.NhaCungCapDAO.conn;
import com.DTO.KhachHangDTO;
import com.DTO.NhaCungCapDTO;
import java.sql.PreparedStatement;

/**
 *
 * @author ACER NITRO5
 */
public class KhachHangDAO {
    public static boolean capNhatKhachHang(KhachHangDTO kh) {
        boolean kq = false;
        String sql = "UPDATE KHACHHANG SET HOTENKH = ?, DIACHIKH = ?, SODT = ?, EMAILKH = ? WHERE MAKH = ?";
        conn.open();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kh.getHoTenKH());
            ps.setString(2, kh.getDiaChi());
            ps.setInt(3, kh.getSoDT());
            ps.setString(4, kh.getEmail());
            ps.setString(5, kh.getMaKH());
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
