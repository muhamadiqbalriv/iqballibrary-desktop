import com.mysql.jdbc.Driver;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MUSASHI NAGASAKI
 */
public class indexBuku extends javax.swing.JFrame {
    Connection koneksi = null;
    ResultSet res = null;
    PreparedStatement pst = null;
    String querySearch = "";
    /**
     * Creates new form index_buku
     */
    public indexBuku() {
        initComponents();
        koneksi = KoneksiDatabase.getKoneksi();
        cek();
        dataBuku();
    }
    
    public void cek(){
        login log = new login();
        String level = log.getRole();
        if(!level.equals("admin")){
            anggota.setVisible(false);
            pegawai.setVisible(false);
        }
    }
    
    private void dataBuku(){
        
        try{
            String bacaData = "SELECT id_buku as 'ID', judul as 'JUDUL', pengarang as 'PENGARANG', gambar as 'GAMBAR' from buku"+querySearch;
            pst = koneksi.prepareStatement(bacaData);
            res = pst.executeQuery();
            if(!res.isBeforeFirst() || querySearch != "" && listBuku.getRowCount() == 0){
                JOptionPane.showMessageDialog(null, "Belum ada data!");
            }

            listBuku.setModel(rs2Table.resultSetToTableModel(res));
            listBuku.setRowHeight(50);
            listBuku.getColumnModel().getColumn(3).setPreferredWidth(150);
            jumlahBaris.setText(Integer.toString(listBuku.getRowCount()));
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void comboBoxs(){
        
        try{
            String bacaData = "SELECT tahun from buku GROUP by tahun";
            pst = koneksi.prepareStatement(bacaData);
            res = pst.executeQuery();
            if(!res.isBeforeFirst()){
                JOptionPane.showMessageDialog(null, "Belum ada data!");
            }
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
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

        dateChooserDialog1 = new datechooser.beans.DateChooserDialog();
        dateChooserDialog2 = new datechooser.beans.DateChooserDialog();
        delete = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jumlahBaris = new javax.swing.JLabel();
        detail = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listBuku = new javax.swing.JTable();
        searchValue = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        insert = new javax.swing.JLabel();
        resetSearch = new javax.swing.JButton();
        update = new javax.swing.JLabel();
        kunjungan = new javax.swing.JLabel();
        buku = new javax.swing.JLabel();
        anggota = new javax.swing.JLabel();
        pegawai = new javax.swing.JLabel();
        peminjaman = new javax.swing.JLabel();
        home = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(720, 470));
        setSize(new java.awt.Dimension(710, 430));
        getContentPane().setLayout(null);

        delete.setBackground(new java.awt.Color(153, 0, 0));
        delete.setFont(new java.awt.Font("High Jakarta", 0, 16)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("file:/E:/Sekolah/STMIK SUMEDANG/Semester 3/PBO/Font-Awesome-SVG-PNG-master/Font-Awesome-SVG-PNG-master/white/png/16/trash.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        delete.setOpaque(true);
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
        });
        delete.setOpaque(true);
        getContentPane().add(delete);
        delete.setBounds(650, 350, 16, 16);

        jLabel1.setText("Jumlah Data :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(170, 330, 110, 14);

        jumlahBaris.setText("0");
        getContentPane().add(jumlahBaris);
        jumlahBaris.setBounds(260, 330, 140, 14);

        detail.setBackground(new java.awt.Color(153, 51, 0));
        detail.setFont(new java.awt.Font("High Jakarta", 0, 16)); // NOI18N
        detail.setForeground(new java.awt.Color(255, 255, 255));
        detail.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("file:/E:/Sekolah/STMIK SUMEDANG/Semester 3/PBO/Font-Awesome-SVG-PNG-master/Font-Awesome-SVG-PNG-master/white/png/16/eye.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        detail.setText("detail");
        detail.setOpaque(true);
        detail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                detailMouseClicked(evt);
            }
        });
        update.setOpaque(true);
        getContentPane().add(detail);
        detail.setBounds(330, 350, 70, 18);

        listBuku.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(listBuku);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(170, 110, 500, 210);
        getContentPane().add(searchValue);
        searchValue.setBounds(380, 80, 184, 25);

        search.setIcon(new javax.swing.ImageIcon("E:\\Sekolah\\STMIK SUMEDANG\\Semester 3\\PBO\\Font-Awesome-SVG-PNG-master\\Font-Awesome-SVG-PNG-master\\black\\png\\16\\search.png")); // NOI18N
        search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchMouseClicked(evt);
            }
        });
        getContentPane().add(search);
        search.setBounds(570, 80, 49, 25);

        insert.setBackground(new java.awt.Color(0, 51, 51));
        insert.setFont(new java.awt.Font("High Jakarta", 0, 16)); // NOI18N
        insert.setForeground(new java.awt.Color(255, 255, 255));
        insert.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("file:/E:/Sekolah/STMIK SUMEDANG/Semester 3/PBO/Font-Awesome-SVG-PNG-master/Font-Awesome-SVG-PNG-master/white/png/16/plus-square.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        insert.setText("TAMBAh");
        insert.setOpaque(true);
        insert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                insertMouseClicked(evt);
            }
        });
        insert.setOpaque(true);
        getContentPane().add(insert);
        insert.setBounds(170, 350, 70, 18);

        resetSearch.setIcon(new javax.swing.ImageIcon("E:\\Sekolah\\STMIK SUMEDANG\\Semester 3\\PBO\\Font-Awesome-SVG-PNG-master\\Font-Awesome-SVG-PNG-master\\black\\png\\16\\refresh.png")); // NOI18N
        resetSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetSearchMouseClicked(evt);
            }
        });
        getContentPane().add(resetSearch);
        resetSearch.setBounds(620, 80, 49, 25);

        update.setBackground(new java.awt.Color(0, 51, 0));
        update.setFont(new java.awt.Font("High Jakarta", 0, 16)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("file:/E:/Sekolah/STMIK SUMEDANG/Semester 3/PBO/Font-Awesome-SVG-PNG-master/Font-Awesome-SVG-PNG-master/white/png/16/pencil-square.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        update.setText("UBAH ");
        update.setOpaque(true);
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
        });
        update.setOpaque(true);
        getContentPane().add(update);
        update.setBounds(250, 350, 70, 18);

        kunjungan.setFont(new java.awt.Font("High Jakarta", 0, 16)); // NOI18N
        kunjungan.setForeground(new java.awt.Color(255, 255, 255));
        kunjungan.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("file:/E:/Sekolah/STMIK SUMEDANG/Semester 3/PBO/Font-Awesome-SVG-PNG-master/Font-Awesome-SVG-PNG-master/white/png/16/send.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        kunjungan.setText("kunjungan");
        kunjungan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kunjunganMouseClicked(evt);
            }
        });
        getContentPane().add(kunjungan);
        kunjungan.setBounds(10, 270, 120, 18);

        buku.setFont(new java.awt.Font("High Jakarta", 0, 16)); // NOI18N
        buku.setForeground(new java.awt.Color(255, 255, 255));
        buku.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("file:/E:/Sekolah/STMIK SUMEDANG/Semester 3/PBO/Font-Awesome-SVG-PNG-master/Font-Awesome-SVG-PNG-master/white/png/16/book.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        buku.setText("BUKU");
        buku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bukuMouseClicked(evt);
            }
        });
        getContentPane().add(buku);
        buku.setBounds(10, 150, 120, 18);

        anggota.setFont(new java.awt.Font("High Jakarta", 0, 16)); // NOI18N
        anggota.setForeground(new java.awt.Color(255, 255, 255));
        anggota.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("file:/E:/Sekolah/STMIK SUMEDANG/Semester 3/PBO/Font-Awesome-SVG-PNG-master/Font-Awesome-SVG-PNG-master/white/png/16/user.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        anggota.setText("ANGGOTA");
        anggota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                anggotaMouseClicked(evt);
            }
        });
        getContentPane().add(anggota);
        anggota.setBounds(10, 180, 120, 18);

        pegawai.setFont(new java.awt.Font("High Jakarta", 0, 16)); // NOI18N
        pegawai.setForeground(new java.awt.Color(255, 255, 255));
        pegawai.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("file:/E:/Sekolah/STMIK SUMEDANG/Semester 3/PBO/Font-Awesome-SVG-PNG-master/Font-Awesome-SVG-PNG-master/white/png/16/user-secret.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        pegawai.setText("pegawai");
        pegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pegawaiMouseClicked(evt);
            }
        });
        getContentPane().add(pegawai);
        pegawai.setBounds(10, 210, 120, 18);

        peminjaman.setFont(new java.awt.Font("High Jakarta", 0, 16)); // NOI18N
        peminjaman.setForeground(new java.awt.Color(255, 255, 255));
        peminjaman.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("file:/E:/Sekolah/STMIK SUMEDANG/Semester 3/PBO/Font-Awesome-SVG-PNG-master/Font-Awesome-SVG-PNG-master/white/png/16/inbox.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        peminjaman.setText("peminjaman");
        peminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                peminjamanMouseClicked(evt);
            }
        });
        getContentPane().add(peminjaman);
        peminjaman.setBounds(10, 240, 120, 18);

        home.setFont(new java.awt.Font("High Jakarta", 0, 16)); // NOI18N
        home.setForeground(new java.awt.Color(255, 255, 255));
        home.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("file:/E:/Sekolah/STMIK SUMEDANG/Semester 3/PBO/Font-Awesome-SVG-PNG-master/Font-Awesome-SVG-PNG-master/white/png/16/home.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        home.setText("Home");
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
        });
        getContentPane().add(home);
        home.setBounds(10, 120, 120, 18);

        logout.setFont(new java.awt.Font("High Jakarta", 0, 16)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setIcon(new javax.swing.ImageIcon("E:\\Sekolah\\STMIK SUMEDANG\\Semester 3\\PBO\\Font-Awesome-SVG-PNG-master\\Font-Awesome-SVG-PNG-master\\white\\png\\16\\sign-out.png")); // NOI18N
        logout.setText("logout");
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });
        getContentPane().add(logout);
        logout.setBounds(30, 390, 70, 18);

        jLabel3.setIcon(new javax.swing.ImageIcon("E:\\Sekolah\\STMIK SUMEDANG\\Semester 3\\PBO\\DesignApps\\buku.jpg")); // NOI18N
        jLabel3.setMaximumSize(new java.awt.Dimension(7100, 4230));
        jLabel3.setMinimumSize(new java.awt.Dimension(710, 430));
        jLabel3.setPreferredSize(new java.awt.Dimension(710, 430));
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 710, 430);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Pristina", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon("E:\\Sekolah\\STMIK SUMEDANG\\Semester 3\\PBO\\Font-Awesome-SVG-PNG-master\\Font-Awesome-SVG-PNG-master\\white\\png\\16\\copyright.png")); // NOI18N
        jLabel2.setText("muhamadiqbalriv");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(jLabel2)
                .addContainerGap(291, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 323, 626, 16);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void insertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertMouseClicked
        // TODO add your handling code here:
        insertBuku iB = new insertBuku();
        iB.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_insertMouseClicked

    private void searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseClicked
        // TODO add your handling code here:
        String searchValues = searchValue.getText();
        if(searchValues.isEmpty()){
            JOptionPane.showMessageDialog(null, "Masukan kata kunci terlebih dahulu!");
        }
        querySearch = " WHERE judul LIKE '%"+searchValues+"%' OR pengarang LIKE '%"+searchValues+"%'";
        
        dataBuku();
    }//GEN-LAST:event_searchMouseClicked

    private void resetSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetSearchMouseClicked
        // TODO add your handling code here:
        if(searchValue.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Anda belum melakukan filter !");
        }else{
            searchValue.setText(null);
            querySearch = "";
            dataBuku();
        }
    }//GEN-LAST:event_resetSearchMouseClicked

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        // TODO add your handling code here:
        if(listBuku.getSelectionModel().isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "Pilih salah satu item yang ada di tabel !");
        }else{
            String queryDelete = "DELETE FROM buku WHERE id_buku=?";
            int tableData = listBuku.getSelectedRow();
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog (null, "Apakah anda yakin akan menghapus data ini?","Warning",dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) {
                try {
                    pst = koneksi.prepareStatement(queryDelete);
                    pst.setString(1, listBuku.getValueAt(tableData, 0).toString());
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus !");
                }catch (SQLException | HeadlessException e){
                    JOptionPane.showMessageDialog(null, e);
                }
            }
            dataBuku();
        }
    }//GEN-LAST:event_deleteMouseClicked

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
        // TODO add your handling code here:
        if(listBuku.getSelectionModel().isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "Pilih salah satu item yang ada di tabel !");
        }else{
            updateBuku uB = new updateBuku();
            //        uB.indexBuku = this;
            uB.setVisible(true);
            this.setVisible(false);

            int tableData = listBuku.getSelectedRow();
            uB.ambilIdBuku = (listBuku.getValueAt(tableData, 0).toString());

            uB.dataTampil();
        }
    }//GEN-LAST:event_updateMouseClicked

    private void kunjunganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kunjunganMouseClicked
        // TODO add your handling code here:
        indexKunjungan db = new indexKunjungan();
        db.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_kunjunganMouseClicked

    private void detailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_detailMouseClicked
        // TODO add your handling code here:
        if(listBuku.getSelectionModel().isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "Pilih salah satu item yang ada di tabel !");
        }else{
                detailBuku uP = new detailBuku();
                uP.setVisible(true);
                this.setVisible(false);
                
                int tableData = listBuku.getSelectedRow();
                uP.ambilId = (listBuku.getValueAt(tableData, 0).toString());
                
                uP.detailTampil();
        }
    }//GEN-LAST:event_detailMouseClicked

    private void bukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bukuMouseClicked
        indexBuku db = new indexBuku();
        db.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bukuMouseClicked

    private void anggotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_anggotaMouseClicked
        indexAnggota db = new indexAnggota();
        db.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_anggotaMouseClicked

    private void pegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pegawaiMouseClicked
        indexPegawai db = new indexPegawai();
        db.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_pegawaiMouseClicked

    private void peminjamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_peminjamanMouseClicked
        indexPeminjaman db = new indexPeminjaman();
        db.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_peminjamanMouseClicked

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        dashboard db = new dashboard();
        db.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_homeMouseClicked

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        login db = new login();
        db.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_logoutMouseClicked

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
            java.util.logging.Logger.getLogger(indexBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(indexBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(indexBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(indexBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new indexBuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anggota;
    private javax.swing.JLabel buku;
    private datechooser.beans.DateChooserDialog dateChooserDialog1;
    private datechooser.beans.DateChooserDialog dateChooserDialog2;
    private javax.swing.JLabel delete;
    private javax.swing.JLabel detail;
    private javax.swing.JLabel home;
    private javax.swing.JLabel insert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jumlahBaris;
    private javax.swing.JLabel kunjungan;
    private javax.swing.JTable listBuku;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel pegawai;
    private javax.swing.JLabel peminjaman;
    private javax.swing.JButton resetSearch;
    private javax.swing.JButton search;
    private javax.swing.JTextField searchValue;
    private javax.swing.JLabel update;
    // End of variables declaration//GEN-END:variables
}
