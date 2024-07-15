/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DTO;

/**
 *
 * @author ACER
 */
public class NhaXuatBanDTO {
    private String MaNXB;
    private String TenNXB;
    private String DiaChiNXB;
    private String SoDT;
    private String EmailNXB;

    public String getMaNXB() {
        return MaNXB;
    }

    public void setMaNXB(String MaNXB) {
        this.MaNXB = MaNXB;
    }

    public String getTenNXB() {
        return TenNXB;
    }

    public void setTenNXB(String TenNXB) {
        this.TenNXB = TenNXB;
    }

    public String getDiaChiNXB() {
        return DiaChiNXB;
    }

    public void setDiaChiNXB(String DiaChiNXB) {
        this.DiaChiNXB = DiaChiNXB;
    }

    public String getSoDT() {
        return SoDT;
    }

    public void setSoDT(String SoDT) {
        this.SoDT = SoDT;
    }

    public String getEmailNXB() {
        return EmailNXB;
    }

    public void setEmailNXB(String EmailNXB) {
        this.EmailNXB = EmailNXB;
    }

    public NhaXuatBanDTO() {
    }

    public NhaXuatBanDTO(String MaNXB, String TenNXB, String DiaChiNXB, String SoDT, String EmailNXB) {
        this.MaNXB = MaNXB;
        this.TenNXB = TenNXB;
        this.DiaChiNXB = DiaChiNXB;
        this.SoDT = SoDT;
        this.EmailNXB = EmailNXB;
    }
    
    public NhaXuatBanDTO(String MaNXB, String TenNXB) {
        this.MaNXB = MaNXB;
        this.TenNXB = TenNXB;
    }
    
    @Override
    public String toString() {
        return TenNXB.toString();
    }
}
