/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sealine.catering;

import DBConnect.DBConnect;
//
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author charith ellawala
 */
public class PaymentRecords extends javax.swing.JFrame {

     DBConnect connect=new DBConnect();
    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    Statement st = null;
    /**
     * Creates new form AddItem
     */
    public PaymentRecords() {
         
        initComponents();
       
        updateTable();
        lbl_date.setText(now());
//        txt_menuprice.setText(MenuSelection.lbl_upprice.getText());
        
    }

     public static final String DATE_FORMAT_NOW = "yyyy-MM-dd";
    
   public static String now() {
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
    return sdf.format(cal.getTime());

  }
    
          private void updateTable(){
        try{
        String sql="select * from payment";
        connect.rs=connect.st.executeQuery(sql);
        table_payment.setModel(DbUtils.resultSetToTableModel(connect.rs));
        
        }catch(Exception ex){
        
        JOptionPane.showMessageDialog(null, ex);
        
        }
 }
    
     private void tableRowClick(){
    
     try{
     
        int row=table_payment.getSelectedRow();
        String table_click=(table_payment.getModel().getValueAt(row,0).toString());
        String sql="select * from payment where payment_id='"+table_click+"' ";
    
      
        connect.rs=connect.st.executeQuery(sql);
      
      if(connect.rs.next()){
      String pay_id=connect.rs.getString("payment_id");
      txt_payid.setText(pay_id);
   
      String date=connect.rs.getString("date");
      lbl_date.setText(date);
      String menuprice=connect.rs.getString("menu_price");
      txt_menuprice.setText(menuprice);
      String noplates=connect.rs.getString("no_of_plates");
      txt_plates.setText(noplates);
      String amount=connect.rs.getString("total_amount");
      txt_amount.setText(amount);
      String paidamount=connect.rs.getString("paid_amount");
      txt_paidamount.setText(paidamount);
      
      }     
     }catch(Exception ex){
          JOptionPane.showMessageDialog(null, ex);
        }
     
}
    
     private void totalCount(){
     
         Double menuprice=Double.parseDouble(txt_menuprice.getText());
         Double platesamount=Double.parseDouble(txt_plates.getText());
         
         Double total=menuprice*platesamount;
         
         txt_amount.setText(String.valueOf(total));
         
     
     }
     
