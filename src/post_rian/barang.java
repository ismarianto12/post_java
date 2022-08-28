/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post_rian;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Scanner;
import java.awt.*;

/**
 *
 * @author Lenovo
 */
public class barang extends javax.swing.JFrame {

    DefaultTableModel tabModel;
    ResultSet RsSakit = null;

    public barang() {
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        this.setLocation((screenSize.width - frameSize.width) / 2,
                (screenSize.height = screenSize.height) / 20);
        tampilData();
        SetEditOff();
    }

    private void tampilData() {
        try {
            Object[] judul_kolom = {"ID", "Kode Barang", "Nama", "Harga Beli", "Harga Jual"};
            tabModel = new DefaultTableModel(null, judul_kolom);
            TableRs.setModel(tabModel);

            Connection conn = (Connection) koneksi.koneksiDB();
            Statement stt = conn.createStatement();
            tabModel.getDataVector().removeAllElements();

            RsSakit = stt.executeQuery("SELECT\n"
                    + "	*, \n"
                    + "	barang.harga_beli, \n"
                    + "	barang.harga_jual, \n"
                    + "	barang.nama_barang, \n"
                    + "	barang.satuan, \n"
                    + "	barang.created_at, \n"
                    + "	barang.jenis_barang, \n"
                    + "	barang.updated_at\n"
                    + "FROM\n"
                    + "	barang");
            while (RsSakit.next()) {
                Object[] data = {
                    RsSakit.getString("id"),
                    RsSakit.getString("kode"),
                    RsSakit.getString("nama_barang"),
                    RsSakit.getString("harga_beli"),
                    RsSakit.getString("harga_jual"),};
                tabModel.addRow(data);
            }

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        nama_barang.setEnabled(false);
//        jTextNpwp.setEnabled(false);
//        jTextFieldPlafon.setEnabled(false);
        satuan.setEnabled(false);
        kode_barang.setEnabled(false);
        harga_jual.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jLabelNama = new javax.swing.JLabel();
        jLabelDiagnosa = new javax.swing.JLabel();
        jLabelHasil = new javax.swing.JLabel();
        jLabelUmur = new javax.swing.JLabel();
        kode_barang = new javax.swing.JTextField();
        nama_barang = new javax.swing.JTextField();
        harga_jual = new javax.swing.JTextField();
        jLabelDokter = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableRs = new javax.swing.JTable();
        jButtonAdd = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(300, 0), new java.awt.Dimension(300, 0), new java.awt.Dimension(300, 32767));
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Id = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jenis1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        satuan = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistem Informasi Data Entri");
        setBackground(new java.awt.Color(153, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNama.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNama.setText("Kode Barang");
        getContentPane().add(jLabelNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));

        jLabelDiagnosa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelDiagnosa.setText("Nama Barang");
        getContentPane().add(jLabelDiagnosa, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, -1));

        jLabelHasil.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelHasil.setText("Satuan");
        getContentPane().add(jLabelHasil, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, -1));

