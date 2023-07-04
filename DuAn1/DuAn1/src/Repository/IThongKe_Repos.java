/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import ViewModel.HoaDon_View;
import ViewModel.ThongKeDVModel;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lequy
 */
public interface IThongKe_Repos {
    List<ThongKeDVModel> getAll();
    List<ThongKeDVModel> getByNgay(Date date1,Date date2);
    List<ThongKeDVModel> getTen(Date date1, Date date2);
    List<HoaDon_View> getDoanhthu();
}
