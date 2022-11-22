/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package view;

import domainModel.KhachHang;
import domainModel.NhanVien;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.type.LocalDateTimeType;
import service.KhachHangService;
import service.impl.KhachHangServiceImpl;
import viewModel.KhachHangResponse;
//import service.impl.KhachHangServiceImpl;

public class ViewKhachHang extends javax.swing.JPanel {

    private KhachHangService khImpl = new KhachHangServiceImpl();
    private List<KhachHangResponse> listKh = new ArrayList<>();
    private List<KhachHangResponse> listKhDaXoa = new ArrayList<>();

    private List<KhachHang> list = new ArrayList<>();

    public ViewKhachHang() {
        initComponents();

        listKh = khImpl.getAllByTrangThai(1);
        loadTableHoatDong(listKh);

        listKhDaXoa = khImpl.getAllByTrangThai(0);
        loadTableDaXoa(listKhDaXoa);

    }

    private void loadTableHoatDong(List<KhachHangResponse> list) {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(new String[]{"STT", "Ma", "Họ Và Tên", "Ngày Sinh", "Số Điện Thoại", "Địa Chỉ"});
        tblKhachHang.setModel(dtm);
        int index = 1;
        for (KhachHangResponse x : list) {
            dtm.addRow(x.toDataRow(index));
            index++;
        }
    }

