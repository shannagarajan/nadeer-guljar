/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * createuser.java
 *
 * Created on 1 Jul, 2013, 2:19:47 PM
 */
package project1;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Sony
 */
public class createuser extends javax.swing.JFrame {

    /** Creates new form createuser */
    public createuser() {
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
        jLabel2 = new javax.swing.JLabel();
        userbox = new javax.swing.JTextField();
        passwordbox = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Create Admin");
        getContentPane().setLayout(null);

        jLabel1.setText("UserName");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(70, 60, 150, 30);

        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 110, 150, 30);
        getContentPane().add(userbox);
        userbox.setBounds(170, 60, 150, 30);
        getContentPane().add(passwordbox);
        passwordbox.setBounds(170, 110, 150, 30);

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(190, 170, 100, 30);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(240, 350, 130, 30);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(120, 300, 200, 0);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(520, 280, 0, 200);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-379)/2, (screenSize.height-326)/2, 379, 326);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String path = "jdbc:mysql://localhost:3306/";
        String place = "project1";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection myconnection = DriverManager.getConnection(path + place, "root", "admin786");
            try {
                String q = "insert into usertable values(?,?,?)";
                PreparedStatement mystatement = myconnection.prepareStatement(q);
                mystatement.setString(1, userbox.getText());
                mystatement.setString(2, passwordbox.getText());
                mystatement.setString(3, "Admin");
                mystatement.execute();
                jLabel5.setText("Saved successfully");
                mystatement.close();
                myconnection.close();

                ham1 obj = new ham1();
                obj.setVisible(true);
                this.dispose();
            } catch (Exception e) {
                //jLabel1.setText("Error in query"+e.getMessage());
                JOptionPane.showMessageDialog(rootPane, "Error in query" + e.getMessage());
            }
        } catch (Exception e) {
            //jLabel1.setText("Error on connnection"+e.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Error in query" + e.getMessage());

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new createuser().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField passwordbox;
    private javax.swing.JTextField userbox;
    // End of variables declaration//GEN-END:variables
}
