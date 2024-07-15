/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DTO;

/**
 *
 * @author ACER NITRO5
 */
public class KhachHangDTO {

    public KhachHangDTO(String maKH, String hoTenKH, String DiaChi, int soDT, String Email) {
        this.maKH = maKH;
        this.hoTenKH = hoTenKH;
        this.DiaChi = DiaChi;
        this.soDT = soDT;
        this.Email = Email;
    }
    public KhachHangDTO()
    {
        
    }
    public KhachHangDTO(String maKH, String hoTenKH)
    {
        this.maKH = maKH;
        this.hoTenKH = hoTenKH;
    }
    private String maKH;
    private String hoTenKH;
    private String DiaChi;
    private int soDT;
    private String Email;

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getHoTenKH() {
        return hoTenKH;
    }

    public void setHoTenKH(String hoTenKH) {
        this.hoTenKH = hoTenKH;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public int getSoDT() {
        return soDT;
    }

    public void setSoDT(int soDT) {
        this.soDT = soDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    @Override
    public String toString() {
        return maKH.toString();
    }
}
