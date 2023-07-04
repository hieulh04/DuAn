/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author LE HUU HIEU
 */
public class HDDichVu_Model {
    private String id;
    private String idDV;
    private String idTM;
    private String maHD;
    private int soLuong;
    private double giaBan;
    private double thanhTien;
    private Date ngayTao; 

    public HDDichVu_Model() {
    }

    public HDDichVu_Model(String id, String idDV, String idTM, String maHD, int soLuong, double giaBan, double thanhTien, Date ngayTao) {
        this.id = id;
        this.idDV = idDV;
        this.idTM = idTM;
        this.maHD = maHD;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.thanhTien = thanhTien;
        this.ngayTao = ngayTao;
    }
    
    public HDDichVu_Model( String idDV, String idTM, String maHD, int soLuong, double giaBan, double thanhTien, Date ngayTao) {
        this.idDV = idDV;
        this.idTM = idTM;
        this.maHD = maHD;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.thanhTien = thanhTien;
        this.ngayTao = ngayTao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdDV() {
        return idDV;
    }

    public void setIdDV(String idDV) {
        this.idDV = idDV;
    }

    public String getIdTM() {
        return idTM;
    }

    public void setIdTM(String idTM) {
        this.idTM = idTM;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }
    
    
}
