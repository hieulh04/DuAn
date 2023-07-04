/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author LE HUU HIEU
 */
public class DichVu_View {

    private int STT;
    private String MaDV;
    private String TenDV;
    private int SoLuong;
    private float GiaBan;
    private String DonVi;

    private String DanhMuc;

    public DichVu_View() {
    }

    public DichVu_View(int STT, String MaDV, String TenDV, int SoLuong, float GiaBan, String DonVi, String DanhMuc) {
        this.STT = STT;
        this.MaDV = MaDV;
        this.TenDV = TenDV;
        this.SoLuong = SoLuong;
        this.GiaBan = GiaBan;
        this.DonVi = DonVi;

        this.DanhMuc = DanhMuc;
    }

    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }

    public String getMaDV() {
        return MaDV;
    }

    public void setMaDV(String MaDV) {
        this.MaDV = MaDV;
    }

    public String getTenDV() {
        return TenDV;
    }

    public void setTenDV(String TenDV) {
        this.TenDV = TenDV;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public float getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(float GiaBan) {
        this.GiaBan = GiaBan;
    }

    public String getDonVi() {
        return DonVi;
    }

    public void setDonVi(String DonVi) {
        this.DonVi = DonVi;
    }

    public String getDanhMuc() {
        return DanhMuc;
    }

    public void setDanhMuc(String DanhMuc) {
        this.DanhMuc = DanhMuc;
    }

}
