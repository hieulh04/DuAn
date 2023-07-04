package Service;

import Model.KhachHang_Model;
import ViewModel.KhachHang_View;
import java.util.List;

/**
 *
 * @author hung duong
 */
public interface IKhachHangService {

    List<KhachHang_View> getALllDM();

    KhachHang_Model getDMByMa(String ma);

    List<KhachHang_View> findKH(String keyWord);

    int add(KhachHang_Model d);

    int delete(KhachHang_Model d);

    int update(KhachHang_Model d);

    String getKhachHangByTen(String ma);

    String getKHByID(String id);
    
    List<KhachHang_View> KhachMoi();
    
    List<KhachHang_View> KhachQuen();
    
    List<KhachHang_View> KhachTT();
    
    int updateTT(KhachHang_Model d);
}
