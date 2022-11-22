/*         
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package view;

import domainModel.ChiTietSanPham;
import domainModel.LoaiDongHo;
import domainModel.SanPham;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.ChiTietSanPhamService;
import service.LoaiDongHoService;
import service.impl.ChiTietSanPhamServiceImpl;
import service.impl.LoaiDongHoServiceImpl;
import viewModel.ChiTietSanPhamResponse;
import viewModel.LoaiDongHoResponse;

/**
 *
 * @author Admin
 */
public class ViewThongKe extends javax.swing.JPanel {


    public ViewThongKe() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        rSTableMetro2 = new rojeru_san.complementos.RSTableMetro();
        jScrollPane4 = new javax.swing.JScrollPane();
        rSTableMetro3 = new rojeru_san.complementos.RSTableMetro();
        jScrollPane5 = new javax.swing.JScrollPane();
        rSTableMetro4 = new rojeru_san.complementos.RSTableMetro();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        rSButtonIconI1 = new rojerusan.RSButtonIconI();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rSButtonIconI2 = new rojerusan.RSButtonIconI();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1169,691)
        );

        rSTableMetro2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã HĐ", "Mã NV", "Khách Hàng", "SĐT", "Ngày Tạo", "Voucher", "Giảm Giá", "Tổng Tiền", "Ghi Chú", "Trạng Thái"
            }
        ));
        rSTableMetro2.setColorBackgoundHead(new java.awt.Color(0, 153, 255));
        rSTableMetro2.setColorBordeFilas(new java.awt.Color(0, 153, 255));
        rSTableMetro2.setColorBordeHead(new java.awt.Color(255, 255, 255));
        rSTableMetro2.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        rSTableMetro2.setColorSelBackgound(new java.awt.Color(51, 204, 255));
        rSTableMetro2.setFuenteFilas(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rSTableMetro2.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rSTableMetro2.setFuenteHead(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rSTableMetro2.setGridColor(new java.awt.Color(255, 255, 255));
        rSTableMetro2.setGrosorBordeFilas(0);
        rSTableMetro2.setGrosorBordeHead(0);
        rSTableMetro2.setIntercellSpacing(new java.awt.Dimension(0, 0));
        rSTableMetro2.setRowHeight(25);
        jScrollPane3.setViewportView(rSTableMetro2);

        rSTableMetro3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Khách Hàng", "Tên Sản Phẩm", "Số Lượng", "Thành Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        rSTableMetro3.setColorBackgoundHead(new java.awt.Color(0, 153, 255));
        rSTableMetro3.setColorBordeFilas(new java.awt.Color(0, 153, 255));
        rSTableMetro3.setColorBordeHead(new java.awt.Color(255, 255, 255));
        rSTableMetro3.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        rSTableMetro3.setColorSelBackgound(new java.awt.Color(51, 204, 255));
        rSTableMetro3.setFuenteFilas(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rSTableMetro3.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rSTableMetro3.setFuenteHead(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rSTableMetro3.setGridColor(new java.awt.Color(255, 255, 255));
        rSTableMetro3.setGrosorBordeFilas(0);
        rSTableMetro3.setGrosorBordeHead(0);
        rSTableMetro3.setIntercellSpacing(new java.awt.Dimension(0, 0));
        rSTableMetro3.setRowHeight(25);
        jScrollPane4.setViewportView(rSTableMetro3);
        if (rSTableMetro3.getColumnModel().getColumnCount() > 0) {
            rSTableMetro3.getColumnModel().getColumn(0).setResizable(false);
            rSTableMetro3.getColumnModel().getColumn(1).setResizable(false);
            rSTableMetro3.getColumnModel().getColumn(2).setResizable(false);
            rSTableMetro3.getColumnModel().getColumn(3).setResizable(false);
        }

        rSTableMetro4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
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
        rSTableMetro4.setColorBackgoundHead(new java.awt.Color(0, 153, 255));
        rSTableMetro4.setColorBordeFilas(new java.awt.Color(0, 153, 255));
        rSTableMetro4.setColorBordeHead(new java.awt.Color(255, 255, 255));
        rSTableMetro4.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        rSTableMetro4.setColorSelBackgound(new java.awt.Color(51, 204, 255));
        rSTableMetro4.setFuenteFilas(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rSTableMetro4.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rSTableMetro4.setFuenteHead(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rSTableMetro4.setGridColor(new java.awt.Color(255, 255, 255));
        rSTableMetro4.setGrosorBordeFilas(0);
        rSTableMetro4.setGrosorBordeHead(0);
        rSTableMetro4.setIntercellSpacing(new java.awt.Dimension(0, 0));
        rSTableMetro4.setRowHeight(25);
        jScrollPane5.setViewportView(rSTableMetro4);
        if (rSTableMetro4.getColumnModel().getColumnCount() > 0) {
            rSTableMetro4.getColumnModel().getColumn(0).setResizable(false);
        }

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Đổi Hàng:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Chọn Serial muốn đổi:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        kGradientPanel1.setkBorderRadius(35);
        kGradientPanel1.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setOpaque(false);

        jLabel3.setIcon(new javax.swing.ImageIcon("E:\\QuanLyBanDongHoManWatch\\DuAn1ManWatch\\src\\main\\java\\folder\\icons8_search_25px_1.png")); // NOI18N

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jTextField1)))
        );

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        rSButtonIconI1.setBackground(new java.awt.Color(0, 153, 255));
        rSButtonIconI1.setIcon(new javax.swing.ImageIcon("E:\\QuanLyBanDongHoManWatch\\DuAn1ManWatch\\src\\main\\java\\folder\\icons8_xls_export_35px_1.png")); // NOI18N
        rSButtonIconI1.setText("Export");
        rSButtonIconI1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Trạng Thái Hóa Đơn:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Tìm Kiếm:");

        rSButtonIconI2.setBackground(new java.awt.Color(0, 153, 255));
        rSButtonIconI2.setIcon(new javax.swing.ImageIcon("E:\\QuanLyBanDongHoManWatch\\DuAn1ManWatch\\src\\main\\java\\folder\\icons8_female_user_update_35px.png")); // NOI18N
        rSButtonIconI2.setText("Đổi Hàng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(rSButtonIconI2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rSButtonIconI1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rSButtonIconI1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(rSButtonIconI2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private rojerusan.RSButtonIconI rSButtonIconI1;
    private rojerusan.RSButtonIconI rSButtonIconI2;
    private rojeru_san.complementos.RSTableMetro rSTableMetro2;
    private rojeru_san.complementos.RSTableMetro rSTableMetro3;
    private rojeru_san.complementos.RSTableMetro rSTableMetro4;
    // End of variables declaration//GEN-END:variables
}