    private void loadTableDaXoa(List<KhachHangResponse> list) {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(new String[]{"STT", "Ma", "Họ Và Tên", "Ngày Sinh", "Số Điện Thoại", "Địa Chỉ"});
        tblKhachHangDaXoa.setModel(dtm);
        int index = 1;
        for (KhachHangResponse x : list) {
            dtm.addRow(x.toDataRow(index));
            index++;
        }
    }

//    public String zenMaKh() {
//        list = khImpl.getAll();
//        String ma = list.get(list.size() - 1).getMa();
//        String maNv = ma.substring(3);
//        System.out.println(maNv);
//        return "KH0" + String.valueOf(Integer.parseInt(maNv) + 1);
//    }
    private KhachHang getFormData() {
        KhachHang kh = new KhachHang();
        kh.setMa(txtMa.getText());
        kh.setHoVaTen(txtHoTen.getText());
        kh.setNgaySinh(txtNgaySinh.getText());
        kh.setDiaChi(txtDiaChi.getText());
        kh.setSdt(txtSdt.getText());
        return kh;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblKhachHang = new rojeru_san.complementos.RSTableMetro();
        jPanel5 = new javax.swing.JPanel();
        txtMa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        txtNgaySinh = new com.github.lgooddatepicker.components.DatePicker();
        btnSua = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnImport = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnXoa1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnCapNhapKhachHangQuayLai = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtKhachHangDaXoa = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblKhachHangDaXoa = new rojeru_san.complementos.RSTableMetro();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1169,691));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1169,691)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(1205, 741));

        jLabel1.setText("Tìm Kiếm:");
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtTimKiem.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 255)));
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Khách Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
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
        tblKhachHang.setColorBackgoundHead(new java.awt.Color(0, 153, 255));
        tblKhachHang.setColorBordeFilas(new java.awt.Color(0, 153, 255));
        tblKhachHang.setColorBordeHead(new java.awt.Color(255, 255, 255));
        tblKhachHang.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tblKhachHang.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tblKhachHang.setFocusCycleRoot(true);
        tblKhachHang.setFuenteFilas(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblKhachHang.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblKhachHang.setFuenteHead(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblKhachHang.setGridColor(new java.awt.Color(255, 255, 255));
        tblKhachHang.setGrosorBordeFilas(0);
        tblKhachHang.setGrosorBordeHead(0);
        tblKhachHang.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblKhachHang.setRowHeight(25);
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblKhachHang);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 725, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 504, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Khách Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        txtMa.setEditable(false);
        txtMa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 255)));

        jLabel2.setText("Mã:");
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setText("Họ Và Tên:");
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtHoTen.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 255)));

        jLabel5.setText("Ngày Sinh:");
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setText("Số Điện Thoại:");
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtSdt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 255)));

        jLabel8.setText("Địa Chỉ:");
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtDiaChi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 255)));

        btnSua.setBackground(new java.awt.Color(0, 153, 255));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(0, 153, 255));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnImport.setBackground(new java.awt.Color(0, 153, 255));

        btnXoa.setBackground(new java.awt.Color(0, 153, 255));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnXoa1.setBackground(new java.awt.Color(0, 153, 255));
        btnXoa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHoTen)
                            .addComponent(txtMa)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                .addGap(19, 19, 19)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                            .addComponent(txtSdt)
                            .addComponent(txtDiaChi)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnImport, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnThem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnImport, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Thông Tin Khách Hàng", jPanel3);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1205, 741));

        btnCapNhapKhachHangQuayLai.setBackground(new java.awt.Color(0, 153, 255));
        btnCapNhapKhachHangQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhapKhachHangQuayLaiActionPerformed(evt);
            }
        });

        jLabel12.setText("Tìm Kiếm:");
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtKhachHangDaXoa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 255)));
        txtKhachHangDaXoa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKhachHangDaXoaKeyReleased(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Khách Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        tblKhachHangDaXoa.setModel(new javax.swing.table.DefaultTableModel(
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
        tblKhachHangDaXoa.setColorBackgoundHead(new java.awt.Color(0, 153, 255));
        tblKhachHangDaXoa.setColorBordeFilas(new java.awt.Color(0, 153, 255));
        tblKhachHangDaXoa.setColorBordeHead(new java.awt.Color(255, 255, 255));
        tblKhachHangDaXoa.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tblKhachHangDaXoa.setColorSelBackgound(new java.awt.Color(51, 204, 255));
        tblKhachHangDaXoa.setFuenteFilas(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblKhachHangDaXoa.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblKhachHangDaXoa.setFuenteHead(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblKhachHangDaXoa.setGridColor(new java.awt.Color(255, 255, 255));
        tblKhachHangDaXoa.setGrosorBordeFilas(0);
        tblKhachHangDaXoa.setGrosorBordeHead(0);
        tblKhachHangDaXoa.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblKhachHangDaXoa.setRowHeight(25);
        jScrollPane4.setViewportView(tblKhachHangDaXoa);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1095, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(txtKhachHangDaXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCapNhapKhachHangQuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKhachHangDaXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCapNhapKhachHangQuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Khách Hàng Đã Xóa", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1075, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        String check = khImpl.insert(getFormData());
        JOptionPane.showMessageDialog(this, check);
        listKh = khImpl.getAllByTrangThai(1);
        loadTableHoatDong(listKh);
        listKhDaXoa = khImpl.getAllByTrangThai(0);
        loadTableDaXoa(listKhDaXoa);

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed

        KhachHang kh = new KhachHang();
        kh.setId(listKh.get(tblKhachHang.getSelectedRow()).getId());
        String check = khImpl.update(getFormData());
        JOptionPane.showMessageDialog(this, check);

        listKh = khImpl.getAllByTrangThai(1);
        loadTableHoatDong(listKh);
        listKhDaXoa = khImpl.getAllByTrangThai(0);
        loadTableDaXoa(listKhDaXoa);

    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnCapNhapKhachHangQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhapKhachHangQuayLaiActionPerformed

         try {
            KhachHang kh = new KhachHang();
            kh.setId(listKhDaXoa.get(tblKhachHangDaXoa.getSelectedRow()).getId());
            kh.setMa(listKhDaXoa.get(tblKhachHangDaXoa.getSelectedRow()).getMa());
            kh.setHoVaTen(listKhDaXoa.get(tblKhachHangDaXoa.getSelectedRow()).getHoVaTen());
            kh.setNgaySinh(listKhDaXoa.get(tblKhachHangDaXoa.getSelectedRow()).getNgaySinh());
            kh.setDiaChi(listKhDaXoa.get(tblKhachHangDaXoa.getSelectedRow()).getDiaChi());
            kh.setSdt(listKhDaXoa.get(tblKhachHangDaXoa.getSelectedRow()).getSdt());
            kh.setTrangThai(1);
            String check = khImpl.update(kh);
            JOptionPane.showMessageDialog(this, check);
            
           
            listKh = khImpl.getAllByTrangThai(1);
            loadTableHoatDong(listKh);
            listKhDaXoa = khImpl.getAllByTrangThai(0);
            loadTableDaXoa(listKhDaXoa);
        } catch (Exception e) {
            System.out.println(e);
        }


    }//GEN-LAST:event_btnCapNhapKhachHangQuayLaiActionPerformed

    private void btnXoa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa1ActionPerformed
//        txtMa.setText(zenMaKh());
    }//GEN-LAST:event_btnXoa1ActionPerformed

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        int i = tblKhachHang.getSelectedRow();
        txtMa.setText(khImpl.getAll().get(i).getMa());
        txtHoTen.setText(khImpl.getAll().get(i).getHoVaTen());
        txtDiaChi.setText(khImpl.getAll().get(i).getDiaChi());
        txtNgaySinh.setDate(LocalDate.parse(khImpl.getAll().get(i).getNgaySinh()));
        txtSdt.setText(khImpl.getAll().get(i).getSdt());

    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
         try {
            KhachHang kh = new KhachHang();
            kh.setId(listKh.get(tblKhachHang.getSelectedRow()).getId());
            kh.setMa(listKh.get(tblKhachHang.getSelectedRow()).getMa());
            kh.setHoVaTen(listKh.get(tblKhachHang.getSelectedRow()).getHoVaTen());
            kh.setNgaySinh(listKh.get(tblKhachHang.getSelectedRow()).getNgaySinh());
            kh.setDiaChi(listKh.get(tblKhachHang.getSelectedRow()).getDiaChi());
            kh.setSdt(listKh.get(tblKhachHang.getSelectedRow()).getSdt());
            kh.setTrangThai(0);
            String check = khImpl.update(kh);
            JOptionPane.showMessageDialog(this, check);
            listKh = khImpl.getAllByTrangThai(1);
            loadTableHoatDong(listKh);
            listKhDaXoa = khImpl.getAllByTrangThai(0);
            loadTableDaXoa(listKhDaXoa);
        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_btnXoaActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        String tenKh = txtTimKiem.getText();
        loadTableHoatDong(khImpl.getAllByTenOrTrangThai(tenKh, 1));
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void txtKhachHangDaXoaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKhachHangDaXoaKeyReleased
        String tenKh = txtTimKiem.getText();
        loadTableDaXoa(khImpl.getAllByTenOrTrangThai(tenKh, 0));
    }//GEN-LAST:event_txtKhachHangDaXoaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhapKhachHangQuayLai;
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoa1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private rojeru_san.complementos.RSTableMetro tblKhachHang;
    private rojeru_san.complementos.RSTableMetro tblKhachHangDaXoa;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtKhachHangDaXoa;
    private javax.swing.JTextField txtMa;
    private com.github.lgooddatepicker.components.DatePicker txtNgaySinh;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
