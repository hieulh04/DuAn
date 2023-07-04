/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository_impl;

import Repository.IThongKe_Repos;
import Ulti.JDBC_Helper;
import ViewModel.HoaDon_View;
import ViewModel.ThongKeDVModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.*;

/**
 *
 * @author lequy
 */
public class ThongKeDV_Repos implements IThongKe_Repos {

    @Override
    public List<ThongKeDVModel> getAll() {
        List<ThongKeDVModel> list = new ArrayList<>();
        ResultSet rs;
        String sql = "SELECT MaDVCT,SoLuong,GiaBan,ThanhTien,NgayTao FROM DICHVUCHITIET";
        rs = JDBC_Helper.Query(sql);
        try {
            while (rs.next()) {
                String MaHD = rs.getString(1);
                int soluong = rs.getInt(2);
                double giaban = rs.getDouble(3);

                Double ThanhTien = rs.getDouble(4);
                Date ngayTao = rs.getDate(5);

                ThongKeDVModel dv = new ThongKeDVModel(MaHD, soluong, giaban, ThanhTien, ngayTao, "");
                list.add(dv);
            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<ThongKeDVModel> getByNgay(Date date1, Date date2) {
        List<ThongKeDVModel> list = new ArrayList<>();
        ResultSet rs;
        String sql = "SELECT MaDVCT,SoLuong,GiaBan,ThanhTien,NgayTao FROM DICHVUCHITIET WHERE NGAYTAO BETWEEN ? AND ?";
        rs = JDBC_Helper.Query(sql, date1, date2);
        try {
            while (rs.next()) {
                String MaHD = rs.getString(1);
                int soluong = rs.getInt(2);
                double giaban = rs.getDouble(3);

                Double ThanhTien = rs.getDouble(4);
                Date ngayTao = rs.getDate(5);

                ThongKeDVModel dv = new ThongKeDVModel(MaHD, soluong, giaban, ThanhTien, ngayTao, "");
                list.add(dv);
            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<ThongKeDVModel> getTen(Date date1, Date date2) {
        List<ThongKeDVModel> list = new ArrayList<>();
        ResultSet rs;
        String sql = "SELECT TOP 5 TenDV,SUM(DICHVUCHITIET.SOLUONG)AS'TONG' FROM DICHVUCHITIET JOIN DichVu ON DICHVUCHITIET.IdDV = DichVu.ID\n"
                + "WHERE NGAYTAO BETWEEN ? AND ?\n"
                + "GROUP BY DICHVUCHITIET.IdDV,TenDV\n"
                + "ORDER BY [TONG] DESC";
        rs = JDBC_Helper.Query(sql, date1, date2);
        try {
            while (rs.next()) {
                String ten = rs.getString(1);
                int soluong = rs.getInt(2);
                ThongKeDVModel dv = new ThongKeDVModel(soluong, ten);
                list.add(dv);
            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<HoaDon_View> getDoanhthu() {
       List<HoaDon_View> list = new ArrayList<>();
       ResultSet rs;
       String sql="SELECT TOP 10 SUM(TongTien),NgayThanhToan FROM HoaDon\n" +
       "GROUP BY NgayThanhToan";
       rs = JDBC_Helper.Query(sql);
        try {
            while (rs.next()) {                
                double tongtin = rs.getDouble(1);
                Date ngaytt = rs.getDate(2);
                HoaDon_View hd = new HoaDon_View(tongtin, ngaytt);
                list.add(hd);
            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }

}
