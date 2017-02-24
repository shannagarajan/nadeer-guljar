/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * newstock.java
 *
 * Created on 28 Jun, 2013, 7:07:40 PM
 */
package project1;

import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class newstock extends javax.swing.JInternalFrame {

    /** Creates new form newstock */
    public newstock() {
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

        namebox1 = new javax.swing.JLabel();
        quantitybox1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        amountbox = new javax.swing.JTextField();
        quanbox = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        num = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Add new stock");
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

        namebox1.setText("Categary Name");
        getContentPane().add(namebox1);
        namebox1.setBounds(20, 70, 120, 30);

        quantitybox1.setText("Quantity");
        getContentPane().add(quantitybox1);
        quantitybox1.setBounds(20, 230, 120, 30);

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(220, 300, 150, 30);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select product" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(210, 70, 170, 30);

        jLabel3.setText("Price Per Item");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 180, 90, 30);

        jLabel2.setText("Type");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 120, 120, 30);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Product Type" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(210, 120, 170, 30);
        getContentPane().add(amountbox);
        amountbox.setBounds(210, 170, 170, 30);
        getContentPane().add(quanbox);
        quanbox.setBounds(210, 230, 170, 30);

        jLabel1.setText("Stock ID");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 30, 80, 14);

        num.setEditable(false);
        getContentPane().add(num);
        num.setBounds(210, 20, 170, 30);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(110, 380, 360, 140);

        setBounds(0, 0, 464, 418);
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
                    jComboBox1.addItem("No product added yet");
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
        empo2();


    }//GEN-LAST:event_formInternalFrameActivated
    int newid = 0;

    void empo2() {
        String path = "jdbc:mysql://localhost:3306/";
        String place = "project1";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection myconnection = DriverManager.getConnection(path + place, "root", "");
            try {
                String q = "select max(no) from newstock1";
                PreparedStatement mystatement = myconnection.prepareStatement(q);


                ResultSet myresult = mystatement.executeQuery();

                if (myresult.next()) {
                    int oldid = Integer.parseInt(myresult.getString(1));
                    newid = oldid + 1;
                    num.setText(String.valueOf(newid));
                }
            } catch (Exception e) {
                //System.out.println("Error in query"+e.getMessage());
                JOptionPane.showMessageDialog(rootPane, "Error in query" + e.getMessage());
            }
        } catch (Exception e) {
            //System.out.println("Error on connnection"+e.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Error in query" + e.getMessage());
        }
    }
    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed


        String path = "jdbc:mysql://localhost:3306/";
        String place = "project1";
        if (jComboBox2.getSelectedIndex() > 0) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection myconnection = DriverManager.getConnection(path + place, "root", "");
                try {
                    String q = "select * from newstock1 where namebox=? and stocknamebox=?";
                    PreparedStatement mystatement = myconnection.prepareStatement(q);
                    mystatement.setString(1, jComboBox1.getSelectedItem().toString());
                    mystatement.setString(2, jComboBox2.getSelectedItem().toString());


                    ResultSet myresult = mystatement.executeQuery();

                    if (myresult.next()) {
                        JOptionPane.showMessageDialog(rootPane, "All ready added to stock");
                        num.setText(myresult.getString("no"));
                        amountbox.setText(myresult.getString("amountbox"));
                        quanbox.setText(myresult.getString("quantitybox"));
                        jButton1.setEnabled(false);

                    } else {
                        num.setText(newid + "");
                        jButton1.setEnabled(true);
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

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String path = "jdbc:mysql://localhost:3306/";
        String place = "project1";

        amountbox.setText("");
        quanbox.setText("");
        jButton1.setEnabled(false);
        if (jComboBox1.getSelectedIndex() > 0) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection myconnection = DriverManager.getConnection(path + place, "root", "");
                try {
                    String q = "select producttype from addstock where comapnyname=?";
                    PreparedStatement mystatement = myconnection.prepareStatement(q);
                    mystatement.setString(1, jComboBox1.getSelectedItem().toString());


                    ResultSet myresult = mystatement.executeQuery();
                    jComboBox2.removeAllItems();
                    if (myresult.next()) {
                        jComboBox2.addItem("Choose product");
                        do {
                            jComboBox2.addItem(myresult.getString("producttype"));
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
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String path = "jdbc:mysql://localhost:3306/";
        String place = "project1";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection myconnection = DriverManager.getConnection(path + place, "root", "");
            try {
                String q = "insert into newstock1 values(?,?,?,?,?,?)";
                PreparedStatement mystatement = myconnection.prepareStatement(q);
                mystatement.setString(1, num.getText());
                mystatement.setString(2, jComboBox1.getSelectedItem().toString());
                mystatement.setString(3, jComboBox2.getSelectedItem().toString());
                mystatement.setString(4, amountbox.getText());
                mystatement.setString(5, quanbox.getText());

                java.util.Date obj = new java.util.Date();
                SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
                String dateofreg = myformat.format(obj);
                mystatement.setString(6, dateofreg);

                mystatement.execute();
                JOptionPane.showMessageDialog(rootPane, "saved successfully");
                mystatement.close();
                myconnection.close();
            } catch (Exception e) {
                //jLabel1.setText("Error in query"+e.getMessage());
                JOptionPane.showMessageDialog(rootPane, "Error in query" + e.getMessage());
            }
        } catch (Exception e) {
            //jLabel1.setText("Error on connnection"+e.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Error in query" + e.getMessage());

        }
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        amountbox.setText(null);
        quanbox.setText(null);
        empo2();

    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountbox;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel namebox1;
    private javax.swing.JTextField num;
    private javax.swing.JTextField quanbox;
    private javax.swing.JLabel quantitybox1;
    // End of variables declaration//GEN-END:variables
}
