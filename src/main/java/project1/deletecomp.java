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
public class deletecomp extends javax.swing.JInternalFrame {

    /** Creates new form deletecomp */
    public deletecomp() {
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

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Delete Categary");
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

        jLabel1.setText("Select product");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 40, 110, 50);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choose Categary" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(180, 50, 210, 30);

        jButton1.setText("Delete ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(200, 110, 150, 30);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(440, 190, 0, 240);

        setBounds(0, 0, 509, 258);
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
                        jComboBox1.addItem(myresult.getString("comapnyname"));
                    } while (myresult.next());

                } else {
                    jComboBox1.addItem("No Comapnies added yet");
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
                    String q = "delete from addcomp where comapnyname=?";
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
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
