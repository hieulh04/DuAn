package View;

import Model.DichVu_Model;
import Model.GiamGia_Model;
import Model.HDDichVu_Model;
import Model.HoaDon_Model;
import Model.May_Model;
import Model.NhanVien_Model;
import Model.ThueMay_Model;
import Repository_impl.HoaDonDichVu_Repos;
import Service.IDichVu_service;
import Service.IMayService;
import Service.IThueMay_Services;
import Service_impl.DichVu_service;
import Service_impl.GiamGia_Services;
import Service_impl.HDDichVu_service;
import Service_impl.HoaDon_Services;
import Service_impl.May_Service;
import Service_impl.NhanVienServices;
import Service_impl.ThueMay_Services;
import Ulti.JDBC_Helper;
import static View.Frame_ThueMay.maMay;
import ViewModel.DichVu_View;
import ViewModel.GiamGia_View;
import ViewModel.ThueMay_View;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.AEADBadTagException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lequy
 */
public class CTThueMayUI extends javax.swing.JFrame {

    private IThueMay_Services _iThueMay_Services;
    private IMayService _iMayService;
    private List<ThueMay_View> listTM_view;

    private IDichVu_service iDichVu_service;
    private HDDichVu_service iHDDichVu_service;
    private HoaDonDichVu_Repos iHdDichVu_Repos;
    private HoaDon_Services _iHoaDon_Services;
    private GiamGia_Services _iGiamGia_Services;
    private NhanVienServices _iNhanVienServices;

    Locale loc = new Locale("vi", "VN");
    NumberFormat numberFM = NumberFormat.getCurrencyInstance(loc);
    HoaDon1 hoadon = new HoaDon1();

    public CTThueMayUI() {
        initComponents();
        setLocationRelativeTo(null);
        _iThueMay_Services = new ThueMay_Services();
        _iMayService = new May_Service();
        listTM_view = _iThueMay_Services.getAllThueMay();

        iDichVu_service = new DichVu_service();
        iHDDichVu_service = new HDDichVu_service();
        iHdDichVu_Repos = new HoaDonDichVu_Repos();
        _iHoaDon_Services = new HoaDon_Services();
        _iGiamGia_Services = new GiamGia_Services();
        _iNhanVienServices = new NhanVienServices();

        btnThanhToan.setEnabled(false);
    }
    public static String tenNV;

    public void loadTable() {
        ThueMay_Model x = _iThueMay_Services.getMayByTT(maMay, 0);
        DefaultTableModel dtm = (DefaultTableModel) this.tblThueMay.getModel();
        dtm.setRowCount(0);
        Object[] rowData = {
            x.getMaThueMay(),
            x.getIdMay(),
            x.getIdKH(),
            x.getTgBatDau(),
            x.getTgKetThuc(),
            x.getNgayTao()
        };
        dtm.addRow(rowData);

        lblKhachHang.setText(x.getIdKH().getHoTen());

    }

    public void loadTableChon() {

        ArrayList<HDDichVu_Model> lst = (ArrayList<HDDichVu_Model>) iHdDichVu_Repos.getHDDVByMa(tblThueMay.getValueAt(0, 0).toString());
        DefaultTableModel dtm = (DefaultTableModel) this.tblDichVuChon.getModel();
        dtm.setRowCount(0);
        for (HDDichVu_Model x : lst) {
            HDDichVu_Model hddv = (HDDichVu_Model) x;
            DichVu_Model dv = iDichVu_service.getDVById(hddv.getIdDV());
            Object[] rowData = {
                dv.getTenDV(),
                hddv.getSoLuong(),
                hddv.getGiaBan(),
                hddv.getThanhTien()
            };
            dtm.addRow(rowData);
        }
        String tongtien = String.valueOf(TinhTongTien(tblDichVuChon));
        lblTienDV.setText(numberFM.format(TinhTongTien(tblDichVuChon)));
    }
    public static String maMay;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pmnHoaDonDV = new javax.swing.JPopupMenu();
        mniXoaSP = new javax.swing.JMenuItem();
        mniSuaSP = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblTenMay = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        txtTralai = new javax.swing.JTextField();
        rdoCheck = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        txtTongTien = new javax.swing.JTextField();
        lblSoGio = new javax.swing.JLabel();
        lblTienMay = new javax.swing.JLabel();
        lblTienDV = new javax.swing.JLabel();
        lblTenNhanVien = new javax.swing.JLabel();
        btnTamTinh = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        lblGiamGia = new javax.swing.JLabel();
        lblGiamGia1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThueMay = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDichVuChon = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDichVu = new javax.swing.JTable();
        txtTimKiem = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lblMay = new javax.swing.JLabel();
        lblLoaiMay = new javax.swing.JLabel();
        lblDonGia = new javax.swing.JLabel();
        lblKhachHang = new javax.swing.JLabel();

