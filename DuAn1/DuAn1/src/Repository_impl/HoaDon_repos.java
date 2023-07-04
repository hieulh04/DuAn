/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository_impl;

import Model.ChucVu_Model;
import Model.GiamGia_Model;
import Model.HoaDon_Model;
import Model.KhachHang_Model;
import Model.LoaiMay_Model;
import Model.May_Model;
import Model.NhanVien_Model;
import Model.ThueMay_Model;
import Repository.IHoaDon_repos;
import Ulti.JDBC_Helper;
import ViewModel.HoaDon_View;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author LE HUU HIEU
 */
public class HoaDon_repos implements IHoaDon_repos {

    private List<HoaDon_Model> ds;

    public HoaDon_repos() {
        ds = new ArrayList<>();
    }
    String INSERT_SQL = "INSERT INTO [dbo].[HoaDon]([IdTM],[IdGG],[IdNV],[MaHD],[TongGio],[TienMay],[TienDV],[TongTien],[NgayThanhToan])VALUES(?,?,?,?,?,?,?,?,?)";
    String SELECT_BY_MONTH = "SELECT TONGTIEN FROM HOADON WHERE MONTH(NGAYTHANHTOAN) = ?";
    String SELECT_ALL = "SELECT GiamGia.Ma , GiamGia.Ten , GiamGia.NgayBatDau, GiamGia.NgayKetThuc, GiamGia.MucGiamGia, GiamGia.TrangThai,\n"
            + "ChucVu.Ma ,ChucVu.Ten,\n"
            + "NhanVien.Id,NhanVien.IdCV,NhanVien.TenTK,NhanVien.MatKhau,NhanVien.HoTen,NhanVien.NgaySinh,NhanVien.GioiTinh,NhanVien.DiaChi,NhanVien.Sdt,NhanVien.Luong,NhanVien.TrangThai,\n"
            + "LoaiMay.TenLoaiMay,LoaiMay.DonGiaMay,\n"
            + "May.Id,May.IdLM,May.MaMay,May.TrangThai,\n"
            + "KhachHang.MaKH,KhachHang.HoTen,KhachHang.NgaySinh,KhachHang.GioiTinh,KhachHang.DiaChi,KhachHang.Sdt,KhachHang.TrangThai ,\n"
            + "ThueMay.Id,ThueMay.IdMay,ThueMay.IdKH,ThueMay.MaThueMay,ThueMay.TG_BatDau,ThueMay.TG_KetThuc,ThueMay.NgayTao,ThueMay.TrangThai,\n"
            + "HoaDon.Id,HoaDon.IdTM,HoaDon.IdGG,HoaDon.IdNV,HoaDon.MaHD,HoaDon.TongGio,HoaDon.TienMay,HoaDon.TienDV,HoaDon.TongTien,HoaDon.NgayThanhToan FROM HoaDon\n"
            + "JOIN GiamGia on GiamGia.Id = HoaDon.IdGG\n"
            + "join NhanVien on NhanVien.id = HoaDon.IdNV\n"
            + "join ChucVu on ChucVu.Id = NhanVien.IdCV\n"
            + "join ThueMay on  ThueMay.Id = HoaDon.IdTM\n"
            + "join May on May.id = ThueMay.IdMay\n"
            + "join LoaiMay on LoaiMay.id = May.IdLM\n"
            + "join KhachHang on KhachHang.Id = ThueMay.IdKH";
    String SELECT_ALL_BY_HIEU = "SELECT GiamGia.Ma , GiamGia.Ten , GiamGia.NgayBatDau, GiamGia.NgayKetThuc, GiamGia.MucGiamGia, GiamGia.TrangThai,\n"
            + "ChucVu.Ma ,ChucVu.Ten,\n"
            + "NhanVien.Id,NhanVien.IdCV,NhanVien.TenTK,NhanVien.MatKhau,NhanVien.HoTen,NhanVien.NgaySinh,NhanVien.GioiTinh,NhanVien.DiaChi,NhanVien.Sdt,NhanVien.Luong,NhanVien.TrangThai,\n"
            + "LoaiMay.TenLoaiMay,LoaiMay.DonGiaMay,\n"
            + "May.Id,May.IdLM,May.MaMay,May.TrangThai,\n"
            + "KhachHang.MaKH,KhachHang.HoTen,KhachHang.NgaySinh,KhachHang.GioiTinh,KhachHang.DiaChi,KhachHang.Sdt,KhachHang.TrangThai ,\n"
            + "ThueMay.Id,ThueMay.IdMay,ThueMay.IdKH,ThueMay.MaThueMay,ThueMay.TG_BatDau,ThueMay.TG_KetThuc,ThueMay.NgayTao,ThueMay.TrangThai,\n"
            + "HoaDon.Id,HoaDon.IdTM,HoaDon.IdGG,HoaDon.IdNV,HoaDon.MaHD,HoaDon.TongGio,HoaDon.TienMay,HoaDon.TienDV,HoaDon.TongTien,HoaDon.NgayThanhToan FROM HoaDon\n"
            + "JOIN GiamGia on GiamGia.Id = HoaDon.IdGG\n"
            + "join NhanVien on NhanVien.id = HoaDon.IdNV\n"
            + "join ChucVu on ChucVu.Id = NhanVien.IdCV\n"
            + "join ThueMay on  ThueMay.Id = HoaDon.IdTM\n"
            + "join May on May.id = ThueMay.IdMay\n"
            + "join LoaiMay on LoaiMay.id = May.IdLM\n"
            + "join KhachHang on KhachHang.Id = ThueMay.IdKH WHERE HoaDon.MaHD like CONCAT('%',?, '%') or HoaDon.NgayThanhToan like CONCAT('%',?, '%')";

