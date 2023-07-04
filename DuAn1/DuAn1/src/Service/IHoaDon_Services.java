/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.HoaDon_Model;
import ViewModel.HoaDon_View;
import java.util.List;

/**
 *
 * @author LE HUU HIEU
 */
public interface IHoaDon_Services {
    int add(HoaDon_Model hd);
    
    public List<HoaDon_View> getTongt();
   
     public List<HoaDon_View> getdoanhthu();
     
    public List<HoaDon_View> getHoadonAll();
    
     List<HoaDon_View> findHD(String keyWord);
     
    
    
}