        mniXoaSP.setText(" Xóa sản phẩm");
        mniXoaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniXoaSPActionPerformed(evt);
            }
        });
        pmnHoaDonDV.add(mniXoaSP);

        mniSuaSP.setText("Sửa số lượng ");
        mniSuaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniSuaSPActionPerformed(evt);
            }
        });
        pmnHoaDonDV.add(mniSuaSP);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("THANH TOÁN");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 102, 255));

        lblTenMay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenMay.setForeground(new java.awt.Color(255, 255, 255));
        lblTenMay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenMay.setText("ABC");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(536, 536, 536)
                .addComponent(lblTenMay, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(627, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTenMay)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 102, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Chi tiết thuê máy");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(255, 102, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Thanh toán");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(296, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Số phút:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Tiền máy:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Tiền dịch vụ:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Tổng tiền:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Tiền khách đưa:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Trả lại:");

        txtTienKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKhachDuaKeyReleased(evt);
            }
        });

        rdoCheck.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdoCheck.setForeground(new java.awt.Color(255, 51, 51));
        rdoCheck.setText("Kiểm tra hoàn tất?");
        rdoCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoCheckActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Người tạo:");

        btnThanhToan.setBackground(new java.awt.Color(204, 204, 255));
        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnThanhToan.setText("THANH TOÁN");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        txtTongTien.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTongTienCaretUpdate(evt);
            }
        });
        txtTongTien.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                txtTongTienCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        txtTongTien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTongTienKeyReleased(evt);
            }
        });

        lblSoGio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSoGio.setForeground(new java.awt.Color(51, 51, 255));

        lblTienMay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTienMay.setForeground(new java.awt.Color(51, 51, 255));
        lblTienMay.setText("0.0");

        lblTienDV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTienDV.setForeground(new java.awt.Color(51, 51, 255));
        lblTienDV.setText("0.0");

        btnTamTinh.setBackground(new java.awt.Color(204, 204, 255));
        btnTamTinh.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnTamTinh.setText("TẠM TÍNH");
        btnTamTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTamTinhActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Giảm Giá :");

        lblGiamGia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblGiamGia.setForeground(new java.awt.Color(51, 51, 255));
        lblGiamGia.setText("0-");

        lblGiamGia1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblGiamGia1.setForeground(new java.awt.Color(51, 51, 255));
        lblGiamGia1.setText("%");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(btnTamTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTralai, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(26, 26, 26)
                        .addComponent(lblTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTienDV, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTienMay)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(lblGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblGiamGia1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSoGio, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(rdoCheck))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblSoGio, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblTienMay))
                .addGap(41, 41, 41)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblTienDV))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(lblGiamGia)
                    .addComponent(lblGiamGia1))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTralai, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(rdoCheck)
                .addGap(36, 36, 36)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(lblTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTamTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        tblThueMay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Thuê", "Máy", "Khách Hàng", "TG Bắt đầu", "TG kết thúc", "Ngày tạo"
            }
        ));
        tblThueMay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThueMayMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblThueMay);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Máy:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Loại máy:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Đơn giá giờ:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Khách hàng:");

        jPanel5.setBackground(new java.awt.Color(255, 102, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Dịch vụ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(328, 328, 328))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Dịch vụ sử dụng"));

        tblDichVuChon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TênDV", "Số Lượng", "Gía", "Thành tiền"
            }
        ));
        tblDichVuChon.setComponentPopupMenu(pmnHoaDonDV);
        jScrollPane2.setViewportView(tblDichVuChon);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách dịch vụ"));

        tblDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã dịch vụ", "Tên dịch vụ", "Số lượng ", "Gía"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDichVuMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDichVu);

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("TÌM KIẾM");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lblMay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMay.setText("abc");

        lblLoaiMay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiMay.setText("abc");

        lblDonGia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDonGia.setText("abc");

        lblKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblKhachHang.setText("abc");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(lblMay, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(lblLoaiMay, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83)
                                .addComponent(jLabel3)
                                .addGap(27, 27, 27)
                                .addComponent(lblDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(lblKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(40, 40, 40)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lblMay)
                            .addComponent(jLabel2)
                            .addComponent(lblLoaiMay)
                            .addComponent(jLabel3)
                            .addComponent(lblDonGia))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(lblKhachHang))
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.lblTenMay.setText(maMay);
        May_Model m = _iMayService.getMayByMa(maMay);
        lblDonGia.setText(m.getLoaiMay().getDonGia() + "");
        lblLoaiMay.setText(m.getLoaiMay().getTen() + "");
        lblMay.setText(maMay);
        lblTenNhanVien.setText(tenNV);
        loadTable();
        this.loadTableDichVu();
        this.loadTableChon();
        this.getGiamGia();

    }//GEN-LAST:event_formWindowOpened

    private void tblThueMayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThueMayMouseClicked
        int pos = JOptionPane.showConfirmDialog(this, "Bạn có muốn nhập thời gian kết thúc hay không?", "Message", JOptionPane.YES_NO_OPTION);
        if (pos == JOptionPane.YES_NO_OPTION) {
            String input = JOptionPane.showInputDialog(this, "Mời nhập thời gian kết thúc");
            tblThueMay.setValueAt(input, 0, 4);
            ThueMay_Model tm = this.getThueMay();
            _iThueMay_Services.update(tm);
            JOptionPane.showMessageDialog(this, "Thêm giờ kết thúc thành công");
            lblTienMay.setText(numberFM.format(GetTienMay()));
            txtTongTien.setText(numberFM.format((GetTienMay() + TinhTongTien(tblDichVuChon)) - (GetTienMay() + TinhTongTien(tblDichVuChon)) * (Double.parseDouble(lblGiamGia.getText()) / 100)));
        }

    }//GEN-LAST:event_tblThueMayMouseClicked

    private void tblDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDichVuMouseClicked
        // TODO add your handling code here:
        String input = JOptionPane.showInputDialog(this, "Mời nhập số lượng");

        try {
            int soLuongMua = Integer.parseInt(input);
            int soLuongTon = Integer.parseInt(tblDichVu.getValueAt(tblDichVu.getSelectedRow(), 3).toString());
            if (soLuongMua > soLuongTon) {
                JOptionPane.showMessageDialog(this, "So luong khong du");
                return;
            }
            soLuongTon = soLuongTon - soLuongMua;
            tblDichVu.setValueAt(soLuongTon, tblDichVu.getSelectedRow(), 3);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Loi dinh dang so luong");
        }

        String MaDV = tblDichVu.getValueAt(tblDichVu.getSelectedRow(), 1).toString();
        String tenDV = tblDichVu.getValueAt(tblDichVu.getSelectedRow(), 2).toString();
        System.out.println(MaDV + "âsdada");
        DichVu_Model dv = iDichVu_service.getDVByMa(MaDV);
        boolean chk = false;
        if (tblDichVuChon.getRowCount() > 0) {
            for (int i = 0; i < tblDichVuChon.getRowCount(); i++) {
                String check = tblDichVuChon.getValueAt(i, 0).toString();
                if (tenDV.equals(check)) {
                    int soLuongMuaTruocKhiSua = Integer.parseInt(String.valueOf(tblDichVuChon.getValueAt(i, 1).toString()));

                    int soLuongMuaSauKhiSua = Integer.parseInt(tblDichVuChon.getValueAt(i, 1).toString()) + Integer.parseInt(input);
                    tblDichVuChon.setValueAt(String.valueOf(soLuongMuaSauKhiSua), i, 1);

                    double thanhTien = Double.parseDouble(tblDichVuChon.getValueAt(i, 1).toString()) * Double.parseDouble(tblDichVuChon.getValueAt(i, 2).toString());
                    tblDichVuChon.setValueAt(String.valueOf(thanhTien), i, 3);
                    String tongtien = String.valueOf(TinhTongTien(tblDichVuChon));
                    lblTienDV.setText(numberFM.format(TinhTongTien(tblDichVuChon)));
//            txtTongTien.setText(numberFM.format(getTongTien()));
                    txtTongTien.setText(numberFM.format((GetTienMay() + TinhTongTien(tblDichVuChon)) - (GetTienMay() + TinhTongTien(tblDichVuChon)) * (Double.parseDouble(lblGiamGia.getText()) / 100)));
                    chk = true;
//                if(chk == true){
//                    this.loadDichVuChiTiet(tblDichVuChon, dv, String.valueOf(soLuongMuaSauKhiSua));
//                }
                }
            }
        }
        if (chk == false) {
            this.loadDichVuChiTiet(tblDichVuChon, dv, input);
        }

