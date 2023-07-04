/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import java.util.Date;
import java.sql.*;

/**
 *
 * @author daoqu
 */
public class ThueMay {
     private int stt;
    private String idMay;
    private String maThueMay;
    private int tgBatDau;
    private Time tgKetThuc;
    private Date ngayTao;
    private int trangThai;
    private String idKH;
    private int dem;


    public ThueMay() {
    }


    public ThueMay( int tgBatDau, int dem) {
        this.tgBatDau = tgBatDau;
        this.dem = dem;
    }

    public int getDem() {
        return dem;
    }

    public void setDem(int dem) {
        this.dem = dem;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getIdMay() {
        return idMay;
    }

    public void setIdMay(String idMay) {
        this.idMay = idMay;
    }

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    public String getMaThueMay() {
        return maThueMay;
    }

    public void setMaThueMay(String maThueMay) {
        this.maThueMay = maThueMay;
    }

    public int getTgBatDau() {
        return tgBatDau;
    }

    public void setTgBatDau(int tgBatDau) {
        this.tgBatDau = tgBatDau;
    }

    public Date getTgKetThuc() {
        return tgKetThuc;
    }

    public void setTgKetThuc(Time tgKetThuc) {
        this.tgKetThuc = tgKetThuc;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
}
