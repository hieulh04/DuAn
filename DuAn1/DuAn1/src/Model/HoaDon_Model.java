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
public class HoaDon_Model {
    private String id;
    private ThueMay_Model idTM;
    private GiamGia_Model idGG;
    private NhanVien_Model idNV;
    private String maHD;
    private int tongGio;
    private double tienMay;
    private double tienDV;
    private double tongTien;
    private Date ngayThanhToan;

    public HoaDon_Model() {
    }

    public HoaDon_Model(String id, ThueMay_Model idTM, GiamGia_Model idGG, NhanVien_Model idNV, String maHD, int tongGio, double tienMay, double tienDV, double tongTien, Date ngayThanhToan) {
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

    public HoaDon_Model( ThueMay_Model idTM, GiamGia_Model idGG, NhanVien_Model idNV, String maHD, int tongGio, double tienMay, double tienDV, double tongTien, Date ngayThanhToan) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ThueMay_Model getIdTM() {
        return idTM;
    }

    public void setIdTM(ThueMay_Model idTM) {
        this.idTM = idTM;
    }

    public GiamGia_Model getIdGG() {
        return idGG;
    }

    public void setIdGG(GiamGia_Model idGG) {
        this.idGG = idGG;
    }

    public NhanVien_Model getIdNV() {
        return idNV;
    }

    public void setIdNV(NhanVien_Model idNV) {
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
