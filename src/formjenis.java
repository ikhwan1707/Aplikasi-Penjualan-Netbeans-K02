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
 * @author user
 */
public class formjenis extends javax.swing.JFrame {
    
    private DefaultTableModel model;
    
    /**
     * Creates new form formjenis
     */
    public formjenis() {
        initComponents();
        loadData();
        kosong();
        SetEnabledFalse();

        
        
    }
    
    public void SetEnabledFalse(){
        kd_jenis.setEnabled(false);
        txtjenis.setEnabled(false);
        btnsave.setEnabled(false);
        btnupdate.setEnabled(false);
        btndelete.setEnabled(false);
    }
     
    public void SetEnabledTrue(){
        kd_jenis.setEnabled(true);
        txtjenis.setEnabled(true);
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

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        kd_jenis = new javax.swing.JTextField();
        txtjenis = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabeljenis = new javax.swing.JTable();
        btnadd = new javax.swing.JButton();
        btnsave = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btncancel = new javax.swing.JButton();
        btnclose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(245, 244, 241));

        jPanel1.setBackground(new java.awt.Color(212, 234, 247));

        jLabel1.setFont(new java.awt.Font("Sitka Banner", 1, 18)); // NOI18N
        jLabel1.setText("Entri Data Jenis Barang ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel2.setText("Kode Jenis ");

        jLabel3.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel3.setText("Jenis Barang");

        tabeljenis.setBackground(new java.awt.Color(182, 204, 216));
        tabeljenis.setModel(new javax.swing.table.DefaultTableModel(
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
        tabeljenis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabeljenisMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabeljenis);

        btnadd.setBackground(new java.awt.Color(0, 102, 140));
        btnadd.setForeground(new java.awt.Color(255, 255, 255));
        btnadd.setText("Add New");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

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

        btndelete.setBackground(new java.awt.Color(0, 102, 140));
        btndelete.setForeground(new java.awt.Color(255, 255, 255));
        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        btncancel.setBackground(new java.awt.Color(0, 102, 140));
        btncancel.setForeground(new java.awt.Color(255, 255, 255));
        btncancel.setText("Cancel");
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });

