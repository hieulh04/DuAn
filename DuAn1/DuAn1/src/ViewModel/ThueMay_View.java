package ViewModel;

import java.util.Date;

/**
 *
 * @author hung duong
 */
public class ThueMay_View {

    private int stt;
    private String idMay;
    private String idKH;
    private String maThueMay;
    private String tgBatDau;
    private String tgKetThuc;
    private Date ngayTao;
    private int trangThai;

    public ThueMay_View() {
    }

    public ThueMay_View(int stt, String idMay, String idKH, String maThueMay, String tgBatDau, String tgKetThuc, Date ngayTao, int trangThai) {
        this.stt = stt;
        this.idMay = idMay;
        this.idKH = idKH;
        this.maThueMay = maThueMay;
        this.tgBatDau = tgBatDau;
        this.tgKetThuc = tgKetThuc;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public ThueMay_View(int stt, String idMay, String idKH, String maThueMay, String tgBatDau, String tgKetThuc, Date ngayTao) {
        this.stt = stt;
        this.idMay = idMay;
        this.idKH = idKH;
        this.maThueMay = maThueMay;
        this.tgBatDau = tgBatDau;
        this.tgKetThuc = tgKetThuc;
        this.ngayTao = ngayTao;
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

    public String getTgBatDau() {
        return tgBatDau;
    }

    public void setTgBatDau(String tgBatDau) {
        this.tgBatDau = tgBatDau;
    }

    public String getTgKetThuc() {
        return tgKetThuc;
    }

    public void setTgKetThuc(String tgKetThuc) {
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

    @Override
    public String toString() {
        return maThueMay;
    }

    public String hienThiGBD() {
        String a = getTgBatDau();
        String[] b = a.split(" ");
        String c = b[1];
        return c;

    }

    public String hienThiGKT() {
        String a = getTgKetThuc();
        String[] b = a.split(" ");
        String c = b[1];
        return c;

    }

}
