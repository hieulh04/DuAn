/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import Model.KhachHang_Model;
import java.util.List;

/**
 *
 * @author hung duong
 */
public interface IKhachHang_repos {

    List<KhachHang_Model> getAllKH();

    KhachHang_Model getKHByMa(String ma);

    List<KhachHang_Model> findKH(String keyWord);

    int add(KhachHang_Model k);

    int update(KhachHang_Model k);

    int delete(KhachHang_Model k);

    String getKhachHangByTen(String hoTen);
    
    List<KhachHang_Model> KhachMoi();
    
    List<KhachHang_Model> Khachquen();
    
    List<KhachHang_Model> KhachTT();

    public int updateTT(KhachHang_Model d);
}
