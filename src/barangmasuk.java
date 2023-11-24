import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author SKMI UTAMA6
 */
public class barangmasuk extends javax.swing.JFrame {
    private javax.swing.table.DefaultTableModel tabelmodel = new DefaultTableModel();
    //private DefaultTableModel model;
    /**
     * Creates new form barangmasuk
     */
    public barangmasuk() {
        initComponents();
        TampilComboPetugas();
        TampilComboBarang();
        TampilComboDistributor();
        nonota();
        kosong();
        SetEditOn();
        SetEditOff();
        loadData();
       // TampilGridDetail();
        
        // Mendapatkan tanggal saat ini
        Date date = new Date();
        
        // Format tanggal
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String tanggal = dateFormat.format(date);
        // Menetapkan tanggal ke dalam JFormattedTextField
        txttglbrng.setText(tanggal);
    }

    public void nonota() {
    Date sk = new Date();

        SimpleDateFormat format1=new SimpleDateFormat("yyMMdd");
        String time = format1.format(sk);
        
        
        try{
            String sql = "select right(NoNota ,1) as kd from tblbrgmasuk order by kd desc";
            Connection c = koneksi.getKoneksi(); 
            Statement s = c.createStatement();       
            ResultSet rs = s.executeQuery(sql);
                if (rs.next()){

                    int kode = Integer.parseInt(rs.getString("kd"))+1;

                    txtnota.setText(time+Integer.toString(kode));

                }else{

                    int kode = 1;

                    txtnota.setText(time+Integer.toString(kode));

                }
            

        }catch (SQLException | NumberFormatException e){

            JOptionPane.showMessageDialog(null, e);

        }
}
    
    public void kosong(){
        tabelmodel.setRowCount(0);
        txtnamapetugas.setText("");
        combopetugas.setSelectedIndex(0);
        combodistributor.setSelectedIndex(0);
        txtnamadistributor.setText("");
        txtkota.setText("");
        combokodebarang.setSelectedIndex(0);
        txtnamabarang.setText("");
        txthargajual.setText("");
        txtjumlah.setText("");
        txtstok.setText("");
        txtsubtotal.setText("");
        txttotal.setText("0");
    }
    
    public void BersihDetail(){
        combokodebarang.setSelectedIndex(0);
        txtnamabarang.setText("");
        txthargajual.setText("");
        txtstok.setText("");
        txtjumlah.setText("");
        txtsubtotal.setText("");
    }
    
    public void totalBiaya(){
        int jumlahBaris = tabelbarangmasuk.getRowCount();
        double totalBiaya = 0;
        int jumlahBarang;
        double hargaBarang;
        for (int i = 0; i < jumlahBaris; i++) {
            jumlahBarang = Integer.parseInt(tabelbarangmasuk.getValueAt(i, 4).toString());
            hargaBarang = Double.parseDouble(tabelbarangmasuk.getValueAt(i, 2).toString());
            totalBiaya = totalBiaya + (jumlahBarang * hargaBarang);
        }
        txttotal.setText(String.format("%.2f", totalBiaya));
    }
    
    public void SetEditOff(){
        txtnota.setEnabled(false); 
        txttglbrng.setEnabled(false);
        combodistributor.setEnabled(false);
        combopetugas.setEnabled(false);
        txtnamapetugas.setEnabled(false);
        txtnamadistributor.setEnabled(false);
        txtkota.setEnabled(false);
        combokodebarang.setEnabled(false);
        txtnamabarang.setEnabled(false);
        txthargajual.setEnabled(false);
        txtstok.setEnabled(false);
        txtjumlah.setEnabled(false); 
        txtsubtotal.setEnabled(false);
        btnhitung.setEnabled(false); 
        btncaridata.setEnabled(false); 
        btnitem.setEnabled(false);
        btnsave.setEnabled(false);
        //btnclose.setEnabled(false);
    }
    
