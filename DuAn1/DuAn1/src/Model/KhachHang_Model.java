package Model;

import java.util.Date;

/**
 *
 * @author daoqu
 */
public class KhachHang_Model {

    private String id;
    private String MaKH;
    private String HoTen;
    private Date ngaySinh;
    private int gioiTinh;
    private String diaChi;
    private String sdt;
    private int trangThai;

    public KhachHang_Model() {
    }

    public KhachHang_Model(String id, String MaKH, String HoTen, Date ngaySinh, int gioiTinh, String diaChi, String sdt, int trangThai) {
        this.id = id;
        this.MaKH = MaKH;
        this.HoTen = HoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.trangThai = trangThai;
    }

    public KhachHang_Model(String MaKH, String HoTen, Date ngaySinh, int gioiTinh, String diaChi, String sdt, int trangThai) {
        this.MaKH = MaKH;
        this.HoTen = HoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.trangThai = trangThai;
    }
    
    public KhachHang_Model(String MaKH, String HoTen, int trangThai) {
        this.MaKH = MaKH;
        this.HoTen = HoTen;
        this.trangThai = trangThai;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return MaKH;
    }

}
