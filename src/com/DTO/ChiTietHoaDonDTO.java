/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DTO;

/**
 *
 * @author ACER NITRO5
 */
public class ChiTietHoaDonDTO {
    private String maSach;
    private String maHD;
    private int giaBan;

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public ChiTietHoaDonDTO(String maSach, String maHD, int giaBan, int soLuong, int tongTien) {
        this.maSach = maSach;
        this.maHD = maHD;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
    }
    
    public ChiTietHoaDonDTO()
    {
        
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }
    private int soLuong;
    private int tongTien;
    @Override
    public String toString() {
        return maHD.toString();
    }
}
