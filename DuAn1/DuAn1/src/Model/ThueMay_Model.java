package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author hung duong
 */
public class ThueMay_Model {

    private String id;
    private May_Model idMay;
    private KhachHang_Model idKH;
    private String maThueMay;
    private String tgBatDau;
    private String tgKetThuc;
    private Date ngayTao;
    private int trangThai;

    public ThueMay_Model() {
    }

    public ThueMay_Model(String id, May_Model idMay, KhachHang_Model idKH, String maThueMay, String tgBatDau, String tgKetThuc, Date ngayTao, int trangThai) {
        this.id = id;
        this.idMay = idMay;
        this.idKH = idKH;
        this.maThueMay = maThueMay;
        this.tgBatDau = tgBatDau;
        this.tgKetThuc = tgKetThuc;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public ThueMay_Model(May_Model idMay, KhachHang_Model idKH, String maThueMay, String tgBatDau, String tgKetThuc, Date ngayTao, int trangThai) {
        this.idMay = idMay;
        this.idKH = idKH;
        this.maThueMay = maThueMay;
        this.tgBatDau = tgBatDau;
        this.tgKetThuc = tgKetThuc;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public ThueMay_Model(May_Model idMay, KhachHang_Model idKH, String maThueMay, String tgBatDau, Date ngayTao) {
        this.idMay = idMay;
        this.idKH = idKH;
        this.maThueMay = maThueMay;
        this.tgBatDau = tgBatDau;
        this.ngayTao = ngayTao;
    }

    public ThueMay_Model(String maThueMay, String tgKetThuc) {
        this.maThueMay = maThueMay;
        this.tgKetThuc = tgKetThuc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public May_Model getIdMay() {
        return idMay;
    }

    public void setIdMay(May_Model idMay) {
        this.idMay = idMay;
    }

    public KhachHang_Model getIdKH() {
        return idKH;
    }

    public void setIdKH(KhachHang_Model idKH) {
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



}
