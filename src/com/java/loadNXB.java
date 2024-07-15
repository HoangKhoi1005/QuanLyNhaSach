/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java;

import SQLServerProvider.SQLServerProvider;
import com.DTO.NhaXuatBanDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class loadNXB {
    SQLServerProvider conn = new SQLServerProvider();
    
    public List<NhaXuatBanDTO> getData()
    {
        try {
            conn.open();
            String sql = "SELECT * FROM NHAXUATBAN";
            ResultSet rs = conn.executeQuery(sql);
            List<NhaXuatBanDTO> list = new ArrayList<>();
            while(rs.next())
                list.add(new NhaXuatBanDTO(rs.getString("MANXB"),rs.getNString("TENNXB")));
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
