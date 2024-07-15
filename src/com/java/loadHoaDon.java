/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java;

import SQLServerProvider.SQLServerProvider;
import com.DTO.ChiTietHoaDonDTO;
import com.DTO.ChucVuDTO;
import com.DTO.HoaDonDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER NITRO5
 */
public class loadHoaDon {
    SQLServerProvider conn = new SQLServerProvider();
    
    public List<HoaDonDTO> getData()
    {
        try {
            conn.open();
            String sql = "SELECT * FROM HOADON ";
            ResultSet rs = conn.executeQuery(sql);
            List<HoaDonDTO> list = new ArrayList<>();
            while(rs.next())
                list.add(new HoaDonDTO(rs.getString("MAHD"),rs.getString("MANV")));
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
