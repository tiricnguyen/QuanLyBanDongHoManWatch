/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import domainModel.LoaiDongHo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lombok.Builder;
import service.LoaiDongHoService;
import service.impl.LoaiDongHoServiceImpl;
import viewModel.LoaiDongHoResponse;

/**
 *
 * @author Admin
 */
public class ViewLoaiDongHo extends javax.swing.JFrame {

    private LoaiDongHoService ldhImpl = new LoaiDongHoServiceImpl();
    private List<LoaiDongHoResponse> listLDH = new ArrayList<>();
    private List<LoaiDongHoResponse> listLDH2 = new ArrayList<>();

    public ViewLoaiDongHo() {
        initComponents();
        setLocationRelativeTo(null);
        loadData();
    }

    private void showData(List<LoaiDongHoResponse> listLDH) {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(new String[]{"STT", "Mã", "Tên"});
        tblLoaiDongHo.setModel(dtm);
        int i = 1;
        for (LoaiDongHoResponse x : listLDH) {
            dtm.addRow(x.toDataRow(i++));
        }
    }

    private void showData2(List<LoaiDongHoResponse> listLDH2) {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(new String[]{"STT", "Mã", "Tên"});
        tblLoaiDongHo1.setModel(dtm);
        int i = 1;
        for (LoaiDongHoResponse x : listLDH2) {
            dtm.addRow(x.toDataRow(i++));
        }
    }

    private void loadData() {
        listLDH = ldhImpl.getAllByTrangThai(1);
        showData(listLDH);
        listLDH2 = ldhImpl.getAllByTrangThai(0);
        showData2(listLDH2);
    }

