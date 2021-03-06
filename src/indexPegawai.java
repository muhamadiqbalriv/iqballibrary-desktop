import com.mysql.jdbc.Driver;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
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
public class indexPegawai extends javax.swing.JFrame {
    Connection koneksi = null;
    ResultSet res = null;
    PreparedStatement pst = null;
    String querySearch = "";
    /**
     * Creates new form index_Anggota
     */
    public indexPegawai() {
        initComponents();
        koneksi = KoneksiDatabase.getKoneksi();
        cek();
        dataPegawai();
    }
    
    public void cek(){
        login log = new login();
        String level = log.getRole();
        if(!level.equals("admin")){
            anggota.setVisible(false);
            pegawai.setVisible(false);
        }
    }
   
    
    private void dataPegawai(){
        
        try{
            String bacaData = "SELECT id_pegawai as 'Id', no_identitas as 'No Identitas', jenis_identitas as 'Jenis Identitas', gambar as 'Gambar', nama as 'Nama' from pegawai"+querySearch;
            pst = koneksi.prepareStatement(bacaData);
            res = pst.executeQuery();
            if(!res.isBeforeFirst() && querySearch != "" && listPegawai.getRowCount() == 0){
                JOptionPane.showMessageDialog(null, "Belum ada data!");
            }
            listPegawai.setModel(rs2Table.resultSetToTableModel(res));
            listPegawai.setRowHeight(50);
            listPegawai.getColumnModel().getColumn(3).setPreferredWidth(150);
            jumlahBaris.setText(Integer.toString(listPegawai.getRowCount()));
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
        jScrollPane1 = new javax.swing.JScrollPane();
        listPegawai = new javax.swing.JTable();
        searchValue = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        insert = new javax.swing.JLabel();
        resetSearch = new javax.swing.JButton();
        update = new javax.swing.JLabel();
        delete = new javax.swing.JLabel();
        filterJK = new javax.swing.JComboBox<>();
        filterJI = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jumlahBaris = new javax.swing.JLabel();
        detail = new javax.swing.JLabel();
        home = new javax.swing.JLabel();
        buku = new javax.swing.JLabel();
        anggota = new javax.swing.JLabel();
        pegawai = new javax.swing.JLabel();
        peminjaman = new javax.swing.JLabel();
        kunjungan = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(720, 470));
        getContentPane().setLayout(null);

        listPegawai.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(listPegawai);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(170, 110, 500, 210);

        searchValue.setToolTipText("Seach by no identitas");
        getContentPane().add(searchValue);
        searchValue.setBounds(480, 80, 98, 20);

        search.setIcon(new javax.swing.ImageIcon("E:\\Sekolah\\STMIK SUMEDANG\\Semester 3\\PBO\\Font-Awesome-SVG-PNG-master\\Font-Awesome-SVG-PNG-master\\black\\png\\16\\search.png")); // NOI18N
        search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchMouseClicked(evt);
            }
        });
        getContentPane().add(search);
        search.setBounds(590, 80, 37, 25);

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
        insert.setText("TAMBAH");
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
        resetSearch.setBounds(630, 80, 37, 25);

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
        update.setText("ubah");
        update.setOpaque(true);
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
        });
        update.setOpaque(true);
        getContentPane().add(update);
        update.setBounds(250, 350, 70, 18);

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
        delete.setBounds(650, 350, 16, 20);

        filterJK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Perempuan", "Laki-laki" }));
        filterJK.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterJKItemStateChanged(evt);
            }
        });
        filterJK.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                filterJKPropertyChange(evt);
            }
        });
        getContentPane().add(filterJK);
        filterJK.setBounds(380, 80, 93, 20);

        filterJI.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "NIK", "NISN", "NIM" }));
        filterJI.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterJIItemStateChanged(evt);
            }
        });
        getContentPane().add(filterJI);
        filterJI.setBounds(280, 80, 89, 20);

        jLabel1.setText("Jumlah data :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(170, 330, 220, 14);

        jumlahBaris.setText("0");
        getContentPane().add(jumlahBaris);
        jumlahBaris.setBounds(240, 330, 160, 14);

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

        user.setBackground(new java.awt.Color(0, 102, 102));
        user.setFont(new java.awt.Font("High Jakarta", 0, 16)); // NOI18N
        user.setForeground(new java.awt.Color(255, 255, 255));
        user.setIcon(new javax.swing.ImageIcon("E:\\Sekolah\\STMIK SUMEDANG\\Semester 3\\PBO\\Font-Awesome-SVG-PNG-master\\Font-Awesome-SVG-PNG-master\\white\\png\\16\\user-plus.png")); // NOI18N
        user.setText("USER");
        user.setOpaque(true);
        user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userMouseClicked(evt);
            }
        });
        getContentPane().add(user);
        user.setBounds(410, 350, 80, 20);

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

        jLabel3.setIcon(new javax.swing.ImageIcon("E:\\Sekolah\\STMIK SUMEDANG\\Semester 3\\PBO\\DesignApps\\pegawai.jpg")); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 710, 430);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void insertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertMouseClicked
        // TODO add your handling code here:
        insertPegawai iP = new insertPegawai();
        iP.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_insertMouseClicked

    private void searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseClicked
        // TODO add your handling code here:
        String searchValues = searchValue.getText();
        if(searchValues.isEmpty()){
            JOptionPane.showMessageDialog(null, "Masukan kata kunci terlebih dahulu!");
        }
        querySearch = " WHERE no_identitas LIKE '%"+searchValues+"%' OR alamat LIKE '%"+searchValues+"%' OR nama LIKE '%"+searchValues+"%'";
        
        dataPegawai();
    }//GEN-LAST:event_searchMouseClicked

    private void resetSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetSearchMouseClicked
        // TODO add your handling code here:
        if(!searchValue.getText().isEmpty() || filterJI.getSelectedItem().toString() != " " || filterJK.getSelectedItem().toString() != " "){
            searchValue.setText(null);
            filterJI.setSelectedItem(" ");
            filterJK.setSelectedItem(" ");
            querySearch = "";
            
            dataPegawai();
        }else{
            JOptionPane.showMessageDialog(null, "Anda belum melakukan filter !");
        }
    }//GEN-LAST:event_resetSearchMouseClicked

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        // TODO add your handling code here:
        if(listPegawai.getSelectionModel().isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "Pilih salah satu item yang ada di tabel !");
        }else{
            String queryDelete = "DELETE FROM pegawai WHERE id_pegawai=?";
            int tableData = listPegawai.getSelectedRow();
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog (null, "Apakah anda yakin akan menghapus data ini?","Warning",dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) {
                try {
                    pst = koneksi.prepareStatement(queryDelete);
                    pst.setString(1, listPegawai.getValueAt(tableData, 0).toString());
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus !");
                }catch (SQLException | HeadlessException e){
                    JOptionPane.showMessageDialog(null, e);
                }
            }
            dataPegawai();
        }
    }//GEN-LAST:event_deleteMouseClicked

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
        // TODO add your handling code here:
        if(listPegawai.getSelectionModel().isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "Pilih salah satu item yang ada di tabel !");
        }else{
            updatePegawai uP = new updatePegawai();
            //        uB.indexAnggota = this;
            uP.setVisible(true);
            this.setVisible(false);

            int tableData = listPegawai.getSelectedRow();
            uP.ambilId = (listPegawai.getValueAt(tableData, 0).toString());
            
            uP.dataTampil();
        }
    }//GEN-LAST:event_updateMouseClicked

    private void filterJKItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterJKItemStateChanged
        String searchValues = filterJK.getSelectedItem().toString();
        if(searchValues == " "){
            querySearch = "";
        }else{
            querySearch = " WHERE jenis_kelamin ='"+searchValues+"'";
        }
        
        dataPegawai();
    }//GEN-LAST:event_filterJKItemStateChanged

    private void filterJKPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_filterJKPropertyChange

    }//GEN-LAST:event_filterJKPropertyChange

    private void filterJIItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterJIItemStateChanged
        // TODO add your handling code here:
        String searchValues = filterJI.getSelectedItem().toString();
        if(searchValues == " "){
            querySearch = "";
        }else{
            querySearch = " WHERE jenis_identitas ='"+searchValues+"'";
        }
        
        dataPegawai();
    }//GEN-LAST:event_filterJIItemStateChanged

    private void detailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_detailMouseClicked
        if(listPegawai.getSelectionModel().isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "Pilih salah satu item yang ada di tabel !");
        }else{
                detailPegawai uP = new detailPegawai();
                uP.setVisible(true);
                this.setVisible(false);
                
                int tableData = listPegawai.getSelectedRow();
                uP.ambilId = (listPegawai.getValueAt(tableData, 0).toString());
                
                uP.detailTampil();
        }
    }//GEN-LAST:event_detailMouseClicked

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

    private void userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMouseClicked
        if(listPegawai.getSelectionModel().isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "Pilih salah satu item yang ada di tabel !");
        }else{
                insertUser uP = new insertUser();
                
                int tableData = listPegawai.getSelectedRow();
                uP.ambilId = (listPegawai.getValueAt(tableData, 0).toString());
                
        try{
            String bacaData = "SELECT * FROM pegawai WHERE id_pegawai="+uP.ambilId;
            pst = koneksi.prepareStatement(bacaData);
            res = pst.executeQuery();
            if(res.next()){
                if(res.getString("username") != null || res.getString("password") != null){
                    JOptionPane.showMessageDialog(null, "Pegawai ini sudah mempunyai akun");
                }else{
                uP.setVisible(true);
                this.setVisible(false);
                }
            }
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }    
                
        }
    }//GEN-LAST:event_userMouseClicked

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
            java.util.logging.Logger.getLogger(indexAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(indexAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(indexAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(indexAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new indexAnggota().setVisible(true);
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
    private javax.swing.JComboBox<String> filterJI;
    private javax.swing.JComboBox<String> filterJK;
    private javax.swing.JLabel home;
    private javax.swing.JLabel insert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jumlahBaris;
    private javax.swing.JLabel kunjungan;
    private javax.swing.JTable listPegawai;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel pegawai;
    private javax.swing.JLabel peminjaman;
    private javax.swing.JButton resetSearch;
    private javax.swing.JButton search;
    private javax.swing.JTextField searchValue;
    private javax.swing.JLabel update;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
