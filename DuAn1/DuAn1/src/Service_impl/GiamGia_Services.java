package Service_impl;

import Model.GiamGia_Model;
import Repository.IGiamGia_repos;
import Repository_impl.GiamGia_repos;
import Service.IGiamGia_Services;
import ViewModel.GiamGia_View;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hung duong
 */
public class GiamGia_Services implements IGiamGia_Services {

    IGiamGia_repos repos;

    public GiamGia_Services() {
        repos = new GiamGia_repos();
    }

    @Override
    public List<GiamGia_View> getAll() {
        List<GiamGia_Model> list = repos.getAllGG();
        List<GiamGia_View> view = new ArrayList<>();
        view.clear();
        int stt = 1;
        for (GiamGia_Model x : list) {
            view.add(new GiamGia_View(stt, x.getMa(), x.getTen(), x.getNgayBatDau(), x.getNgayKetThuc(), x.getMucGiamGia(), x.getTrangThai()));
            stt++;
        }
        return view;
    }

    @Override
    public GiamGia_Model getGiamGiaByMa(String ma) {
        return repos.getAllGGByMa(ma);
    }

    @Override
    public List<GiamGia_View> findGG(String keyWord) {
        List<GiamGia_Model> list = repos.findGG(keyWord);
        List<GiamGia_View> view = new ArrayList<>();
        view.clear();
        int stt = 1;
        for (GiamGia_Model x : list) {
            view.add(new GiamGia_View(stt, x.getMa(), x.getTen(), x.getNgayBatDau(), x.getNgayKetThuc(), x.getMucGiamGia(), x.getTrangThai()));
            stt++;
        }
        return view;
    }

    @Override
    public int add(GiamGia_Model gg) {
        return repos.add(gg);
    }

    @Override
    public int update(GiamGia_Model gg) {
        return repos.update(gg);
    }

    @Override
    public int delete(GiamGia_Model gg) {
        return repos.delete(gg);
    }

}
