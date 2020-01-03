
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MUSASHI NAGASAKI
 */
public class rs2Table {

public static TableModel resultSetToTableModel(ResultSet rs) throws IOException {
    try {
        ResultSetMetaData metaData = rs.getMetaData();
        int numberOfColumns = metaData.getColumnCount();
        Vector<String> columnNames = new Vector<String>();

        // Get the column names
        for (int column = 0; column < numberOfColumns; column++) {
            columnNames.addElement(metaData.getColumnLabel(column + 1));
        }

        // Get all rows.
        Vector<Vector<Object>> rows = new Vector<Vector<Object>>();

        while (rs.next()) {
            Vector<Object> newRow = new Vector<Object>();

                    for (int i = 1; i <= numberOfColumns; i++) {
                        if (i == 4) {  // ... whatever column is your image column
                            Blob blob = rs.getBlob("gambar");
                            int blobLength = (int) blob.length();  

                            byte[] bytes = blob.getBytes(1, blobLength);
                            blob.free();
                            BufferedImage img = ImageIO.read(new ByteArrayInputStream(bytes));
                            ImageIcon icon = new ImageIcon(img.getScaledInstance(40, 50, Image.SCALE_SMOOTH));  
                            newRow.addElement(icon);  
                        } else {
                            newRow.addElement(rs.getObject(i));
                        }
                    }
                    rows.addElement(newRow);
                }

        return new DefaultTableModel(rows, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //return all cells false
                return false;
            }
            @Override
                public Class<?> getColumnClass(int column) {
                    switch(column) {
                        case 3: return ImageIcon.class;
                        default: return Object.class;
                    }
                }
        };
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null,e);
        return null;
    }
}}
