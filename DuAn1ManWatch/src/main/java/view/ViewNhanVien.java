/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package view;

import domainModel.NhanVien;
import java.awt.Image;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.NhanVienService;
import service.impl.NhanVienServiceImplm;
import viewModel.NhanVienResponse;

/**
 *
 * @author Admin
 */
public class ViewNhanVien extends javax.swing.JPanel {

    private NhanVienService nvs = new NhanVienServiceImplm();
    private List<NhanVienResponse> listnv = new ArrayList<>();
    private List<NhanVienResponse> listnvnv = new ArrayList<>();
    private List<NhanVien> listnvdm = new ArrayList<>();
    private String anh;

    public ViewNhanVien() {
        initComponents();
        loadtable();
    }

    private void loadtable() {
        listnvnv = nvs.getAllByTrangThai(0);
        listnv = nvs.getAllByTrangThai(1);
        loadTableDiLam(listnv);
        loadTableNghiViec(listnvnv);
    }

    private void loadTableNghiViec(List<NhanVienResponse> listNvNghiViec) {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(new String[]{"STT", "Mã", "Họ và tên", "Giới Tính", "Ngày sinh",
            "Email", "Hình ảnh", "Chức Vụ", "Địa chỉ", "SDT"});
        tbNhanVienNV.setModel(dtm);
        int i = 1;
        for (NhanVienResponse x : listNvNghiViec) {
            dtm.addRow(x.toDataRow(i));
            i++;
        }
    }

    private void loadTableDiLam(List<NhanVienResponse> listNvDiLam) {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(new String[]{"STT", "Mã", "Họ và tên", "Giới Tính", "Ngày sinh",
              "Chức Vụ", "Địa chỉ", "SDT"});
        tbNhanVien.setModel(dtm);
        int i = 1;
        for (NhanVienResponse x : listNvDiLam) {
            dtm.addRow(x.toDataRow(i));
            i++;
        }
    }

    private NhanVien getForm() {
        NhanVien nv = new NhanVien();

//        int index = (int) Math.random() * 10000;
        nv.setMa(txtMa.getText());
        nv.setHoVaTen(txtHoVaTen.getText());
        nv.setDiaChi(txtDiaChi.getText());
        nv.setNgaySinh(String.valueOf(datePicker1.getDate()));
        nv.setSdt(txtSoDienThoai.getText());
        String ten = txtHoVaTen.getText().trim();

        System.out.println("");
        nv.setEmail(txtEmail.getText());
        nv.setHinhAnh(anh);
        if (cbTrangThai.isSelected() == true) {
            nv.setTrangThai(1);
        } else {
            nv.setTrangThai(0);

        }
        if (rdoNam.isSelected()) {
            nv.setGioiTinh(1);
        } else {
            nv.setGioiTinh(0);
        }
        if (rdoTruongPhong.isSelected()) {
            nv.setChucVu(1);
        } else {
            nv.setChucVu(0);
        }

        return nv;

    }

    private NhanVien getFormSua() {
        int i = tbNhanVien.getSelectedRow();
        NhanVienResponse nvss = listnv.get(i);
        NhanVien nv = new NhanVien();
        nv.setId(nvss.getId());
//        int index = (int) Math.random() * 10000;
        nv.setMa(txtMa.getText());
        nv.setHoVaTen(txtHoVaTen.getText());
        nv.setDiaChi(txtDiaChi.getText());
        nv.setNgaySinh(String.valueOf(datePicker1.getDate()));
        nv.setSdt(txtSoDienThoai.getText());
        nv.setMatKhau(txtPassWord.getText());
        nv.setEmail(txtEmail.getText());
        nv.setHinhAnh(anh);
        if (cbTrangThai.isSelected() == true) {
            nv.setTrangThai(1);
        } else {
            nv.setTrangThai(0);

        }
        if (rdoNam.isSelected()) {
            nv.setGioiTinh(1);
        } else {
            nv.setGioiTinh(0);
        }
        if (rdoTruongPhong.isSelected()) {
            nv.setChucVu(1);
        } else {
            nv.setChucVu(0);
        }
        return nv;

    }

