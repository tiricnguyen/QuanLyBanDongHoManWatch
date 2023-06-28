package view;

import domainModel.HoaDon;
import domainModel.NhanVien;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import service.GiaoCaService;
import service.HoaDonService;
import service.NhanVienService;
import service.impl.GiaoCaServiceImpl;
import service.impl.HoaDonServiceIplm;
import service.impl.NhanVienServiceImplm;
import viewModel.NhanVienResponse;

public class ViewGiaoCa extends javax.swing.JPanel {
    
    private NhanVienService nvService = new NhanVienServiceImplm();
    private HoaDonService hdService = new HoaDonServiceIplm();
    private static GiaoCaService gcService = new GiaoCaServiceImpl();
    private static NhanVien nvDN = new NhanVien();
    
    public ViewGiaoCa(NhanVien nv) {
        initComponents();
        nvDN = nv;
        loadCbxNhanVien(nvService.getAllByTrangThai(1));
        
        txtNhanVienTrucCa.setText(nv.getMa() + "-" + nv.getHoVaTen());
//        txtTienMatDauCa.setText();
        txtTongHoaDon.setText(String.valueOf(tinhHoaDon()));
//        txtGioVaoCa.setText(gcService.getAll().get(0).get);
    }
    
    private void tongTien() {
        BigDecimal tong = new BigDecimal(0);
        for (int i = 0; i < tblKiemDemTien.getRowCount(); i++) {
            tong = tong.add(BigDecimal.valueOf(Long.parseLong(tblKiemDemTien.getValueAt(i, 2).toString())));
        }
        DecimalFormat df = new DecimalFormat("#,###");
        txtTienTongKetCaCuoiNgay.setText(df.format(tong));
    }

    
    private int tinhHoaDon() {
        if (String.valueOf(demHoaDon(1)) == null) {
            txtHoaDonDaThanhToan.setText(String.valueOf(0));
        } else {
            txtHoaDonDaThanhToan.setText(String.valueOf(demHoaDon(1)));
        }
        if (String.valueOf(demHoaDon(0)) == null) {
            txtHoaDonChoThanhToan.setText(String.valueOf(0));
        } else {
            txtHoaDonChoThanhToan.setText(String.valueOf(demHoaDon(0)));
        }
        if (String.valueOf(demHoaDon(2)) == null) {
            txtHoaDonDaHuy.setText(String.valueOf(0));
        } else {
            txtHoaDonDaHuy.setText(String.valueOf(demHoaDon(2)));
        }
        
        int choTT = Integer.parseInt(txtHoaDonDaThanhToan.getText());
        int daTT = Integer.parseInt(txtHoaDonChoThanhToan.getText());
        int huy = Integer.parseInt(txtHoaDonDaHuy.getText());
        return choTT + daTT + huy;
    }
    
    private int demHoaDon(int trangThai) {
        List<HoaDon> listHoaDon = hdService.getAll(trangThai);
        int tongHoaDon = 0;
        for (HoaDon x : listHoaDon) {
            tongHoaDon++;
        }
        return trangThai;
    }
    
