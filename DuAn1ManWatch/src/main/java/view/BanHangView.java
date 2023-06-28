/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package view;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.sun.source.tree.TryTree;
import domainModel.ChiTietSanPham;
import domainModel.HoaDon;
import domainModel.HoaDonChiTiet;
import domainModel.NhanVien;
import domainModel.Serial;
import domainModel.SerialBanHang;
import domainModel.VoucherSanPham;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.formula.functions.Choose;
import service.ChiTietSanPhamService;
import service.HoaDonChiTietService;
import service.HoaDonService;
import service.KhachHangService;
import service.SerialBanHangService;
import service.SerialService;
import service.VoucherService;
import service.impl.ChiTietSanPhamServiceImpl;
import service.impl.HoaDonChiTietServiceIplm;
import service.impl.HoaDonServiceIplm;
import service.impl.KhachHangServiceImpl;
import service.impl.SerialBanHangServiceImpl;
import service.impl.SerialServiceImpl;
import service.impl.VoucherServiceImpl;
import viewModel.ChiTietSanPhamResponse;
import viewModel.HoaDonChiTietResponse;
import viewModel.HoaDonResponse;
import viewModel.SerialBanHangResponse;
import viewModel.SerialResponse;
import viewModel.VoucherResponse;

/**
 *
 * @author Admin
 */
public class BanHangView extends javax.swing.JFrame implements Runnable, ThreadFactory {

    private static NhanVien nvDN = new NhanVien();
    private HoaDonService hoaDonService = new HoaDonServiceIplm();
    private KhachHangService khService = new KhachHangServiceImpl();
    private HoaDonChiTietService hoaDonChiTietService = new HoaDonChiTietServiceIplm();
    private ChiTietSanPhamService chiTietSanPhamService = new ChiTietSanPhamServiceImpl();
    private SerialService serialService = new SerialServiceImpl();
    private SerialBanHangService serialBanHangService = new SerialBanHangServiceImpl();
    private DefaultTableModel dtm = new DefaultTableModel();
    private String regexPhone = "/^[0][0-9]{9}$/";
    private int skcbx = 0;

    private VoucherService vouCherService = new VoucherServiceImpl();
    public static WebcamPanel panel = null;
    public static Webcam webcam = null;

    private static final long serialVersionUID = 6441489157408381878L;
    private Executor executor = Executors.newSingleThreadExecutor(this);

    public BanHangView(NhanVien nv) {
        initComponents();
        prepareUI();
        setLocationRelativeTo(null);

        nvDN = nv;

        dtm = (DefaultTableModel) tblGioHang.getModel();
        loadCbxVoucher(vouCherService.getAllByTrangThai(1));
        loadTableHoaDonCho(hoaDonService.getHoaDonCho(nv.getId(), 0));
        loadTableSanPham(chiTietSanPhamService.getAllChiTietSanPham(1));
        
        datePickerNgayTao.datePicker.getSettings().setAllowKeyboardEditing(false);
        DateFickerNgayHenLay.datePicker.getSettings().setAllowKeyboardEditing(false);
        
        datePickerNgayTao.timePicker.getSettings().setAllowKeyboardEditing(false);
        DateFickerNgayHenLay.timePicker.getSettings().setAllowKeyboardEditing(false);

        initWebcam();
        if (tblhoadoncho.getSelectedRow() != -1) {
            tblhoadoncho.setRowSelectionInterval(0, 0);
        }
        if (cbxVoucher.getSelectedItem() != null) {
            cbxVoucher.setSelectedIndex(0);
        }

    }

