package Service;

import Model.ThueMay_Model;
import ViewModel.ThueMay;
import ViewModel.ThueMay_View;
import java.util.List;

/**
 *
 * @author hung duong
 */
public interface IThueMay_Services {

    List<ThueMay_View> getAllThueMay();

    ThueMay_Model getThueMayByMa(String ma);

    ThueMay_Model getMayByTT(String ma, int tt);

    List<ThueMay> laygio();

    List<ThueMay> laygioMax();

    int add(ThueMay_Model tm);

    int delete(ThueMay_Model tm);

    int update(ThueMay_Model tm);

    int updateTT(int tt, String ma);
}
