/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sudhir Kushwaha
 */
public class AddBook extends javax.swing.JFrame {

    /**
     * Creates new form AddBook
     */
    public AddBook() {
        initComponents();
    }
    public void clear(){
        txtid.setText("");
        txtname.setText("");
        txtauthor.setText("");
        txtpublisher.setText("");
        txtcategory.setText("");
       
    }
    
    public void createTable() {
    try (Connection c = Connect.connectToDB();
         PreparedStatement pst = c.prepareStatement(
            "CREATE TABLE IF NOT EXISTS `book` ("
            + "`id` VARCHAR(50) PRIMARY KEY,  "
            + "`name` VARCHAR(100), "
            + "`publisher` VARCHAR(50), "
            + "`author` VARCHAR(50), "
            + "`category` VARCHAR(50), "
            + "`status` VARCHAR(50), "
            + "`issue` VARCHAR(50), "
            + "`due` VARCHAR(50), "
            + "`studentid` VARCHAR(50))")) {
        pst.executeUpdate();
        System.out.println("Table created or already exists...");
    } catch (SQLException ex) {
        Logger.getLogger(StudentRegistration.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("Table creation error");
    }
}


    
    
    private boolean isValidInput() {
        String bookId = txtid.getText().trim();
        String bookName = txtname.getText().trim();
        String author = txtauthor.getText().trim();
        String publisher = txtpublisher.getText().trim();
        String category = txtcategory.getText().trim();

        // Validate Book ID (4-digit numeric string)
        if (bookId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Book ID is required.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            txtid.requestFocus();
            return false;
        } else if (!bookId.matches("\\d{4}")) {
            JOptionPane.showMessageDialog(this, "Book ID must be a 4-digit numeric value.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            txtid.requestFocus();
            return false;
        }

        // Validate Book Name
        if (bookName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Book Name is required.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            txtname.requestFocus();
            return false;
        }

        // Validate Author Name
        if (author.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Author Name is required.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            txtauthor.requestFocus();
            return false;
        }

        // Validate Publisher Name
        if (publisher.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Publisher Name is required.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            txtpublisher.requestFocus();
            return false;
        }

        // Validate Category
        if (category.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Category is required.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            txtcategory.requestFocus();
            return false;
        }

        return true;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtauthor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtcategory = new javax.swing.JTextField();
        txtpublisher = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close icon.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1088, 0, 50, 31));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Book ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 239, 46));

        txtauthor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(txtauthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 400, 320, 50));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Book Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 239, 46));

        jButton1.setBackground(new java.awt.Color(204, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(242, 242, 242));
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 670, 120, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Author");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 239, 46));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Publisher");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 239, 46));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Category");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 480, 239, 46));

        txtcategory.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(txtcategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 480, 320, 50));

        txtpublisher.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(txtpublisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 320, 50));

        txtid.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });
        getContentPane().add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, 320, 50));

        txtname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, 320, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/isue.jpg"))); // NOI18N
        jLabel1.setText("Add Book Details");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 230, 53));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/All Page Backgraound.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 1140, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!isValidInput()) {
        return;
    }
    createTable();
    String insertSQL = "INSERT INTO book (id, name, publisher, author, category, status) VALUES (?, ?, ?, ?, ?, ?)";
    try (Connection c = Connect.connectToDB(); 
         PreparedStatement pst = c.prepareStatement(insertSQL)) {
        pst.setString(1, txtid.getText().trim());
        pst.setString(2, txtname.getText().trim());
        pst.setString(3, txtpublisher.getText().trim());
        pst.setString(4, txtauthor.getText().trim());
        pst.setString(5, txtcategory.getText().trim());
        pst.setString(6, "NotIssued");

        pst.executeUpdate();
        JOptionPane.showMessageDialog(this, "Record Saved Successfully", 
                                      "Success", JOptionPane.INFORMATION_MESSAGE);
        clear();
    } catch (SQLException ex) {
        Logger.getLogger(AddBook.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Failed to save record: " + ex.getMessage(), 
                                      "Database Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

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
            java.util.logging.Logger.getLogger(AddBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtauthor;
    private javax.swing.JTextField txtcategory;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtpublisher;
    // End of variables declaration//GEN-END:variables
}