        jLabelUmur.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelUmur.setText("Harga Jual");
        getContentPane().add(jLabelUmur, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, -1, -1));

        kode_barang.setText(" ");
        kode_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kode_barangActionPerformed(evt);
            }
        });
        getContentPane().add(kode_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 266, -1));
        getContentPane().add(nama_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 266, -1));

        harga_jual.setText(" ");
        getContentPane().add(harga_jual, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 266, -1));

        jLabelDokter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(jLabelDokter, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 240, -1, -1));

        TableRs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Kode Barang", "Nama", "Harga", "Qty"
            }
        ));
        TableRs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableRsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableRs);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 870, 278));

        jButtonAdd.setBackground(new java.awt.Color(51, 0, 255));
        jButtonAdd.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAdd.setText("Add New");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, -1, -1));

        jButtonSave.setText("Simpan");
        jButtonSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSaveMouseClicked(evt);
            }
        });
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 390, -1, -1));

        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 390, -1, -1));

        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 390, -1, -1));
        getContentPane().add(filler2, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 1068, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\dataentry\\src\\rianrs\\backgound.jpg")); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 370, 930, 940));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -10, 250, -1));
        getContentPane().add(filler3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, -1, -1));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/post_rian/icon/circled-left-2.png"))); // NOI18N
        jLabel2.setText("BACK HOME");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 100));

        Id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdActionPerformed(evt);
            }
        });
        getContentPane().add(Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 150, 180, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("ID");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, -1, -1));

        jenis1.setText(" ");
        jenis1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jenis1ActionPerformed(evt);
            }
        });
        getContentPane().add(jenis1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 200, 180, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Jenis Barang");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 200, -1, -1));

        satuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PCS", "BENDLE", "BUAH", "KARUNG", "LUSIN", "KODI", " " }));
        getContentPane().add(satuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 260, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
//manangani proses ketika button di click 

//fungsi untuk tambah data
    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        BersihData();
        kode_barang.requestFocus();
        jenis1.setEnabled(false);
        jButtonSave.setEnabled(true);
        jButtonUpdate.setEnabled(false);
        jButtonDelete.setEnabled(false);
        setEditOn();
// TODO add your handling code here:
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void kode_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kode_barangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kode_barangActionPerformed


    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        // TODO add your handling code here: 
        String NamaBarang = nama_barang.getText();
        String Satuan = satuan.getSelectedItem().toString();
        String KodeBarang = kode_barang.getText();
        String HargaJual = harga_jual.getText();
        String JenisBarang = jenis1.getText();
        String Kode = kode_barang.getText();

//        String Tanggungan = jComboBoxJentang.getSelectedItem().toString();
        java.util.Date tanggal = new java.util.Date();
        java.text.SimpleDateFormat TanggalFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String CreateDate = TanggalFormat.format(tanggal);

        if (NamaBarang.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nama Barang tidak boleh kosong");
        } else if (Satuan.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Satuan pasien tidak boleh kosong");
        } else if (KodeBarang.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Kode barang tidak boleh kosong");

        } else {
            //if handling complete
            try {
                Connection connection = (Connection) koneksi.koneksiDB();
                Statement stt = connection.createStatement();
                stt.executeUpdate("INSERT INTO ujian_visual.barang(kode,nama_barang, harga_jual, satuan,jenis_barang)"
                        + "        VALUES ('" + Kode + "', '" + NamaBarang + "', '" + HargaJual + "','" + Satuan + "','" + JenisBarang + "');");
                tampilData();
                setEditOn();
                BersihData();

                JOptionPane.showMessageDialog(this, "Data berhasil disimpan", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Simpan data gagal\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSaveMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSaveMouseClicked

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        // TODO add your handling code here: 
        String IdRs = Id.getText();
        String NamaBarang = nama_barang.getText();
        String Satuan = satuan.getSelectedItem().toString();
        String KodeBarang = kode_barang.getText();
        String HargaJual = harga_jual.getText();
        String JenisBarang = jenis1.getText();
        String Kode = kode_barang.getText();

//        String Tanggungan = jComboBoxJentang.getSelectedItem().toString();
        java.util.Date tanggal = new java.util.Date();
        java.text.SimpleDateFormat TanggalFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String CreateDate = TanggalFormat.format(tanggal);

        if (NamaBarang.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nama Barang tidak boleh kosong");
        } else if (Satuan.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Satuan pasien tidak boleh kosong");
        } else if (KodeBarang.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Kode barang tidak boleh kosong");

        } else {
            //if handling complete
            try {
                Connection connection = (Connection) koneksi.koneksiDB();
                Statement stt = connection.createStatement();
                stt.executeUpdate("UPDATE ujian_visual.barang(kode,nama_barang, harga_jual, satuan,jenis_barang)"
                        + "        VALUES ('" + Kode + "', '" + NamaBarang + "', '" + HargaJual + "','" + Satuan + "','" + JenisBarang + "');");
                tampilData();
                setEditOn();
                BersihData();

                JOptionPane.showMessageDialog(this, "Data berhasil disimpan", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Simpan data gagal\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void TableRsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableRsMouseClicked
        // TODO add your handling code here:
        setEditOn();
        tblKeForm();
        jButtonSave.setEnabled(false);
        jButtonUpdate.setEnabled(true);
    }//GEN-LAST:event_TableRsMouseClicked

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        String IdRs = Id.getText();
        if (IdRs.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID Kosong Data Gagal Di Hapus.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int des = JOptionPane.showConfirmDialog(null, "Apakah anda yakin menghapus data ini ?", "Your title", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (des == 0) {
                try {
                    Connection connection = (Connection) koneksi.koneksiDB();
                    Statement stt = connection.createStatement();
                    stt.executeUpdate("DELETE from ujian_visual.barang where id ='" + IdRs + "'");
                    tampilData();
                    setEditOn();
                    BersihData();

                    JOptionPane.showMessageDialog(this, "Data berhasil hapus", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Simpan data gagal\n di hapus" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();

        dashboard second = new dashboard();
        second.setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void IdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdActionPerformed

    private void jenis1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jenis1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jenis1ActionPerformed

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
            java.util.logging.Logger.getLogger(barang.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(barang.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(barang.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(barang.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new barang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Id;
    private javax.swing.JTable TableRs;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JTextField harga_jual;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelDiagnosa;
    private javax.swing.JLabel jLabelDokter;
    private javax.swing.JLabel jLabelHasil;
    private javax.swing.JLabel jLabelNama;
    private javax.swing.JLabel jLabelUmur;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jenis1;
    private javax.swing.JTextField kode_barang;
    private javax.swing.JTextField nama_barang;
    private javax.swing.JComboBox<String> satuan;
    // End of variables declaration//GEN-END:variables

//add function list data java 
    //non aktif kan ketika program tidak di eksekusi
    private void SetEditOff() {
        nama_barang.setEnabled(false);

        satuan.setEnabled(false);
        kode_barang.setEnabled(false);
        harga_jual.setEnabled(false);
    }

    private void setEditOn() {
        nama_barang.setEnabled(true);

        satuan.setEnabled(true);
        kode_barang.setEnabled(true);
        harga_jual.setEnabled(true);
    }

    private void tblKeForm() {

//        jumlah.setText(tabModel.getValueAt(TableRs.getSelectedRow(), 0) + "");
//
//        kode_barang.setText(tabModel.getValueAt(TableRs.getSelectedRow(), 1) + "");
//        nama_barang.setText(tabModel.getValueAt(TableRs.getSelectedRow(), 2) + "");
//        satuan.setText(tabModel.getValueAt(TableRs.getSelectedRow(), 3) + "");
//        harga_jual.setText(tabModel.getValueAt(TableRs.getSelectedRow(), 4) + "");
//        jTextNpwp.setText(tabModel.getValueAt(TableRs.getSelectedRow(), 5) + "");
//        jComboBoxJentang.setSelectedItem(tabModel.getValueAt(TableRs.getSelectedRow(), 6) + "");
//        jTextFieldPlafon.setText(tabModel.getValueAt(TableRs.getSelectedRow(), 7) + "");
        jenis1.setEnabled(false);
        jButtonAdd.setEnabled(true);
        jButtonDelete.setEnabled(true);
        jButtonSave.setEnabled(true);
        jButtonUpdate.setEnabled(false);
    }

    private void BersihData() {
        nama_barang.setText("");
//        jTextNpwp.setText("");
//        jTextFieldPlafon.setText("");
        satuan.setSelectedItem("");
        kode_barang.setText("");
        harga_jual.setText("");
    }

}
