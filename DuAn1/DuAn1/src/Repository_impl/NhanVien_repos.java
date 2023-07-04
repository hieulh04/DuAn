/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository_impl;

import Model.ChucVu_Model;
import Model.NhanVien_Model;
import Repository.INhanVien_repos;
import Ulti.JDBC_Helper;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author lequy
 */
public class NhanVien_repos implements INhanVien_repos {

    final String INSERT_SQL = "INSERT INTO NhanVien(Idcv,TenTK,MatKhau,HoTen,NgaySinh,GioiTinh,DiaChi,Sdt,Luong,TrangThai)\n"
            + "VALUES (?,?,?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE Nhanvien SET Idcv=? ,MatKhau=?,HoTen=?,NgaySinh=?,GioiTinh=?,DiaChi=?,Sdt=?,Luong=?,TrangThai=? where tentk = ?";
    final String DELETE_SQL = "DELETE FROM KhachHang WHERE MaKH = ?";
    final String SELECT_BY_Ma = "SELECT CHUCVU.MA,CHUCVU.TEN,NHANVIEN.ID,NHANVIEN.IDCV,TenTK,MatKhau,HoTen,NgaySinh,GioiTinh,DiaChi,Sdt,Luong,"
            + "TrangThai FROM NhanVien JOIN ChucVu ON NhanVien.IDCV = CHUCVU.ID  WHERE TenTK = ? AND MatKhau = ?";
    final String SELECT_BY_Id = "SELECT * FROM KhachHang  WHERE HoTen = ?";
    final String SELECT_BY_Ma_hoTen = "SELECT CHUCVU.MA,CHUCVU.TEN,NHANVIEN.ID,NHANVIEN.IDCV,TenTK,MatKhau,HoTen,NgaySinh,GioiTinh,DiaChi,Sdt,Luong,"
            + "TrangThai FROM NhanVien JOIN ChucVu ON NhanVien.IDCV = CHUCVU.ID  WHERE HoTen like CONCAT('%',?, '%') or TenTK like CONCAT('%',?, '%')";
    final String SELECT_ALL_SQL = "SELECT * FROM KhachHang ORDER BY MaKH";
    final String SELECT_BY_hoTen = "SELECT * FROM KhachHang WHERE HoTen like CONCAT('%',?, '%')";
    final String SELECT_ALL_SQL_Join = "SELECT CHUCVU.MA,CHUCVU.TEN,NHANVIEN.ID,NHANVIEN.IDCV,TenTK,MatKhau,HoTen,"
            + "NgaySinh,GioiTinh,DiaChi,Sdt,Luong,TrangThai FROM NhanVien JOIN ChucVu ON NhanVien.IDCV = CHUCVU.ID";
    
    final String SELECT_BY_tenTK = "SELECT CHUCVU.MA,CHUCVU.TEN,NHANVIEN.ID,NHANVIEN.IDCV,TenTK,MatKhau,HoTen,NgaySinh,GioiTinh,DiaChi,Sdt,Luong,"
            + "TrangThai FROM NhanVien JOIN ChucVu ON NhanVien.IDCV = CHUCVU.ID  WHERE TenTK = ? ";
    final String SELECT_BY_ten = "SELECT CHUCVU.MA,CHUCVU.TEN,NHANVIEN.ID,NHANVIEN.IDCV,TenTK,MatKhau,HoTen,NgaySinh,GioiTinh,DiaChi,Sdt,Luong,"
            + "TrangThai FROM NhanVien JOIN ChucVu ON NhanVien.IDCV = CHUCVU.ID  WHERE HoTen = ? ";
    @Override
    public List<NhanVien_Model> getALllNV() {
        List<NhanVien_Model> list = new ArrayList<>();

        ResultSet rs = JDBC_Helper.Query(SELECT_ALL_SQL_Join);

        try {
            while (rs.next()) {
                ChucVu_Model cv = new ChucVu_Model(rs.getString(1), rs.getString(2));
                NhanVien_Model nv = new NhanVien_Model(rs.getString(3), cv, rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getDate(8), rs.getInt(9), rs.getString(10), rs.getString(11),
                        rs.getFloat(12), rs.getInt(13));
                list.add(nv);
            }
            return list;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public NhanVien_Model getNVByMa(String ma) {
        NhanVien_Model nv = null;

        ResultSet rs = JDBC_Helper.Query(SELECT_BY_ten, ma);
        try {
            while (rs.next()) {
                ChucVu_Model cv = new ChucVu_Model(rs.getString(1), rs.getString(2));
                nv = new NhanVien_Model(rs.getString(3), cv, rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getDate(8), rs.getInt(9), rs.getString(10), rs.getString(11),
                        rs.getFloat(12), rs.getInt(13));

            }
            return nv;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<NhanVien_Model> findNV(String keyWord) {
        List<NhanVien_Model> lst = new ArrayList<>();
        try {
            ResultSet rs = JDBC_Helper.Query(SELECT_BY_Ma_hoTen, keyWord, keyWord);
            while (rs.next()) {
                ChucVu_Model cv = new ChucVu_Model(rs.getString(1), rs.getString(2));
                lst.add(new NhanVien_Model(rs.getString(3), cv, rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getDate(8), rs.getInt(9), rs.getString(10), rs.getString(11), rs.getFloat(12), rs.getInt(13)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return lst;
    }

    @Override
    public int add(NhanVien_Model nv) {
        return JDBC_Helper.Update(INSERT_SQL, nv.getIdcv().getId(), nv.getTenTK_NV(), nv.getMatKhauNV(), nv.getHoTen(), nv.getNgaySinh(), nv.getGioiTinh(), nv.getDiachi(), nv.getSdt(),
                nv.getLuong(), nv.getTrangThai());
    }

    @Override
    public int delete(NhanVien_Model nv) {
        String sql = "DELETE FROM NhanVien WHERE TenTK = ? ";
        return JDBC_Helper.Update(sql, nv.getTenTK_NV());
    }

    @Override
    public int update(NhanVien_Model nv) {
        return JDBC_Helper.Update(UPDATE_SQL, nv.getIdcv().getId(), nv.getMatKhauNV(), nv.getHoTen(), nv.getNgaySinh(), nv.getGioiTinh(), nv.getDiachi(), nv.getSdt(),
                nv.getLuong(), nv.getTrangThai(), nv.getTenTK_NV());

    }

    @Override
    public NhanVien_Model getUser(String tk, String mk) {
            NhanVien_Model nv = null;
        ResultSet rs = JDBC_Helper.Query(SELECT_BY_Ma,tk,mk);

        try {
            while (rs.next()) {
                ChucVu_Model cv = new ChucVu_Model(rs.getString(1), rs.getString(2));
                nv = new NhanVien_Model(rs.getString(3), cv, rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getDate(8), rs.getInt(9), rs.getString(10), rs.getString(11), rs.getFloat(12), rs.getInt(13));
                
            }
          return nv;
        } catch (SQLException e) {
            return null;
            
        }
    }

    @Override
    public Boolean KTUser(String tk, String mk) {
        NhanVien_Model nv = getUser(tk, mk);
        if (nv==null) {
            JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc mật khẩu");
            return false;
        }else{
        return true;
        }
    }

}
