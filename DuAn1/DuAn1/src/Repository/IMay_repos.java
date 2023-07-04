/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import Model.May_Model;
import java.util.List;

/**
 *
 * @author hung duong
 */
public interface IMay_repos {

    List<May_Model> getAllMay();

    May_Model getMayByMa(String ma);

    int add(May_Model m);

    int delete(May_Model m);

    int update(May_Model m);

    int updateKH(May_Model m);

    public int doitt(int tt, String maMay);

    List<May_Model> getMayFormTT(int tt);

    List<May_Model> getMayFormTenLM(String ten);

    List<May_Model> getMayFormTenLMCBB(String ten);
}
