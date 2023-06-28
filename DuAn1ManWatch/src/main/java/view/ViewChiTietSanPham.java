package view;

import domainModel.ChatLieuDay;
import domainModel.ChatLieuMatKinh;
import domainModel.ChatLieuVo;
import domainModel.ChiTietSanPham;
import domainModel.HangDongHo;
import domainModel.LoaiDongHo;
import domainModel.MatDongHo;
import domainModel.NangLuongSuDung;
import domainModel.SanPham;
import java.awt.Image;
import java.io.File;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.ChatLieuDayService;
import service.ChatLieuMatKinhService;
import service.ChatLieuVoService;
import service.ChiTietSanPhamService;
import service.HangDongHoService;
import service.LoaiDongHoService;
import service.MatDongHoService;
import service.NangLuongSuDungService;
import service.SerialService;
import service.impl.ChatLieuDayServiceImpl;
import service.impl.ChatLieuMatKinhServiceImpl;
import service.impl.ChatLieuVoServiceImpl;
import service.impl.ChiTietSanPhamServiceImpl;
import service.impl.HangDongHoServiceImpl;
import service.impl.LoaiDongHoServiceImpl;
import service.impl.MatDongHoServiceImpl;
import service.impl.NangLuongSuDungServiceImpl;
import service.impl.SanPhamServiceImpl;
import service.impl.SerialServiceImpl;
import viewModel.ChatLieuDayRepsonse;
import viewModel.ChatLieuMatKinhResponse;
import viewModel.ChatLieuVoResponse;
import viewModel.ChiTietSanPhamResponse;
import viewModel.HangDongHoResponse;
import viewModel.LoaiDongHoResponse;
import viewModel.MatDongHoResponse;
import viewModel.NangLuongSuDungResponse;
import viewModel.SanPhamResponse;
import viewModel.SerialResponse;

public class ViewChiTietSanPham extends javax.swing.JPanel {

    private ChiTietSanPhamService ctspImpl = new ChiTietSanPhamServiceImpl();
    private LoaiDongHoService ldhImpl = new LoaiDongHoServiceImpl();
    private ChatLieuDayService cldImpl = new ChatLieuDayServiceImpl();
    private ChatLieuMatKinhService clmkImpl = new ChatLieuMatKinhServiceImpl();
    private ChatLieuVoService clvImpl = new ChatLieuVoServiceImpl();
    private HangDongHoService hdhImpl = new HangDongHoServiceImpl();
    private MatDongHoService mdhImpl = new MatDongHoServiceImpl();
    private NangLuongSuDungService nlsdImpl = new NangLuongSuDungServiceImpl();
    private SanPhamServiceImpl spImpl = new SanPhamServiceImpl();
    private SerialService srlImpl = new SerialServiceImpl();
    private List<ChiTietSanPhamResponse> listCTSP1 = new ArrayList<>();
    private List<ChiTietSanPhamResponse> listCTSP2 = new ArrayList<>();

    private String anh;

    public ViewChiTietSanPham() {
        initComponents();
        listCTSP1 = ctspImpl.getAllChiTietSanPham(1);
        loadTable1(listCTSP1);
        listCTSP2 = ctspImpl.getAllChiTietSanPham(0);
        loadTable0(listCTSP2);
        loadCombox();

    }

    private void showData(int row, int trangThai) {
        ChiTietSanPham ctsp = ctspImpl.getAll(trangThai).get(row);
        cbxLoaiDongHo.setSelectedItem(ctsp.getLoaiDongHo().getTen());
        cbxVo1.setSelectedItem(ctsp.getChatLieuVo().getTen());
        cbxHangDongHo.setSelectedItem(ctsp.getHangDongHo().getTen());
        cbxDay1.setSelectedItem(ctsp.getChatLieuDay().getTen());
        cbxMatDongHo.setSelectedItem(ctsp.getMatDongHo().getTen());
        cbxNangLuong.setSelectedItem(ctsp.getNangLuongSD().getTen());
        cbxChatLieuMatKinh.setSelectedItem(ctsp.getChatLieuMatKinh().getTen());
        cbxTenSanPham.setSelectedItem(ctsp.getSanPham().getTen());
        txtSizeDay.setText(ctsp.getSizeDay() + "");
        txtBarCode.setText(ctsp.getBarCode() + "");
        cbxChongNuoc.setSelectedItem(ctsp.getChongNuoc());
        txtMoTa.setText(ctsp.getMoTa());
        txtGiaBan.setText(ctsp.getGiaBan() + "");
        txtGiaNhap.setText(ctsp.getGiaNhap() + "");
        txtSoLuong.setText(ctsp.getSoLuong() + "");
        txtXuatXu.setText(ctsp.getXuatXu());
        cbxSerial.removeAllItems();
        for (SerialResponse x : srlImpl.getAllById(ctsp.getId(), 1)) {
            cbxSerial.addItem(x.getMa());
        }
        imgAnh.setText("");
        imgAnh.setIcon(new ImageIcon(ctsp.getHinhAnh()));

    }