    private void loadCbxNhanVien(List<NhanVienResponse> list) {
        cbxNhanVienGiaoCa.removeAllItems();
        for (NhanVienResponse x : list) {
            cbxNhanVienGiaoCa.addItem(x.getMa() + "-" + x.getHoVaTen());
        }
        // skcbx = list.size();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        kGradientPanel2 = new com.k33ptoo.components.KGradientPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtGioVaoCa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNhanVienTrucCa = new javax.swing.JTextField();
        txtTienMatDauCa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTongHoaDon = new javax.swing.JTextField();
        txtHoaDonDaThanhToan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtHoaDonChoThanhToan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtHoaDonDaHuy = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtTienMat = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtTienChuyenKhoan = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtTongTienTrongCa = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtTongTienMatCuoiCa = new javax.swing.JTextField();
        cbxNhanVienGiaoCa = new javax.swing.JComboBox<>();
        txtTienPhatSinh = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtLyDoPhatSinh = new javax.swing.JTextArea();
        btnKetCa = new com.k33ptoo.components.KButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtTienTongKetCaCuoiNgay = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblKiemDemTien = new rojeru_san.complementos.RSTableMetro();
        lblDongHo = new rojeru_san.RSLabelHora();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1169,691)
        );

        kGradientPanel1.setkEndColor(new java.awt.Color(224, 31, 62));
        kGradientPanel1.setkStartColor(new java.awt.Color(224, 31, 62));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Chi Tiết Kiểm Đếm");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                .addContainerGap())
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        kGradientPanel2.setkEndColor(new java.awt.Color(224, 31, 62));
        kGradientPanel2.setkStartColor(new java.awt.Color(224, 31, 62));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Bàn Giao Ca");

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Giờ Vào Ca:");

        txtGioVaoCa.setEditable(false);
        txtGioVaoCa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 0)));
        txtGioVaoCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGioVaoCaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Nhân Viên Trực Ca:");

        txtNhanVienTrucCa.setEditable(false);
        txtNhanVienTrucCa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 0)));

        txtTienMatDauCa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Tiền Mặt Đầu Ca: (1)");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Tổng Số Hóa Đơn:");

        txtTongHoaDon.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 0)));

        txtHoaDonDaThanhToan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Hóa Đơn Đã Thanh Toán:");

        txtHoaDonChoThanhToan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Hóa Đơn Chờ Thanh Toán:");

        txtHoaDonDaHuy.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Hóa Đơn Đã Hủy:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Giờ Hiện Tại:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Nhân Viên Bàn Giao Ca:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Tiền Mặt : (2)");

        txtTienMat.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 0)));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Tiền Chuyển Khoản : (3)");

        txtTienChuyenKhoan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 0)));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Tổng Tiiền Trong Ca: (4):(2)+(3)");

        txtTongTienTrongCa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 0)));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Tổng Tiền Mặt Cuối Ca (5):(1)+(2)");

        txtTongTienMatCuoiCa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 0)));

        cbxNhanVienGiaoCa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtTienPhatSinh.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 0)));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Tiền Phát Sinh: (4) - (5)");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("Lý do phát sinh:");

        txtLyDoPhatSinh.setColumns(20);
        txtLyDoPhatSinh.setRows(5);
        jScrollPane1.setViewportView(txtLyDoPhatSinh);

        btnKetCa.setForeground(new java.awt.Color(204, 204, 204));
        btnKetCa.setText("Kết Ca");
        btnKetCa.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnKetCa.setkBorderRadius(50);
        btnKetCa.setkEndColor(new java.awt.Color(224, 31, 62));
        btnKetCa.setkPressedColor(new java.awt.Color(204, 204, 204));
        btnKetCa.setkStartColor(new java.awt.Color(224, 31, 62));
        btnKetCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetCaActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(224, 31, 62));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Tổng Kết Ca Cuối Ngày");

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
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTienTongKetCaCuoiNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTienTongKetCaCuoiNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tblKiemDemTien.setModel(new javax.swing.table.DefaultTableModel(
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
        tblKiemDemTien.setColorBackgoundHead(new java.awt.Color(224, 31, 62));
        tblKiemDemTien.setColorBordeFilas(new java.awt.Color(255, 0, 0));
        tblKiemDemTien.setColorBordeHead(new java.awt.Color(255, 255, 255));
        tblKiemDemTien.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tblKiemDemTien.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tblKiemDemTien.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tblKiemDemTien.setColorSelBackgound(new java.awt.Color(51, 204, 255));
        tblKiemDemTien.setFuenteFilas(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblKiemDemTien.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblKiemDemTien.setFuenteHead(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblKiemDemTien.setGridColor(new java.awt.Color(255, 255, 255));
        tblKiemDemTien.setGrosorBordeHead(0);
        tblKiemDemTien.setRowHeight(40);
        tblKiemDemTien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblKiemDemTienKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tblKiemDemTien);

        lblDongHo.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtHoaDonDaHuy)
                                                .addComponent(txtHoaDonChoThanhToan)
                                                .addComponent(txtHoaDonDaThanhToan)
                                                .addComponent(txtTongHoaDon)
                                                .addComponent(txtTienMatDauCa)
                                                .addComponent(txtNhanVienTrucCa, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtGioVaoCa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTienPhatSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtTongTienMatCuoiCa)
                                            .addComponent(txtTongTienTrongCa)
                                            .addComponent(txtTienChuyenKhoan)
                                            .addComponent(txtTienMat)
                                            .addComponent(cbxNhanVienGiaoCa, 0, 155, Short.MAX_VALUE)
                                            .addComponent(lblDongHo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(btnKetCa, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDongHo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxNhanVienGiaoCa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTienMat, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTienChuyenKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTongTienTrongCa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTongTienMatCuoiCa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGioVaoCa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNhanVienTrucCa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTienMatDauCa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTongHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtHoaDonDaThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtHoaDonChoThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtHoaDonDaHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTienPhatSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(71, 71, 71)
                        .addComponent(btnKetCa, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtGioVaoCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGioVaoCaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGioVaoCaActionPerformed

    private void btnKetCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetCaActionPerformed

    }//GEN-LAST:event_btnKetCaActionPerformed

    private void tblKiemDemTienKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblKiemDemTienKeyReleased

        int row = tblKiemDemTien.getSelectedRow();
        BigDecimal thanhTien = new BigDecimal(String.valueOf(tblKiemDemTien.getValueAt(row, 2)));
        BigDecimal menhGia = new BigDecimal(String.valueOf(tblKiemDemTien.getValueAt(row, 0)));
        String soLuong = tblKiemDemTien.getValueAt(row, 1).toString();
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
        tblKiemDemTien.setValueAt(thanhTien, row, 2);
        tongTien();
    }//GEN-LAST:event_tblKiemDemTienKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btnKetCa;
    private javax.swing.JComboBox<String> cbxNhanVienGiaoCa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    private rojeru_san.RSLabelHora lblDongHo;
    private rojeru_san.complementos.RSTableMetro tblKiemDemTien;
    private javax.swing.JTextField txtGioVaoCa;
    private javax.swing.JTextField txtHoaDonChoThanhToan;
    private javax.swing.JTextField txtHoaDonDaHuy;
    private javax.swing.JTextField txtHoaDonDaThanhToan;
    private javax.swing.JTextArea txtLyDoPhatSinh;
    private javax.swing.JTextField txtNhanVienTrucCa;
    private javax.swing.JTextField txtTienChuyenKhoan;
    private javax.swing.JTextField txtTienMat;
    private javax.swing.JTextField txtTienMatDauCa;
    private javax.swing.JTextField txtTienPhatSinh;
    private javax.swing.JLabel txtTienTongKetCaCuoiNgay;
    private javax.swing.JTextField txtTongHoaDon;
    private javax.swing.JTextField txtTongTienMatCuoiCa;
    private javax.swing.JTextField txtTongTienTrongCa;
    // End of variables declaration//GEN-END:variables

}
