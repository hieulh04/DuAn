/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import java.util.Date;

/**
 *
 * @author lequy
 */
public class ThongKeDVModel {

    private String maHD;
    private int soluong;
    private double giaban;
    private double ThanhTien;
    private Date NgayTao;
    
    private String tendv;

    public ThongKeDVModel() {
    }

    public ThongKeDVModel(String maHD, int soluong, double giaban, double ThanhTien, Date NgayTao, String tendv) {
        this.maHD = maHD;
        this.soluong = soluong;
        this.giaban = giaban;
        this.ThanhTien = ThanhTien;
        this.NgayTao = NgayTao;
        this.tendv = tendv;
    }
    public ThongKeDVModel(int soluong,String tendv) {
       this.soluong = soluong;
        this.tendv = tendv;
    }
    

   

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getGiaban() {
        return giaban;
    }

    public void setGiaban(double giaban) {
        this.giaban = giaban;
    }

    public double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public String getTendv() {
        return tendv;
    }

    public void setTendv(String tendv) {
        this.tendv = tendv;
    }

   
}
