/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DTO;

/**
 *
 * @author ACER
 */
public class TacGiaDTO {
    private String MaTG;
    private String TenTG;
    private String DiaChiTG;
    private String SoDT;
    private String EmailTG;

    public String getMaTG() {
        return MaTG;
    }

    public void setMaTG(String MaTG) {
        this.MaTG = MaTG;
    }

    public String getTenTG() {
        return TenTG;
    }

    public void setTenTG(String TenTG) {
        this.TenTG = TenTG;
    }

    public String getDiaChiTG() {
        return DiaChiTG;
    }

    public void setDiaChiTG(String DiaChiTG) {
        this.DiaChiTG = DiaChiTG;
    }

    public String getSoDT() {
        return SoDT;
    }

    public void setSoDT(String SoDT) {
        this.SoDT = SoDT;
    }

    public String getEmailTG() {
        return EmailTG;
    }

    public void setEmailTG(String EmailTG) {
        this.EmailTG = EmailTG;
    }

    public TacGiaDTO(String MaTG, String TenTG) {
        this.MaTG = MaTG;
        this.TenTG = TenTG;
    }

    public TacGiaDTO(String MaTG, String TenTG, String DiaChiTG, String SoDT, String EmailTG) {
        this.MaTG = MaTG;
        this.TenTG = TenTG;
        this.DiaChiTG = DiaChiTG;
        this.SoDT = SoDT;
        this.EmailTG = EmailTG;
    }

    @Override
    public String toString() {
        return TenTG.toString();
    }
}
