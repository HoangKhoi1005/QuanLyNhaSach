/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java;

import SQLServerProvider.SQLServerProvider;
import com.DTO.SachDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class loadSach {
    SQLServerProvider conn = new SQLServerProvider();
    
    public List<SachDTO> getData()
    {
        try {
            conn.open();
            String sql = "SELECT * FROM SACH WHERE TRANGTHAI = 1";
            ResultSet rs = conn.executeQuery(sql);
            List<SachDTO> list = new ArrayList<>();
            while(rs.next())
                list.add(new SachDTO(rs.getString("MASACH"),rs.getNString("TENSACH")));
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