    private void fillData(int i) {
        NhanVienResponse nvr = listnv.get(i);
        txtMa.setText(nvr.getMa());
        txtHoVaTen.setText(nvr.getHoVaTen());
        txtEmail.setText(nvr.getEmail());
        //   txtPassWord.setText(nvImpl.getAllResponse().get(i).get);
        txtSoDienThoai.setText(nvr.getSdt());
        txtDiaChi.setText(nvr.getDiaChi());
        imgAnh.setIcon(new ImageIcon(nvr.getHinhAnh()));
//        if (nvr.getTrangThai() == 1) {
//            cbtrangThai.setSelected(true);
//        } else {
//            cbtrangThai.setSelected(false);
//        }
        if (nvr.getGioiTinh() == 1) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
        if (nvr.getChucVu() == 0) {
            rdoNhanVien.setSelected(true);
        } else {
            rdoTruongPhong.setSelected(true);
        }
        cbTrangThai.setSelected(true);
        datePicker1.setDate(LocalDate.parse(nvr.getNgaySinh()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbNhanVien = new rojeru_san.complementos.RSTableMetro();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtPassWord = new javax.swing.JPasswordField();
        datePicker1 = new com.github.lgooddatepicker.components.DatePicker();
        jLabel10 = new javax.swing.JLabel();
        rdoTruongPhong = new javax.swing.JRadioButton();
        rdoNhanVien = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        rdoNu = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtHoVaTen = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        cbTrangThai = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        imgNhanVien = new javax.swing.JPanel();
        imgAnh = new rojerusan.RSLabelImage();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnExport = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnAn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnCapNhapDaXoa = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtTimKiemDaXoa = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbNhanVienNV = new rojeru_san.complementos.RSTableMetro();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1169,691));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1169,691));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(1205, 741));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Nhân Viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        tbNhanVien.setModel(new javax.swing.table.DefaultTableModel(
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
        tbNhanVien.setColorBackgoundHead(new java.awt.Color(0, 153, 255));
        tbNhanVien.setColorBordeFilas(new java.awt.Color(0, 153, 255));
        tbNhanVien.setColorBordeHead(new java.awt.Color(255, 255, 255));
        tbNhanVien.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbNhanVien.setColorSelBackgound(new java.awt.Color(51, 204, 255));
        tbNhanVien.setFuenteFilas(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbNhanVien.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbNhanVien.setFuenteHead(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tbNhanVien.setGridColor(new java.awt.Color(255, 255, 255));
        tbNhanVien.setGrosorBordeFilas(0);
        tbNhanVien.setGrosorBordeHead(0);
        tbNhanVien.setRowHeight(25);
        tbNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNhanVienMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbNhanVien);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1083, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 293, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Nhân Viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setText("Ngày Sinh:");
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel13.setText("Mật Khẩu:");
        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtPassWord.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPassWord.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 255)));

        jLabel10.setText("Chức Vụ:");
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        buttonGroup2.add(rdoTruongPhong);
        rdoTruongPhong.setText("Trưởng Phòng");
        rdoTruongPhong.setBackground(new java.awt.Color(255, 255, 255));
        rdoTruongPhong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        buttonGroup2.add(rdoNhanVien);
        rdoNhanVien.setText("Nhân Viên");
        rdoNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        rdoNhanVien.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rdoNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNhanVienActionPerformed(evt);
            }
        });

        jLabel7.setText("Số Điện Thoại:");
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel11.setText("Email:");
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");
        rdoNu.setBackground(new java.awt.Color(255, 255, 255));
        rdoNu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel6.setText("Giới Tính:");
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtDiaChi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 255)));
        txtDiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChiActionPerformed(evt);
            }
        });

        jLabel3.setText("Họ Và Tên:");
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 255)));

        jLabel8.setText("Địa Chỉ:");
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtHoVaTen.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 255)));

        jLabel9.setText("Trạng Thái:");
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtMa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 255)));

        txtSoDienThoai.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 255)));
        txtSoDienThoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoDienThoaiActionPerformed(evt);
            }
        });

        jLabel2.setText("Mã:");
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");
        rdoNam.setBackground(new java.awt.Color(255, 255, 255));
        rdoNam.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(rdoTruongPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rdoNhanVien))
                            .addComponent(datePicker1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtHoVaTen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(rdoNam)
                                .addGap(31, 31, 31)
                                .addComponent(rdoNu))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(92, 92, 92)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPassWord)
                    .addComponent(txtSoDienThoai)
                    .addComponent(txtDiaChi)
                    .addComponent(cbTrangThai)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoVaTen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPassWord, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(datePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdoTruongPhong)
                        .addComponent(rdoNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        imgNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        imgNhanVien.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Hình Ảnh")));

        imgAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgAnhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout imgNhanVienLayout = new javax.swing.GroupLayout(imgNhanVien);
        imgNhanVien.setLayout(imgNhanVienLayout);
        imgNhanVienLayout.setHorizontalGroup(
            imgNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imgNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addContainerGap())
        );
        imgNhanVienLayout.setVerticalGroup(
            imgNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imgNhanVienLayout.createSequentialGroup()
                .addComponent(imgAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(imgNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imgNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Tìm Kiếm:");
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnExport.setText("ExportExxcel");
        btnExport.setBackground(new java.awt.Color(0, 153, 255));
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.setBackground(new java.awt.Color(0, 153, 255));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        txtTimKiem.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 255)));
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        btnAdd.setText("Thêm");
        btnAdd.setBackground(new java.awt.Color(0, 153, 255));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnAn.setText("Ẩn");
        btnAn.setBackground(new java.awt.Color(0, 153, 255));
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
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Thông Tin Nhân Viên", jPanel3);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1205, 741));

        btnCapNhapDaXoa.setText("Quay Lại Làm Việc");
        btnCapNhapDaXoa.setBackground(new java.awt.Color(0, 153, 255));
        btnCapNhapDaXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhapDaXoaActionPerformed(evt);
            }
        });

        jLabel12.setText("Tìm Kiếm:");
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtTimKiemDaXoa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 255)));
        txtTimKiemDaXoa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemDaXoaKeyReleased(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Nhân Viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        tbNhanVienNV.setModel(new javax.swing.table.DefaultTableModel(
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
        tbNhanVienNV.setColorBackgoundHead(new java.awt.Color(0, 153, 255));
        tbNhanVienNV.setColorBordeFilas(new java.awt.Color(0, 153, 255));
        tbNhanVienNV.setColorBordeHead(new java.awt.Color(255, 255, 255));
        tbNhanVienNV.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbNhanVienNV.setColorSelBackgound(new java.awt.Color(51, 204, 255));
        tbNhanVienNV.setFuenteFilas(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbNhanVienNV.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbNhanVienNV.setFuenteHead(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tbNhanVienNV.setGridColor(new java.awt.Color(255, 255, 255));
        tbNhanVienNV.setRowHeight(25);
        jScrollPane4.setViewportView(tbNhanVienNV);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1126, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1083, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 559, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
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
                        .addComponent(txtTimKiemDaXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 562, Short.MAX_VALUE)
                        .addComponent(btnCapNhapDaXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                            .addComponent(txtTimKiemDaXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCapNhapDaXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Nhân Viên Nghỉ Việc", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1117, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rdoNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNhanVienActionPerformed

    private void txtDiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChiActionPerformed

    private void txtSoDienThoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoDienThoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoDienThoaiActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        String tenTimKiem = txtTimKiem.getText();
        listnv = nvs.getAllByNameAndtrangThai(tenTimKiem, 1);
        loadTableDiLam(listnv);
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void txtTimKiemDaXoaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemDaXoaKeyReleased
        String tenTimKiemNV = txtTimKiemDaXoa.getText();
        listnvnv = nvs.getAllByNameAndtrangThai(tenTimKiemNV, 0);
        loadTableNghiViec(listnvnv);
    }//GEN-LAST:event_txtTimKiemDaXoaKeyReleased

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        JOptionPane.showMessageDialog(this, nvs.insert(getForm()));
        loadtable();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        JOptionPane.showMessageDialog(this, nvs.update(getFormSua()));
        loadtable();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnActionPerformed
        int i = tbNhanVien.getSelectedRow();
        NhanVienResponse nvr = listnv.get(i);
        NhanVien nv = nvs.findId(nvr.getId());
        nv.setTrangThai(0);
        nvs.SaveOrUpdate(nv);
        loadtable();
    }//GEN-LAST:event_btnAnActionPerformed

    private void btnCapNhapDaXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhapDaXoaActionPerformed
        // TODO add your handling code here:
        int i = tbNhanVienNV.getSelectedRow();
        NhanVienResponse nvr = listnvnv.get(i);
        NhanVien nv = nvs.findId(nvr.getId());
        nv.setTrangThai(1);
        nvs.SaveOrUpdate(nv);
        loadtable();
    }//GEN-LAST:event_btnCapNhapDaXoaActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, nvs.printExcel());
    }//GEN-LAST:event_btnExportActionPerformed

    private void imgAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgAnhMouseClicked
        try {
            JFileChooser fileChooser = new JFileChooser("image\\");
            int kq = fileChooser.showOpenDialog(fileChooser);
            if (kq == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                if (file.getName().endsWith(".jpg") || file.getName().endsWith(".png") || file.getName().endsWith(".jpeg")) {
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

    private void tbNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNhanVienMouseClicked
        int i = tbNhanVien.getSelectedRow();
        fillData(i);
    }//GEN-LAST:event_tbNhanVienMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAn;
    private javax.swing.JButton btnCapNhapDaXoa;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnSua;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBox cbTrangThai;
    private com.github.lgooddatepicker.components.DatePicker datePicker1;
    private rojerusan.RSLabelImage imgAnh;
    private javax.swing.JPanel imgNhanVien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNhanVien;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JRadioButton rdoTruongPhong;
    private rojeru_san.complementos.RSTableMetro tbNhanVien;
    private rojeru_san.complementos.RSTableMetro tbNhanVienNV;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoVaTen;
    private javax.swing.JTextField txtMa;
    private javax.swing.JPasswordField txtPassWord;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTimKiemDaXoa;
    // End of variables declaration//GEN-END:variables
}
