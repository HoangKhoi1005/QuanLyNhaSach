/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DTO;

/**
 *
 * @author ACER
 */
public class TheLoaiDTO {
    private String MaTL;
    private String TenTL;
    private String DienGiai;

    public String getMaTL() {
        return MaTL;
    }

    public void setMaTL(String MaTL) {
        this.MaTL = MaTL;
    }

    public String getTenTL() {
        return TenTL;
    }

    public void setTenTL(String TenTL) {
        this.TenTL = TenTL;
    }

    public String getDienGiai() {
        return DienGiai;
    }

    public void setDienGiai(String DienGiai) {
        this.DienGiai = DienGiai;
    }

    public TheLoaiDTO(String MaTL, String TenTL, String DienGiai) {
        this.MaTL = MaTL;
        this.TenTL = TenTL;
        this.DienGiai = DienGiai;
    }

    public TheLoaiDTO(String MaTL, String TenTL) {
        this.MaTL = MaTL;
        this.TenTL = TenTL;
    }

    @Override
    public String toString() {
        return TenTL.toString();
    }
    
}