//        String tenDv = tblDichVu.getValueAt(tblDichVu.getSelectedRow(), 2).toString();
//        for (int i = 0; i < tblDichVuChon.getRowCount(); i++) {
//            String tendvchon = tblDichVuChon.getValueAt(i, 0).toString();
//            if (tenDv.equals(tendvchon)) {
//                int soLuongThem = Integer.parseInt(input);
//                int soLuongCongDon = soLuongThem + Integer.parseInt(tblDichVuChon.getValueAt(i, 1).toString());
//                this.loadDichVuChiTiet(tblDichVuChon, dv, String.valueOf(soLuongCongDon));
//            }
//        }
        String tongtien = String.valueOf(TinhTongTien(tblDichVuChon));
        lblTienDV.setText(numberFM.format(TinhTongTien(tblDichVuChon)));
//            txtTongTien.setText(numberFM.format(getTongTien()));
        txtTongTien.setText(numberFM.format((GetTienMay() + TinhTongTien(tblDichVuChon)) - (GetTienMay() + TinhTongTien(tblDichVuChon)) * (Double.parseDouble(lblGiamGia.getText()) / 100)));
    }//GEN-LAST:event_tblDichVuMouseClicked

    private void mniXoaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniXoaSPActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dtm = (DefaultTableModel) tblDichVuChon.getModel();
        int row = tblDichVuChon.getSelectedRow();
        String tenDVChon = tblDichVuChon.getValueAt(row, 0).toString();

        if (row >= 0) {
            String soLuongXoa = tblDichVuChon.getValueAt(row, 1).toString();

            for (int i = 0; i < tblDichVu.getRowCount(); i++) {
                String check = tblDichVu.getValueAt(i, 2).toString();
                if (tenDVChon.equalsIgnoreCase(check)) {
                    int soLuongKhiXoa = Integer.parseInt(String.valueOf(tblDichVu.getValueAt(i, 3)).toString()) + Integer.parseInt(soLuongXoa);
                    tblDichVu.setValueAt(String.valueOf(soLuongKhiXoa), i, 3);

                    ArrayList<HDDichVu_Model> lst = getData();
                    if (lst == null) {
                        return;
                    }
                    for (HDDichVu_Model x : lst) {
                        //                        iHDDichVu_service.add(x);

                        System.out.println(x.getIdDV());
                        DichVu_Model dv = iDichVu_service.getDVById(x.getIdDV());
                        System.out.println(dv.getTenDV());
                        if (dv.getTenDV().trim().equals(tenDVChon)) {
                            iDichVu_service.updateSoLuongKhiXoa(dv, soLuongKhiXoa);
                        }

                    }
                    dtm.removeRow(row);
                }

            }

        }
        String tongtien = String.valueOf(TinhTongTien(tblDichVuChon));
        lblTienDV.setText(numberFM.format(TinhTongTien(tblDichVuChon)));
