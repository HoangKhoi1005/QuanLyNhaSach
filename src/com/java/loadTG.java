/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java;

import SQLServerProvider.SQLServerProvider;
import com.DTO.NhaXuatBanDTO;
import com.DTO.TacGiaDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class loadTG {
    SQLServerProvider conn = new SQLServerProvider();
    
    public List<TacGiaDTO> getData()
    {
        try {
            conn.open();
            String sql = "SELECT * FROM TACGIA";
            ResultSet rs = conn.executeQuery(sql);
            List<TacGiaDTO> list = new ArrayList<>();
            while(rs.next())
                list.add(new TacGiaDTO(rs.getString("MATG"),rs.getNString("TENTG")));
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
