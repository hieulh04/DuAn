/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import Model.HoaDon_Model;
import ViewModel.HoaDon_View;
import java.util.List;

/**
 *
 * @author LE HUU HIEU
 */
public interface IHoaDon_repos {

    int add(HoaDon_Model hd);

    public List<HoaDon_View> getTongt();

    List<HoaDon_Model> getHoadonAll();

    List<HoaDon_Model> findHD(String keyWord);
}
