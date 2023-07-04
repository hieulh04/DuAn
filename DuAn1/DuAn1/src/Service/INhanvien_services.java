/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.NhanVien_Model;
import ViewModel.NhanVien_View;
import java.util.List;

/**
 *
 * @author lequy
 */
public interface INhanvien_services {
    List<NhanVien_View> getAll();
    int add(NhanVien_Model nv);
    int delete(NhanVien_Model nv);
    int update(NhanVien_Model nv);
    NhanVien_Model getNVByMa(String ma);
    List<NhanVien_View> findNV(String ketWord);
    public boolean checktr(String tk);
    NhanVien_Model getUser(String tk,String mk);
    public boolean KTUser(String tk,String mk);
}
