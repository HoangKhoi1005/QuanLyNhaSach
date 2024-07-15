/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java;

import SQLServerProvider.SQLServerProvider;
import com.DTO.KhachHangDTO;
import com.DTO.KhuyenMaiDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER NITRO5
 */
public class loadKhuyenMai {
    SQLServerProvider conn = new SQLServerProvider();
    public List<KhuyenMaiDTO> getData()
    {
        try {
            conn.open();
            String sql = "SELECT * FROM KHUYENMAI";
            ResultSet rs = conn.executeQuery(sql);
            List<KhuyenMaiDTO> list = new ArrayList<>();
            while(rs.next())
                list.add(new KhuyenMaiDTO(rs.getString("MAKM")));
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