    private ChiTietSanPham getFormData() {
        ChiTietSanPham ctsp = new ChiTietSanPham();

        LoaiDongHo ldh = ldhImpl.findIdCbx(cbxLoaiDongHo.getSelectedItem().toString());
        ctsp.setLoaiDongHo(ldh);
        ChatLieuVo clv = clvImpl.findIdCbx(cbxVo1.getSelectedItem().toString());
        ctsp.setChatLieuVo(clv);
        HangDongHo hdh = hdhImpl.findIdCbx(cbxHangDongHo.getSelectedItem().toString());
        ctsp.setHangDongHo(hdh);
        ChatLieuDay cld = cldImpl.findIdCbx(cbxDay1.getSelectedItem().toString());
        ctsp.setChatLieuDay(cld);
        MatDongHo mdh = mdhImpl.findIdCbx(cbxMatDongHo.getSelectedItem().toString());
        ctsp.setMatDongHo(mdh);
        NangLuongSuDung nlsd = nlsdImpl.findIdCbx(cbxNangLuong.getSelectedItem().toString());
        ctsp.setNangLuongSD(nlsd);
        ChatLieuMatKinh clmk = clmkImpl.findIdCbx(cbxChatLieuMatKinh.getSelectedItem().toString());
        ctsp.setChatLieuMatKinh(clmk);
        SanPham sp = spImpl.findIdCbx(cbxTenSanPham.getSelectedItem().toString());
        ctsp.setSanPham(sp);
        if (!txtSizeDay.getText().equals("")
                || !txtGiaNhap.getText().equals("")
                || !txtGiaNhap.getText().equals("")) {
            try {
                ctsp.setSizeDay(Double.parseDouble(txtSizeDay.getText()));
                ctsp.setGiaNhap(BigDecimal.valueOf(Long.parseLong(txtGiaNhap.getText())));
                ctsp.setGiaBan(BigDecimal.valueOf(Long.parseLong(txtGiaBan.getText())));
            } catch (Exception e) {

            }

        }
        ctsp.setBarCode(txtBarCode.getText());
        ctsp.setChongNuoc(cbxChongNuoc.getSelectedItem().toString());
        ctsp.setMoTa(txtMoTa.getText());
        ctsp.setXuatXu(txtXuatXu.getText());

        ctsp.setTrangThai(1);
        return ctsp;
    }

    private void loadCombox() {

        cbxDay1.removeAllItems();
        for (ChatLieuDayRepsonse x : cldImpl.getAllByTrangThai(1)) {
            cbxDay1.addItem(x.getTen());
        }
        cbxChatLieuMatKinh.removeAllItems();
        for (ChatLieuMatKinhResponse x : clmkImpl.getAllByTrangThai(1)) {
            cbxChatLieuMatKinh.addItem(x.getTen());
        }
        cbxHangDongHo.removeAllItems();
        for (HangDongHoResponse x : hdhImpl.getAllByTrangThai(1)) {
            cbxHangDongHo.addItem(x.getTen());
        }

        cbxLoaiDongHo.removeAllItems();
        for (LoaiDongHoResponse x : ldhImpl.getAllByTrangThai(1)) {
            cbxLoaiDongHo.addItem(x.getTen());
        }

        cbxMatDongHo.removeAllItems();
        for (MatDongHoResponse x : mdhImpl.getAllByTrangThai(1)) {
            cbxMatDongHo.addItem(x.getTen());
        }
        cbxNangLuong.removeAllItems();
        for (NangLuongSuDungResponse x : nlsdImpl.getAllByTrangThai(1)) {
            cbxNangLuong.addItem(x.getTen());
        }
        cbxTenSanPham.removeAllItems();
        for (SanPhamResponse x : spImpl.getAllByTrangThai(1)) {
            cbxTenSanPham.addItem(x.getTen());
        }

        cbxVo1.removeAllItems();
        for (ChatLieuVoResponse x : clvImpl.getAllByTrangThai(1)) {
            cbxVo1.addItem(x.getTen());
        }

    }

