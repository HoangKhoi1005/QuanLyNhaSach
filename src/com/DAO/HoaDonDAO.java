/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import SQLServerProvider.SQLServerProvider;
import com.DTO.HoaDonDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

public class HoaDonDAO {
    static SQLServerProvider conn = new SQLServerProvider();

    public static ArrayList<HoaDonDTO> layDS() {
        try {
            String sql = "SELECT HOADON.MAHD, NHANVIEN.HOTENNV AS TENNV, KHACHHANG.HOTENKH AS TENKH, HOADON.NGAYLAP, HOADON.TRANGTHAIDH, HOADON.THANHTIEN " +
                         "FROM HOADON " +
                         "JOIN NHANVIEN ON HOADON.MANV = NHANVIEN.MANV " +
                         "JOIN KHACHHANG ON HOADON.MAKH = KHACHHANG.MAKH";
            conn.open();
            ResultSet rs = conn.executeQuery(sql);
            ArrayList<HoaDonDTO> ds = new ArrayList<>();
            while (rs.next()) {
                HoaDonDTO hoaDon = new HoaDonDTO();
                hoaDon.setMaHD(rs.getString("MAHD"));
                hoaDon.setMaNV(rs.getString("TENNV"));
                hoaDon.setMaKH(rs.getString("TENKH"));
                hoaDon.setNgayLap(rs.getDate("NGAYLAP"));
                hoaDon.setTrangthaiDH(rs.getString("TRANGTHAIDH"));
                hoaDon.setThanhTien(rs.getInt("THANHTIEN"));
                ds.add(hoaDon);
            }
            conn.close();
            return ds;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
