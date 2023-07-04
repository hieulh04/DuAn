/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author daoqu
 */
public class NhanVien_Model {

    private String id;
    private ChucVu_Model idcv;
    private String tenTK_NV;
    private String MatKhauNV;
    private String HoTen;
    private Date NgaySinh;
    private int GioiTinh;
    private String Diachi;
    private String sdt;
    private float luong;
    private int TrangThai;

    public NhanVien_Model() {
    }

    public NhanVien_Model(String id, ChucVu_Model idcv, String tenTK_NV, String MatKhauNV, String HoTen, Date NgaySinh, int GioiTinh, String Diachi, String sdt, float luong,int TrangThai) {
        this.id = id;
        this.idcv = idcv;
        this.tenTK_NV = tenTK_NV;
        this.MatKhauNV = MatKhauNV;
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.Diachi = Diachi;
        this.sdt = sdt;
        this.luong = luong;
        this.TrangThai = TrangThai;
    }

    public NhanVien_Model(ChucVu_Model idcv, String tenTK_NV, String MatKhauNV, String HoTen, Date NgaySinh, int GioiTinh, String Diachi, String sdt, float luong, int TrangThai) {
        this.idcv = idcv;
        this.tenTK_NV = tenTK_NV;
        this.MatKhauNV = MatKhauNV;
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.Diachi = Diachi;
        this.sdt = sdt;
        this.luong = luong;
        this.TrangThai = TrangThai;
    }

    public NhanVien_Model(String tenTK_NV, String MatKhauNV, ChucVu_Model idcv) {

        this.tenTK_NV = tenTK_NV;
        this.MatKhauNV = MatKhauNV;
        this.idcv = idcv;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ChucVu_Model getIdcv() {
        return idcv;
    }

    public void setIdcv(ChucVu_Model idcv) {
        this.idcv = idcv;
    }

    public String getTenTK_NV() {
        return tenTK_NV;
    }

    public void setTenTK_NV(String tenTK_NV) {
        this.tenTK_NV = tenTK_NV;
    }

    public String getMatKhauNV() {
        return MatKhauNV;
    }

    public void setMatKhauNV(String MatKhauNV) {
        this.MatKhauNV = MatKhauNV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

}