    private void initWebcam() {
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0); //0 is default webcam
        webcam.setViewSize(size);
        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);
        jPanel2.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 235, 225));
        executor.execute(this);
    }

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Result result = null;
            BufferedImage image = null;

            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            }

            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException e) {
                //No result...
            }
            if (result != null) {

                txtBarCode.setText(result.getText());
                boolean check = false;
                for (int i = 0; i < chiTietSanPhamService.getAllChiTietSanPham(1).size(); i++) {
                    if (txtBarCode.getText().equalsIgnoreCase(chiTietSanPhamService.getAllChiTietSanPham(1).get(i).getBarCode())) {
                        tblSanPham.setRowSelectionInterval(i, i);

                        int rowHDC = tblhoadoncho.getSelectedRow();
                        if (rowHDC == -1) {
                            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn");
                            return;
                        }
                        HoaDonChiTiet hdct = new HoaDonChiTiet();
                        HoaDon hd = hoaDonService.getAll(0).get(rowHDC);
                        hdct.setHoaDon(hd);

                        ChiTietSanPham ctsp = chiTietSanPhamService.findByBarCode(txtBarCode.getText());

                        String soLuong = JOptionPane.showInputDialog(this, "Nhập Số Lượng  ");
                        try {
                            if (Integer.parseInt(soLuong) < 0) {
                                JOptionPane.showMessageDialog(this, "Số Lượng Phải Lớn Hơn 0 !");
                                return;
                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(this, "Số Lượng Phải Số !!!");
                        }

                        int soLuongTon = chiTietSanPhamService.findById(ctsp.getId()).getSoLuong();

                        if (Integer.parseInt(soLuong) > soLuongTon) {
                            JOptionPane.showMessageDialog(this, "Số Lượng Phải Nhỏ Hơn " + soLuongTon);
                            return;
                        }

                        boolean checkSP = hoaDonChiTietService.checkCTSP(ctsp.getId(), hoaDonChiTietService.getGioHang(hd.getId()));
                        if (checkSP) {
                            for (HoaDonChiTietResponse x : hoaDonChiTietService.getGioHang(hd.getId())) {
                                if (x.getChiTietSP().equals(ctsp.getId())) {
                                    int soLuongGH = x.getSoLuong() + Integer.parseInt(soLuong);
                                    hoaDonChiTietService.updateSoLuong(ctsp.getId(), hd.getId(), soLuongGH);
                                    loadGioHang(hoaDonChiTietService.getGioHang(hd.getId()));
                                }
                            }

                        } else {
                            ChiTietSanPham ctspDM = new ChiTietSanPham();
                            ctspDM.setId(ctsp.getId());
                            hdct.setChiTietSP(ctspDM);
                            hdct.setSoLuong(Integer.parseInt(soLuong));
                            hdct.setDonGia(ctsp.getGiaBan().multiply(BigDecimal.valueOf(Double.parseDouble(soLuong))));
                            hdct.setTrangThai(0);
                            hoaDonChiTietService.save(hdct);
                            loadGioHang(hoaDonChiTietService.getGioHang(hd.getId()));
                        }

                        int soLuongConLai = ctsp.getSoLuong() - Integer.parseInt(soLuong);
                        ChiTietSanPham ctspSL = new ChiTietSanPham();
                        ctspSL.setSoLuong(soLuongConLai);
                        chiTietSanPhamService.updateSoLuong(ctsp.getId(), soLuongConLai);
                        loadTableSanPham(chiTietSanPhamService.getAllChiTietSanPham(1));
                        if (ctspSL.getSoLuong() == 0) {
                            chiTietSanPhamService.updateTrangThai(ctsp.getId(), 2);
                            loadTableSanPham(chiTietSanPhamService.getAllChiTietSanPham(1));
                        }
                        JOptionPane.showMessageDialog(this, "Thêm sản phẩm vào giỏ hàng thành công!!");
                        tongTien();

                        check = true;
                    }
                }
                if (check == false) {
                    JOptionPane.showMessageDialog(this, "Sản Phảm không tồn tại");
                    return;
                }
            }
        } while (true);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
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

    private void loadCbxVoucher(List<VoucherResponse> list) {
        cbxVoucher.removeAllItems();
        for (VoucherResponse x : list) {
            cbxVoucher.addItem(String.valueOf(x.getPhamTram()) + "% - " + x.getMa());
        }
        skcbx = list.size();
    }

    public void loadTableSanPham(List<ChiTietSanPhamResponse> list) {

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"STT", "Mã Sản Phẩm", "Tên Sản Phẩm", "Xuất Xứ", "Số Lượng", "Giá Bán", "Mô Tả"});

        tblSanPham.setModel(model);
        int stt = 1;
        for (ChiTietSanPhamResponse x : list) {
            model.addRow(new Object[]{stt++, x.getMaSanPham(), x.getTenDongHo(), x.getXuatXu(), x.getSoLuong(), x.getGiaBan(), x.getMoTa()});
        }
    }

    private void loadTableHoaDonCho(List<HoaDonResponse> listHD) {
        DefaultTableModel model = (DefaultTableModel) tblhoadoncho.getModel();
        model.setColumnIdentifiers(new String[]{"Hóa Đơn Chờ"});
        model.setRowCount(0);
        for (HoaDonResponse hd : listHD) {
            model.addRow(new Object[]{hd.getMa()});
        }

    }

    private void showHoaDonCho(int row) {
        tongTien();
        HoaDon hdRe = hoaDonService.getAll(0).get(row);
        HoaDon hd = hoaDonService.findId(hdRe.getId());
        lblMaHd.setText(hd.getMa());

        Date ngayTao = hd.getNgayTao();
        if (ngayTao != null) {
            Instant instantNgayTao = ngayTao.toInstant();
            LocalDateTime localDateTime = LocalDateTime.ofInstant(instantNgayTao, ZoneId.systemDefault());
            datePickerNgayTao.setDateTimePermissive(localDateTime);
        }
        Date ngayHen = hd.getNgayHen();
        if (ngayHen != null) {
            Instant instantNgayHen = ngayHen.toInstant();
            LocalDateTime localDateTime = LocalDateTime.ofInstant(instantNgayHen, ZoneId.systemDefault());
            DateFickerNgayHenLay.setDateTimePermissive(localDateTime);
        }
        try {
            txtSDTKhachHang.setText(hd.getKhachHang().getSdt());
        } catch (Exception e) {
            txtSDTKhachHang.setText("");
        }
//        DateFickerNgayNhan.setDate(LocalDate.parse(hd.getNgayNhan()));
//        DateFickerNgayHenLay.setDate(LocalDate.parse(hd.getNgayNhan()));
        if (hd.getGiamGia() == null) {
            txtGiamGia.setText(String.valueOf(0));
        } else {
            txtGiamGia.setText(hd.getGiamGia() + "");
        }

        txtTenNguoiNhan.setText(hd.getTenNguoiNhan());
        txtSDT.setText(hd.getSdt());
        if (hd.getThanhTien() == null) {
            txtThanhTien.setText(txtTongTienHang.getText());
        } else {
            txtThanhTien.setText(String.valueOf(hd.getThanhTien()));
        }

        txtGhiChu.setText(hd.getGhiChu());

        cbxVoucher.setSelectedItem(null);

        //        tinhTien();
    }

    private void loadGioHang(List<HoaDonChiTietResponse> list) {
        dtm.setRowCount(0);
        int stt = 1;
        for (HoaDonChiTietResponse x : list) {
            dtm.addRow(new Object[]{stt++, x.getMaDongHo(), x.getTenDongHo(), x.getSoLuong(), x.getDonGia().multiply(BigDecimal.valueOf(x.getSoLuong()))});
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

    private void tinhTien() {

        DecimalFormat df = new DecimalFormat("#,###");
        int phanTramVoucher;
        if (cbxVoucher.getSelectedItem() == null) {
            phanTramVoucher = 0;
        } else {
            String ma = String.valueOf(cbxVoucher.getSelectedItem());
            String[] catChuoi = ma.split("%");
            phanTramVoucher = Integer.parseInt(catChuoi[0]);
        }

        if (txtGiamGia.getText().equals("")) {
            return;
        }
        int giamGia = Integer.parseInt(txtGiamGia.getText().trim());

        try {
            if (Integer.parseInt(txtGiamGia.getText().trim()) < 0) {
                JOptionPane.showMessageDialog(this, "Giảm giá lớn hơn 0");
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Giảm giá là số");
            return;
        }
        BigDecimal tongTien;
        if (txtTongTienHang.getText().trim().isEmpty()) {
            tongTien = BigDecimal.valueOf(0.0);
        } else {
            String[] mangTongTien = txtTongTienHang.getText().trim().split(" ");
            String tongTienStr = mangTongTien[0].replace(",", "");
            tongTien = BigDecimal.valueOf(Long.parseLong(tongTienStr));
        }

        BigDecimal thanhTien = tongTien.subtract(tongTien.multiply(BigDecimal.valueOf((double) (phanTramVoucher + giamGia) / 100)));
        txtThanhTien.setText(df.format(thanhTien));

    }

    private void tienTraKhach() {

        try {
            DecimalFormat df = new DecimalFormat("#,###");
            String[] mangThanhTien = txtThanhTien.getText().trim().split(" ");
            String thanhTienStr = mangThanhTien[0].replace(",", "");
            BigDecimal thanhTienBig = BigDecimal.valueOf(Long.parseLong(thanhTienStr));

            if (txtTienMat.getText().trim().isEmpty()) {
                txtTienMat.setText(String.valueOf(0));
            }

            if (txtChuyenKhoan.getText().trim().isEmpty()) {
                txtChuyenKhoan.setText(String.valueOf(0));
            }
            BigDecimal chuyenKhoan = BigDecimal.valueOf(Long.parseLong(txtChuyenKhoan.getText()));
            BigDecimal tienMat = BigDecimal.valueOf(Long.parseLong(txtTienMat.getText()));

            BigDecimal tienThua = (tienMat.add(chuyenKhoan)).subtract(thanhTienBig);

            txtienThua.setText(df.format(tienThua));
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }

    private void tongTien() {

        BigDecimal tong = new BigDecimal(0);
        for (int i = 0; i < tblGioHang.getRowCount(); i++) {
            tong = tong.add(BigDecimal.valueOf(Long.parseLong(tblGioHang.getValueAt(i, 4).toString())));
        }
        DecimalFormat df = new DecimalFormat("#,###");
        txtTongTienHang.setText(df.format(tong));
        txtThanhTien.setText(txtTongTienHang.getText());
    }

    private void clearHoaDon() {
        txtSDTKhachHang.setText("");
        
        datePickerNgayTao.datePicker.setText("");
        DateFickerNgayHenLay.datePicker.setText("");
      
        datePickerNgayTao.timePicker.setText("");
        DateFickerNgayHenLay.timePicker.setText("");
        
        txtGiamGia.setText("");
        txtTenNguoiNhan.setText("");
        txtSDT.setText("");
        txtTongTienHang.setText("");
        txtThanhTien.setText("");
        txtGhiChu.setText("");
        txtChuyenKhoan.setText("");
        txtTienMat.setText("");
        txtienThua.setText("");
        rdoChuyenKhoan.setSelected(false);
        rdoTienMat.setSelected(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        mnuGiohang = new javax.swing.JPopupMenu();
        xoa1sp = new javax.swing.JMenuItem();
        xoaTatCaSp = new javax.swing.JMenuItem();
        mnuHoaDon = new javax.swing.JPopupMenu();
        lamMoi = new javax.swing.JMenuItem();
        capNhap = new javax.swing.JMenuItem();
        MenuSerialBh = new javax.swing.JPopupMenu();
        Xoa = new javax.swing.JMenuItem();
        kGradientPanel2 = new com.k33ptoo.components.KGradientPanel();
        kGradientPanel3 = new com.k33ptoo.components.KGradientPanel();
        btnThoat = new rojerusan.RSButtonHover();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btnTaoHoaDon = new rojerusan.RSButtonHover();
        lblMaHd = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblGioHang = new rojeru_san.complementos.RSTableMetro();
        jPanel2 = new javax.swing.JPanel();
        txtBarCode = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblSanPham = new rojeru_san.complementos.RSTableMetro();
        txtSearch = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblSerialBanHang = new rojeru_san.complementos.RSTableMetro();
        jScrollPane1 = new javax.swing.JScrollPane();
        listSerial = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        pnlTaiQuay = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbxVoucher = new javax.swing.JComboBox<>();
        btnFindSDT = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtGiamGia = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtTenNguoiNhan = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtGhiChu = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtTongTienHang = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        rdoChuyenKhoan = new javax.swing.JRadioButton();
        rdoTienMat = new javax.swing.JRadioButton();
        txtChuyenKhoan = new javax.swing.JTextField();
        txtTienMat = new javax.swing.JTextField();
        txtienThua = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSDTKhachHang = new javax.swing.JTextField();
        kButton3 = new com.k33ptoo.components.KButton();
        jLabel43 = new javax.swing.JLabel();
        btnVoucher = new javax.swing.JButton();
        txtThanhTien = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        datePickerNgayTao = new com.github.lgooddatepicker.components.DateTimePicker();
        DateFickerNgayHenLay = new com.github.lgooddatepicker.components.DateTimePicker();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblhoadoncho = new rojeru_san.complementos.RSTableMetro();

        xoa1sp.setText("Xóa 1 sản phẩm");
        xoa1sp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoa1spActionPerformed(evt);
            }
        });
        mnuGiohang.add(xoa1sp);

        xoaTatCaSp.setText("Xóa Tất Cả Sản Phẩm");
        xoaTatCaSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaTatCaSpActionPerformed(evt);
            }
        });
        mnuGiohang.add(xoaTatCaSp);

        lamMoi.setText("Làm Mới");
        lamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lamMoiActionPerformed(evt);
            }
        });
        mnuHoaDon.add(lamMoi);

        capNhap.setText("Cập Nhập");
        capNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capNhapActionPerformed(evt);
            }
        });
        mnuHoaDon.add(capNhap);

        Xoa.setText("Xóa");
        Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaActionPerformed(evt);
            }
        });
        MenuSerialBh.add(Xoa);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocationByPlatform(true);
        setUndecorated(true);

        kGradientPanel2.setkBorderRadius(35);
        kGradientPanel2.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setOpaque(false);

        kGradientPanel3.setkBorderRadius(40);
        kGradientPanel3.setkEndColor(new java.awt.Color(224, 31, 62));
        kGradientPanel3.setkStartColor(new java.awt.Color(224, 31, 62));
        kGradientPanel3.setOpaque(false);

        btnThoat.setText("Thoát");
        btnThoat.setBackground(new java.awt.Color(224, 31, 62));
        btnThoat.setColorHover(new java.awt.Color(224, 31, 62));
        btnThoat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        kGradientPanel1.setkBorderRadius(55);
        kGradientPanel1.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setOpaque(false);

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
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
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnTaoHoaDon.setText("Tạo Hóa Đơn");
        btnTaoHoaDon.setBackground(new java.awt.Color(224, 31, 62));
        btnTaoHoaDon.setColorHover(new java.awt.Color(224, 31, 62));
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        lblMaHd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMaHd.setText("Mã Hóa Đơn");
        lblMaHd.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        lblMaHd.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(lblMaHd, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addComponent(lblMaHd)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(btnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Giỏ Hàng");
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setText("Sản Phẩm");
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Đồng Hồ", "Tên Đồng Hồ", "Số Lượng", "Thành Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGioHang.setColorBackgoundHead(new java.awt.Color(224, 31, 62));
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
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblGioHangKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblGioHangKeyReleased(evt);
            }
        });
        jScrollPane6.setViewportView(tblGioHang);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBarCode.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 51)));
        txtBarCode.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtBarCodeCaretUpdate(evt);
            }
        });

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Sản Phẩm", "Tên Sản Phẩm", "Xuất Xứ", "Số Lượng", "Giá Bán", "Mô Tả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.setColorBackgoundHead(new java.awt.Color(224, 31, 62));
        tblSanPham.setColorBordeFilas(new java.awt.Color(0, 153, 255));
        tblSanPham.setColorBordeHead(new java.awt.Color(255, 255, 255));
        tblSanPham.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tblSanPham.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tblSanPham.setFocusCycleRoot(true);
        tblSanPham.setFuenteFilas(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblSanPham.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblSanPham.setFuenteHead(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblSanPham.setGridColor(new java.awt.Color(255, 255, 255));
        tblSanPham.setGrosorBordeFilas(0);
        tblSanPham.setGrosorBordeHead(0);
        tblSanPham.setRowHeight(25);
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseEntered(evt);
            }
        });
        jScrollPane7.setViewportView(tblSanPham);
        if (tblSanPham.getColumnModel().getColumnCount() > 0) {
            tblSanPham.getColumnModel().getColumn(0).setMinWidth(30);
            tblSanPham.getColumnModel().getColumn(0).setMaxWidth(30);
            tblSanPham.getColumnModel().getColumn(1).setMinWidth(130);
            tblSanPham.getColumnModel().getColumn(1).setMaxWidth(130);
            tblSanPham.getColumnModel().getColumn(2).setMinWidth(250);
            tblSanPham.getColumnModel().getColumn(2).setMaxWidth(250);
            tblSanPham.getColumnModel().getColumn(3).setMinWidth(100);
            tblSanPham.getColumnModel().getColumn(3).setMaxWidth(100);
            tblSanPham.getColumnModel().getColumn(4).setMinWidth(70);
            tblSanPham.getColumnModel().getColumn(4).setMaxWidth(70);
            tblSanPham.getColumnModel().getColumn(5).setMinWidth(150);
            tblSanPham.getColumnModel().getColumn(5).setMaxWidth(150);
            tblSanPham.getColumnModel().getColumn(6).setMinWidth(250);
            tblSanPham.getColumnModel().getColumn(6).setMaxWidth(250);
        }

        txtSearch.setText("Search");
        txtSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 51)));
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
        tblSerialBanHang.setColorBackgoundHead(new java.awt.Color(224, 31, 62));
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

        listSerial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listSerialMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listSerial);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                    .addComponent(txtBarCode, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSearch, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 854, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 755, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(43, 43, 43))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtBarCode, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pnlTaiQuay.setBackground(new java.awt.Color(255, 255, 255));
        pnlTaiQuay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnlTaiQuayMouseReleased(evt);
            }
        });

        jLabel9.setText("Khách Hàng:");
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel10.setText("VouCher:");
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        cbxVoucher.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxVoucher.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxVoucherItemStateChanged(evt);
            }
        });
        cbxVoucher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxVoucherMouseClicked(evt);
            }
        });
        cbxVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxVoucherActionPerformed(evt);
            }
        });

        btnFindSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindSDTActionPerformed(evt);
            }
        });

        jLabel13.setText("Ngày Tạo:");
        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtGiamGia.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(224, 31, 62)));
        txtGiamGia.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtGiamGiaCaretUpdate(evt);
            }
        });
        txtGiamGia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtGiamGiaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGiamGiaKeyReleased(evt);
            }
        });

        jLabel18.setText("Giảm Giá:");
        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel27.setText("%");
        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel28.setText("Tên Người Nhận:");
        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtTenNguoiNhan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(224, 31, 62)));

        txtSDT.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(224, 31, 62)));

        jLabel30.setText("Số Điện Thoại:");
        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtGhiChu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(224, 31, 62)));

        jLabel31.setText("Ghi Chú:");
        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtTongTienHang.setEditable(false);
        txtTongTienHang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(224, 31, 62)));
        txtTongTienHang.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTongTienHangCaretUpdate(evt);
            }
        });
        txtTongTienHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTienHangActionPerformed(evt);
            }
        });

        jLabel32.setText("Tổng Tiền Hàng:");
        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel33.setText("Hình Thức Thanh Toán:");
        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        rdoChuyenKhoan.setText("Chuyển Khoản");
        rdoChuyenKhoan.setBackground(new java.awt.Color(255, 255, 255));
        rdoChuyenKhoan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        rdoTienMat.setText("Tiền Mặt");
        rdoTienMat.setBackground(new java.awt.Color(255, 255, 255));
        rdoTienMat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtChuyenKhoan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(224, 31, 62)));
        txtChuyenKhoan.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtChuyenKhoanCaretUpdate(evt);
            }
        });

        txtTienMat.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(224, 31, 62)));
        txtTienMat.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTienMatCaretUpdate(evt);
            }
        });

        txtienThua.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(224, 31, 62)));

        jLabel3.setText("Tiền Thừa Khách:");
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtSDTKhachHang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(224, 31, 62)));

        kButton3.setText("Thanh Toán");
        kButton3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        kButton3.setkBorderRadius(25);
        kButton3.setkEndColor(new java.awt.Color(224, 31, 62));
        kButton3.setkHoverEndColor(new java.awt.Color(51, 0, 255));
        kButton3.setkStartColor(new java.awt.Color(224, 31, 62));
        kButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton3ActionPerformed(evt);
            }
        });

        jLabel43.setText("Ngày Hẹn:");
        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoucherActionPerformed(evt);
            }
        });

        txtThanhTien.setEditable(false);
        txtThanhTien.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtThanhTien.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(224, 31, 62)));
        txtThanhTien.setCaretColor(new java.awt.Color(255, 0, 0));
        txtThanhTien.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtThanhTienCaretUpdate(evt);
            }
        });

        jLabel34.setText("Thành Tiền:");
        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout pnlTaiQuayLayout = new javax.swing.GroupLayout(pnlTaiQuay);
        pnlTaiQuay.setLayout(pnlTaiQuayLayout);
        pnlTaiQuayLayout.setHorizontalGroup(
            pnlTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTaiQuayLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlTaiQuayLayout.createSequentialGroup()
                        .addGroup(pnlTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(pnlTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSDT)
                            .addComponent(txtTenNguoiNhan)
                            .addComponent(txtGhiChu)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTaiQuayLayout.createSequentialGroup()
                                .addComponent(txtGiamGia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel27))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTaiQuayLayout.createSequentialGroup()
                                .addGroup(pnlTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbxVoucher, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtSDTKhachHang))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnFindSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnVoucher, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlTaiQuayLayout.createSequentialGroup()
                                .addGroup(pnlTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTongTienHang, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                    .addComponent(txtThanhTien, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                    .addComponent(datePickerNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(DateFickerNgayHenLay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(pnlTaiQuayLayout.createSequentialGroup()
                        .addGroup(pnlTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdoChuyenKhoan)
                            .addGroup(pnlTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rdoTienMat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(pnlTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTienMat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                            .addComponent(txtienThua, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtChuyenKhoan, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(pnlTaiQuayLayout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlTaiQuayLayout.setVerticalGroup(
            pnlTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTaiQuayLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFindSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSDTKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datePickerNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(pnlTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DateFickerNgayHenLay, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenNguoiNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongTienHang, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTaiQuayLayout.createSequentialGroup()
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlTaiQuayLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtThanhTien, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(pnlTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTaiQuayLayout.createSequentialGroup()
                        .addGroup(pnlTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtChuyenKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoChuyenKhoan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTienMat, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rdoTienMat, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(pnlTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tblhoadoncho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Hóa Đơn Chờ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblhoadoncho.setColorBackgoundHead(new java.awt.Color(224, 31, 62));
        tblhoadoncho.setColorBordeFilas(new java.awt.Color(0, 153, 255));
        tblhoadoncho.setColorBordeHead(new java.awt.Color(255, 255, 255));
        tblhoadoncho.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tblhoadoncho.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tblhoadoncho.setFocusCycleRoot(true);
        tblhoadoncho.setFuenteFilas(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblhoadoncho.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblhoadoncho.setFuenteHead(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblhoadoncho.setGridColor(new java.awt.Color(255, 255, 255));
        tblhoadoncho.setGrosorBordeFilas(0);
        tblhoadoncho.setGrosorBordeHead(0);
        tblhoadoncho.setRowHeight(80);
        tblhoadoncho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblhoadonchoMouseClicked(evt);
            }
        });
        tblhoadoncho.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblhoadonchoKeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(tblhoadoncho);

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kGradientPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pnlTaiQuay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(563, 563, 563)))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
                    .addComponent(pnlTaiQuay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                    .addContainerGap(87, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        new ViewMain(nvDN).setVisible(true);
        webcam.close();
        dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked
        int rowHD = tblhoadoncho.getSelectedRow();
        int rowGH = tblGioHang.getSelectedRow();

        HoaDon hd = hoaDonService.getAll(0).get(rowHD);
        UUID idHd = hoaDonService.findId(hd.getId()).getId();

        HoaDonChiTietResponse hdctRe = hoaDonChiTietService.getGioHang(idHd).get(rowGH);
        HoaDonChiTiet hdct = new HoaDonChiTiet();
        hdct.setId(hdctRe.getId());

        List<SerialBanHangResponse> listSerialBanHang = serialBanHangService.getAllById(hdct.getId(), 1);
        loadSerialBanHang(listSerialBanHang);

        ChiTietSanPham ctsp = chiTietSanPhamService.getAll(1).get(rowGH);
        loadSerial(serialService.getAllById(ctsp.getId(), 1));


    }//GEN-LAST:event_tblGioHangMouseClicked

    private void tblGioHangMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseReleased
        if (evt.isPopupTrigger()) {
            mnuGiohang.show(tblGioHang, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tblGioHangMouseReleased

    private void tblGioHangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblGioHangKeyReleased
        int rowSP = tblSanPham.getSelectedRow();
        int rowGH = tblGioHang.getSelectedRow();
        int rowHDC = tblhoadoncho.getSelectedRow();
        HoaDon hd = hoaDonService.getAll(0).get(rowHDC);
        HoaDonChiTietResponse hdctRe = hoaDonChiTietService.getGioHang(hd.getId()).get(rowGH);
        HoaDonChiTiet hdct = new HoaDonChiTiet();
        hdct.setId(hdctRe.getId());
        int soLuongGoc = hdctRe.getSoLuong();
        String soLuongMoi = tblGioHang.getValueAt(rowGH, 3).toString();

        try {
            if (Integer.parseInt(soLuongMoi) < 0) {
                JOptionPane.showMessageDialog(this, "Số Lượng Phải Lớn Hơn 0 !");
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Số Lượng Phải Số !!!");
            return;
        }

        int soLuongTon = (int) tblSanPham.getValueAt(rowSP, 4);
        if (Integer.parseInt(soLuongMoi) > soLuongTon) {
            JOptionPane.showMessageDialog(this, "Số Lượng Phải Nhỏ Hơn " + soLuongTon);
            return;
        }

        if (soLuongGoc < Integer.parseInt(soLuongMoi)) {
            for (ChiTietSanPham x : chiTietSanPhamService.getAll(1)) {
                if (hdctRe.getChiTietSP().equals(x.getId())) {
                    int soLuongUD = x.getSoLuong() - (Integer.parseInt(soLuongMoi) - soLuongGoc);
                    chiTietSanPhamService.updateSoLuong(x.getId(), soLuongUD);
                    hoaDonChiTietService.updateSoLuong(x.getId(), hd.getId(), Integer.parseInt(soLuongMoi));
                    loadTableSanPham(chiTietSanPhamService.getAllChiTietSanPham(1));
                    loadGioHang(hoaDonChiTietService.getGioHang(hd.getId()));
                    tongTien();
                }
            }
        }
        if (soLuongGoc > Integer.parseInt(soLuongMoi)) {
            for (ChiTietSanPham x : chiTietSanPhamService.getAll(1)) {
                if (hdctRe.getChiTietSP().equals(x.getId())) {
                    int soLuongUD = x.getSoLuong() + (soLuongGoc - Integer.parseInt(soLuongMoi));
                    chiTietSanPhamService.updateSoLuong(x.getId(), soLuongUD);
                    hoaDonChiTietService.updateSoLuong(x.getId(), hd.getId(), Integer.parseInt(soLuongMoi));
                    loadTableSanPham(chiTietSanPhamService.getAllChiTietSanPham(1));
                    loadGioHang(hoaDonChiTietService.getGioHang(hd.getId()));
                    tongTien();

                }
            }
        }

        if (soLuongGoc == Integer.parseInt(soLuongMoi)) {
            return;
        }

    }//GEN-LAST:event_tblGioHangKeyReleased

    private void txtBarCodeCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtBarCodeCaretUpdate

    }//GEN-LAST:event_txtBarCodeCaretUpdate

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        int row = tblSanPham.getSelectedRow();
        int rowHDC = tblhoadoncho.getSelectedRow();
        if (rowHDC == -1) {
            clearHoaDon();
            HoaDon hd = new HoaDon();
            hd.setNhanVien(nvDN);
            int ma = hoaDonService.getAll().size() + 1;
            if (ma <= 9) {
                hd.setMa("HD00000" + ma++);
            } else if (ma > 9) {
                hd.setMa("HD0000" + ma++);
            } else if (ma > 99) {
                hd.setMa("HD000" + ma++);
            } else if (ma > 999) {
                hd.setMa("HD00" + ma++);
            }
            lblMaHd.setText(hd.getMa());
            LocalDate toDay = LocalDate.now();
            hd.setNgayTao(new Date());
           
            hd.setNgayHen(new Date());
            hd.setTrangThai(0);
            HoaDon hdReturn = hoaDonService.insert(hd);
            loadTableHoaDonCho(hoaDonService.getHoaDonCho(nvDN.getId(), 0));
            tblhoadoncho.setRowSelectionInterval(0, 0);
            loadGioHang(hoaDonChiTietService.getGioHang(hdReturn.getId()));
            showHoaDonCho(0);
        }
        HoaDonChiTiet hdct = new HoaDonChiTiet();

        HoaDon hd = hoaDonService.getAll(0).get(rowHDC);
        hdct.setHoaDon(hd);

        String soLuong = JOptionPane.showInputDialog(this, "Nhập Số Lượng  ");
        try {
            if (Integer.parseInt(soLuong) < 0) {
                JOptionPane.showMessageDialog(this, "Số Lượng Phải Lớn Hơn 0 !");
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Số Lượng Phải Số !!!");
            return;
        }

        int soLuongTon = (int) tblSanPham.getValueAt(row, 4);
        if (Integer.parseInt(soLuong) > soLuongTon) {
            JOptionPane.showMessageDialog(this, "Số Lượng Phải Nhỏ Hơn " + soLuongTon);
            return;
        }

        ChiTietSanPhamResponse ctsp = chiTietSanPhamService.getAllChiTietSanPham(1).get(row);

        boolean checkSP = hoaDonChiTietService.checkCTSP(ctsp.getId(), hoaDonChiTietService.getGioHang(hd.getId()));
        if (checkSP) {
            for (HoaDonChiTietResponse x : hoaDonChiTietService.getGioHang(hd.getId())) {
                if (x.getChiTietSP().equals(ctsp.getId())) {
                    int soLuongGH = x.getSoLuong() + Integer.parseInt(soLuong);
                    hoaDonChiTietService.updateSoLuong(ctsp.getId(), hd.getId(), soLuongGH);
                    loadGioHang(hoaDonChiTietService.getGioHang(hd.getId()));
                }
            }

        } else {
            ChiTietSanPham ctspDM = new ChiTietSanPham();
            ctspDM.setId(ctsp.getId());
            hdct.setChiTietSP(ctspDM);
            hdct.setSoLuong(Integer.parseInt(soLuong));
            hdct.setDonGia(ctsp.getGiaBan().multiply(BigDecimal.valueOf(Double.parseDouble(soLuong))));
            hdct.setTrangThai(0);
            hoaDonChiTietService.save(hdct);
            loadGioHang(hoaDonChiTietService.getGioHang(hd.getId()));
        }

        int soLuongConLai = ctsp.getSoLuong() - Integer.parseInt(soLuong);
        ChiTietSanPham ctspSL = new ChiTietSanPham();
        ctspSL.setSoLuong(soLuongConLai);
        chiTietSanPhamService.updateSoLuong(ctsp.getId(), soLuongConLai);
        loadTableSanPham(chiTietSanPhamService.getAllChiTietSanPham(1));
        if (ctspSL.getSoLuong() == 0) {
            chiTietSanPhamService.updateTrangThai(ctsp.getId(), 2);
            loadTableSanPham(chiTietSanPhamService.getAllChiTietSanPham(1));
        }
        JOptionPane.showMessageDialog(this, "Thêm sản phẩm vào giỏ hàng thành công!!");

        tongTien();
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void tblSanPhamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblSanPhamMouseEntered

    private void tblhoadonchoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblhoadonchoMouseClicked
        clearHoaDon();
        try {
            int rowHDC = tblhoadoncho.getSelectedRow();
            HoaDon hd = hoaDonService.getAll(0).get(rowHDC);
            hd.setId(hd.getId());
            loadGioHang(hoaDonChiTietService.getGioHang(hd.getId()));
            showHoaDonCho(rowHDC);

        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }//GEN-LAST:event_tblhoadonchoMouseClicked

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        try {
            clearHoaDon();
            HoaDon hd = new HoaDon();
            hd.setNhanVien(nvDN);
            int ma = hoaDonService.getAll().size() + 1;

            if (ma <= 9) {
                hd.setMa("HD00000" + ma++);
            } else if (ma > 9) {
                hd.setMa("HD0000" + ma++);
            } else if (ma > 99) {
                hd.setMa("HD000" + ma++);
            } else if (ma > 999) {
                hd.setMa("HD00" + ma++);
            }

            lblMaHd.setText(hd.getMa());
           
            hd.setNgayTao(new Date());
           
            hd.setNgayHen(new Date());
            hd.setTrangThai(0);
            HoaDon hdReturn = hoaDonService.insert(hd);
            loadTableHoaDonCho(hoaDonService.getHoaDonCho(nvDN.getId(), 0));
            tblhoadoncho.setRowSelectionInterval(0, 0);
            loadGioHang(hoaDonChiTietService.getGioHang(hdReturn.getId()));
            showHoaDonCho(0);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void tblhoadonchoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblhoadonchoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tblhoadonchoKeyReleased

    private void xoa1spActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoa1spActionPerformed
        int rowGH = tblGioHang.getSelectedRow();
        int rowHD = tblhoadoncho.getSelectedRow();

        HoaDon hd = hoaDonService.getAll(0).get(rowHD);
        HoaDonChiTietResponse hdctRe = hoaDonChiTietService.getGioHang(hd.getId()).get(rowGH);

        HoaDonChiTiet hdct = new HoaDonChiTiet();
        hdct.setId(hdctRe.getId());
        int soLuong = hdctRe.getSoLuong();
        for (ChiTietSanPham x : chiTietSanPhamService.getAll(1)) {
            if (hdctRe.getChiTietSP().equals(x.getId())) {
                int soLuongUD = soLuong + x.getSoLuong();
                chiTietSanPhamService.updateSoLuong(x.getId(), soLuongUD);
                loadTableSanPham(chiTietSanPhamService.getAllChiTietSanPham(1));
            }
        }
        if (tblSerialBanHang.getRowCount() > 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng xóa hết serial trước khi xóa sản phẩm ở giỏ hàng");
            return;
        }

        hoaDonChiTietService.delete(hdctRe.getId());
        loadGioHang(hoaDonChiTietService.getGioHang(hd.getId()));
        tongTien();
    }//GEN-LAST:event_xoa1spActionPerformed

    private void xoaTatCaSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaTatCaSpActionPerformed
        int rowHD = tblhoadoncho.getSelectedRow();
        int rowGH = tblGioHang.getSelectedRow();

        HoaDon hd = hoaDonService.getAll(0).get(rowHD);
        UUID idHd = hoaDonService.findId(hd.getId()).getId();
        HoaDonChiTietResponse hdctRe = hoaDonChiTietService.getGioHang(idHd).get(rowGH);
        List<SerialBanHang> list = serialBanHangService.getAllTrangThai(1);
        int tong = 0;
        for (HoaDonChiTiet x : hoaDonChiTietService.getAll()) {
            tong = tong + x.getSoLuong();
        }

        if (list.size() > 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng xóa hết serial trươc khi xóa sản phẩm trong giỏ hàng");
            return;
        }
        for (HoaDonChiTiet x : hoaDonChiTietService.getAll()) {
            for (ChiTietSanPham y : chiTietSanPhamService.getAll(1)) {
                if (x.getChiTietSP().getId().equals(y.getId())) {
                    int soLuongUD = x.getSoLuong() + y.getSoLuong();
                    chiTietSanPhamService.updateSoLuong(y.getId(), soLuongUD);
                    loadTableSanPham(chiTietSanPhamService.getAllChiTietSanPham(1));
                }
            }
        }

        hoaDonChiTietService.deleteALL(hd.getId());
        loadGioHang(hoaDonChiTietService.getGioHang(hd.getId()));
        tongTien();
    }//GEN-LAST:event_xoaTatCaSpActionPerformed

    private void lamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lamMoiActionPerformed
        clearHoaDon();
    }//GEN-LAST:event_lamMoiActionPerformed

    private void capNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capNhapActionPerformed
        int rowHD = tblhoadoncho.getSelectedRow();
        HoaDon hdRe = hoaDonService.getAll(0).get(rowHD);
        HoaDon hd = hoaDonService.findId(hdRe.getId());
        hd.setMa(lblMaHd.getText());

        if (txtSDTKhachHang.getText().trim().equals("")) {
            hd.setKhachHang(null);
        } else {
            hd.setKhachHang(khService.findBySDT(txtSDTKhachHang.getText()));
        }

        if (cbxVoucher.getSelectedItem() == null) {
            hd.setVoucher(null);
        } else {
            String ma = cbxVoucher.getSelectedItem().toString();
            String[] catChuoi = ma.split("- ");
            VoucherSanPham vc = vouCherService.findIdByMa(catChuoi[1]);
            hd.setVoucher(vc);
        }

        try {
            LocalDateTime time1 = DateFickerNgayHenLay.getDateTimePermissive();
            String t1 = String.valueOf(time1);
            String array1[] = t1.split("T");
            String arrayDaoChuoi[] = array1[0].split("-");
            String ngayDao = arrayDaoChuoi[2] + "-" + arrayDaoChuoi[1] + "-" + arrayDaoChuoi[0];
            String timeNgayMongMuon = "";
            if (Integer.parseInt(t1.substring(11, 13)) < 12) {
                timeNgayMongMuon = ngayDao + " " + array1[1] + " AM";
            } else {
                timeNgayMongMuon = ngayDao + " " + array1[1] + " PM";
            }
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm");
            Date NgayHenLay = sdf.parse(timeNgayMongMuon);
            hd.setNgayHen(NgayHenLay);
        } catch (Exception e) {
        }

        if (txtTenNguoiNhan.getText().trim().equals("")) {
            hd.setTenNguoiNhan(null);
        } else {
            hd.setTenNguoiNhan(txtTenNguoiNhan.getText().trim());
        }

        if (txtSDT.getText().trim().equals("")) {
            hd.setSdt(null);
        } else {
            if (!txtSDT.getText().matches(regexPhone)) {
                JOptionPane.showMessageDialog(this, "Sai định dạng sdt");
                return;
            }
            hd.setSdt(txtSDT.getText().trim());
        }

        if (txtGhiChu.getText().trim().equals("")) {
            hd.setGhiChu(null);
        } else {
            hd.setGhiChu(txtGhiChu.getText());
        }

        if (txtGiamGia.getText().trim().equals("")) {
            hd.setGiamGia(0);
        } else {
            hd.setGiamGia(Integer.parseInt(txtGiamGia.getText().trim()));
        }

        if (txtTienMat.getText().trim().equals("")) {
            hd.setTienMat(BigDecimal.valueOf(0));
        } else {
            hd.setTienMat(BigDecimal.valueOf(Long.parseLong(txtTienMat.getText().trim())));
        }

        if (txtChuyenKhoan.getText().trim().equals("")) {
            hd.setChuyenKhoan(BigDecimal.valueOf(0));
        } else {
            hd.setChuyenKhoan(BigDecimal.valueOf(Long.parseLong(txtChuyenKhoan.getText().trim())));
        }

        if (txtThanhTien.getText().trim().equals("")) {
            hd.setThanhTien(BigDecimal.valueOf(0));
        } else {
            String[] mangThanhTien = txtThanhTien.getText().trim().split(" ");
            String thanhTienStr = mangThanhTien[0].replace(",", "");
            hd.setThanhTien(BigDecimal.valueOf(Long.parseLong(thanhTienStr.trim())));
        }
        hd.setTrangThai(0);
        JOptionPane.showMessageDialog(this, "Cập Nhập " + hoaDonService.update(hd));

    }//GEN-LAST:event_capNhapActionPerformed

    private void tblGioHangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblGioHangKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblGioHangKeyPressed

    private void pnlTaiQuayMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTaiQuayMouseReleased
        if (evt.isPopupTrigger()) {
            mnuHoaDon.show(pnlTaiQuay, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_pnlTaiQuayMouseReleased

    private void kButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton3ActionPerformed

        int rowHDC = tblhoadoncho.getSelectedRow();
        UUID idHdct = hoaDonService.getAll(0).get(rowHDC).getId();
        if (rowHDC == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn để thanh toán");
            return;
        }
        for (HoaDonChiTiet x : hoaDonChiTietService.findByIdHD(idHdct)) {
            if (x.getChiTietSP().getTrangThai() == 0) {
                JOptionPane.showMessageDialog(this, "Sản Phẩm " + x.getChiTietSP().getSanPham().getTen() + " đã ngừng kinh doanh vui lòng bỏ ra khỏi giỏ hàng");
                return;
            }
        }
        for (HoaDon x : hoaDonService.findByIdVoucher(idHdct)) {
            if (x.getVoucher().getTrangThai() == 0) {
                JOptionPane.showMessageDialog(this, "Voucher" + x.getVoucher().getTen() + " đã hết hạn vui lòng chọn voucher khác");
                return;
            }
        }
        if (txtienThua.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nhập tiền mặt khi thanh toán");
            return;
        }

        String[] mangTienThua = txtienThua.getText().trim().split(" ");
        String tienThuaStr = mangTienThua[0].replace(",", "");

        BigDecimal tienThua = BigDecimal.valueOf(Long.parseLong(tienThuaStr));
        if (tienThua.compareTo(BigDecimal.ZERO) < 0) {
            JOptionPane.showMessageDialog(this, "Nhập đủ tiền mặt khi thanh toán");
            return;
        }

        List<HoaDonChiTietResponse> listHdct = hoaDonChiTietService.getGioHang(idHdct);

        int tong = 0;
        for (int i = 0; i < listHdct.size(); i++) {
            tong = tong + listHdct.get(i).getSoLuong();
        }

        List<SerialBanHang> list = serialBanHangService.getAllTrangThai(1);
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < listHdct.size(); j++) {
                if ((list.get(i).getHoaDonChiTiet().getId()).equals(listHdct.get(j).getId())) {
                    count++;
                }
            }
        }

        if (tong != count) {
            JOptionPane.showMessageDialog(this, "Nhập đủ serial bán hàng trước khi thanh toán");
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < listHdct.size(); j++) {
                if ((list.get(i).getHoaDonChiTiet().getId()).equals(listHdct.get(j).getId())) {
                    SerialBanHang serialBh = serialBanHangService.findIdByMa(list.get(i).getMa());
                    serialBh.setTrangThai(0);
                    serialBanHangService.update(serialBh);
                }
            }
        }

        HoaDon hdRe = hoaDonService.getAll(0).get(rowHDC);
        HoaDon hd = hoaDonService.findId(hdRe.getId());
        hd.setMa(lblMaHd.getText());

        if (txtSDTKhachHang.getText().trim().equals("")) {
            hd.setKhachHang(null);
        } else {
            hd.setKhachHang(khService.findBySDT(txtSDTKhachHang.getText()));
        }

        if (cbxVoucher.getSelectedItem() == null) {
            hd.setVoucher(null);
        } else {
            String ma = cbxVoucher.getSelectedItem().toString();
            String[] catChuoi = ma.split("- ");
            VoucherSanPham vc = vouCherService.findIdByMa(catChuoi[1]);
            hd.setVoucher(vc);
        }

        try {
            LocalDateTime time1 = DateFickerNgayHenLay.getDateTimePermissive();
            String t1 = String.valueOf(time1);
            String array1[] = t1.split("T");
            String arrayDaoChuoi[] = array1[0].split("-");
            String ngayDao = arrayDaoChuoi[2] + "-" + arrayDaoChuoi[1] + "-" + arrayDaoChuoi[0];
            String timeNgayMongMuon = "";
            if (Integer.parseInt(t1.substring(11, 13)) < 12) {
                timeNgayMongMuon = ngayDao + " " + array1[1] + " AM";
            } else {
                timeNgayMongMuon = ngayDao + " " + array1[1] + " PM";
            }
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm");
            Date NgayHenLay = sdf.parse(timeNgayMongMuon);
            hd.setNgayHen(NgayHenLay);
        } catch (Exception e) {
        }

        hd.setNgayThanhToan(new Date());

        if (txtTenNguoiNhan.getText().trim().equals("")) {
            hd.setTenNguoiNhan(null);
        } else {
            hd.setTenNguoiNhan(txtTenNguoiNhan.getText().trim());
        }

        if (txtSDT.getText().trim().equals("")) {
            hd.setSdt(null);
        } else {
            if (!txtSDT.getText().matches(regexPhone)) {
                JOptionPane.showMessageDialog(this, "Sai định dạng sdt");
                return;
            }
            hd.setSdt(txtSDT.getText().trim());
        }

        if (txtGhiChu.getText().trim().equals("")) {
            hd.setGhiChu(null);
        } else {
            hd.setGhiChu(txtGhiChu.getText());
        }

        if (txtGiamGia.getText().trim().equals("")) {
            hd.setGiamGia(0);
        } else {
            hd.setGiamGia(Integer.parseInt(txtGiamGia.getText().trim()));
        }

        if (txtTienMat.getText().trim().equals("")) {
            hd.setTienMat(BigDecimal.valueOf(0));
        } else {
            hd.setTienMat(BigDecimal.valueOf(Long.parseLong(txtTienMat.getText().trim())));
        }

        if (txtChuyenKhoan.getText().trim().equals("")) {
            hd.setChuyenKhoan(BigDecimal.valueOf(0));
        } else {
            hd.setChuyenKhoan(BigDecimal.valueOf(Long.parseLong(txtChuyenKhoan.getText().trim())));
        }

        if (txtThanhTien.getText().trim().equals("")) {
            hd.setThanhTien(BigDecimal.valueOf(0));
        } else {
            String[] mangThanhTien = txtThanhTien.getText().trim().split(" ");
            String thanhTienStr = mangThanhTien[0].replace(",", "");
            hd.setThanhTien(BigDecimal.valueOf(Long.parseLong(thanhTienStr.trim())));
        }
        hd.setTrangThai(1);
        JOptionPane.showMessageDialog(this, "Thanh toán" + hoaDonService.update(hd));
        clearHoaDon();
        loadTableHoaDonCho(hoaDonService.getHoaDonCho(nvDN.getId(), 0));
    }//GEN-LAST:event_kButton3ActionPerformed

    private void btnFindSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindSDTActionPerformed

        new ViewKhachHangThemNhanh(txtSDTKhachHang).setVisible(true);
    }//GEN-LAST:event_btnFindSDTActionPerformed

    private void btnVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoucherActionPerformed
        new ViewVoucher().setVisible(true);
    }//GEN-LAST:event_btnVoucherActionPerformed

    private void txtThanhTienCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtThanhTienCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtThanhTienCaretUpdate

    private void txtGiamGiaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtGiamGiaCaretUpdate

        if (txtGiamGia.getText().trim().equals("")) {
            return;
        }
        try {
            if (Integer.parseInt(txtGiamGia.getText()) < 0) {
                JOptionPane.showMessageDialog(this, "Giảm giá lớn hơn 0");
                return;
            }
            tinhTien();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Giảm giá là số");
            return;
        }


    }//GEN-LAST:event_txtGiamGiaCaretUpdate

    private void cbxVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxVoucherActionPerformed
        try {

            if (skcbx >= vouCherService.getAllByTrangThai(1).size()) {
                tinhTien();
            }
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }//GEN-LAST:event_cbxVoucherActionPerformed

    private void cbxVoucherItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxVoucherItemStateChanged

    }//GEN-LAST:event_cbxVoucherItemStateChanged

    private void txtTongTienHangCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTongTienHangCaretUpdate

    }//GEN-LAST:event_txtTongTienHangCaretUpdate

    private void txtTongTienHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTienHangActionPerformed
        tinhTien();
    }//GEN-LAST:event_txtTongTienHangActionPerformed

    private void txtChuyenKhoanCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtChuyenKhoanCaretUpdate

        tienTraKhach();
    }//GEN-LAST:event_txtChuyenKhoanCaretUpdate

    private void txtTienMatCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienMatCaretUpdate

        tienTraKhach();
    }//GEN-LAST:event_txtTienMatCaretUpdate

    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked
        txtSearch.setText("");
    }//GEN-LAST:event_txtSearchMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased

        List<SerialResponse> listSerial = serialService.searchSerial(txtSearch.getText().trim(), 1);
        loadSerial(listSerial);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void tblSerialBanHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSerialBanHangMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblSerialBanHangMouseClicked

    private void tblSerialBanHangMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSerialBanHangMouseReleased
        if (evt.isPopupTrigger()) {
            MenuSerialBh.show(tblSerialBanHang, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tblSerialBanHangMouseReleased

    private void tblSerialBanHangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblSerialBanHangKeyReleased

    }//GEN-LAST:event_tblSerialBanHangKeyReleased

    private void XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaActionPerformed
        int rowSbh = tblSerialBanHang.getSelectedRow();
        int rowhdct = tblGioHang.getSelectedRow();
        int rowHD = tblhoadoncho.getSelectedRow();

        HoaDon hd = hoaDonService.getAll(0).get(rowHD);
        HoaDonChiTietResponse hdctRe = hoaDonChiTietService.getGioHang(hd.getId()).get(rowhdct);
        HoaDonChiTiet hdct = new HoaDonChiTiet();
        hdct.setId(hdctRe.getId());

        SerialBanHangResponse serialBh = serialBanHangService.getAllById(hdct.getId(), 1).get(rowSbh);
        SerialBanHang serial = serialBanHangService.findIdByMa(serialBh.getMa());

        serialService.updateTrangThai(serial.getMa(), 1);
        loadSerial(serialService.getAllById(hdct.getId(), 1));

        serialBanHangService.delete(serial.getId());
        loadSerialBanHang(serialBanHangService.getAllById(hdct.getId(), 1));
    }//GEN-LAST:event_XoaActionPerformed

    private void listSerialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listSerialMouseClicked
        int rowGH = tblGioHang.getSelectedRow();
        int rowHD = tblhoadoncho.getSelectedRow();

        HoaDon hd = hoaDonService.getAll(0).get(rowHD);
        UUID idHd = hoaDonService.findId(hd.getId()).getId();
        HoaDonChiTietResponse hdctRe = hoaDonChiTietService.getGioHang(idHd).get(rowGH);
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

    private void txtGiamGiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGiamGiaKeyReleased

    }//GEN-LAST:event_txtGiamGiaKeyReleased

    private void txtGiamGiaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGiamGiaKeyPressed


    }//GEN-LAST:event_txtGiamGiaKeyPressed

    private void cbxVoucherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxVoucherMouseClicked
        loadCbxVoucher(vouCherService.getAllByTrangThai(1));
    }//GEN-LAST:event_cbxVoucherMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed


    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.github.lgooddatepicker.components.DateTimePicker DateFickerNgayHenLay;
    private javax.swing.JPopupMenu MenuSerialBh;
    private javax.swing.JMenuItem Xoa;
    private javax.swing.JButton btnFindSDT;
    private rojerusan.RSButtonHover btnTaoHoaDon;
    private rojerusan.RSButtonHover btnThoat;
    private javax.swing.JButton btnVoucher;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JMenuItem capNhap;
    private javax.swing.JComboBox<String> cbxVoucher;
    private com.github.lgooddatepicker.components.DateTimePicker datePickerNgayTao;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTextField jTextField1;
    private com.k33ptoo.components.KButton kButton3;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    private com.k33ptoo.components.KGradientPanel kGradientPanel3;
    private javax.swing.JMenuItem lamMoi;
    private javax.swing.JLabel lblMaHd;
    private javax.swing.JList<String> listSerial;
    private javax.swing.JPopupMenu mnuGiohang;
    private javax.swing.JPopupMenu mnuHoaDon;
    private javax.swing.JPanel pnlTaiQuay;
    private javax.swing.JRadioButton rdoChuyenKhoan;
    private javax.swing.JRadioButton rdoTienMat;
    private rojeru_san.complementos.RSTableMetro tblGioHang;
    private rojeru_san.complementos.RSTableMetro tblSanPham;
    private rojeru_san.complementos.RSTableMetro tblSerialBanHang;
    private rojeru_san.complementos.RSTableMetro tblhoadoncho;
    private javax.swing.JTextField txtBarCode;
    private javax.swing.JTextField txtChuyenKhoan;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtGiamGia;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSDTKhachHang;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTenNguoiNhan;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtTienMat;
    private javax.swing.JTextField txtTongTienHang;
    private javax.swing.JTextField txtienThua;
    private javax.swing.JMenuItem xoa1sp;
    private javax.swing.JMenuItem xoaTatCaSp;
    // End of variables declaration//GEN-END:variables
}
