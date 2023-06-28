
package view;

import domainModel.ChatLieuVo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.ChatLieuVoService;
import service.impl.ChatLieuVoServiceImpl;
import viewModel.ChatLieuVoResponse;

/**
 *
 * @author Admin
 */
public class ViewChatLieuVo extends javax.swing.JFrame {

    private ChatLieuVoService chatLieuVoService = new ChatLieuVoServiceImpl();
    private List<ChatLieuVoResponse> listCLV = new ArrayList<>();
    private List<ChatLieuVoResponse> listCLV2 = new ArrayList<>();

    /**
     * Creates new form ViewChatLieuVo
     */
    public ViewChatLieuVo() {
        initComponents();
        setLocationRelativeTo(null);
        loadData();
    }

    private void showData(List<ChatLieuVoResponse> listCLV) {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(new String[]{"STT", "Mã", "Tên", "Màu Sắc", "Mô Tả"});
        tblChatLieuVo.setModel(dtm);
        dtm.setRowCount(0);
        int i = 1;
        for (ChatLieuVoResponse x : listCLV) {
            dtm.addRow(x.toDataRow(i++));
        }
    }

    private void showData2(List<ChatLieuVoResponse> listCLV2) {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(new String[]{"STT", "Mã", "Tên", "Màu Sắc", "Mô Tả"});
        tblChatLieuVo1.setModel(dtm);
        dtm.setRowCount(0);
        int i = 1;
        for (ChatLieuVoResponse x : listCLV2) {
            dtm.addRow(x.toDataRow(i++));
        }
    }

    private void loadData() {
        listCLV = chatLieuVoService.getAllByTrangThai(1);
        showData(listCLV);
        for (ChatLieuVoResponse clv : listCLV) {
            System.out.println(clv.toString());
        }

        listCLV2 = chatLieuVoService.getAllByTrangThai(0);
        showData2(listCLV2);
        for (ChatLieuVoResponse clv : listCLV2) {
            System.out.println(clv.toString());
        }
    }

    private void fillData(int i) {
        ChatLieuVoResponse clv = listCLV.get(i);
        txtMa.setText(clv.getMa());
        txtTen.setText(clv.getTen());
        txtMauSac.setText(clv.getMauSac());
        txtMoTa.setText(clv.getMoTa());
    }

