package Service;

import Model.May_Model;
import ViewModel.May_View;
import java.util.List;

/**
 *
 * @author hung duong
 */
public interface IMayService {

    List<May_View> getAllMay();
    
    List<May_View> getIdMay();

    May_Model getMayByMa(String ma);

    int add(May_Model m);

    int update(May_Model m);

    int delete(May_Model m);
    
    int updateTT(May_Model m);
    
    public int doitt(int tt, String maMay);
    
    List<May_View> getMayFormTT(int tt);
    
    List<May_View> getMayFormTenLM(String ten);
    
    List<May_View> getMayFormTenLMCBB(String ten);
}
