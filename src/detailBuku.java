
import java.awt.HeadlessException;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MUSASHI NAGASAKI
 */
public class detailBuku extends javax.swing.JFrame {
    Connection koneksi = null;
    ResultSet res = null;
    PreparedStatement pst = null;
    /**
     * Creates new form insertBuku
     */
    public detailBuku() {
        initComponents();
        koneksi = KoneksiDatabase.getKoneksi();
        cek();
    }
    
    public void cek(){
        login log = new login();
        String level = log.getRole();
        if(!level.equals("admin")){
            anggota.setVisible(false);
            pegawai.setVisible(false);
        }
    }
         
    ImageIcon ResizeImage(String ImagePath, byte[] pic)
    {
        ImageIcon MyImage = null;
        if(ImagePath != null)
        {
           MyImage = new ImageIcon(ImagePath);
        }else
        {
            MyImage = new ImageIcon(pic);
        }
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(gambar.getWidth(), gambar.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
    
    String ambilId;
        public String ambilId(){
            return ambilId;
        }
    
    public void detailTampil(){
        try{
            String bacaData = "SELECT * from buku WHERE id_buku ="+ambilId;
            pst = koneksi.prepareStatement(bacaData);
            res = pst.executeQuery();
            if(res.next()){
                juduls.setText(res.getString("judul"));
                pengarangs.setText(res.getString("pengarang"));
                penerbits.setText(res.getString("penerbit"));
                tahuns.setText(res.getString("tahun"));
                jenis_bukus.setText(res.getString("jenis_buku"));
                lokasi_raks.setText(res.getString("lokasi_rak"));
//                ids.setText(res.getString("id_buku"));
                byte[] Passimg = res.getBytes("gambar");
                gambar.setIcon(ResizeImage(null, res.getBytes("gambar")));
                statuss.setText(res.getString("status"));
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jenis_kelamins = new javax.swing.ButtonGroup();
        cancel = new javax.swing.JButton();
        gambar = new javax.swing.JLabel();
        juduls = new javax.swing.JLabel();
        pengarangs = new javax.swing.JLabel();
        penerbits = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tahuns = new javax.swing.JLabel();
        jenis_bukus = new javax.swing.JLabel();
        lokasi_raks = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        home = new javax.swing.JLabel();
        buku = new javax.swing.JLabel();
        anggota = new javax.swing.JLabel();
        pegawai = new javax.swing.JLabel();
        peminjaman = new javax.swing.JLabel();
        kunjungan = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        statuss = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(720, 470));
        getContentPane().setLayout(null);

        cancel.setBackground(new java.awt.Color(102, 0, 0));
        cancel.setForeground(new java.awt.Color(255, 255, 255));
        cancel.setText("Kembali");
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelMouseClicked(evt);
            }
        });
        getContentPane().add(cancel);
        cancel.setBounds(517, 348, 150, 23);
        getContentPane().add(gambar);
        gambar.setBounds(167, 88, 118, 140);

        juduls.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        juduls.setText("jLabel12");
        getContentPane().add(juduls);
        juduls.setBounds(307, 88, 250, 29);

        pengarangs.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pengarangs.setText("jLabel2");
        getContentPane().add(pengarangs);
        pengarangs.setBounds(307, 128, 190, 22);

        penerbits.setText("jLabel2");
        getContentPane().add(penerbits);
        penerbits.setBounds(357, 158, 150, 14);

        jLabel2.setText("|");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(347, 158, 4, 14);

        tahuns.setText("jLabel3");
        getContentPane().add(tahuns);
        tahuns.setBounds(307, 158, 34, 14);

        jenis_bukus.setText("jLabel3");
        getContentPane().add(jenis_bukus);
        jenis_bukus.setBounds(307, 208, 240, 14);

        lokasi_raks.setText("jLabel3");
        getContentPane().add(lokasi_raks);
        lokasi_raks.setBounds(597, 208, 70, 14);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Jenis:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(307, 188, 180, 14);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Lokasi RAK:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(597, 188, 65, 14);

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
        home.setBounds(7, 118, 120, 18);

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
        buku.setBounds(7, 148, 120, 18);

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
        anggota.setBounds(7, 178, 120, 18);

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
        pegawai.setBounds(7, 208, 120, 18);

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
        peminjaman.setBounds(7, 238, 120, 18);

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
        kunjungan.setBounds(7, 268, 120, 18);

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
        logout.setBounds(27, 388, 70, 18);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Status :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(177, 248, 60, 14);
        getContentPane().add(statuss);
        statuss.setBounds(177, 268, 220, 20);

        jLabel5.setIcon(new javax.swing.ImageIcon("E:\\Sekolah\\STMIK SUMEDANG\\Semester 3\\PBO\\DesignApps\\buku.jpg")); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 707, 438);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
        // TODO add your handling code here:
        indexBuku iP = new indexBuku();
        iP.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelMouseClicked

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        dashboard db = new dashboard();
        db.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_homeMouseClicked

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

    private void kunjunganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kunjunganMouseClicked
        // TODO add your handling code here:
        indexKunjungan db = new indexKunjungan();
        db.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_kunjunganMouseClicked

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
            java.util.logging.Logger.getLogger(insertBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(insertBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(insertBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(insertBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new insertPeminjaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anggota;
    private javax.swing.JLabel buku;
    private javax.swing.JButton cancel;
    private datechooser.beans.DateChooserDialog dateChooserDialog1;
    private javax.swing.JLabel gambar;
    private javax.swing.JLabel home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jenis_bukus;
    private javax.swing.ButtonGroup jenis_kelamins;
    private javax.swing.JLabel juduls;
    private javax.swing.JLabel kunjungan;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel lokasi_raks;
    private javax.swing.JLabel pegawai;
    private javax.swing.JLabel peminjaman;
    private javax.swing.JLabel penerbits;
    private javax.swing.JLabel pengarangs;
    private javax.swing.JLabel statuss;
    private javax.swing.JLabel tahuns;
    // End of variables declaration//GEN-END:variables
}