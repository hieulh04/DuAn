package Repository_impl;

import Model.GiamGia_Model;
import Repository.IGiamGia_repos;
import Ulti.JDBC_Helper;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author hung duong
 */
public class GiamGia_repos implements IGiamGia_repos {

    private List<GiamGia_Model> ds;

    public GiamGia_repos() {
        this.ds = new ArrayList<>();
    }

    final String INSERT_SQL = "INSERT INTO GiamGia (Ma,Ten,NgayBatDau,NgayKetThuc,MucGiamGia,TrangThai) VALUES (?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE GiamGia SET Ten = ?,NgayBatDau = ?,NgayKetThuc = ?, MucGiamGia = ?,TrangThai = ? WHERE Ma = ?";
    final String DELETE_SQL = "DELETE FROM GiamGia WHERE Ma = ?";
    final String SELECT_BY_Ma = "SELECT * FROM GiamGia WHERE Ma like CONCAT ('%',?,'%')";
    final String SELECT_BY_Id = "SELECT * FROM GiamGia  WHERE Id = ?";
    final String SELECT_BY_Ma_hoTen = "SELECT * FROM GiamGia WHERE Ma like CONCAT('%',?, '%') or Ten like CONCAT('%',?, '%')";
    final String SELECT_ALL_SQL = "SELECT * FROM GiamGia ORDER BY Ma";

    @Override
    public List<GiamGia_Model> getAllGG() {
        ResultSet rs = JDBC_Helper.Query(SELECT_ALL_SQL);
        try {
            ds.clear();
            while (rs.next()) {
                Integer mucGG = rs.getInt(6);
                this.ds.add(new GiamGia_Model(rs.getString(1), rs.getString(2),rs.getString(3), rs.getDate(4), rs.getDate(5), mucGG, rs.getInt(7)));
            }
            return ds;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public GiamGia_Model getAllGGByMa(String ma) {
        GiamGia_Model gg = null;
        ResultSet rs = JDBC_Helper.Query(SELECT_BY_Ma, ma);
        try {
            while (rs.next()) {
                Integer mucGG = rs.getInt(6);
                gg = new GiamGia_Model(rs.getString(1), rs.getString(2),rs.getString(3), rs.getDate(4), rs.getDate(5), mucGG, rs.getInt(7));
            }
            return gg;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int add(GiamGia_Model lm) {
        return JDBC_Helper.Update(INSERT_SQL, lm.getMa(), lm.getTen(), lm.getNgayBatDau(), lm.getNgayKetThuc(), lm.getMucGiamGia(), lm.getTrangThai());
    }

    @Override
    public int delete(GiamGia_Model lm) {
        return JDBC_Helper.Update(DELETE_SQL, lm.getMa());
    }

    @Override
    public int update(GiamGia_Model lm) {
        return JDBC_Helper.Update(UPDATE_SQL, lm.getTen(), lm.getNgayBatDau(), lm.getNgayKetThuc(), lm.getMucGiamGia(), lm.getTrangThai(), lm.getMa());
    }

    @Override
    public List<GiamGia_Model> findGG(String keyWord) {
        List<GiamGia_Model> lst = new ArrayList<>();
        try {
            ResultSet rs = JDBC_Helper.Query(SELECT_BY_Ma_hoTen, keyWord, keyWord);
            while (rs.next()) {
                Integer mucGG = rs.getInt(6);
                lst.add(new GiamGia_Model(rs.getString(1), rs.getString(2),rs.getString(3), rs.getDate(4), rs.getDate(5), mucGG, rs.getInt(7)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return lst;
    }

}
