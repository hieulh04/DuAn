/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service_impl;

import Model.HoaDon_Model;
import Repository_impl.HoaDon_repos;
import Repository_impl.ThongKeDV_Repos;
import Service.IHoaDon_Services;
import ViewModel.HoaDon_View;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LE HUU HIEU
 */
public class HoaDon_Services implements IHoaDon_Services {

    HoaDon_repos repos = new HoaDon_repos();
    ThongKeDV_Repos thongke = new ThongKeDV_Repos();

    @Override
    public int add(HoaDon_Model hd) {
        return repos.add(hd);
    }

    @Override
    public List<HoaDon_View> getTongt() {
        return repos.getTongt();
    }

    @Override
    public List<HoaDon_View> getdoanhthu() {
        return thongke.getDoanhthu();
    }

    @Override
    public List<HoaDon_View> getHoadonAll() {
        List<HoaDon_Model> list = repos.getHoadonAll();
        List<HoaDon_View> view = new ArrayList<>();
        view.clear();
        for (HoaDon_Model x : list) {
            view.add(new HoaDon_View(x.getIdTM().getMaThueMay(), x.getIdGG().getMa(), x.getIdNV().getHoTen(), x.getMaHD(), x.getTongGio(), x.getTienMay(), x.getTienDV(), x.getTongTien(), x.getNgayThanhToan()));
        }
        return view;
    }

    @Override
    public List<HoaDon_View> findHD(String keyWord) {
        List<HoaDon_Model> list = repos.findHD(keyWord);
        List<HoaDon_View> view = new ArrayList<>();
        view.clear();
        for (HoaDon_Model x : list) {
            view.add(new HoaDon_View(x.getIdTM().getMaThueMay(), x.getIdGG().getMa(), x.getIdNV().getHoTen(), x.getMaHD(), x.getTongGio(), x.getTienMay(), x.getTienDV(), x.getTongTien(), x.getNgayThanhToan()));
        }
        return view;
    }
}
