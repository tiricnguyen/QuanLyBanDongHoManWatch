/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import domainModel.ChiTietSanPham;
import domainModel.HoaDon;
import domainModel.HoaDonChiTiet;
import domainModel.Serial;
import domainModel.SerialBanHang;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.ChiTietSanPhamService;
import service.HoaDonChiTietService;
import service.HoaDonService;
import service.SerialBanHangService;
import service.SerialService;
import service.impl.ChiTietSanPhamServiceImpl;
import service.impl.HoaDonChiTietServiceIplm;
import service.impl.HoaDonServiceIplm;
import service.impl.SerialBanHangServiceImpl;
import service.impl.SerialServiceImpl;
import viewModel.HoaDonChiTietResponse;
import viewModel.SerialBanHangResponse;
import viewModel.SerialResponse;

/**
 *
 * @author duongnl
 */
public class ViewSerialBanHang extends javax.swing.JFrame {
    
    private HoaDonChiTietService hoaDonChiTietService = new HoaDonChiTietServiceIplm();
    private HoaDonService hoaDonService = new HoaDonServiceIplm();
    private static HoaDon hoadon = new HoaDon();
    private SerialService serialService = new SerialServiceImpl();
    private SerialBanHangService serialBanHangService = new SerialBanHangServiceImpl();
    private ChiTietSanPhamService chiTietSanPhamService = new ChiTietSanPhamServiceImpl();
    private List<SerialBanHang> list = new ArrayList<>();
    
    public ViewSerialBanHang(HoaDon hd) {
        initComponents();
        prepareUI();
        this.hoadon = hd;
        loadGioHang(hoaDonChiTietService.getGioHang(hoadon.getId()));
    }
    
