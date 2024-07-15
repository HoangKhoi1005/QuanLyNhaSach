/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DTO;

import java.util.Date;

/**
 *
 * @author ACER NITRO5
 */
public class KhuyenMaiDTO {
    private String maKM, tenKM;
    private Date ngayBD, ngayKT;
    private double giamGia;

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public Date getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(Date ngayBD) {
        this.ngayBD = ngayBD;
    }

    public Date getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(Date ngayKT) {
        this.ngayKT = ngayKT;
    }

    public double getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(double giamGia) {
        this.giamGia = giamGia;
    }

    public KhuyenMaiDTO(String maKM, String tenKM, Date ngayBD, Date ngayKT, double giamGia) {
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.giamGia = giamGia;
    }
    public KhuyenMaiDTO()
    {
        
    }
    public KhuyenMaiDTO(String maKM)
    {
        this.maKM = maKM;
    }
    
    
    
}
