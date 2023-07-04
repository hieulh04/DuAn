package Repository;

import Model.KhachHang_Model;
import Model.LoaiMay_Model;
import java.util.List;

/**
 *
 * @author hung duong
 */
public interface ILoaiMay_repos {

    List<LoaiMay_Model> getAllLMay();
    
    LoaiMay_Model getAllMayByMa(String ma);

    LoaiMay_Model getLMayByMa(String ma);

    int add(LoaiMay_Model lm);

    int delete(LoaiMay_Model lm);

    int update(LoaiMay_Model lm);

}
