/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author daoqu
 */
public class DichVu_Model {

    private String id;
    private String MaDV;
    private String TenDV;
    private int SoLuong;
    private float GiaBan;
    private String DonVi;

    private String DanhMuc;

    public DichVu_Model() {
    }

    public DichVu_Model(String id, String MaDV, String TenDV, int SoLuong, float GiaBan, String DonVi, String DanhMuc) {
        this.id = id;
        this.MaDV = MaDV;
        this.TenDV = TenDV;
        this.SoLuong = SoLuong;
        this.GiaBan = GiaBan;
        this.DonVi = DonVi;

        this.DanhMuc = DanhMuc;

    }

    public DichVu_Model(String MaDV, String TenDV, int SoLuong, float GiaBan, String DonVi, String DanhMuc) {
        this.MaDV = MaDV;
        this.TenDV = TenDV;
        this.SoLuong = SoLuong;
        this.GiaBan = GiaBan;
        this.DonVi = DonVi;

        this.DanhMuc = DanhMuc;

    }

    public DichVu_Model(String TenDV, float GiaBan) {
        this.TenDV = TenDV;
        this.GiaBan = GiaBan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
