/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java;

import SQLServerProvider.SQLServerProvider;
import com.DTO.TheLoaiDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class loaiTL {
    SQLServerProvider conn = new SQLServerProvider();
    public List<TheLoaiDTO> getData()
    {
        try {
            conn.open();
            String sql = "SELECT * FROM THELOAI";
            ResultSet rs = conn.executeQuery(sql);
            List<TheLoaiDTO> list = new ArrayList<>();
            while(rs.next())
                list.add(new TheLoaiDTO(rs.getString("MATL"),rs.getNString("TENTL")));
            conn.close();
            return list;
        } catch (Exception e) {
        }
        return null;
    }
}
