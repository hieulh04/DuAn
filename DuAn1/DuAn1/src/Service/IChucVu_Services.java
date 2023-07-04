/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.ChucVu_Model;
import ViewModel.ChucVuViewModel;
import java.util.List;

/**
 *
 * @author lequy
 */
public interface IChucVu_Services {
    List<ChucVuViewModel> getALllDV();

    ChucVu_Model getDVByMa(String ma);
}
