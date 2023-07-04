package Repository_impl;

import Model.KhachHang_Model;
import Model.LoaiMay_Model;
import Repository.ILoaiMay_repos;
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
public class LoaiMay_repos implements ILoaiMay_repos {

    final String INSERT_SQL = "INSERT INTO LoaiMay (Ma,Ten) VALUES (?,?)";
    final String UPDATE_SQL = "UPDATE LoaiMay SET Ten = ? WHERE Ma = ?";
    final String DELETE_SQL = "DELETE FROM LoaiMay WHERE Ma = ?";
    final String SELECT_BY_Ma = "SELECT * FROM LoaiMay WHERE TenLoaiMay like CONCAT ('%',?,'%')";
    final String SELECT_BY_Id = "SELECT * FROM LoaiMay  WHERE Id = ?";
    final String SELECT_BY_Ma_hoTen = "SELECT * FROM LoaiMay WHERE HoTen like CONCAT('%',?, '%') or MaKH like CONCAT('%',?, '%')";
    final String SELECT_ALL_SQL = "SELECT * FROM LoaiMay";
    final String SELECT_ALL_SQL_Join_WhereMaMay = "SELECT * FROM MAY JOIN LoaiMay ON May.IdLM = LoaiMay.Id WHERE May.MaMay = ? ";

    private List<LoaiMay_Model> ds;

    public LoaiMay_repos() {
        this.ds = new ArrayList<>();
    }

    @Override
    public List<LoaiMay_Model> getAllLMay() {
                ResultSet rs = JDBC_Helper.Query(SELECT_ALL_SQL);
        try {
            while (rs.next()) {
                this.ds.add(new LoaiMay_Model(rs.getString(1), rs.getString(2), rs.getFloat(3)));
            }
            return ds;
        } catch (SQLException ex) {
            Logger.getLogger(May_repos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public LoaiMay_Model getLMayByMa(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int add(LoaiMay_Model lm) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(LoaiMay_Model lm) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(LoaiMay_Model lm) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
        @Override
    public LoaiMay_Model getAllMayByMa(String ma) {
        LoaiMay_Model lm = null;
        ResultSet rs = JDBC_Helper.Query(SELECT_BY_Ma, ma);
        try {
            while (rs.next()) {
              lm = new LoaiMay_Model(rs.getString(1), rs.getString(2), rs.getFloat(3));
            }
            return lm;
        } catch (SQLException ex) {
            return null;
        }
    }

 

}
