package View;

import Model.LoaiMay_Model;
import Model.May_Model;
import Service.ILoaiMayService;
import Service.IMayService;
import Service_impl.LoaiMay_Service;
import Service_impl.May_Service;
import ViewModel.LoaiMay_View;
import ViewModel.May_View;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hung duong
 */
public class pnl_May extends javax.swing.JPanel {

     public static pnl_May form_may;
    private IMayService _iMayService;
    private ILoaiMayService _iLoaiMayService;
    private List<LoaiMay_View> listLM;

    public pnl_May() {
        initComponents();
        form_may = this;
        _iMayService = new May_Service();
        _iLoaiMayService = new LoaiMay_Service();
        listLM = this._iLoaiMayService.getAllLMay();
        this.loadTable();
        fillCBoKH();
    }

    public void fillCBoKH() {
        cbbLoaiMay1.removeAllItems();
        for (LoaiMay_View x : listLM) {
            cbbLoaiMay1.addItem(x.toString());
        }
    }

    public void loadTable() {
        List<May_View> ds = this._iMayService.getAllMay();
        DefaultTableModel dtm = (DefaultTableModel) this.tblMay.getModel();
        dtm.setRowCount(0);
        for (May_View d : ds) {
            Object[] rowData = {
                d.getStt(),
                d.getMaMay(),
                d.getTrangThai() == 0 ? "Sẵn sàng" : "Đang hoạt động",
                d.getLoaiMay()
            };
            dtm.addRow(rowData);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnThem1 = new javax.swing.JButton();
        btnSua1 = new javax.swing.JButton();
        btnXoa1 = new javax.swing.JButton();
        txtMaMay = new javax.swing.JTextField();
        txtTim1 = new javax.swing.JTextField();
        btnNew1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        cbbTrangThai = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cbbLoaiMay1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMay = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1026, 544));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Mã Máy");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Loại Máy");

        btnThem1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_add_30px_1.png"))); // NOI18N
        btnThem1.setText("Thêm");
        btnThem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem1ActionPerformed(evt);
            }
        });

        btnSua1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSua1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_update_30px.png"))); // NOI18N
        btnSua1.setText("SỬA");
        btnSua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua1ActionPerformed(evt);
            }
        });

        btnXoa1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnXoa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_delete_30px.png"))); // NOI18N
        btnXoa1.setText("XÓA");
        btnXoa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa1ActionPerformed(evt);
            }
        });

        txtTim1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTim1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTim1ActionPerformed(evt);
            }
        });
        txtTim1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTim1KeyReleased(evt);
            }
        });

        btnNew1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNew1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_refresh_30px.png"))); // NOI18N
        btnNew1.setText("New");
        btnNew1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNew1ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("TÌM KIẾM");

        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sẵn sàng", "Đang hoạt động" }));

        jLabel10.setText("Trạng Thái");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTim1)
                            .addComponent(txtMaMay)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel14))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(cbbLoaiMay1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(113, 113, 113)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNew1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(143, 143, 143))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTim1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtMaMay, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNew1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbbLoaiMay1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        tblMay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã máy", "Trạng Thái", "Loại Máy"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMayMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMay);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem1ActionPerformed
        May_Model m = this.getFormDaTa();
        _iMayService.add(m);
        loadTable();
        clearForm();
    }//GEN-LAST:event_btnThem1ActionPerformed

    private void btnSua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua1ActionPerformed
        May_Model m = this.getFormDaTa();
        _iMayService.update(m);
        loadTable();
        clearForm();
    }//GEN-LAST:event_btnSua1ActionPerformed

    private void btnXoa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa1ActionPerformed
        May_Model m = this.getFormDaTa();
        _iMayService.delete(m);
        loadTable();
        clearForm();
    }//GEN-LAST:event_btnXoa1ActionPerformed

    private void txtTim1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTim1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTim1ActionPerformed

    private void txtTim1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTim1KeyReleased
        // TODO add your handling code here:
        //        String key = txtTim.getText();
    }//GEN-LAST:event_txtTim1KeyReleased

    private void btnNew1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNew1ActionPerformed
        clearForm();
    }//GEN-LAST:event_btnNew1ActionPerformed

    private void tblMayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMayMouseClicked
        // TODO add your handling code here:
        int row = this.tblMay.getSelectedRow();
        if (row == -1) {
            return;
        }
        String ma = this.tblMay.getValueAt(row, 1).toString();
        String tt = this.tblMay.getValueAt(row, 2).toString();
        String lm = this.tblMay.getValueAt(row, 3).toString();

        txtMaMay.setText(ma);
        cbbLoaiMay1.setSelectedItem(lm);
        cbbTrangThai.setSelectedItem(tt);
    }//GEN-LAST:event_tblMayMouseClicked

    public May_Model getFormDaTa() {
        May_Model m = new May_Model();
        String ma = txtMaMay.getText();
        m.setMaMay(ma);

        String malm = this.cbbLoaiMay1.getSelectedItem().toString();
        System.out.println(malm);
        LoaiMay_Model lm = _iLoaiMayService.getAllMayByMa(malm);
        m.setLoaiMay(lm);
        int tt = 0;

        if (this.cbbTrangThai.getSelectedItem().equals("Đang hoạt động")) {
            tt = 1;
        } else {
            tt = 0;
        }

        m.setTrangThai(tt);
        return m;
    }

    public void clearForm() {
        txtMaMay.setText("");
        cbbLoaiMay1.setSelectedIndex(0);
        cbbTrangThai.setSelectedIndex(0);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNew1;
    private javax.swing.JButton btnSua1;
    private javax.swing.JButton btnThem1;
    private javax.swing.JButton btnXoa1;
    private javax.swing.JComboBox<String> cbbLoaiMay1;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMay;
    private javax.swing.JTextField txtMaMay;
    private javax.swing.JTextField txtTim1;
    // End of variables declaration//GEN-END:variables
}
