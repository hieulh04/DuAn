package Service_impl;

import Model.May_Model;
import Repository.IKhachHang_repos;
import Repository.ILoaiMay_repos;
import Repository.IMay_repos;
import Repository_impl.KhachHang_repos;
import Repository_impl.LoaiMay_repos;
import Repository_impl.May_repos;
import Service.IMayService;
import ViewModel.May_View;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hung duong
 */
public class May_Service implements IMayService {

    private IMay_repos repos;
    private ILoaiMay_repos _iLoaiMay_repos;
    private IKhachHang_repos _iKhachHang_repos;
    private List<May_View> ds;

    public May_Service() {
        this.repos = new May_repos();
        this._iKhachHang_repos = new KhachHang_repos();
        this._iLoaiMay_repos = new LoaiMay_repos();
        this.ds = new ArrayList<>();
    }

    @Override
    public List<May_View> getAllMay() {
        List<May_Model> list = repos.getAllMay();
        List<May_View> view = new ArrayList<>();
        view.clear();
        int stt = 1;
        for (May_Model x : list) {
            view.add(new May_View(stt, x.getLoaiMay().getTen(), x.getMaMay(), x.getTrangThai()));
            stt++;
        }
        return view;
    }

    @Override
    public May_Model getMayByMa(String ma) {
        return repos.getMayByMa(ma);
    }

    @Override
    public int add(May_Model m) {
        return repos.add(m);
    }

    @Override
    public int update(May_Model m) {
        return repos.update(m);
    }

    @Override
    public int delete(May_Model m) {
        return repos.delete(m);
    }

    @Override
    public int updateTT(May_Model m) {
        System.out.println(m.getTrangThai());
        return repos.updateKH(m);
    }

    @Override
    public List<May_View> getIdMay() {
        List<May_Model> list = repos.getAllMay();
        List<May_View> view = new ArrayList<>();
        view.clear();
        int stt = 1;
        for (May_Model x : list) {
            view.add(new May_View(stt, x.getLoaiMay().getTen(), x.getMaMay(), x.getTrangThai(), x.getId()));
            stt++;
        }
        return view;
    }

    @Override
    public int doitt(int tt, String maMay) {
        return repos.doitt(tt, maMay);
    }

    @Override
    public List<May_View> getMayFormTT(int tt) {
        List<May_Model> list = repos.getMayFormTT(tt);
        List<May_View> view = new ArrayList<>();
        view.clear();
        int stt = 1;
        for (May_Model x : list) {
            view.add(new May_View(stt, x.getLoaiMay().getTen(), x.getMaMay(), x.getTrangThai()));
            stt++;
        }
        return view;
    }

    @Override
    public List<May_View> getMayFormTenLM(String ten) {
        List<May_Model> list = repos.getMayFormTenLM(ten);
        List<May_View> view = new ArrayList<>();
        view.clear();
        int stt = 1;
        for (May_Model x : list) {
            view.add(new May_View(stt, x.getLoaiMay().getTen(), x.getMaMay(), x.getTrangThai()));
            stt++;
        }
        return view;
    }

    @Override
    public List<May_View> getMayFormTenLMCBB(String ten) {
        List<May_Model> list = repos.getMayFormTenLMCBB(ten);
        List<May_View> view = new ArrayList<>();
        view.clear();
        int stt = 1;
        for (May_Model x : list) {
            view.add(new May_View(stt, x.getLoaiMay().getTen(), x.getMaMay(), x.getTrangThai()));
            stt++;
        }
        return view;
    }

}