    void prepareUI() {
        setLocationRelativeTo(null);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 35, 35));
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuSerialBh = new javax.swing.JPopupMenu();
        Xoa = new javax.swing.JMenuItem();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblGioHang = new rojeru_san.complementos.RSTableMetro();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listSerial = new javax.swing.JList<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblSerialBanHang = new rojeru_san.complementos.RSTableMetro();
        jButton1 = new javax.swing.JButton();

        MenuSerialBh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuSerialBhMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuSerialBhMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MenuSerialBhMouseReleased(evt);
            }
        });

        Xoa.setText("Xóa");
        Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaActionPerformed(evt);
            }
        });
        MenuSerialBh.add(Xoa);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);

        kGradientPanel1.setkBorderRadius(30);
        kGradientPanel1.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setOpaque(false);

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Đồng Hồ", "Tên Đồng Hồ", "Số Lượng", "Đơn Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGioHang.setColorBackgoundHead(new java.awt.Color(0, 153, 255));
        tblGioHang.setColorBordeFilas(new java.awt.Color(0, 153, 255));
        tblGioHang.setColorBordeHead(new java.awt.Color(255, 255, 255));
        tblGioHang.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tblGioHang.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tblGioHang.setFocusCycleRoot(true);
        tblGioHang.setFuenteFilas(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblGioHang.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblGioHang.setFuenteHead(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblGioHang.setGridColor(new java.awt.Color(255, 255, 255));
        tblGioHang.setGrosorBordeFilas(0);
        tblGioHang.setGrosorBordeHead(0);
        tblGioHang.setRowHeight(25);
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblGioHangMouseReleased(evt);
            }
        });
        tblGioHang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblGioHangKeyReleased(evt);
            }
        });
        jScrollPane6.setViewportView(tblGioHang);

        txtSearch.setText("Search");
        txtSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 51, 255)));
        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchMouseClicked(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        listSerial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listSerialMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listSerial);

        tblSerialBanHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serial"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSerialBanHang.setColorBackgoundHead(new java.awt.Color(0, 153, 255));
        tblSerialBanHang.setColorBordeFilas(new java.awt.Color(0, 153, 255));
        tblSerialBanHang.setColorBordeHead(new java.awt.Color(255, 255, 255));
        tblSerialBanHang.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tblSerialBanHang.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tblSerialBanHang.setFocusCycleRoot(true);
        tblSerialBanHang.setFuenteFilas(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblSerialBanHang.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblSerialBanHang.setFuenteHead(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblSerialBanHang.setGridColor(new java.awt.Color(255, 255, 255));
        tblSerialBanHang.setGrosorBordeFilas(0);
        tblSerialBanHang.setGrosorBordeHead(0);
        tblSerialBanHang.setRowHeight(25);
        tblSerialBanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSerialBanHangMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblSerialBanHangMouseReleased(evt);
            }
        });
        tblSerialBanHang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblSerialBanHangKeyReleased(evt);
            }
        });
        jScrollPane8.setViewportView(tblSerialBanHang);

        jButton1.setText("Thoát");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(0, 15, Short.MAX_VALUE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked
        UUID idHd = hoaDonService.findId(hoadon.getId()).getId();
        int rowGH = tblGioHang.getSelectedRow();
        
        HoaDonChiTietResponse hdctRe = hoaDonChiTietService.getGioHang(idHd).get(rowGH);
        HoaDonChiTiet hdct = new HoaDonChiTiet();
        hdct.setId(hdctRe.getId());
        
        List<SerialBanHangResponse> listSerialBanHang = serialBanHangService.getAllById(hdct.getId(), 1);
        loadSerialBanHang(listSerialBanHang);
        
        ChiTietSanPham ctsp = chiTietSanPhamService.getAll(1).get(rowGH);
        loadSerial(serialService.getAllById(ctsp.getId(), 1));

    }//GEN-LAST:event_tblGioHangMouseClicked

    private void tblGioHangMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseReleased

    }//GEN-LAST:event_tblGioHangMouseReleased

    private void tblGioHangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblGioHangKeyReleased

    }//GEN-LAST:event_tblGioHangKeyReleased

    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked
        txtSearch.setText("");
    }//GEN-LAST:event_txtSearchMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        
        List<SerialResponse> listSerial = serialService.searchSerial(txtSearch.getText().trim(), 1);
        loadSerial(listSerial);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void listSerialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listSerialMouseClicked
        int rowGH = tblGioHang.getSelectedRow();
        
        HoaDonChiTietResponse hdctRe = hoaDonChiTietService.getGioHang(hoadon.getId()).get(rowGH);
        int soLuong = hdctRe.getSoLuong();        
        
        if (tblSerialBanHang.getRowCount() >= soLuong) {
            JOptionPane.showMessageDialog(this, "Bán Ngu Vừa Thôi ");
            return;
        }
        
        int cauHoi = JOptionPane.showConfirmDialog(this, "Co Chan Chan Muon Ban Serial '" + listSerial.getSelectedValue() + "' khum??");
        if (cauHoi == JOptionPane.YES_OPTION) {
            
            HoaDonChiTiet hdct = new HoaDonChiTiet();
            hdct.setId(hdctRe.getId());
            
            SerialBanHang seriBanHang = new SerialBanHang();
            seriBanHang.setHoaDonChiTiet(hdct);
            seriBanHang.setMa(listSerial.getSelectedValue());
            seriBanHang.setTrangThai(1);
            
            JOptionPane.showMessageDialog(this, serialBanHangService.insert(seriBanHang));
            List<SerialBanHangResponse> listSerialBanHang = serialBanHangService.getAllById(hdct.getId(), 1);
            loadSerialBanHang(listSerialBanHang);
            
            Serial serial = serialService.findIdByMa(listSerial.getSelectedValue());
            serial.setTrangThai(0);
            serialService.update(serial);
            
            ChiTietSanPham ctsp = chiTietSanPhamService.getAll(1).get(rowGH);
            loadSerial(serialService.getAllById(ctsp.getId(), 1));
        }
    }//GEN-LAST:event_listSerialMouseClicked

    private void tblSerialBanHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSerialBanHangMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblSerialBanHangMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblSerialBanHangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblSerialBanHangKeyReleased

    }//GEN-LAST:event_tblSerialBanHangKeyReleased

    private void MenuSerialBhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuSerialBhMouseClicked

    }//GEN-LAST:event_MenuSerialBhMouseClicked

    private void XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaActionPerformed
        int x = tblSerialBanHang.getSelectedRow();
        int rowhdct = tblGioHang.getSelectedRow();
        HoaDonChiTietResponse hdctRe = hoaDonChiTietService.getGioHang(hoadon.getId()).get(rowhdct);
        HoaDonChiTiet hdct = new HoaDonChiTiet();
        hdct.setId(hdctRe.getId());
        SerialBanHangResponse serialBh = serialBanHangService.getAllById(hdct.getId(), 1).get(x);
        
        SerialBanHang serial = serialBanHangService.findIdByMa(serialBh.getMa());
        serialService.updateTrangThai(serial.getMa(), 1);
        loadSerial(serialService.getAllById(hdct.getId(), 1));
        serialBanHangService.delete(serial.getId());
        loadSerialBanHang(serialBanHangService.getAllById(hdct.getId(), 1));
    }//GEN-LAST:event_XoaActionPerformed

    private void tblSerialBanHangMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSerialBanHangMouseReleased
        if (evt.isPopupTrigger()) {
            MenuSerialBh.show(tblSerialBanHang, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tblSerialBanHangMouseReleased

    private void MenuSerialBhMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuSerialBhMouseReleased

    }//GEN-LAST:event_MenuSerialBhMouseReleased

    private void MenuSerialBhMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuSerialBhMousePressed

    }//GEN-LAST:event_MenuSerialBhMousePressed
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewSerialBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewSerialBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewSerialBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewSerialBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewSerialBanHang(hoadon).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuSerialBh;
    private javax.swing.JMenuItem Xoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private javax.swing.JList<String> listSerial;
    private rojeru_san.complementos.RSTableMetro tblGioHang;
    private rojeru_san.complementos.RSTableMetro tblSerialBanHang;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private void loadGioHang(List<HoaDonChiTietResponse> list) {
        DefaultTableModel dtm = (DefaultTableModel) tblGioHang.getModel();
        dtm.setRowCount(0);
        int stt = 1;
        for (HoaDonChiTietResponse x : list) {
            dtm.addRow(new Object[]{stt++, x.getMaDongHo(), x.getTenDongHo(), x.getSoLuong(), x.getDonGia()});
        }
        
    }
    
    private void loadSerial(List<SerialResponse> list) {
        DefaultListModel model = new DefaultListModel();
        model.removeAllElements();
        for (SerialResponse x : list) {
            model.addElement(x.getMa());
        }
        listSerial.setModel(model);
    }
    
    private void loadSerialBanHang(List<SerialBanHangResponse> list) {
        DefaultTableModel dtm = (DefaultTableModel) tblSerialBanHang.getModel();
        dtm.setRowCount(0);
        for (SerialBanHangResponse x : list) {
            dtm.addRow(new Object[]{x.getMa()});
        }
        
    }
    
}
