/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java;

import SQLServerProvider.SQLServerProvider;
import com.DTO.NhaXuatBanDTO;
import com.DTO.NhanVienDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class loadNV {
    SQLServerProvider conn = new SQLServerProvider();
    
    public List<NhanVienDTO> getData()
    {
        try {
            conn.open();
            String sql = "SELECT * FROM NHANVIEN";
            ResultSet rs = conn.executeQuery(sql);
            List<NhanVienDTO> list = new ArrayList<>();
            while(rs.next())
                list.add(new NhanVienDTO(rs.getString("MANV"),rs.getNString("HOTENNV")));
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
