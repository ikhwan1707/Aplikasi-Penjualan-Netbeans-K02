/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
/**
 *
 * @author SMKI Utama8
 */
public class penjualan extends javax.swing.JFrame {
    
    
    public penjualan() {
        initComponents();
        nofaktur();
        TampilComboPetugas();
        TampilComboBarang();
        kosong();
        SetEditOff();
        
        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize=this.getSize();
        if(frameSize.height > screenSize.height){
        frameSize.height=screenSize.height;
        }
        if(frameSize.width > screenSize.width){
        frameSize.width=screenSize.width;
        }
        
        this.setLocation((screenSize.width - frameSize.width) / 2,
        (screenSize.height = screenSize.height) / 10);
        
        tbhasil.setModel(tableModel);
        Tabel(tbhasil, new int[]{90,300,90,60,60,90});
        
        
         setDefaultTable();
        // Mendapatkan tanggal saat ini
        Date date = new Date();
        
        // Format tanggal
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String tanggal = dateFormat.format(date);
        // Menetapkan tanggal ke dalam JFormattedTextField
        txttanggal.setText(tanggal);
    }
    
    private javax.swing.table.DefaultTableModel tableModel=getDefaultTabelModel();
    
    private void Tabel(javax.swing.JTable tb, int lebar[] ) {
        tb.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        int kolom=tb.getColumnCount();
        for(int i=0;i < kolom;i++) {
            javax.swing.table.TableColumn tbc=tb.getColumnModel().getColumn(i);
            tbc.setPreferredWidth(lebar[i]);
            tb.setRowHeight(17);
        }
    }
    