    public void SetEditOn(){
        txtnota.setEnabled(true); 
        txttglbrng.setEnabled(true); 
        combopetugas.setEnabled(true); 
        txtnamapetugas.setEnabled(true);
        combodistributor.setEnabled(true);
        txtnamadistributor.setEnabled(true);
        txtkota.setEnabled(true);
        combokodebarang.setEnabled(true); 
        txtnamabarang.setEnabled(true);
        txthargajual.setEnabled(true);
        txtstok.setEnabled(true);
        txtjumlah.setEnabled(true); 
        btnsave.setEnabled(true); 
        btncaridata.setEnabled(true); 
        btnhitung.setEnabled(true);
        txtsubtotal.setEnabled(true);
        btnitem.setEnabled(true);
        btnsave.setEnabled(true);
        btnclose.setEnabled(true);
    }
    
    public void TampilGridDetail() {
    //membuat model
    tabelmodel = new DefaultTableModel();
    
    //menghapus seluruh data
    tabelmodel.getDataVector().removeAllElements();
    //memberi tau bahwa data telah kosong
    tabelmodel.fireTableDataChanged();
    
    tabelbarangmasuk.setModel(tabelmodel);
    tabelmodel.addColumn("Kode Barang");
    tabelmodel.addColumn("Nama Barang");
    tabelmodel.addColumn("Harga Jual");
    tabelmodel.addColumn("Stok");
    tabelmodel.addColumn("Jumlah");
    tabelmodel.addColumn("Subtotal");
    
    try {
        String sql = "SELECT tblbarang.KodeBarang,tblbarang.NamaBarang,tblbarang.HargaJual,tblbarang.Stok,tbldetailbrgmasuk.Jumlah,tbldetailbrgmasuk.Subtottal, tblbrgmasuk.NoNota FROM tblbarang,tbldetailbrgmasuk,tblbrgmasuk WHERE tblbarang.KodeBarang=tbldetailbrgmasuk.KodeBarang AND tblbrgmasuk.NoNota=tbldetailbrgmasuk.NoNota AND tbldetailbrgmasuk.NoNota='"+txtnota.getText()+"'";
        
        Connection c = koneksi.getKoneksi(); 
            Statement s = c.createStatement();       
            ResultSet res = s.executeQuery(sql);  

            while(res.next()){
                String data[] = new String[6];
            // lakukan penelusuran baris 
                data[0] = res.getString(1);
                data[1] = res.getString(2);
                data[2] = res.getString(3);
                data[3] = res.getString(4);
                data[4] = res.getString(5);
                data[5] = res.getString(6);
                tabelmodel.addRow(data);
            }
    tabelbarangmasuk.setModel(tabelmodel);
    
    }catch(SQLException e){ 
            System.out.println("Terjadi Error");
        }
    }
    