    private void fillData2(int i) {
        ChatLieuVoResponse clv = listCLV2.get(i);
        txtMa.setText(clv.getMa());
        txtTen.setText(clv.getTen());
        txtMauSac.setText(clv.getMauSac());
        txtMoTa.setText(clv.getMoTa());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtTen = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtMauSac = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMoTa = new javax.swing.JTextField();
        btnThêm = new javax.swing.JButton();
        btnCapNhap = new javax.swing.JButton();
        btnXuatExcel = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        tab = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblChatLieuVo = new rojeru_san.complementos.RSTableMetro();
        btnAn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblChatLieuVo1 = new rojeru_san.complementos.RSTableMetro();
        btnSuDung = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(954, 429));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Chất Liệu Vỏ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12)))); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(425, 380));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        txtTen.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 153, 255)));

        jLabel2.setText("Mã:");

        jLabel4.setText("Màu Sắc:");

        txtMa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 153, 255)));

        txtMauSac.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 153, 255)));

        jLabel3.setText("Tên:");

        jLabel6.setText("Mô Tả:");

        txtMoTa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 153, 255)));

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
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(156, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnThêm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCapNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                    .addComponent(btnXuatExcel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnThêm)
                        .addGap(25, 25, 25)
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

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Chất Liệu Vỏ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12)))); // NOI18N

        tblChatLieuVo.setModel(new javax.swing.table.DefaultTableModel(
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
        tblChatLieuVo.setColorBackgoundHead(new java.awt.Color(0, 153, 255));
        tblChatLieuVo.setColorBordeFilas(new java.awt.Color(0, 153, 255));
        tblChatLieuVo.setColorBordeHead(new java.awt.Color(255, 255, 255));
        tblChatLieuVo.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tblChatLieuVo.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tblChatLieuVo.setFocusCycleRoot(true);
        tblChatLieuVo.setFuenteFilas(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblChatLieuVo.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblChatLieuVo.setFuenteHead(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblChatLieuVo.setGridColor(new java.awt.Color(255, 255, 255));
        tblChatLieuVo.setGrosorBordeFilas(0);
        tblChatLieuVo.setGrosorBordeHead(0);
        tblChatLieuVo.setRowHeight(25);
        tblChatLieuVo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChatLieuVoMouseClicked(evt);
            }
        });
        tblChatLieuVo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblChatLieuVoKeyReleased(evt);
            }
        });
        jScrollPane6.setViewportView(tblChatLieuVo);

        btnAn.setBackground(new java.awt.Color(0, 153, 255));
        btnAn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAn.setForeground(new java.awt.Color(255, 255, 255));
        btnAn.setText("Ẩn");
        btnAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addContainerGap())
        );

        tab.addTab("Sử Dụng", jPanel5);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Chất Liệu Vỏ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12)))); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(462, 329));

        tblChatLieuVo1.setModel(new javax.swing.table.DefaultTableModel(
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
        tblChatLieuVo1.setColorBackgoundHead(new java.awt.Color(0, 153, 255));
        tblChatLieuVo1.setColorBordeFilas(new java.awt.Color(0, 153, 255));
        tblChatLieuVo1.setColorBordeHead(new java.awt.Color(255, 255, 255));
        tblChatLieuVo1.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tblChatLieuVo1.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tblChatLieuVo1.setFocusCycleRoot(true);
        tblChatLieuVo1.setFuenteFilas(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblChatLieuVo1.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblChatLieuVo1.setFuenteHead(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblChatLieuVo1.setGridColor(new java.awt.Color(255, 255, 255));
        tblChatLieuVo1.setGrosorBordeFilas(0);
        tblChatLieuVo1.setGrosorBordeHead(0);
        tblChatLieuVo1.setRowHeight(25);
        tblChatLieuVo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChatLieuVo1MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblChatLieuVo1);

        btnSuDung.setBackground(new java.awt.Color(0, 153, 255));
        btnSuDung.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSuDung.setForeground(new java.awt.Color(255, 255, 255));
        btnSuDung.setLabel("Sử dụng");
        btnSuDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuDungActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSuDung, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSuDung)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addContainerGap())
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
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
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

    private void tblChatLieuVoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChatLieuVoMouseClicked
        // TODO add your handling code here:
        int i = tblChatLieuVo.getSelectedRow();
        fillData(i);
    }//GEN-LAST:event_tblChatLieuVoMouseClicked

    private void tblChatLieuVo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChatLieuVo1MouseClicked
        // TODO add your handling code here:
        int i = tblChatLieuVo1.getSelectedRow();
        fillData(i);
    }//GEN-LAST:event_tblChatLieuVo1MouseClicked

    private void btnSuDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuDungActionPerformed
        int i = tblChatLieuVo1.getSelectedRow();
        ChatLieuVoResponse cl = listCLV2.get(i);
        ChatLieuVo clv = chatLieuVoService.findById(cl.getId());
        clv.setTrangThai(1);
        JOptionPane.showMessageDialog(this, "Khôi phục" + chatLieuVoService.update(clv));
        loadData();
    }//GEN-LAST:event_btnSuDungActionPerformed

    private void btnThêmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThêmActionPerformed
        ChatLieuVo clv = new ChatLieuVo();
        clv.setMa(txtMa.getText());
        clv.setTen(txtTen.getText());
        clv.setMauSac(txtMauSac.getText());
        clv.setMoTa(txtMoTa.getText());
        clv.setTrangThai(1);
        JOptionPane.showMessageDialog(this, chatLieuVoService.insert(clv));
        loadData();
    }//GEN-LAST:event_btnThêmActionPerformed

    private void btnCapNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhapActionPerformed
        // TODO add your handling code here:
        int i = tblChatLieuVo.getSelectedRow();
        ChatLieuVoResponse cl = listCLV.get(i);
        ChatLieuVo clv = chatLieuVoService.findById(cl.getId());
        clv.setMa(txtMa.getText());
        clv.setTen(txtTen.getText());
        clv.setMauSac(txtMauSac.getText());
        clv.setMoTa(txtMoTa.getText());
        JOptionPane.showMessageDialog(this, "Cập nhật" + chatLieuVoService.update(clv));
        loadData();
    }//GEN-LAST:event_btnCapNhapActionPerformed

    private void btnAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnActionPerformed
        // TODO add your handling code here:
        int i = tblChatLieuVo.getSelectedRow();
        ChatLieuVoResponse cl = listCLV.get(i);
        ChatLieuVo clv = chatLieuVoService.findById(cl.getId());
        clv.setTrangThai(0);
        JOptionPane.showMessageDialog(this, "Ẩn" + chatLieuVoService.update(clv));
        loadData();
    }//GEN-LAST:event_btnAnActionPerformed

    private void btnXuatExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatExcelActionPerformed
        JOptionPane.showMessageDialog(this, chatLieuVoService.printExcel());    }//GEN-LAST:event_btnXuatExcelActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
        if (tab.getSelectedIndex() == 0) {
            listCLV = chatLieuVoService.getAllByTenOrTrangThai(txtTimKiem.getText(), 1);
            showData(listCLV);
        } else {
            listCLV2 = chatLieuVoService.getAllByTenOrTrangThai(txtTimKiem.getText(), 0);
            showData2(listCLV2);
        }
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        new ViewChiTietSanPham().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void tblChatLieuVoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblChatLieuVoKeyReleased
        // TODO add your handling code here:
        int x = tblChatLieuVo.getSelectedRow();
            ChatLieuVoResponse cl = listCLV.get(x);
            ChatLieuVo clv = chatLieuVoService.findById(cl.getId());
            clv.setMa(tblChatLieuVo.getValueAt(x, 1).toString());
            clv.setTen(tblChatLieuVo.getValueAt(x, 2).toString());
            clv.setMauSac(tblChatLieuVo.getValueAt(x, 3).toString());
            clv.setMoTa(tblChatLieuVo.getValueAt(x, 4).toString());
            JOptionPane.showMessageDialog(this, "Cập nhật" + chatLieuVoService.update(clv));
            loadData();
    }//GEN-LAST:event_tblChatLieuVoKeyReleased

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
            java.util.logging.Logger.getLogger(ViewChatLieuVo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewChatLieuVo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewChatLieuVo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewChatLieuVo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ViewChatLieuVo().setVisible(true);
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane tab;
    private rojeru_san.complementos.RSTableMetro tblChatLieuVo;
    private rojeru_san.complementos.RSTableMetro tblChatLieuVo1;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMauSac;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
