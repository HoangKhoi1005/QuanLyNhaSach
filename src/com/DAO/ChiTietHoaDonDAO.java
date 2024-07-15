/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import SQLServerProvider.SQLServerProvider;
import static com.DAO.NhaCungCapDAO.conn;
import com.DTO.ChiTietHoaDonDTO;
import com.DTO.NhaCungCapDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ACER NITRO5
 */
public class ChiTietHoaDonDAO {
    static SQLServerProvider conn = new SQLServerProvider();
    public static ArrayList<ChiTietHoaDonDTO> layDS(String maHD) {
        try {
            String sql = "SELECT * FROM CHITIETHOADON";
            conn.open();
            ResultSet rs = conn.executeQuery(sql);
            ArrayList<ChiTietHoaDonDTO> ds = new ArrayList<>();
            while(rs.next()) {
                
            }
            conn.close();
            return ds;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
