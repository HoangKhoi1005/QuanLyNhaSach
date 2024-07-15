/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java;

import SQLServerProvider.SQLServerProvider;
import com.DTO.NhaCungCapDTO;
import com.DTO.NhaXuatBanDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class loadNCC {
    SQLServerProvider conn = new SQLServerProvider();
    
    public List<NhaCungCapDTO> getData()
    {
        try {
            conn.open();
            String sql = "SELECT * FROM NHACUNGCAP WHERE isDelete = 1";
            ResultSet rs = conn.executeQuery(sql);
            List<NhaCungCapDTO> list = new ArrayList<>();
            while(rs.next())
                list.add(new NhaCungCapDTO(rs.getString("MANCC"),rs.getNString("TENNCC")));
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
