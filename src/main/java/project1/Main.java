package project1;

import java.sql.*;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println("Error occured in look and feel");

        }




        String path = "jdbc:mysql://localhost:3306/";
        String place = "project1";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection myconnection = DriverManager.getConnection(path + place, "root", "");
            try {
                String q = "select * from usertable";
                PreparedStatement mystatement = myconnection.prepareStatement(q);

                ResultSet myresult = mystatement.executeQuery();

                if (myresult.next()) {
                    login obj = new login();
                    obj.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "No admin found, Create Admin first");
                    createuser obj = new createuser();
                    obj.setVisible(true);
                }


                mystatement.close();
                myconnection.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error in query" + e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in query" + e.getMessage());
        }

    }
}
