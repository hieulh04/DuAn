package Repository_impl;

import Model.LoaiMay_Model;
import Model.May_Model;
import Repository.IMay_repos;
import Ulti.JDBC_Helper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hung duong
 */
public class May_repos implements IMay_repos {

    private List<May_Model> ds;

    public May_repos() {
        this.ds = new ArrayList<>();
    }

    final String INSERT_SQL = "INSERT INTO May (IdLM,MaMay,TrangThai) VALUES (?,?,?)";
    final String UPDATE_SQL = "UPDATE May SET IdLM = ?,TrangThai = ? WHERE MaMay = ?";
    final String UPDATE_SQL_TT = "UPDATE May SET TrangThai = ? WHERE MaMay = ?";
    final String DELETE_SQL = "DELETE FROM May WHERE MaMay = ?";
    final String SELECT_BY_Ma = "SELECT LoaiMay.TenLoaiMay,LoaiMay.DonGiaMay,May.Id,May.IdLM,May.MaMay,May.TrangThai FROM MAY JOIN LoaiMay ON May.IdLM = LoaiMay.Id WHERE MaMay = ? ORDER BY MaMay ";
    final String SELECT_BY_Ma_hoTen = "SELECT * FROM KhachHang WHERE HoTen like CONCAT('%',?, '%') or MaKH like CONCAT('%',?, '%')";
    final String SELECT_ALL_SQL = "SELECT * FROM May ORDER BY MaMay";
    final String SELECT_ALL_SQL_Join = "SELECT LoaiMay.TenLoaiMay,LoaiMay.DonGiaMay,May.Id,May.IdLM,May.MaMay,May.TrangThai FROM MAY JOIN LoaiMay ON May.IdLM = LoaiMay.Id ORDER BY May.TrangThai DESC";
    final String SELECT_ALL_SQL_BY_TT = "SELECT LoaiMay.TenLoaiMay,LoaiMay.DonGiaMay,May.Id,May.IdLM,May.MaMay,May.TrangThai FROM MAY JOIN LoaiMay ON May.IdLM = LoaiMay.Id WHERE May.TrangThai = ? ORDER BY MaMay";
    final String SELECT_ALL_SQL_BY_LM = "SELECT LoaiMay.TenLoaiMay,LoaiMay.DonGiaMay,May.Id,May.IdLM,May.MaMay,May.TrangThai FROM MAY JOIN LoaiMay ON May.IdLM = LoaiMay.Id WHERE MaMay = ? ORDER BY MaMay";
    final String SELECT_ALL_SQL_BY_LMCBB = "SELECT LoaiMay.TenLoaiMay,LoaiMay.DonGiaMay,May.Id,May.IdLM,May.MaMay,May.TrangThai FROM MAY JOIN LoaiMay ON May.IdLM = LoaiMay.Id WHERE LoaiMay.TenLoaiMay  = ? ORDER BY MaMay";

    @Override
    public List<May_Model> getAllMay() {
        ResultSet rs = JDBC_Helper.Query(SELECT_ALL_SQL_Join);
        try {
            ds.clear();
            while (rs.next()) {
                float dg = rs.getFloat(2);
                LoaiMay_Model lm = new LoaiMay_Model(rs.getString(1), dg);
                this.ds.add(new May_Model(rs.getString(3), lm, rs.getString(5), rs.getInt(6)));
            }
            return ds;
        } catch (SQLException ex) {
            Logger.getLogger(May_repos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public May_Model getMayByMa(String ma) {
        May_Model m = null;
        ResultSet rs = JDBC_Helper.Query(SELECT_BY_Ma, ma);
        try {
            while (rs.next()) {
                float dg = rs.getFloat(2);
                LoaiMay_Model lm = new LoaiMay_Model(rs.getString(1), dg);
                m = new May_Model(rs.getString(3), lm, rs.getString(5), rs.getInt(6));
            }
            return m;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int add(May_Model m) {
        return JDBC_Helper.Update(INSERT_SQL, m.getLoaiMay().getId(), m.getMaMay(), m.getTrangThai());
    }

    @Override
    public int delete(May_Model m) {
        return JDBC_Helper.Update(DELETE_SQL, m.getMaMay());
    }

    @Override
    public int update(May_Model m) {
        return JDBC_Helper.Update(UPDATE_SQL, m.getLoaiMay().getId(), m.getTrangThai(), m.getMaMay());
    }

    @Override
    public int updateKH(May_Model m) {
        return JDBC_Helper.Update(UPDATE_SQL_TT, m.getTrangThai(), m.getMaMay());
    }

    @Override
    public int doitt(int tt, String maMay) {
        return JDBC_Helper.Update(UPDATE_SQL_TT, tt, maMay);
    }

    @Override
    public List<May_Model> getMayFormTT(int tt) {
        ResultSet rs = JDBC_Helper.Query(SELECT_ALL_SQL_BY_TT, tt);
        try {
            ds.clear();
            while (rs.next()) {
                LoaiMay_Model lm = new LoaiMay_Model(rs.getString(1), rs.getFloat(2));
                this.ds.add(new May_Model(rs.getString(3), lm, rs.getString(5), rs.getInt(6)));
            }
            return ds;
        } catch (SQLException ex) {
            Logger.getLogger(May_repos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<May_Model> getMayFormTenLM(String ten) {
        ResultSet rs = JDBC_Helper.Query(SELECT_ALL_SQL_BY_LM, ten);
        try {
            ds.clear();
            while (rs.next()) {
                LoaiMay_Model lm = new LoaiMay_Model(rs.getString(1), rs.getFloat(2));
                this.ds.add(new May_Model(rs.getString(3), lm, rs.getString(5), rs.getInt(6)));
            }
            return ds;
        } catch (SQLException ex) {
            Logger.getLogger(May_repos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<May_Model> getMayFormTenLMCBB(String ten) {
        ResultSet rs = JDBC_Helper.Query(SELECT_ALL_SQL_BY_LMCBB, ten);
        try {
            ds.clear();
            while (rs.next()) {
                LoaiMay_Model lm = new LoaiMay_Model(rs.getString(1), rs.getFloat(2));
                this.ds.add(new May_Model(rs.getString(3), lm, rs.getString(5), rs.getInt(6)));
            }
            return ds;
        } catch (SQLException ex) {
            Logger.getLogger(May_repos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

}
