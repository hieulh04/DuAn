/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service_impl;

import Model.DichVu_Model;
import Repository_impl.DichVu_repos;
import Service.IDichVu_service;
import ViewModel.DichVu_View;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LE HUU HIEU
 */
public class DichVu_service implements IDichVu_service {

    DichVu_repos repos = new DichVu_repos();

    @Override
    public List<DichVu_View> getALllDV() {
        List<DichVu_Model> lst = repos.getALllDV();
        List<DichVu_View> dv_view = new ArrayList<>();
        int stt = 1;
        for (DichVu_Model x : lst) {
            dv_view.add(new DichVu_View(stt, x.getMaDV(), x.getTenDV(), x.getSoLuong(), x.getGiaBan(), x.getDonVi(), x.getDanhMuc()));
            stt++;
        }
        return dv_view;
    }

    @Override
    public DichVu_Model getDVByMa(String ma) {
        return repos.getDVByMa(ma);
    }

    @Override
    public DichVu_Model getDVByTen(String ten) {
        return repos.getDVByTen(ten);
    }

    @Override
    public DichVu_Model getDVById(String ten) {
        return repos.getDVById(ten);
    }

    @Override
    public int updateSoLuong(DichVu_Model dv, int soLuong) {
        return repos.updateSoLuong(dv, soLuong);
    }

    @Override
    public int updateSoLuongKhiXoa(DichVu_Model dv, int soLuong) {
        return repos.updateSoLuongKhiXoa(dv, soLuong);
    }

    @Override
    public List<DichVu_View> findNV(String keyWord) {
        List<DichVu_Model> list = repos.findNV(keyWord);
        List<DichVu_View> view = new ArrayList<>();
        view.clear();
        int stt = 1;
        for (DichVu_Model x : list) {
            view.add(new DichVu_View(stt, x.getMaDV(), x.getTenDV(), x.getSoLuong(), x.getGiaBan(), x.getDonVi(), x.getDanhMuc()));
            stt++;
        }
        return view;
    }

    @Override
    public int add(DichVu_Model dv) {
        return repos.add(dv);
    }

    @Override
    public int delete(DichVu_Model dv) {
        return repos.delete(dv);
    }

    @Override
    public int update(DichVu_Model dv) {
        return repos.update(dv);
    }

}
