/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service_impl;

import Model.DichVu_Model;
import Model.HDDichVu_Model;
import Repository_impl.HoaDonDichVu_Repos;

/**
 *
 * @author LE HUU HIEU
 */
public class HDDichVu_service {
    HoaDonDichVu_Repos repos = new HoaDonDichVu_Repos();
    public int add(HDDichVu_Model hddv){
        return repos.add(hddv);
    }
    public int update(HDDichVu_Model hddv){
        return repos.update(hddv);
    }
    public int delete(HDDichVu_Model hddv){
        return repos.delete(hddv);
    }
    public DichVu_Model getDVById(String id){
        return repos.getDVById(id);
    }
}
