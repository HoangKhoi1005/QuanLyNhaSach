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
public class HoaDonDTO {
    private String maHD;
    private String maNV;
    private String maKH;

    public HoaDonDTO(String maHD, String maNV, String maKH, Date ngayLap, String trangthaiDH, int thanhTien) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.maKH = maKH;
        this.ngayLap = ngayLap;
        this.trangthaiDH = trangthaiDH;
        this.thanhTien = thanhTien;
    }    
    public HoaDonDTO()
    {
        
    }
    private Date ngayLap;
    private String trangthaiDH;
    private int thanhTien;

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getTrangthaiDH() {
        return trangthaiDH;
    }

    public void setTrangthaiDH(String trangthaiDH) {
        this.trangthaiDH = trangthaiDH;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }
    public HoaDonDTO(String maHD, String maNV)
    {
        this.maHD = maHD;
        this.maNV = maNV;
    }
    @Override
    public String toString() {
        return maHD.toString();
    }
    
}
