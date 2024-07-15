/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DTO;

/**
 *
 * @author ACER
 */
public class ChucVuDTO {
    private String maCV;
    private String tenCV;
    private double luong;

    public String getMaCV() {
        return maCV;
    }

    public void setMaCV(String maCV) {
        this.maCV = maCV;
    }

    public String getTenCV() {
        return tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public ChucVuDTO(String maCV, String tenCV, double luong) {
        this.maCV = maCV;
        this.tenCV = tenCV;
        this.luong = luong;
    }

    public ChucVuDTO() {
    }

    public ChucVuDTO(String maCV, String tenCV) {
        this.maCV = maCV;
        this.tenCV = tenCV;
    }

    @Override
    public String toString() {
        return tenCV.toString();
    }
    
    
}