//            txtTongTien.setText(numberFM.format(getTongTien()));
        txtTongTien.setText(numberFM.format((GetTienMay() + TinhTongTien(tblDichVuChon)) - (GetTienMay() + TinhTongTien(tblDichVuChon)) * (Double.parseDouble(lblGiamGia.getText()) / 100)));
    }//GEN-LAST:event_mniXoaSPActionPerformed

    private void mniSuaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniSuaSPActionPerformed
        // TODO add your handling code here:

        int row = tblDichVuChon.getSelectedRow();
        String tenDVChon = tblDichVuChon.getValueAt(row, 0).toString();

        for (int i = 0; i < tblDichVu.getRowCount(); i++) {
            String check = tblDichVu.getValueAt(i, 2).toString();
            if (tenDVChon.equals(check)) {
                int soLuongMuaTruocKhiSua = Integer.parseInt(String.valueOf(tblDichVuChon.getValueAt(row, 1).toString()));
                int soLuongTon = Integer.parseInt(tblDichVu.getValueAt(i, 3).toString()) + soLuongMuaTruocKhiSua;
                tblDichVu.setValueAt(String.valueOf(soLuongTon), i, 3);

                String input = JOptionPane.showInputDialog(this, "Mời nhập số lượng");
                int soLuongTonSau = Integer.parseInt(tblDichVu.getValueAt(i, 3).toString()) - Integer.parseInt(input);
                tblDichVuChon.setValueAt(input, row, 1);
                tblDichVu.setValueAt(String.valueOf(soLuongTonSau), i, 3);
                double thanhTien = Double.parseDouble(tblDichVuChon.getValueAt(row, 1).toString()) * Double.parseDouble(tblDichVuChon.getValueAt(row, 2).toString());
                tblDichVuChon.setValueAt(String.valueOf(thanhTien), row, 3);
                String tongtien = String.valueOf(TinhTongTien(tblDichVuChon));
                lblTienDV.setText(numberFM.format(TinhTongTien(tblDichVuChon)));
//            txtTongTien.setText(numberFM.format(getTongTien()));
                txtTongTien.setText(numberFM.format((GetTienMay() + TinhTongTien(tblDichVuChon)) - (GetTienMay() + TinhTongTien(tblDichVuChon)) * (Double.parseDouble(lblGiamGia.getText()) / 100)));
                ArrayList<HDDichVu_Model> lst = getData();
                if (lst == null) {
                    return;
                }
                for (HDDichVu_Model x : lst) {
                    //                    iHDDichVu_service.add(x);
                    System.out.println(x.getIdDV());
                    DichVu_Model dv = iDichVu_service.getDVById(x.getIdDV());
                    System.out.println(dv.getTenDV());
                    if (dv.getTenDV().trim().equals(tenDVChon)) {
                        iDichVu_service.updateSoLuongKhiXoa(dv, x.getSoLuong());
                    }

                }
            }
        }

    }//GEN-LAST:event_mniSuaSPActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        try {

            HoaDon_Model hd = this.getDataFormHoaDon();
            _iHoaDon_Services.add(hd);
            JOptionPane.showMessageDialog(this, "Thanh toán thành công");
            _iMayService.doitt(0, maMay);

            _iThueMay_Services.updateTT(1, tblThueMay.getValueAt(0, 0).toString());

            int in = JOptionPane.showConfirmDialog(null, "Bạn muốn in hóa đơn không", "Hóa Đơn", JOptionPane.OK_CANCEL_OPTION);
            if (in == 0) {

                String hoten = lblKhachHang.getText();
                String ngayden = tblThueMay.getValueAt(0, 3).toString();
                String ngaydi = tblThueMay.getValueAt(0, 4).toString();
                String May = lblMay.getText();
                String tongtien = txtTongTien.getText();
                String tiennmay = lblTienMay.getText();
                String tiendv = lblTienDV.getText();
                String nhanvien = lblTenNhanVien.getText();

                String tiendua = txtTienKhachDua.getText();
                String tientra = txtTralai.getText();

                hoadon.txtbai.append("\t \t NO RICH GAMING\n \n"
                        + "\t=======================================================\t\n"
                        + "Địa chỉ : Số 2 Ngõ 132/66/2 Cầu Diễn,Bắc Từ Liêm,Hà Nội\n"
                        + "Điện Thoại : 0966861471\n"
                        + "Email : lequyan2210@gmail.com\n"
                        + "\t========================================================\t\n"
                        + "\t \t  Hóa Đơn Thanh Toán \n \n"
                        + "------------------------------------------------------------------------------------------------------------\n"
                        + "Họ và Tên :" + hoten + " \t \t Giờ vào :" + ngayden + " \n"
                        + "Địa chỉ : Hà Nội \t \t Giờ ra : " + ngaydi + "\n"
                        + "Điện thoại : 0966861471 \t \t Thu Ngân : "+ nhanvien +"\n"
                        + "Máy : " + May + "\n"
                        + "------------------------------------------------------------------------------------------------------------\n"
                        + "Tiền Máy :  " + tiennmay + "\n"
                        + "Tiền Dịch Vụ :  " + tiendv + "\n"
                        + "-----------------------------------------------------------------------------------------------------------------\n"
                        + "\t\t\t\t Tổng :" + tongtien + "VND\n"
                        + "\t\t\t\tTiền Khách Đưa :" + tiendua + "\n"
                        + "\t\t\t\tTiền Trả : " + tientra + "\n\n"
                        + "\t**********************************"
                        + "\n \t \tHẹn Gặp Lại");
                hoadon.txtbai.print();
                MeNuUi frm = MeNuUi.b;
                frm.tab.remove(pnl_GioChoi_Moi.form_gioChoi);
                pnl_GioChoi_Moi pnl = new pnl_GioChoi_Moi();
                frm.tab.add("Danh sách máy", pnl);
                frm.tab.setSelectedComponent(pnl);
                this.dispose();
            }
            MeNuUi frm = MeNuUi.b;
            frm.tab.remove(pnl_GioChoi_Moi.form_gioChoi);
            pnl_GioChoi_Moi pnl = new pnl_GioChoi_Moi();
            frm.tab.add("Danh sách máy", pnl);
            frm.tab.setSelectedComponent(pnl);
            this.dispose();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnTamTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTamTinhActionPerformed
        // TODO add your handling code here:
        ArrayList<HDDichVu_Model> lst = getData();
        if (lst == null) {
            return;
        }
        for (HDDichVu_Model x : lst) {
            iHDDichVu_service.add(x);
            System.out.println(x.getIdDV());
            DichVu_Model dv = iDichVu_service.getDVById(x.getIdDV());
            System.out.println(dv.getTenDV());
            iDichVu_service.updateSoLuong(dv, x.getSoLuong());
            System.out.println("so luong mua : " + x.getSoLuong());
        }
        JOptionPane.showMessageDialog(this, "Thêm thành công");
    }//GEN-LAST:event_btnTamTinhActionPerformed

    private void txtTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemKeyPressed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
        String key = txtTimKiem.getText();
        this.findDv(key);
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void txtTongTienKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTongTienKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTongTienKeyReleased

    private void txtTongTienCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTongTienCaretUpdate
        // TODO add your handling code here:


    }//GEN-LAST:event_txtTongTienCaretUpdate

    private void txtTongTienCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtTongTienCaretPositionChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTongTienCaretPositionChanged

    private void txtTienKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyReleased
        // TODO add your handling code here:

        try {
            double khach = Double.parseDouble(txtTienKhachDua.getText());
//            txtTienKhach.setText(numberFM.format(khach));
            double tienThua = khach - ((GetTienMay() + TinhTongTien(tblDichVuChon)) - (GetTienMay() + TinhTongTien(tblDichVuChon)) * (Double.parseDouble(lblGiamGia.getText()) / 100));
            txtTralai.setText(numberFM.format(tienThua));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Vui lòng nhập lại tiền khách đưa");
        }


    }//GEN-LAST:event_txtTienKhachDuaKeyReleased

    private void rdoCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoCheckActionPerformed
        // TODO add your handling code here:
        if (rdoCheck.isSelected()) {
            double tongtien = (GetTienMay() + TinhTongTien(tblDichVuChon)) - (GetTienMay() + TinhTongTien(tblDichVuChon)) * (Double.parseDouble(lblGiamGia.getText()) / 100);
            double tienkhach = Double.parseDouble(txtTienKhachDua.getText());
            if (tienkhach < tongtien) {
                JOptionPane.showMessageDialog(this, "Tiền khách trả không đủ!");
                rdoCheck.setSelected(false);
                return;
            }
            txtTongTien.setEnabled(false);
            txtTienKhachDua.setEnabled(false);
            btnThanhToan.setEnabled(true);
        } else {
            btnThanhToan.setEnabled(false);

        }

    }//GEN-LAST:event_rdoCheckActionPerformed