    private void fillData(int i) {
        LoaiDongHoResponse sp = listLDH.get(i);
        txtMa.setText(sp.getMa());
        txtTen.setText(sp.getTen());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtTen = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnThêm = new javax.swing.JButton();
        btnCapNhap = new javax.swing.JButton();
        btnXuatExcel = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        tab = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblLoaiDongHo = new rojeru_san.complementos.RSTableMetro();
        btnAn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnSuDung = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblLoaiDongHo1 = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Loại Đồng Hồ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12)))); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(425, 380));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        txtTen.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 153, 255)));

        jLabel2.setText("Mã:");

        txtMa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 153, 255)));

        jLabel3.setText("Tên:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnThêm.setBackground(new java.awt.Color(0, 153, 255));
        btnThêm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThêm.setForeground(new java.awt.Color(255, 255, 255));
        btnThêm.setText("Thêm");
        btnThêm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThêmActionPerformed(evt);
            }
        });

        btnCapNhap.setBackground(new java.awt.Color(0, 153, 255));
        btnCapNhap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCapNhap.setForeground(new java.awt.Color(255, 255, 255));
        btnCapNhap.setText("Cập Nhập");
        btnCapNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhapActionPerformed(evt);
            }
        });

        btnXuatExcel.setBackground(new java.awt.Color(0, 153, 255));
        btnXuatExcel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXuatExcel.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatExcel.setText("Xuất");
        btnXuatExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatExcelActionPerformed(evt);
            }
        });

        btnThoat.setBackground(new java.awt.Color(0, 153, 255));
        btnThoat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThoat.setForeground(new java.awt.Color(255, 255, 255));
        btnThoat.setText("Exit");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnThêm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCapNhap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
                    .addComponent(btnXuatExcel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnThêm)
                        .addGap(27, 27, 27)
                        .addComponent(btnCapNhap)
                        .addGap(26, 26, 26)
                        .addComponent(btnXuatExcel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThoat))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel1.setText("Tìm Kiếm");

        txtTimKiem.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 153, 255)));
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Loại Đồng Hồ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12)))); // NOI18N

        tblLoaiDongHo.setModel(new javax.swing.table.DefaultTableModel(
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
        tblLoaiDongHo.setColorBackgoundHead(new java.awt.Color(0, 153, 255));
        tblLoaiDongHo.setColorBordeFilas(new java.awt.Color(0, 153, 255));
        tblLoaiDongHo.setColorBordeHead(new java.awt.Color(255, 255, 255));
        tblLoaiDongHo.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tblLoaiDongHo.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tblLoaiDongHo.setFocusCycleRoot(true);
        tblLoaiDongHo.setFuenteFilas(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblLoaiDongHo.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblLoaiDongHo.setFuenteHead(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblLoaiDongHo.setGridColor(new java.awt.Color(255, 255, 255));
        tblLoaiDongHo.setGrosorBordeFilas(0);
        tblLoaiDongHo.setGrosorBordeHead(0);
        tblLoaiDongHo.setRowHeight(25);
        tblLoaiDongHo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLoaiDongHoMouseClicked(evt);
            }
        });
        tblLoaiDongHo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblLoaiDongHoKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tblLoaiDongHo);

        btnAn.setBackground(new java.awt.Color(0, 153, 255));
        btnAn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAn.setForeground(new java.awt.Color(255, 255, 255));
        btnAn.setText("Ẩn");
        btnAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAn)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tab.addTab("Sử Dụng", jPanel7);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Loại Đồng Hồ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12)))); // NOI18N

        btnSuDung.setBackground(new java.awt.Color(0, 153, 255));
        btnSuDung.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSuDung.setForeground(new java.awt.Color(255, 255, 255));
        btnSuDung.setText("Sử dụng");
        btnSuDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuDungActionPerformed(evt);
            }
        });

        tblLoaiDongHo1.setModel(new javax.swing.table.DefaultTableModel(
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
        tblLoaiDongHo1.setColorBackgoundHead(new java.awt.Color(0, 153, 255));
        tblLoaiDongHo1.setColorBordeFilas(new java.awt.Color(0, 153, 255));
        tblLoaiDongHo1.setColorBordeHead(new java.awt.Color(255, 255, 255));
        tblLoaiDongHo1.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tblLoaiDongHo1.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tblLoaiDongHo1.setFocusCycleRoot(true);
        tblLoaiDongHo1.setFuenteFilas(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblLoaiDongHo1.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblLoaiDongHo1.setFuenteHead(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblLoaiDongHo1.setGridColor(new java.awt.Color(255, 255, 255));
        tblLoaiDongHo1.setGrosorBordeFilas(0);
        tblLoaiDongHo1.setGrosorBordeHead(0);
        tblLoaiDongHo1.setRowHeight(25);
        tblLoaiDongHo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLoaiDongHo1MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblLoaiDongHo1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSuDung, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSuDung)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tab.addTab("Đã Ẩn", jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(tab)))
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

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        if (tab.getSelectedIndex() == 0) {
            listLDH = ldhImpl.getAllByTenOrTrangThai(txtTimKiem.getText(), 1);
            showData(listLDH);
        } else {
            listLDH2 = ldhImpl.getAllByTenOrTrangThai(txtTimKiem.getText(), 0);
            showData2(listLDH2);
        }
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void btnThêmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThêmActionPerformed
        LoaiDongHo ldh = new LoaiDongHo();
        ldh.setMa(txtMa.getText());
        ldh.setTen(txtTen.getText());
        ldh.setTrangThai(1);
        JOptionPane.showMessageDialog(this, ldhImpl.insert(ldh));
        loadData();
    }//GEN-LAST:event_btnThêmActionPerformed

    private void btnCapNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhapActionPerformed
        int i = tblLoaiDongHo.getSelectedRow();
        LoaiDongHoResponse ldhRe = listLDH.get(i);
        LoaiDongHo ldh = ldhImpl.findById(ldhRe.getId());
        ldh.setMa(txtMa.getText());
        ldh.setTen(txtTen.getText());
        JOptionPane.showMessageDialog(this, "Cập nhật " + ldhImpl.update(ldh));
        loadData();
    }//GEN-LAST:event_btnCapNhapActionPerformed

    private void btnAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnActionPerformed
        int i = tblLoaiDongHo.getSelectedRow();
        LoaiDongHoResponse ldhRe = listLDH.get(i);
        LoaiDongHo ldh = ldhImpl.findById(ldhRe.getId());
        ldh.setTrangThai(0);
        JOptionPane.showMessageDialog(this, "Ẩn " + ldhImpl.update(ldh));
        loadData();
    }//GEN-LAST:event_btnAnActionPerformed

    private void btnSuDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuDungActionPerformed
        int i = tblLoaiDongHo1.getSelectedRow();
        LoaiDongHoResponse ldhRe = listLDH2.get(i);
        LoaiDongHo ldh = ldhImpl.findById(ldhRe.getId());
        ldh.setTrangThai(1);
        JOptionPane.showMessageDialog(this, "Khôi phục " + ldhImpl.update(ldh));
        loadData();
    }//GEN-LAST:event_btnSuDungActionPerformed

    private void btnXuatExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatExcelActionPerformed
        JOptionPane.showMessageDialog(this, ldhImpl.printExcel());
    }//GEN-LAST:event_btnXuatExcelActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        new ViewChiTietSanPham().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void tblLoaiDongHoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoaiDongHoMouseClicked
        // TODO add your handling code here:
        int i = tblLoaiDongHo.getSelectedRow();
        fillData(i);
    }//GEN-LAST:event_tblLoaiDongHoMouseClicked

    private void tblLoaiDongHo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoaiDongHo1MouseClicked
        // TODO add your handling code here:
        int i = tblLoaiDongHo1.getSelectedRow();
        fillData(i);
    }//GEN-LAST:event_tblLoaiDongHo1MouseClicked

    private void tblLoaiDongHoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblLoaiDongHoKeyReleased
        // TODO add your handling code here:
        int i = tblLoaiDongHo.getSelectedRow();
        LoaiDongHoResponse ldhRe = listLDH.get(i);
        LoaiDongHo ldh = ldhImpl.findById(ldhRe.getId());
        ldh.setMa(tblLoaiDongHo.getValueAt(i, 1).toString());
        ldh.setTen(tblLoaiDongHo.getValueAt(i, 2).toString());
        JOptionPane.showMessageDialog(this, "Cập nhật " + ldhImpl.update(ldh));
        loadData();
    }//GEN-LAST:event_tblLoaiDongHoKeyReleased

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
            java.util.logging.Logger.getLogger(ViewLoaiDongHo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewLoaiDongHo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewLoaiDongHo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewLoaiDongHo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewLoaiDongHo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAn;
    private javax.swing.JButton btnCapNhap;
    private javax.swing.JButton btnSuDung;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnThêm;
    private javax.swing.JButton btnXuatExcel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane tab;
    private rojeru_san.complementos.RSTableMetro tblLoaiDongHo;
    private rojeru_san.complementos.RSTableMetro tblLoaiDongHo1;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