    private javax.swing.table.DefaultTableModel getDefaultTabelModel() {
        return new javax.swing.table.DefaultTableModel(
        new Object[][] {},
        new String [] {"Kode Barang","Nama Barang","Harga Jual","Stok","Jumlah","Sub Total"}
        ){
            boolean[] canEdit = new boolean[]{
                false, false, false, false
            };
            
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return canEdit[columnIndex];
            }
        };
    }
    
    public void totalBiaya(){
        int jumlahBaris = tbhasil.getRowCount();
        double totalBiaya = 0;
        int jumlahBarang;
        double hargaBarang;
        for (int i = 0; i < jumlahBaris; i++) {
            jumlahBarang = Integer.parseInt(tbhasil.getValueAt(i, 4).toString());
            hargaBarang = Double.parseDouble(tbhasil.getValueAt(i, 2).toString());
            totalBiaya = totalBiaya + (jumlahBarang * hargaBarang);
        }
        txttotal.setText(String.format("%.2f", totalBiaya));
    }
    
    String data[]=new String[6];
    private void setDefaultTable() {
        try{
            
            String sql = "SELECT tblbarang.KodeBarang,tblbarang.NamaBarang,tblbarang.HargaJual,tblbarang.Stok,tbldetailpenjualan.Jumlah,"
                    + "tbldetailpenjualan.SubTotal,tblpenjualan.NoFaktur "
                    + "FROM tblbarang,tbldetailpenjualan,tblpenjualan WHERE tblbarang.KodeBarang=tbldetailpenjualan.KodeBarang "
                    + "AND tblpenjualan.NoFaktur=tbldetailpenjualan.NoFaktur AND tbldetailpenjualan.NoFaktur='"+txtnofaktur.getText()+"'";

            Connection c = koneksi.getKoneksi(); 
            Statement s = c.createStatement();       
            ResultSet res = s.executeQuery(sql);  

            while(res.next()){
            // lakukan penelusuran baris 
                data[0] = res.getString(1);
                data[1] = res.getString(2);
                data[2] = res.getString(3);
                data[3] = res.getString(4);
                data[4] = res.getString(5);
                data[5] = res.getString(6);
                tableModel.addRow(data);
            }
            
        }catch(SQLException e){ 
            System.out.println("Terjadi Error");
        }
    }
    public void BersihDetail(){
        //txtpetugas.setText("");
        //txtidpetugas.setText("");
        cmbkodebarang.setSelectedIndex(0);
        txtnamabarang.setText("");
        txthargajual.setText("");
        txtjumlah.setText("");
        txtstok.setText("");
        txtsubtotal.setText("");
    }
    public void kosong(){
        tableModel.setRowCount(0);
        //txtpetugas.setText("");
       // txtidpetugas.setText("");
        cmbkodebarang.setSelectedIndex(0);
        txtnamabarang.setText("");
        txthargajual.setText("");
        txtjumlah.setText("");
        txtstok.setText("");
        txtsubtotal.setText("");
    }

    private void TampilGridDetail(){
        try{
            
            String sql = "SELECT tblbarang.kodebarang,tblbarang.namabarang,tblbarang.hargajual,tblbarang.stok,tbldetailpenjualan.jumlah,"
                    + "tbldetailpenjualan.subtotal,tblpenjualan.nofaktur "
                    + "FROM tblbarang,tbldetailpenjualan,tblpenjualan WHERE tblbarang.kodebarang=tbldetailpenjualan.kodebarang "
                    + "AND tblpenjualan.nofaktur=tbldetailpenjualan.nofaktur AND tbldetailpenjualan.nofaktur='"+txtnofaktur.getText()+"'";

            Connection c = koneksi.getKoneksi(); 
            Statement s = c.createStatement();       
            ResultSet res = s.executeQuery(sql);  

            while(res.next()){
            // lakukan penelusuran baris 
                data[0] = res.getString(1);
                data[1] = res.getString(2);
                data[2] = res.getString(3);
                data[3] = res.getString(4);
                data[4] = res.getString(5);
                data[5] = res.getString(6);
                tableModel.addRow(data);
            }
            
        }catch(SQLException e){ 
           System.err.println(e.getMessage());
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

        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtpetugas = new javax.swing.JTextField();
        txttanggal = new javax.swing.JFormattedTextField();
        jPanel9 = new javax.swing.JPanel();
        cmbkodebarang = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        txtnamabarang = new javax.swing.JTextField();
        txtsubtotal = new javax.swing.JTextField();
        txtstok = new javax.swing.JTextField();
        btnadditem = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        txthargajual = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        txtjumlah = new javax.swing.JTextField();
        btnhitung = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtnofaktur = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbhasil = new javax.swing.JTable();
        btnclose = new javax.swing.JButton();
        btnaddnew = new javax.swing.JButton();
        btnsave = new javax.swing.JButton();
        btncancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        txtbayar = new javax.swing.JTextField();
        txtsisa = new javax.swing.JTextField();
        btncaridata = new javax.swing.JButton();
        txtidpetugas = new javax.swing.JTextField();
        btncaripetugas = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setForeground(new java.awt.Color(255, 255, 255));

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("No. Faktur");
        jPanel8.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel3.setText("ID Petugas");
        jPanel8.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel5.setText("Nama Petugas");
        jPanel8.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, -1, -1));

        txtpetugas.setEnabled(false);
        jPanel8.add(txtpetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 200, -1));

        txttanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttanggalActionPerformed(evt);
            }
        });
        jPanel8.add(txttanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 200, -1));

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Barang"));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbkodebarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Data Barang" }));
        cmbkodebarang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbkodebarangItemStateChanged(evt);
            }
        });
        cmbkodebarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbkodebarangActionPerformed(evt);
            }
        });
        jPanel9.add(cmbkodebarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 140, -1));

        jLabel12.setText("Kode Barang");
        jPanel9.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel13.setText("Nama Barang");
        jPanel9.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, -1, -1));

        jLabel14.setText("Harga Jual");
        jPanel9.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, -1, -1));

        jLabel46.setText("Stok");
        jPanel9.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, -1));

        txtnamabarang.setEnabled(false);
        jPanel9.add(txtnamabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 330, -1));

        txtsubtotal.setEnabled(false);
        jPanel9.add(txtsubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, 130, -1));

        txtstok.setEnabled(false);
        jPanel9.add(txtstok, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 120, -1));

        btnadditem.setBackground(new java.awt.Color(0, 102, 140));
        btnadditem.setForeground(new java.awt.Color(255, 255, 255));
        btnadditem.setText("Add Item");
        btnadditem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnadditemActionPerformed(evt);
            }
        });
        jPanel9.add(btnadditem, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, 170, -1));

        jLabel47.setText("Jumlah");
        jPanel9.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, -1, -1));

        txthargajual.setEnabled(false);
        jPanel9.add(txthargajual, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 200, -1));

        jLabel48.setText("Sub Total Rp");
        jPanel9.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 130, -1, -1));
        jPanel9.add(txtjumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 70, -1));

        btnhitung.setBackground(new java.awt.Color(0, 102, 140));
        btnhitung.setForeground(new java.awt.Color(255, 255, 255));
        btnhitung.setText("Count");
        btnhitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhitungActionPerformed(evt);
            }
        });
        jPanel9.add(btnhitung, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, -1, -1));

        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 740, 240));

        jLabel6.setText("Tanggal Penjualan");
        jPanel8.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, -1, -1));

        txtnofaktur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnofakturActionPerformed(evt);
            }
        });
        jPanel8.add(txtnofaktur, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 140, -1));

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Grid Data Barang"));

        tbhasil.setBackground(new java.awt.Color(182, 204, 216));
        tbhasil.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbhasil);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel8.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 740, 180));

        btnclose.setBackground(new java.awt.Color(204, 0, 0));
        btnclose.setForeground(new java.awt.Color(255, 255, 255));
        btnclose.setText("Close");
        btnclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncloseActionPerformed(evt);
            }
        });
        jPanel8.add(btnclose, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 620, -1, -1));

        btnaddnew.setBackground(new java.awt.Color(0, 102, 140));
        btnaddnew.setForeground(new java.awt.Color(255, 255, 255));
        btnaddnew.setText("Add New");
        btnaddnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddnewActionPerformed(evt);
            }
        });
        jPanel8.add(btnaddnew, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, -1, -1));

        btnsave.setBackground(new java.awt.Color(0, 102, 140));
        btnsave.setForeground(new java.awt.Color(255, 255, 255));
        btnsave.setText("Save Transaction");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });
        jPanel8.add(btnsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 620, 130, -1));

        btncancel.setBackground(new java.awt.Color(204, 0, 0));
        btncancel.setForeground(new java.awt.Color(255, 255, 255));
        btncancel.setText("Cancel");
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });
        jPanel8.add(btncancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 620, -1, -1));

        jLabel1.setText("Total Rp");
        jPanel8.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 690, -1, -1));

        jLabel49.setText("Bayar Rp");
        jPanel8.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 630, -1, -1));

        jLabel50.setText("Sisa Rp");
        jPanel8.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 660, -1, -1));

        txttotal.setEnabled(false);
        txttotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalActionPerformed(evt);
            }
        });
        jPanel8.add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 690, 220, -1));

        txtbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbayarActionPerformed(evt);
            }
        });
        jPanel8.add(txtbayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 630, 220, -1));

        txtsisa.setEnabled(false);
        txtsisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsisaActionPerformed(evt);
            }
        });
        jPanel8.add(txtsisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 660, 220, -1));

        btncaridata.setBackground(new java.awt.Color(0, 102, 140));
        btncaridata.setForeground(new java.awt.Color(255, 255, 255));
        btncaridata.setText("Search");
        btncaridata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncaridataActionPerformed(evt);
            }
        });
        jPanel8.add(btncaridata, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, -1, -1));
        jPanel8.add(txtidpetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 140, -1));

        btncaripetugas.setBackground(new java.awt.Color(0, 102, 140));
        btncaripetugas.setForeground(new java.awt.Color(255, 255, 255));
        btncaripetugas.setText("Find an Officer");
        btncaripetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncaripetugasActionPerformed(evt);
            }
        });
        jPanel8.add(btncaripetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 150, -1));

        jPanel1.setBackground(new java.awt.Color(212, 234, 247));

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel45.setText("Entri Data Penjualan Barang");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(jLabel45)
                .addContainerGap(244, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel45)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel8.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 60));

        jScrollPane3.setViewportView(jPanel8);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 790, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public void nofaktur() {
    Date sk = new Date();

        SimpleDateFormat format1=new SimpleDateFormat("yyMMdd");
        String time = format1.format(sk);
        
        
        try{
            String sql = "select right(NoFaktur ,1) as kd from tblpenjualan order by kd desc";
            Connection c = koneksi.getKoneksi(); 
            Statement s = c.createStatement();       
            ResultSet rs = s.executeQuery(sql);
                if (rs.next()){

                    int kode = Integer.parseInt(rs.getString("kd"))+1;

                    txtnofaktur.setText(time+Integer.toString(kode));

                }else{

                    int kode = 1;

                    txtnofaktur.setText(time+Integer.toString(kode));

                }
            

        }catch (SQLException | NumberFormatException e){

            JOptionPane.showMessageDialog(null, e);

        }
}
    
    
    
    public void TampilComboPetugas(){
        try {
            
            String SQL = "SELECT * FROM tblpetugas";
            
            Connection kon = koneksi.getKoneksi();
            Statement stt = kon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
           
            ResultSet res = stt.executeQuery(SQL);
            while(res.next()){
               // cmbpetugas.addItem(res.getString("IDPetugas"));
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
                cmbkodebarang.addItem(rs.getString("KodeBarang"));
            }
        } catch (SQLException ex) {
             System.out.println("Terjadi Error"+ex.getMessage());
        }
    }
    
    
    
    public void SetEditOff(){
        txtnofaktur.setEnabled(false); 
        txttanggal.setEnabled(false); 
       txtidpetugas.setEnabled(false);
        cmbkodebarang.setEnabled(false); 
        txtjumlah.setEnabled(false); 
        btnhitung.setEnabled(false); 
        btncaridata.setEnabled(false); 
        btnadditem.setEnabled(false);
        txtbayar.setText("0");
        txtsisa.setText("0");
        txttotal.setText("0");
        btncaripetugas.setEnabled(false);
//        btnclose.setEnabled(false);
//        btncancel.setEnabled(false);
        btnsave.setEnabled(false);
    }
    
    public void SetEditOn(){
        txtnofaktur.setEnabled(true); 
        txttanggal.setEnabled(true); 
        txtidpetugas.setEnabled(true);
        cmbkodebarang.setEnabled(true); 
        txtjumlah.setEnabled(true); 
        btnsave.setEnabled(true); 
        btncaridata.setEnabled(true); 
        btnhitung.setEnabled(true); 
        btnadditem.setEnabled(true);
        txtbayar.setText("0");
        txtsisa.setText("0");
        txttotal.setText("0");
        btncaripetugas.setEnabled(true);
        btnclose.setEnabled(true);
        btncancel.setEnabled(true);
        btnsave.setEnabled(true);
    }
    
    
    
    
    private void cmbkodebarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbkodebarangActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cmbkodebarangActionPerformed
    
    private void btnadditemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnadditemActionPerformed
        // TODO add your handling code here:
        String NM=txtnofaktur.getText();
        String KB=cmbkodebarang.getSelectedItem().toString();
        String JM=txtjumlah.getText();
        
        cmbkodebarang.requestFocus();
        
        if ((NM.isEmpty()) | (KB.isEmpty()) |(JM.isEmpty())) {
           JOptionPane.showMessageDialog(null,"data tidak boleh kosong, silahkan dilengkapi");
        }else {
            try{
                Connection con = koneksi.getKoneksi();
                Statement stt = con.createStatement();
                String SQL = "insert into tbldetailpenjualan values('"+txtnofaktur.getText()+"',"+
                "'"+cmbkodebarang.getSelectedItem()+"',"+
                "'"+txtjumlah.getText()+"',"+
                "'"+txtsubtotal.getText()+"')";
                stt.executeUpdate(SQL);
               
                Connection con1 = koneksi.getKoneksi();
                Statement stt1 = con.createStatement();
                String SQL1 = "Update tblbarang Set Stok=Stok - '"+txtjumlah.getText()+"'" +
                "Where kodebarang='"+cmbkodebarang.getSelectedItem().toString()+"'";
                stt1.executeUpdate(SQL1);
               
                
                data[0] = cmbkodebarang.getSelectedItem().toString();
                data[1] = txtnamabarang.getText();
                data[2] = txthargajual.getText();
                data[3] = txtstok.getText();
                data[4] = txtjumlah.getText();
                data[5] = txtsubtotal.getText();
                tableModel.insertRow(0, data);
                
                totalBiaya();
                stt.close();
                cmbkodebarang.requestFocus();
                btnsave.setEnabled(true);
                BersihDetail();
                cmbkodebarang.requestFocus();
                
            } catch(Exception ex){
                 System.out.println("Terjadi Error: "+ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnadditemActionPerformed

    private void btncloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncloseActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(null,"This application will be close \n if you press button OK","Information", JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE)==JOptionPane.OK_OPTION)
        this.dispose();
    }//GEN-LAST:event_btncloseActionPerformed

    private void txttotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalActionPerformed

    private void txtsisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsisaActionPerformed

    private void btncaridataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncaridataActionPerformed
        // TODO add your handling code here:
        try {
    Connection con = koneksi.getKoneksi();
    String SQL = "SELECT * FROM tblpenjualan WHERE nofaktur=?";
    
    try (PreparedStatement pst = con.prepareStatement(SQL)) {
        pst.setString(1, txtnofaktur.getText().toString());
        ResultSet res = pst.executeQuery();
        
        if (res.next()) {
            TampilGridDetail();
            txttanggal.setText(res.getString("TglPenjualan"));
            txtidpetugas.setText(res.getString("IDPetugas"));
            txtbayar.setText(res.getString("Bayar"));
            txtsisa.setText(res.getString("Sisa"));
            txttotal.setText(res.getString("Total"));
            
            btnsave.setEnabled(false);
            txtnofaktur.setEnabled(false);
            btncaridata.setEnabled(false);
        } else {
            System.out.println("Data tidak ditemukan");
        }
    }
} catch (SQLException ex) {
    ex.printStackTrace();
    System.out.println("Terjadi Error: " + ex.getMessage());
}

    }//GEN-LAST:event_btncaridataActionPerformed

    private void txttanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttanggalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttanggalActionPerformed

    private void cmbkodebarangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbkodebarangItemStateChanged
        // TODO add your handling code here:
        try {
            Connection kon = koneksi.getKoneksi();
            Statement stt = kon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM tblbarang where KodeBarang='"+ cmbkodebarang.getSelectedItem().toString()+"'";
            ResultSet rs = stt.executeQuery(SQL);
            rs.absolute(1);
             txtnamabarang.setText(rs.getString("NamaBarang"));
            txthargajual.setText(rs.getString("HargaJual"));
            txtstok.setText(rs.getString("Stok"));
            } catch (SQLException ex) {
        }
    }//GEN-LAST:event_cmbkodebarangItemStateChanged

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

    private void txtbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbayarActionPerformed
        // TODO add your handling code here:
        double total, bayar, kembalian;
        
        total = Double.valueOf(txttotal.getText());
        bayar = Double.valueOf(txtbayar.getText());
        
        if (total > bayar) {
            JOptionPane.showMessageDialog(null, "Uang tidak cukup untuk melakukan pembayaran");
        } else {
            kembalian = bayar - total;
            txtsisa.setText(String.format("%.2f", kembalian));
        }
    }//GEN-LAST:event_txtbayarActionPerformed

    private void btnaddnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddnewActionPerformed
        // TODO add your handling code here:
        SetEditOn(); 
        kosong();
        txtnofaktur.requestFocus();  
        nofaktur();
    }//GEN-LAST:event_btnaddnewActionPerformed

    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
        // TODO add your handling code here:
        kosong();
        SetEditOff();
    }//GEN-LAST:event_btncancelActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        String NM = txtnofaktur.getText();
        String IP= txtidpetugas.getText();
        
            if ((NM.isEmpty())) {
            JOptionPane.showMessageDialog(null,"data tidak boleh kosong, silahkan dilengkapi");
            txtnofaktur.requestFocus();
        }else {
            try {
           
                Connection con = koneksi.getKoneksi();
                Statement stt = con.createStatement();
                String SQL = "insert into tblpenjualan values('"+txtnofaktur.getText()+"','"+txttanggal.getText()+"','"+txtidpetugas.getText()+"','"+txtbayar.getText()+"','"+txtsisa.getText()+"','"+txttotal.getText()+"')";
                stt.executeUpdate(SQL);
                
                stt.close();
                
                kosong();
                SetEditOff();
                 JOptionPane.showMessageDialog(null,"Transaksi Berhasil");
            btnsave.setEnabled(false);
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }

    }//GEN-LAST:event_btnsaveActionPerformed

    private void btncaripetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncaripetugasActionPerformed
        // TODO add your handling code here:
         listpetugas a = new listpetugas();
        a.setVisible(true);
    }//GEN-LAST:event_btncaripetugasActionPerformed

    private void txtnofakturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnofakturActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnofakturActionPerformed

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
            java.util.logging.Logger.getLogger(penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new penjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadditem;
    private javax.swing.JButton btnaddnew;
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btncaridata;
    private javax.swing.JButton btncaripetugas;
    private javax.swing.JButton btnclose;
    private javax.swing.JButton btnhitung;
    private javax.swing.JButton btnsave;
    private javax.swing.JComboBox<String> cmbkodebarang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbhasil;
    private javax.swing.JTextField txtbayar;
    private javax.swing.JTextField txthargajual;
    public static javax.swing.JTextField txtidpetugas;
    private javax.swing.JTextField txtjumlah;
    private javax.swing.JTextField txtnamabarang;
    private javax.swing.JTextField txtnofaktur;
    public static javax.swing.JTextField txtpetugas;
    private javax.swing.JTextField txtsisa;
    private javax.swing.JTextField txtstok;
    private javax.swing.JTextField txtsubtotal;
    private javax.swing.JFormattedTextField txttanggal;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables





}
