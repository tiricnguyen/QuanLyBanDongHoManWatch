package view;

import domainModel.ChiTietSanPham;
import domainModel.HoaDon;
import domainModel.HoaDonChiTiet;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import service.HoaDonChiTietService;
import service.HoaDonService;
import service.SerialBanHangService;
import service.impl.HoaDonChiTietServiceIplm;
import service.impl.HoaDonServiceIplm;
import service.impl.SerialBanHangServiceImpl;
import viewModel.HoaDonChiTietResponse;
import viewModel.HoaDonResponse;
import viewModel.SerialBanHangResponse;

public class ViewHoaDon extends javax.swing.JPanel {

    private List<HoaDonResponse> listHD = new ArrayList<>();
    private HoaDonService hoaDonService = new HoaDonServiceIplm();
    private HoaDonChiTietService hoaDonChiTietService = new HoaDonChiTietServiceIplm();
    private SerialBanHangService serialBanHangService = new SerialBanHangServiceImpl();

    public ViewHoaDon() {
        initComponents();
        listHD = hoaDonService.getAllResponse();
        loadTableHoaDon(listHD);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        tbHoaDon = new rojeru_san.complementos.RSTableMetro();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblGioHang = new rojeru_san.complementos.RSTableMetro();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblSerialBanHang = new rojeru_san.complementos.RSTableMetro();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        cbxTrangThai = new javax.swing.JComboBox<>();
        rSButtonIconI1 = new rojerusan.RSButtonIconI();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rSButtonIconI2 = new rojerusan.RSButtonIconI();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1169,691)
        );

        tbHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HĐ", "Tên NV", "Tên KH", "Mã Voucher", "Ngày Tạo", "Ngày Hẹn", "Giảm Giá", "Tên Người Nhận", "Số Điện Thoại", "Ghi Chú", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbHoaDon.setColorBackgoundHead(new java.awt.Color(224, 31, 62));
        tbHoaDon.setColorBordeFilas(new java.awt.Color(0, 153, 255));
        tbHoaDon.setColorBordeHead(new java.awt.Color(255, 255, 255));
        tbHoaDon.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbHoaDon.setColorSelBackgound(new java.awt.Color(51, 204, 255));
        tbHoaDon.setFuenteFilas(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbHoaDon.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbHoaDon.setFuenteHead(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tbHoaDon.setGridColor(new java.awt.Color(255, 255, 255));
        tbHoaDon.setGrosorBordeFilas(0);
        tbHoaDon.setGrosorBordeHead(0);
        tbHoaDon.setRowHeight(25);
        tbHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHoaDonMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbHoaDon);
        if (tbHoaDon.getColumnModel().getColumnCount() > 0) {
            tbHoaDon.getColumnModel().getColumn(0).setResizable(false);
        }

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Thành Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGioHang.setColorBackgoundHead(new java.awt.Color(224, 31, 62));
        tblGioHang.setColorBordeFilas(new java.awt.Color(0, 153, 255));
        tblGioHang.setColorBordeHead(new java.awt.Color(255, 255, 255));
        tblGioHang.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tblGioHang.setColorSelBackgound(new java.awt.Color(51, 204, 255));
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
        });
        jScrollPane4.setViewportView(tblGioHang);
        if (tblGioHang.getColumnModel().getColumnCount() > 0) {
            tblGioHang.getColumnModel().getColumn(0).setResizable(false);
            tblGioHang.getColumnModel().getColumn(1).setResizable(false);
            tblGioHang.getColumnModel().getColumn(2).setResizable(false);
            tblGioHang.getColumnModel().getColumn(3).setResizable(false);
        }

        tblSerialBanHang.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSerialBanHang.setColorBackgoundHead(new java.awt.Color(224, 31, 62));
        tblSerialBanHang.setColorBordeFilas(new java.awt.Color(0, 153, 255));
        tblSerialBanHang.setColorBordeHead(new java.awt.Color(255, 255, 255));
        tblSerialBanHang.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tblSerialBanHang.setColorSelBackgound(new java.awt.Color(51, 204, 255));
        tblSerialBanHang.setFuenteFilas(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblSerialBanHang.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblSerialBanHang.setFuenteHead(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblSerialBanHang.setGridColor(new java.awt.Color(255, 255, 255));
        tblSerialBanHang.setGrosorBordeFilas(0);
        tblSerialBanHang.setGrosorBordeHead(0);
        tblSerialBanHang.setRowHeight(25);
        jScrollPane5.setViewportView(tblSerialBanHang);
        if (tblSerialBanHang.getColumnModel().getColumnCount() > 0) {
            tblSerialBanHang.getColumnModel().getColumn(0).setResizable(false);
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

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(224, 31, 62)));
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

        cbxTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chờ  Thanh Toán", "Đã Hủy", "Đã Thanh Toán", "Tất Cả" }));
        cbxTrangThai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTrangThaiItemStateChanged(evt);
            }
        });

        rSButtonIconI1.setBackground(new java.awt.Color(224, 31, 62));
        rSButtonIconI1.setText("Export");
        rSButtonIconI1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rSButtonIconI1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonIconI1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Trạng Thái Hóa Đơn:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Tìm Kiếm:");

        rSButtonIconI2.setBackground(new java.awt.Color(224, 31, 62));
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
                            .addComponent(cbxTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(cbxTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void tbHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHoaDonMouseClicked
        int rowHDC = tbHoaDon.getSelectedRow();
        HoaDon hd = hoaDonService.getAll().get(rowHDC);
        loadGioHang(hoaDonChiTietService.getGioHang(hd.getId()));
    }//GEN-LAST:event_tbHoaDonMouseClicked

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked

        int rowGH = tblGioHang.getSelectedRow();
        HoaDonChiTietResponse hdctRe = hoaDonChiTietService.getAllReponse().get(rowGH);
        List<SerialBanHangResponse> listSerialBanHang = serialBanHangService.getAllById(hdctRe.getId(), 1);
        loadSerialBanHang(listSerialBanHang);
    }//GEN-LAST:event_tblGioHangMouseClicked

    private void cbxTrangThaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxTrangThaiItemStateChanged
        int index = cbxTrangThai.getSelectedIndex();
        if (index == 0) {
            loadTableHoaDon(hoaDonService.locTrangThai(0));
        } else if (index == 1) {
            loadTableHoaDon(hoaDonService.locTrangThai(1));
        } else if (index == 2) {
            loadTableHoaDon(hoaDonService.locTrangThai(2));
        } else {
            loadTableHoaDon(hoaDonService.getAllResponse());
        }
    }//GEN-LAST:event_cbxTrangThaiItemStateChanged

    private void rSButtonIconI1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonIconI1ActionPerformed
        printExcel();
    }//GEN-LAST:event_rSButtonIconI1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxTrangThai;
    private javax.swing.JComboBox<String> jComboBox1;
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
    private rojeru_san.complementos.RSTableMetro tbHoaDon;
    private rojeru_san.complementos.RSTableMetro tblGioHang;
    private rojeru_san.complementos.RSTableMetro tblSerialBanHang;
    // End of variables declaration//GEN-END:variables

    private void loadTableHoaDon(List<HoaDonResponse> list) {
        DefaultTableModel dtm = (DefaultTableModel) tbHoaDon.getModel();
        dtm.setRowCount(0);
        for (HoaDonResponse x : list) {
            dtm.addRow(x.toDaTaRow());
        }
    }

    private void loadGioHang(List<HoaDonChiTietResponse> list) {

        DefaultTableModel dtm = (DefaultTableModel) tblGioHang.getModel();
        dtm.setRowCount(0);
        int stt = 1;
        for (HoaDonChiTietResponse x : list) {
            dtm.addRow(new Object[]{stt++, x.getMaDongHo(), x.getTenDongHo(), x.getSoLuong(), x.getDonGia().multiply(BigDecimal.valueOf(x.getSoLuong()))});
        }
    }

    private void loadSerialBanHang(List<SerialBanHangResponse> list) {
        DefaultTableModel dtm = (DefaultTableModel) tblSerialBanHang.getModel();
        dtm.setRowCount(0);
        for (SerialBanHangResponse x : list) {
            dtm.addRow(new Object[]{x.getMa()});
        }

    }

    public void printExcel() {
        HoaDonService hd = new HoaDonServiceIplm();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("danh_sach_new");
            XSSFRow row = null;
            Cell cell = null;

            row = sheet.createRow(0);
            cell = row.createCell(0);
            cell.setCellValue("Mã Hóa Đơn");

            cell = row.createCell(1);
            cell.setCellValue("Tên Nhân Viên ");

            cell = row.createCell(2);
            cell.setCellValue("Tên Khách Hàng");

            cell = row.createCell(3);
            cell.setCellValue("Mã Voucher");

            cell = row.createCell(4);
            cell.setCellValue("Ngày Tạo");

            cell = row.createCell(5);
            cell.setCellValue("Ngày Hẹn");

            cell = row.createCell(6);
            cell.setCellValue("Ngày Nhận");

            cell = row.createCell(7);
            cell.setCellValue("Giảm Giá");

            cell = row.createCell(8);
            cell.setCellValue("Tên Người Nhận");

            cell = row.createCell(9);
            cell.setCellValue("Số Điện Thoại");

            cell = row.createCell(10);
            cell.setCellValue("Ghi Chú");

            cell = row.createCell(11);
            cell.setCellValue("Trạng Thái");
            List<HoaDonResponse> listExPort = hd.getAllResponse();
            for (int i = 1; i < listExPort.size(); i++) {

                row = sheet.createRow(i);
                cell = row.createCell(0);
                cell.setCellValue(tbHoaDon.getValueAt(i, 0).toString());

                cell = row.createCell(1);
                cell.setCellValue(tbHoaDon.getValueAt(i, 1).toString());

                cell = row.createCell(2);
                cell.setCellValue(tbHoaDon.getValueAt(i, 2).toString());

                cell = row.createCell(3);
                cell.setCellValue(tbHoaDon.getValueAt(i, 3).toString());

                cell = row.createCell(4);
                cell.setCellValue(tbHoaDon.getValueAt(i, 4).toString());

                cell = row.createCell(5);
                cell.setCellValue(tbHoaDon.getValueAt(i, 5).toString());

                cell = row.createCell(6);
                cell.setCellValue(tbHoaDon.getValueAt(i, 6).toString());

                cell = row.createCell(7);
                cell.setCellValue(tbHoaDon.getValueAt(i, 7).toString());

                cell = row.createCell(8);
                cell.setCellValue(tbHoaDon.getValueAt(i, 8).toString());

                cell = row.createCell(9);
                cell.setCellValue(tbHoaDon.getValueAt(i, 9).toString());

                cell = row.createCell(10);
                cell.setCellValue(tbHoaDon.getValueAt(i, 10).toString());

                cell = row.createCell(11);
                cell.setCellValue(tbHoaDon.getValueAt(i, 11).toString());

            }
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter fileName = new FileNameExtensionFilter("Excel Files", "xls", "xlsx", "xlsm");
            chooser.setFileFilter(fileName);
            if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                String path = chooser.getSelectedFile().getPath();
                if (!path.contains(".xlsx")) {
                    path += ".xlsx";
                }
                FileOutputStream fos = new FileOutputStream(path);
                workbook.write(fos);
                fos.flush();
                fos.close();

            }

            JOptionPane.showMessageDialog(this, "Thành công");

        } catch (Exception e) {
            e.printStackTrace(System.out);
            JOptionPane.showMessageDialog(this, "Thất bại");
        }

    }
}
