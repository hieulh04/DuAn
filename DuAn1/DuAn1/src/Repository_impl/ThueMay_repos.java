package Repository_impl;

import Model.KhachHang_Model;
import Model.LoaiMay_Model;
import Model.May_Model;
import Model.ThueMay_Model;
import Repository.IThueMay_repos;
import Ulti.JDBC_Helper;
import ViewModel.ThueMay;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author hung duong
 */
public class ThueMay_repos implements IThueMay_repos {

    private List<ThueMay_Model> ds;
    private List<ThueMay> ls;
    public ThueMay_repos() {
        this.ds = new ArrayList<>();
        this.ls = new ArrayList<>();
    }

    final String INSERT_SQL = "INSERT INTO ThueMay (IdMay,IdKH,MaThueMay,TG_BatDau,NgayTao) VALUES (?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE ThueMay SET TG_KetThuc = ? WHERE MaThueMay = ?";
    final String UPDATE_SQL_TT = "UPDATE May SET TrangThai = ? WHERE MaMay = ?";
    final String DELETE_SQL = "DELETE FROM May WHERE MaMay = ?";
    final String SELECT_BY_Ma = "SELECT TenLoaiMay,DonGiaMay,KhachHang.MaKH,HoTen,NgaySinh,GioiTinh,DiaChi,Sdt,KhachHang.TrangThai,May.Id,May.IdLM,MaMay,May.TrangThai,ThueMay.Id,ThueMay.IdMay,ThueMay.IdKH,ThueMay.MaThueMay,TG_BatDau,TG_KetThuc,NgayTao,ThueMay.TrangThai FROM ThueMay JOIN May ON ThueMay.IdMay = May.Id JOIN KhachHang ON KhachHang.Id = ThueMay.IdKH JOIN LoaiMay ON LoaiMay.Id = May.IdLM WHERE ThueMay.MaThueMay = ?";
    final String SELECT_BY_Ma_hoTen = "SELECT * FROM KhachHang WHERE HoTen like CONCAT('%',?, '%') or MaKH like CONCAT('%',?, '%')";
    final String SELECT_ALL_SQL = "SELECT * FROM May ORDER BY MaMay";
    final String SELECT_ALL_SQL_Join = "SELECT TenLoaiMay,DonGiaMay,KhachHang.MaKH,HoTen,NgaySinh,GioiTinh,DiaChi,Sdt,KhachHang.TrangThai,May.Id,May.IdLM,MaMay,May.TrangThai,ThueMay.Id,ThueMay.IdMay,ThueMay.IdKH,ThueMay.MaThueMay,TG_BatDau,TG_KetThuc,NgayTao,ThueMay.TrangThai FROM ThueMay JOIN May ON ThueMay.IdMay = May.Id JOIN KhachHang ON KhachHang.Id = ThueMay.IdKH JOIN LoaiMay ON LoaiMay.Id = May.IdLM ORDER BY MaThueMay";
    final String SELECT_ALL_SQL_BYTT = "SELECT TenLoaiMay,DonGiaMay,KhachHang.MaKH,HoTen,NgaySinh,GioiTinh,DiaChi,Sdt,KhachHang.TrangThai,May.Id,May.IdLM,MaMay,May.TrangThai,ThueMay.Id,ThueMay.IdMay,ThueMay.IdKH,ThueMay.MaThueMay,TG_BatDau,TG_KetThuc,NgayTao,ThueMay.TrangThai FROM ThueMay JOIN May ON ThueMay.IdMay = May.Id JOIN KhachHang ON KhachHang.Id = ThueMay.IdKH JOIN LoaiMay ON LoaiMay.Id = May.IdLM WHERE MaMay = ? AND ThueMay.TrangThai = ?  ORDER BY MaThueMay";
    final String UPDATE_SQL_BY_TT = "UPDATE ThueMay SET TrangThai = ? where MaThueMay = ? ";

