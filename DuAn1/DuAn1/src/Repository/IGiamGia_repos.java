/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import java.util.ArrayList;
import Model.GiamGia_Model;
import java.util.List;

public interface IGiamGia_repos {

    List<GiamGia_Model> getAllGG();

    GiamGia_Model getAllGGByMa(String ma);
    
    List<GiamGia_Model> findGG(String keyWord);

    int add(GiamGia_Model lm);

    int delete(GiamGia_Model lm);

    int update(GiamGia_Model lm);

}