    @Override
    public int add(HoaDon_Model hd) {
        return JDBC_Helper.Update(INSERT_SQL, hd.getIdTM().getId(), hd.getIdGG().getId(), hd.getIdNV().getId(), hd.getMaHD(), hd.getTongGio(), hd.getTienMay(), hd.getTienDV(), hd.getTongTien(), hd.getNgayThanhToan());
    }

    @Override

    public List<HoaDon_View> getTongt() {
        List<HoaDon_View> list = new ArrayList<>();
        ResultSet rs;
        String sql = "SELECT MAHD,TONGGIO,TIENMAY,TIENDV,TONGTIEN,NGAYTHANHTOAN FROM HOADON";
        rs = JDBC_Helper.Query(sql);
        try {
            while (rs.next()) {
                String mahd = rs.getString(1);
                int tonggio = rs.getInt(2);
                double tienmay = rs.getDouble(3);
                double tiendv = rs.getDouble(4);
                double tongtien = rs.getDouble(5);
                Date ngaythanhtoan = rs.getDate(6);

                HoaDon_View hd = new HoaDon_View(mahd, tonggio, tienmay, tiendv, tongtien, ngaythanhtoan);
                list.add(hd);
            }
            return list;
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<HoaDon_Model> getHoadonAll() {

        ResultSet rs = JDBC_Helper.Query(SELECT_ALL);
        ds.clear();
        try {
            while (rs.next()) {
                int mgg = rs.getInt(5);
                GiamGia_Model gg = new GiamGia_Model(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), mgg, rs.getInt(6));
                ChucVu_Model cv = new ChucVu_Model(rs.getString(7), rs.getString(8));
                NhanVien_Model nv = new NhanVien_Model(rs.getString(9), cv, rs.getString(11), rs.getString(12), rs.getString(13), rs.getDate(14), rs.getInt(15), rs.getString(16), rs.getString(17), rs.getFloat(18), rs.getInt(19));
                LoaiMay_Model lm = new LoaiMay_Model(rs.getString(20), rs.getFloat(21));
                May_Model m = new May_Model(rs.getString(22), lm, rs.getString(24), rs.getInt(25));
                KhachHang_Model kh = new KhachHang_Model(rs.getString(26), rs.getString(27), rs.getDate(28), rs.getInt(29), rs.getString(30), rs.getString(31), rs.getInt(32));
                ThueMay_Model tm = new ThueMay_Model(rs.getString(33), m, kh, rs.getString(36), rs.getString(37), rs.getString(38), rs.getDate(39), rs.getInt(40));
                int tg = rs.getInt(46);
                double tmt = rs.getDouble(47);
                double tdv = rs.getDouble(48);
                double tt = rs.getDouble(49);
//                HoaDon_Model hd = new HoaDon_Model(rs.getString(42), tm, gg, nv, rs.getString(46), tg, tmt, tdv, tt, rs.getDate(51));
                this.ds.add(new HoaDon_Model(rs.getString(41), tm, gg, nv, rs.getString(45), tg, tmt, tdv, tt, rs.getDate(50)));
            }
            return ds;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<HoaDon_Model> findHD(String keyWord) {
        List<HoaDon_Model> lst = new ArrayList<>();
        try {
            ResultSet rs = JDBC_Helper.Query(SELECT_ALL_BY_HIEU, keyWord, keyWord);
            while (rs.next()) {
                int mgg = rs.getInt(5);
                GiamGia_Model gg = new GiamGia_Model(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), mgg, rs.getInt(6));
                ChucVu_Model cv = new ChucVu_Model(rs.getString(7), rs.getString(8));
                NhanVien_Model nv = new NhanVien_Model(rs.getString(9), cv, rs.getString(11), rs.getString(12), rs.getString(13), rs.getDate(14), rs.getInt(15), rs.getString(16), rs.getString(17), rs.getFloat(18), rs.getInt(19));
                LoaiMay_Model lm = new LoaiMay_Model(rs.getString(20), rs.getFloat(21));
                May_Model m = new May_Model(rs.getString(22), lm, rs.getString(24), rs.getInt(25));
                KhachHang_Model kh = new KhachHang_Model(rs.getString(26), rs.getString(27), rs.getDate(28), rs.getInt(29), rs.getString(30), rs.getString(31), rs.getInt(32));
                ThueMay_Model tm = new ThueMay_Model(rs.getString(33), m, kh, rs.getString(36), rs.getString(37), rs.getString(38), rs.getDate(39), rs.getInt(40));
                int tg = rs.getInt(46);
                double tmt = rs.getDouble(47);
                double tdv = rs.getDouble(48);
                double tt = rs.getDouble(49);
//                HoaDon_Model hd = new HoaDon_Model(rs.getString(42), tm, gg, nv, rs.getString(46), tg, tmt, tdv, tt, rs.getDate(51));
                lst.add(new HoaDon_Model(rs.getString(41), tm, gg, nv, rs.getString(45), tg, tmt, tdv, tt, rs.getDate(50)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return lst;
    }

}
