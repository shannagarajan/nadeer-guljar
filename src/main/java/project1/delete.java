/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * deletecomp.java
 *
 * Created on 4 Jul, 2013, 8:26:58 PM
 */
package project1;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Sony
 */
public class delete extends javax.swing.JInternalFrame {

    /** Creates new form deletecomp */
    public delete() {
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

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Delete Style");
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

        jLabel1.setText("Select Clothing Style");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 100, 140, 30);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choose Style" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(210, 100, 220, 30);

        jButton1.setText("Delete ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(250, 160, 150, 30);

        jLabel2.setText("Select Categary");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 40, 100, 30);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choose Category" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(210, 40, 220, 30);

        setBounds(0, 0, 518, 301);
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        String path = "jdbc:mysql://localhost:3306/";
        String place = "project1";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection myconnection = DriverManager.getConnection(path + place, "root", "");
            try {
                String q = "select * from addcomp";
                PreparedStatement mystatement = myconnection.prepareStatement(q);



                ResultSet myresult = mystatement.executeQuery();

                if (myresult.next()) {
                    do {
                        jComboBox2.addItem(myresult.getString("comapnyname"));
                    } while (myresult.next());

                } else {
                    jComboBox2.addItem("No product added yet");
                }


                mystatement.close();
                myconnection.close();
            } catch (Exception e) {
                //System.out.println("Error in query"+e.getMessage());
                JOptionPane.showMessageDialog(rootPane, "Error in query" + e.getMessage());
            }
        } catch (Exception e) {
            //System.out.println("Error on connnection"+e.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Error in query" + e.getMessage());
        }
    }//GEN-LAST:event_formInternalFrameActivated

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String path = "jdbc:mysql://localhost:3306/";
        String place = "project1";

        int n = JOptionPane.showConfirmDialog(rootPane, "Are you sure want to delete all record of " + jComboBox1.getSelectedItem() + " ?");
        if (n == 0) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection myconnection = DriverManager.getConnection(path + place, "root", "");
                try {
                    String q = "delete from addstock where producttype=?";
                    PreparedStatement mystatement = myconnection.prepareStatement(q);
                    mystatement.setString(1, jComboBox1.getSelectedItem().toString());


                    int b = mystatement.executeUpdate();

                    if (b > 0) {

                        JOptionPane.showMessageDialog(rootPane, "Deleted Successfully");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Already Deleted");
                    }


                    mystatement.close();
                    myconnection.close();
                } catch (Exception e) {
                    //System.out.println("Error in query"+e.getMessage());
                    JOptionPane.showMessageDialog(rootPane, "Error in query" + e.getMessage());
                }
            } catch (Exception e) {
                //System.out.println("Error on connnection"+e.getMessage());
                JOptionPane.showMessageDialog(rootPane, "Error in query" + e.getMessage());
            }
            jComboBox1.setSelectedIndex(0);
            jComboBox2.setSelectedIndex(0);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        String path = "jdbc:mysql://localhost:3306/";
        String place = "project1";
        if (jComboBox2.getSelectedIndex() != 0) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection myconnection = DriverManager.getConnection(path + place, "root", "");
                try {
                    String q = "select producttype from addstock where comapnyname=?";
                    PreparedStatement mystatement = myconnection.prepareStatement(q);
                    mystatement.setString(1, jComboBox2.getSelectedItem().toString());


                    ResultSet myresult = mystatement.executeQuery();
                    jComboBox1.removeAllItems();
                    if (myresult.next()) {
                        jComboBox1.addItem("Choose product");
                        do {
                            jComboBox1.addItem(myresult.getString("producttype"));
                        } while (myresult.next());
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "no producttype found");
                    }


                    mystatement.close();
                    myconnection.close();
                } catch (Exception e) {
                    //System.out.println("Error in query"+e.getMessage());
                    JOptionPane.showMessageDialog(rootPane, "Error in query" + e.getMessage());
                }
            } catch (Exception e) {
                //System.out.println("Error on connnection"+e.getMessage());
                JOptionPane.showMessageDialog(rootPane, "Error in query" + e.getMessage());
            }
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
