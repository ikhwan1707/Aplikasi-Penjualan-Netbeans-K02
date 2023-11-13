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

    /**
     * Creates new form barangmasuk
     */
    public barangmasuk() {
        initComponents();
        TampilComboPetugas();
        TampilComboBarang();
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
        jLabel1 = new javax.swing.JLabel();
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

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Barang Masuk");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        jLabel2.setText("Tanggal Barang Masuk ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 43, -1, -1));

        jLabel3.setText("No.Nota");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 71, -1, -1));

        jLabel4.setText("ID Petugas ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 100, -1, -1));

        jLabel5.setText("Nama Petugas");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 128, -1, -1));

        jLabel6.setText("ID Distributor");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 153, -1, -1));

        jLabel7.setText("Nama Distributor");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 181, -1, -1));

        jLabel8.setText("Kota Asal");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 209, -1, -1));
        getContentPane().add(txttglbrng, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 40, 221, -1));
        getContentPane().add(txtnota, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 68, 89, -1));

        btncaridata.setText("Cari Data");
        getContentPane().add(btncaridata, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 68, 120, -1));

        combopetugas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Petugas" }));
        combopetugas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combopetugasItemStateChanged(evt);
            }
        });
        getContentPane().add(combopetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 97, 221, -1));
        getContentPane().add(txtnamapetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 125, 399, -1));

        combodistributor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Distributor" }));
        getContentPane().add(combodistributor, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 153, 221, -1));
        getContentPane().add(txtnamadistributor, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 181, 399, -1));
        getContentPane().add(txtkota, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 209, 399, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detail Barang Masuk"));
        jPanel1.setName("Detail Barang Masuk"); // NOI18N

        jLabel9.setText("Kode Barang");

        jLabel10.setText("Nama Barang");

        jLabel11.setText("Harga Jual");

        combokodebarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Data Barang" }));
        combokodebarang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combokodebarangItemStateChanged(evt);
            }
        });

        jLabel12.setText("Rp");

        jLabel13.setText("Stok");

        jLabel14.setText("Jumlah");

        jLabel15.setText("Sub Total Rp");

        btnitem.setText("Add Item");

        btnhitung.setText("Hitung");

        txtsubtotal.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(combokodebarang, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnamabarang, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txthargajual, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)))))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnitem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtstok)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnhitung))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtsubtotal)))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnitem)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 249, 528, 150));

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
        jScrollPane1.setViewportView(tabelbarangmasuk);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 520, 180));

        btnnew.setText("Add New");
        getContentPane().add(btnnew, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 100, -1));

        btnsave.setText("Save Transaction");
        getContentPane().add(btnsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 600, 150, -1));

        btnclose.setText("Close");
        getContentPane().add(btnclose, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 600, -1, -1));

        jLabel16.setText("Total  Rp");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 600, -1, -1));

        txttotal.setText("0");
        txttotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalActionPerformed(evt);
            }
        });
        getContentPane().add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 600, 120, -1));

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
    private void txttotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalActionPerformed

    private void combokodebarangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combokodebarangItemStateChanged
        // TODO add your handling code here:
        try {
            Connection c = koneksi.getKoneksi();
            String sql = "SELECT * FROM tblbarang where KodeBarang='"+ combokodebarang.getSelectedItem().toString()+"'";
            PreparedStatement p = c.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
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
            String sql = "SELECT * FROM tblpetugas where idpetugas='"+ combopetugas.getSelectedItem().toString()+"'";
            PreparedStatement p = c.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            rs.absolute(1);
            txtnamapetugas.setText(rs.getString("namapetugas"));
            } catch (SQLException ex) {
        }
    }//GEN-LAST:event_combopetugasItemStateChanged

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