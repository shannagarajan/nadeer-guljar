/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * bill.java
 *
 * Created on 7 Jul, 2013, 4:23:49 PM
 */
package project1;

import java.text.SimpleDateFormat;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.sql.*;
import java.text.MessageFormat;
import java.util.StringTokenizer;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sony
 */
public class ViewBill extends JInternalFrame implements Printable {

    double total = 0, sum;

    /** Creates new form bill */
    public ViewBill() {
        initComponents();


    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bil = new JTextField();
        jLabel5 = new JLabel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jLabel6 = new JLabel();
        bn = new JTextField();
        jLabel7 = new JLabel();
        jButton5 = new JButton();
        jButton1 = new JButton();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Calculate Bill");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });
        getContentPane().setLayout(null);

        bil.setEditable(false);
        getContentPane().add(bil);
        bil.setBounds(720, 430, 150, 30);

        jLabel5.setText("Total Bill");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(630, 430, 80, 30);

        jTable1.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Category", "Clothing Style", "Price Per item", "Quantity", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(50, 110, 820, 300);

        jLabel6.setText("Bill No");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(70, 20, 70, 20);
        getContentPane().add(bn);
        bn.setBounds(140, 20, 120, 30);
        getContentPane().add(jLabel7);
        jLabel7.setBounds(590, 30, 260, 0);

        jButton5.setText("Print Bill");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(60, 430, 140, 40);

        jButton1.setText("Show Bill");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(280, 20, 130, 30);

        jLabel8.setText("Date");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(70, 60, 60, 30);

        jLabel9.setBorder(BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel9);
        jLabel9.setBounds(140, 60, 120, 30);

        setBounds(0, 0, 931, 513);
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
    }//GEN-LAST:event_formInternalFrameActivated

         private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         }//GEN-LAST:event_jButton5ActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    String c = "", p = "", price = "", qu = "";
    StringTokenizer ctkn, ptkn, prtkn, qtkn;
    DefaultTableModel tbl = (DefaultTableModel) jTable1.getModel();
    tbl.setRowCount(0);
    String path = "jdbc:mysql://localhost:3306/";
    String place = "project1";
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection myconnection = DriverManager.getConnection(path + place, "root", "");
        try {

            String q = "Select * from billing where bill_id=?";
            PreparedStatement ps = myconnection.prepareStatement(q);
            ps.setString(1, bn.getText());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                c = rs.getString(2);
                p = rs.getString(3);
                price = rs.getString(4);
                qu = rs.getString(5);
                bil.setText(rs.getString(6));
                jLabel9.setText(rs.getString(7));
            } else {
                bil.setText("");
                jLabel9.setText("");
                JOptionPane.showMessageDialog(rootPane, "No bill found!!!");
            }

            ps.close();
            myconnection.close();

        } catch (Exception e) {
            //System.out.println("Error in query"+e.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Error in query" + e.getMessage());
        }
    } catch (Exception e) {
        //System.out.println("Error on connnection"+e.getMessage());
        JOptionPane.showMessageDialog(rootPane, "Error in query" + e.getMessage());
    }

    ctkn = new StringTokenizer(c, ",");
    ptkn = new StringTokenizer(p, ",");
    prtkn = new StringTokenizer(price, ",");
    qtkn = new StringTokenizer(qu, ",");

    double prc;
    while (ctkn.hasMoreTokens()) {

        price = prtkn.nextToken();
        qu = qtkn.nextToken();

        prc = Double.parseDouble(price) * Double.parseDouble(qu);

        tbl.addRow(new Object[]{ctkn.nextToken(),
                    ptkn.nextToken(),
                    price,
                    qu, prc});
    }

}//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JTextField bil;
    private JTextField bn;
    private JButton jButton1;
    private JButton jButton5;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    // End of variables declaration//GEN-END:variables

    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }


        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());


        this.paint(g2d);
        this.repaint();

        return PAGE_EXISTS;


    }
}
