package View;

import Model.LoaiMay_Model;
import Service.ILoaiMayService;
import Service.IMayService;
import Service.IThueMay_Services;
import Service_impl.LoaiMay_Service;
import Service_impl.May_Service;
import Service_impl.ThueMay_Services;
import ViewModel.LoaiMay_View;
import ViewModel.May_View;
import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

/**
 *
 * @author lequy
 */
public class pnl_GioChoi_Moi extends javax.swing.JPanel {

    public static pnl_GioChoi_Moi form_gioChoi;
    List<May_View> listMay_View;
    ILoaiMayService _iLoaiMayService;
    IMayService _iMayService;
    List<LoaiMay_View> listLMay_View;
    LoaiMay_Model loaiMay;

    public pnl_GioChoi_Moi() {
        initComponents();
        form_gioChoi = this;
        _iMayService = new May_Service();
        _iLoaiMayService = new LoaiMay_Service();
        listLMay_View = _iLoaiMayService.getAllLMay();
        listMay_View = _iMayService.getAllMay();
        this.Fillphong(listMay_View = _iMayService.getAllMay());
        loaiMay = new LoaiMay_Model();

    }

    public void Fillphong(List<May_View> listMay_View) {
        pnl.removeAll();

//        listMay_View = _iMayService.getAllMay();
        int sapxep = listMay_View.size();
        //pnl.setLayout(new GridLayout(10, 5, 20, 20));

        if (sapxep > 3) {
            pnl.setLayout(new GridLayout(10, sapxep / 5, 20, 20));
        } else if (sapxep < 3) {
            pnl.setLayout(new GridLayout(3, 3));
        }

        if (listMay_View != null) {
            JButton[] btn = new JButton[listMay_View.size()];
            for (int i = 0; i < listMay_View.size(); i++) {
                btn[i] = new javax.swing.JButton();
                btn[i].setFont(new java.awt.Font("Segoe", 1, 13));
                btn[i].setPreferredSize(new Dimension(200, 200));
                btn[i].setHorizontalTextPosition((int) CENTER_ALIGNMENT);
                btn[i].setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                btn[i].setFont(new java.awt.Font("Segoe", 1, 15));
                btn[i].setForeground(Color.decode("#000000"));
                String MaMay = String.valueOf(listMay_View.get(i).getMaMay());

                if (listMay_View.get(i).getTrangThai() == 0) {
                    JButton btnMay = btn[i];
                    btn[i].setBackground(Color.decode("#CCFFCC"));
                    String a = ("<html><div style=\"text-align: center;\"> " + String.valueOf(listMay_View.get(i).getMaMay()) + "<br>" + "<br>" + "<br>" + "Sẵn sàng...</div></html>");
                    btn[i].setText(a);
                    btn[i].setToolTipText(a);
                    btn[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_My_Computer_30px.png")));
//                   
                    JPopupMenu paop = new JPopupMenu();
                    paop.setMaximumSize(getSize());
                    JMenuItem mn1 = new JMenuItem("Đặt máy");
                    JMenuItem mn2 = new JMenuItem("Bảo trì");

                    mn1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int chon = JOptionPane.showConfirmDialog(null, "Bạn có muốn mở máy không?", "OK", JOptionPane.OK_CANCEL_OPTION);
                            if (chon == 0) {
                                Frame_ThueMay tm = new Frame_ThueMay();
                                tm.maMay = MaMay;
                                tm.setVisible(true);
                            }

                        }
                    });
                    mn2.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int chon = JOptionPane.showConfirmDialog(null, "Bạn có muốn bảo trì máy hay không?", "OK", JOptionPane.OK_CANCEL_OPTION);
                            if (chon == 0) {
                                _iMayService.doitt(2, MaMay);
                                MeNuUi frm = MeNuUi.b;
                                frm.tab.remove(pnl_GioChoi_Moi.form_gioChoi);
                                pnl_GioChoi_Moi pnl = new pnl_GioChoi_Moi();
                                frm.tab.add("Danh sách máy", pnl);
                                frm.tab.setSelectedComponent(pnl);
                            }
                        }
                    });
                    paop.add(mn1);
                    paop.add(mn2);

                    btn[i].addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            paop.show(btnMay, e.getX(), e.getY());
                        }
                    });
                    btnMay.add(paop);
                }

                if (listMay_View.get(i).getTrangThai() == 1) {
                    JButton btnMay = btn[i];
                    btn[i].setBackground(Color.decode("#EE2003"));
                    String a = ("<html><div style=\"text-align: center;\"> " + String.valueOf(listMay_View.get(i).getMaMay()) + "<br>" + "<br>" + "<br>" + "Đang hoạt động...</div></html>");
                    btn[i].setText(a);
                    btn[i].setToolTipText(a);
                    btn[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_Kid_On_Computer_30px_1.png")));
                    btn[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int chon = JOptionPane.showConfirmDialog(null, "Bạn có xem chi tiết thuê máy không ?", "OK", JOptionPane.OK_CANCEL_OPTION);
                            if (chon == 0) {
                                CTThueMayUI hd = new CTThueMayUI();
                                hd.maMay = MaMay;
                                hd.setVisible(true);
                            }
                        }
                    });
                }

                if (listMay_View.get(i).getTrangThai() == 2) {
                    JButton btnMay = btn[i];
                    btn[i].setBackground(Color.decode("#6666FF"));
                    String a = ("<html><div style=\"text-align: center;\"> " + String.valueOf(listMay_View.get(i).getMaMay()) + "<br>" + "<br>" + "<br>" + "Đang sửa chữa...</div></html>");
                    btn[i].setText(a);
                    btn[i].setToolTipText(a);
                    btn[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_computer_support_30px.png")));
                    btn[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int chon = JOptionPane.showConfirmDialog(null, "Bạn có muốn hoàn tất bảo trì hay không?", "OK", JOptionPane.OK_CANCEL_OPTION);
                            if (chon == 0) {
                                _iMayService.doitt(0, MaMay);
                                MeNuUi frm = MeNuUi.b;
                                frm.tab.remove(pnl_GioChoi_Moi.form_gioChoi);
                                pnl_GioChoi_Moi pnl = new pnl_GioChoi_Moi();
                                frm.tab.add("Danh sách máy", pnl);
                                frm.tab.setSelectedComponent(pnl);
                            }
                        }
                    });
                }

                pnl.add(btn[i]);
                pnl.updateUI();
            }

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        pnl = new javax.swing.JPanel();
        cbbTrangThai = new javax.swing.JComboBox<>();
        cbbLoaiMay = new javax.swing.JComboBox<>();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setBackground(new java.awt.Color(255, 255, 255));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        javax.swing.GroupLayout pnlLayout = new javax.swing.GroupLayout(pnl);
        pnl.setLayout(pnlLayout);
        pnlLayout.setHorizontalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1906, Short.MAX_VALUE)
        );
        pnlLayout.setVerticalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1066, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(pnl);

        cbbTrangThai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Sẵn sàng", "Đang hoạt động", "Đang sửa chữa" }));
        cbbTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTrangThaiActionPerformed(evt);
            }
        });

        cbbLoaiMay.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbbLoaiMay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Normal", "Vip" }));
        cbbLoaiMay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLoaiMayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(cbbLoaiMay, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbLoaiMay, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1002, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbbLoaiMayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLoaiMayActionPerformed
        if (cbbLoaiMay.getSelectedIndex() == 0) {
            Fillphong(_iMayService.getAllMay());
        } else {
            String ten = this.cbbLoaiMay.getSelectedItem().toString();

            listMay_View = _iMayService.getMayFormTenLMCBB(ten);
            System.out.println(ten);
            System.out.println(listLMay_View.size());
            Fillphong(listMay_View);
        }
    }//GEN-LAST:event_cbbLoaiMayActionPerformed

    private void cbbTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTrangThaiActionPerformed
        if (cbbTrangThai.getSelectedIndex() == 0) {
            Fillphong(_iMayService.getAllMay());
        } else {
            int tt = 1;

            if (cbbTrangThai.getSelectedItem().equals("Sẵn sàng")) {
                tt = 0;
            } else if (cbbTrangThai.getSelectedItem().equals("Đang hoạt động")) {
                tt = 1;
            } else if (cbbTrangThai.getSelectedItem().equals("Đang sửa chữa")) {
                tt = 2;
            }
            listMay_View = _iMayService.getMayFormTT(tt);
            System.out.println(listLMay_View.size());
            Fillphong(listMay_View);
        }

    }//GEN-LAST:event_cbbTrangThaiActionPerformed

    

    class MenuItemListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
//            statusLabel.setText(e.getActionCommand() + " JMenuItem clicked.");
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbbLoaiMay;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel pnl;
    // End of variables declaration//GEN-END:variables
}