//    public ThueMay_Model getThueMay() {
//        String maThueMay = tblThueMay.getValueAt(0, 0).toString();
//        String tgkt = tblThueMay.getValueAt(0, 4).toString();
//        SimpleDateFormat DateFM = new SimpleDateFormat("HH:mm:ss");
//        ThueMay_Model tm = _iThueMay_Services.getThueMayByMa(maThueMay);
//
//        return new ThueMay_Model(maThueMay, DateFM.format(tgkt));
//
//    }
    public ThueMay_Model getThueMay() {
        String maThueMay = tblThueMay.getValueAt(0, 0).toString();
        ThueMay_Model tm = _iThueMay_Services.getThueMayByMa(maThueMay);
        String end = tblThueMay.getValueAt(0, 4).toString();
        return new ThueMay_Model(maThueMay, end);

    }

    public String getValueFormTBlThueMay() {
        if (tblThueMay.getValueAt(0, 4).toString().equals("")) {
            return null;
        } else {
            return tblThueMay.getValueAt(0, 4).toString();
        }

    }

    public double GetTienMay() throws NumberFormatException {
        String start = tblThueMay.getValueAt(0, 3).toString();
        String end = getValueFormTBlThueMay();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1 = null;
        Date d2 = null;
        try {

            d1 = format.parse(start);

            d2 = format.parse(end);

        } catch (ParseException e) {

        }
        // Get msec from each, and subtract.
        long diff = d2.getTime() - d1.getTime();
        System.out.println(diff);
        long diffSeconds = diff / 1000;
        long diffMinutes = diff / (60 * 1000);
        long diffHours = diff / (60 * 60 * 1000);
        System.out.println("Số giây : " + diffSeconds + " seconds.");
        System.out.println("Số phút: " + diffMinutes + " minutes.");
        System.out.println("Số giờ: " + diffHours + " hours.");
        float secondsss = Float.parseFloat(diffSeconds + "");
        float minute = Float.parseFloat(diffMinutes + "");
        String donGiaMay = lblDonGia.getText();
        float dg = Float.parseFloat(donGiaMay);
        long h = diffMinutes - (diffHours * 60);
        System.out.println(h);
        lblSoGio.setText(diffMinutes + "");
        float tt = (secondsss / 3600) * dg;
        float tt_mn = (minute / 60) * dg;
        double tongTien = (double) Math.round(tt * 1) / 1;
        double ttmn = (double) Math.round(tt_mn * 1) / 1;
        System.out.println("Tổng Tiền: " + tongTien);
        return tongTien;
    }

    public Date getDate() {
        SimpleDateFormat DateFM = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String d = DateFM.format(date);
        try {
            return DateFM.parse(d);
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CTThueMayUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTamTinh;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblDonGia;
    private javax.swing.JLabel lblGiamGia;
    private javax.swing.JLabel lblGiamGia1;
    private javax.swing.JLabel lblKhachHang;
    private javax.swing.JLabel lblLoaiMay;
    private javax.swing.JLabel lblMay;
    private javax.swing.JLabel lblSoGio;
    private javax.swing.JLabel lblTenMay;
    private javax.swing.JLabel lblTenNhanVien;
    private javax.swing.JLabel lblTienDV;
    private javax.swing.JLabel lblTienMay;
    private javax.swing.JMenuItem mniSuaSP;
    private javax.swing.JMenuItem mniXoaSP;
    private javax.swing.JPopupMenu pmnHoaDonDV;
    private javax.swing.JRadioButton rdoCheck;
    private javax.swing.JTable tblDichVu;
    private javax.swing.JTable tblDichVuChon;
    private javax.swing.JTable tblThueMay;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTongTien;
    private javax.swing.JTextField txtTralai;
    // End of variables declaration//GEN-END:variables
    public void loadTableDichVu() {
        ArrayList<DichVu_View> lst = (ArrayList<DichVu_View>) this.iDichVu_service.getALllDV();
        DefaultTableModel dtm = (DefaultTableModel) tblDichVu.getModel();
        dtm.setRowCount(0);

        for (DichVu_View x : lst) {
            DichVu_View dv = (DichVu_View) x;
            Object[] rowData = {
                dv.getSTT(),
                dv.getMaDV(),
                dv.getTenDV(),
                dv.getSoLuong(),
                dv.getGiaBan()
            };
            dtm.addRow(rowData);
        }
    }

    public void loadDichVuChiTiet(JTable tbl, DichVu_Model dv, String SoLuongMua) {
        DefaultTableModel dtm = (DefaultTableModel) tbl.getModel();
        Object[] rowData = {
            dv.getTenDV(),
            SoLuongMua,
            dv.getGiaBan(),
            Double.parseDouble(SoLuongMua) * dv.getGiaBan()
        };
        dtm.addRow(rowData);
    }

    public double TinhTongTien(JTable tbl) {
        double tongTien = 0;

        for (int i = 0; i < tbl.getRowCount(); i++) {
            tongTien = tongTien + Double.parseDouble(tbl.getValueAt(i, 3).toString());
            System.out.println(tongTien);
        }
        return tongTien;
    }

    public ArrayList<HDDichVu_Model> getData() {
        ArrayList<HDDichVu_Model> lst = new ArrayList<>();

        String maDVCT = this.tblThueMay.getValueAt(0, 0).toString();
        System.out.println(maDVCT);
        ThueMay_Model tm = _iThueMay_Services.getThueMayByMa(maDVCT);
        System.out.println("thue may" + tm);
        String idTm = tm.getId();
        System.out.println("dfksdf" + idTm);
        for (int i = 0; i < tblDichVuChon.getRowCount(); i++) {
            DichVu_Model dv = iDichVu_service.getDVByTen(tblDichVuChon.getValueAt(i, 0).toString());

            int soluong = Integer.parseInt(tblDichVuChon.getValueAt(i, 1).toString());
            double giaban = Double.parseDouble(tblDichVuChon.getValueAt(i, 2).toString());
            double thanhtien = Double.parseDouble(tblDichVuChon.getValueAt(i, 3).toString());

            lst.add(new HDDichVu_Model(dv.getId(), idTm, maDVCT, soluong, giaban, thanhtien, getDate()));

        }

        return lst;
    }

    public void findDv(String keyWord) {
        List<DichVu_View> ds = this.iDichVu_service.findNV(keyWord);
        DefaultTableModel dtm = (DefaultTableModel) this.tblDichVu.getModel();
        dtm.setRowCount(0);
        for (DichVu_View dv : ds) {
            Object[] rowData = {
                dv.getSTT(),
                dv.getMaDV(),
                dv.getTenDV(),
                dv.getSoLuong(),
                dv.getGiaBan(),
                dv.getDonVi(),
                dv.getDanhMuc()

            };
            dtm.addRow(rowData);
        }
    }

//    public String getTongTien() {
//
//        double tienMay = Double.parseDouble(lblTienMay.getText());
//        double tienDV = Double.parseDouble(lblTienDV.getText());
////        lblTienMay.setText(numberFM.format(tienMay));
////        lblTienDV.setText(numberFM.format(tienDV));
//        double tongtien = tienDV + tienMay;
//        String tongTienStr = numberFM.format(tongtien);
//        return tongTienStr;
//    }
    public Date getTime() {
        SimpleDateFormat DateFM = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String d = DateFM.format(date);
        try {
            return DateFM.parse(d);
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void getGiamGia() {
        ArrayList<GiamGia_View> lst = (ArrayList<GiamGia_View>) _iGiamGia_Services.getAll();
        for (GiamGia_View x : lst) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date d1 = null;
            Date d2 = null;
            Date d3 = null;
            d1 = x.getNgayKetThuc();
            d2 = x.getNgayBatDau();
            d3 = getTime();
            // Get msec from each, and subtract.
            long checkTruoc = d2.getTime() - d3.getTime();
            long checkSau = d1.getTime() - d3.getTime();
            System.out.println("checkTruoc" + checkTruoc);
            System.out.println("checkSau" + checkSau);
            if (checkSau > 0 && checkTruoc < 0) {
                int mucgg = x.getMucGiamGia();
                System.out.println("gg:" + mucgg);
                lblGiamGia.setText(String.valueOf(mucgg));
            } else {
                lblGiamGia.setText("0");
            }
        }

    }

    public String getMaGiamGia() {
        ArrayList<GiamGia_View> lst = (ArrayList<GiamGia_View>) _iGiamGia_Services.getAll();
        for (GiamGia_View x : lst) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date d1 = null;
            Date d2 = null;
            Date d3 = null;
            d1 = x.getNgayKetThuc();
            d2 = x.getNgayBatDau();
            d3 = getTime();
            // Get msec from each, and subtract.
            long checkTruoc = d2.getTime() - d3.getTime();
            long checkSau = d1.getTime() - d3.getTime();
            System.out.println("checkTruoc" + checkTruoc);
            System.out.println("checkSau" + checkSau);
            if (checkSau > 0 && checkTruoc < 0) {
                int mucgg = x.getMucGiamGia();
                System.out.println("gg:" + mucgg);
                lblGiamGia.setText(String.valueOf(mucgg));
                return x.getMa();
            }
        }
        return null;

    }

    public HoaDon_Model getDataFormHoaDon() {
        GiamGia_Model gg = _iGiamGia_Services.getGiamGiaByMa(getMaGiamGia());
        ThueMay_Model tm = _iThueMay_Services.getThueMayByMa(tblThueMay.getValueAt(0, 0).toString());
        NhanVien_Model nv = _iNhanVienServices.getNVByMa(lblTenNhanVien.getText());

        String maHD = JDBC_Helper.gen("HD");
        String soGio = lblSoGio.getText();
        int soGioqd = Integer.parseInt(soGio);
        double tienMay = GetTienMay();
        double tienDV = TinhTongTien(tblDichVuChon);
        double giamgia = Double.parseDouble(lblGiamGia.getText());
        double tongtien = (tienMay + tienDV) - ((tienMay + tienDV) * giamgia / 100);

//        String ngayTao = "2022-12-15";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


            return new HoaDon_Model(tm, gg, nv, maHD, soGioqd, tienMay, tienDV, tongtien, getDate());

    }
}
