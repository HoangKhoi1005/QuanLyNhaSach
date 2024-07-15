/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java;

import SQLServerProvider.SQLServerProvider;
import com.DTO.KhachHangDTO;
import com.DTO.SachDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER NITRO5
 */
public class loadKhachHang {
    SQLServerProvider conn = new SQLServerProvider();
    
    public List<KhachHangDTO> getData()
    {
        try {
            conn.open();
            String sql = "SELECT * FROM KHACHHANG";
            ResultSet rs = conn.executeQuery(sql);
            List<KhachHangDTO> list = new ArrayList<>();
            while(rs.next())
                list.add(new KhachHangDTO(rs.getString("MAKH"),rs.getNString("HOTENKH")));
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
