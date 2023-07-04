/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository_impl;

import Model.ChucVu_Model;
import Repository.IChucVu_repos;
import Ulti.JDBC_Helper;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author lequy
 */
public class ChucVu_repos implements IChucVu_repos {

    
    private List<ChucVu_Model> ds;

    public ChucVu_repos() {
        this.ds = new ArrayList<>();
    }
    
    final String INSERT_SQL = "INSERT INTO Chucvu (Ma,Ten) VALUES (?,?)";
    final String UPDATE_SQL = "UPDATE Chucvu SET Ten = ? WHERE Ma = ?";
    final String DELETE_SQL = "DELETE FROM Chucvu WHERE Ma = ?";
    final String SELECT_BY_Ma = "SELECT * FROM LoaiMay WHERE TenLoaiMay like CONCAT ('%',?,'%')";
    final String SELECT_BY_Id = "SELECT * FROM Chucvu  WHERE Ten = ?";
    final String SELECT_BY_Ma_hoTen = "SELECT * FROM LoaiMay WHERE HoTen like CONCAT('%',?, '%') or MaKH like CONCAT('%',?, '%')";
    final String SELECT_ALL_SQL = "SELECT * FROM Chucvu";
    final String SELECT_ALL_SQL_Join_WhereMaMay = "SELECT * FROM MAY JOIN LoaiMay ON May.IdLM = LoaiMay.Id WHERE May.MaMay = ? ";

    @Override
    public List<ChucVu_Model> getALllDV() {
        ResultSet rs = JDBC_Helper.Query(SELECT_ALL_SQL);
        try {
            while (rs.next()) {
              this.ds.add(new ChucVu_Model(rs.getString(1),rs.getString(2),rs.getString(3)));
            }
            return ds;
        } catch (SQLException ex) {
           
            return null;
        }
    }

    @Override
    public ChucVu_Model getDVByMa(String ma) {
        ChucVu_Model lm = null;
        ResultSet rs = JDBC_Helper.Query(SELECT_BY_Id, ma);
        try {
            while (rs.next()) {
              lm = new ChucVu_Model(rs.getString(1), rs.getString(2), rs.getString(3));
            }
            return lm;
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public List<ChucVu_Model> findNV(String keyWord) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int add(ChucVu_Model dv) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(ChucVu_Model dv) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(ChucVu_Model dv) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
