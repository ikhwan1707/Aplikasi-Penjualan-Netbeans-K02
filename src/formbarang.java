import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


/**
 *
 * @author elsarsntna
 */
public class formbarang extends javax.swing.JFrame {

    /**
     * Creates new form formbarang
     */
     private DefaultTableModel model;
     
    public formbarang() {
        initComponents();
        loadData();
        kosong();
        TampilComboJenis();
        SetEnabledFalse();
       
    }
    
    public void SetEnabledFalse(){
        kd_barang.setEnabled(false);
        txtnama.setEnabled(false);
        cmbjenis.setEnabled(false);
        txtjenis.setEnabled(false);
        txtnet.setEnabled(false);
        txtjual.setEnabled(false);
        txtstok.setEnabled(false);
        btnsave.setEnabled(false);
        btnupdate.setEnabled(false);
        btndelete.setEnabled(false);               
       
        
    }
     
    public void SetEnabledTrue(){
        kd_barang.setEnabled(true);
        txtnama.setEnabled(true);
        cmbjenis.setEnabled(true);
        txtjenis.setEnabled(false);
        txtnet.setEnabled(true);
        txtjual.setEnabled(true);
        txtstok.setEnabled(true);
        btnsave.setEnabled(true);
        btnupdate.setEnabled(true);
        btndelete.setEnabled(true);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        kd_barang = new javax.swing.JTextField();
        txtnama = new javax.swing.JTextField();
        txtjenis = new javax.swing.JTextField();
        cmbjenis = new javax.swing.JComboBox<>();
        txtnet = new javax.swing.JTextField();
        txtjual = new javax.swing.JTextField();
        txtstok = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnadd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelbarang = new javax.swing.JTable();
        btnsave = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btncancel = new javax.swing.JButton();
        btnclose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(212, 234, 247));

