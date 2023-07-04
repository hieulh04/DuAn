/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository_impl;

import Model.DichVu_Model;
import Model.HDDichVu_Model;
import Ulti.JDBC_Helper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LE HUU HIEU
 */
public class HoaDonDichVu_Repos {
//    DichVu_repos dv_repos = new DichVu_repos();
    final String INSERT_SQL = "INSERT INTO [dbo].[DichVuChiTiet]([IdDV],[IdTM],[MaDVCT],[SoLuong],[GiaBan],[ThanhTien],[NgayTao])VALUES(?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE [dbo].[DichVuChiTiet] SET [IdDV] = ?,[IdDV] = ?,[SoLuong] = ?,[GiaBan] = ?,[ThanhTien] = ?,[NgayTao] = ? WHERE [MaDVCT] = ?";
    final String DELETE_SQL = "DELETE FROM [DichVuChiTiet] WHERE MaDVCT = ?";  
    final String SELECT_SQL_ID  = "select * from DichVu where id like '?'";
    final String SELECT_SQL_MA = "SELECT * FROM DichVuChiTiet where MaDVCT like '?'";
    
    public int add(HDDichVu_Model hddv){

        return JDBC_Helper.Update(INSERT_SQL,hddv.getIdDV(),hddv.getIdTM(),hddv.getMaHD(),hddv.getSoLuong(),hddv.getGiaBan(),hddv.getThanhTien(),hddv.getNgayTao());
    } 
    public int update(HDDichVu_Model hddv){
        return JDBC_Helper.Update(UPDATE_SQL,hddv.getIdDV(),hddv.getIdTM(),hddv.getSoLuong(),hddv.getGiaBan(),hddv.getThanhTien(),hddv.getMaHD() );
    }
    public int delete(HDDichVu_Model hddv){
        return JDBC_Helper.Update(DELETE_SQL, hddv.getIdDV());
    }
    public DichVu_Model getDVById(String id){
        DichVu_Model dv = null;
        ResultSet rs = JDBC_Helper.Query(SELECT_SQL_ID,id);
        try {
            while (rs.next()) {                
                dv = new DichVu_Model(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5), rs.getString(6), rs.getString(7));
            }
            return dv;
        } catch (SQLException e) {
            return null;
        }
    }

    public List<HDDichVu_Model> getHDDVByMa(String ma){
        List<HDDichVu_Model> lst = new ArrayList<>();
        ResultSet rs = JDBC_Helper.Query("SELECT * FROM DichVuChiTiet where MaDVCT = ?",ma);
        try {
            while (rs.next()) {                
                lst.add(new HDDichVu_Model(rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getInt(5),rs.getDouble(6),rs.getDouble(7),rs.getDate(8)));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return lst;
    }
}
