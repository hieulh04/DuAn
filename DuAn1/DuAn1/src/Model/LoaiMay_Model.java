package Model;

/**
 *
 * @author hung duong
 */
public class LoaiMay_Model {

    private String id;
    private String ten;
    private float donGia;

    public LoaiMay_Model() {
    }

    public LoaiMay_Model(String id, String ten, float donGia) {
        this.id = id;
        this.ten = ten;
        this.donGia = donGia;
    }

    public LoaiMay_Model(String ten, float donGia) {
        this.ten = ten;
        this.donGia = donGia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return ten;
    }
    
    

}