        jLabel1.setFont(new java.awt.Font("Sitka Banner", 1, 18)); // NOI18N
        jLabel1.setText("Entri Data Barang ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(304, 304, 304)
                .addComponent(jLabel1)
                .addContainerGap(293, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel2.setText("Kode Barang");

        jLabel3.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel3.setText("Nama Barang");

        jLabel4.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel4.setText("Kode Jenis Barang");

        jLabel5.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel5.setText("Jenis Barang");

        jLabel6.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel6.setText("Harga Net");

        jLabel7.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel7.setText("Harga Jual");

        jLabel8.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel8.setText("Stok");

        txtnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamaActionPerformed(evt);
            }
        });

        txtjenis.setEnabled(false);

        cmbjenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Kode Jenis" }));
        cmbjenis.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbjenisItemStateChanged(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel9.setText("Rp");

        jLabel10.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel10.setText("Rp");

        btnadd.setBackground(new java.awt.Color(0, 102, 140));
        btnadd.setForeground(new java.awt.Color(255, 255, 255));
        btnadd.setText("Add New");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        tabelbarang.setBackground(new java.awt.Color(182, 204, 216));
        tabelbarang.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelbarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelbarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelbarang);

        btnsave.setBackground(new java.awt.Color(0, 102, 140));
        btnsave.setForeground(new java.awt.Color(255, 255, 255));
        btnsave.setText("Save");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        btnupdate.setBackground(new java.awt.Color(0, 102, 140));
        btnupdate.setForeground(new java.awt.Color(255, 255, 255));
        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        btndelete.setBackground(new java.awt.Color(204, 0, 0));
        btndelete.setForeground(new java.awt.Color(255, 255, 255));
        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        btncancel.setBackground(new java.awt.Color(204, 0, 0));
        btncancel.setForeground(new java.awt.Color(255, 255, 255));
        btncancel.setText("Cancel");
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });

        btnclose.setBackground(new java.awt.Color(204, 0, 0));
        btnclose.setForeground(new java.awt.Color(255, 255, 255));
        btnclose.setText("Close");
        btnclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbjenis, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(57, 57, 57)
                        .addComponent(kd_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(btnadd))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtstok, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtjual, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtnet, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9))
                                    .addComponent(txtjenis, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(54, 54, 54)
                        .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btndelete)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btncancel)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnsave)
                                    .addGap(28, 28, 28)
                                    .addComponent(btnupdate))))
                        .addGap(18, 18, 18)
                        .addComponent(btnclose)
                        .addGap(79, 79, 79))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(kd_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cmbjenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtjenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(txtnet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10)
                            .addComponent(txtjual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtstok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnsave)
                                    .addComponent(btnupdate))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btncancel)
                                    .addComponent(btndelete)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(btnclose)))))
                .addGap(18, 18, 18)
                .addComponent(btnadd)
                .addGap(0, 68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     public void TampilComboJenis(){
        try {
            String sql = "SELECT * FROM tbljenis";
            
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);
            
            while(r.next()){
                cmbjenis.addItem(r.getString("KodeJenis"));
            }
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    
    public void loadData(){
         // membuat model
        model = new DefaultTableModel ();
        
        // menghapus seluruh data
        model.getDataVector().removeAllElements();
        
        // memberi tahu bahwa data telah kosong 
        model.fireTableDataChanged();
        
        tabelbarang.setModel(model);
        model.addColumn("Kode Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Jenis Barang");
        model.addColumn("Harga Net");
        model.addColumn("Harga Jual");
        model.addColumn("Stok");
        
        try{
        
            
        String sql = "SELECT * FROM tblbarang";
        
        Connection  c = koneksi.getKoneksi();
        Statement s = c.createStatement();
        ResultSet r = s.executeQuery(sql);
        
        while(r.next()){
        // lakukan penelusuran baris
            model.addRow(new Object[]{
                r.getString(1),
                r.getString(2),
                r.getString(3),
                r.getString(4),
                r.getString(5),
                r.getString(6)
            });
        }
        tabelbarang.setModel(model);
        }catch(SQLException e){
            System.out.println("Terjadi Error");
        }
    }
    
    public void kosong(){
               
        kd_barang.setText(null);
        txtnama.setText(null);
        txtjenis.setText(null);
        txtnet.setText(null);
        txtjual.setText(null);
        txtstok.setText(null);
        cmbjenis.setSelectedIndex(0);
        
    }
    
     public void SetEditOff(){
        kd_barang.setEnabled(false);
        txtnama.setEnabled(false);
        cmbjenis.setEnabled(false);
        txtjenis.setEnabled(false);
        txtnet.setEnabled(false);
        txtjual.setEnabled(false);
        txtstok.setEnabled(false);
        txtstok.setEnabled(false);
        
    }
    public void SetEditOn(){
        kd_barang.setEnabled(true);
        txtnama.setEnabled(true);
        cmbjenis.setEnabled(true);
        txtjenis.setEnabled(false);
        txtnet.setEnabled(true);
        txtjual.setEnabled(true);
        txtstok.setEnabled(true);
    }
    
   
    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
         int i = tabelbarang.getSelectedRow();
        
        if(i == -1){
            //tidak ada baris terseleksi
            JOptionPane.showMessageDialog(this, "harap pilih data terlebih dahulu", "error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String kode_barang = (String) model.getValueAt(i, 0);
        
        try{
            Connection c = koneksi.getKoneksi();
            
            String sql = "DELETE FROM tblbarang WHERE KodeBarang = ?";
            
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, kode_barang);
            p.executeUpdate();
            p.close();
            
            JOptionPane.showMessageDialog(null,
                       "Hapus data Berhasil");
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(this,
                        e.getMessage());
                
            }finally{
            loadData();
            kosong();
            SetEditOff();
        
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        String kode_barang = kd_barang.getText();
        String nama = txtnama.getText();
        String jenis = txtjenis.getText();
        String net = txtnet.getText();
        String jual = txtjual.getText();
        String stok = txtstok.getText();
        
        String KJ=cmbjenis.getSelectedItem().toString();
        
        if ("".equals(kode_barang) || "".equals(nama) || 
            "".equals(jenis) || "".equals(net) || "".equals(jual)|| "".equals(stok)|| "".equals(KJ))
        {
            JOptionPane.showMessageDialog(this,
                    "Harap Lengkapi Data",
                    "error", JOptionPane.WARNING_MESSAGE);
        } else {
            
            try{
                Connection c = koneksi.getKoneksi();
                String sql = "INSERT INTO tblbarang VALUES (?,?,?,?,?,?)";
                PreparedStatement p = c.prepareStatement(sql);
                
                p.setString(1, kode_barang);
                p.setString(2, nama);
                p.setString(3, KJ);
                p.setString(4, net);
                p.setString(5, jual);
                p.setString(6, stok);
                
                p.executeUpdate();
                p.close();
                
                JOptionPane.showMessageDialog(null,
                       "Penyimpanan Data Berhasil");
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(this,
                        e.getMessage());
                
            }finally{
            loadData();
            kosong();
            SetEditOff();

        }
        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void txtnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamaActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        // TODO add your handling code here:
        kosong();
        kd_barang.requestFocus();
        btnsave.setEnabled(true);
        btnupdate.setEnabled(false);
        btndelete.setEnabled(false);
        SetEditOn();
        
    }//GEN-LAST:event_btnaddActionPerformed

    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
        // TODO add your handling code here:
        kosong();
        SetEnabledFalse();
        //SetEditOff();
 
    }//GEN-LAST:event_btncancelActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
        int i = tabelbarang.getSelectedRow();
        
        if(i == -1){
            //tidak ada baris terseleksi
            JOptionPane.showMessageDialog(this, "harap pilih data terlebih dahulu", "error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String kode_barang = (String) model.getValueAt(i, 0);
        String nama = txtnama.getText();
        String KJ = cmbjenis.getSelectedItem().toString();
        String net = txtnet.getText();
        String jual = txtjual.getText();
        String stok = txtstok.getText();
        
        try{
            
            Connection c = koneksi.getKoneksi();
            
            String sql = "UPDATE tblbarang SET NamaBarang = ?,KodeJenis = ?, HargaNet = ?, HargaJual = ? , Stok = ? WHERE KodeBarang = ?";
            
            PreparedStatement p = c.prepareStatement(sql);
            
            
                
                p.setString(1, nama);
                p.setString(2, KJ);
                p.setString(3, net);
                p.setString(4, jual);
                p.setString(5, stok);
                p.setString(6, kode_barang);
                
            p.executeUpdate();
                p.close();
                
                JOptionPane.showMessageDialog(null,
                       "Ubah Data Berhasil");
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(this,
                        e.getMessage());
                
            }finally{
            loadData();
            kosong();
            btnsave.setEnabled(false);
            SetEditOff();
        }
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btncloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncloseActionPerformed
        // TODO add your handling code here:
         dispose();
    }//GEN-LAST:event_btncloseActionPerformed

    private void cmbjenisItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbjenisItemStateChanged
        // TODO add your handling code here:
        try{
            
            String sql = "SELECT * FROM tbljenis WHERE KodeJenis='"+cmbjenis.getSelectedItem().toString()+"'";
            
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);
            
            r.absolute(1);
            txtjenis.setText(r.getString("Jenis"));
            
        }catch (SQLException ex) {
            
        }
    }//GEN-LAST:event_cmbjenisItemStateChanged

    private void tabelbarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelbarangMouseClicked
        // TODO add your handling code here:
         int baris = tabelbarang.getSelectedRow();
        
        if (baris == -1){
            // tak ada baris terseleksi
            return;
        }
        
        String kode_barang = tabelbarang.getValueAt(baris, 0).toString();
        kd_barang.setText(kode_barang);
        String nama = tabelbarang.getValueAt(baris, 1).toString();
        txtnama.setText(nama);
        cmbjenis.setSelectedItem(tabelbarang.getValueAt(baris, 2).toString());
        String net = tabelbarang.getValueAt(baris, 3).toString();
        txtnet.setText(net);
        String jual = tabelbarang.getValueAt(baris, 4).toString();
        txtjual.setText(jual);
        String stok = tabelbarang.getValueAt(baris, 5).toString();
        txtstok.setText(stok);
        btnsave.setEnabled(false);
        btnupdate.setEnabled(true);
        btndelete.setEnabled(true);
        SetEditOn();
    }//GEN-LAST:event_tabelbarangMouseClicked

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
            java.util.logging.Logger.getLogger(formbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formbarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btnclose;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnupdate;
    private javax.swing.JComboBox<String> cmbjenis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JTextField kd_barang;
    private javax.swing.JTable tabelbarang;
    private javax.swing.JTextField txtjenis;
    private javax.swing.JTextField txtjual;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtnet;
    private javax.swing.JTextField txtstok;
    // End of variables declaration//GEN-END:variables
}
