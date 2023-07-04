/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service_impl;

import Repository_impl.ThongKeDV_Repos;
import Service.IThongkeDV_Services;
import ViewModel.ThongKeDVModel;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lequy
 */
public class ThongKeDV_Services implements IThongkeDV_Services{

    
    ThongKeDV_Repos repos = new ThongKeDV_Repos();
    @Override
    public List<ThongKeDVModel> getAll() {
        return repos.getAll();
    }

    @Override
    public List<ThongKeDVModel> getNgayTao(Date date1, Date date2) {
        return repos.getByNgay(date1, date2);
    }

    @Override
    public List<ThongKeDVModel> getTen(Date date1, Date date2) {
        return repos.getTen(date1, date2);
    }
    
}
