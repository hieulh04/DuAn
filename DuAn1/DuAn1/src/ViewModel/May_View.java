package ViewModel;

/**
 *
 * @author hung duong
 */
public class May_View {

    private int stt;
    private String loaiMay;
    private String MaMay;
    private int TrangThai;
    private String id;

    public May_View() {
    }

    public May_View(int stt, String loaiMay, String MaMay, int TrangThai, String id) {
        this.stt = stt;
        this.loaiMay = loaiMay;
        this.MaMay = MaMay;
        this.TrangThai = TrangThai;
        this.id = id;
    }

    public May_View(int stt, String loaiMay, String MaMay, int TrangThai) {
        this.stt = stt;
        this.loaiMay = loaiMay;
        this.MaMay = MaMay;
        this.TrangThai = TrangThai;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getLoaiMay() {
        return loaiMay;
    }

    public void setLoaiMay(String loaiMay) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return MaMay;
    }

    
    

}
