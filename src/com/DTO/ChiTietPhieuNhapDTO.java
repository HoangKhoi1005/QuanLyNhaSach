/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DTO;

/**
 *
 * @author ACER
 */
public class ChiTietPhieuNhapDTO {
    private String maSach;
    private String maPhieuNhap;
    private Double giaNhap;
    private int soLuongNhap;
    private Double tongTien;

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public Double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public int getSoLuongNhap() {
        return soLuongNhap;
    }

    public void setSoLuongNhap(int soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public ChiTietPhieuNhapDTO(String maSach, String maPhieuNhap, Double giaNhap, int soLuongNhap, Double tongTien) {
        this.maSach = maSach;
        this.maPhieuNhap = maPhieuNhap;
        this.giaNhap = giaNhap;
        this.soLuongNhap = soLuongNhap;
        this.tongTien = tongTien;
    }

    public ChiTietPhieuNhapDTO() {
    }
    
}