    private void loadTable1(List<ChiTietSanPhamResponse> list) {
        String header[] = {"STT", "Tên Đồng Hồ", "Tên Hãng", "Tên Loại", "BarCode", "Chống Nước", "Size Dây", "Số Lượng", "Giá bán", "Mô tả"};
        DefaultTableModel model = new DefaultTableModel(header, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblChTietSanPham.setModel(model);
        model.setRowCount(0);
        int index = 1;
        for (ChiTietSanPhamResponse x : list) {
            model.addRow(x.toDataRow(index));
            index++;
        }

    }

    private void loadTable0(List<ChiTietSanPhamResponse> list) {
        String header[] = {"STT", "Tên Đồng Hồ", "Tên Hãng", "Tên Loại", "BarCode", "Chống Nước", "Size Dây", "Số Lượng", "Giá bán", "Mô tả"};
        DefaultTableModel model = new DefaultTableModel(header, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblSanPham0.setModel(model);
        int index = 1;
        for (ChiTietSanPhamResponse x : list) {
            model.addRow(x.toDataRow(index));
            index++;
        }

    }

    private void clear() {
        cbxChongNuoc.setSelectedIndex(0);
        txtGiaBan.setText("");
        txtXuatXu.setText("");
        txtGiaNhap.setText("");
        txtMoTa.setText("");
        txtSizeDay.setText("");
        txtSoLuong.setText("");
        txtXuatXu.setText("");
        txtBarCode.setText("");
        cbxChatLieuMatKinh.setSelectedIndex(0);
        cbxDay1.setSelectedIndex(0);
        cbxHangDongHo.setSelectedIndex(0);
        cbxLoaiDongHo.setSelectedIndex(0);
        cbxMatDongHo.setSelectedIndex(0);
        cbxNangLuong.setSelectedIndex(0);
        cbxTenSanPham.setSelectedIndex(0);
        cbxVo1.setSelectedIndex(0);
        imgAnh.setIcon(null);
        imgAnh.setText("ImageAvatar!!");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tab = new javax.swing.JTabbedPane();
        tab2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblChTietSanPham = new rojeru_san.complementos.RSTableMetro();
        txtTimKiemSanPham1 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        btnXoa = new javax.swing.JButton();
        btnCapNhap = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        ImageSanPham = new javax.swing.JPanel();
        imgAnh = new rojerusan.RSLabelImage();
        cbxTenSanPham = new javax.swing.JComboBox<>();
        btnSerial = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnTenSanPham = new javax.swing.JButton();
        cbxSerial = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        cbxChatLieuMatKinh = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        cbxDay1 = new javax.swing.JComboBox<>();
        btnChatLieuMatKinh = new javax.swing.JButton();
        btnChatLieuDay = new javax.swing.JButton();
        txtSizeDay = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtGiaNhap = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        cbxMatDongHo = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        cbxHangDongHo = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        btnHangDongHo = new javax.swing.JButton();
        btnMatDongHo = new javax.swing.JButton();
        cbxLoaiDongHo = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        cbxNangLuong = new javax.swing.JComboBox<>();
        btnNangLuongSuDung = new javax.swing.JButton();
        btnLoaiDongHo = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        cbxVo1 = new javax.swing.JComboBox<>();
        txtSoLuong = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        cbxChongNuoc = new javax.swing.JComboBox<>();
        btnChatLieuVo = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        txtXuatXu = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        jLabel45 = new javax.swing.JLabel();
        txtBarCode = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnCapNhapDaXoa = new javax.swing.JButton();
        txtTimKiemSanPhamDaXoa = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblSanPham0 = new rojeru_san.complementos.RSTableMetro();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1169,691)
        );

        tab.setBackground(new java.awt.Color(255, 255, 255));
        tab.setPreferredSize(new java.awt.Dimension(1169,691)
        );
        tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabMouseClicked(evt);
            }
        });

        tab2.setBackground(new java.awt.Color(255, 255, 255));
        tab2.setPreferredSize(new java.awt.Dimension(1166, 691)
        );

        tblChTietSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblChTietSanPham.setColorBackgoundHead(new java.awt.Color(255, 51, 51));
        tblChTietSanPham.setColorBordeFilas(new java.awt.Color(0, 153, 255));
        tblChTietSanPham.setColorBordeHead(new java.awt.Color(255, 255, 255));
        tblChTietSanPham.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tblChTietSanPham.setColorSelBackgound(new java.awt.Color(51, 204, 255));
        tblChTietSanPham.setFuenteFilas(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblChTietSanPham.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblChTietSanPham.setFuenteHead(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblChTietSanPham.setGridColor(new java.awt.Color(255, 255, 255));
        tblChTietSanPham.setGrosorBordeFilas(0);
        tblChTietSanPham.setGrosorBordeHead(0);
        tblChTietSanPham.setRowHeight(25);
        tblChTietSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChTietSanPhamMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblChTietSanPham);
        if (tblChTietSanPham.getColumnModel().getColumnCount() > 0) {
            tblChTietSanPham.getColumnModel().getColumn(0).setResizable(false);
            tblChTietSanPham.getColumnModel().getColumn(1).setResizable(false);
            tblChTietSanPham.getColumnModel().getColumn(2).setResizable(false);
            tblChTietSanPham.getColumnModel().getColumn(3).setResizable(false);
        }

        txtTimKiemSanPham1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTimKiemSanPham1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 0)));
        txtTimKiemSanPham1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemSanPham1CaretUpdate(evt);
            }
        });
        txtTimKiemSanPham1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemSanPham1KeyReleased(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setText("Tìm Kiếm:");

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnCapNhap.setText("Cập Nhập");
        btnCapNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhapActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        ImageSanPham.setBackground(new java.awt.Color(255, 255, 255));
        ImageSanPham.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Hình Ảnh")));

        imgAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgAnhMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                imgAnhMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout ImageSanPhamLayout = new javax.swing.GroupLayout(ImageSanPham);
        ImageSanPham.setLayout(ImageSanPhamLayout);
        ImageSanPhamLayout.setHorizontalGroup(
            ImageSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImageSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addContainerGap())
        );
        ImageSanPhamLayout.setVerticalGroup(
            ImageSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImageSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addContainerGap())
        );

        cbxTenSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxTenSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxTenSanPhamMouseClicked(evt);
            }
        });

        btnSerial.setBackground(new java.awt.Color(224, 31, 62));
        btnSerial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSerialActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Serial:");

        btnTenSanPham.setBackground(new java.awt.Color(224, 31, 62));
        btnTenSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTenSanPhamActionPerformed(evt);
            }
        });

        cbxSerial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxSerialMouseClicked(evt);
            }
        });
        cbxSerial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSerialActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Tên Sản Phẩm:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxTenSanPham, 0, 165, Short.MAX_VALUE)
                            .addComponent(cbxSerial, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSerial, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(ImageSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(ImageSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSerial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxSerial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Chất Liệu Mặt Kính:");

        cbxChatLieuMatKinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxChatLieuMatKinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxChatLieuMatKinhMouseClicked(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel27.setText("Chất Liệu Dây:");

        cbxDay1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxDay1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxDay1MouseClicked(evt);
            }
        });

        btnChatLieuMatKinh.setBackground(new java.awt.Color(224, 31, 62));
        btnChatLieuMatKinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChatLieuMatKinhActionPerformed(evt);
            }
        });

        btnChatLieuDay.setBackground(new java.awt.Color(224, 31, 62));
        btnChatLieuDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChatLieuDayActionPerformed(evt);
            }
        });

        txtSizeDay.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(224, 31, 62)));
        txtSizeDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSizeDayActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel33.setText("Size Dây:");

        txtGiaNhap.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(224, 31, 62)));
        txtGiaNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaNhapActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel35.setText("Giá Nhập:");

        cbxMatDongHo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxMatDongHo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxMatDongHoMouseClicked(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel36.setText("Măt Đồng Hồ:");

        cbxHangDongHo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxHangDongHo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxHangDongHoMouseClicked(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel37.setText("Hãng Đồng Hồ:");

        btnHangDongHo.setBackground(new java.awt.Color(224, 31, 62));
        btnHangDongHo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHangDongHoActionPerformed(evt);
            }
        });

        btnMatDongHo.setBackground(new java.awt.Color(224, 31, 62));
        btnMatDongHo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatDongHoActionPerformed(evt);
            }
        });

        cbxLoaiDongHo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxLoaiDongHo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxLoaiDongHoMouseClicked(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel38.setText("Giá Bán:");

        txtGiaBan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(224, 31, 62)));
        txtGiaBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaBanActionPerformed(evt);
            }
        });

        cbxNangLuong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxNangLuong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxNangLuongMouseClicked(evt);
            }
        });

        btnNangLuongSuDung.setBackground(new java.awt.Color(224, 31, 62));
        btnNangLuongSuDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNangLuongSuDungActionPerformed(evt);
            }
        });

        btnLoaiDongHo.setBackground(new java.awt.Color(224, 31, 62));
        btnLoaiDongHo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoaiDongHoActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel39.setText("Loại Đồng Hồ:");

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel40.setText("Năng Lượng Sử Dụng:");

        cbxVo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxVo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxVo1MouseClicked(evt);
            }
        });

        txtSoLuong.setEditable(false);
        txtSoLuong.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(224, 31, 62)));
        txtSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel41.setText("Chất Liệu Vỏ:");

        cbxChongNuoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3ATM", "5ATM", "10ATM", "20ATM" }));
        cbxChongNuoc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxChongNuocItemStateChanged(evt);
            }
        });
        cbxChongNuoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxChongNuocMouseClicked(evt);
            }
        });
        cbxChongNuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxChongNuocActionPerformed(evt);
            }
        });

        btnChatLieuVo.setBackground(new java.awt.Color(224, 31, 62));
        btnChatLieuVo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChatLieuVoActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel42.setText("Chống Nước:");

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel43.setText("Số Lượng:");

        txtXuatXu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(224, 31, 62)));
        txtXuatXu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtXuatXuActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel34.setText("Xuất Xứ:");

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel44.setText("Mô Tả:");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane2.setViewportView(txtMoTa);

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel45.setText("BarCode:");

        txtBarCode.setEditable(false);
        txtBarCode.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(224, 31, 62)));
        txtBarCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBarCodeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cbxChatLieuMatKinh, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChatLieuMatKinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cbxHangDongHo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHangDongHo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel37)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cbxNangLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNangLuongSuDung, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel40)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cbxVo1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChatLieuVo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel41))
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel27)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cbxDay1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChatLieuDay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cbxMatDongHo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMatDongHo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel36)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cbxLoaiDongHo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLoaiDongHo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel39)
                    .addComponent(jLabel42)
                    .addComponent(cbxChongNuoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSizeDay, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(txtGiaNhap)
                    .addComponent(txtGiaBan)
                    .addComponent(txtSoLuong)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 96, Short.MAX_VALUE)))
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtXuatXu, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtBarCode))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbxChatLieuMatKinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbxDay1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnChatLieuMatKinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnChatLieuDay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSizeDay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxHangDongHo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxMatDongHo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnHangDongHo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMatDongHo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBarCode, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbxNangLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbxLoaiDongHo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnNangLuongSuDung, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLoaiDongHo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbxVo1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbxChongNuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnChatLieuVo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tab2Layout = new javax.swing.GroupLayout(tab2);
        tab2.setLayout(tab2Layout);
        tab2Layout.setHorizontalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab2Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKiemSanPham1, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 318, Short.MAX_VALUE)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnCapNhap)
                        .addGap(32, 32, 32)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(171, 171, 171))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab2Layout.createSequentialGroup()
                        .addGroup(tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, tab2Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(10, 10, 10))))
        );
        tab2Layout.setVerticalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiemSanPham1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addContainerGap())
        );

        tab.addTab("Thông Tin Sản Phẩm", tab2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1166,691));

        btnCapNhapDaXoa.setBackground(new java.awt.Color(255, 51, 51));
        btnCapNhapDaXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhapDaXoaActionPerformed(evt);
            }
        });

        txtTimKiemSanPhamDaXoa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTimKiemSanPhamDaXoa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(224, 31, 62)));
        txtTimKiemSanPhamDaXoa.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemSanPhamDaXoaCaretUpdate(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("Tìm Kiếm:");

        tblSanPham0.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSanPham0.setColorBackgoundHead(new java.awt.Color(224, 31, 62));
        tblSanPham0.setColorBordeFilas(new java.awt.Color(0, 153, 255));
        tblSanPham0.setColorBordeHead(new java.awt.Color(255, 255, 255));
        tblSanPham0.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tblSanPham0.setColorSelBackgound(new java.awt.Color(51, 204, 255));
        tblSanPham0.setFuenteFilas(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblSanPham0.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblSanPham0.setFuenteHead(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblSanPham0.setGridColor(new java.awt.Color(255, 255, 255));
        tblSanPham0.setGrosorBordeFilas(0);
        tblSanPham0.setGrosorBordeHead(0);
        tblSanPham0.setRowHeight(25);
        tblSanPham0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPham0MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblSanPham0MouseEntered(evt);
            }
        });
        jScrollPane4.setViewportView(tblSanPham0);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKiemSanPhamDaXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 608, Short.MAX_VALUE)
                        .addComponent(btnCapNhapDaXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTimKiemSanPhamDaXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCapNhapDaXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );

        tab.addTab("Sản Phẩm Ngừng Kinh Doanh", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 1154, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 696, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabMouseClicked
        loadTable1(ctspImpl.getAllChiTietSanPham(1));
    }//GEN-LAST:event_tabMouseClicked

    private void tblSanPham0MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPham0MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblSanPham0MouseEntered

    private void tblSanPham0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPham0MouseClicked
        int row = tblSanPham0.getSelectedRow();
        showData(row, 0);
        tab.setSelectedIndex(1);
    }//GEN-LAST:event_tblSanPham0MouseClicked

    private void txtTimKiemSanPhamDaXoaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemSanPhamDaXoaCaretUpdate
        ctspImpl.search(txtTimKiemSanPham1.getText().trim(), 0);
        loadTable1(ctspImpl.getAllChiTietSanPham(0));
    }//GEN-LAST:event_txtTimKiemSanPhamDaXoaCaretUpdate

    private void btnCapNhapDaXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhapDaXoaActionPerformed
        int row = tblSanPham0.getSelectedRow();
        ChiTietSanPham ctsp = ctspImpl.getAll(0).get(row);
        ctsp.setTrangThai(1);
        ctspImpl.update(ctsp);
        loadTable1(ctspImpl.getAllChiTietSanPham(1));
        loadTable0(ctspImpl.getAllChiTietSanPham(0));
        clear();
        JOptionPane.showMessageDialog(this, " Thanh Cong!");
    }//GEN-LAST:event_btnCapNhapDaXoaActionPerformed

    private void txtXuatXuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtXuatXuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtXuatXuActionPerformed

    private void btnChatLieuVoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChatLieuVoActionPerformed
        new ViewChatLieuVo().setVisible(true);
    }//GEN-LAST:event_btnChatLieuVoActionPerformed

    private void cbxChongNuocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxChongNuocMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxChongNuocMouseClicked

    private void txtSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongActionPerformed

    private void cbxVo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxVo1MouseClicked
        cbxVo1.removeAllItems();
        for (ChatLieuVoResponse x : clvImpl.getAllByTrangThai(1)) {
            cbxVo1.addItem(x.getTen());
        }
    }//GEN-LAST:event_cbxVo1MouseClicked

    private void btnLoaiDongHoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoaiDongHoActionPerformed
        new ViewLoaiDongHo().setVisible(true);
    }//GEN-LAST:event_btnLoaiDongHoActionPerformed

    private void btnNangLuongSuDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNangLuongSuDungActionPerformed
        new ViewNangLuongSuDung().setVisible(true);
    }//GEN-LAST:event_btnNangLuongSuDungActionPerformed

    private void cbxNangLuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxNangLuongMouseClicked
        cbxNangLuong.removeAllItems();
        for (NangLuongSuDungResponse x : nlsdImpl.getAllByTrangThai(1)) {
            cbxNangLuong.addItem(x.getTen());
        }
    }//GEN-LAST:event_cbxNangLuongMouseClicked

    private void txtGiaBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaBanActionPerformed

    private void cbxLoaiDongHoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxLoaiDongHoMouseClicked
        cbxLoaiDongHo.removeAllItems();
        for (LoaiDongHoResponse x : ldhImpl.getAllByTrangThai(1)) {
            cbxLoaiDongHo.addItem(x.getTen());
        }
    }//GEN-LAST:event_cbxLoaiDongHoMouseClicked

    private void btnMatDongHoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatDongHoActionPerformed
        new ViewMatDongHo().setVisible(true);
    }//GEN-LAST:event_btnMatDongHoActionPerformed

    private void btnHangDongHoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHangDongHoActionPerformed
        new ViewHangDongHo().setVisible(true);
    }//GEN-LAST:event_btnHangDongHoActionPerformed

    private void cbxHangDongHoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxHangDongHoMouseClicked
        cbxHangDongHo.removeAllItems();
        for (HangDongHoResponse x : hdhImpl.getAllByTrangThai(1)) {
            cbxHangDongHo.addItem(x.getTen());
        }
    }//GEN-LAST:event_cbxHangDongHoMouseClicked

    private void cbxMatDongHoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxMatDongHoMouseClicked
        cbxMatDongHo.removeAllItems();
        for (MatDongHoResponse x : mdhImpl.getAllByTrangThai(1)) {
            cbxMatDongHo.addItem(x.getTen());
        }
    }//GEN-LAST:event_cbxMatDongHoMouseClicked

    private void txtGiaNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaNhapActionPerformed

    private void txtSizeDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSizeDayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSizeDayActionPerformed

    private void btnChatLieuDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChatLieuDayActionPerformed
        new ViewChatLieuDay().setVisible(true);
    }//GEN-LAST:event_btnChatLieuDayActionPerformed

    private void btnChatLieuMatKinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChatLieuMatKinhActionPerformed
        new ViewChatLieuMatKinh().setVisible(true);
    }//GEN-LAST:event_btnChatLieuMatKinhActionPerformed

    private void cbxDay1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxDay1MouseClicked
        cbxDay1.removeAllItems();
        for (ChatLieuDayRepsonse x : cldImpl.getAllByTrangThai(1)) {
            cbxDay1.addItem(x.getTen());
        }
    }//GEN-LAST:event_cbxDay1MouseClicked

    private void cbxChatLieuMatKinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxChatLieuMatKinhMouseClicked
        cbxChatLieuMatKinh.removeAllItems();
        for (ChatLieuMatKinhResponse x : clmkImpl.getAllByTrangThai(1)) {
            cbxChatLieuMatKinh.addItem(x.getTen());
        }
    }//GEN-LAST:event_cbxChatLieuMatKinhMouseClicked

    private void cbxSerialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSerialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxSerialActionPerformed

    private void cbxSerialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxSerialMouseClicked

    }//GEN-LAST:event_cbxSerialMouseClicked

    private void btnTenSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTenSanPhamActionPerformed
        new ViewSanPham().setVisible(true);
    }//GEN-LAST:event_btnTenSanPhamActionPerformed

    private void btnSerialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSerialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSerialActionPerformed

    private void cbxTenSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxTenSanPhamMouseClicked
        cbxTenSanPham.removeAllItems();
        for (SanPhamResponse x : spImpl.getAllByTrangThai(1)) {
            cbxTenSanPham.addItem(x.getTen());
        }
    }//GEN-LAST:event_cbxTenSanPhamMouseClicked

    private void imgAnhMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgAnhMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_imgAnhMouseEntered

    private void imgAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgAnhMouseClicked
        try {
            JFileChooser fileChooser = new JFileChooser("image\\");
            int kq = fileChooser.showOpenDialog(fileChooser);
            if (kq == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                if (file.getName().endsWith(".jpg")
                        || file.getName().endsWith(".JPG")
                        || file.getName().endsWith(".png")
                        || file.getName().endsWith(".PNG")
                        || file.getName().endsWith(".jpeg")
                        || file.getName().endsWith(".JPEG")) {
                    anh = file.getPath();
                    Image img = ImageIO.read(file);
                    int with = imgAnh.getWidth();
                    int height = imgAnh.getHeight();
                    imgAnh.setIcon(new ImageIcon(img.getScaledInstance(with, height, img.SCALE_SMOOTH)));
                    imgAnh.setToolTipText(file.getPath());
                } else {
                    JOptionPane.showMessageDialog(this, "Vui lòng chọn file ảnh có các đuôi sau: jpg, jpeg, png");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Bạn chưa chọn ảnh...");
            }
        } catch (Exception a) {

        }
    }//GEN-LAST:event_imgAnhMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        ChiTietSanPham ctsp = getFormData();
        double ranDomBarCode = Math.random();
        ranDomBarCode = ranDomBarCode * 1000000000;
        int barCode = (int) ranDomBarCode;
        ctsp.setBarCode(String.valueOf(barCode));
        ctsp.setHinhAnh(anh);
        ctspImpl.insert(ctsp);
        if (ctsp.getId() == null) {
            JOptionPane.showMessageDialog(this, ctsp.getMoTa());
        } else {
            loadTable1(ctspImpl.getAllChiTietSanPham(1));
            new ViewSerial(ctsp, cbxSerial, txtSoLuong).setVisible(true);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnCapNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhapActionPerformed
        ChiTietSanPham ctsp = getFormData();
        int row = tblChTietSanPham.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(this, "Chọn sản phẩm để cập nhập");
            return;
        }
        ChiTietSanPham ctspRow = ctspImpl.getAll(1).get(row);

        ctsp.setId(ctspRow.getId());
        ctsp.setSoLuong(ctspRow.getSoLuong());

        if (anh != null) {
            ctsp.setHinhAnh(anh);
        } else {
            ctsp.setHinhAnh(ctspRow.getHinhAnh());
        }
        JOptionPane.showMessageDialog(this, ctspImpl.update(ctsp));
        loadTable1(ctspImpl.getAllChiTietSanPham(1));
        clear();
    }//GEN-LAST:event_btnCapNhapActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int row = tblChTietSanPham.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(this, "Chọn sản phẩm để xóa");
            return;
        }
        ChiTietSanPham ctsp = ctspImpl.getAll(1).get(row);
        ctsp.setTrangThai(0);
        ctspImpl.update(ctsp);
        loadTable1(ctspImpl.getAllChiTietSanPham(1));
        loadTable0(ctspImpl.getAllChiTietSanPham(0));
        clear();
        JOptionPane.showMessageDialog(this, "Xoa Thanh Cong!");
    }//GEN-LAST:event_btnXoaActionPerformed

    private void txtTimKiemSanPham1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemSanPham1CaretUpdate

    }//GEN-LAST:event_txtTimKiemSanPham1CaretUpdate

    private void tblChTietSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChTietSanPhamMouseClicked
        int row = tblChTietSanPham.getSelectedRow();
        ChiTietSanPham ctspRow = ctspImpl.getAll(1).get(row);
        showData(row, 1);

    }//GEN-LAST:event_tblChTietSanPhamMouseClicked

    private void txtTimKiemSanPham1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemSanPham1KeyReleased
        ctspImpl.search(txtTimKiemSanPham1.getText().trim(), 1);
        loadTable1(ctspImpl.getAllChiTietSanPham(1));
    }//GEN-LAST:event_txtTimKiemSanPham1KeyReleased

    private void txtBarCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBarCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBarCodeActionPerformed

    private void cbxChongNuocItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxChongNuocItemStateChanged
     
    }//GEN-LAST:event_cbxChongNuocItemStateChanged

    private void cbxChongNuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxChongNuocActionPerformed
     
    }//GEN-LAST:event_cbxChongNuocActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ImageSanPham;
    private javax.swing.JButton btnCapNhap;
    private javax.swing.JButton btnCapNhapDaXoa;
    private javax.swing.JButton btnChatLieuDay;
    private javax.swing.JButton btnChatLieuMatKinh;
    private javax.swing.JButton btnChatLieuVo;
    private javax.swing.JButton btnHangDongHo;
    private javax.swing.JButton btnLoaiDongHo;
    private javax.swing.JButton btnMatDongHo;
    private javax.swing.JButton btnNangLuongSuDung;
    private javax.swing.JButton btnSerial;
    private javax.swing.JButton btnTenSanPham;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbxChatLieuMatKinh;
    private javax.swing.JComboBox<String> cbxChongNuoc;
    private javax.swing.JComboBox<String> cbxDay1;
    private javax.swing.JComboBox<String> cbxHangDongHo;
    private javax.swing.JComboBox<String> cbxLoaiDongHo;
    private javax.swing.JComboBox<String> cbxMatDongHo;
    private javax.swing.JComboBox<String> cbxNangLuong;
    private javax.swing.JComboBox<String> cbxSerial;
    private javax.swing.JComboBox<String> cbxTenSanPham;
    private javax.swing.JComboBox<String> cbxVo1;
    private rojerusan.RSLabelImage imgAnh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane tab;
    private javax.swing.JPanel tab2;
    private rojeru_san.complementos.RSTableMetro tblChTietSanPham;
    private rojeru_san.complementos.RSTableMetro tblSanPham0;
    private javax.swing.JTextField txtBarCode;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtSizeDay;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTimKiemSanPham1;
    private javax.swing.JTextField txtTimKiemSanPhamDaXoa;
    private javax.swing.JTextField txtXuatXu;
    // End of variables declaration//GEN-END:variables
}
