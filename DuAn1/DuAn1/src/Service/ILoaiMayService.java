/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.LoaiMay_Model;
import ViewModel.LoaiMay_View;
import java.util.List;

/**
 *
 * @author hung duong
 */
public interface ILoaiMayService {
    List<LoaiMay_View> getAllLMay();
    
    LoaiMay_Model getAllMayByMa(String ma);

    LoaiMay_Model getLMayByMa(String ma);

    int add(LoaiMay_Model lm);

    int delete(LoaiMay_Model lm);

    int update(LoaiMay_Model lm);
}