    final String select_Gio = "SELECT DATEPART(HOUR, TG_BatDau), COUNT(IdKH) FROM ThueMay\n"
            + "GROUP BY DATEPART(HOUR, TG_BatDau)\n"
            + "ORDER BY DATEPART(HOUR, TG_BatDau) ASC";
    final String select_gio_max = "SELECT top 1 DATEPART(HOUR, TG_BatDau), COUNT(IdKH) FROM ThueMay\n"
            + "GROUP BY DATEPART(HOUR, TG_BatDau)\n"
            + "ORDER BY COUNT(IdKH) DESC";

    @Override
    public List<ThueMay_Model> getAllThueMay() {
        ResultSet rs = JDBC_Helper.Query(SELECT_ALL_SQL_Join);
        try {
            ds.clear();
            while (rs.next()) {
                LoaiMay_Model lm = new LoaiMay_Model(rs.getString(1), rs.getFloat(2));
                KhachHang_Model kh = new KhachHang_Model(rs.getString(3), rs.getString(4), rs.getDate(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getInt(9));
                May_Model m = new May_Model(rs.getString(10), lm, rs.getString(12), rs.getInt(13));
                this.ds.add(new ThueMay_Model(rs.getString(14), m, kh, rs.getString(17), rs.getString(18), rs.getString(19), rs.getDate(20), rs.getInt(21)));
            }
            return ds;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ThueMay_Model getThueMayByMa(String ma) {
        ThueMay_Model tm = null;
        ResultSet rs = JDBC_Helper.Query(SELECT_BY_Ma, ma);
        try {
            while (rs.next()) {
                LoaiMay_Model lm = new LoaiMay_Model(rs.getString(1), rs.getFloat(2));
                KhachHang_Model kh = new KhachHang_Model(rs.getString(3), rs.getString(4), rs.getDate(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getInt(9));
                May_Model m = new May_Model(rs.getString(10), lm, rs.getString(12), rs.getInt(13));
                tm = new ThueMay_Model(rs.getString(14), m, kh, rs.getString(17), rs.getString(18), rs.getString(19), rs.getDate(20), rs.getInt(21));
            }
            return tm;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public int add(ThueMay_Model tm) {
        return JDBC_Helper.Update(INSERT_SQL, tm.getIdMay().getId(), tm.getIdKH().getId(), tm.getMaThueMay(), tm.getTgBatDau(), tm.getNgayTao());
    }

    @Override
    public int delete(ThueMay_Model tm) {
        return JDBC_Helper.Update(DELETE_SQL, tm.getMaThueMay());
    }

    @Override
    public int update(ThueMay_Model tm) {
        return JDBC_Helper.Update(UPDATE_SQL, tm.getTgKetThuc(), tm.getMaThueMay());
    }

    @Override
    public ThueMay_Model getMayByTT(String ma, int tt) {
        ThueMay_Model tm = null;
        ResultSet rs = JDBC_Helper.Query(SELECT_ALL_SQL_BYTT, ma, tt);
        try {
            while (rs.next()) {
                LoaiMay_Model lm = new LoaiMay_Model(rs.getString(1), rs.getFloat(2));
                KhachHang_Model kh = new KhachHang_Model(rs.getString(3), rs.getString(4), rs.getDate(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getInt(9));
                May_Model m = new May_Model(rs.getString(10), lm, rs.getString(12), rs.getInt(13));
                tm = new ThueMay_Model(rs.getString(14), m, kh, rs.getString(17), rs.getString(18), rs.getString(19), rs.getDate(20), rs.getInt(21));
            }
            return tm;
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public int updateTT(int tt, String ma) {
        return JDBC_Helper.Update(UPDATE_SQL_BY_TT, tt, ma);
    }

    @Override
    public List<ThueMay> laygio() {

        ResultSet rs = JDBC_Helper.Query(select_Gio);
        ls.clear();
        try {

            while (rs.next()) {
                this.ls.add(new ThueMay(rs.getInt(1), rs.getInt(2)));
            }
            return ls;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        }

    }

    @Override
    public List<ThueMay> laygioMax() {

        ResultSet rs = JDBC_Helper.Query(select_gio_max);
        ls.clear();
        try {

            while (rs.next()) {
                this.ls.add(new ThueMay(rs.getInt(1), rs.getInt(2)));
            }
            return ls;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        }
    }

}
