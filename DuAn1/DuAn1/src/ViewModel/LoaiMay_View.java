package ViewModel;

/**
 *
 * @author hung duong
 */
public class LoaiMay_View {

    private String id;
    private int stt;
    private String tenLoaiMay;
    private float dongGia;

    public LoaiMay_View() {
    }

    public LoaiMay_View(String id, int stt, String tenLoaiMay, float dongGia) {
        this.id = id;
        this.stt = stt;
        this.tenLoaiMay = tenLoaiMay;
        this.dongGia = dongGia;
    }

    public LoaiMay_View(int stt, String tenLoaiMay, float dongGia) {
        this.stt = stt;
        this.tenLoaiMay = tenLoaiMay;
        this.dongGia = dongGia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getTenLoaiMay() {
        return tenLoaiMay;
    }

    public void setTenLoaiMay(String tenLoaiMay) {
        this.tenLoaiMay = tenLoaiMay;
    }

    public float getDongGia() {
        return dongGia;
    }

    public void setDongGia(float dongGia) {
        this.dongGia = dongGia;
    }

    @Override
    public String toString() {
        return tenLoaiMay;
    }

    
   
}
