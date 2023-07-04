/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import Model.ChucVu_Model;
import java.util.List;

/**
 *
 * @author lequy
 */
public interface IChucVu_repos {
    List<ChucVu_Model> getALllDV();

    ChucVu_Model getDVByMa(String ma);

    List<ChucVu_Model> findNV(String keyWord);

    int add(ChucVu_Model dv);

    int delete(ChucVu_Model dv);

    int update(ChucVu_Model dv);
}
