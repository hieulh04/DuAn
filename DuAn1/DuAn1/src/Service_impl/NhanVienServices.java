/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service_impl;

import Model.NhanVien_Model;
import Repository_impl.NhanVien_repos;
import Service.INhanvien_services;
import ViewModel.NhanVien_View;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lequy
 */
public class NhanVienServices implements INhanvien_services {

    NhanVien_repos repos = new NhanVien_repos();

    @Override
    public List<NhanVien_View> getAll() {
        List<NhanVien_Model> list = repos.getALllNV();
        List<NhanVien_View> view = new ArrayList<>();
        int stt = 1;
        for (NhanVien_Model n : list) {
            view.add(new NhanVien_View(stt, n.getIdcv().getTencv(), n.getTenTK_NV(), n.getMatKhauNV(),
                    n.getHoTen(), n.getNgaySinh(), n.getGioiTinh(), n.getDiachi(),
                    n.getSdt(), n.getLuong(), n.getTrangThai()));
            stt++;
        }
        return view;
    }

    @Override
    public int add(NhanVien_Model nv) {
        return repos.add(nv);
    }

    @Override
    public int delete(NhanVien_Model nv) {
        return repos.delete(nv);
    }

    @Override
    public int update(NhanVien_Model nv) {
        return repos.update(nv);
    }

    @Override
    public NhanVien_Model getNVByMa(String ma) {
        return repos.getNVByMa(ma);
    }

    @Override
    public List<NhanVien_View> findNV(String ketWord) {
        List<NhanVien_Model> list = repos.findNV(ketWord);
        List<NhanVien_View> view = new ArrayList<>();
        int stt = 1;
        for (NhanVien_Model n : list) {
            view.add(new NhanVien_View(stt, n.getIdcv().getTencv(), n.getTenTK_NV(), n.getMatKhauNV(),
                    n.getHoTen(), n.getNgaySinh(), n.getGioiTinh(), n.getDiachi(),
                    n.getSdt(), n.getLuong(), n.getTrangThai()));
            stt++;
        }
        return view;
    }

    @Override
    public boolean checktr(String tk) {
        NhanVien_Model nv = this.repos.getNVByMa(tk);
        if (nv == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public NhanVien_Model getUser(String tk, String mk) {
        return repos.getUser(tk, mk);
    }

    @Override
    public boolean KTUser(String tk,String mk) {
        return repos.KTUser(tk, mk);
    }
}
