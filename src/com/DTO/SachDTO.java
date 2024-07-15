package com.DTO;

import java.util.Date;

public class SachDTO {
    private String maSach;
    private String maNXB;
    private String maTL;
    private String tenSach;
    private String maTG;
    private Date ngayXuatBan;
    private Double giaBan;
    private int soLuongTon;
    private String anhSach;
    private int trangThai;
    public SachDTO(){
        
    }
    // Constructor
    public SachDTO(String maSach, String maNXB, String maTL, String tenSach, 
                   String maTG, Date ngayXuatBan, Double giaBan, int soLuongTon, 
                   String anhSach,int trangThai) {
        this.maSach = maSach;
        this.maNXB = maNXB;
        this.maTL = maTL;
        this.tenSach = tenSach;
        this.maTG = maTG;
        this.ngayXuatBan = ngayXuatBan;
        this.giaBan = giaBan;
        this.soLuongTon = soLuongTon;
        this.anhSach = anhSach;
        this.trangThai = trangThai;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    // Getters and Setters
    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getMaNXB() {
        return maNXB;
    }

    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }

    public String getMaTL() {
        return maTL;
    }

    public void setMaTL(String maTL) {
        this.maTL = maTL;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getMaTG() {
        return maTG;
    }

    public void setMaTG(String maTG) {
        this.maTG = maTG;
    }

    public Date getNgayXuatBan() {
        return ngayXuatBan;
    }

    public void setNgayXuatBan(Date ngayXuatBan) {
        this.ngayXuatBan = ngayXuatBan;
    }

    public Double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public String getAnhSach() {
        return anhSach;
    }

    public void setAnhSach(String anhSach) {
        this.anhSach = anhSach;
    }

    public SachDTO(String maSach, String tenSach) {
        this.maSach = maSach;
        this.tenSach = tenSach;
    }

    @Override
    public String toString() {
        return tenSach.toString();
    }
    
}