      public void search_By_paymentno(){
    
        try { 
            String sql = "select * from payment where payment_id='" +txt_payid.getText()+ "'";
            connect.rs = connect.st.executeQuery(sql);
            table_payment.setModel(DbUtils.resultSetToTableModel(connect.rs));
            
//             String pay_No=connect.rs.getString("payment_no");
//      txt_paymentno.setText(pay_No);
      String menu_price=connect.rs.getString("menu_price");
      txt_menuprice.setText(menu_price);
      String no_plates=connect.rs.getString("no_of_plates");
      txt_plates.setText(no_plates);
     
      String date=connect.rs.getString("date");
      lbl_date.setText(date);
      String total=connect.rs.getString("total_amount");
      txt_amount.setText(total);
      String paidamount=connect.rs.getString("paid_amount");
      txt_paidamount.setText(paidamount);
      String pay_Type=connect.rs.getString("paid_type");
      txt_paidtype.setText(pay_Type);

        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, ex);
        }
    }
       
      private void updatePayments(){
        
        try{     
                
       String query="UPDATE payment "
               + "SET date='"+lbl_date.getText()+"',paid_amount='"+txt_paidamount.getText()+"',paid_type='"+txt_paidtype.getText()+"',no_of_plates='"+txt_plates.getText()+"',total_amount='"+txt_amount.getText()+"' where payment_id='"+txt_payid.getText()+"'";
        
       connect.st.executeUpdate(query);
        JOptionPane.showMessageDialog(null, "Record Successfully Updated");
        }catch(Exception ex){
        
         JOptionPane.showMessageDialog(null, ex);
         }
        updateTable();
 }
      
          public void deletePayments(){
          try {
            int row = table_payment.getSelectedRow();
            String table_click = (table_payment.getModel().getValueAt(row, 0).toString());
            String sql = "delete from  payment where payment_id='" + table_click + "'";
            connect.st.executeUpdate(sql);

            JOptionPane.showMessageDialog(null, "Selected order is deleted!!!");
        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(null, "Please Select an order from the table First");
        }
          updateTable();
    }
     
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        menuSelectionPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_paidamount = new javax.swing.JTextField();
        txt_plates = new javax.swing.JTextField();
        txt_amount = new javax.swing.JTextField();
        lbl_date = new javax.swing.JLabel();
        txt_menuprice = new javax.swing.JTextField();
        txt_payid = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txt_paidtype = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_payment = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuSelectionPanel.setPreferredSize(new java.awt.Dimension(768, 620));
        menuSelectionPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Price of the menu");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 100, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Payment ID");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 100, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("No Of Plates");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 90, 30));

        jLabel14.setText("Paid Type");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 90, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Paid amount");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 90, 20));

        txt_paidamount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(txt_paidamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, 110, 30));

        txt_plates.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(txt_plates, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 113, 33));

        txt_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_amountKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_amountKeyTyped(evt);
            }
        });
        jPanel2.add(txt_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 130, 30));
        jPanel2.add(lbl_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 30));

        txt_menuprice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(txt_menuprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 130, 30));

        txt_payid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(txt_payid, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 120, 30));

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 120, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Total");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 304, 110, 30));
        jPanel2.add(txt_paidtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 480, 120, 30));

        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 553, 100, 30));

        jButton2.setText("Delete");
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 553, 110, 30));

        menuSelectionPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 340, 610));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        table_payment.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        table_payment.setModel(new javax.swing.table.DefaultTableModel(
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
        table_payment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_paymentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_payment);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(123, Short.MAX_VALUE))
        );

        menuSelectionPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 420, 610));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addComponent(menuSelectionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuSelectionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(34, 34, 34))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 800, 660));

        jMenu3.setText("Menu");
        jMenu3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Menu Selection");
        jMenu4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        jMenu5.setText("Payments");
        jMenu5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuBar1.add(jMenu5);

        jMenu7.setText("Items");
        jMenu7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenu7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu7MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu7);

        jMenu8.setText("Reports");
        jMenu8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuBar1.add(jMenu8);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table_paymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_paymentMouseClicked
        tableRowClick();
    }//GEN-LAST:event_table_paymentMouseClicked

    private void txt_amountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_amountKeyTyped
       // totalCount();
    }//GEN-LAST:event_txt_amountKeyTyped

    private void txt_amountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_amountKeyReleased
        // TODO add your handling code here:
        totalCount();
    }//GEN-LAST:event_txt_amountKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        search_By_paymentno();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           updatePayments();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        MenuAdd mselection=new   MenuAdd();
         mselection.setVisible(true);
          this.dispose();
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
       MenuSelection mselection=new   MenuSelection();
         mselection.setVisible(true);
          this.dispose();
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenu7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu7MouseClicked
        ItemAdd mselection=new   ItemAdd();
         mselection.setVisible(true);
          this.dispose();
    }//GEN-LAST:event_jMenu7MouseClicked

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
            java.util.logging.Logger.getLogger(PaymentRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaymentRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaymentRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaymentRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaymentRecords().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JPanel menuSelectionPanel;
    private javax.swing.JTable table_payment;
    private javax.swing.JTextField txt_amount;
    private javax.swing.JTextField txt_menuprice;
    private javax.swing.JTextField txt_paidamount;
    private javax.swing.JTextField txt_paidtype;
    private javax.swing.JTextField txt_payid;
    private javax.swing.JTextField txt_plates;
    // End of variables declaration//GEN-END:variables
}
