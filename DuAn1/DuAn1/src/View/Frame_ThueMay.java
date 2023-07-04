package View;

import Model.KhachHang_Model;
import Model.May_Model;
import Model.ThueMay_Model;
import Service.IKhachHangService;
import Service.IMayService;
import Service.IThueMay_Services;
import Service_impl.KhachHang_Service;
import Service_impl.May_Service;
import Service_impl.ThueMay_Services;
import ViewModel.KhachHang_View;
import ViewModel.May_View;
import ViewModel.ThueMay_View;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author hung duong
 */
public class Frame_ThueMay extends javax.swing.JFrame {

    private IKhachHangService _iKhachHangService;
    private IThueMay_Services _iThueMay_Services;
    private IMayService _iMayService;
    private List<KhachHang_View> listKH_view;
    private List<ThueMay_View> listTM_view;
    private List<May_View> listMay_view;

    public Frame_ThueMay() {
        initComponents();
        setLocationRelativeTo(this);
        _iKhachHangService = new KhachHang_Service();
        _iThueMay_Services = new ThueMay_Services();
        _iMayService = new May_Service();
        listKH_view = _iKhachHangService.getALllDM();
        listTM_view = _iThueMay_Services.getAllThueMay();
        listMay_view = _iMayService.getAllMay();
        loadCBBKH();
        getThueMay();

    }

    public void loadCBBKH() {
        cbbKhachHang.removeAllItems();
        for (KhachHang_View x : listKH_view) {
            cbbKhachHang.addItem(x.toString());
        }
    }

    public ThueMay_Model getThueMay() {
//        int count = Integer.parseInt(listTM_view.get(i).getMaThueMay().substring(2, listTM_view.get(0).getMaThueMay().length())) + 1;
//        ma = "MT" + count;

//        String ma = listTM_view.get(listTM_view.size() - 1).getMaThueMay().substring(2, listTM_view.get(listTM_view.size() - 1).getMaThueMay().length());
        String tenma = gen("MT");
//        String ngayTao = "2022-12-15";
//        String time = "2022-12-15 14:47:02 ";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String tenMay = lblTenMay.getText();
        String tenKh = cbbKhachHang.getSelectedItem().toString();
        KhachHang_Model kh = _iKhachHangService.getDMByMa(tenKh);
        May_Model m = _iMayService.getMayByMa(tenMay);
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return new ThueMay_Model(m, kh, tenma, s.format(getTime()), (Date) getDate());

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

    public static String gen(String ma) {
        int last = (int) Math.floor((Math.random()) * 9999);
        if (last < 1000 && last >= 100) {
            return ma + "0" + last;
        }
        if (last < 100 && last >= 10) {
            return ma + "00" + last;
        }
        if (last < 10) {
            return ma + "000" + last;
        }

        return ma + last;

    }

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

    public static String maMay;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbbKhachHang = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        lblTenMay = new javax.swing.JLabel();
        btnThemKH = new javax.swing.JButton();
        btnThue = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Khách hàng");

        jLabel2.setText("Máy");

        cbbKhachHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Thuê Máy");

        lblTenMay.setText("TenMay");

        btnThemKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_add_30px_1.png"))); // NOI18N
        btnThemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKHActionPerformed(evt);
            }
        });

        btnThue.setText("Thuê Máy");
        btnThue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1)
                        .addGap(22, 22, 22)
                        .addComponent(cbbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnThemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 34, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel2)
                        .addGap(27, 27, 27)
                        .addComponent(lblTenMay, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(6, 6, 6))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(btnThue, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1))
                    .addComponent(cbbKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(lblTenMay))
                .addGap(44, 44, 44)
                .addComponent(btnThue, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.lblTenMay.setText(maMay);
    }//GEN-LAST:event_formWindowOpened

    private void btnThueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThueActionPerformed
        ThueMay_Model tm = this.getThueMay();
        _iThueMay_Services.add(tm);
        JOptionPane.showMessageDialog(this, "Mở máy thành công");
        _iMayService.doitt(1, maMay);
        MeNuUi frm = MeNuUi.b;
        frm.tab.remove(pnl_GioChoi_Moi.form_gioChoi);
        pnl_GioChoi_Moi pnl = new pnl_GioChoi_Moi();
        frm.tab.add("Danh sách máy", pnl);
        frm.tab.setSelectedComponent(pnl);
        this.dispose();

    }//GEN-LAST:event_btnThueActionPerformed

    private void btnThemKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKHActionPerformed
        // TODO add your handling code here:
        MeNuUi frm = MeNuUi.b;

        pnl_KhachHang pnl = new pnl_KhachHang();
        frm.tab.add("Danh sách máy", pnl);
        frm.tab.setSelectedComponent(pnl);
        this.dispose();
    }//GEN-LAST:event_btnThemKHActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThemKH;
    private javax.swing.JButton btnThue;
    private javax.swing.JComboBox<String> cbbKhachHang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblTenMay;
    // End of variables declaration//GEN-END:variables
}
