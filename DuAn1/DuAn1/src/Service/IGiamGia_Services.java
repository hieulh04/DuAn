package Service;

import Model.GiamGia_Model;
import ViewModel.GiamGia_View;
import java.util.List;

/**
 *
 * @author hung duong
 */
public interface IGiamGia_Services {

    List<GiamGia_View> getAll();

    GiamGia_Model getGiamGiaByMa(String ma);

    List<GiamGia_View> findGG(String keyWord);

    public int add(GiamGia_Model gg);

    public int update(GiamGia_Model gg);

    public int delete(GiamGia_Model gg);
}
