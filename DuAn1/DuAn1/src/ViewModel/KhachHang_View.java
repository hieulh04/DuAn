package ViewModel;

import java.util.Date;

/**
 *
 * @author hung duong
 */
public class KhachHang_View {

    private int stt;
    private String ma;
    private String hoTen;
    private Date ngaySinh;
    private int gioiTinh;
    private String diaChi;
    private String sdt;
    private int trangThai;

    public KhachHang_View() {
    }

    public KhachHang_View(int stt, String ma, String hoTen, Date ngaySinh, int gioiTinh, String diaChi, String sdt, int trangThai) {
        this.stt = stt;
        this.ma = ma;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.trangThai = trangThai;
    }
    
    public KhachHang_View(int stt, String ma, String hoTen, int trangThai) {
        this.stt = stt;
        this.ma = ma;
        this.hoTen = hoTen;
        this.trangThai = trangThai;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
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
        return ma;
    }
    public String gettrangthai(){
    if(this.trangThai==0){
        return "Khách mới";
    }else if(this.trangThai==1){
        return "Khách quen";
    }else{
        return "Khach vip";
    }
}

    

}
