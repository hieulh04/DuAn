/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import Model.NhanVien_Model;
import java.util.List;

/**
 *
 * @author hung duong
 */
public interface INhanVien_repos {

    List<NhanVien_Model> getALllNV();

    NhanVien_Model getNVByMa(String ma);

    List<NhanVien_Model> findNV(String keyWord);

    int add(NhanVien_Model nv);

    int delete(NhanVien_Model nv);

    int update(NhanVien_Model nv);
    
    NhanVien_Model getUser(String tk,String mk);
    
    public Boolean KTUser(String tk,String mk);
}
