/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import Model.DichVu_Model;
import java.util.List;

/**
 *
 * @author LE HUU HIEU
 */
public interface IDichVu_repos {

    List<DichVu_Model> getALllDV();

    DichVu_Model getDVByMa(String ma);
    
    DichVu_Model getDVByTen(String ten);
    
    DichVu_Model getDVById(String ten);
    
    public int updateSoLuong(DichVu_Model dv,int soLuong);
    
    public int updateSoLuongKhiXoa(DichVu_Model dv,int soLuong);

    List<DichVu_Model> findNV(String keyWord);

    int add(DichVu_Model dv);

    int delete(DichVu_Model dv);

    int update(DichVu_Model dv);
}
