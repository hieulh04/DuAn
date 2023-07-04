package Service_impl;

import Model.May_Model;
import Model.ThueMay_Model;
import Repository.IThueMay_repos;
import Repository_impl.ThueMay_repos;
import Service.IThueMay_Services;
import ViewModel.ThueMay;
import ViewModel.ThueMay_View;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author hung duong
 */
public class ThueMay_Services implements IThueMay_Services {

    IThueMay_repos repos;

    public ThueMay_Services() {
        repos = new ThueMay_repos();
    }

    @Override
    public List<ThueMay_View> getAllThueMay() {
        List<ThueMay_Model> list = repos.getAllThueMay();
        List<ThueMay_View> view = new ArrayList<>();
        view.clear();
        int stt = 1;
        for (ThueMay_Model x : list) {
            view.add(new ThueMay_View(stt, x.getIdMay().getMaMay(), x.getIdKH().getMaKH(), x.getMaThueMay(), x.getTgBatDau(), x.getTgKetThuc(), x.getNgayTao()));
            stt++;
        }
        return view;
    }

    @Override
    public ThueMay_Model getThueMayByMa(String ma) {
        return repos.getThueMayByMa(ma);
    }

    @Override
    public int add(ThueMay_Model tm) {
        return repos.add(tm);
    }

    @Override
    public int delete(ThueMay_Model tm) {
        return repos.delete(tm);
    }

    @Override
    public int update(ThueMay_Model tm) {
        return repos.update(tm);
    }

    @Override
    public ThueMay_Model getMayByTT(String ma, int tt) {
        return repos.getMayByTT(ma, tt);
    }

    @Override
    public int updateTT(int tt, String ma) {
        return repos.updateTT(tt, ma);
    }

    @Override
    public List<ThueMay> laygio() {

        List<ThueMay> list = repos.laygio();
        List<ThueMay> view = new ArrayList<>();
        view.clear();
        int stt = 1;
        for (ThueMay x : list) {
            view.add(new ThueMay( x.getTgBatDau(), x.getDem()));
            stt++;
        }
        return view;
    }

    @Override
    public List<ThueMay> laygioMax() {
        List<ThueMay> list = repos.laygioMax();
        List<ThueMay> view = new ArrayList<>();
        view.clear();
        int stt = 1;
        for (ThueMay x : list) {
            view.add(new ThueMay( x.getTgBatDau(), x.getDem()));
            stt++;
        }
        return view;
    }

}
