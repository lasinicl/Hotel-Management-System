/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sealine.catering;

import javax.swing.JOptionPane;
import javax.swing.JOptionPane;
import DBConnect.DBConnect;
import DBConnect.DBConnect;
//
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.*;
import javax.swing.JOptionPane;
import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 *
 * @author charith ellawala
 */
public class ItemAdd extends javax.swing.JFrame {

    /**
     * Creates new form AddItem
     */
    public ItemAdd() {
        initComponents();
        setLabel();
        fillCombo();
        updateTable();
    }

    DBConnect connect=new DBConnect();
    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
     Statement st = null;
     
     
     private void clearForm(){
    
    lbl_menuid.setText("");
    txt_itemname.setText("");
    ibl_itemid.setText("");
     txt_price.setText("");
      
    }   
     
     private void updateTable(){
        try{
        String sql="select * from itemlist";
       
        connect.rs=connect.st.executeQuery(sql);
        tbl_itemlist.setModel(DbUtils.resultSetToTableModel(connect.rs));
        
        }catch(Exception ex){
        
        JOptionPane.showMessageDialog(null, ex);
        JOptionPane.showMessageDialog(null, "couldn't update");
        
        }
 }
    
      private void fillCombo(){
         try{
            
            Class.forName("com.mysql.jdbc.Driver");
            conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","");
            st=conn.createStatement();
//            JOptionPane.showConfirmDialog(null, "Connection Successfully Completed");
            System.out.println("Connection Successfully Completed");
    }catch (Exception ex){
        //System.out.println("Error :" +ex);
        JOptionPane.showMessageDialog(null,"couldn't connect to database");
        }
     
         try{
             String query="select menu_name from menu";
     
            pst=conn.prepareStatement(query);
     
           rs=pst.executeQuery();
           
        
             while(rs.next()){
                 String menu_name=rs.getString("menu_name");
               //  System.out.println(menu_name);
                 cmb_menuname.addItem(menu_name);
             }
             
         }
         catch(Exception ex){
             JOptionPane.showMessageDialog(null, "Exception 1 -> "+ex);
         }
         
     
     }
    
      private void setLabel() {

        try {

                String query="select * from itemlist";
                connect.rs = connect.st.executeQuery(query);
                int max=0;
                while(connect.rs.next()){
                String item_no=connect.rs.getString("itemid");
                int item_no_int=Integer.parseInt(item_no.substring(4,9));
                if(item_no_int>max){
                max=item_no_int;
                }else{
                max=max;
                }
                ibl_itemid.setText("item"+Integer.toString(max+1));
               //  String menuId="ORDR"+Integer.toString(max+1);
                
                }
                } catch (Exception ex) {
                        JOptionPane.showMessageDialog(rootPane,ex);
                        JOptionPane.showMessageDialog(null, "couldn't find order Number");

                }
    }
     
    
    private void addItem(){
        
        try{
            
            String query="insert into itemlist (menuname,menuID,itemid,itemList,itemprice) values('"+cmb_menuname.getSelectedItem()+"','"+lbl_menuid.getText()+"','"+ibl_itemid.getText()+"','"+txt_itemname.getText()+"','"+txt_price.getText()+"')";
        
            
       connect.st.executeUpdate(query);
        
        JOptionPane.showMessageDialog(null, "Record Successfully Added");
    //    JOptionPane.showMessageDialog(null, "please select the particular order to add payments");
        }catch(Exception ex){
        
         JOptionPane.showMessageDialog(rootPane, ex);
         }
        updateTable();
 }
    
      public void deleteItem(){
          try {
            int row = tbl_itemlist.getSelectedRow();
            String table_click = (tbl_itemlist.getModel().getValueAt(row, 2).toString());
            String sql = "delete from  itemlist where itemid='" + table_click + "'";
            connect.st.executeUpdate(sql);

            JOptionPane.showMessageDialog(null, "Selected item is deleted!!!");
        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(null, "Please Select a item from the table First");
        }
          updateTable();
    }
    
      private void tableRowClick(){
    
                    try{

                    int row=tbl_itemlist.getSelectedRow();
                    String table_click=(tbl_itemlist.getModel().getValueAt(row,2).toString());
                    String sql="select * from itemlist where itemid='"+table_click+"' ";
                  // System.out.println("hhfjdfj");

                     connect.rs=connect.st.executeQuery(sql);

                     if(connect.rs.next()){
                     System.out.println("hhfjdfj");
                     String item_id=connect.rs.getString("itemid");
                     ibl_itemid.setText(item_id);
                     String menu_Id=connect.rs.getString("menuID");
                     lbl_menuid.setText(menu_Id);
                     String item_name=connect.rs.getString("itemList");
                     txt_itemname.setText(item_name);
                     String itemprice=connect.rs.getString("itemprice");
                     txt_price.setText(itemprice);

                     }     
                    }catch(Exception ex){
                         JOptionPane.showMessageDialog(null, ex);
                           System.out.println(ex);
                       }

}
    
