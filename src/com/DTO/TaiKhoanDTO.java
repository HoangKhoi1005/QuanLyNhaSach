/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DTO;

/**
 *
 * @author ACER
 */
public class TaiKhoanDTO {
    private String tenDN;
    private String tenHT;
    private String matKhau;
    private String phanQuyen;
    private String maNV;
    private String anhNV;
    private String tenNV;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }
    
    
    // Constructor không tham số
    public TaiKhoanDTO() {
    }
    
    public TaiKhoanDTO(String tenDN,String matKhau)
    {
        this.tenDN = tenDN;
        this.matKhau = matKhau;
    }

    public TaiKhoanDTO(String tenDN, String matKhau, String anhNV,String maNV) {
        this.tenDN = tenDN;
        this.matKhau = matKhau;
        this.anhNV = anhNV;
        this.maNV = maNV;
    }

    public String getAnhNV() {
        return anhNV;
    }

    public void setAnhNV(String anhNV) {
        this.anhNV = anhNV;
    }

    
    // Constructor với tham số
    public TaiKhoanDTO(String tenDN, String tenHT, String matKhau, String phanQuyen, String maNV, String tenNV, String email) {    
        this.tenDN = tenDN;
        this.tenHT = tenHT;
        this.matKhau = matKhau;
        this.phanQuyen = phanQuyen;
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.email = email;
    }

    // Getter và setter cho tenDN
    public String getTenDN() {
        return tenDN;
    }

    public void setTenDN(String tenDN) {
        this.tenDN = tenDN;
    }

    // Getter và setter cho tenHT
    public String getTenHT() {
        return tenHT;
    }

    public void setTenHT(String tenHT) {
        this.tenHT = tenHT;
    }

    // Getter và setter cho matKhau
    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    // Getter và setter cho phanQuyen
    public String getPhanQuyen() {
        return phanQuyen;
    }

    public void setPhanQuyen(String phanQuyen) {
        this.phanQuyen = phanQuyen;
    }

    // Getter và setter cho maNV
    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }
}
