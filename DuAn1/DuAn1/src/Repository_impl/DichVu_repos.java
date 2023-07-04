/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository_impl;

import Model.DichVu_Model;
import Repository.IDichVu_repos;
import Ulti.JDBC_Helper;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author LE HUU HIEU
 */
public class DichVu_repos implements IDichVu_repos{

    final String INSERT_SQL = "INSERT INTO [DichVu]([MaDV],[TenDV],[SoLuong],[GiaBan],[DonVi],[DanhMuc]) VALUES(?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE [DichVu] SET [TenDV] =? ,[SoLuong] =? ,[GiaBan] =? ,[DonVi] = ? ,[DanhMuc] =? WHERE [MaDV] = ?";
    final String DELETE_SQL = "DELETE FROM [DichVu] WHERE MaDV = ?";
    final String SELECT_BY_SQL = "SELECT * FROM [DichVu]  WHERE MaDV = ?";
    final String SELECT_BY_SQL_2 = "SELECT * FROM DichVu WHERE TenDV = ?";
    final String SELECT_SQL_ID = "select * from DichVu where id = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM DichVu ORDER BY MaDV ";
    final String SELECT_BY_Ma_hoTen = "SELECT * FROM DichVu WHERE TenDV like CONCAT('%',?, '%') or MaDV like CONCAT('%',?, '%')";
    final String UPDATE_SOLUONG = "UPDATE [dbo].[DichVu]SET [SoLuong] = ? WHERE [Id] = ?";

    @Override
    public List<DichVu_Model> getALllDV() {
        List<DichVu_Model> list = new ArrayList<>();
        ResultSet rs = JDBC_Helper.Query(SELECT_ALL_SQL);
        try {
            while (rs.next()) {
                list.add(new DichVu_Model(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4), rs.getFloat(5), rs.getString(6), rs.getString(7)));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public DichVu_Model getDVByMa(String ma) {
        DichVu_Model dv = null;
        ResultSet rs = JDBC_Helper.Query(SELECT_BY_SQL, ma);
        try {
            while (rs.next()) {
                dv = new DichVu_Model(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5), rs.getString(6), rs.getString(7));
            }
            return dv;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public DichVu_Model getDVByTen(String ten) {
        DichVu_Model dv = null;
        ResultSet rs = JDBC_Helper.Query(SELECT_BY_SQL_2, ten);
        try {
            while (rs.next()) {
                dv = new DichVu_Model(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5), rs.getString(6), rs.getString(7));
            }
            return dv;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public DichVu_Model getDVById(String ten) {
        DichVu_Model dv = null;
        ResultSet rs = JDBC_Helper.Query(SELECT_SQL_ID, ten);
        try {
            while (rs.next()) {
                dv = new DichVu_Model(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5), rs.getString(6), rs.getString(7));
            }
            return dv;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int updateSoLuong(DichVu_Model dv, int soLuong) {
        int SLTon = dv.getSoLuong()- soLuong;
        System.out.println("slm : " + soLuong);
        System.out.println("so luong co : " + dv.getSoLuong());
        System.out.println("so luong ton : " + SLTon);
        
        return JDBC_Helper.Update(UPDATE_SOLUONG, SLTon, dv.getId());
    }

    @Override
    public List<DichVu_Model> findNV(String keyWord) {
        List<DichVu_Model> lst = new ArrayList<>();
        try {
            ResultSet rs = JDBC_Helper.Query(SELECT_BY_Ma_hoTen, keyWord, keyWord);
            while (rs.next()) {
                lst.add(new DichVu_Model(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4), rs.getFloat(5), rs.getString(6), rs.getString(7)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return lst;
    }

    @Override
    public int add(DichVu_Model dv) {
        return JDBC_Helper.Update(INSERT_SQL, dv.getMaDV(), dv.getTenDV(), dv.getSoLuong(), dv.getGiaBan(), dv.getDonVi(), dv.getDanhMuc());
    }

    @Override
    public int delete(DichVu_Model dv) {
        return JDBC_Helper.Update(DELETE_SQL, dv.getMaDV());
    }

    @Override
    public int update(DichVu_Model dv) {
        return JDBC_Helper.Update(UPDATE_SQL, dv.getTenDV(), dv.getSoLuong(), dv.getGiaBan(), dv.getDonVi(), dv.getDanhMuc(), dv.getMaDV());
    }

    @Override
    public int updateSoLuongKhiXoa(DichVu_Model dv, int soLuong) {
        return JDBC_Helper.Update(UPDATE_SOLUONG, soLuong, dv.getId());
    }

}