    private void loadData(){
    //membuat model
    tabelmodel = new DefaultTableModel();
    
    //menghapus seluruh data
    tabelmodel.getDataVector().removeAllElements();
    //memberi tau bahwa data telah kosong
    tabelmodel.fireTableDataChanged();
    
    tabelbarangmasuk.setModel(tabelmodel);
    tabelmodel.addColumn("Kode Barang");
    tabelmodel.addColumn("Nama Barang");
    tabelmodel.addColumn("Harga Jual");
    tabelmodel.addColumn("Stok");
    tabelmodel.addColumn("Jumlah");
    tabelmodel.addColumn("Subtotal");
    
    try {
        String sql = "SELECT tblbarang.KodeBarang,tblbarang.NamaBarang,tblbarang.HargaJual,tblbarang.Stok,tbldetailbrgmasuk.Jumlah,tbldetailbrgmasuk.Subtottal, tblbrgmasuk.NoNota FROM tblbarang,tbldetailbrgmasuk,tblbrgmasuk WHERE tblbarang.KodeBarang=tbldetailbrgmasuk.KodeBarang AND tblbrgmasuk.NoNota=tbldetailbrgmasuk.NoNota AND tbldetailbrgmasuk.NoNota='"+txtnota.getText()+"'";
        
        Connection c = koneksi.getKoneksi(); 
            Statement s = c.createStatement();       
            ResultSet res = s.executeQuery(sql);  

            while(res.next()){
                String data[] = new String[6];
            // lakukan penelusuran baris 
                data[0] = res.getString(1);
                data[1] = res.getString(2);
                data[2] = res.getString(3);
                data[3] = res.getString(4);
                data[4] = res.getString(5);
                data[5] = res.getString(6);
                tabelmodel.addRow(data);
            }
    tabelbarangmasuk.setModel(tabelmodel);
    
    }catch(SQLException e){ 
            System.out.println("Terjadi Error");
        }
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txttglbrng = new javax.swing.JTextField();
        txtnota = new javax.swing.JTextField();
        btncaridata = new javax.swing.JButton();
        combopetugas = new javax.swing.JComboBox<>();
        txtnamapetugas = new javax.swing.JTextField();
        combodistributor = new javax.swing.JComboBox<>();
        txtnamadistributor = new javax.swing.JTextField();
        txtkota = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        combokodebarang = new javax.swing.JComboBox<>();
        txtnamabarang = new javax.swing.JTextField();
        txthargajual = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnitem = new javax.swing.JButton();
        txtstok = new javax.swing.JTextField();
        txtjumlah = new javax.swing.JTextField();
        btnhitung = new javax.swing.JButton();
        txtsubtotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelbarangmasuk = new javax.swing.JTable();
        btnnew = new javax.swing.JButton();
        btnsave = new javax.swing.JButton();
        btnclose = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(212, 234, 247));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Tanggal Barang Masuk ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel3.setText("No.Nota");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel4.setText("ID Petugas ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel5.setText("Nama Petugas");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel6.setText("ID Distributor");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jLabel7.setText("Nama Distributor");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        jLabel8.setText("Kota Asal");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        txttglbrng.setEnabled(false);
        getContentPane().add(txttglbrng, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 270, -1));
        getContentPane().add(txtnota, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 110, -1));

        btncaridata.setBackground(new java.awt.Color(0, 102, 140));
        btncaridata.setForeground(new java.awt.Color(255, 255, 255));
        btncaridata.setText("Search Data");
        btncaridata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncaridataActionPerformed(evt);
            }
        });
        getContentPane().add(btncaridata, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 150, -1));

        combopetugas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select An Officer" }));
        combopetugas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combopetugasItemStateChanged(evt);
            }
        });
        combopetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combopetugasActionPerformed(evt);
            }
        });
        getContentPane().add(combopetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 270, -1));

        txtnamapetugas.setEnabled(false);
        getContentPane().add(txtnamapetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 500, -1));

        combodistributor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select An Distributor" }));
        combodistributor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combodistributorItemStateChanged(evt);
            }
        });
        getContentPane().add(combodistributor, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 270, -1));

        txtnamadistributor.setEnabled(false);
        getContentPane().add(txtnamadistributor, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 500, -1));

        txtkota.setEnabled(false);
        getContentPane().add(txtkota, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 500, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detail Barang Masuk"));
        jPanel1.setName("Detail Barang Masuk"); // NOI18N

        jLabel9.setText("Kode Barang");

        jLabel10.setText("Nama Barang");

        jLabel11.setText("Harga Jual");

        combokodebarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Item Data" }));
        combokodebarang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combokodebarangItemStateChanged(evt);
            }
        });
        combokodebarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combokodebarangActionPerformed(evt);
            }
        });

        txtnamabarang.setEnabled(false);

        txthargajual.setEnabled(false);
        txthargajual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthargajualActionPerformed(evt);
            }
        });

        jLabel12.setText("Rp");

        jLabel13.setText("Stok");

        jLabel14.setText("Jumlah");

        jLabel15.setText("Sub Total Rp");

        btnitem.setBackground(new java.awt.Color(0, 102, 140));
        btnitem.setForeground(new java.awt.Color(255, 255, 255));
        btnitem.setText("Add Item");
        btnitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnitemActionPerformed(evt);
            }
        });

        txtstok.setEnabled(false);

        txtjumlah.setEnabled(false);

        btnhitung.setBackground(new java.awt.Color(0, 102, 140));
        btnhitung.setForeground(new java.awt.Color(255, 255, 255));
        btnhitung.setText("Count");
        btnhitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhitungActionPerformed(evt);
            }
        });

        txtsubtotal.setText("0");
        txtsubtotal.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(combokodebarang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtnamabarang, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txthargajual)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnhitung))
                            .addComponent(txtsubtotal)
                            .addComponent(txtstok)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(btnitem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(combokodebarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtstok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtnamabarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)
                        .addComponent(txtjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnhitung)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txthargajual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel15)
                    .addComponent(txtsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnitem)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 690, 200));

        tabelbarangmasuk.setBackground(new java.awt.Color(182, 204, 216));
        tabelbarangmasuk.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelbarangmasuk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelbarangmasukMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelbarangmasuk);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 690, 230));

        btnnew.setBackground(new java.awt.Color(0, 102, 140));
        btnnew.setForeground(new java.awt.Color(255, 255, 255));
        btnnew.setText("Add New");
        btnnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnewActionPerformed(evt);
            }
        });
        getContentPane().add(btnnew, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 780, 150, -1));

        btnsave.setBackground(new java.awt.Color(0, 102, 140));
        btnsave.setForeground(new java.awt.Color(255, 255, 255));
        btnsave.setText("Save Transaction");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 780, 200, -1));

        btnclose.setBackground(new java.awt.Color(204, 0, 0));
        btnclose.setForeground(new java.awt.Color(255, 255, 255));
        btnclose.setText("Close");
        btnclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnclose, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 780, -1, -1));

        jLabel16.setText("Total  Rp");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 780, -1, -1));

        txttotal.setEnabled(false);
        txttotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalActionPerformed(evt);
            }
        });
        getContentPane().add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 780, 120, -1));

        jPanel2.setBackground(new java.awt.Color(212, 234, 247));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Barang Masuk");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(jLabel1)
                .addContainerGap(298, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void TampilComboPetugas(){
        try {
            Connection c = koneksi.getKoneksi();
            String sql = "SELECT * FROM tblpetugas";
            PreparedStatement p = c.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                combopetugas.addItem(rs.getString("IDPetugas"));
            }
        } catch (SQLException ex) {
             System.out.println("Terjadi Error"+ex.getMessage());
        }
    }
    
    public void TampilComboBarang(){
        try {
            Connection c = koneksi.getKoneksi();
            String sql = "SELECT * FROM tblbarang";
            PreparedStatement p = c.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                combokodebarang.addItem(rs.getString("KodeBarang"));
            }
        } catch (SQLException ex) {
             System.out.println("Terjadi Error"+ex.getMessage());
        }
    }
    
    public void TampilComboDistributor(){
        try {
            Connection c = koneksi.getKoneksi();
            String sql = "SELECT * FROM tbldistributor";
            PreparedStatement p = c.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                combodistributor.addItem(rs.getString("IDDistributor"));
            }
        } catch (SQLException ex) {
             System.out.println("Terjadi Error"+ex.getMessage());
        }
    }
    private void txttotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalActionPerformed
        // TODO add your handling code mila here:
    }//GEN-LAST:event_txttotalActionPerformed

    private void combokodebarangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combokodebarangItemStateChanged
        // TODO add your handling code here:
        try {
            Connection c = koneksi.getKoneksi();
            Statement stt = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM tblbarang where KodeBarang='"+ combokodebarang.getSelectedItem().toString()+"'";
           
            ResultSet rs = stt.executeQuery(sql);
            rs.absolute(1);
            txtnamabarang.setText(rs.getString("namabarang"));
            txthargajual.setText(rs.getString("hargajual"));
            txtstok.setText(rs.getString("stok"));
            } catch (SQLException ex) {
        }
    }//GEN-LAST:event_combokodebarangItemStateChanged

    private void combopetugasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combopetugasItemStateChanged
        // TODO add your handling code here:
       try {
            Connection c = koneksi.getKoneksi();
            String sql = "SELECT * FROM tblpetugas where IDPetugas='"+ combopetugas.getSelectedItem().toString()+"'";
            //PreparedStatement p = c.prepareStatement(sql);
            Statement stt = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stt.executeQuery(sql);
            rs.absolute(1);
            txtnamapetugas.setText(rs.getString("namapetugas"));
            } catch (SQLException ex) {
        }
    }//GEN-LAST:event_combopetugasItemStateChanged

    private void btnhitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhitungActionPerformed
        // TODO add your handling code here:
        double a;
        int b;
        double c;   
        a = Integer.parseInt(txthargajual.getText());
        b = Integer.parseInt(txtjumlah.getText());
        c = a * b; 
        txtsubtotal.setText(String.format("%.2f", c));
    }//GEN-LAST:event_btnhitungActionPerformed

    private void btnnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnewActionPerformed
        // TODO add your handling code here:
          SetEditOn(); 
          kosong();
          txtnota.requestFocus();  
          nonota();
    }//GEN-LAST:event_btnnewActionPerformed

    private void combodistributorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combodistributorItemStateChanged
        // TODO add your handling code here:
        try {
            Connection c = koneksi.getKoneksi();
            String sql = "SELECT * FROM tbldistributor where IDDistributor='"+ combodistributor.getSelectedItem().toString()+"'";
            //PreparedStatement p = c.prepareStatement(sql);
            Statement stt = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stt.executeQuery(sql);
            rs.absolute(1);
            txtnamadistributor.setText(rs.getString("NamaDistributor"));
            txtkota.setText(rs.getString("KotaAsal"));
            } catch (SQLException ex) {
        }
    }//GEN-LAST:event_combodistributorItemStateChanged

    private void btncloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncloseActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(null,"This application will be close \n if you press button OK","Information", JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE)==JOptionPane.OK_OPTION)
        this.dispose();
    }//GEN-LAST:event_btncloseActionPerformed

    private void btncaridataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncaridataActionPerformed
        // TODO add your handling code here:
        try {
            Connection con = koneksi.getKoneksi();
            Statement stt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM tblbrgmasuk where NoNota='"+txtnota.getText().toString()+"'";
            ResultSet res = stt.executeQuery(SQL);
            res.absolute(1);
            TampilGridDetail();
            txttglbrng.setText(res.getString("TglMasuk"));
            combopetugas.setSelectedItem(res.getString("IDPetugas"));
            combodistributor.setSelectedItem(res.getString("IDDistributor"));
            txttotal.setText(res.getString("Total"));
            txtnota.setEnabled(false);
            btncaridata.setEnabled(false);
            } catch (SQLException ex) {
                 System.out.println("Terjadi Error"+ex.getMessage());
        }
    }//GEN-LAST:event_btncaridataActionPerformed

    private void btnitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnitemActionPerformed
        // TODO add your handling code here:
        String NT = txtnota.getText();
        String KB = combokodebarang.getSelectedItem().toString();
        String JM = txtjumlah.getText();
        
        
        
       
        if ((NT.isEmpty()) | (KB.isEmpty()) |(JM.isEmpty())) {
        JOptionPane.showMessageDialog(null,"data tidak boleh kosong, silahkan dilengkapi");
        combokodebarang.requestFocus();
        }else {
            try{
                Connection kon = koneksi.getKoneksi();
                Statement stt = kon.createStatement();
                String SQL = "insert into tbldetailbrgmasuk values('"+txtnota.getText()+"',"+
                "'"+combokodebarang.getSelectedItem()+"',"+
                "'"+txtjumlah.getText()+"',"+
                "'"+txtsubtotal.getText()+"')";
                stt.executeUpdate(SQL);
               
                Connection kon1 = koneksi.getKoneksi();
                Statement stt1 = kon1.createStatement();
                String SQL1 = "Update tblbarang Set stok=stok - '"+txtjumlah.getText()+"'" +
                "Where KodeBarang='"+combokodebarang.getSelectedItem().toString()+"'";
                stt1.executeUpdate(SQL1);
               
                String data[] = new String[6];
                data[0] = combokodebarang.getSelectedItem().toString();
                data[1] = txtnamabarang.getText();
                data[2] = txthargajual.getText();
                data[3] = txtstok.getText();
                data[4] = txtjumlah.getText();
                data[5] = txtsubtotal.getText();
                tabelmodel.insertRow(0, data);
                
                
                totalBiaya();
                stt.close();
                //kon.close();
                combokodebarang.requestFocus();
               // btnitem.setEnabled(false);
                btnsave.setEnabled(true);
                BersihDetail();
                combokodebarang.requestFocus();
            } catch(Exception ex){
                 System.out.println("Terjadi Error"+ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnitemActionPerformed

    private void combokodebarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combokodebarangActionPerformed
        // TODO add your handling code here:
        try {
            Connection c = koneksi.getKoneksi();
            String sql = "SELECT * FROM tblbrgmasuk where KodeBarang='"+ combokodebarang.getSelectedItem().toString()+"'";
            PreparedStatement p = c.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            rs.absolute(1);
            txtnamabarang.setText(rs.getString("NamaBarang"));
            txthargajual.setText(rs.getString("HargaJual"));
            txtstok.setText(rs.getString("Stok"));
            } catch (SQLException ex) {
        }
    }//GEN-LAST:event_combokodebarangActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        String NM = txtnota.getText();
        String IP = combopetugas.getSelectedItem().toString();
        String PI = combodistributor.getSelectedItem().toString();
        
            if ((NM.isEmpty())) {
            JOptionPane.showMessageDialog(null,"data tidak boleh kosong, silahkan dilengkapi");
            txtnota.requestFocus();
        }else {
            try {
           
                Connection con = koneksi.getKoneksi();
                Statement stt = con.createStatement();
                String SQL = "insert into tblbrgmasuk values('"+txtnota.getText()+"',"+
                "'"+txttglbrng.getText()+"',"+
                "'"+IP+"',"+
                "'"+PI+"',"+
                "'"+txttotal.getText()+"')";
                stt.executeUpdate(SQL);
                
                stt.close();
                
                kosong();
                SetEditOff();
            btnsave.setEnabled(false);
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }

    }//GEN-LAST:event_btnsaveActionPerformed

    private void tabelbarangmasukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelbarangmasukMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelbarangmasukMouseClicked

    private void txthargajualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthargajualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthargajualActionPerformed

    private void combopetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combopetugasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combopetugasActionPerformed

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
            java.util.logging.Logger.getLogger(barangmasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(barangmasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(barangmasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(barangmasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new barangmasuk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncaridata;
    private javax.swing.JButton btnclose;
    private javax.swing.JButton btnhitung;
    private javax.swing.JButton btnitem;
    private javax.swing.JButton btnnew;
    private javax.swing.JButton btnsave;
    private javax.swing.JComboBox<String> combodistributor;
    private javax.swing.JComboBox<String> combokodebarang;
    private javax.swing.JComboBox<String> combopetugas;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelbarangmasuk;
    private javax.swing.JTextField txthargajual;
    private javax.swing.JTextField txtjumlah;
    private javax.swing.JTextField txtkota;
    private javax.swing.JTextField txtnamabarang;
    private javax.swing.JTextField txtnamadistributor;
    private javax.swing.JTextField txtnamapetugas;
    private javax.swing.JTextField txtnota;
    private javax.swing.JTextField txtstok;
    private javax.swing.JTextField txtsubtotal;
    private javax.swing.JTextField txttglbrng;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
