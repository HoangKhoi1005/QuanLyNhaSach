/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java;

import SQLServerProvider.SQLServerProvider;
import com.DTO.ChucVuDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class loadChucVu {
    SQLServerProvider conn = new SQLServerProvider();
    
    public List<ChucVuDTO> getData()
    {
        try {
            conn.open();
            String sql = "SELECT * FROM CHUCVU";
            ResultSet rs = conn.executeQuery(sql);
            List<ChucVuDTO> list = new ArrayList<>();
            while(rs.next())
                list.add(new ChucVuDTO(rs.getString("MACV"),rs.getNString("TENCV")));
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
