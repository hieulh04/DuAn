/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;



import Model.ChucVu_Model;
import Model.NhanVien_Model;
import Service.IChucVu_Services;
import Service.INhanvien_services;
import Service_impl.ChucVuServices;
import Service_impl.NhanVienServices;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.JOptionPane;


import javax.swing.UIManager;


/**
 *
 * @author lequy
 */

  
public class LonginUi extends javax.swing.JFrame {
private INhanvien_services nhanvien_services = new NhanVienServices();
private IChucVu_Services chucVu_Services = new ChucVuServices();
   
    /**
     * Creates new form LonginUi
     */
    public LonginUi() {
        initComponents();
        setLocationRelativeTo(null);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txttk = new javax.swing.JTextField();
        btndanhnhap = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ckhienmatkhau = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        txtmk = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel2.setText("ĐĂNG NHẬP");

        txttk.setBorder(javax.swing.BorderFactory.createTitledBorder("Tài khoản"));
        txttk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttkActionPerformed(evt);
            }
        });

        btndanhnhap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btndanhnhap.setText("ĐĂNG NHẬP");
        btndanhnhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndanhnhapActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo-removebg-preview.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        ckhienmatkhau.setText("Hiện mật khẩu?");
        ckhienmatkhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckhienmatkhauActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("---------------------------------------------");

        txtmk.setBorder(javax.swing.BorderFactory.createTitledBorder("Mật khẩu"));
        txtmk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(btndanhnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txttk)
                                    .addComponent(jLabel3)
                                    .addComponent(ckhienmatkhau)
                                    .addComponent(txtmk, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txttk, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtmk, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ckhienmatkhau)
                        .addGap(40, 40, 40)
                        .addComponent(btndanhnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txttkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttkActionPerformed

    private void btndanhnhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndanhnhapActionPerformed
        // TODO add your handling code here:
         if (nhanvien_services.KTUser(txttk.getText(), txtmk.getText())) {

            NhanVien_Model nv = nhanvien_services.getUser(txttk.getText(), txtmk.getText());
            if (nv.getTrangThai() != 0) {
                JOptionPane.showMessageDialog(this, "Nhân viên có tài khoản vừa nhập đã nghỉ  việc!");
                return;
            } else {
                String tentk = nv.getTenTK_NV();
                String id = nv.getIdcv().getTencv();
                String tennv = nv.getHoTen();
                MeNuUi ui = new MeNuUi();
                ui.TenTK = tentk;
                ui.IDCV = id;
                ui.setVisible(true);
                CTThueMayUI hdi = new CTThueMayUI();
                hdi.tenNV = tennv;
                this.dispose();
            }
        }
    }//GEN-LAST:event_btndanhnhapActionPerformed

    private void ckhienmatkhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckhienmatkhauActionPerformed
        // TODO add your handling code here:
        if (ckhienmatkhau.isSelected() == true) {
            txtmk.setEchoChar((char)0);
        }else{
        txtmk.setEchoChar('*');
        }
    }//GEN-LAST:event_ckhienmatkhauActionPerformed

    private void txtmkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmkActionPerformed
        // TODO add your handling code here:
         txtmk.setEchoChar('*');
    }//GEN-LAST:event_txtmkActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LonginUi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndanhnhap;
    private javax.swing.JCheckBox ckhienmatkhau;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPasswordField txtmk;
    private javax.swing.JTextField txttk;
    // End of variables declaration//GEN-END:variables
}