     private void deleteRow(){
    
        
     try {           
            int dialogButton = JOptionPane.YES_NO_OPTION;
               int dialogResult = JOptionPane.showConfirmDialog(this, "Do You Want To Delete This Record ?", "Delete Records", dialogButton);
                        if(dialogResult == 0) {
                            deleteItem();
                           //  clearForm();
            }
    
          }catch(Exception ex){
        JOptionPane.showMessageDialog(null, ex);           
        }
          
    }
     
      private void updateItem(){
        
        try{     
                
       String query="UPDATE itemlist "
               + "SET menuname='"+cmb_menuname.getSelectedItem()+"',menuID='"+lbl_menuid.getText()+"',itemList='"+txt_itemname.getText()+"',itemprice='"+txt_price.getText()+"' where itemid='"+ibl_itemid.getText()+"'";
        
       connect.st.executeUpdate(query);
        JOptionPane.showMessageDialog(null, "Record Successfully Updated");
        }catch(Exception ex){
        
         JOptionPane.showMessageDialog(null, ex);
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
        newItemAddPanel = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        lbl_menuid = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_itemname = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txt_price = new javax.swing.JTextField();
        cmb_menuname = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_itemlist = new javax.swing.JTable();
        ibl_itemid = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newItemAddPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        newItemAddPanel.setPreferredSize(new java.awt.Dimension(768, 620));
        newItemAddPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Menu");
        newItemAddPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 68, 32));

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        newItemAddPanel.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 545, 114, 32));

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        newItemAddPanel.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 545, 102, 32));

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setText("Update");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        newItemAddPanel.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(511, 545, 91, 32));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("menu ID");
        newItemAddPanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 68, 24));

        lbl_menuid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_menuid.setText("menu102");
        newItemAddPanel.add(lbl_menuid, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 90, 24));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Menu Item");
        newItemAddPanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 68, 29));
        newItemAddPanel.add(txt_itemname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 130, 29));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Price of the Item");
        newItemAddPanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 96, 26));
        newItemAddPanel.add(txt_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, 90, 26));

        cmb_menuname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmb_menuname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_menunameActionPerformed(evt);
            }
        });
        newItemAddPanel.add(cmb_menuname, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 90, 32));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tbl_itemlist.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_itemlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_itemlistMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_itemlist);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                .addContainerGap())
        );

        newItemAddPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, 510));

        ibl_itemid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ibl_itemid.setText("jLabel1");
        newItemAddPanel.add(ibl_itemid, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 90, 25));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText(" itemId");
        newItemAddPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 68, 25));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 508, Short.MAX_VALUE)
        );

        newItemAddPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 290, 510));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newItemAddPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newItemAddPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
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
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
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
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu5);

        jMenu7.setText("Items");
        jMenu7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuBar1.add(jMenu7);

        jMenu8.setText("Reports");
        jMenu8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuBar1.add(jMenu8);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        deleteRow();
        updateTable();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        addItem();
        clearForm();
        setLabel();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tbl_itemlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_itemlistMouseClicked
       tableRowClick();
    }//GEN-LAST:event_tbl_itemlistMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
            updateItem();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        MenuAdd item=new MenuAdd();
         item.setVisible(true);
          this.dispose();
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
         PaymentRecords pay=new PaymentRecords();
          pay.setVisible(true);
          this.dispose();
    }//GEN-LAST:event_jMenu5MouseClicked

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
       MenuSelection pay=new MenuSelection();
          pay.setVisible(true);
          this.dispose();
    }//GEN-LAST:event_jMenu4MouseClicked

    private void cmb_menunameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_menunameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_menunameActionPerformed

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
            java.util.logging.Logger.getLogger(ItemAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ItemAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ItemAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ItemAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ItemAdd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmb_menuname;
    private javax.swing.JLabel ibl_itemid;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbl_menuid;
    private javax.swing.JPanel newItemAddPanel;
    private javax.swing.JTable tbl_itemlist;
    private javax.swing.JTextField txt_itemname;
    private javax.swing.JTextField txt_price;
    // End of variables declaration//GEN-END:variables
}
