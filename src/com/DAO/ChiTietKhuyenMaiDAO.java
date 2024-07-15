/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import SQLServerProvider.SQLServerProvider;
import static com.DAO.KhuyenMaiDAO.conn;
import com.DTO.ChiTietKhuyenMaiDTO;
import com.DTO.KhuyenMaiDTO;
import java.sql.PreparedStatement;

/**
 *
 * @author ACER NITRO5
 */
public class ChiTietKhuyenMaiDAO {
        static SQLServerProvider conn = new SQLServerProvider();
        public static boolean themKhuyenMai(ChiTietKhuyenMaiDTO km) {
        boolean kq = false;
        String sql = "INSERT INTO SACHKHUYENMAI VALUES(?,?,?)";
        conn.open();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, km.getId());
            ps.setString(2, km.getMaSach());
            ps.setString(3, km.getMaKM());
            int n = ps.executeUpdate();
            if(n == 1)
                kq = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        conn.close();
        return kq;
    }
    public static boolean xoaKhuyenMai(int Id) {
        boolean kq = false;
        String sql = "DELETE FROM SACHKHUYENMAI WHERE ID = ?";
        conn.open();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Id);
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
