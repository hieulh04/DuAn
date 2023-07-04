package Model;

/**
 *
 * @author hungduong
 */
public class May_Model {

    private String id;
    private LoaiMay_Model loaiMay;
    private String MaMay;
    private int TrangThai;

    public May_Model() {
    }

    public May_Model(String id, LoaiMay_Model loaiMay, String MaMay, int TrangThai) {
        this.id = id;
        this.loaiMay = loaiMay;
        this.MaMay = MaMay;
        this.TrangThai = TrangThai;
    }

    public May_Model(LoaiMay_Model loaiMay, String MaMay, int TrangThai) {
        this.id = id;
        this.loaiMay = loaiMay;
        this.MaMay = MaMay;
        this.TrangThai = TrangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LoaiMay_Model getLoaiMay() {
        return loaiMay;
    }

    public void setLoaiMay(LoaiMay_Model loaiMay) {
        this.loaiMay = loaiMay;
    }

    public String getMaMay() {
        return MaMay;
    }

    public void setMaMay(String MaMay) {
        this.MaMay = MaMay;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    @Override
    public String toString() {
        return MaMay;
    }
    
    

}
