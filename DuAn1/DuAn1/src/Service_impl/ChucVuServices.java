/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service_impl;

import Model.ChucVu_Model;
import Repository.IChucVu_repos;
import Repository_impl.ChucVu_repos;
import Service.IChucVu_Services;
import ViewModel.ChucVuViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lequy
 */
public class ChucVuServices implements IChucVu_Services {

    IChucVu_repos chucvurepos;

    public ChucVuServices() {
        chucvurepos = new ChucVu_repos();
    }

    @Override
    public List<ChucVuViewModel> getALllDV() {
        List<ChucVu_Model> list = chucvurepos.getALllDV();
        List<ChucVuViewModel> view = new ArrayList<>();
        int stt = 1;
        for (ChucVu_Model n : list) {
            view.add(new ChucVuViewModel(stt, n.getMa(), n.getTencv()));
        }

        return view;
    }

    @Override
    public ChucVu_Model getDVByMa(String ma) {
        return chucvurepos.getDVByMa(ma);
    }

}
