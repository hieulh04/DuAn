package Repository_impl;

import Model.KhachHang_Model;
import Model.May_Model;
import Repository.IKhachHang_repos;
import java.sql.*;
import java.util.List;
import Ulti.JDBC_Helper;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hung duong
 */
public class KhachHang_repos implements IKhachHang_repos {

    private List<KhachHang_Model> ds;

    public KhachHang_repos() {
        this.ds = new ArrayList<>();
    }

    final String INSERT_SQL = "INSERT INTO KhachHang (MaKH,HoTen,NgaySinh, GioiTinh,DiaChi,Sdt) VALUES (?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE KhachHang SET HoTen = ?,NgaySinh = ?, GioiTinh = ?,DiaChi = ?, Sdt = ? WHERE MaKH = ?";
    final String DELETE_SQL = "DELETE FROM KhachHang WHERE MaKH = ?";
    final String SELECT_BY_Ma = "SELECT * FROM KhachHang  WHERE MaKH = ?";
    final String SELECT_BY_Id = "SELECT * FROM KhachHang  WHERE HoTen = ?";
    final String SELECT_BY_Ma_hoTen = "SELECT * FROM KhachHang WHERE HoTen like CONCAT('%',?, '%') or MaKH like CONCAT('%',?, '%')";
    final String SELECT_ALL_SQL = "SELECT * FROM KhachHang ORDER BY MaKH";
    final String SELECT_BY_hoTen = "SELECT * FROM KhachHang WHERE HoTen like CONCAT('%',?, '%')";
    final String SELECT_ALL_SQL_Join = "SELECT TenLoaiMay,DonGiaMay,"
            + "May.Id,May.IdLM,May.MaMay,May.TrangThai,"
            + "KhachHang.Id, KhachHang.IdMay,MaKH, HoTen,NgaySinh,GioiTinh,DiaChi,Sdt "
            + "FROM KhachHang JOIN May ON KhachHang.IdMay = May.Id JOIN LoaiMay ON LoaiMay.Id = May.IdLM ORDER BY MaKH";
    
    final String select_khachmoi = "select MaKH,HoTen,TrangThai from KhachHang where TrangThai=0";
    final String select_khachquen = "select MaKH,HoTen,TrangThai from KhachHang where TrangThai=1";
    final String select_khachTT = "select top 1 MaKH,HoTen,KhachHang.TrangThai from HoaDon\n"
            + "join ThueMay on ThueMay.Id=HoaDon.IdTM\n"
            + "JOIN KhachHang ON ThueMay.IdKH = KhachHang.Id\n"
            + "group by IdKH, MaKH,HoTen,KhachHang.TrangThai\n"
            + "order by sum(HoaDon.TongTien) desc";
    final String update_TT = "  update khachhang set trangthai=1 FROM KhachHang\n"
            + "JOIN ThueMay ON ThueMay.IdKH = KhachHang.Id\n"
            + "WHERE KhachHang.Id IN (\n"
            + "SELECT IdKH FROM ThueMay\n"
            + "GROUP BY IdKH\n"
            + "HAVING COUNT(ThueMay.Id) >=3\n"
            + ")";

    @Override
    public int add(KhachHang_Model d) {
        return JDBC_Helper.Update(INSERT_SQL, d.getMaKH(), d.getHoTen(), d.getNgaySinh(), d.getGioiTinh(), d.getDiaChi(), d.getSdt());
    }

    @Override
    public int delete(KhachHang_Model d) {
        return JDBC_Helper.Update(DELETE_SQL, d.getMaKH());
    }

    @Override
    public int update(KhachHang_Model d) {
        return JDBC_Helper.Update(UPDATE_SQL, d.getHoTen(), d.getNgaySinh(), d.getGioiTinh(), d.getDiaChi(), d.getSdt(), d.getMaKH());
    }

    @Override
    public List<KhachHang_Model> getAllKH() {
        ResultSet rs = JDBC_Helper.Query(SELECT_ALL_SQL);
        ds.clear();
        try {
            while (rs.next()) {
                this.ds.add(new KhachHang_Model(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getInt(5), rs.getString(6), rs.getString(7),rs.getInt(8)));
            }
            return ds;
        } catch (SQLException ex) {
            Logger.getLogger(May_repos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public KhachHang_Model getKHByMa(String ma) {
        KhachHang_Model kh = null;
        ResultSet rs = JDBC_Helper.Query(SELECT_BY_Ma, ma);
        try {
            while (rs.next()) {
                kh = new KhachHang_Model(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getInt(5), rs.getString(6), rs.getString(7),rs.getInt(8));
            }
            return kh;
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public List<KhachHang_Model> findKH(String keyWord) {
        List<KhachHang_Model> lst = new ArrayList<>();
        try {
            ResultSet rs = JDBC_Helper.Query(SELECT_BY_Ma_hoTen, keyWord, keyWord);
            while (rs.next()) {
                lst.add(new KhachHang_Model(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getInt(5), rs.getString(6), rs.getString(7),rs.getInt(8)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return lst;
    }

    @Override
    public String getKhachHangByTen(String hoTen) {
//        List<KhachHang_Model> lst = getSelectSQL(SELECT_BY_hoTen,hoTen);
//        for (KhachHang_Model x : lst) {
//            if (x.get().equals(id)) {
//                return x.getHoTen();
//            }
//        }
        return "";
    }
    @Override
    public List<KhachHang_Model> KhachMoi() {
        ResultSet rs = JDBC_Helper.Query(select_khachmoi);
        ds.clear();
        try {

            while (rs.next()) {
                this.ds.add(new KhachHang_Model(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
            return ds;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<KhachHang_Model> Khachquen() {
        ResultSet rs = JDBC_Helper.Query(select_khachquen);
        ds.clear();
        try {

            while (rs.next()) {
                this.ds.add(new KhachHang_Model(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
            return ds;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<KhachHang_Model> KhachTT() {
        ResultSet rs = JDBC_Helper.Query(select_khachTT);
        ds.clear();
        try {

            while (rs.next()) {
                this.ds.add(new KhachHang_Model(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
            return ds;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public int updateTT(KhachHang_Model d) {
        return JDBC_Helper.Update(update_TT);
    }

}
