/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DTO;

/**
 *
 * @author ACER
 */
public class NhanVienDTO {
    private String maNV;
    private String maCV;
    private String hoTenNV;
    private String diaChiNV;
    private String soDT;
    private String emailNV;
    private String anhNV;
    private int trangThai;

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    // Constructor không tham số
    public NhanVienDTO() {
    }

    // Constructor với tham số
    public NhanVienDTO(String maNV, String maCV, String hoTenNV, String diaChiNV, String soDT, String emailNV, String anhNV, int trangThai) {
        this.maNV = maNV;
        this.maCV = maCV;
        this.hoTenNV = hoTenNV;
        this.diaChiNV = diaChiNV;
        this.soDT = soDT;
        this.emailNV = emailNV;
        this.anhNV = anhNV;
        this.trangThai = trangThai;
    }

    // Getter và setter cho maNV
    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    // Getter và setter cho maCV
    public String getMaCV() {
        return maCV;
    }

    public void setMaCV(String maCV) {
        this.maCV = maCV;
    }

    // Getter và setter cho hoTenNV
    public String getHoTenNV() {
        return hoTenNV;
    }

    public void setHoTenNV(String hoTenNV) {
        this.hoTenNV = hoTenNV;
    }

    // Getter và setter cho diaChiNV
    public String getDiaChiNV() {
        return diaChiNV;
    }

    public void setDiaChiNV(String diaChiNV) {
        this.diaChiNV = diaChiNV;
    }

    // Getter và setter cho soDT
    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    // Getter và setter cho emailNV
    public String getEmailNV() {
        return emailNV;
    }

    public void setEmailNV(String emailNV) {
        this.emailNV = emailNV;
    }

    // Getter và setter cho anhNV
    public String getAnhNV() {
        return anhNV;
    }

    public void setAnhNV(String anhNV) {
        this.anhNV = anhNV;
    }

    public NhanVienDTO(String maNV, String hoTenNV) {
        this.maNV = maNV;
        this.hoTenNV = hoTenNV;
    }

    @Override
    public String toString() {
        return hoTenNV.toString();
    }
    
    
}
