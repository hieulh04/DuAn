/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import java.util.Date;

/**
 *
 * @author LE HUU HIEU
 */
public class HoaDon_View {
    private String id;
    private String idTM;
    private String idGG;
    private String idNV;
    private String maHD;
    private int tongGio;
    private double tienMay;
    private double tienDV;
    private double tongTien;
    private Date ngayThanhToan;

    public HoaDon_View() {
    }

    public HoaDon_View(String id, String idTM, String idGG, String idNV, String maHD, int tongGio, double tienMay, double tienDV, double tongTien, Date ngayThanhToan) {
        this.id = id;
        this.idTM = idTM;
        this.idGG = idGG;
        this.idNV = idNV;
        this.maHD = maHD;
        this.tongGio = tongGio;
        this.tienMay = tienMay;
        this.tienDV = tienDV;
        this.tongTien = tongTien;
        this.ngayThanhToan = ngayThanhToan;
    }

    public HoaDon_View( String idTM, String idGG, String idNV, String maHD, int tongGio, double tienMay, double tienDV, double tongTien, Date ngayThanhToan) {

        this.idTM = idTM;
        this.idGG = idGG;
        this.idNV = idNV;
        this.maHD = maHD;
        this.tongGio = tongGio;
        this.tienMay = tienMay;
        this.tienDV = tienDV;
        this.tongTien = tongTien;
        this.ngayThanhToan = ngayThanhToan;
    }

    public HoaDon_View(double tongTien, Date ngayThanhToan) {
        this.tongTien = tongTien;
        this.ngayThanhToan = ngayThanhToan;
    }

    

    public HoaDon_View(String maHD, int tongGio, double tienMay, double tienDV, double tongTien, Date ngayThanhToan) {
        this.maHD = maHD;
        this.tongGio = tongGio;
        this.tienMay = tienMay;
        this.tienDV = tienDV;
        this.tongTien = tongTien;
        this.ngayThanhToan = ngayThanhToan;
    }

   
    
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdTM() {
        return idTM;
    }

    public void setIdTM(String idTM) {
        this.idTM = idTM;
    }

    public String getIdGG() {
        return idGG;
    }

    public void setIdGG(String idGG) {
        this.idGG = idGG;
    }

    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public int getTongGio() {
        return tongGio;
    }

    public void setTongGio(int tongGio) {
        this.tongGio = tongGio;
    }

    public double getTienMay() {
        return tienMay;
    }

    public void setTienMay(double tienMay) {
        this.tienMay = tienMay;
    }

    public double getTienDV() {
        return tienDV;
    }

    public void setTienDV(double tienDV) {
        this.tienDV = tienDV;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }


    
    
}
