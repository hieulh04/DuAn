/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import ViewModel.ThongKeDVModel;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lequy
 */
public interface IThongkeDV_Services {
    public List<ThongKeDVModel> getAll();
    public List<ThongKeDVModel> getNgayTao(Date date1,Date date2);
    public List<ThongKeDVModel> getTen(Date date1,Date date2);
}
