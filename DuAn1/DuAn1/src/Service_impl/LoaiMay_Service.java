package Service_impl;

import Model.LoaiMay_Model;
import Repository_impl.LoaiMay_repos;
import Service.ILoaiMayService;
import ViewModel.LoaiMay_View;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hung duong
 */
public class LoaiMay_Service implements ILoaiMayService{
    
    private LoaiMay_repos repos;

    public LoaiMay_Service() {
        this.repos = new LoaiMay_repos();
    }
    
    @Override
    public List<LoaiMay_View> getAllLMay() {
        List<LoaiMay_Model> list = repos.getAllLMay();
        List<LoaiMay_View> view = new ArrayList<>();
        view.clear();
        int stt = 1;
        for (LoaiMay_Model x : list) {
            view.add(new LoaiMay_View(stt, x.getTen(), x.getDonGia()));
            stt++;
        }
        return view;
    }

    @Override
    public LoaiMay_Model getAllMayByMa(String ma) {
        return repos.getAllMayByMa(ma);
    }

    @Override
    public LoaiMay_Model getLMayByMa(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int add(LoaiMay_Model lm) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(LoaiMay_Model lm) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(LoaiMay_Model lm) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
