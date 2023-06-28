/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package view;

import domainModel.GiaoCa;
import domainModel.NhanVien;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import lombok.Builder;
import net.bytebuddy.asm.Advice;
import service.GiaoCaService;
import service.NhanVienService;
import service.impl.GiaoCaServiceImpl;
import service.impl.NhanVienServiceImplm;

/**
 *
 * @author Admin
 */
public class ViewKhaiBaoTienDauCa extends javax.swing.JFrame {

    private static NhanVien nvDN = new NhanVien();
    private static GiaoCaService gcService = new GiaoCaServiceImpl();
    private static NhanVienService nvService = new NhanVienServiceImplm();

    public ViewKhaiBaoTienDauCa(NhanVien nv) {
        initComponents();
        setLocationRelativeTo(null);
        nvDN = nv;
        txtMaNhanVien.setText(nv.getMa());
        LocalDate date = LocalDate.now();
        txtNgayVaoCa.setText(String.valueOf(date) + " ||");
        prepareUI();
    }

    private void tongTien() {

        BigDecimal tong = new BigDecimal(0);
        for (int i = 0; i < tblTongKetCuoiCa.getRowCount(); i++) {
            tong = tong.add(BigDecimal.valueOf(Long.parseLong(tblTongKetCuoiCa.getValueAt(i, 2).toString())));
        }
        DecimalFormat df = new DecimalFormat("#,###");
        txtTienTongKetCaCuoiNgay.setText(df.format(tong));

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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaNhanVien = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNgayVaoCa = new javax.swing.JLabel();
        lblDongHo = new rojeru_san.RSLabelHora();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblTongKetCuoiCa = new rojeru_san.complementos.RSTableMetro();
        btnLuu = new rojerusan.RSButtonHover();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtTienTongKetCaCuoiNgay = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("KHAI BÁO TIỀN ĐẦU CA");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nhân Viên:");

        txtMaNhanVien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtMaNhanVien.setForeground(new java.awt.Color(255, 0, 0));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Giờ Vào Ca:");

        txtNgayVaoCa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNgayVaoCa.setForeground(new java.awt.Color(255, 0, 0));
        txtNgayVaoCa.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        lblDongHo.setForeground(new java.awt.Color(255, 0, 0));

        tblTongKetCuoiCa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"500000", "0", "0"},
                {"200000", "0", "0"},
                {"100000", "0", "0"},
                {"50000", "0", "0"},
                {"20000", "0", "0"},
                {"10000", "0", "0"},
                {"5000", "0", "0"},
                {"2000", "0", "0"},
                {"1000", "0", "0"}
            },
            new String [] {
                "Mệnh Giá", "Số Lượng", "Thành Tiền"
            }
        ));
        tblTongKetCuoiCa.setColorBackgoundHead(new java.awt.Color(224, 31, 62));
        tblTongKetCuoiCa.setColorBordeFilas(new java.awt.Color(255, 0, 0));
        tblTongKetCuoiCa.setColorBordeHead(new java.awt.Color(255, 255, 255));
        tblTongKetCuoiCa.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tblTongKetCuoiCa.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tblTongKetCuoiCa.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tblTongKetCuoiCa.setColorSelBackgound(new java.awt.Color(51, 204, 255));
        tblTongKetCuoiCa.setFuenteFilas(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblTongKetCuoiCa.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblTongKetCuoiCa.setFuenteHead(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblTongKetCuoiCa.setGridColor(new java.awt.Color(255, 255, 255));
        tblTongKetCuoiCa.setGrosorBordeHead(0);
        tblTongKetCuoiCa.setRowHeight(40);
        tblTongKetCuoiCa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblTongKetCuoiCaKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tblTongKetCuoiCa);
        if (tblTongKetCuoiCa.getColumnModel().getColumnCount() > 0) {
            tblTongKetCuoiCa.getColumnModel().getColumn(0).setMinWidth(130);
            tblTongKetCuoiCa.getColumnModel().getColumn(0).setMaxWidth(130);
            tblTongKetCuoiCa.getColumnModel().getColumn(1).setMinWidth(100);
            tblTongKetCuoiCa.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        btnLuu.setBackground(new java.awt.Color(224, 31, 62));
        btnLuu.setText("Lưu");
        btnLuu.setColorHover(new java.awt.Color(224, 31, 50));
        btnLuu.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("X");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(224, 31, 62));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Tổng Kết Ca Cuối Ngày");

        txtTienTongKetCaCuoiNgay.setBackground(new java.awt.Color(255, 255, 255));
        txtTienTongKetCaCuoiNgay.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtTienTongKetCaCuoiNgay.setForeground(new java.awt.Color(255, 255, 255));
        txtTienTongKetCaCuoiNgay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTienTongKetCaCuoiNgay.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTienTongKetCaCuoiNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTienTongKetCaCuoiNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNgayVaoCa, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblDongHo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel4)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNgayVaoCa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblDongHo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        String[] mangTienThua = txtTienTongKetCaCuoiNgay.getText().trim().split(" ");
        String tienTongKeKhaiCuoiNgay = mangTienThua[0].replace(",", "");

        BigDecimal tienKeKhaiCuoiNgay = BigDecimal.valueOf(Long.parseLong(tienTongKeKhaiCuoiNgay));
        if (tienKeKhaiCuoiNgay.compareTo(BigDecimal.ZERO) < 0) {
            JOptionPane.showMessageDialog(this, "Nhập đủ tiền mặt vào ca");
            return;
        } else {
            int ma = 0;
            GiaoCa gc = new GiaoCa();
            if (gcService.getAllVM() == null) {
                ma = 0;
            } else {
                ma = gcService.getAllVM().size() + 1;
            }
            if (ma <= 9) {
                gc.setMa("GC00000" + ma++);
            } else if (ma > 9) {
                gc.setMa("GC0000" + ma++);
            } else if (ma > 99) {
                gc.setMa("GC000" + ma++);
            } else if (ma > 999) {
                gc.setMa("GC00" + ma++);
            }

            gc.setNhanVienTrongCa(nvService.findByMa(txtMaNhanVien.getText().trim()));
            gc.setTienMatDauCa(tienKeKhaiCuoiNgay);

            gc.setThoiGianNhanCa(new Date());
            int chon = JOptionPane.showConfirmDialog(this, "Bạn Có Chắc vào ca không", "Xác Nhận Vào Ca", JOptionPane.YES_NO_OPTION);
            if (chon == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(this, gcService.insert(gc));
                new ViewMain(nvDN).setVisible(true);
                dispose();
            }
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void tblTongKetCuoiCaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblTongKetCuoiCaKeyReleased

        int row = tblTongKetCuoiCa.getSelectedRow();
        BigDecimal thanhTien = new BigDecimal(String.valueOf(tblTongKetCuoiCa.getValueAt(row, 2)));
        BigDecimal menhGia = new BigDecimal(String.valueOf(tblTongKetCuoiCa.getValueAt(row, 0)));
        String soLuong = tblTongKetCuoiCa.getValueAt(row, 1).toString();
        try {
            if (Integer.parseInt(soLuong) < 0) {
                JOptionPane.showMessageDialog(this, "Số Lượng Phải Lớn Hơn 0 !");
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Số Lượng Phải Số !!!");
            return;
        }

        thanhTien = menhGia.multiply(new BigDecimal(soLuong));
        tblTongKetCuoiCa.setValueAt(thanhTien, row, 2);
        tongTien();
    }//GEN-LAST:event_tblTongKetCuoiCaKeyReleased

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewKhaiBaoTienDauCa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewKhaiBaoTienDauCa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewKhaiBaoTienDauCa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewKhaiBaoTienDauCa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewKhaiBaoTienDauCa(nvDN).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonHover btnLuu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane4;
    private rojeru_san.RSLabelHora lblDongHo;
    private rojeru_san.complementos.RSTableMetro tblTongKetCuoiCa;
    private javax.swing.JLabel txtMaNhanVien;
    private javax.swing.JLabel txtNgayVaoCa;
    private javax.swing.JLabel txtTienTongKetCaCuoiNgay;
    // End of variables declaration//GEN-END:variables
}