        btnclose.setBackground(new java.awt.Color(0, 102, 140));
        btnclose.setForeground(new java.awt.Color(255, 255, 255));
        btnclose.setText("Close");
        btnclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(33, 33, 33)
                        .addComponent(kd_jenis, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnsave)
                            .addComponent(btnupdate)
                            .addComponent(btndelete)
                            .addComponent(btncancel)
                            .addComponent(btnclose)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnadd)
                            .addComponent(txtjenis, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 19, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel2))
                    .addComponent(kd_jenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel3))
                    .addComponent(txtjenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnadd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnsave)
                        .addGap(7, 7, 7)
                        .addComponent(btnupdate)
                        .addGap(7, 7, 7)
                        .addComponent(btndelete)
                        .addGap(7, 7, 7)
                        .addComponent(btncancel)
                        .addGap(7, 7, 7)
                        .addComponent(btnclose)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
        public void loadData(){
         // membuat model
        model = new DefaultTableModel ();
        
        // menghapus seluruh data
        model.getDataVector().removeAllElements();
        
        // memberi tahu bahwa data telah kosong 
        model.fireTableDataChanged();
        
        tabeljenis.setModel(model);
        model.addColumn("Kode Jenis");
        model.addColumn("Jenis Barang");
        
        
        
        
        try{
        
            
        String sql = "SELECT * FROM tbljenis";
        
        Connection  c = koneksi.getKoneksi();
        Statement s = c.createStatement();
        ResultSet r = s.executeQuery(sql);
        
        while(r.next()){
        // lakukan penelusuran baris
            model.addRow(new Object[]{
                r.getString(1),
                r.getString(2),
            });
        }
        tabeljenis.setModel(model);
        }catch(SQLException e){
            System.out.println("Terjadi Error");
        }
    }
     
   
    public void kosong(){
        kd_jenis.setText(null);
        txtjenis.setText(null);
    }
    
    public void SetEditOff(){
        kd_jenis.setEnabled(false);
        txtjenis.setEnabled(false);
    }
    public void SetEditOn(){
        kd_jenis.setEnabled(true);
        txtjenis.setEnabled(true);
    }

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        // TODO add your handling code here:
        kosong();
        kd_jenis.requestFocus();
        btnsave.setEnabled(true);
        btnupdate.setEnabled(false);
        btndelete.setEnabled(false);
         SetEditOn();
    }//GEN-LAST:event_btnaddActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
        int i = tabeljenis.getSelectedRow();
        
        if(i == -1){
            //tidak ada baris terseleksi
            JOptionPane.showMessageDialog(this, "harap pilih data terlebih dahulu", "error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String kode_jenis = (String) model.getValueAt(i, 0);
        String jenis = txtjenis.getText();
        
        try{
            Connection c = koneksi.getKoneksi();
            String sql = "UPDATE tbljenis SET  Jenis = ? WHERE KodeJenis = ?";
            PreparedStatement p = c.prepareStatement(sql);
            
            p.setString(1, jenis);
            p.setString(2, kode_jenis);
                
            p.executeUpdate();
            p.close();
                
                JOptionPane.showMessageDialog(null,
                       "Ubah Data Berhasil");
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(this,
                        e.getMessage());
                
            }finally{
            loadData();
            btnsave.setEnabled(false);
            kosong();
            SetEditOff();
        }
      
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
        int i = tabeljenis.getSelectedRow();
        
        if(i == -1){
            //tidak ada baris terseleksi
            JOptionPane.showMessageDialog(this, "harap pilih data terlebih dahulu", "error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String kode_jenis = (String) model.getValueAt(i, 0);
        
        try{
            Connection c = koneksi.getKoneksi();
            
            String sql = "DELETE FROM tbljenis WHERE KodeJenis = ?";
            
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, kode_jenis);
            p.executeUpdate();
            p.close();
            
            JOptionPane.showMessageDialog(null,
                       "Hapus Data Berhasil");
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(this,
                        e.getMessage());
                
            }finally{
            loadData();
            kosong();
            SetEditOff();
        }


    }//GEN-LAST:event_btndeleteActionPerformed

    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
        // TODO add your handling code here:
        kosong();
        SetEnabledFalse();
        //SetEditOff();
       
    }//GEN-LAST:event_btncancelActionPerformed

    private void btncloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncloseActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btncloseActionPerformed

    private void tabeljenisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabeljenisMouseClicked
        // TODO add your handling code here:
        int baris = tabeljenis.getSelectedRow();
        
        if (baris == -1){
            // tak ada baris terseleksi
            return;
        }
        
        kd_jenis.setText(model.getValueAt(baris, 0).toString());
        txtjenis.setText(model.getValueAt(baris, 1).toString());
        btnsave.setEnabled(false);
        btnupdate.setEnabled(true);
        btndelete.setEnabled(true);
        SetEditOn();
        
        
    }//GEN-LAST:event_tabeljenisMouseClicked

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        
        
        
        if ("".equals(kd_jenis.getText()) || "".equals(txtjenis.getText())) 
        {
            JOptionPane.showMessageDialog(this,
                    "Harap Lengkapi Data",
                    "error", JOptionPane.WARNING_MESSAGE);
        } else {
            
            try{
                String sql = "INSERT INTO tbljenis VALUES('"+kd_jenis.getText()+"','"+txtjenis.getText()+"')";
              java.sql.Connection conn = (Connection)koneksi.getKoneksi();
              java.sql.PreparedStatement pst=conn.prepareStatement(sql);
              pst.execute();
                JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
 
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }finally{
            loadData();
            kosong();
            SetEditOff();
        }
        }
        
    }//GEN-LAST:event_btnsaveActionPerformed

    
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
            java.util.logging.Logger.getLogger(formjenis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formjenis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formjenis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formjenis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formjenis().setVisible(true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kd_jenis;
    private javax.swing.JTable tabeljenis;
    private javax.swing.JTextField txtjenis;
    // End of variables declaration//GEN-END:variables
}
